package z;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b<K, V> implements Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f569577a;

    public b() {
        this(false);
    }

    @Override // java.util.Map
    public final void clear() {
        this.f569577a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        return this.f569577a.containsKey(r100);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        return this.f569577a.containsValue(r100);
    }

    @Override // java.util.Map
    public final V get(Object r100) {
        return (V) this.f569577a.get(r100);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f569577a.isEmpty();
    }

    @Override // java.util.Map
    public final V put(K r100, V r101) {
        return (V) this.f569577a.put(r100, r101);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r100) {
        this.f569577a.putAll(r100);
    }

    @Override // java.util.Map
    public final V remove(Object r100) {
        return (V) this.f569577a.remove(r100);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.f569577a.entrySet();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.f569577a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f569577a.size();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.f569577a.values();
    }

    public b(boolean r100) {
        if (r100 == false) goto L5;
        Map r101 = new ConcurrentHashMap();
    L6:
        this.f569577a = r101;
        return;
    L5:
        r101 = new LinkedHashMap(0, 0.75f, true);
        goto L6
    }
}
