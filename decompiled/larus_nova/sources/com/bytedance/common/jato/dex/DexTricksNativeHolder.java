package com.bytedance.common.jato.dex;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes3.dex */
public class DexTricksNativeHolder {
    private static boolean sInited;

    public DexTricksNativeHolder() {
    }

    private static native int dvmVerifyEnableNative();

    private static native int dvmVerifyNoneNative();

    private static native int verifyEnableAbove15Native();

    private static native int verifyEnableNative();

    private static native int verifyNoneAbove15Native();

    private static native int verifyNoneNative(int r100, int r101);

    private static synchronized boolean ensureInited() {
        monitor-enter(DexTricksNativeHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sInited == false) goto L7;
    L9:
        boolean r100 = sInited;     // Catch: Throwable -> L12
        monitor-exit(DexTricksNativeHolder.class);
        return r100;
    L7:
        if (JatoNativeLoader.loadLibrary() == false) goto L9;
        sInited = true;     // Catch: Throwable -> L12
        goto L9
    }

    public static int dvmVerifyEnable() {
        if (ensureInited() == true) goto L8;
    L6:
        return -1;
    L8:
        return dvmVerifyEnableNative();
    }

    public static int dvmVerifyNone() {
        if (ensureInited() == true) goto L8;
    L6:
        return -1;
    L8:
        return dvmVerifyNoneNative();
    }

    public static int verifyEnable() {
        if (ensureInited() == true) goto L5;
        return -1;
    L5:
        return verifyEnableNative();
    }

    public static int verifyEnable15() {
        if (ensureInited() == true) goto L5;
        return -1;
    L5:
        return verifyEnableAbove15Native();
    }

    public static int verifyNone15() {
        if (ensureInited() == true) goto L5;
        return -1;
    L5:
        return verifyNoneAbove15Native();
    }

    public static int verifyNone(int r100, int r101) {
        if (ensureInited() == true) goto L5;
        return -1;
    L5:
        return verifyNoneNative(r100, r101);
    }
}
