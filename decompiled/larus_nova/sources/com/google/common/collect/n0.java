package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class n0<E> extends f0<E> implements y1<E> {
    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public abstract y1<E> delegate();

    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<y1.a<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.y1
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.f0
    public void standardClear() {
        Iterators.b(entrySet().iterator());
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.d(this);
    }

    public int standardSize() {
        return Multisets.e(this);
    }

    @Override // com.google.common.collect.f0
    public String standardToString() {
        return entrySet().toString();
    }

    public n0() {
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y1
    public int count(@CheckForNull Object r100) {
        return delegate().count(r100);
    }

    @Override // java.util.Collection, com.google.common.collect.y1
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r100) == true) goto L7;
        return false;
    }

    public boolean standardAdd(@ParametricNullness E r100) {
        add(r100, 1);
        return true;
    }

    @Override // com.google.common.collect.f0
    public boolean standardAddAll(Collection<? extends E> r100) {
        return Multisets.a(this, r100);
    }

    @Override // com.google.common.collect.f0
    public boolean standardContains(@CheckForNull Object r100) {
        if (count(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int standardCount(@CheckForNull Object r100) {
        Iterator<y1.a<E>> r101 = entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        y1.a<E> r102 = r101.next();
        if (com.google.common.base.k.a(r102.getElement(), r100) == false) goto L4;
        return r102.getCount();
    L9:
        return 0;
    }

    public boolean standardEquals(@CheckForNull Object r100) {
        return Multisets.b(this, r100);
    }

    @Override // com.google.common.collect.f0
    public boolean standardRemove(@CheckForNull Object r100) {
        if (remove(r100, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.common.collect.f0
    public boolean standardRemoveAll(Collection<?> r100) {
        if ((r100 instanceof y1) == false) goto L6;
        r100 = ((y1) r100).elementSet();
    L6:
        return elementSet().removeAll(r100);
    }

    @Override // com.google.common.collect.f0
    public boolean standardRetainAll(Collection<?> r100) {
        r100.getClass();
        if ((r100 instanceof y1) == false) goto L6;
        r100 = ((y1) r100).elementSet();
    L6:
        return elementSet().retainAll(r100);
    }

    public int add(@ParametricNullness E r100, int r101) {
        return delegate().add(r100, r101);
    }

    public int remove(@CheckForNull Object r100, int r101) {
        return delegate().remove(r100, r101);
    }

    public int setCount(@ParametricNullness E r100, int r101) {
        return delegate().setCount(r100, r101);
    }

    public int standardSetCount(@ParametricNullness E r100, int r101) {
        o.b(r101, "count");
        int r102 = count(r100);
        int r103 = r101 - r102;
        if (r103 <= 0) goto L5;
        add(r100, r103);
    L7:
        return r102;
    L5:
        if (r103 >= 0) goto L7;
        remove(r100, -r103);
        goto L7
    }

    public boolean setCount(@ParametricNullness E r100, int r101, int r102) {
        return delegate().setCount(r100, r101, r102);
    }

    public boolean standardSetCount(@ParametricNullness E r100, int r101, int r102) {
        o.b(r101, "oldCount");
        o.b(r102, "newCount");
        if (count(r100) != r101) goto L5;
        setCount(r100, r102);
        return true;
    L5:
        return false;
    }
}
