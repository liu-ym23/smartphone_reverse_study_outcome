package com.bytedance.bmmt.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public class Logging {
    private static Severity loggableSeverity = null;
    private static volatile boolean loggingEnabled = true;

    public static final enum Severity extends Enum<Severity> {
        private static final /* synthetic */ Severity[] $VALUES = null;
        public static final Severity LS_DEBUG = null;
        public static final Severity LS_ERROR = null;
        public static final Severity LS_INFO = null;
        public static final Severity LS_NONE = null;
        public static final Severity LS_TRACE = null;
        public static final Severity LS_WARNING = null;

        private static /* synthetic */ Severity[] $values() {
            return new Severity[]{LS_DEBUG, LS_TRACE, LS_INFO, LS_WARNING, LS_ERROR, LS_NONE};
        }

        static {
            LS_DEBUG = new Severity("LS_DEBUG", 0);
            LS_TRACE = new Severity("LS_TRACE", 1);
            LS_INFO = new Severity("LS_INFO", 2);
            LS_WARNING = new Severity("LS_WARNING", 3);
            LS_ERROR = new Severity("LS_ERROR", 4);
            LS_NONE = new Severity("LS_NONE", 5);
            $VALUES = $values();
        }

        public static Severity[] values() {
            return (Severity[]) $VALUES.clone();
        }

        public static Severity valueOf(String r100) {
            return (Severity) a.a(Severity.class, r100);
        }

        private Severity(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TraceLevel extends Enum<TraceLevel> {
        private static final /* synthetic */ TraceLevel[] $VALUES = null;
        public static final TraceLevel TRACE_ALL = null;
        public static final TraceLevel TRACE_APICALL = null;
        public static final TraceLevel TRACE_CRITICAL = null;
        public static final TraceLevel TRACE_DEBUG = null;
        public static final TraceLevel TRACE_DEFAULT = null;
        public static final TraceLevel TRACE_ERROR = null;
        public static final TraceLevel TRACE_INFO = null;
        public static final TraceLevel TRACE_MEMORY = null;
        public static final TraceLevel TRACE_MODULECALL = null;
        public static final TraceLevel TRACE_NONE = null;
        public static final TraceLevel TRACE_STATEINFO = null;
        public static final TraceLevel TRACE_STREAM = null;
        public static final TraceLevel TRACE_TERSEINFO = null;
        public static final TraceLevel TRACE_TIMER = null;
        public static final TraceLevel TRACE_WARNING = null;
        public final int level;

        private static /* synthetic */ TraceLevel[] $values() {
            return new TraceLevel[]{TRACE_NONE, TRACE_STATEINFO, TRACE_WARNING, TRACE_ERROR, TRACE_CRITICAL, TRACE_APICALL, TRACE_DEFAULT, TRACE_MODULECALL, TRACE_MEMORY, TRACE_TIMER, TRACE_STREAM, TRACE_DEBUG, TRACE_INFO, TRACE_TERSEINFO, TRACE_ALL};
        }

        static {
            TRACE_NONE = new TraceLevel("TRACE_NONE", 0, 0);
            TRACE_STATEINFO = new TraceLevel("TRACE_STATEINFO", 1, 1);
            TRACE_WARNING = new TraceLevel("TRACE_WARNING", 2, 2);
            TRACE_ERROR = new TraceLevel("TRACE_ERROR", 3, 4);
            TRACE_CRITICAL = new TraceLevel("TRACE_CRITICAL", 4, 8);
            TRACE_APICALL = new TraceLevel("TRACE_APICALL", 5, 16);
            TRACE_DEFAULT = new TraceLevel("TRACE_DEFAULT", 6, 255);
            TRACE_MODULECALL = new TraceLevel("TRACE_MODULECALL", 7, 32);
            TRACE_MEMORY = new TraceLevel("TRACE_MEMORY", 8, 256);
            TRACE_TIMER = new TraceLevel("TRACE_TIMER", 9, 512);
            TRACE_STREAM = new TraceLevel("TRACE_STREAM", 10, 1024);
            TRACE_DEBUG = new TraceLevel("TRACE_DEBUG", 11, 2048);
            TRACE_INFO = new TraceLevel("TRACE_INFO", 12, 4096);
            TRACE_TERSEINFO = new TraceLevel("TRACE_TERSEINFO", 13, 8192);
            TRACE_ALL = new TraceLevel("TRACE_ALL", 14, 65535);
            $VALUES = $values();
        }

        public static TraceLevel[] values() {
            return (TraceLevel[]) $VALUES.clone();
        }

        public static TraceLevel valueOf(String r100) {
            return (TraceLevel) a.a(TraceLevel.class, r100);
        }

        private TraceLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.level = r102;
        }
    }

    public Logging() {
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int r100);

    private static native void nativeLog(int r100, String r101, String r102);

    public static void enableLogThreads() {
        nativeEnableLogThreads();
    }

    public static void enableLogTimeStamps() {
        nativeEnableLogTimeStamps();
    }

    public static synchronized void enableLogToDebugOutput(Severity r100) {
        monitor-enter(Logging.class);
        nativeEnableLogToDebugOutput(r100.ordinal());     // Catch: Throwable -> L7
        loggingEnabled = true;     // Catch: Throwable -> L7
        monitor-exit(Logging.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getStackTraceString(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }

    public static void d(String r100, String r101) {
        log(Severity.LS_DEBUG, r100, r101);
    }

    public static void e(String r100, String r101) {
        log(Severity.LS_ERROR, r100, r101);
    }

    public static void i(String r100, String r101) {
        log(Severity.LS_INFO, r100, r101);
    }

    public static void t(String r100, String r101) {
        log(Severity.LS_TRACE, r100, r101);
    }

    public static void w(String r100, String r101) {
        log(Severity.LS_WARNING, r100, r101);
    }

    public static void e(String r100, String r101, Throwable r102) {
        Severity r103 = Severity.LS_ERROR;
        log(r103, r100, r101);
        log(r103, r100, r102.toString());
        log(r103, r100, getStackTraceString(r102));
    }

    public static void log(Severity r100, String r101, String r102) {
        if (r101 == null) goto L9;
        if (r102 == null) goto L9;
        if (loggingEnabled == false) goto L10;
        nativeLog(r100.ordinal(), r101, r102);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Logging tag or message may not be null.");
    }

    public static void w(String r100, String r101, Throwable r102) {
        Severity r103 = Severity.LS_WARNING;
        log(r103, r100, r101);
        log(r103, r100, r102.toString());
        log(r103, r100, getStackTraceString(r102));
    }
}
