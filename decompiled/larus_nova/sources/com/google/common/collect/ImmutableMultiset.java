package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements y1<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableList<E> f275089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSet<y1.a<E>> f275090c;

    public final class EntrySet extends IndexedImmutableSet<y1.a<E>> {
        private static final long serialVersionUID = 0;
        final /* synthetic */ ImmutableMultiset this$0;

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(this.this$0);
        }

        private void readObject(ObjectInputStream r100) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof y1.a) == false) goto L11;
            y1.a r101 = (y1.a) r100;
            if (r101.getCount() > 0) goto L8;
            return false;
        L8:
            if (this.this$0.count(r101.getElement()) != r101.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public y1.a<E> get(int r100) {
            return this.this$0.getEntry(r100);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        public EntrySet(ImmutableMultiset r100, a r101) {
            this.this$0 = r100;
        }
    }

    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public Object readResolve() {
            return this.multiset.entrySet();
        }

        public EntrySetSerializedForm(ImmutableMultiset<E> r100) {
            this.multiset = r100;
        }
    }

    public class a extends z2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f275091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public E f275092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f275093c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275091a <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.f275093c.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public final E next() {
            if (this.f275091a > 0) goto L5;
            y1.a r100 = (y1.a) this.f275093c.next();
            this.f275092b = (E) r100.getElement();
            this.f275091a = r100.getCount();
        L5:
            this.f275091a--;
            E r101 = this.f275092b;
            Objects.requireNonNull(r101);
            return r101;
        }

        public a(z2 r100) {
            this.f275093c = r100;
        }
    }

    public static class b<E> extends ImmutableCollection.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public c2<E> f275094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f275095b;

        public ImmutableMultiset<E> f() {
            Objects.requireNonNull(this.f275094a);
            if (this.f275094a.f275440c == 0) goto L5;
            this.f275095b = true;
            return new RegularImmutableMultiset(this.f275094a);
        L5:
            return ImmutableMultiset.of();
        }

        public b(int r100) {
            this.f275095b = false;
            this.f275094a = new c2(r100, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ ImmutableCollection.b b(Object r100) {
            return c(r100);
        }

        public b<E> c(E r100) {
            return e(r100, 1);
        }

        public b<E> d(E... r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            b(r100[r102]);
            r102 = r102 + 1;
            goto L3
        L5:
            return this;
        }

        public b(Object r100) {
            this.f275095b = false;
            this.f275094a = null;
        }

        public b<E> e(E r100, int r101) {
            Objects.requireNonNull(this.f275094a);
            if (r101 != 0) goto L6;
            return this;
        L6:
            if (this.f275095b == false) goto L8;
            this.f275094a = new c2(this.f275094a);
        L8:
            this.f275095b = false;
            r100.getClass();
            c2<E> r102 = this.f275094a;
            r102.l(r100, r101 + r102.d(r100));
            return this;
        }
    }

    public abstract /* synthetic */ int count(@CheckForNull Object r100);

    public abstract ImmutableSet<E> elementSet();

    public abstract y1.a<E> getEntry(int r100);

    @Override // com.google.common.collect.ImmutableCollection
    abstract Object writeReplace();

    public static <E> b<E> builder() {
        return new b(4);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r100 = this.f275089b;
        if (r100 != null) goto L6;
        ImmutableList<E> r101 = super.asList();
        this.f275089b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.y1
    public ImmutableSet<y1.a<E>> entrySet() {
        ImmutableSet<y1.a<E>> r100 = this.f275090c;
        if (r100 == null) goto L5;
    L9:
        return r100;
    L5:
        if (isEmpty() == false) goto L7;
        r100 = ImmutableSet.of();
    L8:
        this.f275090c = r100;
        goto L9
    L7:
        r100 = new EntrySet(this, null);
        goto L8
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // java.util.Collection, com.google.common.collect.y1
    public int hashCode() {
        return Sets.c(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public z2<E> iterator() {
        return new a(entrySet().iterator());
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    public ImmutableMultiset() {
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public static <E> ImmutableMultiset<E> a(E... r100) {
        b r101 = new b(4);
        r101.d(r100);
        return r101.f();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends y1.a<? extends E>> r100) {
        c2 r101 = new c2(r100.size());
        Iterator<? extends y1.a<? extends E>> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L12;
        y1.a<? extends E> r103 = r102.next();
        E r104 = r103.getElement();
        int r105 = r103.getCount();
        Objects.requireNonNull(r101);
        if (r105 == 0) goto L5;
        if (0 == 0) goto L11;
        r101 = new c2(r101);
    L11:
        r104.getClass();
        r101.l(r104, r105 + r101.d(r104));
        goto L5
    L12:
        Objects.requireNonNull(r101);
        if (r101.f275440c != 0) goto L16;
        return of();
    L16:
        return new RegularImmutableMultiset(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> r100) {
        if ((r100 instanceof ImmutableMultiset) == false) goto L7;
        ImmutableMultiset<E> r101 = (ImmutableMultiset) r100;
        if (r101.isPartialView() == true) goto L7;
        return r101;
    L7:
        b r102 = new b(Multisets.c(r100));
        Objects.requireNonNull(r102.f275094a);
        if ((r100 instanceof y1) == false) goto L24;
        y1 r103 = (y1) r100;
        if ((r103 instanceof RegularImmutableMultiset) == false) goto L13;
        c2<E> r104 = ((RegularImmutableMultiset) r103).contents;
    L16:
        if (r104 == null) goto L20;
        c2<E> r105 = r102.f275094a;
        r105.b(Math.max(r105.f275440c, r104.f275440c));
        int r106 = r104.c();
    L18:
        if (r106 < 0) goto L29;
        com.google.common.base.m.j(r106, r104.f275440c);
        r102.e(r104.f275438a[r106], r104.e(r106));
        r106 = r104.j(r106);
    L29:
        return r102.f();
    L20:
        Set<y1.a<E>> r107 = r103.entrySet();
        c2<E> r108 = r102.f275094a;
        r108.b(Math.max(r108.f275440c, r107.size()));
        Iterator<y1.a<E>> r109 = r103.entrySet().iterator();
    L22:
        if (r109.hasNext() == false) goto L29;
        y1.a<E> r110 = r109.next();
        r102.e(r110.getElement(), r110.getCount());
        goto L22
    L13:
        if ((r103 instanceof AbstractMapBasedMultiset) == false) goto L15;
        r104 = ((AbstractMapBasedMultiset) r103).backingMap;
        goto L16
    L15:
        r104 = null;
        goto L16
    L24:
        Iterator<? extends E> r111 = r100.iterator();
    L26:
        if (r111.hasNext() == false) goto L29;
        r102.c(r111.next());
        goto L26
    }

    public static <E> ImmutableMultiset<E> of(E r100) {
        return a(new Object[]{r100});
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        if (count(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, com.google.common.collect.y1
    public boolean equals(@CheckForNull Object r100) {
        return Multisets.b(this, r100);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> r100) {
        b r101 = new b(4);
    L4:
        if (r100.hasNext() == false) goto L7;
        r101.b(r100.next());
        goto L4
    L7:
        return r101.f();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] r100) {
        return a(r100);
    }

    public static <E> ImmutableMultiset<E> of(E r100, E r101) {
        return a(new Object[]{r100, r101});
    }

    @Override // com.google.common.collect.y1
    public final int add(E r100, int r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r100, int r101) {
        z2<y1.a<E>> r102 = entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        y1.a<E> r103 = r102.next();
        Arrays.fill(r100, r101, r103.getCount() + r101, r103.getElement());
        r101 = r101 + r103.getCount();
        goto L4
    L6:
        return r101;
    }

    @Override // com.google.common.collect.y1
    public final int remove(@CheckForNull Object r100, int r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y1
    public final int setCount(E r100, int r101) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E r100, E r101, E r102) {
        return a(new Object[]{r100, r101, r102});
    }

    @Override // com.google.common.collect.y1
    public final boolean setCount(E r100, int r101, int r102) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E r100, E r101, E r102, E r103) {
        return a(new Object[]{r100, r101, r102, r103});
    }

    public static <E> ImmutableMultiset<E> of(E r100, E r101, E r102, E r103, E r104) {
        return a(new Object[]{r100, r101, r102, r103, r104});
    }

    public static <E> ImmutableMultiset<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E... r106) {
        b r107 = new b(4);
        r107.e(r100, 1);
        return r107.c(r101).c(r102).c(r103).c(r104).c(r105).d(r106).f();
    }
}
