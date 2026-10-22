package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class f0<E> extends o0 implements Collection<E> {
    @Override // com.google.common.collect.o0
    public abstract Collection<E> delegate();

    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.b(iterator());
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        int r100 = size();
        o.b(r100, "size");
        StringBuilder r101 = new StringBuilder((int) Math.min(((long) r100) * 8, 1073741824));
        r101.append('[');
        Iterator<E> r102 = iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L12;
        E r104 = r102.next();
        if (r103 == true) goto L8;
        r101.append(", ");
    L8:
        if (r104 != this) goto L10;
        r101.append("(this Collection)");
    L11:
        r103 = false;
        goto L4
    L10:
        r101.append(r104);
        goto L11
    L12:
        r101.append(']');
        return r101.toString();
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public f0() {
    }

    public boolean add(@ParametricNullness E r100) {
        return delegate().add(r100);
    }

    public boolean addAll(Collection<? extends E> r100) {
        return delegate().addAll(r100);
    }

    public boolean contains(@CheckForNull Object r100) {
        return delegate().contains(r100);
    }

    public boolean containsAll(Collection<?> r100) {
        return delegate().containsAll(r100);
    }

    public boolean remove(@CheckForNull Object r100) {
        return delegate().remove(r100);
    }

    public boolean removeAll(Collection<?> r100) {
        return delegate().removeAll(r100);
    }

    public boolean retainAll(Collection<?> r100) {
        return delegate().retainAll(r100);
    }

    public boolean standardAddAll(Collection<? extends E> r100) {
        return Iterators.a(this, r100.iterator());
    }

    public boolean standardContains(@CheckForNull Object r100) {
        return Iterators.c(iterator(), r100);
    }

    public boolean standardContainsAll(Collection<?> r100) {
        return p.a(this, r100);
    }

    public boolean standardRemove(@CheckForNull Object r100) {
        Iterator<E> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (com.google.common.base.k.a(r101.next(), r100) == false) goto L4;
        r101.remove();
        return true;
    L9:
        return false;
    }

    public boolean standardRemoveAll(Collection<?> r100) {
        return Iterators.g(iterator(), r100);
    }

    public boolean standardRetainAll(Collection<?> r100) {
        Iterator<E> r101 = iterator();
        r100.getClass();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100.contains(r101.next()) == true) goto L4;
        r101.remove();
        r102 = true;
        goto L4
    L8:
        return r102;
    }

    public <T> T[] standardToArray(T[] r100) {
        return (T[]) b2.c(this, r100);
    }

    public <T> T[] toArray(T[] r100) {
        return (T[]) delegate().toArray(r100);
    }
}
