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
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableList<E> f275112b;

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }

        public SerializedForm(Object[] r100) {
            this.elements = r100;
        }
    }

    public static class a<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @CheckForNull
        public Object[] f275113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275114e;

        public a() {
            super(4);
        }

        public ImmutableSet<E> f() {
            int r100 = this.f275056b;
            if (r100 == 0) goto L21;
            if (r100 != 1) goto L7;
            Object r101 = this.f275055a[0];
            Objects.requireNonNull(r101);
            return ImmutableSet.of(r101);
        L7:
            if (this.f275113d != null) goto L9;
        L15:
            ImmutableSet<E> r102 = ImmutableSet.access$100(this.f275056b, this.f275055a);
            this.f275056b = r102.size();
        L16:
            this.f275057c = true;
            this.f275113d = null;
            return r102;
        L9:
            if (ImmutableSet.chooseTableSize(r100) != this.f275113d.length) goto L15;
            if (ImmutableSet.access$000(this.f275056b, this.f275055a.length) == false) goto L13;
            Object[] r103 = Arrays.copyOf(this.f275055a, this.f275056b);
        L14:
            int r104 = this.f275114e;
            Object[] r105 = this.f275113d;
            r102 = new RegularImmutableSet(r103, r104, r105, r105.length - 1, this.f275056b);
            goto L16
        L13:
            r103 = this.f275055a;
            goto L14
        L21:
            return ImmutableSet.of();
        }

        public a(int r100) {
            super(r100);
            this.f275113d = new Object[ImmutableSet.chooseTableSize(r100)];
        }

        public a<E> d(E r100) {
            r100.getClass();
            if (this.f275113d == null) goto L14;
            int r101 = ImmutableSet.chooseTableSize(this.f275056b);
            Object[] r102 = this.f275113d;
            if (r101 > r102.length) goto L14;
            int r103 = r102.length - 1;
            int r104 = r100.hashCode();
            int r105 = u0.b(r104);
        L7:
            int r106 = r105 & r103;
            Object[] r107 = this.f275113d;
            Object r108 = r107[r106];
            if (r108 == null) goto L9;
            if (r108.equals(r100) == true) goto L12;
            r105 = r106 + 1;
        L12:
            return this;
        L9:
            r107[r106] = r100;
            this.f275114e += r104;
            b(r100);
        L14:
            this.f275113d = null;
            b(r100);
            return this;
        }

        public a<E> e(Iterator<? extends E> r100) {
            r100.getClass();
        L4:
            if (r100.hasNext() == false) goto L6;
            d(r100.next());
            goto L4
        L6:
            return this;
        }
    }

    public static boolean access$000(int r100, int r101) {
        if (r100 >= ((r101 >> 1) + (r101 >> 2))) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract z2<E> iterator();

    public static <E> a<E> builder() {
        return new a();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r100 = this.f275112b;
        if (r100 != null) goto L6;
        ImmutableList<E> r101 = createAsList();
        this.f275112b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.c(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public ImmutableSet() {
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> a<E> builderWithExpectedSize(int r100) {
        o.b(r100, "expectedSize");
        return new a(r100);
    }

    public static int chooseTableSize(int r100) {
        int r101 = Math.max(r100, 2);
        boolean r102 = true;
        if (r101 >= 751619276) goto L10;
        int r103 = Integer.highestOneBit(r101 - 1) << 1;
    L6:
        if ((((double) r103) * 0.7d) >= r101) goto L8;
        r103 = r103 << 1;
        goto L6
    L8:
        return r103;
    L10:
        if (r101 < 1073741824) goto L13;
        r102 = false;
    L13:
        com.google.common.base.m.c(r102, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> r100) {
        if (r100.hasNext() == false) goto L5;
        E r101 = r100.next();
        if (r100.hasNext() == false) goto L9;
        a r102 = new a();
        r102.d(r101);
        r102.e(r100);
        return r102.f();
    L9:
        return of(r101);
    L5:
        return of();
    }

    public static <E> ImmutableSet<E> of(E r100) {
        return new SingletonImmutableSet(r100);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableSet) == false) goto L16;
        if (isHashCodeFast() == false) goto L16;
        if (((ImmutableSet) r100).isHashCodeFast() == false) goto L16;
        if (hashCode() == r100.hashCode()) goto L16;
        return false;
    L16:
        return Sets.a(this, r100);
    }

    public static <E> ImmutableSet<E> copyOf(E[] r100) {
        int r101 = r100.length;
        if (r101 == 0) goto L11;
        if (r101 == 1) goto L9;
        return a(r100.length, (Object[]) r100.clone());
    L9:
        return of(r100[0]);
    L11:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> r100) {
        if ((r100 instanceof ImmutableSet) == true) goto L5;
    L9:
        Object[] r101 = r100.toArray();
        return a(r101.length, r101);
    L5:
        if ((r100 instanceof SortedSet) == true) goto L9;
        ImmutableSet<E> r102 = (ImmutableSet) r100;
        if (r102.isPartialView() == true) goto L9;
        return r102;
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> r100) {
        if ((r100 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r100);
    L6:
        return copyOf(r100.iterator());
    }

    public static <E> ImmutableSet<E> a(int r110, Object... r111) {
        if (r110 == 0) goto L37;
        boolean r100 = false;
        if (r110 == 1) goto L34;
        int r101 = chooseTableSize(r110);
        Object[] r102 = new Object[r101];
        int r103 = r101 - 1;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r104 >= r110) goto L19;
        Object r107 = r111[r104];
        if (r107 == null) goto L18;
        int r108 = r107.hashCode();
        int r112 = u0.b(r108);
    L10:
        int r113 = r112 & r103;
        Object r114 = r102[r113];
        if (r114 == null) goto L12;
        if (r114.equals(r107) == true) goto L15;
        r112 = r112 + 1;
    L15:
        r104 = r104 + 1;
        goto L6
    L12:
        r111[r106] = r107;
        r102[r113] = r107;
        r105 = r105 + r108;
        r106 = r106 + 1;
        goto L15
    L18:
        throw new NullPointerException("at index " + r104);
    L19:
        Arrays.fill(r111, r106, r110, null);
        if (r106 != 1) goto L24;
        Object r115 = r111[0];
        Objects.requireNonNull(r115);
        return new SingletonImmutableSet(r115);
    L24:
        if (chooseTableSize(r106) < (r101 / 2)) goto L26;
        int r116 = r111.length;
        if (r106 >= ((r116 >> 1) + (r116 >> 2))) goto L30;
        r100 = true;
    L30:
        if (r100 == false) goto L33;
        r111 = Arrays.copyOf(r111, r106);
    L33:
        return new RegularImmutableSet(r111, r105, r102, r103, r106);
    L26:
        return a(r106, r111);
    L34:
        Object r117 = r111[0];
        Objects.requireNonNull(r117);
        return of(r117);
    L37:
        return of();
    }

    public static /* synthetic */ ImmutableSet access$100(int r100, Object[] r101) {
        return a(r100, r101);
    }

    public static <E> ImmutableSet<E> of(E r100, E r101) {
        return a(2, new Object[]{r100, r101});
    }

    public static <E> ImmutableSet<E> of(E r100, E r101, E r102) {
        return a(3, new Object[]{r100, r101, r102});
    }

    public static <E> ImmutableSet<E> of(E r100, E r101, E r102, E r103) {
        return a(4, new Object[]{r100, r101, r102, r103});
    }

    public static <E> ImmutableSet<E> of(E r100, E r101, E r102, E r103, E r104) {
        return a(5, new Object[]{r100, r101, r102, r103, r104});
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E r100, E r101, E r102, E r103, E r104, E r110, E... r111) {
        if (r111.length > 2147483641) goto L5;
        boolean r105 = true;
    L6:
        com.google.common.base.m.c(r105, "the total number of elements must fit in an int");
        int r106 = r111.length + 6;
        Object[] r107 = new Object[r106];
        r107[0] = r100;
        r107[1] = r101;
        r107[2] = r102;
        r107[3] = r103;
        r107[4] = r104;
        r107[5] = r110;
        System.arraycopy(r111, 0, r107, 6, r111.length);
        return a(r106, r107);
    L5:
        r105 = false;
        goto L6
    }
}
