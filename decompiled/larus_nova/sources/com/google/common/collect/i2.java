package com.google.common.collect;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface i2<R, C, V> extends t2<R, C, V> {
    @Override // com.google.common.collect.t2
    SortedSet<R> rowKeySet();

    @Override // com.google.common.collect.t2
    SortedMap<R, Map<C, V>> rowMap();
}
