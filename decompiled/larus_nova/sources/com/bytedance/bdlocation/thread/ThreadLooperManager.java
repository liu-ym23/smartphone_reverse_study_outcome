package com.bytedance.bdlocation.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadLooperManager {
    private static final String BEACON_POLLING_WORKER = "BeaconPollingWorker";
    private static final String BEACON_TASK_WORKER = "BeaconTaskWorker";
    private static final String BLE_SCAN_WORKER = "BleScanWorker";
    private static final String BLE_TIMER_WORKER = "BleTimerWorker";
    private static final String CONFIG_WORKER = "ConfigWorker";
    private static final String LBS_LIGHT_LOCATION_WORKER = "LBSLightLocationWorker";
    private static final String LOCATION_WORKER = "LocationWorker";
    private static final String NETWORK_COLLECT_WORKER = "NetworkCollectWorker";
    private static final String POLL_UPLOAD_WORKER = "PollUploadWorker";
    private static final String SCHEDULER_WORKER = "SchedulerWorker";
    private static final String SENSOR_COLLECT_WORKER = "SensorCollectWorker";
    private static final String SHAKE_TASK_WORKER = "ShakeTaskWorker";
    private static HandlerThread sBeaconPollingWorker;
    private static HandlerThread sBeaconTaskWorker;
    private static HandlerThread sBleScanWorker;
    private static HandlerThread sBleTimerWorker;
    private static HandlerThread sConfigWorker;
    private static HandlerThread sLBSLightLocationWorker;
    private static HandlerThread sLocationWorker;
    private static HandlerThread sNetworkCollectWorker;
    private static HandlerThread sPollUploadWorker;
    private static HandlerThread sSchedulerWorker;
    private static HandlerThread sSensorCollectWorker;
    private static HandlerThread sShakeTaskWorker;
    private static Handler sWorkerHandler;

    public static synchronized Looper getBeaconPollingWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sBeaconPollingWorker != null) goto L7;
        sBeaconPollingWorker = getNewThread(BEACON_POLLING_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sBeaconPollingWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getBeaconTaskWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sBeaconTaskWorker != null) goto L7;
        sBeaconTaskWorker = getNewThread(BEACON_TASK_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sBeaconTaskWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getBleScanWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sBleScanWorker != null) goto L7;
        sBleScanWorker = getNewThread(BLE_SCAN_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sBleScanWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getBleTimerWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sBleTimerWorker != null) goto L7;
        sBleTimerWorker = getNewThread(BLE_TIMER_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sBleTimerWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getConfigWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sConfigWorker != null) goto L7;
        sConfigWorker = getNewThread(CONFIG_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sConfigWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getLBSLightLocationWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sLBSLightLocationWorker != null) goto L7;
        sLBSLightLocationWorker = getNewThread(LBS_LIGHT_LOCATION_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sLBSLightLocationWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getLocationWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sLocationWorker != null) goto L7;
        sLocationWorker = getNewThread(LOCATION_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sLocationWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getNetworkCollectWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sNetworkCollectWorker != null) goto L7;
        sNetworkCollectWorker = getNewThread(NETWORK_COLLECT_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sNetworkCollectWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getPollUploadWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sPollUploadWorker != null) goto L7;
        sPollUploadWorker = getNewThread(POLL_UPLOAD_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sPollUploadWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getSchedulerWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSchedulerWorker != null) goto L7;
        sSchedulerWorker = getNewThread(SCHEDULER_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sSchedulerWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getSensorCollectWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSensorCollectWorker != null) goto L7;
        sSensorCollectWorker = getNewThread(SENSOR_COLLECT_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sSensorCollectWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    public static synchronized Looper getShakeTaskWorker() {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sShakeTaskWorker != null) goto L7;
        sShakeTaskWorker = getNewThread(SHAKE_TASK_WORKER);     // Catch: Throwable -> L10
    L7:
        Looper r100 = sShakeTaskWorker.getLooper();     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
        return r100;
    }

    private ThreadLooperManager() {
    }

    private static HandlerThread getNewThread(String r100) {
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2(r100);
        ThreadMethodProxy.start(r101);
        return r101;
    }

    public static synchronized void postWorkRunner(Runnable r100) {
        monitor-enter(ThreadLooperManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sWorkerHandler != null) goto L7;
        sWorkerHandler = new Handler(getConfigWorker());     // Catch: Throwable -> L10
    L7:
        sWorkerHandler.post(r100);     // Catch: Throwable -> L10
        monitor-exit(ThreadLooperManager.class);
    }
}
