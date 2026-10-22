package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes23.dex */
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST = null;
    private float[] array;
    private int size;

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r100 = 1;
        int r101 = 0;
    L4:
        if (r101 >= this.size) goto L6;
        r100 = (r100 * 31) + Float.floatToIntBits(this.array[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    static {
        FloatArrayList r100 = new FloatArrayList();
        EMPTY_LIST = r100;
        r100.makeImmutable();
    }

    public FloatArrayList() {
        this(new float[10], 0);
    }

    public static FloatArrayList emptyList() {
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
    public boolean addAll(Collection<? extends Float> r100) {
        ensureIsMutable();
        Internal.checkNotNull(r100);
        if ((r100 instanceof FloatArrayList) == false) goto L5;
        FloatArrayList r101 = (FloatArrayList) r100;
        int r102 = r101.size;
        if (r102 != 0) goto L9;
        return false;
    L9:
        int r103 = this.size;
        if ((Integer.MAX_VALUE - r103) < r102) goto L17;
        int r104 = r103 + r102;
        float[] r105 = this.array;
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

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float r100) {
        addFloat(this.size, r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FloatArrayList) == false) goto L8;
        FloatArrayList r101 = (FloatArrayList) r100;
        if (this.size == r101.size) goto L12;
        return false;
    L12:
        float[] r102 = r101.array;
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
    public Float get(int r100) {
        return Float.valueOf(getFloat(r100));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int r100) {
        ensureIndexInRange(r100);
        return this.array[r100];
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Float> mutableCopyWithCapacity(int r100) {
        if (r100 < this.size) goto L7;
        return new FloatArrayList(Arrays.copyOf(this.array, r100), this.size);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        ensureIsMutable();
        int r101 = 0;
    L4:
        if (r101 >= this.size) goto L10;
        if (r100.equals(Float.valueOf(this.array[r101])) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        float[] r102 = this.array;
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
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Float> mutableCopyWithCapacity2(int r100) {
        return mutableCopyWithCapacity(r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int r100) {
        ensureIsMutable();
        ensureIndexInRange(r100);
        float[] r101 = this.array;
        float r102 = r101[r100];
        System.arraycopy(r101, r100 + 1, r101, r100, this.size - r100);
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(r102);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r100) {
        return remove(r100);
    }

    private FloatArrayList(float[] r100, int r101) {
        this.array = r100;
        this.size = r101;
    }

    private void addFloat(int r100, float r101) {
        ensureIsMutable();
        if (r100 < 0) goto L13;
        int r102 = this.size;
        if (r100 > r102) goto L13;
        float[] r103 = this.array;
        if (r102 >= r103.length) goto L9;
        System.arraycopy(r103, r100, r103, r100 + 1, r102 - r100);
    L10:
        this.array[r100] = r101;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        float[] r104 = new float[((r102 * 3) / 2) + 1];
        System.arraycopy(r103, 0, r104, 0, r100);
        System.arraycopy(this.array, r100, r104, r100 + 1, this.size - r100);
        this.array = r104;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r100));
    }

    public void add(int r100, Float r101) {
        addFloat(r100, r101.floatValue());
    }

    public Float set(int r100, Float r101) {
        return Float.valueOf(setFloat(r100, r101.floatValue()));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int r100, float r101) {
        ensureIsMutable();
        ensureIndexInRange(r100);
        float[] r102 = this.array;
        float r103 = r102[r100];
        r102[r100] = r101;
        return r103;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
        add(r100, (Float) r101);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (Float) r101);
    }
}
