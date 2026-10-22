package com.bytedance.crypto.monitor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.monitor.proto.NormalTrace;
import com.bytedance.crypto.utils.LogUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public class NormalEvent {
    private static final long DELAY_TIME = 21600000;
    private static final String TAG = "NormalEvent";
    private static volatile NormalEvent normalEvent;
    private static final HashMap<String, NormalTrace> normalTraceMap = null;
    private final Object LOCK;
    private boolean isInit;
    private Handler mHandler;
    private Runnable mTimerTask;

    static {
        normalTraceMap = new HashMap();
    }

    public NormalEvent() {
        this.isInit = false;
        this.LOCK = new Object();
    }

    public static /* synthetic */ void a(String r100, NormalTrace r101) {
        lambda$executeTask$0(r100, r101);
    }

    public static /* synthetic */ void access$000(NormalEvent r100) {
        r100.executeTask();
    }

    public static /* synthetic */ Handler access$100(NormalEvent r100) {
        return r100.mHandler;
    }

    private void executeTask() {
        Object r100 = this.LOCK;
        monitor-enter(r100);
        HashMap<String, NormalTrace> r101 = normalTraceMap;     // Catch: Throwable -> L12
        if (r101.size() > 0) goto L9;
        LogUtils.i(TAG, "normalTraceMap is empty, no need to write event");     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L9:
        LogUtils.i(TAG, "NormalEvent executeTask, normalTraceMap size = " + r101.size());     // Catch: Throwable -> L12
        r101.forEach(new a());     // Catch: Throwable -> L12
        r101.clear();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static NormalEvent getInstance() {
        if (normalEvent != null) goto L15;
        monitor-enter(NormalEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (normalEvent != null) goto L9;
        normalEvent = new NormalEvent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NormalEvent.class);     // Catch: Throwable -> L11
    L15:
        return normalEvent;
    }

    private static /* synthetic */ void lambda$executeTask$0(String r100, NormalTrace r101) {
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addNormalTrace(r101));
    }

    public void eventRecord(int r110, int r210, String r211, String r212, long r213, long r214) {
        LogUtils.d(TAG, "eventRecord, module: " + r110 + ", event: " + r210 + ", pkgName: " + r211 + ", appid: " + r212 + ", timeConsumption: " + r213 + ", dataSize: " + r214);
        Object r100 = this.LOCK;
        monitor-enter(r100);
        String r111 = r110 + "_" + r210 + "_" + r211 + "_" + r212;     // Catch: Throwable -> L12
        HashMap<String, NormalTrace> r112 = normalTraceMap;     // Catch: Throwable -> L12
        NormalTrace r113 = r112.get(r111);     // Catch: Throwable -> L12
        if (r113 == null) goto L8;
        int r114 = r113.getTotalCalls() + 1;     // Catch: Throwable -> L12
        long r101 = r113.getTimeConsumption() + r213;     // Catch: Throwable -> L12
        NormalTrace.Builder r102 = NormalTrace.newBuilder().setModuleId(r110).setEventId(r210).setPackageName(r211).setAppId(r212).setUserid(0).setErrCode(0).setTotalCalls(r114).setTimeConsumption(r101).setTotalDataSize(r113.getTotalDataSize() + r214);     // Catch: Throwable -> L12
    L9:
        r112.put(r111, r102.build());     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L8:
        r102 = NormalTrace.newBuilder().setModuleId(r110).setEventId(r210).setPackageName(r211).setAppId(r212).setUserid(0).setErrCode(0).setTotalCalls(1).setTimeConsumption(r213).setTotalDataSize(r214);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void eventReport(int r100, int r101, String r102, String r103, long r104) {
        LogUtils.d(TAG, "eventReport, module: " + r100 + ", event: " + r101 + ", pkgName: " + r102 + ", appid: " + r103 + ", timeConsumption: " + r104);
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addNormalTrace(NormalTrace.newBuilder().setModuleId(r100).setEventId(r101).setPackageName(r102).setAppId(r103).setUserid(0).setErrCode(0).setTotalCalls(1).setTimeConsumption(r104).setTotalDataSize(0)));
    }

    public void init() {
        String r100 = TAG;
        LogUtils.d(r100, "init");
        if (this.isInit == false) goto L6;
        LogUtils.i(r100, "init already!");
        return;
    L6:
        this.mHandler = new Handler(Looper.getMainLooper());
        Runnable r101 = new AnonymousClass1(this);
        this.mTimerTask = r101;
        this.mHandler.postDelayed(r101, DELAY_TIME);
        this.isInit = true;
    }
}
