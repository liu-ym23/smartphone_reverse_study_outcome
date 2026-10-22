package com.google.common.collect;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f275061b = null;

    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient ImmutableList<E> f275062c;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f275062c.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f275062c.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f275062c;
        }

        public ReverseImmutableList(ImmutableList<E> r100) {
            this.f275062c = r100;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            return this.f275062c.contains(r100);
        }

        @Override // java.util.List
        public E get(int r100) {
            com.google.common.base.m.j(r100, size());
            return this.f275062c.get((size() - 1) - r100);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            int r101 = this.f275062c.lastIndexOf(r100);
            if (r101 >= 0) goto L5;
            return -1;
        L5:
            return (size() - 1) - r101;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object r100) {
            int r101 = this.f275062c.indexOf(r100);
            if (r101 >= 0) goto L5;
            return -1;
        L5:
            return (size() - 1) - r101;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r100) {
            return super.listIterator(r100);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r100, int r101) {
            com.google.common.base.m.n(r100, r101, size());
            return this.f275062c.subList(size() - r101, size() - r100).reverse();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r100, int r101) {
            return subList(r100, r101);
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }

        public SerializedForm(Object[] r100) {
            this.elements = r100;
        }
    }

    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;
        final /* synthetic */ ImmutableList this$0;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection
        @CheckForNull
        public Object[] internalArray() {
            return this.this$0.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return (this.this$0.internalArrayStart() + this.offset) + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return this.this$0.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // java.util.List
        public E get(int r100) {
            com.google.common.base.m.j(r100, this.length);
            return this.this$0.get(r100 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r100) {
            return super.listIterator(r100);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r100, int r101) {
            com.google.common.base.m.n(r100, r101, this.length);
            ImmutableList r102 = this.this$0;
            int r103 = this.offset;
            return r102.subList(r100 + r103, r101 + r103);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r100, int r101) {
            return subList(r100, r101);
        }

        public SubList(ImmutableList r100, int r101, int r102) {
            this.this$0 = r100;
            this.offset = r101;
            this.length = r102;
        }
    }

    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            super(4);
        }

        public final ImmutableList<E> e() {
            this.f275057c = true;
            return ImmutableList.asImmutableList(this.f275055a, this.f275056b);
        }

        public a(int r100) {
            super(r100);
        }

        public final ImmutableCollection.b d(Object r100) {
            b(r100);
            return this;
        }
    }

    public static class b<E> extends com.google.common.collect.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImmutableList<E> f275063c;

        @Override // com.google.common.collect.a
        public final E a(int r100) {
            return this.f275063c.get(r100);
        }

        public b(ImmutableList<E> r100, int r101) {
            super(r100.size(), r101);
            this.f275063c = r100;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // java.util.List
    public a3<E> listIterator() {
        return listIterator(0);
    }

    static {
        f275061b = new b(RegularImmutableList.EMPTY, 0);
    }

    public static <E> a<E> builder() {
        return new a();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int r100 = size();
        int r101 = 1;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = ~(~((r101 * 31) + get(r102).hashCode()));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public z2<E> iterator() {
        return listIterator();
    }

    public ImmutableList<E> reverse() {
        if (size() > 1) goto L6;
        return this;
    L6:
        return new ReverseImmutableList(this);
    }

    public ImmutableList() {
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] r100) {
        return asImmutableList(r100, r100.length);
    }

    public static <E> a<E> builderWithExpectedSize(int r100) {
        o.b(r100, "expectedSize");
        return new a(r100);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> r100) {
        if (r100.hasNext() == false) goto L5;
        E r101 = r100.next();
        if (r100.hasNext() == false) goto L9;
        a r102 = new a();
        r102.b(r101);
    L12:
        if (r100.hasNext() == false) goto L15;
        r102.d(r100.next());
        goto L12
    L15:
        return r102.e();
    L9:
        return of(r101);
    L5:
        return of();
    }

    public static <E> ImmutableList<E> of(E r100) {
        Object[] r101 = {r100};
        b2.a(r101, 1);
        return asImmutableList(r101);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> r100) {
        Comparable[] r101 = new Comparable[0];
        if ((r100 instanceof Collection) == false) goto L5;
        Collection r102 = (Collection) r100;
    L6:
        Comparable[] r103 = (Comparable[]) r102.toArray(r101);
        b2.a(r103, r103.length);
        Arrays.sort(r103);
        return asImmutableList(r103);
    L5:
        r102 = Lists.c(r100.iterator());
        goto L6
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        if (indexOf(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof List) == false) goto L27;
        List r101 = (List) r100;
        int r102 = size();
        if (r102 != r101.size()) goto L27;
        if ((r101 instanceof RandomAccess) == false) goto L19;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L38;
        if (com.google.common.base.k.a(ListProtector.get(this, r103), ListProtector.get(r101, r103)) == false) goto L27;
        r103 = r103 + 1;
        goto L14
    L38:
        return true;
    L19:
        Iterator<E> r104 = iterator();
        Iterator<E> r105 = r101.iterator();
    L21:
        if (r104.hasNext() == false) goto L29;
        if (r105.hasNext() == false) goto L27;
        if (com.google.common.base.k.a(r104.next(), r105.next()) == true) goto L21;
    L29:
        return !r105.hasNext();
    L27:
        return false;
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object r100) {
        if (r100 == null) goto L14;
        int r101 = size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L15;
        if (r100.equals(ListProtector.get(this, r102)) == true) goto L11;
        r102 = r102 + 1;
        goto L6
    L11:
        return r102;
    L15:
        return -1;
    L14:
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object r100) {
        if (r100 == null) goto L14;
        int r101 = size() - 1;
    L6:
        if (r101 < 0) goto L15;
        if (r100.equals(ListProtector.get(this, r101)) == true) goto L11;
        r101 = r101 - 1;
        goto L6
    L11:
        return r101;
    L15:
        return -1;
    L14:
        return -1;
    }

    @Override // java.util.List
    public a3<E> listIterator(int r100) {
        com.google.common.base.m.m(r100, size());
        if (isEmpty() == false) goto L7;
        return f275061b;
    L7:
        return new b(this, r100);
    }

    @Override // java.util.List
    public final E remove(int r100) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> r100) {
        if ((r100 instanceof ImmutableCollection) == false) goto L8;
        ImmutableList<E> r101 = ((ImmutableCollection) r100).asList();
        if (r101.isPartialView() == true) goto L7;
        return r101;
    L7:
        return asImmutableList(r101.toArray());
    L8:
        Object[] r102 = r100.toArray();
        b2.a(r102, r102.length);
        return asImmutableList(r102);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r100) {
        return listIterator(r100);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> r100) {
        r100.getClass();
        if ((r100 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r100);
    L6:
        return copyOf(r100.iterator());
    }

    public static <E> ImmutableList<E> copyOf(E[] r100) {
        if (r100.length == 0) goto L7;
        Object[] r101 = (Object[]) r100.clone();
        b2.a(r101, r101.length);
        return asImmutableList(r101);
    L7:
        return of();
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] r100, int r101) {
        if (r101 != 0) goto L6;
        return of();
    L6:
        return new RegularImmutableList(r100, r101);
    }

    public static <E> ImmutableList<E> of(E r100, E r101) {
        Object[] r102 = {r100, r101};
        b2.a(r102, 2);
        return asImmutableList(r102);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> r100, Iterable<? extends E> r101) {
        r100.getClass();
        if ((r101 instanceof Collection) == false) goto L5;
        Collection r102 = (Collection) r101;
    L6:
        Object[] r103 = r102.toArray();
        b2.a(r103, r103.length);
        Arrays.sort(r103, r100);
        return asImmutableList(r103);
    L5:
        r102 = Lists.c(r101.iterator());
        goto L6
    }

    @Override // java.util.List
    public final void add(int r100, E r101) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends E> r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r100, int r101) {
        int r102 = size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r100[r101 + r103] = get(r103);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101 + r102;
    }

    @Override // java.util.List
    public final E set(int r100, E r101) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int r100, int r101) {
        com.google.common.base.m.n(r100, r101, size());
        int r102 = r101 - r100;
        if (r102 != size()) goto L5;
        return this;
    L5:
        if (r102 != 0) goto L9;
        return of();
    L9:
        return subListUnchecked(r100, r101);
    }

    public ImmutableList<E> subListUnchecked(int r100, int r101) {
        return new SubList(this, r100, r101 - r100);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int r100, int r101) {
        return subList(r100, r101);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102) {
        Object[] r103 = {r100, r101, r102};
        b2.a(r103, 3);
        return asImmutableList(r103);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103) {
        Object[] r104 = {r100, r101, r102, r103};
        b2.a(r104, 4);
        return asImmutableList(r104);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104) {
        Object[] r105 = {r100, r101, r102, r103, r104};
        b2.a(r105, 5);
        return asImmutableList(r105);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104, E r105) {
        Object[] r106 = {r100, r101, r102, r103, r104, r105};
        b2.a(r106, 6);
        return asImmutableList(r106);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E r106) {
        Object[] r107 = {r100, r101, r102, r103, r104, r105, r106};
        b2.a(r107, 7);
        return asImmutableList(r107);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E r106, E r110) {
        Object[] r107 = {r100, r101, r102, r103, r104, r105, r106, r110};
        b2.a(r107, 8);
        return asImmutableList(r107);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E r106, E r110, E r111) {
        Object[] r107 = {r100, r101, r102, r103, r104, r105, r106, r110, r111};
        b2.a(r107, 9);
        return asImmutableList(r107);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E r106, E r110, E r111, E r112) {
        Object[] r107 = {r100, r101, r102, r103, r104, r105, r106, r110, r111, r112};
        b2.a(r107, 10);
        return asImmutableList(r107);
    }

    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E r106, E r110, E r111, E r112, E r113) {
        Object[] r107 = {r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113};
        b2.a(r107, 11);
        return asImmutableList(r107);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E r100, E r101, E r102, E r103, E r110, E r111, E r112, E r113, E r114, E r115, E r116, E r117, E... r118) {
        if (r118.length > 2147483635) goto L5;
        boolean r104 = true;
    L6:
        com.google.common.base.m.c(r104, "the total number of elements must fit in an int");
        int r105 = r118.length + 12;
        Object[] r106 = new Object[r105];
        r106[0] = r100;
        r106[1] = r101;
        r106[2] = r102;
        r106[3] = r103;
        r106[4] = r110;
        r106[5] = r111;
        r106[6] = r112;
        r106[7] = r113;
        r106[8] = r114;
        r106[9] = r115;
        r106[10] = r116;
        r106[11] = r117;
        System.arraycopy(r118, 0, r106, 12, r118.length);
        b2.a(r106, r105);
        return asImmutableList(r106);
    L5:
        r104 = false;
        goto L6
    }
}
