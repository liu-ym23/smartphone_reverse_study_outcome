package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class w2<F, T> extends v2<F, T> implements ListIterator<T> {
    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f275533a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f275533a).nextIndex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    @ParametricNullness
    public final T previous() {
        return (T) a(((ListIterator) this.f275533a).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f275533a).previousIndex();
    }

    public w2(ListIterator<? extends F> r100) {
        super(r100);
    }

    @Override // java.util.ListIterator
    public final void add(@ParametricNullness T r100) {
        throw new UnsupportedOperationException();
    }

    public void set(@ParametricNullness T r100) {
        throw new UnsupportedOperationException();
    }
}
