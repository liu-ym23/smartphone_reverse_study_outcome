package com.bytedance.anniex.bd.foundation.impl;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s<K, V> implements lr3.a<K, V> {
    public final ConcurrentHashMap<K, V> a;

    public s() {
        this.a = new ConcurrentHashMap();
    }

    @Override // lr3.a
    public boolean delete(K r2) {
        ConcurrentHashMap<K, V> r0 = this.a;
        if (r0 == null) goto L10;
        if (TypeIntrinsics.asMutableMap(r0).remove(r2) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
