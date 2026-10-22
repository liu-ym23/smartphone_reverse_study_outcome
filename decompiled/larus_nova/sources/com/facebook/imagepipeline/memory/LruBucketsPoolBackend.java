package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {
    private final Set<T> mCurrentItems;
    private final BucketMap<T> mMap;

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public T pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    public int valueCount() {
        return this.mMap.valueCount();
    }

    public LruBucketsPoolBackend() {
        this.mCurrentItems = new HashSet();
        this.mMap = new BucketMap();
    }

    private T maybeRemoveFromCurrentItems(T r100) {
        if (r100 == null) goto L10;
        monitor-enter(this);
        this.mCurrentItems.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    L10:
        return r100;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public T get(int r100) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(r100));
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public void put(T r100) {
        monitor-enter(this);
        boolean r101 = this.mCurrentItems.add(r100);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r101 == false) goto L13;
        this.mMap.release(getSize(r100), r100);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
