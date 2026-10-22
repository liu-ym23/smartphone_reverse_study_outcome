package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class i0<T> extends o0 implements Iterator<T> {
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return ((ConcurrentHashMultiset.c) this).f274998b.hasNext();
    }

    @ParametricNullness
    public T next() {
        return (T) ((ConcurrentHashMultiset.c) this).f274998b.next();
    }

    public i0() {
    }
}
