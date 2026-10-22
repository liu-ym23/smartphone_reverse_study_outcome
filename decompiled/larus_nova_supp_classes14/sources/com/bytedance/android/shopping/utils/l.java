package com.bytedance.android.shopping.utils;

import com.bytedance.jedi.model.ext.cache.guava.LruCache;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class l<K, V> extends LruCache<K, V> {
    public final List<Pair<K, V>> h() {
        return super.h();
    }

    public l(long r1) {
        super(r1);
    }

    public final V b(K r2) {
        return (V) ((LruCache) this).b.a.getIfPresent(r2);
    }

    public final void i(K r2) {
        super.g(r2, null);
    }

    public final void g(K r1, V r2) {
        super.g(r1, r2);
    }
}
