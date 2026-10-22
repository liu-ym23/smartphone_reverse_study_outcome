package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements f1<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract List<V> createCollection();

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createUnmodifiableEmptyCollection() {
        return createUnmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    public AbstractListMultimap(Map<K, Collection<V>> r100) {
        super(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public List<V> get(@ParametricNullness K r100) {
        return (List) super.get(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public List<V> removeAll(@CheckForNull Object r100) {
        return (List) super.removeAll(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r100) {
        return Collections.unmodifiableList((List) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public boolean put(@ParametricNullness K r100, @ParametricNullness V r101) {
        return super.put(r100, r101);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public List<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
        return (List) super.replaceValues(r100, r101);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(@ParametricNullness K r100, Collection<V> r101) {
        return wrapList(r100, (List) r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }
}
