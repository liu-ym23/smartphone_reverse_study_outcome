package com.facebook.imagepipeline.memory;

import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapCounterProvider {
    private static final long KB = 1024;
    public static final int MAX_BITMAP_TOTAL_SIZE = 0;
    private static final long MB = 1048576;
    private static final Class<?> TAG = null;
    private static volatile BitmapCounter sBitmapCounter;
    private static int sMaxBitmapCount;

    public BitmapCounterProvider() {
    }

    static {
        TAG = BitmapCounterProvider.class;
        MAX_BITMAP_TOTAL_SIZE = getMaxSizeHardCap();
        sMaxBitmapCount = 384;
    }

    public static BitmapCounter get() {
        if (sBitmapCounter != null) goto L15;
        monitor-enter(BitmapCounterProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sBitmapCounter != null) goto L9;
        sBitmapCounter = new BitmapCounter(sMaxBitmapCount, MAX_BITMAP_TOTAL_SIZE);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BitmapCounterProvider.class);     // Catch: Throwable -> L11
    L15:
        return sBitmapCounter;
    }

    private static int getMaxSizeHardCap() {
        int r100 = (int) Math.min(Runtime.getRuntime().maxMemory(), SieveCacheKt.NodeLinkMask);
        if (r100 <= 16777216) goto L7;
        return (r100 / 4) * 3;
    L7:
        return r100 / 2;
    }

    public static void initialize(BitmapCounterConfig r100) {
        if (sBitmapCounter != null) goto L7;
        sMaxBitmapCount = r100.getMaxBitmapCount();
        return;
    L7:
        throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
    }
}
