package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface CacheKeyFactory {
    CacheKey getBitmapCacheKey(ImageRequest r100, Object r101);

    CacheKey getEncodedCacheKey(ImageRequest r100, Uri r101, @Nullable Object r102);

    CacheKey getEncodedCacheKey(ImageRequest r100, @Nullable Object r101);

    CacheKey getPostprocessedBitmapCacheKey(ImageRequest r100, Object r101);

    CacheKey getResizedImageCacheKey(ImageRequest r100, @Nullable Object r101);
}
