package com.bytedance.ttnet.priority;

import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.client.Request;
import hx5.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RequestDelayController {
    private static final int DEFAULT_RANDOM_SEND_LOWER_BOUNDS_MS = 500;
    private static final int DEFAULT_RANDOM_SEND_UPPER_BOUNDS_MS = 3000;
    private static final int DEFAULT_SPARSE_SEND_INTERVAL_MS = 100;
    private int mAsyncReqDelayMaxCount;
    private final Map<Runnable, Executor> mAsyncReqExecutorMap;
    private final Set<Request> mAsyncSet;
    private String mOwnerStateName;
    private int mRandomSendLowerBoundMs;
    private int mRandomSendUpperBoundMs;
    private final ReadWriteLock mReleaseEnqueueLock;
    private final Lock mReleaseEnqueueWriteLock;
    private final Condition mReleaseExecuteCondition;
    private final Lock mReleaseExecuteLock;
    private int mSparseSendIntervalMs;
    private int mSyncReqDelayMaxCount;
    private final Set<Request> mSyncSet;

    private int getP1RandomDelayTime() {
        int r100 = this.mRandomSendLowerBoundMs;
        if (r100 > 0) goto L6;
        r100 = 500;
    L6:
        int r101 = this.mRandomSendUpperBoundMs;
        if (r101 > 0) goto L10;
        r101 = 3000;
    L10:
        if (r100 < r101) goto L14;
        return 0;
    L14:
        return new Random().nextInt((r101 - r100) + 1) + r100;
    }

    private boolean useRandomOrSparse() {
        if (this.mSparseSendIntervalMs > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void releaseAllDelayedRequests() {
        this.mReleaseExecuteLock.lock();
        this.mReleaseExecuteCondition.signalAll();     // Catch: Throwable -> L19
        this.mReleaseExecuteLock.unlock();
        this.mReleaseEnqueueWriteLock.lock();
        Iterator<Map.Entry<Runnable, Executor>> r100 = this.mAsyncReqExecutorMap.entrySet().iterator();     // Catch: Throwable -> L16
        int r101 = 0;
    L6:
        if (r100.hasNext() == false) goto L14;
        Map.Entry<Runnable, Executor> r102 = r100.next();     // Catch: Throwable -> L16
        final Runnable r110 = r102.getKey();     // Catch: Throwable -> L16
        final Executor r111 = r102.getValue();     // Catch: Throwable -> L16
        if (useRandomOrSparse() == false) goto L11;
        r101 = getP1RandomDelayTime();     // Catch: Throwable -> L16
    L12:
        final long r103 = r101;
        final long r104 = 0;
        final int r112 = r101;
        b.a(NetworkAsyncTaskType.NETWORK).b(new AnonymousClass2(this, r103, r104, r110, r112, r111));     // Catch: Throwable -> L16
        goto L6
    L11:
        r101 = r101 + this.mSparseSendIntervalMs;     // Catch: Throwable -> L16
        goto L12
    L14:
        this.mReleaseEnqueueWriteLock.unlock();
        this.mAsyncSet.clear();
        this.mSyncSet.clear();
        return;
    L16:
        th = move-exception;
        this.mReleaseEnqueueWriteLock.unlock();
        throw th;
    L19:
        th = move-exception;
        this.mReleaseExecuteLock.unlock();
        throw th;
    }

    public RequestDelayController() {
        this.mOwnerStateName = null;
        this.mSyncSet = new CopyOnWriteArraySet();
        this.mSyncReqDelayMaxCount = -1;
        ReentrantLock r100 = new ReentrantLock();
        this.mReleaseExecuteLock = r100;
        this.mReleaseExecuteCondition = r100.newCondition();
        this.mAsyncSet = new CopyOnWriteArraySet();
        this.mAsyncReqDelayMaxCount = -1;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReleaseEnqueueLock = r101;
        this.mReleaseEnqueueWriteLock = r101.writeLock();
        this.mAsyncReqExecutorMap = new ConcurrentHashMap();
        this.mRandomSendLowerBoundMs = 500;
        this.mRandomSendUpperBoundMs = 3000;
        this.mSparseSendIntervalMs = 100;
    }

    public static /* synthetic */ Lock access$000(RequestDelayController r100) {
        return r100.mReleaseEnqueueWriteLock;
    }

    public static /* synthetic */ Map access$100(RequestDelayController r100) {
        return r100.mAsyncReqExecutorMap;
    }

    public void notifyRequestCompleted(Request r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mSyncSet.remove(r100);
        this.mAsyncSet.remove(r100);
    }

    public void setOwnerStateName(String r100) {
        this.mOwnerStateName = r100;
    }

    public void initWithTncConfig(JSONObject r100, String r101) {
        this.mSyncReqDelayMaxCount = r100.optInt("sync_req_delay_max_count", -1);
        this.mAsyncReqDelayMaxCount = r100.optInt("async_req_delay_max_count", -1);
        this.mRandomSendLowerBoundMs = r100.optInt("random_send_lbound_ms", 500);
        this.mRandomSendUpperBoundMs = r100.optInt("random_send_ubound_ms", 3000);
        this.mSparseSendIntervalMs = r100.optInt("sparse_send_interval_ms", 100);
        setOwnerStateName(r101);
    }

    public void initWithLocal(int r100, int r101, int r102) {
        this.mSyncReqDelayMaxCount = r100;
        this.mAsyncReqDelayMaxCount = r101;
        this.mSparseSendIntervalMs = r102;
    }

    public void requestBlockingDelay(Request r110, boolean r111, boolean r112, long r113) {
        if (r113 > 0) goto L5;
        return;
    L5:
        if (r111 == false) goto L7;
    L9:
        long r100 = SystemClock.uptimeMillis();
        this.mSyncSet.add(r110);
        r110.getMetrics().syncDelayCount = this.mSyncSet.size();
        r110.getMetrics().delayStateName = this.mOwnerStateName;
        r110.getMetrics().delayedWithState = true;
        if (Logger.debug() == false) goto L12;
        Logger.d("RequestDelay", "Delay request before await");
    L12:
        this.mReleaseExecuteLock.lock();
        this.mReleaseExecuteCondition.await(r113, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L27 Exception -> L29
        this.mReleaseExecuteLock.unlock();
        int r114 = getP1RandomDelayTime();
        if (Logger.debug() == false) goto L17;
        Logger.d("RequestDelay", "Delay request :" + r110.getPath() + " time:" + r114 + " start random now");
    L17:
        if (r114 > 0) goto L58;
    L22:
        long r115 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L26;
        StringBuilder r116 = new StringBuilder("Delay request end random ");
    L25:
        r116.append(r114);
        r116.append(" delay all ");
        r116.append(r115 - r100);
        Logger.d("RequestDelay", r116.toString());
    L26:
        r110.getMetrics().randomSendTime = r114;
        r110.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - r100;
        return;
    L58:
        Thread.sleep(r114);     // Catch: InterruptedException -> L21
    L21:
        Logger.e("sleeping interrupted");
        goto L22
    L29:
        e = move-exception;
        if (Logger.debug() == false) goto L33;
        Logger.d("RequestDelay", "Delay request await interrupted " + e.getMessage());     // Catch: Throwable -> L27
    L33:
        this.mReleaseExecuteLock.unlock();
        r114 = getP1RandomDelayTime();
        if (Logger.debug() == false) goto L36;
        Logger.d("RequestDelay", "Delay request :" + r110.getPath() + " time:" + r114 + " start random now");
    L36:
        if (r114 > 0) goto L65;
    L41:
        r115 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L26;
        r116 = new StringBuilder("Delay request end random ");
        goto L25
    L65:
        Thread.sleep(r114);     // Catch: InterruptedException -> L40
    L40:
        Logger.e("sleeping interrupted");
    L27:
        th = move-exception;
        this.mReleaseExecuteLock.unlock();
        int r117 = getP1RandomDelayTime();
        if (Logger.debug() == false) goto L48;
        Logger.d("RequestDelay", "Delay request :" + r110.getPath() + " time:" + r117 + " start random now");
    L48:
        if (r117 > 0) goto L62;
    L53:
        long r101 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L56;
        Logger.d("RequestDelay", "Delay request end random " + r117 + " delay all " + (r101 - r100));
    L56:
        r110.getMetrics().randomSendTime = r117;
        r110.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - r100;
        throw th;
    L62:
        Thread.sleep(r117);     // Catch: InterruptedException -> L52
    L52:
        Logger.e("sleeping interrupted");
        goto L53
    L7:
        if (this.mSyncSet.size() < this.mSyncReqDelayMaxCount) goto L9;
    }

    public boolean requestAsyncDelay(final Request r110, boolean r111, final long r112, final Runnable r113, final Executor r114) {
        if (r112 > 0) goto L5;
        return false;
    L5:
        if (r111 == false) goto L7;
    L9:
        this.mAsyncReqExecutorMap.put(r113, r114);
        this.mAsyncSet.add(r110);
        r110.getMetrics().delayStartTimeStamp = SystemClock.uptimeMillis();
        r110.getMetrics().delayStateName = this.mOwnerStateName;
        r110.getMetrics().asyncDelayCount = this.mAsyncSet.size();
        r110.getMetrics().delayedWithState = true;
        final long r100 = 0;
        b.a(NetworkAsyncTaskType.NETWORK).b(new AnonymousClass1(this, r112, r100, r113, r114, r110));
        return true;
    L7:
        if (this.mAsyncSet.size() < this.mAsyncReqDelayMaxCount) goto L9;
        return false;
    }
}
