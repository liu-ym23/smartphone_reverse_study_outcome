package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
@ElementTypesAreNonnullByDefault
public interface t2<R, C, V> {

    public interface a<R, C, V> {
        @ParametricNullness
        C getColumnKey();

        @ParametricNullness
        R getRowKey();

        @ParametricNullness
        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(@ParametricNullness C r100);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@CheckForNull Object r100, @CheckForNull Object r101);

    boolean containsColumn(@CheckForNull Object r100);

    boolean containsRow(@CheckForNull Object r100);

    boolean containsValue(@CheckForNull Object r100);

    boolean equals(@CheckForNull Object r100);

    @CheckForNull
    V get(@CheckForNull Object r100, @CheckForNull Object r101);

    int hashCode();

    boolean isEmpty();

    @CheckForNull
    V put(@ParametricNullness R r100, @ParametricNullness C r101, @ParametricNullness V r102);

    void putAll(t2<? extends R, ? extends C, ? extends V> r100);

    @CheckForNull
    V remove(@CheckForNull Object r100, @CheckForNull Object r101);

    Map<C, V> row(@ParametricNullness R r100);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
