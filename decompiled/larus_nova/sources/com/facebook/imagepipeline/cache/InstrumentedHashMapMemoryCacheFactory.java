package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes3.dex */
public class InstrumentedHashMapMemoryCacheFactory {
    public InstrumentedHashMapMemoryCacheFactory() {
    }

    public static InstrumentedMemoryCache<CacheKey, Bitmap> get(HashMapMemoryCache<CacheKey, Bitmap> r100, final ImageCacheStatsTracker r101) {
        r101.registerHashMapMemoryCache(r100);
        return new InstrumentedMemoryCache(r100, new AnonymousClass1(r101));
    }
}
