package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ImageDynamicCacheStrategy {
    public static ImageDynamicCacheStrategy FRESCO_DEFAULT_STRATEGY;
    private static ImageDynamicCacheStrategy sStrategy;

    public ImageDynamicCacheStrategy() {
    }

    public abstract int AdjustAnimBitmapMemoryCacheSize(int r100);

    public abstract int AdjustBigBitmapMemoryCacheSize(int r100);

    public abstract int AdjustEncodeMemoryCacheSize(int r100);

    public abstract int AdjustNormalBitmapMemoryCacheSize(int r100);

    public abstract int AdjustPrefetchBitmapMemoryCacheSize(int r100);

    static {
        FRESCO_DEFAULT_STRATEGY = new AnonymousClass1();
    }

    public static ImageDynamicCacheStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageDynamicCacheStrategy r100) {
        sStrategy = r100;
    }
}
