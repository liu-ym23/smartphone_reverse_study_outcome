package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class y<K, V> extends com.google.common.collect.c<K, V> implements a0<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q1<K, V> f275539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.common.base.n<? super K> f275540g;

    public static class a<K, V> extends j0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f275541a;

        @Override // com.google.common.collect.f0, com.google.common.collect.o0
        public final Object delegate() {
            return Collections.emptyList();
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection delegate() {
            return Collections.emptyList();
        }

        public a(@ParametricNullness K r100) {
            this.f275541a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Queue
        public final boolean add(@ParametricNullness V r100) {
            add(0, r100);
            throw null;
        }

        @Override // com.google.common.collect.f0, java.util.Collection
        public final boolean addAll(Collection<? extends V> r100) {
            addAll(0, r100);
            throw null;
        }

        @Override // java.util.List
        public final void add(int r100, @ParametricNullness V r101) {
            com.google.common.base.m.m(r100, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f275541a);
        }

        @Override // java.util.List
        public final boolean addAll(int r100, Collection<? extends V> r101) {
            r101.getClass();
            com.google.common.base.m.m(r100, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f275541a);
        }
    }

    public static class b<K, V> extends q0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f275542a;

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Object delegate() {
            return Collections.emptySet();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection delegate() {
            return Collections.emptySet();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public final Set<V> delegate() {
            return Collections.emptySet();
        }

        public b(@ParametricNullness K r100) {
            this.f275542a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Queue
        public final boolean add(@ParametricNullness V r100) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f275542a);
        }

        @Override // com.google.common.collect.f0, java.util.Collection
        public final boolean addAll(Collection<? extends V> r100) {
            r100.getClass();
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f275542a);
        }
    }

    public class c extends f0<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f275543a;

        @Override // com.google.common.collect.f0, com.google.common.collect.o0
        public final Collection<Map.Entry<K, V>> delegate() {
            return p.b(this.f275543a.f275539f.entries(), this.f275543a.c());
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.o0
        public final /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public c(y r100) {
            this.f275543a = r100;
        }

        @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            if (this.f275543a.f275539f.containsKey(r101.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.f275543a.f275540g.apply((Object) r101.getKey()) == true) goto L9;
            return false;
        L9:
            return this.f275543a.f275539f.remove(r101.getKey(), r101.getValue());
        L10:
            return false;
        }
    }

    @Override // com.google.common.collect.a0
    public final com.google.common.base.n<? super Map.Entry<K, V>> c() {
        return Maps.f(this.f275540g);
    }

    @Override // com.google.common.collect.c
    public final Map<K, Collection<V>> createAsMap() {
        Map<K, Collection<V>> r100 = this.f275539f.asMap();
        com.google.common.base.n<? super K> r101 = this.f275540g;
        r101.getClass();
        com.google.common.base.n r102 = Maps.f(r101);
        if ((r100 instanceof Maps.a) == false) goto L5;
        Maps.a r103 = (Maps.a) r100;
        return new Maps.e(r103.f275246d, Predicates.c(r103.f275247e, r102));
    L5:
        r100.getClass();
        return new Maps.f(r100, r101, r102);
    }

    @Override // com.google.common.collect.c
    public final Set<K> createKeySet() {
        return Sets.b(this.f275539f.keySet(), this.f275540g);
    }

    @Override // com.google.common.collect.c
    public final y1<K> createKeys() {
        y1<K> r100 = this.f275539f.keys();
        com.google.common.base.n<? super K> r101 = this.f275540g;
        if ((r100 instanceof Multisets.d) == false) goto L6;
        Multisets.d r102 = (Multisets.d) r100;
        com.google.common.base.n r103 = Predicates.c(r102.f275276d, r101);
        return new Multisets.d(r102.f275275c, r103);
    L6:
        return new Multisets.d(r100, r101);
    }

    @Override // com.google.common.collect.c
    public final Collection<V> createValues() {
        return new b0(this);
    }

    @Override // com.google.common.collect.c
    public final Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.q1
    public final void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.q1
    public final int size() {
        Iterator<Collection<V>> r100 = asMap().values().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().size();
        goto L4
    L6:
        return r101;
    }

    @Override // com.google.common.collect.q1
    public final boolean containsKey(@CheckForNull Object r100) {
        if (this.f275539f.containsKey(r100) == true) goto L5;
        return false;
    L5:
        return this.f275540g.apply(r100);
    }

    public y(q1<K, V> r100, com.google.common.base.n<? super K> r101) {
        r100.getClass();
        this.f275539f = r100;
        this.f275540g = r101;
    }
}
