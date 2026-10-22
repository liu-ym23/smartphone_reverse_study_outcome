package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use Iterators.peekingIterator")
@ElementTypesAreNonnullByDefault
public interface e2<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @ParametricNullness
    E next();

    @ParametricNullness
    E peek();
}
