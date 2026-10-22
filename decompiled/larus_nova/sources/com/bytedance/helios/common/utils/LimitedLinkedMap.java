package com.bytedance.helios.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class LimitedLinkedMap<K, V> extends LinkedHashMap<K, V> {
    private final int limit;

    public LimitedLinkedMap(int r100) {
        this.limit = r100;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r100) {
        if (size() <= this.limit) goto L5;
        return true;
    L5:
        return false;
    }
}
