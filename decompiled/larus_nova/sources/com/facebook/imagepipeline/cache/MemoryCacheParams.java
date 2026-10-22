package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryCacheParams {
    public static final int CACHE_TYPE_BITMAP_ANIM = 3;
    public static final int CACHE_TYPE_BITMAP_BIG = 4;
    public static final int CACHE_TYPE_BITMAP_NORMAL = 2;
    public static final int CACHE_TYPE_BITMAP_PREFETCH = 5;
    public static final int CACHE_TYPE_BITMAP_SINGLE = 6;
    public static final int CACHE_TYPE_DEFAULT = 0;
    public static final int CACHE_TYPE_ENCODE = 1;
    public int mCacheType;
    private ImageDynamicCacheStrategy mImageDynamicCacheStrategy;
    public final boolean mMemoryCacheOpt;
    public final boolean mOptReuseMemoryCache;
    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    private int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;
    public final int maxOptEntrySize;

    public int getMaxCacheSize() {
        if (this.mImageDynamicCacheStrategy != null) goto L6;
        this.mImageDynamicCacheStrategy = ImageDynamicCacheStrategy.getStrategy();
    L6:
        if (this.mImageDynamicCacheStrategy == null) goto L30;
        int r100 = this.mCacheType;
        if (r100 == 1) goto L28;
        if (r100 == 2) goto L26;
        if (r100 == 3) goto L24;
        if (r100 == 4) goto L22;
        if (r100 == 5) goto L20;
        return this.maxCacheSize;
    L20:
        return ImageDynamicCacheStrategy.getStrategy().AdjustPrefetchBitmapMemoryCacheSize(this.maxCacheSize);
    L22:
        return ImageDynamicCacheStrategy.getStrategy().AdjustBigBitmapMemoryCacheSize(this.maxCacheSize);
    L24:
        return ImageDynamicCacheStrategy.getStrategy().AdjustAnimBitmapMemoryCacheSize(this.maxCacheSize);
    L26:
        return ImageDynamicCacheStrategy.getStrategy().AdjustNormalBitmapMemoryCacheSize(this.maxCacheSize);
    L28:
        return ImageDynamicCacheStrategy.getStrategy().AdjustEncodeMemoryCacheSize(this.maxCacheSize);
    L30:
        return this.maxCacheSize;
    }

    public MemoryCacheParams(int r110, int r111, int r112, int r113, int r114) {
        this(0, r110, r111, r112, r113, r114, false, 0, false);
    }

    public MemoryCacheParams(int r110, int r111, int r112, int r113, int r114, boolean r115, int r116) {
        this(0, r110, r111, r112, r113, r114, r115, r116, false);
    }

    public MemoryCacheParams(int r110, int r111, int r112, int r113, int r114, boolean r115, int r116, boolean r117) {
        this(0, r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public MemoryCacheParams(int r100, int r101, int r102, int r103, int r104, int r105, boolean r106, int r107, boolean r108) {
        this.mCacheType = r100;
        this.maxCacheSize = r101;
        this.maxCacheEntries = r102;
        this.maxEvictionQueueSize = r103;
        this.maxEvictionQueueEntries = r104;
        this.maxCacheEntrySize = r105;
        this.mMemoryCacheOpt = r106;
        this.maxOptEntrySize = r107;
        this.mOptReuseMemoryCache = r108;
    }
}
