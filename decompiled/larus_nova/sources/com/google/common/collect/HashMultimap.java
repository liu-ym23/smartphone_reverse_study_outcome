package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private HashMultimap() {
        this(12, 2);
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return CompactHashSet.createWithExpectedSize(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ y1 keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    public HashMultimap(q1<? extends K, ? extends V> r100) {
        super(CompactHashMap.createWithExpectedSize(r100.keySet().size()));
        this.expectedValuesPerKey = 2;
        putAll(r100);
    }

    public static <K, V> HashMultimap<K, V> create(q1<? extends K, ? extends V> r100) {
        return new HashMultimap(r100);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int r101 = r100.readInt();
        setMap(CompactHashMap.createWithExpectedSize(12));
        j2.c(this, r100, r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        j2.f(this, r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object r100) {
        return super.containsKey(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object r100) {
        return super.containsValue(r100);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object r100) {
        return super.get(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean putAll(q1 r100) {
        return super.putAll(r100);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object r100) {
        return super.removeAll(r100);
    }

    public HashMultimap(int r100, int r101) {
        super(CompactHashMap.createWithExpectedSize(r100));
        this.expectedValuesPerKey = 2;
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.b(r102);
        this.expectedValuesPerKey = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static <K, V> HashMultimap<K, V> create(int r100, int r101) {
        return new HashMultimap(r100, r101);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.containsEntry(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean put(@ParametricNullness Object r100, @ParametricNullness Object r101) {
        return super.put(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object r100, Iterable r101) {
        return super.putAll(r100, r101);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        return super.remove(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set replaceValues(@ParametricNullness Object r100, Iterable r101) {
        return super.replaceValues(r100, r101);
    }
}
