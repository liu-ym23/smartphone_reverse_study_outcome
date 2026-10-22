package com.ss.videoarch.strategy.utils;

/* JADX INFO: loaded from: classes38.dex */
public class VeLSUtils {
    static final String TAG = "VeLSUtils";
    private static boolean mLoadSoSuccess;

    public VeLSUtils() {
    }

    public static boolean isLoadSoSuccess() {
        monitor-enter(VeLSUtils.class);
        boolean r100 = mLoadSoSuccess;     // Catch: Throwable -> L7
        monitor-exit(VeLSUtils.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setLoadSoSuccess(boolean r100) {
        monitor-enter(VeLSUtils.class);
        mLoadSoSuccess = r100;     // Catch: Throwable -> L7
        monitor-exit(VeLSUtils.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
