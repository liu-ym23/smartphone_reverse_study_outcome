package com.bytedance.common.utility.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 3805937866184666407L;
    final int mMaxSize;

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r100) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public MaxSizeLinkedHashMap(int r100, int r101) {
        this(r100, r101, false);
    }

    public MaxSizeLinkedHashMap(int r100, int r101, boolean r102) {
        super(r101, 0.75f, true);
        this.mMaxSize = r100;
        if (r100 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
