package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class a3<E> extends z2<E> implements ListIterator<E> {
    public a3() {
    }

    @Override // java.util.ListIterator
    public final void add(@ParametricNullness E r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(@ParametricNullness E r100) {
        throw new UnsupportedOperationException();
    }
}
