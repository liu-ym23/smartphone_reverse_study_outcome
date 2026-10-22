package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class v2<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f275533a;

    @ParametricNullness
    abstract T a(@ParametricNullness F r100);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f275533a.hasNext();
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        return a(this.f275533a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f275533a.remove();
    }

    public v2(Iterator<? extends F> r100) {
        r100.getClass();
        this.f275533a = r100;
    }
}
