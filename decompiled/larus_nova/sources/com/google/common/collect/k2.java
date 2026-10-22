package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface k2<K, V> extends q1<K, V> {
    @Override // com.google.common.collect.q1
    Set<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.q1
    Set<V> get(@ParametricNullness K r100);

    @Override // com.google.common.collect.q1
    Set<V> removeAll(@CheckForNull Object r100);

    @Override // com.google.common.collect.q1
    Set<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101);
}
