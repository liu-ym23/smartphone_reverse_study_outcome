package com.bytedance.vmsdk.log;

import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
public class VLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "VLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static long alogNativePtr = 0;
    private static final int sDefaultLogLevel = 6;
    private static final int sDetectALogDependencyInterval = 500;
    private static final int sMaxTryCounts = 120;
    private static int[] sNativeLevelMap = null;
    private static int sNativeMinLogLevel = 6;
    private static int sTryCounts;

    /* JADX INFO: loaded from: classes22.dex */
    public class a extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (VLog.access$000() == false) goto L9;
            cancel();     // Catch: Throwable -> L6
            return;
        }

        public a() {
        }
    }

    public VLog() {
    }

    private static native void nativeInitALogNative(long r100, boolean r101);

    private static native void nativeInternalLog(int r100, String r101, String r102);

    private static native void nativeSetNativeMinLogLevel(int r100);

    public static void onEnvReady() {
        setMinimumLoggingLevel(4);
    }

    private static void initNativeLogLevelMap() {
        if (sNativeLevelMap != null) goto L6;
        sNativeLevelMap = new int[]{0, 0, -1, 0, 0, 1, 2, 3};
        return;
    }

    public static /* synthetic */ boolean access$000() {
        return detectALogDependence();
    }

    private static boolean detectALogDependence() {
        long r100 = tp7.a.b();
        if (r100 == 0) goto L6;
        initALog(r100);
        return true;
    L6:
        int r101 = sTryCounts + 1;
        sTryCounts = r101;
        if (r101 != 120) goto L9;
        return true;
    L9:
        return false;
    }

    public static void init() {
        onEnvReady();     // Catch: Throwable -> L6
        long r100 = tp7.a.b();     // Catch: Throwable -> L6
        if (r100 == 0) goto L9;
        initALog(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static void loadALogDependency() {
        if (detectALogDependence() == true) goto L6;
        new PthreadTimer("msdk/log/VLog").schedule(new a(), 0, 500);
        return;
    }

    private static long getALogPtr() {
        return alogNativePtr;
    }

    private static void initALogLazy() {
        loadALogDependency();
    }

    public static void initALog(long r100) {
        if (Build.VERSION.SDK_INT <= 24) goto L5;
        boolean r101 = true;
    L6:
        alogNativePtr = r100;
        nativeInitALogNative(r100, r101);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void setMinimumLoggingLevel(int r100) {
        initNativeLogLevelMap();     // Catch: ArrayIndexOutOfBoundsException -> L6
        nativeSetNativeMinLogLevel(sNativeLevelMap[r100]);     // Catch: ArrayIndexOutOfBoundsException -> L6
        if (sNativeMinLogLevel == r100) goto L11;
        sNativeMinLogLevel = r100;     // Catch: ArrayIndexOutOfBoundsException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.getMessage();
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

    public static void v(String r100, String r101) {
        internalLog(2, r100, r101);
    }

    public static void w(String r100, String r101) {
        internalLog(5, r100, r101);
    }

    public static void internalLog(int r100, String r101, String r102) {
        nativeInternalLog(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.getMessage();
    }
}
