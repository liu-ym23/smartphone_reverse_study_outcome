package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorConfig {
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_DEFAULT = 3;
    public static final int LOG_LEVEL_ERROR = 4;
    public static final int LOG_LEVEL_FATAL = 5;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_VERBOSE = 0;
    public static final int LOG_LEVEL_WARN = 3;
    private static int sLogLevel = 3;

    public SpeedPredictorConfig() {
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static void setLoglevel(int r100) {
        sLogLevel = r100;
    }
}
