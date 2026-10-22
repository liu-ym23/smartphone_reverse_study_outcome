package com.bytedance.common.jato.interpreter;

import android.os.Build;
import android.os.Process;
import com.bytedance.common.jato.JatoListener;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes3.dex */
public class InterpreterBridge {
    private static String TAG;
    private static volatile boolean sIsLoadError;
    private static volatile boolean sIsLoaded;
    private static JatoListener sMonitor;

    public InterpreterBridge() {
    }

    private static native void chaOptInternal();

    public static native void disableDexVerifyNative();

    private static native int initInterpreterBridgeInternal(int r100);

    private static native void nterpGetShortyOptInternal();

    public static native void runtimeImageOptNative(int r100, int r101);

    public static void initInterpreterBridge() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 33) goto L6;
        return;
    L6:
        if (r100 >= 24) goto L9;
        return;
    L9:
        if (sIsLoaded == false) goto L11;
        return;
    L11:
        if (sIsLoadError == true) goto L27;
        int r101 = initInterpreterBridgeInternal(r100);     // Catch: Throwable -> L21
        if (r101 == 0) goto L19;
        JatoListener r102 = sMonitor;     // Catch: Throwable -> L21
        if (r102 == null) goto L18;
        r102.onDebugInfo("InterpreterBridge init failed:" + r101);     // Catch: Throwable -> L21
    L18:
        sIsLoadError = true;     // Catch: Throwable -> L21
    L19:
        sIsLoaded = true;     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    static {
        JatoNativeLoader.loadLibrary();
        TAG = "InterpreterBridge";
    }

    public static void chaOpt() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        chaOptInternal();
    }

    public static void disableDexVerify() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        disableDexVerifyNative();
    }

    public static void nterpGetShortyOpt() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        nterpGetShortyOptInternal();
    }
}
