package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes23.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST = null;
    private long[] array;
    private int size;

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r100 = 1;
        int r101 = 0;
    L4:
        if (r101 >= this.size) goto L6;
        r100 = (r100 * 31) + Internal.hashLong(this.array[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    static {
        LongArrayList r100 = new LongArrayList();
        EMPTY_LIST = r100;
        r100.makeImmutable();
    }

    public LongArrayList() {
        this(new long[10], 0);
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private void ensureIndexInRange(int r100) {
        if (r100 < 0) goto L7;
        if (r100 >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r100));
    }

    private String makeOutOfBoundsExceptionMessage(int r100) {
        return "Index:" + r100 + ", Size:" + this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> r100) {
        ensureIsMutable();
        Internal.checkNotNull(r100);
        if ((r100 instanceof LongArrayList) == false) goto L5;
        LongArrayList r101 = (LongArrayList) r100;
        int r102 = r101.size;
        if (r102 != 0) goto L9;
        return false;
    L9:
        int r103 = this.size;
        if ((Integer.MAX_VALUE - r103) < r102) goto L17;
        int r104 = r103 + r102;
        long[] r105 = this.array;
        if (r104 <= r105.length) goto L14;
        this.array = Arrays.copyOf(r105, r104);
    L14:
        System.arraycopy(r101.array, 0, this.array, this.size, r101.size);
        this.size = r104;
        ((AbstractList) this).modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r100);
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long r100) {
        addLong(this.size, r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LongArrayList) == false) goto L8;
        LongArrayList r101 = (LongArrayList) r100;
        if (this.size == r101.size) goto L12;
        return false;
    L12:
        long[] r102 = r101.array;
        int r103 = 0;
    L14:
        if (r103 >= this.size) goto L19;
        if (this.array[r103] != r102[r103]) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int r100) {
        return Long.valueOf(getLong(r100));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int r100) {
        ensureIndexInRange(r100);
        return this.array[r100];
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Long> mutableCopyWithCapacity(int r100) {
        if (r100 < this.size) goto L7;
        return new LongArrayList(Arrays.copyOf(this.array, r100), this.size);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        ensureIsMutable();
        int r101 = 0;
    L4:
        if (r101 >= this.size) goto L10;
        if (r100.equals(Long.valueOf(this.array[r101])) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        long[] r102 = this.array;
        System.arraycopy(r102, r101 + 1, r102, r101, this.size - r101);
        this.size--;
        ((AbstractList) this).modCount++;
        return true;
    L10:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Long> mutableCopyWithCapacity2(int r100) {
        return mutableCopyWithCapacity(r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int r100) {
        ensureIsMutable();
        ensureIndexInRange(r100);
        long[] r101 = this.array;
        long r102 = r101[r100];
        System.arraycopy(r101, r100 + 1, r101, r100, this.size - r100);
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(r102);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r100) {
        return remove(r100);
    }

    private LongArrayList(long[] r100, int r101) {
        this.array = r100;
        this.size = r101;
    }

    private void addLong(int r100, long r101) {
        ensureIsMutable();
        if (r100 < 0) goto L13;
        int r102 = this.size;
        if (r100 > r102) goto L13;
        long[] r103 = this.array;
        if (r102 >= r103.length) goto L9;
        System.arraycopy(r103, r100, r103, r100 + 1, r102 - r100);
    L10:
        this.array[r100] = r101;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        long[] r104 = new long[((r102 * 3) / 2) + 1];
        System.arraycopy(r103, 0, r104, 0, r100);
        System.arraycopy(this.array, r100, r104, r100 + 1, this.size - r100);
        this.array = r104;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r100));
    }

    public void add(int r100, Long r101) {
        addLong(r100, r101.longValue());
    }

    public Long set(int r100, Long r101) {
        return Long.valueOf(setLong(r100, r101.longValue()));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int r100, long r101) {
        ensureIsMutable();
        ensureIndexInRange(r100);
        long[] r102 = this.array;
        long r103 = r102[r100];
        r102[r100] = r101;
        return r103;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
        add(r100, (Long) r101);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (Long) r101);
    }
}
