package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class SettableCacheEvent implements CacheEvent {
    private static final int MAX_RECYCLED = 5;
    private static final Object RECYCLER_LOCK = null;
    private static SettableCacheEvent sFirstRecycledEvent;
    private static int sRecycledCount;
    private CacheKey mCacheKey;
    private long mCacheLimit;
    private long mCacheSize;
    private CacheEventListener.EvictionReason mEvictionReason;
    private IOException mException;
    private long mItemSize;
    private SettableCacheEvent mNextRecycledEvent;
    private String mResourceId;

    private void reset() {
        this.mCacheKey = null;
        this.mResourceId = null;
        this.mItemSize = 0;
        this.mCacheLimit = 0;
        this.mCacheSize = 0;
        this.mException = null;
        this.mEvictionReason = null;
    }

    static {
        RECYCLER_LOCK = new Object();
    }

    public static SettableCacheEvent obtain() {
        Object r100 = RECYCLER_LOCK;
        monitor-enter(r100);
        SettableCacheEvent r101 = sFirstRecycledEvent;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        sFirstRecycledEvent = r101.mNextRecycledEvent;     // Catch: Throwable -> L12
        r101.mNextRecycledEvent = null;     // Catch: Throwable -> L12
        sRecycledCount--;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return new SettableCacheEvent();
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public CacheKey getCacheKey() {
        CacheKey r100 = this.mCacheKey;
        if ((r100 instanceof DiskWrapperCacheKey) == true) goto L5;
        return r100;
    L5:
        return ((DiskWrapperCacheKey) r100).getInnerCacheKey();
    }

    public void recycle() {
        Object r100 = RECYCLER_LOCK;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sRecycledCount >= 5) goto L10;
        reset();     // Catch: Throwable -> L12
        sRecycledCount++;     // Catch: Throwable -> L12
        SettableCacheEvent r101 = sFirstRecycledEvent;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        this.mNextRecycledEvent = r101;     // Catch: Throwable -> L12
    L9:
        sFirstRecycledEvent = this;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    private SettableCacheEvent() {
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheLimit() {
        return this.mCacheLimit;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheSize() {
        return this.mCacheSize;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public CacheEventListener.EvictionReason getEvictionReason() {
        return this.mEvictionReason;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public IOException getException() {
        return this.mException;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getItemSize() {
        return this.mItemSize;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public String getResourceId() {
        return this.mResourceId;
    }

    public SettableCacheEvent setCacheKey(CacheKey r100) {
        this.mCacheKey = r100;
        return this;
    }

    public SettableCacheEvent setCacheLimit(long r100) {
        this.mCacheLimit = r100;
        return this;
    }

    public SettableCacheEvent setCacheSize(long r100) {
        this.mCacheSize = r100;
        return this;
    }

    public SettableCacheEvent setEvictionReason(CacheEventListener.EvictionReason r100) {
        this.mEvictionReason = r100;
        return this;
    }

    public SettableCacheEvent setException(IOException r100) {
        this.mException = r100;
        return this;
    }

    public SettableCacheEvent setItemSize(long r100) {
        this.mItemSize = r100;
        return this;
    }

    public SettableCacheEvent setResourceId(String r100) {
        this.mResourceId = r100;
        return this;
    }
}
