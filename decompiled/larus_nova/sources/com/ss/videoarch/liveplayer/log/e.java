package com.ss.videoarch.liveplayer.log;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f459441a;

    static {
        f459441a = -1;
    }

    public static void d(String r100, String r101) {
    }

    public static void destory() {
        f459441a = -1;
    }

    public static void e(String r100, String r101) {
    }

    public static long getVolcBaseLogCallback() {
        return -1;
    }

    public static void i(String r100, String r101) {
    }

    private static void initLogSDK() {
    }

    public static boolean isVolcBaseLogExist() {
        return false;
    }

    public static long setLogLevel(VeLivePlayerLogConfig.VeLivePlayerLogLevel r100) {
        return -1;
    }

    public static void v(String r100, String r101) {
    }

    public static void w(String r100, String r101) {
    }

    public static void writeLog(int r100, String r101, String r102, int r103, String r104) {
    }

    private e() {
    }

    private static int getLogLevel(VeLivePlayerLogConfig.VeLivePlayerLogLevel r100) {
        if (r100 != VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelVerbose) goto L7;
        return 1;
    L7:
        if (r100 != VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelDebug) goto L10;
        return 2;
    L10:
        if (r100 != VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo) goto L14;
        return 3;
    L14:
        if (r100 != VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelWarn) goto L18;
        return 4;
    L18:
        if (r100 != VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelError) goto L22;
        return 5;
    L22:
        if (r100 != VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelNone) goto L25;
        return 6;
    L25:
        return 2;
    }

    public static void setLogConfig(VeLivePlayerLogConfig r100) {
        if (f459441a == (-1)) goto L6;
        if (r100 == null) goto L6;
        destory();
    L6:
        initLogSDK();
        c.i("VeLivePlayerLog", "setLogConfig:config=" + r100);
    }

    public static void writeLog(int r100, String r101, String r102) {
        writeLog(r100, r101, "", 0, r102);
    }
}
