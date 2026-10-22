package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = null;
    final transient c2<E> contents;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f275314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableSet<E> f275315e;

    public final class ElementSet extends IndexedImmutableSet<E> {
        final /* synthetic */ RegularImmutableMultiset this$0;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.contents.f275440c;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            return this.this$0.contains(r100);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int r100) {
            c2<E> r101 = this.this$0.contents;
            com.google.common.base.m.j(r100, r101.f275440c);
            return (E) r101.f275438a[r100];
        }

        public ElementSet(RegularImmutableMultiset r100, a r101) {
            this.this$0 = r100;
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public Object readResolve() {
            c2 r100 = new c2(this.elements.length);
            int r101 = 0;
            boolean r102 = false;
        L3:
            Object[] r103 = this.elements;
            if (r101 >= r103.length) goto L12;
            Object r104 = r103[r101];
            int r105 = this.counts[r101];
            Objects.requireNonNull(r100);
            if (r105 == 0) goto L11;
            if (r102 == false) goto L10;
            r100 = new c2(r100);
        L10:
            r104.getClass();
            r100.l(r104, r105 + r100.d(r104));
            r102 = false;
        L11:
            r101 = r101 + 1;
            goto L3
        L12:
            Objects.requireNonNull(r100);
            if (r100.f275440c != 0) goto L16;
            return ImmutableMultiset.of();
        L16:
            return new RegularImmutableMultiset(r100);
        }

        public SerializedForm(y1<? extends Object> r100) {
            int r101 = r100.entrySet().size();
            this.elements = new Object[r101];
            this.counts = new int[r101];
            Iterator<y1.a<? extends Object>> r102 = r100.entrySet().iterator();
            int r103 = 0;
        L4:
            if (r102.hasNext() == false) goto L6;
            y1.a<? extends Object> r104 = r102.next();
            this.elements[r103] = r104.getElement();
            this.counts[r103] = r104.getCount();
            r103 = r103 + 1;
            goto L4
        }
    }

    public static /* synthetic */ class a {
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    static {
        EMPTY = new RegularImmutableMultiset(new c2());
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r100 = this.f275315e;
        if (r100 != null) goto L6;
        ElementSet r101 = new ElementSet(this, null);
        this.f275315e = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public int size() {
        return this.f275314d;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    public RegularImmutableMultiset(c2<E> r100) {
        this.contents = r100;
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.f275440c) goto L6;
        r101 = r101 + ((long) r100.e(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        this.f275314d = Ints.c(r101);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public int count(@CheckForNull Object r100) {
        return this.contents.d(r100);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public y1.a<E> getEntry(int r100) {
        c2<E> r101 = this.contents;
        com.google.common.base.m.j(r100, r101.f275440c);
        return new c2.a(r101, r100);
    }
}
