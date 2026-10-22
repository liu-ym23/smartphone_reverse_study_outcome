package io.github.alexzhirkevich.compottie;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes41.dex */
public final class c0<T> implements Map<Object, T>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Object, T> f490734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f490735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MultiOwnerMutex f490736c;

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f490734a.containsKey(r100);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f490734a.containsValue(r100);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f490734a.isEmpty();
    }

    @Override // java.util.Map
    public final void clear() {
        this.f490734a.clear();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<Object, T>> entrySet() {
        return this.f490734a.entrySet();
    }

    @Override // java.util.Map
    public final Set<Object> keySet() {
        return this.f490734a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f490734a.size();
    }

    @Override // java.util.Map
    public final Collection<T> values() {
        return this.f490734a.values();
    }

    public c0(int r100) {
        LinkedHashMap<Object, T> r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f490734a = r101;
        this.f490735b = 10;
        this.f490736c = new MultiOwnerMutex();
    }

    @Override // java.util.Map
    public final T get(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        T r101 = this.f490734a.remove(r100);
        if (r101 == null) goto L10;
        a(r100, r101);
        return r101;
    L10:
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends Object, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Iterator<Map.Entry<? extends Object, ? extends T>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends Object, ? extends T> r102 = r101.next();
        a(r102.getKey(), r102.getValue());
        goto L4
    }

    @Override // java.util.Map
    public final T remove(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return this.f490734a.remove(r100);
    }

    public final T a(Object r100, T r101) {
        if (this.f490735b >= 1) goto L6;
        return r101;
    L6:
        if (this.f490735b >= size()) goto L9;
        Object r102 = CollectionsKt.firstOrNull(keySet());
        TypeIntrinsics.asMutableMap(this).remove(r102);
        goto L6
    L9:
        return this.f490734a.put(r100, r101);
    }

    @Override // java.util.Map
    public final T put(Object r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return a(r100, r101);
    }
}
