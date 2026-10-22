package com.ss.mediakit.medialoader;

import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "AVMDLLog";
    public static int enableLogOptimization;

    @FunctionalInterface
    public interface LogMessageSupplier {
        String get();
    }

    public AVMDLLog() {
    }

    public static /* synthetic */ String a(String r100) {
        return lambda$track$4(r100);
    }

    public static /* synthetic */ String b(String r100) {
        return lambda$d$0(r100);
    }

    public static /* synthetic */ String c(String r100) {
        return lambda$w$1(r100);
    }

    public static /* synthetic */ String d(String r100) {
        return lambda$kill$5(r100);
    }

    public static /* synthetic */ String e(String r100) {
        return lambda$v$3(r100);
    }

    public static /* synthetic */ String f(String r100) {
        return lambda$e$2(r100);
    }

    private static /* synthetic */ String lambda$d$0(String r100) {
        return r100;
    }

    private static /* synthetic */ String lambda$e$2(String r100) {
        return r100;
    }

    private static /* synthetic */ String lambda$kill$5(String r100) {
        return r100;
    }

    private static /* synthetic */ String lambda$track$4(String r100) {
        return r100;
    }

    private static /* synthetic */ String lambda$v$3(String r100) {
        return r100;
    }

    private static /* synthetic */ String lambda$w$1(String r100) {
        return r100;
    }

    public static boolean isLogLevelEnabled(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 <= 6) goto L8;
        return false;
    L8:
        if (((LogTurnOn >> r100) & 1) != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public static void d(String r100, final String r101) {
        log(1, r100, new e(r101));
    }

    public static void e(String r100, final String r101) {
        log(6, r100, new b(r101));
    }

    public static void i(String r100, LogMessageSupplier r101) {
        log(2, r100, r101);
    }

    public static void kill(String r100, final String r101) {
        log(4, r100, new g(r101));
    }

    public static void track(String r100, final String r101) {
        log(3, r100, new d(r101));
    }

    public static final void turnOn(int r100, int r101) {
        int r102 = (~(1 << r100)) & LogTurnOn;
        LogTurnOn = (r101 << r100) | r102;
    }

    public static void v(String r100, final String r101) {
        log(0, r100, new f(r101));
    }

    public static void w(String r100, final String r101) {
        log(5, r100, new c(r101));
    }

    public static void d(String r100, LogMessageSupplier r101) {
        log(1, r100, r101);
    }

    public static void e(String r100, LogMessageSupplier r101) {
        log(6, r100, r101);
    }

    public static void kill(String r100, LogMessageSupplier r101) {
        log(4, r100, r101);
    }

    public static void track(String r100, LogMessageSupplier r101) {
        log(3, r100, r101);
    }

    public static void v(String r100, LogMessageSupplier r101) {
        log(0, r100, r101);
    }

    public static void w(String r100, LogMessageSupplier r101) {
        log(5, r100, r101);
    }

    private static void log(int r100, String r101, LogMessageSupplier r102) {
        int r103 = enableLogOptimization;
        if (r103 != 0) goto L6;
        String r104 = r102.get();
    L10:
        if (isLogLevelEnabled(r100) == false) goto L15;
        if (r104 != null) goto L13;
        r104 = r102.get();
    L13:
        printLog(r100, r101, r104);
        return;
    L15:
        return;
    L6:
        if (r103 != 2) goto L8;
        return;
    L8:
        r104 = null;
        goto L10
    }

    private static void printLog(int r100, String r101, String r102) {
        String.format(Locale.US, "<%s>%s", new Object[]{r101, r102});
        switch(r100) {
            case 0: goto L8;
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L9;
        };
    L8:
        return;
    L9:
        return;
    L10:
        return;
    }
}
