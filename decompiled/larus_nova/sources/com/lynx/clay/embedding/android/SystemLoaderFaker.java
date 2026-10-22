package com.lynx.clay.embedding.android;

/* JADX INFO: loaded from: classes32.dex */
public class SystemLoaderFaker {
    public SystemLoaderFaker() {
    }

    private static native boolean nativeLoadLibrary(String r100, String r101);

    public static boolean loadLibrary(String r100, String r101) {
        return nativeLoadLibrary(r100, r101);
    }
}
