package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface p2<K, V> extends k2<K, V> {
    @Override // com.google.common.collect.k2, com.google.common.collect.q1
    SortedSet<V> get(@ParametricNullness K r100);

    @Override // com.google.common.collect.k2, com.google.common.collect.q1
    SortedSet<V> removeAll(@CheckForNull Object r100);

    @Override // com.google.common.collect.k2, com.google.common.collect.q1
    SortedSet<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101);

    @CheckForNull
    Comparator<? super V> valueComparator();
}
