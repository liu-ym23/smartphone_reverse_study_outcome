package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheFactory {
    public BitmapMemoryCacheFactory() {
    }

    public static InstrumentedMemoryCache<CacheKey, CloseableImage> get(CountingMemoryCache<CacheKey, CloseableImage> r100, final ImageCacheStatsTracker r101) {
        r101.registerBitmapMemoryCache(r100);
        return new InstrumentedMemoryCache(r100, new AnonymousClass1(r101));
    }
}
