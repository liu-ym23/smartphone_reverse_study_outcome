package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes3.dex */
public class HashMapMemoryCacheFactory {
    public HashMapMemoryCacheFactory() {
    }

    public static HashMapMemoryCache<CacheKey, Bitmap> get() {
        return new HashMapMemoryCache();
    }
}
