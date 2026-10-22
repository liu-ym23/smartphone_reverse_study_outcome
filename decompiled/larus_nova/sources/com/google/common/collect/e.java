package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class e<K, V> extends Maps.h<K, V> implements NavigableMap<K, V> {

    public final class a extends Maps.b<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f275460d;

        public a(e r100) {
            this.f275460d = r100;
        }
    }

    public abstract Iterator<Map.Entry<K, V>> b();

    @Override // java.util.NavigableMap
    public final NavigableSet<K> descendingKeySet() {
        return new a(this).navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap<K, V> descendingMap() {
        return new a(this);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set<K> keySet() {
        return new Maps.j(this);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet<K> navigableKeySet() {
        return new Maps.j(this);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.d(a());
    }

    @Override // java.util.SortedMap
    @ParametricNullness
    public final K firstKey() {
        Map.Entry<K, V> r100 = firstEntry();
        if (r100 == null) goto L7;
        return r100.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.d(b());
    }

    @Override // java.util.SortedMap
    @ParametricNullness
    public final K lastKey() {
        Map.Entry<K, V> r100 = lastEntry();
        if (r100 == null) goto L7;
        return r100.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.f(a());
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.f(b());
    }

    public e() {
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> ceilingEntry(@ParametricNullness K r100) {
        return tailMap(r100, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final K ceilingKey(@ParametricNullness K r100) {
        return (K) Maps.e(ceilingEntry(r100));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> floorEntry(@ParametricNullness K r100) {
        return headMap(r100, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final K floorKey(@ParametricNullness K r100) {
        return (K) Maps.e(floorEntry(r100));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap<K, V> headMap(@ParametricNullness K r100) {
        return headMap(r100, false);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> higherEntry(@ParametricNullness K r100) {
        return tailMap(r100, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final K higherKey(@ParametricNullness K r100) {
        return (K) Maps.e(higherEntry(r100));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry<K, V> lowerEntry(@ParametricNullness K r100) {
        return headMap(r100, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final K lowerKey(@ParametricNullness K r100) {
        return (K) Maps.e(lowerEntry(r100));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap<K, V> tailMap(@ParametricNullness K r100) {
        return tailMap(r100, true);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap<K, V> subMap(@ParametricNullness K r100, @ParametricNullness K r101) {
        return subMap(r100, true, r101, false);
    }
}
