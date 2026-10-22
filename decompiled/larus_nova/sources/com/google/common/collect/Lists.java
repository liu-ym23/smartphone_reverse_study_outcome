package com.google.common.collect;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Lists {

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final E first;
        final E[] rest;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Ints.c(((long) this.rest.length) + ((long) 1));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int r100) {
            com.google.common.base.m.j(r100, size());
            if (r100 != 0) goto L6;
            return this.first;
        L6:
            return this.rest[r100 - 1];
        }

        public OnePlusArrayList(@ParametricNullness E r100, E[] r101) {
            this.first = r100;
            r101.getClass();
            this.rest = r101;
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        public StringAsImmutableList(String r100) {
            this.string = r100;
        }

        @Override // java.util.List
        public Character get(int r100) {
            com.google.common.base.m.j(r100, size());
            return Character.valueOf(this.string.charAt(r100));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return this.string.indexOf(((Character) r100).charValue());
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return this.string.lastIndexOf(((Character) r100).charValue());
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int r100, int r101) {
            com.google.common.base.m.n(r100, r101, size());
            String r102 = this.string.substring(r100, r101);
            r102.getClass();
            return new StringAsImmutableList(r102);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r100, int r101) {
            return subList(r100, r101);
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.g<? super F, ? extends T> function;

        public class a extends w2<F, T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TransformingRandomAccessList f275200b;

            @Override // com.google.common.collect.v2
            public final T a(F r100) {
                return this.f275200b.function.apply(r100);
            }

            public a(TransformingRandomAccessList r100, ListIterator r101) {
                this.f275200b = r100;
                super(r101);
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int r100) {
            return this.function.apply((Object) ListProtector.get(this.fromList, r100));
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r100) {
            return new a(this, this.fromList.listIterator(r100));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int r100) {
            return this.function.apply((Object) ListProtector.remove(this.fromList, r100));
        }

        public TransformingRandomAccessList(List<F> r100, com.google.common.base.g<? super F, ? extends T> r101) {
            r100.getClass();
            this.fromList = r100;
            r101.getClass();
            this.function = r101;
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.g<? super F, ? extends T> function;

        public class a extends w2<F, T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TransformingSequentialList f275201b;

            @Override // com.google.common.collect.v2
            @ParametricNullness
            public final T a(@ParametricNullness F r100) {
                return this.f275201b.function.apply(r100);
            }

            public a(TransformingSequentialList r100, ListIterator r101) {
                this.f275201b = r100;
                super(r101);
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r100) {
            return new a(this, this.fromList.listIterator(r100));
        }

        public TransformingSequentialList(List<F> r100, com.google.common.base.g<? super F, ? extends T> r101) {
            r100.getClass();
            this.fromList = r100;
            r101.getClass();
            this.function = r101;
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final E first;
        final E[] rest;

        @ParametricNullness
        final E second;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Ints.c(((long) this.rest.length) + ((long) 2));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            com.google.common.base.m.j(r100, size());
            return this.rest[r100 - 2];
        L8:
            return this.second;
        L10:
            return this.first;
        }

        public TwoPlusArrayList(@ParametricNullness E r100, @ParametricNullness E r101, E[] r102) {
            this.first = r100;
            this.second = r101;
            r102.getClass();
            this.rest = r102;
        }
    }

    public static <E> ArrayList<E> b(Iterable<? extends E> r100) {
        r100.getClass();
        if ((r100 instanceof Collection) == false) goto L6;
        return new ArrayList((Collection) r100);
    L6:
        return c(r100.iterator());
    }

    public static <E> ArrayList<E> c(Iterator<? extends E> r100) {
        ArrayList<E> r101 = new ArrayList();
        Iterators.a(r101, r100);
        return r101;
    }

    public static <E> ArrayList<E> d(int r100) {
        o.b(r100, "initialArraySize");
        return new ArrayList(r100);
    }

    public static <E> List<E> a(@ParametricNullness E r100, E[] r101) {
        return new OnePlusArrayList(r100, r101);
    }
}
