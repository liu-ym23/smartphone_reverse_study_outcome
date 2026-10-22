package com.google.common.collect;

import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class l0<K, V> extends o0 implements Map.Entry<K, V> {
    public abstract Map.Entry<K, V> e();

    @Override // java.util.Map.Entry
    @ParametricNullness
    public final K getKey() {
        return e().getKey();
    }

    @Override // java.util.Map.Entry
    @ParametricNullness
    public V getValue() {
        return e().getValue();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return e().hashCode();
    }

    public l0() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(@CheckForNull Object r100) {
        return e().equals(r100);
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V r100) {
        return e().setValue(r100);
    }
}
