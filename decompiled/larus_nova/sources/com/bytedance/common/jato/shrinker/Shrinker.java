package com.bytedance.common.jato.shrinker;

import android.os.Build;

/* JADX INFO: loaded from: classes15.dex */
public class Shrinker {
    public static final int DEFAULT_DESIRABLE_LOWEST_HEAP_SIZE_POST_O = 2048;
    public static final int DEFAULT_DESIRABLE_LOWEST_HEAP_SIZE_PRE_O = 512;
    private static Shrinker sInstance;

    public Shrinker() {
    }

    public static synchronized Shrinker getInstance() {
        monitor-enter(Shrinker.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new Shrinker();     // Catch: Throwable -> L10
    L7:
        Shrinker r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(Shrinker.class);
        return r100;
    }

    public int doShrink() {
        return doShrink(512, 2048);
    }

    public int shrinkWebviewNative() {
        return ShrinkerNativeHolder.shrinkWebviewNative();
    }

    public int doShrink(int r100) {
        return doShrink(r100, 2048);
    }

    public int doShrinkRegion(int r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        if (ShrinkerNativeHolder.ensureInited() == true) goto L7;
        return 0;
    L7:
        return ShrinkerNativeHolder.shrinkRegionNative(r100);
    }

    public int doShrink(int r100, int r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 <= 23) goto L10;
        if (r102 > 29) goto L10;
        if (ShrinkerNativeHolder.ensureInited() == false) goto L10;
        ShrinkerNativeHolder.shrinkMallocNative(2, 16);
    L10:
        if (ShrinkerNativeHolder.ensureInited() == true) goto L12;
        return -1;
    L12:
        if (r102 >= 26) goto L16;
        return ShrinkerNativeHolder.shrinkHeapNative(r100);
    L16:
        return ShrinkerNativeHolder.shrinkRegionNative(r101);
    }
}
