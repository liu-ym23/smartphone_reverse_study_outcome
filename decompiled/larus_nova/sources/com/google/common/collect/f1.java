package com.google.common.collect;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface f1<K, V> extends q1<K, V> {
    @Override // com.google.common.collect.q1
    List<V> get(@ParametricNullness K r100);

    @Override // com.google.common.collect.q1
    List<V> removeAll(@CheckForNull Object r100);

    @Override // com.google.common.collect.q1
    List<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101);
}
