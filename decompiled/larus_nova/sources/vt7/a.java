package vt7;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a<K, V> implements Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<K, V> f557229a;

    public a() {
        this(16);
    }

    @Override // java.util.Map
    public final void clear() {
        this.f557229a.clear();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return ((ConcurrentHashMap) this.f557229a).entrySet();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f557229a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return ((ConcurrentHashMap) this.f557229a).keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return ((ConcurrentHashMap) this.f557229a).size();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return ((ConcurrentHashMap) this.f557229a).values();
    }

    public a(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f557229a = new ConcurrentHashMap(r100);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        return this.f557229a.containsKey(r100);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        return this.f557229a.containsValue(r100);
    }

    @Override // java.util.Map
    public final V get(Object r100) {
        return this.f557229a.get(r100);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f557229a.putAll(r100);
    }

    @Override // java.util.Map
    public final V remove(Object r100) {
        return this.f557229a.remove(r100);
    }

    public a(int r100) {
        this.f557229a = new ConcurrentHashMap(r100);
    }

    @Override // java.util.Map
    public final V put(K r100, V r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        return this.f557229a.put(r100, r101);
    L7:
        throw new NullPointerException("key==null or value==null");
    }

    @Override // java.util.Map
    public final boolean remove(Object r100, Object r101) {
        return this.f557229a.remove(r100, r101);
    }
}
