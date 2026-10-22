package com.facebook.cache.common;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MultiCacheEventListener implements CacheEventListener {
    private List<CacheEventListener> mCacheEventListeners;

    @Override // com.facebook.cache.common.CacheEventListener
    public void onCleared() {
        Iterator<CacheEventListener> r100 = this.mCacheEventListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onCleared();
        goto L4
    }

    public MultiCacheEventListener() {
        this.mCacheEventListeners = new CopyOnWriteArrayList();
    }

    public void addCacheEventListener(CacheEventListener r100) {
        this.mCacheEventListeners.add(r100);
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onEviction(r100);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onHit(r100);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onMiss(r100);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onReadException(r100);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onWriteAttempt(r100);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onWriteException(r100);
        goto L4
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteSuccess(CacheEvent r100) {
        Iterator<CacheEventListener> r101 = this.mCacheEventListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onWriteSuccess(r100);
        goto L4
    }
}
