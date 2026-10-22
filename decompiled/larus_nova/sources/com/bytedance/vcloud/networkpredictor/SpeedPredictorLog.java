package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "SpeedPredictorLog";

    public SpeedPredictorLog() {
    }

    public static void d(Throwable r100) {
        if (((LogTurnOn >> 1) & 1) != 1) goto L6;
        r100.printStackTrace();
        return;
    }

    public static final void d(String r100, String r101) {
        if (((LogTurnOn >> 1) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static void e(String r100, String r101) {
        if (((LogTurnOn >> 6) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static final void i(String r100, String r101) {
        if (((LogTurnOn >> 2) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static final void k(String r100, String r101) {
        if (((LogTurnOn >> 4) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static final void t(String r100, String r101) {
        if (((LogTurnOn >> 3) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static final void turnOn(int r100, int r101) {
        int r102 = ((~(1 << r100)) & LogTurnOn) | (r101 << r100);
        LogTurnOn = r102;
        if (r100 != 1) goto L7;
        if (r101 != 1) goto L8;
        LogTurnOn = (r102 & (-5)) | (r101 << 2);
        return;
    L8:
        return;
    }

    public static final void w(String r100, String r101) {
        if (((LogTurnOn >> 5) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }
}
