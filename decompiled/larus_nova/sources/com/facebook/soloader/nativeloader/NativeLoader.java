package com.facebook.soloader.nativeloader;

import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class NativeLoader {
    private static NativeLoaderDelegate sDelegate;

    private NativeLoader() {
    }

    public static int getSoSourcesVersion() {
        monitor-enter(NativeLoader.class);
        NativeLoaderDelegate r100 = sDelegate;     // Catch: Throwable -> L11
        if (r100 == null) goto L10;
        monitor-exit(NativeLoader.class);     // Catch: Throwable -> L11
        return r100.getSoSourcesVersion();
    L10:
        throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isInitialized() {
        monitor-enter(NativeLoader.class);
        if (sDelegate == null) goto L7;
        boolean r100 = true;
    L8:
        monitor-exit(NativeLoader.class);
        return r100;
    L7:
        r100 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public static String getLibraryPath(String r100) throws IOException {
        monitor-enter(NativeLoader.class);
        NativeLoaderDelegate r101 = sDelegate;     // Catch: Throwable -> L11
        if (r101 == null) goto L10;
        monitor-exit(NativeLoader.class);     // Catch: Throwable -> L11
        return r101.getLibraryPath(r100);
    L10:
        throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(NativeLoaderDelegate r100) {
        monitor-enter(NativeLoader.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sDelegate != null) goto L10;
        sDelegate = r100;     // Catch: Throwable -> L11
        monitor-exit(NativeLoader.class);
        return;
    L10:
        throw new IllegalStateException("Cannot re-initialize NativeLoader.");     // Catch: Throwable -> L11
    }

    public static synchronized void initIfUninitialized(NativeLoaderDelegate r100) {
        monitor-enter(NativeLoader.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInitialized() == true) goto L7;
        init(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(NativeLoader.class);
    }

    public static boolean loadLibrary(String r100) {
        return loadLibrary(r100, 0);
    }

    public static boolean loadLibrary(String r100, int r101) {
        monitor-enter(NativeLoader.class);
        NativeLoaderDelegate r102 = sDelegate;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        monitor-exit(NativeLoader.class);     // Catch: Throwable -> L11
        return r102.loadLibrary(r100, r101);
    L10:
        throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
