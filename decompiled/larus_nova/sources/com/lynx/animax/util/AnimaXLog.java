package com.lynx.animax.util;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXLog {

    public static final enum LogLevel extends Enum<LogLevel> {
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel VERBOSE = null;
        public static final LogLevel WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogLevel[] f380467a = null;

        static {
            LogLevel r100 = new LogLevel("VERBOSE", 0);
            VERBOSE = r100;
            LogLevel r101 = new LogLevel("DEBUG", 1);
            DEBUG = r101;
            LogLevel r102 = new LogLevel("INFO", 2);
            INFO = r102;
            LogLevel r103 = new LogLevel("WARN", 3);
            WARN = r103;
            LogLevel r104 = new LogLevel("ERROR", 4);
            ERROR = r104;
            f380467a = new LogLevel[]{r100, r101, r102, r103, r104};
        }

        public static LogLevel[] values() {
            return (LogLevel[]) f380467a.clone();
        }

        public static LogLevel valueOf(String r100) {
            return (LogLevel) a.a(LogLevel.class, r100);
        }

        public LogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AnimaXLog() {
    }

    private static native void nativeLog(int r100, String r101, String r102);

    public static void a(String r100, String r101) {
        c(LogLevel.ERROR, r100, r101);
    }

    public static void b(String r100, String r101) {
        c(LogLevel.INFO, r100, r101);
    }

    public static void d(String r100, String r101) {
        c(LogLevel.WARN, r100, r101);
    }

    public static void c(LogLevel r100, String r101, String r102) {
        if (AnimaX.e().f380464a == false) goto L6;
        nativeLog(r100.ordinal(), r101, r102);
        return;
    }
}
