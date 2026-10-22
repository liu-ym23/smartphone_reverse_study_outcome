package com.bytedance.dora.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxElements;

    public LRUCache(int r100) {
        super(r100, 0.75f, true);
        this.maxElements = r100;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry r100) {
        if (size() <= this.maxElements) goto L5;
        return true;
    L5:
        return false;
    }
}
