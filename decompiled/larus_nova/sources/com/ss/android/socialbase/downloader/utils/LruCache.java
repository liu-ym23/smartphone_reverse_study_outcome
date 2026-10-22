package com.ss.android.socialbase.downloader.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class LruCache<K, T> extends LinkedHashMap<K, T> {
    private static final int DEFAULT_SIZE = 4;
    private int mMaxSize;

    public LruCache() {
        this(4, 4);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> r100) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMaxSize(int r100) {
        this.mMaxSize = r100;
    }

    public LruCache(int r100, int r101) {
        this(r100, r101, true);
    }

    public LruCache(int r100, int r101, boolean r102) {
        super(r100, 0.75f, r102);
        setMaxSize(r101);
    }
}
