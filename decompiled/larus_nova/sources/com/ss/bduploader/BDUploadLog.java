package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_PRINT_BOTH = 3;
    public static final int LOG_PRINT_CALL_BACK = 2;
    public static final int LOG_PRINT_LOCAL = 1;
    public static final int LOG_PRINT_NONE = 0;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "BDUploadLog";
    private static ALogCallback sALogCallback;

    public interface ALogCallback {
        void onLogPrint(int r100, String r101, String r102);
    }

    public BDUploadLog() {
    }

    private static native void _setLogPrintType(int r100);

    public static void setALogCallback(ALogCallback r100) {
        sALogCallback = r100;
    }

    public static void setLogPrintType(int r100) {
        BDUploadUtil.initInternal(new StringBuffer());
        _setLogPrintType(r100);
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
        int r102 = (~(1 << r100)) & LogTurnOn;
        LogTurnOn = (r101 << r100) | r102;
    }

    public static final void w(String r100, String r101) {
        if (((LogTurnOn >> 5) & 1) != 1) goto L6;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    private static void onALogCallback(int r100, String r101, String r102) {
        ALogCallback r103 = sALogCallback;
        if (r103 == null) goto L6;
        r103.onLogPrint(r100, r101, r102);
        return;
    }
}
