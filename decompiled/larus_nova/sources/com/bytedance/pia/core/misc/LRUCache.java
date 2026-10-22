package com.bytedance.pia.core.misc;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public LRUCache(int r100) {
        super(r100, 1.0f, true);
        this.cacheSize = r100;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry r100) {
        if (size() <= this.cacheSize) goto L5;
        return true;
    L5:
        return false;
    }
}
