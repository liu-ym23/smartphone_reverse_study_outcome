package com.lynx.debugrouter.log;

import com.lynx.debugrouter.DebugRouter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class LLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int REPORT = 8;
    private static final String TAG = "DebugRouter_LLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static Integer currentId = null;
    private static final int sDefaultLogLevel = 6;
    private static int sHandlerId = -1;
    private static final ConcurrentHashMap<Integer, ILogDelegate> sHandlerMap = null;
    private static int[] sNativeLevelMap;
    private static int sNativeMinLogLevel;

    public LLog() {
    }

    private static native void nativeSetHasLoggingDelegate(boolean r100);

    private static native void nativeSetNativeMinLogLevel(int r100);

    static {
        sHandlerMap = new ConcurrentHashMap();
        currentId = 0;
        sNativeMinLogLevel = 6;
    }

    public static synchronized void addDebugLoggingDelegate() {
        monitor-enter(LLog.class);
        addLoggingDelegate(new AnonymousClass1());     // Catch: Throwable -> L7
        monitor-exit(LLog.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getMinimumLoggingLevel() {
        ILogDelegate r100 = sHandlerMap.get(Integer.valueOf(sHandlerId));
        if (r100 != null) goto L5;
        return 4;
    L5:
        return r100.getMinimumLoggingLevel();
    }

    private static void initNativeLogLevelMap() {
        if (sNativeLevelMap != null) goto L6;
        sNativeLevelMap = new int[]{0, 0, -1, 0, 0, 1, 2, 3, 5};
        return;
    }

    private static void resetMinLogLevel() {
        Iterator<Map.Entry<Integer, ILogDelegate>> r100 = sHandlerMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        ILogDelegate r101 = r100.next().getValue();
        int r102 = sNativeMinLogLevel;
        if (r102 == 6) goto L7;
        sNativeMinLogLevel = Math.min(r102, r101.getMinimumLoggingLevel());
        goto L4
    L7:
        sNativeMinLogLevel = r101.getMinimumLoggingLevel();
        goto L4
    L9:
        setMinimumLoggingLevel(sNativeMinLogLevel);
    }

    private static void ensureNativeLibraryLoaded() {
        if (DebugRouter.isNativeLibraryLoaded() == true) goto L6;
        DebugRouter.loadNativeLibrary();
        return;
    }

    public static synchronized int addLoggingDelegate(AbsLogDelegate r100) {
        monitor-enter(LLog.class);
        ensureNativeLibraryLoaded();     // Catch: Throwable -> L18
        if (r100 != null) goto L9;
        monitor-exit(LLog.class);
        return -1;
    L9:
        Integer r101 = Integer.valueOf(currentId.intValue() + 1);     // Catch: Throwable -> L18
        currentId = r101;     // Catch: Throwable -> L18
        if (r100.type() != 1) goto L15;
        int r102 = sHandlerId;     // Catch: Throwable -> L18
        if (r102 == (-1)) goto L14;
        sHandlerMap.remove(Integer.valueOf(r102));     // Catch: Throwable -> L18
    L14:
        sHandlerId = r101.intValue();     // Catch: Throwable -> L18
        resetMinLogLevel();     // Catch: Throwable -> L18
    L15:
        sHandlerMap.put(r101, r100);     // Catch: Throwable -> L18
        nativeSetHasLoggingDelegate(true);     // Catch: Throwable -> L18
        int r103 = r101.intValue();     // Catch: Throwable -> L18
        monitor-exit(LLog.class);
        return r103;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized void removeLoggingDelegate(int r100) {
        monitor-enter(LLog.class);
        sHandlerMap.remove(Integer.valueOf(r100));     // Catch: Throwable -> L7
        monitor-exit(LLog.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setMinimumLoggingLevel(int r100) {
        ensureNativeLibraryLoaded();
        if (sNativeMinLogLevel == r100) goto L9;
        sNativeMinLogLevel = r100;
    L9:
        initNativeLogLevelMap();     // Catch: Throwable -> L7
        nativeSetNativeMinLogLevel(sNativeLevelMap[r100]);     // Catch: Throwable -> L7
        return;
    L7:
        sNativeMinLogLevel = 6;
        nativeSetNativeMinLogLevel(sNativeLevelMap[6]);
    }

    public static void d(String r100, String r101) {
        internalLog(3, r100, r101);
    }

    public static void e(String r100, String r101) {
        internalLog(6, r100, r101);
    }

    public static void i(String r100, String r101) {
        internalLog(4, r100, r101);
    }

    public static void report(String r100, String r101) {
        internalLog(8, r100, r101);
    }

    public static void v(String r100, String r101) {
        internalLog(2, r100, r101);
    }

    public static void w(String r100, String r101) {
        internalLog(5, r100, r101);
    }

    public static void internalLog(int r100, String r101, String r102) {
        internalLog(r100, r101, r102, LogSource.JAVA);
    }

    private static void log(int r100, String r101, String r102) {
        if (r100 == 7) goto L11;
        internalLog(r100, r101, r102, LogSource.Native);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.getMessage();
        return;
    }

    public static void internalLog(int r100, String r101, String r102, LogSource r103) {
        Iterator<ILogDelegate> r104 = sHandlerMap.values().iterator();
    L4:
        if (r104.hasNext() == false) goto L27;
        ILogDelegate r105 = r104.next();
        if (r105.isLoggable(r100) == false) goto L4;
        if (r100 != 2) goto L11;
        r105.v(r101, r102);
        goto L4
    L11:
        if (r100 != 3) goto L13;
        r105.d(r101, r102);
        goto L4
    L13:
        if (r100 != 4) goto L15;
        r105.i(r101, r102);
        goto L4
    L15:
        if (r100 != 5) goto L17;
        r105.w(r101, r102);
        goto L4
    L17:
        if (r100 != 6) goto L19;
        r105.e(r101, r102);
        goto L4
    L19:
        if (r100 != 8) goto L4;
        r105.k(r101, r102);
        goto L4
    }
}
