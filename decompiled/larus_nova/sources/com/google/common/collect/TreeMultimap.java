package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Comparator<? super K> f275372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient Comparator<? super V> f275373i;

    public TreeMultimap() {
        throw null;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap(Ordering.natural(), Ordering.natural());
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createCollection() {
        return new TreeSet(this.f275373i);
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
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

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
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

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public Comparator<? super K> keyComparator() {
        return this.f275372h;
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.p2
    public Comparator<? super V> valueComparator() {
        return this.f275373i;
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ SortedMap asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Set createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ SortedSet keySet() {
        return keySet();
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(q1<? extends K, ? extends V> r100) {
        TreeMultimap<K, V> r101 = new TreeMultimap(Ordering.natural(), Ordering.natural());
        r101.putAll(r100);
        return r101;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        Comparator<? super K> r101 = (Comparator) r100.readObject();
        r101.getClass();
        this.f275372h = r101;
        Comparator<? super V> r102 = (Comparator) r100.readObject();
        r102.getClass();
        this.f275373i = r102;
        setMap(new TreeMap(this.f275372h));
        j2.c(this, r100, r100.readInt());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(keyComparator());
        r100.writeObject(valueComparator());
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(@ParametricNullness K r100) {
        if (r100 != 0) goto L5;
        keyComparator().compare(r100, r100);
    L5:
        return super.createCollection(r100);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public NavigableSet<V> get(@ParametricNullness K r100) {
        return (NavigableSet) super.get(r100);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean putAll(q1 r100) {
        return super.putAll(r100);
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ SortedSet removeAll(@CheckForNull Object r100) {
        return super.removeAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
        return get(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object r100) {
        return get(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ SortedSet get(@ParametricNullness Object r100) {
        return get(r100);
    }

    public TreeMultimap(Comparator<? super K> r100, Comparator<? super V> r101) {
        super(new TreeMap(r100));
        this.f275372h = r100;
        this.f275373i = r101;
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> r100, Comparator<? super V> r101) {
        r100.getClass();
        r101.getClass();
        return new TreeMultimap(r100, r101);
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
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ SortedSet replaceValues(@ParametricNullness Object r100, Iterable r101) {
        return super.replaceValues(r100, r101);
    }
}
