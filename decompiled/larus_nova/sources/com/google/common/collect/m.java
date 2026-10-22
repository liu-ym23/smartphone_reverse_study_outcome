package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface m<K, V> extends Map<K, V> {
    @CheckForNull
    V forcePut(@ParametricNullness K r100, @ParametricNullness V r101);

    m<V, K> inverse();

    Set<V> values();
}
