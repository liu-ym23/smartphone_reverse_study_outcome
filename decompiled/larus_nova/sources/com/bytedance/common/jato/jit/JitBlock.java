package com.bytedance.common.jato.jit;

import android.os.Build;
import com.bytedance.common.jato.JatoFeatureReporter;
import com.bytedance.common.jato.JatoListener;
import com.bytedance.common.jato.JatoNativeLoader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class JitBlock {
    private static volatile boolean isDebug;
    private static volatile boolean sIsLoadError;
    private static volatile boolean sIsLoaded;
    private static JatoListener sMonitor;

    public JitBlock() {
    }

    private static native int initJitBlockInternal(int r100, boolean r101);

    private static native void lightJitBlockStartInternal();

    private static native void lightJitBlockStopInternal();

    private static native void nativeSetInterval(long r100);

    private static native void nativeSetPriority(int r100);

    private static boolean checkEnable() {
        if (isDebug == false) goto L5;
    L14:
        return false;
    L5:
        if (sIsLoaded == false) goto L14;
        if (sIsLoadError == true) goto L14;
        if (Build.VERSION.SDK_INT >= 24) goto L12;
        return false;
    L12:
        return true;
    }

    public static void lightJitBlockStart() {
        if (checkEnable() == false) goto L6;
        lightJitBlockStartInternal();
        return;
    }

    public static void lightJitBlockStop() {
        if (checkEnable() == false) goto L6;
        lightJitBlockStopInternal();
        return;
    }

    public static void initJitBlock(boolean r100) {
        if (isDebug == false) goto L6;
        return;
    L6:
        if (sIsLoaded == false) goto L8;
        return;
    L8:
        if (sIsLoadError == true) goto L33;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 24) goto L14;
        return;
    L14:
        if (JatoNativeLoader.loadLibrary() == true) goto L30;
        return;
    L30:
        int r102 = initJitBlockInternal(r101, r100);     // Catch: Throwable -> L27
        if (JatoFeatureReporter.isEnabled() == false) goto L20;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L27
        JatoFeatureReporter.putExtra(r103, "isAddref", Boolean.valueOf(r100));     // Catch: Throwable -> L27
        JatoFeatureReporter.putExtra(r103, "sdkversion", Integer.valueOf(r101));     // Catch: Throwable -> L27
        JatoFeatureReporter.reportResult("JitBlockInit", r102, 0, r103);     // Catch: Throwable -> L27
    L20:
        if (r102 == 0) goto L25;
        JatoListener r104 = sMonitor;     // Catch: Throwable -> L27
        if (r104 == null) goto L24;
        r104.onDebugInfo("init jit block failed:" + r102);     // Catch: Throwable -> L27
    L24:
        sIsLoadError = true;     // Catch: Throwable -> L27
    L25:
        sIsLoaded = true;     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void setInterval(long r100) {
        if (checkEnable() == false) goto L6;
        nativeSetInterval(r100);
        return;
    }

    public static void setMonitor(JatoListener r100) {
        sMonitor = r100;
    }

    public static void setPriority(int r100) {
        if (checkEnable() == true) goto L5;
        return;
    L5:
        if (r100 == (-1)) goto L9;
        nativeSetPriority(r100);
        return;
    }
}
