package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedFrameCache {
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final CountingMemoryCache.EntryStateObserver<CacheKey> mEntryStateObserver;
    private final LinkedHashSet<CacheKey> mFreeItemsPool;
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

    @Nullable
    private synchronized CacheKey popFirstFreeItemKey() {
        monitor-enter(this);
        Iterator<CacheKey> r100 = this.mFreeItemsPool.iterator();     // Catch: Throwable -> L10
        if (r100.hasNext() == false) goto L7;
        CacheKey r101 = r100.next();     // Catch: Throwable -> L10
        r100.remove();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Nullable
    public CloseableReference<CloseableImage> getForReuse() {
    L2:
        CacheKey r100 = popFirstFreeItemKey();
        if (r100 == null) goto L4;
        CloseableReference<CloseableImage> r101 = this.mBackingCache.reuse(r100);
        if (r101 == null) goto L2;
        return r101;
    L4:
        return null;
    }

    public static /* synthetic */ CacheKey access$000(AnimatedFrameCache r100) {
        return r100.mImageCacheKey;
    }

    private FrameKey keyFor(int r100) {
        return new FrameKey(this.mImageCacheKey, r100);
    }

    public void clear(final int r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        this.mBackingCache.removeAllForExclusive(new AnonymousClass2(this, r100));
    }

    public boolean contains(int r100) {
        return this.mBackingCache.contains(keyFor(r100));
    }

    @Nullable
    public CloseableReference<CloseableImage> get(int r100) {
        return this.mBackingCache.get(keyFor(r100));
    }

    public AnimatedFrameCache(CacheKey r100, CountingMemoryCache<CacheKey, CloseableImage> r101) {
        this.mImageCacheKey = r100;
        this.mBackingCache = r101;
        this.mFreeItemsPool = new LinkedHashSet();
        this.mEntryStateObserver = new AnonymousClass1(this);
    }

    @Nullable
    public CloseableReference<CloseableImage> cache(int r100, CloseableReference<CloseableImage> r101) {
        return this.mBackingCache.cache(keyFor(r100), r101, this.mEntryStateObserver);
    }

    public synchronized void onReusabilityChange(CacheKey r100, boolean r101) {
        monitor-enter(this);
        if (r101 == false) goto L5;
        this.mFreeItemsPool.add(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L5:
        this.mFreeItemsPool.remove(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
