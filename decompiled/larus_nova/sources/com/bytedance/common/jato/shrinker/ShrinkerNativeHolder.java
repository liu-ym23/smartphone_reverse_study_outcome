package com.bytedance.common.jato.shrinker;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
class ShrinkerNativeHolder {
    private static boolean sInited;

    public ShrinkerNativeHolder() {
    }

    public static native int shrinkHeapNative(int r100);

    public static native int shrinkMallocNative(int r100, int r101);

    public static native int shrinkRegionNative(int r100);

    public static native int shrinkWebviewNative();

    public static synchronized boolean ensureInited() {
        monitor-enter(ShrinkerNativeHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sInited == false) goto L7;
    L9:
        boolean r100 = sInited;     // Catch: Throwable -> L12
        monitor-exit(ShrinkerNativeHolder.class);
        return r100;
    L7:
        if (JatoNativeLoader.loadLibrary() == false) goto L9;
        sInited = true;     // Catch: Throwable -> L12
        goto L9
    }
}
