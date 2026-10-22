package com.lynx.tasm.base;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;

/* JADX INFO: loaded from: classes32.dex */
public class LLog {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int INFO = 2;
    public static final int REPORT = -1;
    public static final int VERBOSE = 0;
    public static final int WARN = 3;

    public LLog() {
    }

    public static void DTHROW() {
        DTHROW(null);
    }

    public static int addLoggingDelegate(AbsLogDelegate r100) {
        return -1;
    }

    public static void initALog(long r100) {
    }

    public static void internalLog(int r100, String r101, String r102, LogSource r103, Long r104, int r105) {
    }

    public static boolean isLoggable(int r100) {
        return false;
    }

    public static void onEnvReady() {
    }

    public static void setLoggingDelegate(AbsLogDelegate r100) {
    }

    public static int getMinimumLoggingLevel() {
        return LynxLog.getMinimumLoggingLevel();
    }

    public static void initLynxLog() {
        LynxLog.initLynxLog(LynxEnv.inst().isDevtoolEnabled());
    }

    public static void DCHECK(boolean r100) {
        LynxLog.DCHECK(r100);
    }

    public static void DTHROW(RuntimeException r100) {
        LynxLog.DTHROW(r100);
    }

    public static synchronized void removeLoggingDelegate(int r100) {
        monitor-enter(LLog.class);
        monitor-exit(LLog.class);
    }

    public static void setDebugLoggingDelegate(AbsLogDelegate r100) {
        if (b.f381857b == null) goto L5;
    L14:
        b.f381857b.getClass();
        b.f381856a = r100;
        LynxLog.setDebugLoggingDelegate(b.a());
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.f381857b != null) goto L9;
        b.f381857b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void setJSLogsFromExternalChannels(boolean r100) {
        LynxLog.setJSLogsFromExternalChannels(r100);
    }

    public static void setMinimumLoggingLevel(int r100) {
        LynxLog.setMinimumLoggingLevel(r100);
    }

    public static void d(String r100, String r101) {
        LynxLog.d(r100, r101);
    }

    public static void e(String r100, String r101) {
        LynxLog.e(r100, r101);
    }

    public static void i(String r100, String r101) {
        LynxLog.i(r100, r101);
    }

    public static void report(String r100, String r101) {
        LynxLog.e(r100, r101);
    }

    public static void v(String r100, String r101) {
        LynxLog.v(r100, r101);
    }

    public static void w(String r100, String r101) {
        LynxLog.w(r100, r101);
    }

    public static void internalLog(int r100, String r101, String r102) {
        LynxLog.internalLog(r100, r101, r102);
    }
}
