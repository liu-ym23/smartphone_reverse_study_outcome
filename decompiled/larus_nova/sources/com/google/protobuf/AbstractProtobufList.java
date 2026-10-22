package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes23.dex */
abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    private boolean isMutable;

    @Override // com.google.protobuf.Internal.ProtobufList
    public final void makeImmutable() {
        this.isMutable = false;
    }

    public void ensureIsMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public AbstractProtobufList() {
        this.isMutable = true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r100 = size();
        int r101 = 1;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = (r101 * 31) + get(r102).hashCode();
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public boolean isModifiable() {
        return this.isMutable;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        ensureIsMutable();
        return super.add(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r100) {
        ensureIsMutable();
        return super.addAll(r100);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof List) == true) goto L9;
        return false;
    L9:
        if ((r100 instanceof RandomAccess) == false) goto L11;
        List r101 = (List) r100;
        int r102 = size();
        if (r102 == r101.size()) goto L15;
        return false;
    L15:
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L21;
        if (get(r103).equals(ListProtector.get(r101, r103)) == false) goto L19;
        r103 = r103 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L11:
        return super.equals(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r100) {
        ensureIsMutable();
        return (E) super.remove(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r100) {
        ensureIsMutable();
        return super.removeAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r100) {
        ensureIsMutable();
        return super.retainAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        ensureIsMutable();
        return super.remove(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        ensureIsMutable();
        super.add(r100, r101);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends E> r101) {
        ensureIsMutable();
        return super.addAll(r100, r101);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        ensureIsMutable();
        return (E) super.set(r100, r101);
    }
}
