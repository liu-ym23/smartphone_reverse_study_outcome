package io.ktor.util.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes41.dex */
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Key, Value> f491948a;

    @Override // java.util.Map
    public final void clear() {
        this.f491948a.clear();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<Key, Value>> entrySet() {
        return this.f491948a.entrySet();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f491948a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f491948a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<Key> keySet() {
        return this.f491948a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f491948a.size();
    }

    public final String toString() {
        return "ConcurrentMapJvm by " + this.f491948a;
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        return this.f491948a.values();
    }

    public ConcurrentMap() {
        this.f491948a = new ConcurrentHashMap(32);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        return this.f491948a.containsKey(r100);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        return this.f491948a.containsValue(r100);
    }

    @Override // java.util.Map
    public final boolean equals(Object r100) {
        if ((r100 instanceof Map) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100, this.f491948a);
    }

    @Override // java.util.Map
    public final Value get(Object r100) {
        return this.f491948a.get(r100);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends Key, ? extends Value> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f491948a.putAll(r100);
    }

    @Override // java.util.Map
    public final Value remove(Object r100) {
        return this.f491948a.remove(r100);
    }

    public final Value a(Key r100, final Function0<? extends Value> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        ConcurrentHashMap<Key, Value> r102 = this.f491948a;
        final Function1<Key, Value> r103 = new ConcurrentMap$computeIfAbsent$1(r101);
        return r102.computeIfAbsent(r100, new a(r103));
    }

    @Override // java.util.Map
    public final Value put(Key r100, Value r101) {
        return this.f491948a.put(r100, r101);
    }

    @Override // java.util.Map
    public final boolean remove(Object r100, Object r101) {
        return this.f491948a.remove(r100, r101);
    }
}
