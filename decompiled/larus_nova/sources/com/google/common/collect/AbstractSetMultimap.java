package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements k2<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract Set<V> createCollection();

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

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    public AbstractSetMultimap(Map<K, Collection<V>> r100) {
        super(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public Set<V> get(@ParametricNullness K r100) {
        return (Set) super.get(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public Set<V> removeAll(@CheckForNull Object r100) {
        return (Set) super.removeAll(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r100) {
        return Collections.unmodifiableSet((Set) r100);
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
    public Set<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
        return (Set) super.replaceValues(r100, r101);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(@ParametricNullness K r100, Collection<V> r101) {
        return new AbstractMapBasedMultimap.n(this, r100, (Set) r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }
}
