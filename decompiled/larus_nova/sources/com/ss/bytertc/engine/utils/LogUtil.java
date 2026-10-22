package com.ss.bytertc.engine.utils;

import android.content.Context;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes40.dex */
public class LogUtil {
    private static final String DEBUG_LEVEL = "DEBUG";
    public static final String DIR_TAIL = "logs";
    private static final String ERROR_LEVEL = "ERROR";
    private static final String INFO_LEVEL = "INFO";
    private static final String LOG_TAG = "ByteRTC";
    private static final String WARN_LEVEL = "WARNING";
    private static String sDeviceID;
    private static String sLogDir;
    private static LogLevel sLogLevel;
    private static AtomicReference<ILoggerSink> sLoggerSink;

    public interface ILoggerSink {
        void onLoggerMessage(LogLevel r100, String r101, Throwable r102);
    }

    public static final enum LogLevel extends Enum<LogLevel> {
        private static final /* synthetic */ LogLevel[] $VALUES = null;
        public static final LogLevel LOG_LEVEL_DEBUG = null;
        public static final LogLevel LOG_LEVEL_ERROR = null;
        public static final LogLevel LOG_LEVEL_INFO = null;
        public static final LogLevel LOG_LEVEL_TRACE = null;
        public static final LogLevel LOG_LEVEL_WARNING = null;

        static {
            LogLevel r100 = new LogLevel("LOG_LEVEL_TRACE", 0);
            LOG_LEVEL_TRACE = r100;
            LogLevel r101 = new LogLevel("LOG_LEVEL_DEBUG", 1);
            LOG_LEVEL_DEBUG = r101;
            LogLevel r102 = new LogLevel("LOG_LEVEL_INFO", 2);
            LOG_LEVEL_INFO = r102;
            LogLevel r103 = new LogLevel("LOG_LEVEL_WARNING", 3);
            LOG_LEVEL_WARNING = r103;
            LogLevel r104 = new LogLevel("LOG_LEVEL_ERROR", 4);
            LOG_LEVEL_ERROR = r104;
            $VALUES = new LogLevel[]{r100, r101, r102, r103, r104};
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }

        public static LogLevel valueOf(String r100) {
            return (LogLevel) r27.a.a(LogLevel.class, r100);
        }

        private LogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LogUtil() {
    }

    public static void setDebug(boolean r100) {
    }

    static {
        sLoggerSink = new AtomicReference();
        sDeviceID = null;
        sLogLevel = LogLevel.LOG_LEVEL_INFO;
        sLogDir = null;
    }

    private static ILoggerSink getLoggerSink() {
        return sLoggerSink.get();
    }

    public static String getDeviceID() {
        return sDeviceID;
    }

    public static LogLevel getLogLevel() {
        return sLogLevel;
    }

    public static String getLogDir(Context r100) {
        String r101 = sLogDir;
        if (r101 == null) goto L5;
        return r101;
    L5:
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.getExternalFilesDir(null));
        String r103 = File.separator;
        r102.append(r103);
        r102.append("RTCEngine");
        r102.append(r103);
        r102.append("Log");
        r102.append(r103);
        r102.append(DIR_TAIL);
        String r104 = r102.toString();
        sLogDir = r104;
        return r104;
    }

    public static void setDeviceID(String r100) {
        sDeviceID = r100;
    }

    public static void setLogDir(String r100) {
        sLogDir = r100 + File.separator + DIR_TAIL;
    }

    public static void setLogLevel(LogLevel r100) {
        sLogLevel = r100;
    }

    public static void setLoggerSink(ILoggerSink r100) {
        if (r100 == null) goto L4;
        sLoggerSink.set(r100);
        return;
    L4:
        AtomicReference<ILoggerSink> r101 = sLoggerSink;
        ILoggerSink r102 = getLoggerSink();
    L6:
        if (r101.compareAndSet(r102, null) == true) goto L14;
        if (r101.get() == r102) goto L6;
        return;
    }

    public static void d(String r100, String r101) {
        LogLevel r102 = LogLevel.LOG_LEVEL_DEBUG;
        if (r102.compareTo(sLogLevel) < 0) goto L6;
        notifyLoggerSinks(r102, String.format("[%s:%s]:%s", new Object[]{LOG_TAG, r100, String.format("[msg:%s]", new Object[]{r101})}), null);
        return;
    }

    public static void e(String r100, String r101) {
        LogLevel r102 = LogLevel.LOG_LEVEL_ERROR;
        if (r102.compareTo(sLogLevel) < 0) goto L6;
        notifyLoggerSinks(r102, String.format("[%s:%s]:%s", new Object[]{LOG_TAG, r100, String.format("[msg:%s]", new Object[]{r101})}), null);
        return;
    }

    public static void i(String r100, String r101) {
        LogLevel r102 = LogLevel.LOG_LEVEL_INFO;
        if (r102.compareTo(sLogLevel) < 0) goto L6;
        notifyLoggerSinks(r102, String.format("[%s:%s]:%s", new Object[]{LOG_TAG, r100, String.format("[msg:%s]", new Object[]{r101})}), null);
        return;
    }

    public static void w(String r100, String r101) {
        LogLevel r102 = LogLevel.LOG_LEVEL_WARNING;
        if (r102.compareTo(sLogLevel) < 0) goto L6;
        notifyLoggerSinks(r102, String.format("[%s:%s]:%s", new Object[]{LOG_TAG, r100, String.format("[msg:%s]", new Object[]{r101})}), null);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        LogLevel r103 = LogLevel.LOG_LEVEL_ERROR;
        if (r103.compareTo(sLogLevel) < 0) goto L6;
        notifyLoggerSinks(r103, String.format("[%s:%s]:%s", new Object[]{LOG_TAG, r100, String.format("[msg:%s]", new Object[]{r101})}), r102);
        return;
    }

    private static void notifyLoggerSinks(LogLevel r100, String r101, Throwable r102) {
        if (sLoggerSink == null) goto L8;
        ILoggerSink r103 = getLoggerSink();
        if (r103 == null) goto L9;
        r103.onLoggerMessage(r100, r101, r102);
        return;
    L9:
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        LogLevel r103 = LogLevel.LOG_LEVEL_WARNING;
        if (r103.compareTo(sLogLevel) < 0) goto L6;
        notifyLoggerSinks(r103, String.format("[%s:%s]:%s", new Object[]{LOG_TAG, r100, String.format("[msg:%s]", new Object[]{r101})}), r102);
        return;
    }
}
