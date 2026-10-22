package com.bytedance.common.wschannel.utils;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class WsAsyncIOTaskManager {
    private static final String TAG = null;
    private static WsAsyncIOTaskManager sInstance;
    private ConcurrentHashMap<WsAsyncTask, ScheduledFuture> mFutureTasks;
    private ConcurrentHashMap<WsAsyncTask, Runnable> mRunnableTasks;
    private ScheduledThreadPoolExecutor mTaskExecutor;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class InnerRunnable implements Runnable {
        private WsAsyncTask task;
        final /* synthetic */ WsAsyncIOTaskManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_common_wschannel_utils_WsAsyncIOTaskManager$InnerRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_common_wschannel_utils_WsAsyncIOTaskManager$InnerRunnable__run$___twin___() {
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L9
            this.task.run();     // Catch: Throwable -> L9
            if (Logger.debug() == false) goto L7;
            Logger.d(WsAsyncIOTaskManager.access$100(), "Task execute time: " + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L9
        L7:
            if (this.task.isLoop() == true) goto L14;
        L8:
            WsAsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            WsAsyncIOTaskManager.access$300(this.this$0).remove(this.task);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            Logger.e(WsAsyncIOTaskManager.access$100(), "thread " + ThreadMethodProxy.currentThread().getName() + " exception", th);     // Catch: Throwable -> L15
            if (this.task.isLoop() == false) goto L8;
            return;
        L15:
            th = move-exception;
            if (this.task.isLoop() == true) goto L19;
            WsAsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            WsAsyncIOTaskManager.access$300(this.this$0).remove(this.task);
        L19:
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_common_wschannel_utils_WsAsyncIOTaskManager$InnerRunnable_com_larus_apm_impl_protector_RunnableLancet_run(InnerRunnable r100) {
            r100.com_bytedance_common_wschannel_utils_WsAsyncIOTaskManager$InnerRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private InnerRunnable(WsAsyncIOTaskManager r100, WsAsyncTask r101) {
            this.this$0 = r100;
            this.task = r101;
        }

        public /* synthetic */ InnerRunnable(WsAsyncIOTaskManager r100, WsAsyncTask r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    static {
        TAG = "WsAsyncIOTaskManager";
    }

    public static WsAsyncIOTaskManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(WsAsyncIOTaskManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new WsAsyncIOTaskManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(WsAsyncIOTaskManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private WsAsyncIOTaskManager() {
        this.mFutureTasks = new ConcurrentHashMap();
        this.mRunnableTasks = new ConcurrentHashMap();
        this.mTaskExecutor = new PThreadScheduledThreadPoolExecutor(1, new WsThreadFactory("frontier"));
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ConcurrentHashMap access$200(WsAsyncIOTaskManager r100) {
        return r100.mFutureTasks;
    }

    public static /* synthetic */ ConcurrentHashMap access$300(WsAsyncIOTaskManager r100) {
        return r100.mRunnableTasks;
    }

    public void postTask(WsAsyncTask r100) {
        if (r100 != null) goto L13;
        return;
    L13:
        InnerRunnable r101 = new InnerRunnable(this, r100, null);     // Catch: Throwable -> L10
        if (r100.isLoop() == false) goto L7;
        ScheduledFuture<?> r102 = this.mTaskExecutor.scheduleWithFixedDelay(r101, r100.getInitialDelay(), r100.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.mRunnableTasks.put(r100, r101);     // Catch: Throwable -> L10
        this.mFutureTasks.put(r100, r102);     // Catch: Throwable -> L10
        return;
    L7:
        r102 = this.mTaskExecutor.schedule(r101, r100.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(TAG, "sendTask failed.", th);
    }
}
