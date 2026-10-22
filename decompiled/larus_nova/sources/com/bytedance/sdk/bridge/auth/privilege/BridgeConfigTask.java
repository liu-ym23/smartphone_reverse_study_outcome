package com.bytedance.sdk.bridge.auth.privilege;

import com.bytedance.sdk.bridge.auth.privilege.a;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BridgeConfigTask<T, B extends a> {

    public static class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
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
}
