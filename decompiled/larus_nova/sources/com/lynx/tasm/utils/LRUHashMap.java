package com.lynx.tasm.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class LRUHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public int getCapacity() {
        return this.capacity;
    }

    public LRUHashMap(int r100) {
        super(r100, 0.75f, true);
        this.capacity = r100;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r100) {
        if (size() <= this.capacity) goto L5;
        return true;
    L5:
        return false;
    }
}
