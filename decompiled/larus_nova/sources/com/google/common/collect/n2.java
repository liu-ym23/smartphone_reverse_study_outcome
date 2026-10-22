package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface n2<E> extends y1, l2<E> {
    Comparator<? super E> comparator();

    n2<E> descendingMultiset();

    @Override // com.google.common.collect.y1
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.y1
    Set<y1.a<E>> entrySet();

    @CheckForNull
    y1.a<E> firstEntry();

    n2<E> headMultiset(@ParametricNullness E r100, BoundType r101);

    @CheckForNull
    y1.a<E> lastEntry();

    @CheckForNull
    y1.a<E> pollFirstEntry();

    @CheckForNull
    y1.a<E> pollLastEntry();

    n2<E> subMultiset(@ParametricNullness E r100, BoundType r101, @ParametricNullness E r102, BoundType r103);

    n2<E> tailMultiset(@ParametricNullness E r100, BoundType r101);
}
