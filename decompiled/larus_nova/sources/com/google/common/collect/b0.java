package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class b0<K, V> extends AbstractCollection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0<K, V> f275427a;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f275427a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return new j1(this.f275427a.entries().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f275427a.size();
    }

    public b0(a0<K, V> r100) {
        r100.getClass();
        this.f275427a = r100;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object r100) {
        return this.f275427a.containsValue(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object r100) {
        com.google.common.base.n<? super Map.Entry<K, V>> r101 = this.f275427a.c();
        Iterator<Map.Entry<K, V>> r102 = this.f275427a.d().entries().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<K, V> r103 = r102.next();
        if (r101.apply(r103) == false) goto L4;
        if (com.google.common.base.k.a(r103.getValue(), r100) == false) goto L4;
        r102.remove();
        return true;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> r100) {
        return a1.c(this.f275427a.d().entries(), Predicates.c(this.f275427a.c(), Maps.k(Predicates.f(r100))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> r100) {
        return a1.c(this.f275427a.d().entries(), Predicates.c(this.f275427a.c(), Maps.k(Predicates.h(Predicates.f(r100)))));
    }
}
