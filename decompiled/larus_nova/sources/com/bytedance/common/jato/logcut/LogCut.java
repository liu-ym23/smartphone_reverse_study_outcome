package com.bytedance.common.jato.logcut;

import android.os.Build;
import com.bytedance.common.jato.JatoListener;

/* JADX INFO: loaded from: classes3.dex */
public class LogCut {
    public static int LOGCUT_ALL_LOG = 20002;
    public static int LOGCUT_JNI_LOG = 20001;
    public static int LOGCUT_NATIVE_LOG = 20000;
    private static volatile boolean sIsLoadError = false;
    private static volatile boolean sIsLoaded = false;
    private static JatoListener sMonitor = null;
    private static int sType = 20002;

    public LogCut() {
    }

    private static native int initLogCutInternal(int r100, int r101);

    private static native void logCutStartInternal();

    private static native void logCutStopInternal();

    private static boolean checkEnable() {
        if (sIsLoaded == true) goto L5;
        return false;
    L5:
        if (sIsLoadError == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static void logCutStart() {
        if (checkEnable() == false) goto L6;
        logCutStartInternal();
        return;
    }

    public static void logCutStop() {
        if (checkEnable() == false) goto L6;
        logCutStopInternal();
        return;
    }

    public static void initLogCut(int r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 32) goto L6;
        return;
    L6:
        if (sType == r100) goto L9;
        sIsLoaded = false;
        sIsLoadError = false;
    L9:
        if (sIsLoaded == false) goto L11;
        return;
    L11:
        if (sIsLoadError == true) goto L27;
        int r102 = initLogCutInternal(r100, r101);     // Catch: Throwable -> L21
        if (r102 == 0) goto L19;
        JatoListener r103 = sMonitor;     // Catch: Throwable -> L21
        if (r103 == null) goto L18;
        r103.onDebugInfo("logcut init failed:" + r102);     // Catch: Throwable -> L21
    L18:
        sIsLoadError = true;     // Catch: Throwable -> L21
    L19:
        sIsLoaded = true;     // Catch: Throwable -> L21
        sType = r100;     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void setMonitor(JatoListener r100) {
        sMonitor = r100;
    }
}
