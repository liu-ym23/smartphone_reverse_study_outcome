package com.bytedance.android.shopping.mall.homepage.tools;

import android.util.LruCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s<K> extends LruCache<K, Object> {
    public static final Object a = null;

    static {
        a = new Object();
    }

    public s(int r1) {
        super(r1);
    }

    public final void a(K r2) {
        put(r2, a);
    }
}
