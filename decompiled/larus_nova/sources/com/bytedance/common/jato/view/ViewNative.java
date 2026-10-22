package com.bytedance.common.jato.view;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ViewNative {
    static volatile int inited;

    public ViewNative() {
    }

    public static native long nativeGetCurrentThreadRenderNodeCount();

    public static native long nativeGetMainThreadRenderNodeCount();

    public static native long nativeGetRenderNodeCreatedCount();

    public static native long nativeGetRenderNodeDestroyedCount();

    private static native boolean nativeInit(Class r100);

    public static native boolean nativeRegister(long r100);

    public static native boolean nativeSetEnableMonitor(boolean r100);

    public static native void nativeUnregister(long r100);

    public static boolean init() {
        if (inited != (-1)) goto L19;
        monitor-enter(ViewNative.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (inited == (-1)) goto L9;
    L13:
        monitor-exit(ViewNative.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (nativeInit(ViewDestroyMonitor.class) == false) goto L11;
        int r100 = 1;
    L12:
        inited = r100;     // Catch: Throwable -> L15
        goto L13
    L11:
        r100 = 0;
    L19:
        if (inited != 1) goto L24;
        return true;
    L24:
        return false;
    }

    static {
        JatoNativeLoader.loadLibrary();
        inited = -1;
    }
}
