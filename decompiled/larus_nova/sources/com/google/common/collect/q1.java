package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
@ElementTypesAreNonnullByDefault
public interface q1<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101);

    boolean containsKey(@CheckForNull Object r100);

    boolean containsValue(@CheckForNull Object r100);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object r100);

    Collection<V> get(@ParametricNullness K r100);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    y1<K> keys();

    boolean put(@ParametricNullness K r100, @ParametricNullness V r101);

    boolean putAll(q1<? extends K, ? extends V> r100);

    boolean putAll(@ParametricNullness K r100, Iterable<? extends V> r101);

    boolean remove(@CheckForNull Object r100, @CheckForNull Object r101);

    Collection<V> removeAll(@CheckForNull Object r100);

    Collection<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101);

    int size();

    Collection<V> values();
}
