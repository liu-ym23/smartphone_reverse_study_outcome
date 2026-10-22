package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    public static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        public Object readResolve() {
            return this.map.values();
        }

        public SerializedForm(ImmutableMap<?, V> r100) {
            this.map = r100;
        }
    }

    public class a extends z2<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z2<Map.Entry<K, V>> f275079a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f275079a.hasNext();
        }

        @Override // java.util.Iterator
        public final V next() {
            return this.f275079a.next().getValue();
        }

        public a(ImmutableMapValues r100) {
            this.f275079a = ImmutableMapValues.access$000(r100).entrySet().iterator();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> r100 = this.map.entrySet().asList();
        return new AnonymousClass2(this, r100);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public z2<V> iterator() {
        return new a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.map);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public ImmutableMapValues(ImmutableMap<K, V> r100) {
        this.map = r100;
    }

    public static /* synthetic */ ImmutableMap access$000(ImmutableMapValues r100) {
        return r100.map;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Iterators.c(iterator(), r100) == false) goto L6;
        return true;
    }
}
