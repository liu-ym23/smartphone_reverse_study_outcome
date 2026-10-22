package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0001J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0002J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\u0011\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0011\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0002J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0001J\u0011\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0007J\r\u0010\u001d\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\bH\u0000¢\u0006\u0002\b J\u0015\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0003H\u0000¢\u0006\u0002\b#R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/collection/MutableIntSet;", "Landroidx/collection/IntSet;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "add", "", "element", "plusAssign", "addAll", "elements", "", "remove", "minusAssign", "removeAll", "removeElementAt", "index", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableIntSet extends IntSet {
    private int growthLimit;

    public MutableIntSet() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final void clear() {
        this._size = 0;
        long[] r1 = this.metadata;
        if (r1 == ScatterMapKt.EmptyGroup) goto L5;
        ArraysKt.fill$default(r1, -9187201950435737472L, 0, 0, 6, null);
        long[] r0 = this.metadata;
        int r2 = this._capacity;
        int r3 = r2 >> 3;
        long r5 = 255 << ((r2 & 7) << 3);
        r0[r3] = (r0[r3] & (~r5)) | r5;
    L5:
        initializeGrowth();
    }

    public final void adjustStorage$collection() {
        if (this._capacity > 8) goto L5;
    L7:
        resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        return;
    L5:
        if (Long.compare(ULong.constructor-impl(ULong.constructor-impl(this._size) * 32) ^ Long.MIN_VALUE, ULong.constructor-impl(ULong.constructor-impl(this._capacity) * 25) ^ Long.MIN_VALUE) > 0) goto L7;
        dropDeletes$collection();
    }

    public final void dropDeletes$collection() {
        long[] r1 = this.metadata;
        int r2 = this._capacity;
        int[] r3 = this.elements;
        int r4 = (r2 + 7) >> 3;
        char r5 = 0;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        long r7 = r1[r6] & (-9187201950435737472L);
        r1[r6] = (-72340172838076674L) & ((~r7) + (r7 >>> 7));
        r6 = r6 + 1;
        goto L3
    L5:
        int r8 = ArraysKt.getLastIndex(r1);
        int r9 = r8 - 1;
        long r10 = 72057594037927935L;
        r1[r9] = (r1[r9] & 72057594037927935L) | (-72057594037927936L);
        r1[r8] = r1[0];
        int r11 = 0;
    L6:
        if (r11 == r2) goto L21;
        int r12 = r11 >> 3;
        int r13 = (r11 & 7) << 3;
        long r14 = (r1[r12] >> r13) & 255;
        if (r14 == 128) goto L9;
        if (r14 != 254) goto L9;
        int r15 = r3[r11] * ScatterMapKt.MurmurHashC1;
        int r16 = r15 ^ (r15 << 16);
        int r17 = r16 >>> 7;
        int r18 = findFirstAvailableSlot(r17);
        int r19 = r17 & r2;
        if ((((r18 - r19) & r2) / 8) == (((r11 - r19) & r2) / 8)) goto L15;
        int r20 = r18 >> 3;
        long r110 = r1[r20];
        int r111 = (r18 & 7) << 3;
        if (((r110 >> r111) & 255) != 128) goto L19;
        r1[r20] = ((~(255 << r111)) & r110) | (((long) (r16 & 127)) << r111);
        r1[r12] = (r1[r12] & (~(255 << r13))) | (128 << r13);
        r3[r18] = r3[r11];
        r3[r11] = 0;
    L20:
        r10 = 72057594037927935L;
        r1[ArraysKt.getLastIndex(r1)] = (r1[0] & 72057594037927935L) | Long.MIN_VALUE;
        r11 = r11 + 1;
        r5 = 0;
        goto L6
    L19:
        r1[r20] = (((long) (r16 & 127)) << r111) | ((~(255 << r111)) & r110);
        int r21 = r3[r18];
        r3[r18] = r3[r11];
        r3[r11] = r21;
        r11 = r11 - 1;
        goto L20
    L15:
        long r22 = ((long) (r16 & 127)) << r13;
        r1[r12] = r22 | ((~(255 << r13)) & r1[r12]);
        r1[ArraysKt.getLastIndex(r1)] = (r1[r5] & r10) | Long.MIN_VALUE;
    L9:
        r11 = r11 + 1;
        goto L6
    L21:
        initializeGrowth();
    }

    public final int trim() {
        int r0 = this._capacity;
        int r1 = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (r1 >= r0) goto L6;
        resizeStorage$collection(r1);
        return r0 - this._capacity;
    L6:
        return 0;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    public MutableIntSet(int r2) {
        super(null);
        if (r2 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
    L8:
        initializeStorage(ScatterMapKt.unloadedCapacity(r2));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final int findAbsoluteInsertIndex(int r21) {
        int r2 = ScatterMapKt.MurmurHashC1 * r21;
        int r3 = r2 ^ (r2 << 16);
        int r4 = r3 >>> 7;
        int r5 = r3 & 127;
        int r6 = this._capacity;
        int r7 = r4 & r6;
        int r8 = 0;
    L3:
        long[] r9 = this.metadata;
        int r10 = r7 >> 3;
        int r11 = (r7 & 7) << 3;
        long r12 = ((r9[r10 + 1] << (64 - r11)) & ((-r11) >> 63)) | (r9[r10] >>> r11);
        long r13 = r5;
        int r18 = r8;
        long r14 = r12 ^ (r13 * ScatterMapKt.BitmaskLsb);
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r15 == 0) goto L7;
        boolean r19 = true;
    L8:
        if (r19 == false) goto L14;
        int r16 = (r7 + (Long.numberOfTrailingZeros(r15) >> 3)) & r6;
        if (this.elements[r16] == r21) goto L11;
        r15 = r15 & (r15 - 1);
        goto L5
    L11:
        return r16;
    L14:
        if (((((~r12) << 6) & r12) & (-9187201950435737472L)) != 0) goto L15;
        r8 = r18 + 8;
        r7 = (r7 + r8) & r6;
        goto L3
    L15:
        int r1 = findFirstAvailableSlot(r4);
        if (this.growthLimit == 0) goto L18;
    L23:
        this._size++;
        int r17 = this.growthLimit;
        long[] r20 = this.metadata;
        int r22 = r1 >> 3;
        long r23 = r20[r22];
        int r24 = (r1 & 7) << 3;
        if (((r23 >> r24) & 255) != 128) goto L26;
        int r110 = 1;
    L27:
        this.growthLimit = r17 - r110;
        int r25 = this._capacity;
        long r26 = ((~(255 << r24)) & r23) | (r13 << r24);
        r20[r22] = r26;
        r20[(((r1 - 7) & r25) + (r25 & 7)) >> 3] = r26;
        return r1;
    L26:
        r110 = 0;
        goto L27
    L18:
        if (((this.metadata[r1 >> 3] >> ((r1 & 7) << 3)) & 255) != 254) goto L20;
        boolean r27 = true;
    L21:
        if (r27 == true) goto L23;
        adjustStorage$collection();
        r1 = findFirstAvailableSlot(r4);
        goto L23
    L20:
        r27 = false;
        goto L21
    L7:
        r19 = false;
        goto L8
    }

    private final int findFirstAvailableSlot(int r10) {
        int r0 = this._capacity;
        int r11 = r10 & r0;
        int r1 = 0;
    L3:
        long[] r2 = this.metadata;
        int r3 = r11 >> 3;
        int r4 = (r11 & 7) << 3;
        long r5 = ((r2[r3 + 1] << (64 - r4)) & ((-r4) >> 63)) | (r2[r3] >>> r4);
        long r6 = (r5 & ((~r5) << 7)) & (-9187201950435737472L);
        if (r6 != 0) goto L6;
        r1 = r1 + 8;
        r11 = (r11 + r1) & r0;
        goto L3
    L6:
        return (r11 + (Long.numberOfTrailingZeros(r6) >> 3)) & r0;
    }

    private final void initializeMetadata(int r9) {
        if (r9 != 0) goto L4;
        long[] r0 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r0;
        int r1 = r9 >> 3;
        long r4 = 255 << ((r9 & 7) << 3);
        r0[r1] = (r0[r1] & (~r4)) | r4;
        initializeGrowth();
        return;
    L4:
        r0 = new long[((((r9 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r0, -9187201950435737472L, 0, 0, 6, null);
        goto L5
    }

    private final void initializeStorage(int r2) {
        if (r2 <= 0) goto L4;
        int r3 = Math.max(7, ScatterMapKt.normalizeCapacity(r2));
    L5:
        this._capacity = r3;
        initializeMetadata(r3);
        this.elements = new int[r3];
        return;
    L4:
        r3 = 0;
        goto L5
    }

    private final void removeElementAt(int r9) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r9 >> 3;
        int r3 = (r9 & 7) << 3;
        long r4 = (r0[r2] & (~(255 << r3))) | (254 << r3);
        r0[r2] = r4;
        r0[(((r9 - 7) & r1) + (r1 & 7)) >> 3] = r4;
    }

    public final boolean add(int r4) {
        int r0 = this._size;
        int r1 = findAbsoluteInsertIndex(r4);
        this.elements[r1] = r4;
        if (this._size == r0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(IntSet r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(int r18) {
        int r2 = ScatterMapKt.MurmurHashC1 * r18;
        int r3 = r2 ^ (r2 << 16);
        int r4 = r3 & 127;
        int r5 = this._capacity;
        int r6 = (r3 >>> 7) & r5;
        int r7 = 0;
    L3:
        long[] r8 = this.metadata;
        int r9 = r6 >> 3;
        int r10 = (r6 & 7) << 3;
        long r11 = ((r8[r9 + 1] << (64 - r10)) & ((-r10) >> 63)) | (r8[r9] >>> r10);
        long r12 = (((long) r4) * ScatterMapKt.BitmaskLsb) ^ r11;
        long r13 = ((~r12) & (r12 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r13 == 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == false) goto L14;
        int r15 = ((Long.numberOfTrailingZeros(r13) >> 3) + r6) & r5;
        if (this.elements[r15] == r18) goto L16;
        r13 = r13 & (r13 - 1);
    L16:
        if (r15 < 0) goto L23;
        removeElementAt(r15);
        return;
    L23:
        return;
    L14:
        if (((r11 & ((~r11) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r7 = r7 + 8;
        r6 = (r6 + r7) & r5;
        goto L3
    L15:
        r15 = -1;
        goto L16
    L7:
        r14 = false;
        goto L8
    }

    public final void plusAssign(IntSet r15) {
        Intrinsics.checkNotNullParameter(r15, "elements");
        int[] r0 = r15.elements;
        long[] r16 = r15.metadata;
        int r1 = r16.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r16[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        plusAssign(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final boolean remove(int r18) {
        int r2 = ScatterMapKt.MurmurHashC1 * r18;
        int r3 = r2 ^ (r2 << 16);
        int r4 = r3 & 127;
        int r5 = this._capacity;
        int r6 = (r3 >>> 7) & r5;
        boolean r7 = false;
        int r8 = 0;
    L3:
        long[] r9 = this.metadata;
        int r10 = r6 >> 3;
        int r11 = (r6 & 7) << 3;
        long r12 = ((r9[r10 + 1] << (64 - r11)) & ((-r11) >> 63)) | (r9[r10] >>> r11);
        long r13 = (((long) r4) * ScatterMapKt.BitmaskLsb) ^ r12;
        long r14 = ((~r13) & (r13 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r14 == 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L14;
        int r16 = ((Long.numberOfTrailingZeros(r14) >> 3) + r6) & r5;
        if (this.elements[r16] == r18) goto L16;
        r14 = r14 & (r14 - 1);
    L16:
        if (r16 < 0) goto L18;
        r7 = true;
    L18:
        if (r7 == false) goto L20;
        removeElementAt(r16);
    L20:
        return r7;
    L14:
        if (((r12 & ((~r12) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r8 = r8 + 8;
        r6 = (r6 + r8) & r5;
        goto L3
    L15:
        r16 = -1;
        goto L16
    L7:
        r15 = false;
        goto L8
    }

    public final boolean removeAll(IntSet r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void resizeStorage$collection(int r20) {
        long[] r1 = this.metadata;
        int[] r2 = this.elements;
        int r3 = this._capacity;
        initializeStorage(r20);
        long[] r4 = this.metadata;
        int[] r5 = this.elements;
        int r6 = this._capacity;
        int r8 = 0;
    L3:
        if (r8 >= r3) goto L11;
        if (((r1[r8 >> 3] >> ((r8 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L10;
        int r10 = r2[r8];
        int r11 = ScatterMapKt.MurmurHashC1 * r10;
        int r12 = r11 ^ (r11 << 16);
        int r13 = findFirstAvailableSlot(r12 >>> 7);
        long r14 = r12 & 127;
        int r15 = r13 >> 3;
        int r16 = (r13 & 7) << 3;
        long r17 = (r4[r15] & (~(255 << r16))) | (r14 << r16);
        r4[r15] = r17;
        r4[(((r13 - 7) & r6) + (r6 & 7)) >> 3] = r17;
        r5[r13] = r10;
    L10:
        r8 = r8 + 1;
        goto L3
    L7:
        r9 = false;
        goto L8
    }

    public final boolean addAll(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(IntSet r15) {
        Intrinsics.checkNotNullParameter(r15, "elements");
        int[] r0 = r15.elements;
        long[] r16 = r15.metadata;
        int r1 = r16.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r16[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        minusAssign(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final void plusAssign(int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        plusAssign(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final boolean removeAll(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        minusAssign(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(int r3) {
        int r0 = findAbsoluteInsertIndex(r3);
        this.elements[r0] = r3;
    }

    public /* synthetic */ MutableIntSet(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }
}
