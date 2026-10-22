package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> {
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private final List<E> list;

    static {
        ProtobufArrayList<Object> r100 = new ProtobufArrayList();
        EMPTY_LIST = r100;
        r100.makeImmutable();
    }

    public ProtobufArrayList() {
        this(new ArrayList(10));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private ProtobufArrayList(List<E> r100) {
        this.list = r100;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r100) {
        return (E) ListProtector.get(this.list, r100);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int r100) {
        if (r100 < size()) goto L7;
        ArrayList r101 = new ArrayList(r100);
        r101.addAll(this.list);
        return new ProtobufArrayList(r101);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int r100) {
        ensureIsMutable();
        E r101 = (E) ListProtector.remove(this.list, r100);
        ((AbstractList) this).modCount++;
        return r101;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r100) {
        return mutableCopyWithCapacity(r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        ensureIsMutable();
        ListProtector.add(this.list, r100, r101);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        ensureIsMutable();
        E r102 = (E) ListProtector.set(this.list, r100, r101);
        ((AbstractList) this).modCount++;
        return r102;
    }
}
