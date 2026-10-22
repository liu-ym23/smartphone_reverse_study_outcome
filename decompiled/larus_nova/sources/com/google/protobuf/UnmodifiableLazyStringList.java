package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes23.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new AnonymousClass2(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public UnmodifiableLazyStringList(LazyStringList r100) {
        this.list = r100;
    }

    public static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList r100) {
        return r100.list;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r100) {
        return this.list.get(r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r100) {
        return this.list.getByteArray(r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r100) {
        return this.list.getByteString(r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r100) {
        return this.list.getRaw(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(final int r100) {
        return new AnonymousClass1(this, r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r100, ByteString r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r100, byte[] r101) {
        throw new UnsupportedOperationException();
    }
}
