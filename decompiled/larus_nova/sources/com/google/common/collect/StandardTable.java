package com.google.common.collect;

import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class StandardTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @GwtTransient
    final Map<R, Map<C, V>> backingMap;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    public transient d f275328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    public transient Map<R, Map<C, V>> f275329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public transient StandardTable<R, C, V>.e f275330e;

    @GwtTransient
    final com.google.common.base.t<? extends Map<C, V>> factory;

    public class a implements Iterator<t2.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f275331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public Map.Entry<R, Map<C, V>> f275332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f275333c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275331a.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f275333c.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f275333c.hasNext() == true) goto L5;
            Map.Entry<R, Map<C, V>> r100 = this.f275331a.next();
            this.f275332b = r100;
            this.f275333c = r100.getValue().entrySet().iterator();
        L5:
            Objects.requireNonNull(this.f275332b);
            Map.Entry<C, V> r101 = this.f275333c.next();
            R r102 = this.f275332b.getKey();
            C r103 = r101.getKey();
            V r104 = r101.getValue();
            Tables.a r105 = Tables.f275364a;
            return new Tables.ImmutableCell(r102, r103, r104);
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f275333c.remove();
            Map.Entry<R, Map<C, V>> r100 = this.f275332b;
            Objects.requireNonNull(r100);
            if (r100.getValue().isEmpty() == false) goto L6;
            this.f275331a.remove();
            this.f275332b = null;
            return;
        }

        public a(StandardTable r100) {
            this.f275331a = r100.backingMap.entrySet().iterator();
            this.f275333c = Iterators.EmptyModifiableIterator.INSTANCE;
        }
    }

    public class b extends Maps.q<R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f275334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ StandardTable f275335e;

        public class a extends Sets.c<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f275336a;

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final void clear() {
                this.f275336a.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean isEmpty() {
                b r100 = this.f275336a;
                return !r100.f275335e.containsColumn(r100.f275334d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<R, V>> iterator() {
                return new C3853b(this.f275336a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                Iterator<Map<C, V>> r100 = this.f275336a.f275335e.backingMap.values().iterator();
                int r101 = 0;
            L4:
                if (r100.hasNext() == false) goto L8;
                if (r100.next().containsKey(this.f275336a.f275334d) == false) goto L4;
                r101 = r101 + 1;
                goto L4
            L8:
                return r101;
            }

            public a(b r100) {
                this.f275336a = r100;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object r100) {
                if ((r100 instanceof Map.Entry) == false) goto L6;
                Map.Entry r101 = (Map.Entry) r100;
                return StandardTable.access$300(this.f275336a.f275335e, r101.getKey(), this.f275336a.f275334d, r101.getValue());
            L6:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if ((r100 instanceof Map.Entry) == false) goto L6;
                Map.Entry r101 = (Map.Entry) r100;
                return StandardTable.access$400(this.f275336a.f275335e, r101.getKey(), this.f275336a.f275334d, r101.getValue());
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                return this.f275336a.d(Predicates.h(Predicates.f(r100)));
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.StandardTable$b$b, reason: collision with other inner class name */
        public class C3853b extends AbstractIterator<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f275337c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b f275338d;

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public final Object a() {
            L3:
                if (this.f275337c.hasNext() == false) goto L7;
                Map.Entry<R, Map<C, V>> r100 = this.f275337c.next();
                if (r100.getValue().containsKey(this.f275338d.f275334d) == false) goto L3;
                return new q2(this, r100);
            L7:
                this.f274902a = AbstractIterator.State.DONE;
                return null;
            }

            public C3853b(b r100) {
                this.f275338d = r100;
                this.f275337c = r100.f275335e.backingMap.entrySet().iterator();
            }
        }

        public class c extends Maps.i<R, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f275339b;

            public c(b r100) {
                this.f275339b = r100;
                super(r100);
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object r100) {
                b r101 = this.f275339b;
                return r101.f275335e.contains(r100, r101.f275334d);
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                b r101 = this.f275339b;
                if (r101.f275335e.remove(r100, r101.f275334d) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                return this.f275339b.d(Maps.f(Predicates.h(Predicates.f(r100))));
            }
        }

        public class d extends Maps.p<R, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f275340b;

            public d(b r100) {
                this.f275340b = r100;
                super(r100);
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean remove(@CheckForNull Object r100) {
                if (r100 != null) goto L4;
            L6:
                return false;
            L4:
                if (this.f275340b.d(Maps.k(Predicates.e(r100))) == false) goto L6;
                return true;
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean removeAll(Collection<?> r100) {
                return this.f275340b.d(Maps.k(Predicates.f(r100)));
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean retainAll(Collection<?> r100) {
                return this.f275340b.d(Maps.k(Predicates.h(Predicates.f(r100))));
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<R, V>> a() {
            return new a(this);
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<R> b() {
            return new c(this);
        }

        @Override // com.google.common.collect.Maps.q
        public final Collection<V> c() {
            return new d(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return this.f275335e.contains(r100, this.f275334d);
        }

        public final boolean d(com.google.common.base.n<? super Map.Entry<R, V>> r100) {
            Iterator<Map.Entry<R, Map<C, V>>> r101 = this.f275335e.backingMap.entrySet().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L13;
            Map.Entry<R, Map<C, V>> r103 = r101.next();
            Map<C, V> r104 = r103.getValue();
            V r105 = r104.get(this.f275334d);
            if (r105 == null) goto L4;
            if (r100.apply(new ImmutableEntry(r103.getKey(), r105)) == false) goto L4;
            r104.remove(this.f275334d);
            if (r104.isEmpty() == false) goto L12;
            r101.remove();
        L12:
            r102 = true;
            goto L4
        L13:
            return r102;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V get(@CheckForNull Object r100) {
            return (V) this.f275335e.get(r100, this.f275334d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V remove(@CheckForNull Object r100) {
            return (V) this.f275335e.remove(r100, this.f275334d);
        }

        public b(StandardTable r100, C r101) {
            this.f275335e = r100;
            r101.getClass();
            this.f275334d = r101;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V put(R r100, V r101) {
            return (V) this.f275335e.put(r100, this.f275334d, r101);
        }
    }

    public class c extends AbstractIterator<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<C, V> f275341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Iterator<Map<C, V>> f275342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f275343e;

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public final C a() {
        L3:
            if (this.f275343e.hasNext() == true) goto L4;
            if (this.f275342d.hasNext() == false) goto L11;
            this.f275343e = this.f275342d.next().entrySet().iterator();
            goto L3
        L11:
            this.f274902a = AbstractIterator.State.DONE;
            return null;
        L4:
            Map.Entry<C, V> r100 = this.f275343e.next();
            if (this.f275341c.containsKey(r100.getKey()) == true) goto L3;
            this.f275341c.put(r100.getKey(), r100.getValue());
            return r100.getKey();
        }

        public c(StandardTable r100) {
            this.f275341c = r100.factory.get();
            this.f275342d = r100.backingMap.values().iterator();
            this.f275343e = Iterators.b.f275137e;
        }
    }

    public class d extends StandardTable<R, C, V>.h<C> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StandardTable f275344b;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<C> iterator() {
            return this.f275344b.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return Iterators.h(iterator());
        }

        public d(StandardTable r100) {
            this.f275344b = r100;
            super(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object r100) {
            return this.f275344b.containsColumn(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object r100) {
            boolean r101 = false;
            if (r100 != null) goto L5;
            return false;
        L5:
            Iterator<Map<C, V>> r102 = this.f275344b.backingMap.values().iterator();
        L7:
            if (r102.hasNext() == false) goto L14;
            Map<C, V> r103 = r102.next();
            if (r103.keySet().remove(r100) == false) goto L7;
            if (r103.isEmpty() == false) goto L13;
            r102.remove();
        L13:
            r101 = true;
            goto L7
        L14:
            return r101;
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> r100) {
            r100.getClass();
            Iterator<Map<C, V>> r101 = this.f275344b.backingMap.values().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L11;
            Map<C, V> r103 = r101.next();
            if (Iterators.g(r103.keySet().iterator(), r100) == false) goto L4;
            if (r103.isEmpty() == false) goto L10;
            r101.remove();
        L10:
            r102 = true;
            goto L4
        L11:
            return r102;
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection<?> r100) {
            r100.getClass();
            Iterator<Map<C, V>> r101 = this.f275344b.backingMap.values().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L11;
            Map<C, V> r103 = r101.next();
            if (r103.keySet().retainAll(r100) == false) goto L4;
            if (r103.isEmpty() == false) goto L10;
            r101.remove();
        L10:
            r102 = true;
            goto L4
        L11:
            return r102;
        }
    }

    public class e extends Maps.q<C, Map<R, V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ StandardTable f275345d;

        public class a extends StandardTable<R, C, V>.h<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f275346b;

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$e$a$a, reason: collision with other inner class name */
            public class C3854a implements com.google.common.base.g<C, Map<R, V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f275347a;

                public C3854a(a r100) {
                    this.f275347a = r100;
                }

                @Override // com.google.common.base.g
                public final Object apply(Object r100) {
                    return this.f275347a.f275346b.f275345d.column(r100);
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                Set<C> r100 = this.f275346b.f275345d.columnKeySet();
                C3854a r101 = new C3854a(this);
                return new k1(r100.iterator(), r101);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return this.f275346b.f275345d.columnKeySet().size();
            }

            public a(e r100) {
                this.f275346b = r100;
                super(r100.f275345d);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object r100) {
                if ((r100 instanceof Map.Entry) == false) goto L12;
                Map.Entry r101 = (Map.Entry) r100;
                if (this.f275346b.f275345d.containsColumn(r101.getKey()) == false) goto L14;
                e r102 = this.f275346b;
                Object r103 = r101.getKey();
                if (r102.f275345d.containsColumn(r103) == false) goto L9;
                StandardTable r104 = r102.f275345d;
                Objects.requireNonNull(r103);
                Map r105 = r104.column(r103);
            L10:
                Objects.requireNonNull(r105);
                return r105.equals(r101.getValue());
            L9:
                r105 = null;
                goto L10
            L14:
                return false;
            L12:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if (contains(r100) == true) goto L5;
                return false;
            L5:
                if ((r100 instanceof Map.Entry) == false) goto L10;
                StandardTable.access$900(this.f275346b.f275345d, ((Map.Entry) r100).getKey());
                return true;
            L10:
                return false;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection<?> r100) {
                r100.getClass();
                return Sets.e(this, r100.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> r100) {
                r100.getClass();
                Iterator r101 = Lists.c(this.f275346b.f275345d.columnKeySet().iterator()).iterator();
                boolean r102 = false;
            L4:
                if (r101.hasNext() == false) goto L8;
                Object r103 = r101.next();
                if (r100.contains(new ImmutableEntry(r103, this.f275346b.f275345d.column(r103))) == true) goto L4;
                StandardTable.access$900(this.f275346b.f275345d, r103);
                r102 = true;
                goto L4
            L8:
                return r102;
            }
        }

        public class b extends Maps.p<C, Map<R, V>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f275348b;

            public b(e r100) {
                this.f275348b = r100;
                super(r100);
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean remove(@CheckForNull Object r100) {
                Iterator<Map.Entry<C, Map<R, V>>> r101 = this.f275348b.entrySet().iterator();
            L4:
                if (r101.hasNext() == false) goto L9;
                Map.Entry<C, Map<R, V>> r102 = r101.next();
                if (r102.getValue().equals(r100) == false) goto L4;
                StandardTable.access$900(this.f275348b.f275345d, r102.getKey());
                return true;
            L9:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean removeAll(Collection<?> r100) {
                r100.getClass();
                Iterator r101 = Lists.c(this.f275348b.f275345d.columnKeySet().iterator()).iterator();
                boolean r102 = false;
            L4:
                if (r101.hasNext() == false) goto L8;
                Object r103 = r101.next();
                if (r100.contains(this.f275348b.f275345d.column(r103)) == false) goto L4;
                StandardTable.access$900(this.f275348b.f275345d, r103);
                r102 = true;
                goto L4
            L8:
                return r102;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public final boolean retainAll(Collection<?> r100) {
                r100.getClass();
                Iterator r101 = Lists.c(this.f275348b.f275345d.columnKeySet().iterator()).iterator();
                boolean r102 = false;
            L4:
                if (r101.hasNext() == false) goto L8;
                Object r103 = r101.next();
                if (r100.contains(this.f275348b.f275345d.column(r103)) == true) goto L4;
                StandardTable.access$900(this.f275348b.f275345d, r103);
                r102 = true;
                goto L4
            L8:
                return r102;
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<C, Map<R, V>>> a() {
            return new a(this);
        }

        @Override // com.google.common.collect.Maps.q
        public final Collection<Map<R, V>> c() {
            return new b(this);
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public final Set<C> keySet() {
            return this.f275345d.columnKeySet();
        }

        public e(StandardTable r100) {
            this.f275345d = r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return this.f275345d.containsColumn(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object get(@CheckForNull Object r100) {
            if (this.f275345d.containsColumn(r100) == false) goto L5;
            StandardTable r101 = this.f275345d;
            Objects.requireNonNull(r100);
            return r101.column(r100);
        L5:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object remove(@CheckForNull Object r100) {
            if (this.f275345d.containsColumn(r100) == true) goto L7;
            return null;
        L7:
            return StandardTable.access$900(this.f275345d, r100);
        }
    }

    public class f extends Maps.h<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f275349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public Map<C, V> f275350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ StandardTable f275351c;

        public class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f275352a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f275353b;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f275352a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                f r100 = this.f275353b;
                Map.Entry r101 = (Map.Entry) this.f275352a.next();
                r100.getClass();
                return new r2(r101);
            }

            @Override // java.util.Iterator
            public final void remove() {
                this.f275352a.remove();
                this.f275353b.c();
            }

            public a(f r100, Iterator r101) {
                this.f275353b = r100;
                this.f275352a = r101;
            }
        }

        @CheckForNull
        public Map<C, V> b() {
            return this.f275351c.backingMap.get(this.f275349a);
        }

        public final void d() {
            Map<C, V> r100 = this.f275350b;
            if (r100 != null) goto L5;
        L8:
            this.f275350b = b();
            return;
        L5:
            if (r100.isEmpty() == true) goto L7;
            return;
        L7:
            if (this.f275351c.backingMap.containsKey(this.f275349a) == true) goto L8;
        }

        @Override // com.google.common.collect.Maps.h
        public final Iterator<Map.Entry<C, V>> a() {
            d();
            Map<C, V> r100 = this.f275350b;
            if (r100 != null) goto L7;
            return Iterators.EmptyModifiableIterator.INSTANCE;
        L7:
            return new a(this, r100.entrySet().iterator());
        }

        public void c() {
            d();
            Map<C, V> r100 = this.f275350b;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isEmpty() == false) goto L9;
            this.f275351c.backingMap.remove(this.f275349a);
            this.f275350b = null;
            return;
        }

        @Override // com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public final void clear() {
            d();
            Map<C, V> r100 = this.f275350b;
            if (r100 == null) goto L5;
            r100.clear();
        L5:
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            d();
            Map<C, V> r100 = this.f275350b;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r100) {
            d();
            if (r100 == null) goto L9;
            Map<C, V> r101 = this.f275350b;
            if (r101 == null) goto L9;
            if (Maps.g(r101, r100) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V get(@CheckForNull Object r100) {
            d();
            if (r100 == null) goto L7;
            Map<C, V> r101 = this.f275350b;
            if (r101 == null) goto L7;
            return (V) Maps.h(r101, r100);
        L7:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final V remove(@CheckForNull Object r100) {
            d();
            Map<C, V> r101 = this.f275350b;
            V r102 = null;
            if (r101 != null) goto L9;
            return null;
        L9:
            r102 = r101.remove(r100);     // Catch: Throwable -> L8
        L6:
            c();
            return r102;
        }

        public f(StandardTable r100, R r101) {
            this.f275351c = r100;
            r101.getClass();
            this.f275349a = r101;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(C r100, V r101) {
            r100.getClass();
            r101.getClass();
            Map<C, V> r102 = this.f275350b;
            if (r102 == null) goto L9;
            if (r102.isEmpty() == true) goto L9;
            return this.f275350b.put(r100, r101);
        L9:
            return (V) this.f275351c.put(this.f275349a, r100, r101);
        }
    }

    public class g extends Maps.q<R, Map<C, V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ StandardTable f275354d;

        public class a extends StandardTable<R, C, V>.h<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f275355b;

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$g$a$a, reason: collision with other inner class name */
            public class C3855a implements com.google.common.base.g<R, Map<C, V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f275356a;

                public C3855a(a r100) {
                    this.f275356a = r100;
                }

                @Override // com.google.common.base.g
                public final Object apply(Object r100) {
                    return this.f275356a.f275355b.f275354d.row(r100);
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                Set<R> r100 = this.f275355b.f275354d.backingMap.keySet();
                C3855a r101 = new C3855a(this);
                return new k1(r100.iterator(), r101);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return this.f275355b.f275354d.backingMap.size();
            }

            public a(g r100) {
                this.f275355b = r100;
                super(r100.f275354d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object r100) {
                if ((r100 instanceof Map.Entry) == false) goto L17;
                Map.Entry r101 = (Map.Entry) r100;
                if (r101.getKey() != null) goto L7;
                return false;
            L7:
                if ((r101.getValue() instanceof Map) == false) goto L19;
                Set<Map.Entry<R, Map<C, V>>> r102 = this.f275355b.f275354d.backingMap.entrySet();
                r102.getClass();
                boolean r103 = r102.contains(r101);     // Catch: Throwable -> L11
            L12:
                if (r103 == false) goto L20;
                return true;
            L20:
                return false;
            L11:
                r103 = false;
                goto L12
            L19:
                return false;
            L17:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object r100) {
                if ((r100 instanceof Map.Entry) == false) goto L12;
                Map.Entry r101 = (Map.Entry) r100;
                if (r101.getKey() != null) goto L7;
                return false;
            L7:
                if ((r101.getValue() instanceof Map) == true) goto L9;
                return false;
            L9:
                if (this.f275355b.f275354d.backingMap.entrySet().remove(r101) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
            }
        }

        @Override // com.google.common.collect.Maps.q
        public final Set<Map.Entry<R, Map<C, V>>> a() {
            return new a(this);
        }

        public g(StandardTable r100) {
            this.f275354d = r100;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object r100) {
            return this.f275354d.containsRow(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object get(@CheckForNull Object r100) {
            if (this.f275354d.containsRow(r100) == false) goto L5;
            StandardTable r101 = this.f275354d;
            Objects.requireNonNull(r100);
            return r101.row(r100);
        L5:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object remove(@CheckForNull Object r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            return this.f275354d.backingMap.remove(r100);
        }
    }

    public abstract class h<T> extends Sets.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StandardTable f275357a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.f275357a.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.f275357a.backingMap.isEmpty();
        }

        public h(StandardTable r100) {
            this.f275357a = r100;
        }
    }

    @Override // com.google.common.collect.i
    public Iterator<t2.a<R, C, V>> cellIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public Set<C> columnKeySet() {
        d r100 = this.f275328c;
        if (r100 != null) goto L6;
        d r101 = new d(this);
        this.f275328c = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.t2
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.e r100 = this.f275330e;
        if (r100 != null) goto L6;
        StandardTable<R, C, V>.e r101 = new e(this);
        this.f275330e = r101;
        return r101;
    L6:
        return r100;
    }

    public Iterator<C> createColumnKeyIterator() {
        return new c(this);
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new g(this);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.t2
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> r100 = this.f275329d;
        if (r100 != null) goto L6;
        Map<R, Map<C, V>> r101 = createRowMap();
        this.f275329d = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.t2
    public int size() {
        Iterator<Map<C, V>> r100 = this.backingMap.values().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().size();
        goto L4
    L6:
        return r101;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public Set<t2.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.t2
    public Map<R, V> column(C r100) {
        return new b(this, r100);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsColumn(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<Map<C, V>> r101 = this.backingMap.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (Maps.g(r101.next(), r100) == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsRow(@CheckForNull Object r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Maps.g(this.backingMap, r100) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean containsValue(@CheckForNull Object r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r100) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.t2
    public Map<C, V> row(R r100) {
        return new f(this, r100);
    }

    public StandardTable(Map<R, Map<C, V>> r100, com.google.common.base.t<? extends Map<C, V>> r101) {
        this.backingMap = r100;
        this.factory = r101;
    }

    public static Map access$900(StandardTable r100, Object r101) {
        r100.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> r103 = r100.backingMap.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<R, Map<C, V>> r104 = r103.next();
        V r105 = r104.getValue().remove(r101);
        if (r105 == null) goto L4;
        r102.put(r104.getKey(), r105);
        if (r104.getValue().isEmpty() == false) goto L4;
        r103.remove();
        goto L4
    L10:
        return r102;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    public boolean contains(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        if (super.contains(r100, r101) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V get(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        return (V) super.get(r100, r101);
    L6:
        return null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V remove(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        Map r102 = (Map) Maps.h(this.backingMap, r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        V r103 = (V) r102.remove(r101);
        if (r102.isEmpty() == false) goto L12;
        this.backingMap.remove(r100);
    L12:
        return r103;
    L13:
        return null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.t2
    @CheckForNull
    public V put(R r100, C r101, V r102) {
        r100.getClass();
        r101.getClass();
        r102.getClass();
        Map<C, V> r103 = this.backingMap.get(r100);
        if (r103 != null) goto L6;
        r103 = this.factory.get();
        this.backingMap.put(r100, r103);
    L6:
        return r103.put(r101, r102);
    }

    public static boolean access$300(StandardTable r100, Object r101, Object r102, Object r103) {
        if (r103 != null) goto L4;
        r100.getClass();
    L7:
        return false;
    L4:
        if (r103.equals(r100.get(r101, r102)) == false) goto L7;
        return true;
    }

    public static boolean access$400(StandardTable r100, Object r101, Object r102, Object r103) {
        if (r103 != null) goto L5;
        r100.getClass();
    L8:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L11;
        r100.remove(r101, r102);
        return true;
    L11:
        return false;
    L5:
        if (r103.equals(r100.get(r101, r102)) == false) goto L8;
        r104 = true;
        goto L9
    }
}
