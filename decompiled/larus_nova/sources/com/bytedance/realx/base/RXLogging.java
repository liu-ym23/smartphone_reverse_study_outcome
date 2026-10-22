package com.bytedance.realx.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public class RXLogging {
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

        static {
            Severity r100 = new Severity("LS_DEBUG", 0);
            LS_DEBUG = r100;
            Severity r101 = new Severity("LS_TRACE", 1);
            LS_TRACE = r101;
            Severity r102 = new Severity("LS_INFO", 2);
            LS_INFO = r102;
            Severity r103 = new Severity("LS_WARNING", 3);
            LS_WARNING = r103;
            Severity r104 = new Severity("LS_ERROR", 4);
            LS_ERROR = r104;
            Severity r105 = new Severity("LS_NONE", 5);
            LS_NONE = r105;
            $VALUES = new Severity[]{r100, r101, r102, r103, r104, r105};
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

        static {
            TraceLevel r100 = new TraceLevel("TRACE_NONE", 0, 0);
            TRACE_NONE = r100;
            TraceLevel r101 = new TraceLevel("TRACE_STATEINFO", 1, 1);
            TRACE_STATEINFO = r101;
            TraceLevel r102 = new TraceLevel("TRACE_WARNING", 2, 2);
            TRACE_WARNING = r102;
            TraceLevel r103 = new TraceLevel("TRACE_ERROR", 3, 4);
            TRACE_ERROR = r103;
            TraceLevel r104 = new TraceLevel("TRACE_CRITICAL", 4, 8);
            TRACE_CRITICAL = r104;
            TraceLevel r110 = new TraceLevel("TRACE_APICALL", 5, 16);
            TRACE_APICALL = r110;
            TraceLevel r111 = new TraceLevel("TRACE_DEFAULT", 6, 255);
            TRACE_DEFAULT = r111;
            TraceLevel r112 = new TraceLevel("TRACE_MODULECALL", 7, 32);
            TRACE_MODULECALL = r112;
            TraceLevel r113 = new TraceLevel("TRACE_MEMORY", 8, 256);
            TRACE_MEMORY = r113;
            TraceLevel r105 = new TraceLevel("TRACE_TIMER", 9, 512);
            TRACE_TIMER = r105;
            TraceLevel r114 = new TraceLevel("TRACE_STREAM", 10, 1024);
            TRACE_STREAM = r114;
            TraceLevel r106 = new TraceLevel("TRACE_DEBUG", 11, 2048);
            TRACE_DEBUG = r106;
            TraceLevel r107 = new TraceLevel("TRACE_INFO", 12, 4096);
            TRACE_INFO = r107;
            TraceLevel r108 = new TraceLevel("TRACE_TERSEINFO", 13, 8192);
            TRACE_TERSEINFO = r108;
            TraceLevel r109 = new TraceLevel("TRACE_ALL", 14, 65535);
            TRACE_ALL = r109;
            $VALUES = new TraceLevel[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r114, r106, r107, r108, r109};
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

    public RXLogging() {
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
        monitor-enter(RXLogging.class);
        nativeEnableLogToDebugOutput(r100.ordinal());     // Catch: Throwable -> L7
        loggingEnabled = true;     // Catch: Throwable -> L7
        monitor-exit(RXLogging.class);
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
