package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedHeifFrameCache {
    private final HashMapMemoryCache<CacheKey, Bitmap> mAnimatedHeifBackingCache;
    private final CacheKey mImageCacheKey;

    public static class FrameKey implements CacheKey {
        private final int mFrameIndex;
        private final CacheKey mImageCacheKey;

        @Override // com.facebook.cache.common.CacheKey
        public String getUriString() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.mImageCacheKey.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            return Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri r100) {
            return this.mImageCacheKey.containsUri(r100);
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FrameKey) == false) goto L14;
            FrameKey r101 = (FrameKey) r100;
            if (this.mFrameIndex == r101.mFrameIndex) goto L10;
        L12:
            return false;
        L10:
            if (this.mImageCacheKey.equals(r101.mImageCacheKey) == false) goto L12;
            return true;
        L14:
            return false;
        }

        public FrameKey(CacheKey r100, int r101) {
            this.mImageCacheKey = r100;
            this.mFrameIndex = r101;
        }
    }

    public void clear() {
        this.mAnimatedHeifBackingCache.clearForCacheKey(this.mImageCacheKey);
    }

    private FrameKey keyFor(int r100) {
        return new FrameKey(this.mImageCacheKey, r100);
    }

    public boolean contains(int r100) {
        return CloseableReference.isValid(this.mAnimatedHeifBackingCache.get(keyFor(r100)));
    }

    @Nullable
    public CloseableReference<Bitmap> get(int r100) {
        return this.mAnimatedHeifBackingCache.get(keyFor(r100));
    }

    public AnimatedHeifFrameCache(CacheKey r100, HashMapMemoryCache<CacheKey, Bitmap> r101) {
        this.mImageCacheKey = r100;
        this.mAnimatedHeifBackingCache = r101;
    }

    @Nullable
    public CloseableReference<Bitmap> cache(int r100, CloseableReference<Bitmap> r101) {
        if (CloseableReference.isValid(r101) == false) goto L6;
        CloseableReference<Bitmap> r102 = CloseableReference.cloneOrNull(r101);
        this.mAnimatedHeifBackingCache.cache(keyFor(r100), r102);
        return r102;
    L6:
        return null;
    }
}
