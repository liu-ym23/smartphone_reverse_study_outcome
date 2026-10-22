package com.ss.android.eventbus;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int r100) {
        super(16, 0.75f, true);
        this.cacheSize = r100;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r100) {
        if (size() < this.cacheSize) goto L5;
        return true;
    L5:
        return false;
    }
}
