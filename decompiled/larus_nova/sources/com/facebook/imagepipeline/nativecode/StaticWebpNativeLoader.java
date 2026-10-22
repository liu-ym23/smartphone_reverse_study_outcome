package com.facebook.imagepipeline.nativecode;

import com.facebook.imageutils.FrescoSoLoader;

/* JADX INFO: loaded from: classes23.dex */
public class StaticWebpNativeLoader {
    private static boolean sInitialized;

    public StaticWebpNativeLoader() {
    }

    public static synchronized void ensure() {
        monitor-enter(StaticWebpNativeLoader.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sInitialized == true) goto L7;
        FrescoSoLoader.loadLibrary("static-webp");     // Catch: Throwable -> L9
        sInitialized = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(StaticWebpNativeLoader.class);
    }
}
