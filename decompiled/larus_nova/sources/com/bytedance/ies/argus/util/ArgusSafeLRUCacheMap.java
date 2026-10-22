package com.bytedance.ies.argus.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusSafeLRUCacheMap<K, V> implements Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<K, V> f246247a;

    @Override // java.util.Map
    public final void clear() {
        this.f246247a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        return this.f246247a.containsKey(r100);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        return this.f246247a.containsValue(r100);
    }

    @Override // java.util.Map
    public final V get(Object r100) {
        return this.f246247a.get(r100);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f246247a.isEmpty();
    }

    @Override // java.util.Map
    public final V put(K r100, V r101) {
        return this.f246247a.put(r100, r101);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f246247a.putAll(r100);
    }

    @Override // java.util.Map
    public final V remove(Object r100) {
        return this.f246247a.remove(r100);
    }

    public /* synthetic */ ArgusSafeLRUCacheMap() {
        this(15);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.f246247a.entrySet();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.f246247a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f246247a.size();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.f246247a.values();
    }

    public ArgusSafeLRUCacheMap(final int r100) {
        final int r101 = ((int) (r100 / 0.75f)) + 1;
        this.f246247a = Collections.synchronizedMap(new AnonymousClass1(r100, r101));
    }
}
