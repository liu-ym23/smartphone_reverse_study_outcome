package com.ss.videoarch.strategy.log.strategyMonitor;

/* JADX INFO: loaded from: classes38.dex */
public class BaseLogInfo {
    public static String REAL_SDK_APP_ID = "330361";
    public static final String SDK_NAME = "com.ss.videoarch.strategy:livestrategysdk";
    public static final String SDK_VERSION = "1.10.258.3";
    private static volatile BaseLogInfo sInstance;
    public long mSDKStartCostTime;

    public static BaseLogInfo inst() {
        if (sInstance != null) goto L15;
        monitor-enter(BaseLogInfo.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BaseLogInfo();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BaseLogInfo.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public BaseLogInfo() {
        this.mSDKStartCostTime = -1;
    }
}
