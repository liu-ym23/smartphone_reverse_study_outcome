package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class HashMapMemoryCache<K, V> implements MemoryCache<K, V> {
    final Map<K, CloseableReference<V>> mCachedEntries;

    /* JADX INFO: loaded from: classes23.dex */
    public static class Entry<K, V> {
        public final K key;
        public final CloseableReference<V> valueRef;

        private Entry(K r100, CloseableReference<V> r101) {
            this.key = (K) Preconditions.checkNotNull(r100);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(r101));
        }
    }

    public HashMapMemoryCache() {
        this.mCachedEntries = new ConcurrentHashMap();
    }

    public void clearForCacheKey(final CacheKey r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getUriString().isEmpty() == true) goto L8;
        removeAll(new AnonymousClass1(this, r100));
        return;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList(this.mCachedEntries.entrySet().size());     // Catch: Throwable -> L15
        Iterator<Map.Entry<K, CloseableReference<V>>> r102 = this.mCachedEntries.entrySet().iterator();     // Catch: Throwable -> L15
    L5:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<K, CloseableReference<V>> r103 = r102.next();     // Catch: Throwable -> L15
        if (r100 == null) goto L10;
        if (r100.apply(r103.getKey()) == false) goto L5;
    L10:
        r101.add(r103);     // Catch: Throwable -> L15
        goto L5
    L11:
        boolean r104 = !r101.isEmpty();
        monitor-exit(this);
        return r104;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K r100) {
        Preconditions.checkNotNull(r100);
        return this.mCachedEntries.get(r100);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<K, CloseableReference<V>>> r102 = this.mCachedEntries.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<K, CloseableReference<V>> r103 = r102.next();
        if (r100 == null) goto L9;
        if (r100.apply(r103.getKey()) == false) goto L4;
    L9:
        r101.add(r103.getValue());
        r103.getValue().close();
        r102.remove();
        goto L4
    L11:
        return r101.size();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K r100, CloseableReference<V> r101) {
        return this.mCachedEntries.put(r100, r101);
    }
}
