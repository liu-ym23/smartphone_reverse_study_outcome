package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    public static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, V> map;

        public Object readResolve() {
            return this.map.entrySet();
        }

        public EntrySetSerializedForm(ImmutableMap<K, V> r100) {
            this.map = r100;
        }
    }

    public static final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap<K, V> f275077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient ImmutableList<Map.Entry<K, V>> f275078d;

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public z2<Map.Entry<K, V>> iterator() {
            return this.f275078d.iterator();
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return this.f275078d;
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        public ImmutableMap<K, V> map() {
            return this.f275077c;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        public RegularEntrySet(ImmutableMap<K, V> r100, ImmutableList<Map.Entry<K, V>> r101) {
            this.f275077c = r100;
            this.f275078d = r101;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r100, int r101) {
            return this.f275078d.copyIntoArray(r100, r101);
        }

        public RegularEntrySet(ImmutableMap<K, V> r100, Map.Entry<K, V>[] r101) {
            this(r100, ImmutableList.asImmutableList(r101));
        }
    }

    public abstract ImmutableMap<K, V> map();

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EntrySetSerializedForm(map());
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return map().hashCode();
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return map().isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return map().size();
    }

    public ImmutableMapEntrySet() {
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        if ((r100 instanceof Map.Entry) == false) goto L10;
        Map.Entry r101 = (Map.Entry) r100;
        V r102 = map().get(r101.getKey());
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.equals(r101.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
