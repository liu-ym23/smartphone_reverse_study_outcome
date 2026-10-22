package com.lynx.base.log;

import com.lynx.base.LynxBaseEnv;
import com.lynx.tasm.service.ILynxLogService;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public class LynxLog {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int INFO = 2;
    private static final String TAG = "LynxLog";
    public static final int VERBOSE = 0;
    public static final int WARN = 3;
    private static int sALogMinLogLevel = 2;
    private static AbsBaseLogDelegate sDebugLoggingDelegate = null;
    private static final int sDetectALogDependencyInterval = 500;
    private static boolean sIsJSLogsFromExternalChannelsOpen = false;
    private static boolean sIsNativeLibLoad = false;
    private static final int sMaxTryCounts = 120;
    private static int sTryCounts;
    private static ILynxLogService service;

    public LynxLog() {
    }

    public static void DCHECK(boolean r100) {
    }

    public static void DTHROW() {
        DTHROW(null);
    }

    public static void DTHROW(RuntimeException r100) {
    }

    private static void logByAndroidUtil(int r100, String r101, String r102) {
    }

    private static native void nativeInitALogNative(long r100);

    private static native void nativeInitLynxLoggingNative(boolean r100);

    private static native void nativeInternalLog(int r100, String r101, String r102);

    private static native void nativeSetLogOutputByPlatform();

    private static native void nativeSetNativeMinLogLevel(int r100);

    private static void setLogOutputChannel() {
        ILynxLogService r100 = service;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isLogOutputByPlatform() == false) goto L9;
        nativeSetLogOutputByPlatform();
        return;
    }

    public static /* synthetic */ boolean access$000() {
        return detectALogDependence();
    }

    private static void asyncInitLynxNativeLog() {
        if (detectALogDependence() == false) goto L5;
        return;
    L5:
        final PthreadTimer r100 = new PthreadTimer("e/log/LynxLog");
        r100.schedule(new AnonymousClass1(r100), 0, 500);
    }

    private static boolean detectALogDependence() {
        ILynxLogService r100 = (ILynxLogService) n.c().a(ILynxLogService.class);
        service = r100;
        if (r100 == null) goto L5;
        long r101 = r100.getDefaultWriteFunction();
    L7:
        if (r101 == 0) goto L10;
        nativeInitALogNative(r101);
        return true;
    L10:
        int r102 = sTryCounts + 1;
        sTryCounts = r102;
        if (r102 < 120) goto L13;
        return true;
    L13:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public static int getMinimumLoggingLevel() {
        return sALogMinLogLevel;
    }

    public static void initLynxLog(boolean r100) {
    L9:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (sIsNativeLibLoad == true) goto L6;
        sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();     // Catch: ArrayIndexOutOfBoundsException -> L9
    L6:
        if (sIsNativeLibLoad == false) goto L14;
        initLynxLogging(r100);     // Catch: ArrayIndexOutOfBoundsException -> L9
        return;
    }

    private static void initLynxLogging(boolean r100) {
        nativeInitLynxLoggingNative(r100);
        asyncInitLynxNativeLog();
        setLogOutputChannel();
    }

    public static void setDebugLoggingDelegate(AbsBaseLogDelegate r100) {
        sDebugLoggingDelegate = r100;
    }

    public static void setJSLogsFromExternalChannels(boolean r100) {
        sIsJSLogsFromExternalChannelsOpen = r100;
    }

    public static void setMinimumLoggingLevel(int r100) {
    L12:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (sIsNativeLibLoad == true) goto L6;
        sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();     // Catch: ArrayIndexOutOfBoundsException -> L12
    L6:
        if (sIsNativeLibLoad == false) goto L16;
        String[] r101 = {"VERBOSE", "DEBUG", "INFO", "WARN", "ERROR"};     // Catch: ArrayIndexOutOfBoundsException -> L12
        int r102 = sALogMinLogLevel;     // Catch: ArrayIndexOutOfBoundsException -> L12
        if (r102 >= r100) goto L10;
        sALogMinLogLevel = r100;     // Catch: ArrayIndexOutOfBoundsException -> L12
        nativeSetNativeMinLogLevel(r100);     // Catch: ArrayIndexOutOfBoundsException -> L12
        String.format("Reset minimum log level as %s", new Object[]{r101[sALogMinLogLevel]});     // Catch: ArrayIndexOutOfBoundsException -> L12
        return;
    L10:
        String.format("Please set a log level higher than %s to filter lynx logs!", new Object[]{r101[r102]});     // Catch: ArrayIndexOutOfBoundsException -> L12
        return;
    }

    public static void d(String r100, String r101) {
        internalLog(1, r100, r101);
    }

    public static void e(String r100, String r101) {
        internalLog(4, r100, r101);
    }

    public static void i(String r100, String r101) {
        internalLog(2, r100, r101);
    }

    public static void v(String r100, String r101) {
        internalLog(0, r100, r101);
    }

    public static void w(String r100, String r101) {
        internalLog(3, r100, r101);
    }

    public static void internalLog(int r100, String r101, String r102) {
        if (r102 == null) goto L25;
        if (r101 == null) goto L28;
        logByDebugLoggingDelegate(r100, r101, r102);
    L21:
        e = move-exception;
        e.getMessage();
        return;
    L7:
        if (sIsNativeLibLoad == true) goto L13;
        boolean r103 = LynxBaseEnv.inst().isNativeLibraryLoaded();     // Catch: UnsatisfiedLinkError -> L21
        sIsNativeLibLoad = r103;     // Catch: UnsatisfiedLinkError -> L21
        if (r103 == true) goto L13;
        logByAndroidUtil(r100, r101, r102);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L13:
        if (r100 < sALogMinLogLevel) goto L26;
        ILynxLogService r104 = service;     // Catch: UnsatisfiedLinkError -> L21
        if (r104 != null) goto L17;
    L19:
        nativeInternalLog(r100, r101, r102);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L17:
        if (r104.isLogOutputByPlatform() == false) goto L19;
        service.logByPlatform(r100, r101, r102);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L26:
        return;
    L28:
        return;
    }

    private static void logByDebugLoggingDelegate(int r100, String r101, String r102) {
        AbsBaseLogDelegate r103 = sDebugLoggingDelegate;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        r103.v(r101, r102);
        return;
    L7:
        if (r100 != 1) goto L9;
        r103.d(r101, r102);
        return;
    L9:
        if (r100 != 2) goto L11;
        r103.i(r101, r102);
        return;
    L11:
        if (r100 != 3) goto L13;
        r103.w(r101, r102);
        return;
    L13:
        if (r100 != 4) goto L25;
        r103.e(r101, r102);
        return;
    }

    private static void log(int r100, String r101, String r102, int r103, long r104, int r105, int r106) {
        if (r100 <= 4) goto L15;
        r100 = 4;
    L15:
        ILynxLogService r107 = service;     // Catch: Throwable -> L12
        if (r107 != null) goto L8;
    L10:
        logByDebugLoggingDelegate(r100, r101, r102);     // Catch: Throwable -> L12
        return;
    L8:
        if (r107.isLogOutputByPlatform() == false) goto L10;
        service.logByPlatform(r100, r101, r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.getMessage();
    }

    private static void logByte(int r100, String r101, byte[] r110, int r111, long r112, int r113, int r114) {
        log(r100, r101, new String(r110), r111, r112, r113, r114);
    }
}
