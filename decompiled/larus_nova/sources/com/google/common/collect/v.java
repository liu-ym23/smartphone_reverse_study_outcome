package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class v<K, V> extends com.google.common.collect.c<K, V> implements a0<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q1<K, V> f275519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.common.base.n<? super Map.Entry<K, V>> f275520g;

    public class a extends Maps.q<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v f275521d;

        /* JADX INFO: renamed from: com.google.common.collect.v$a$a, reason: collision with other inner class name */
        public class C3857a extends Maps.c<K, Collection<V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f275522a;

            /* JADX INFO: renamed from: com.google.common.collect.v$a$a$a, reason: collision with other inner class name */
            public class C3858a extends AbstractIterator<Map.Entry<K, Collection<V>>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final Iterator<Map.Entry<K, Collection<V>>> f275523c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ C3857a f275524d;

                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                public final Object a() {
                L3:
                    if (this.f275523c.hasNext() == false) goto L7;
                    Map.Entry<K, Collection<V>> r100 = this.f275523c.next();
                    K r101 = r100.getKey();
                    p.a r102 = v.b(r100.getValue(), new c(this.f275524d.f275522a.f275521d, r101));
                    if (r102.isEmpty() == true) goto L3;
                    return new ImmutableEntry(r101, r102);
                L7:
                    this.f274902a = AbstractIterator.State.DONE;
                    return null;
                }

                public C3858a(C3857a r100) {
                    this.f275524d = r100;
                    this.f275523c = r100.f275522a.f275521d.f275519f.asMap().entrySet().iterator();
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C3858a(this);
            }

            @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return Iterators.h(new C3858a(this));
            }

            @Override // com.google.common.collect.Maps.c
            public final Map<K, Collection<V>> a() {
                return this.f275522a;
            }

            public C3857a(a r100) {
                this.f275522a = r100;
            }

            @Override // com.google.common.collect.Maps.c, com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection<?> r100) {
                return this.f275522a.f275521d.e(Predicates.f(r100));
            }

            @Override // com.google.common.collect.Maps.c, com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                return this.f275522a.f275521d.e(Predicates.h(Predicates.f(r100)));
            }
        }

        public class b extends Maps.i<K, Collection<V>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f275525b;

            public b(a r100) {
                this.f275525b = r100;
                super(r100);
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if (this.f275525b.e(r100) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection<?> r100) {
                return this.f275525b.f275521d.e(Maps.f(Predicates.f(r100)));
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                return this.f275525b.f275521d.e(Maps.f(Predicates.h(Predicates.f(r100))));
            }
        }

        public class c extends Maps.p<K, Collection<V>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f275526b;

            public c(a r100) {
                this.f275526b = r100;
                super(r100);
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean remove(@CheckForNull Object r100) {
                if ((r100 instanceof Collection) == false) goto L17;
                Collection r101 = (Collection) r100;
                Iterator<Map.Entry<K, Collection<V>>> r102 = this.f275526b.f275521d.f275519f.asMap().entrySet().iterator();
            L6:
                if (r102.hasNext() == false) goto L26;
                Map.Entry<K, Collection<V>> r103 = r102.next();
                K r104 = r103.getKey();
                p.a r105 = v.b(r103.getValue(), new c(this.f275526b.f275521d, r104));
                if (r105.isEmpty() == true) goto L6;
                if (r101.equals(r105) == false) goto L6;
                if (r105.size() != r103.getValue().size()) goto L14;
                r102.remove();
                return true;
            L14:
                r105.clear();
                return true;
            L26:
                return false;
            L17:
                return false;
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean removeAll(Collection<?> r100) {
                return this.f275526b.f275521d.e(Maps.k(Predicates.f(r100)));
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean retainAll(Collection<?> r100) {
                return this.f275526b.f275521d.e(Maps.k(Predicates.h(Predicates.f(r100))));
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<K, Collection<V>>> a() {
            return new C3857a(this);
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<K> b() {
            return new b(this);
        }

        @Override // com.google.common.collect.Maps.q
        public final Collection<Collection<V>> c() {
            return new c(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f275521d.clear();
        }

        public a(v r100) {
            this.f275521d = r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            if (d(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @CheckForNull
        public final Collection<V> d(@CheckForNull Object r100) {
            Collection<V> r101 = this.f275521d.f275519f.asMap().get(r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            p.a r102 = v.b(r101, new c(this.f275521d, r100));
            if (r102.isEmpty() == false) goto L9;
            return null;
        L9:
            return r102;
        }

        @CheckForNull
        public final Collection<V> e(@CheckForNull Object r100) {
            Collection<V> r101 = this.f275521d.f275519f.asMap().get(r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            ArrayList r102 = new ArrayList();
            Iterator<V> r103 = r101.iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            V r104 = r103.next();
            if (this.f275521d.f275520g.apply(new ImmutableEntry(r100, r104)) == false) goto L7;
            r103.remove();
            r102.add(r104);
            goto L7
        L12:
            if (r102.isEmpty() == false) goto L15;
            return null;
        L15:
            if ((this.f275521d.f275519f instanceof k2) == false) goto L19;
            return Collections.unmodifiableSet(new LinkedHashSet(r102));
        L19:
            return Collections.unmodifiableList(r102);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final /* bridge */ /* synthetic */ Object get(@CheckForNull Object r100) {
            return d(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object r100) {
            return e(r100);
        }
    }

    public class b extends Multimaps.c<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v f275527d;

        public class a extends Multisets.c<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f275528a;

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<y1.a<K>> iterator() {
                return this.f275528a.entryIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return this.f275528a.f275527d.keySet().size();
            }

            @Override // com.google.common.collect.Multisets.c
            public final y1<K> a() {
                return this.f275528a;
            }

            public a(b r100) {
                this.f275528a = r100;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection<?> r100) {
                com.google.common.base.n r101 = Predicates.f(r100);
                return this.f275528a.f275527d.e(new w(r101));
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                com.google.common.base.n r101 = Predicates.h(Predicates.f(r100));
                return this.f275528a.f275527d.e(new w(r101));
            }
        }

        @Override // com.google.common.collect.d, com.google.common.collect.y1
        public final Set<y1.a<K>> entrySet() {
            return new a(this);
        }

        public b(v r100) {
            this.f275527d = r100;
            super(r100);
        }

        @Override // com.google.common.collect.Multimaps.c, com.google.common.collect.d, com.google.common.collect.y1
        public final int remove(@CheckForNull Object r100, int r101) {
            o.b(r101, "occurrences");
            if (r101 == 0) goto L5;
            Collection<V> r102 = this.f275527d.f275519f.asMap().get(r100);
            int r103 = 0;
            if (r102 != null) goto L9;
            return 0;
        L9:
            Iterator<V> r104 = r102.iterator();
        L11:
            if (r104.hasNext() == false) goto L17;
            V r105 = r104.next();
            if (this.f275527d.f275520g.apply(new ImmutableEntry(r100, r105)) == false) goto L11;
            r103 = r103 + 1;
            if (r103 > r101) goto L11;
            r104.remove();
            goto L11
        L17:
            return r103;
        L5:
            return count(r100);
        }
    }

    public final class c implements com.google.common.base.n<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f275529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f275530b;

        @Override // com.google.common.base.n
        public final boolean apply(@ParametricNullness V r100) {
            v r101 = this.f275530b;
            K r102 = this.f275529a;
            return r101.f275520g.apply(new ImmutableEntry(r102, r100));
        }

        public c(@ParametricNullness v r100, K r101) {
            this.f275530b = r100;
            this.f275529a = r101;
        }
    }

    @Override // com.google.common.collect.q1
    public final void clear() {
        ((x) this).entries().clear();
    }

    @Override // com.google.common.collect.q1
    public final int size() {
        return ((x) this).entries().size();
    }

    @Override // com.google.common.collect.c
    public final Map<K, Collection<V>> createAsMap() {
        return new a(this);
    }

    @Override // com.google.common.collect.c
    public final y1<K> createKeys() {
        return new b(this);
    }

    @Override // com.google.common.collect.c
    public final Collection<V> createValues() {
        return new b0(this);
    }

    @Override // com.google.common.collect.c
    public final Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    public final Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.a0
    public final com.google.common.base.n<? super Map.Entry<K, V>> c() {
        return this.f275520g;
    }

    @Override // com.google.common.collect.q1
    public final boolean containsKey(@CheckForNull Object r100) {
        if (asMap().get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(com.google.common.base.n<? super Map.Entry<K, Collection<V>>> r100) {
        Iterator<Map.Entry<K, Collection<V>>> r101 = this.f275519f.asMap().entrySet().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<K, Collection<V>> r103 = r101.next();
        K r104 = r103.getKey();
        p.a r105 = b(r103.getValue(), new c(this, r104));
        if (r105.isEmpty() == true) goto L4;
        if (r100.apply(new ImmutableEntry(r104, r105)) == false) goto L4;
        if (r105.size() != r103.getValue().size()) goto L12;
        r101.remove();
    L13:
        r102 = true;
        goto L4
    L12:
        r105.clear();
        goto L13
    L14:
        return r102;
    }

    public v(q1<K, V> r100, com.google.common.base.n<? super Map.Entry<K, V>> r101) {
        r100.getClass();
        this.f275519f = r100;
        this.f275520g = r101;
    }

    public static p.a b(Collection r100, c r101) {
        if ((r100 instanceof Set) == false) goto L7;
        return Sets.b((Set) r100, r101);
    L7:
        return p.b(r100, r101);
    }
}
