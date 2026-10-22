package com.samsung.sdk.sperf;

import android.os.Process;

/* JADX INFO: loaded from: classes34.dex */
public class PerformanceManager {
    protected static final int PRESET_END = 256;
    protected static final int PRESET_START = 64;
    public static final int PRESET_TYPE_BUS = 256;
    public static final int PRESET_TYPE_CPU = 64;
    public static final int PRESET_TYPE_GPU = 128;
    private static PerformanceManager mPerformanceManager = null;
    private static int myPid = -1;
    private static SPerfManager sPerfManager;

    private PerformanceManager() {
    }

    public static PerformanceManager getInstance() {
        monitor-enter(PerformanceManager.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (mPerformanceManager != null) goto L7;
        mPerformanceManager = new PerformanceManager();     // Catch: Throwable -> L14
    L7:
        PerformanceManager r100 = null;
        SPerfManager r101 = SPerfManager.createInstance(null);     // Catch: Throwable -> L14
        sPerfManager = r101;     // Catch: Throwable -> L14
        if (r101 == null) goto L10;
        r100 = mPerformanceManager;     // Catch: Throwable -> L14
    L10:
        monitor-exit(PerformanceManager.class);
        return r100;
    }

    public static int getPid() {
        if (myPid >= 0) goto L6;
        myPid = Process.myPid();
    L6:
        return myPid;
    }

    public int start(int r100, int r101) {
        SPerfManager r102 = sPerfManager;
        if (r102 != null) goto L7;
        SPerfUtil.log("SPerf has not initialized");
        return -1;
    L7:
        return r102.startPresetBoost(r100, r101);
    }

    public int start(CustomParams r100) {
        if (sPerfManager != null) goto L7;
        String r101 = "SPerf has not initialized";
    L5:
        SPerfUtil.log(r101);
        return -1;
    L7:
        if (r100 != null) goto L9;
        r101 = "CustomParams is null";
        goto L5
    L9:
        BoostObject r102 = r100.getBoostObject();
        if (r102 != null) goto L13;
        r101 = "CustomParams is not initialized";
        goto L5
    L13:
        return sPerfManager.startBoost(r102);
    }

    public int stop() {
        SPerfManager r100 = sPerfManager;
        if (r100 != null) goto L7;
        SPerfUtil.log("SPerf has not initialized");
        return -1;
    L7:
        return r100.stopBoost();
    }
}
