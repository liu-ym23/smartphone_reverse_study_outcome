package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class ImmutableEntry<K, V> extends b<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @ParametricNullness
    final K key;

    @ParametricNullness
    final V value;

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final V setValue(@ParametricNullness V r100) {
        throw new UnsupportedOperationException();
    }

    public ImmutableEntry(@ParametricNullness K r100, @ParametricNullness V r101) {
        this.key = r100;
        this.value = r101;
    }
}
