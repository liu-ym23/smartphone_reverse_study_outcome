package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0086\bø\u0001\u0000J\u0019\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0086\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0003J&\u0010\u001a\u001a\u00020\b2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u001cH\u0086\bø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020 H\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!H\u0086\nJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0003H\u0001J\u0006\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0006\u0010(\u001a\u00020\u0003J\r\u0010)\u001a\u00020\bH\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\bH\u0000¢\u0006\u0002\b,J\u0015\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0003H\u0000¢\u0006\u0002\b/R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/collection/MutableLongIntMap;", "Landroidx/collection/LongIntMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "key", "", "defaultValue", "Lkotlin/Function0;", "set", "value", "put", "default", "putAll", "from", "plusAssign", "remove", "", "removeIf", "predicate", "Lkotlin/Function2;", "minusAssign", "keys", "", "Landroidx/collection/LongSet;", "Landroidx/collection/LongList;", "removeValueAt", "index", "clear", "findInsertIndex", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableLongIntMap extends LongIntMap {
    private int growthLimit;

    public MutableLongIntMap() {
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
        long[] r3 = this.keys;
        int[] r4 = this.values;
        int r5 = (r2 + 7) >> 3;
        char r6 = 0;
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L5;
        long r8 = r1[r7] & (-9187201950435737472L);
        r1[r7] = (-72340172838076674L) & ((~r8) + (r8 >>> 7));
        r7 = r7 + 1;
        goto L3
    L5:
        int r9 = ArraysKt.getLastIndex(r1);
        int r10 = r9 - 1;
        long r11 = 72057594037927935L;
        r1[r10] = (r1[r10] & 72057594037927935L) | (-72057594037927936L);
        r1[r9] = r1[0];
        int r12 = 0;
    L6:
        if (r12 == r2) goto L21;
        int r13 = r12 >> 3;
        int r14 = (r12 & 7) << 3;
        long r15 = (r1[r13] >> r14) & 255;
        if (r15 == 128) goto L9;
        if (r15 != 254) goto L9;
        long r16 = r3[r12];
        int r17 = ((int) (r16 ^ (r16 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r18 = (r17 << 16) ^ r17;
        int r19 = r18 >>> 7;
        int r110 = findFirstAvailableSlot(r19);
        int r20 = r19 & r2;
        if ((((r110 - r20) & r2) / 8) == (((r12 - r20) & r2) / 8)) goto L15;
        int r21 = r110 >> 3;
        long r111 = r1[r21];
        int r112 = (r110 & 7) << 3;
        if (((r111 >> r112) & 255) != 128) goto L19;
        r1[r21] = ((~(255 << r112)) & r111) | (((long) (r18 & 127)) << r112);
        r1[r13] = (r1[r13] & (~(255 << r14))) | (128 << r14);
        r3[r110] = r3[r12];
        r3[r12] = 0;
        r4[r110] = r4[r12];
        r4[r12] = 0;
    L20:
        r11 = 72057594037927935L;
        r1[ArraysKt.getLastIndex(r1)] = (r1[0] & 72057594037927935L) | Long.MIN_VALUE;
        r12 = r12 + 1;
        r6 = 0;
        goto L6
    L19:
        r1[r21] = (((long) (r18 & 127)) << r112) | ((~(255 << r112)) & r111);
        long r22 = r3[r110];
        r3[r110] = r3[r12];
        r3[r12] = r22;
        int r23 = r4[r110];
        r4[r110] = r4[r12];
        r4[r12] = r23;
        r12 = r12 - 1;
        goto L20
    L15:
        long r24 = ((long) (r18 & 127)) << r14;
        r1[r13] = r24 | ((~(255 << r14)) & r1[r13]);
        r1[ArraysKt.getLastIndex(r1)] = (r1[r6] & r11) | Long.MIN_VALUE;
    L9:
        r12 = r12 + 1;
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

    public MutableLongIntMap(int r2) {
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

    private final int findInsertIndex(long r22) {
        int r2 = ((int) (r22 ^ (r22 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r1 = (r2 << 16) ^ r2;
        int r3 = r1 >>> 7;
        int r4 = r1 & 127;
        int r5 = this._capacity;
        int r6 = r3 & r5;
        int r7 = 0;
    L3:
        long[] r8 = this.metadata;
        int r9 = r6 >> 3;
        int r10 = (r6 & 7) << 3;
        long r11 = ((r8[r9 + 1] << (64 - r10)) & ((-r10) >> 63)) | (r8[r9] >>> r10);
        long r12 = r4;
        int r17 = r7;
        long r13 = r11 ^ (r12 * ScatterMapKt.BitmaskLsb);
        long r14 = ((~r13) & (r13 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r14 == 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == false) goto L14;
        int r15 = ((Long.numberOfTrailingZeros(r14) >> 3) + r6) & r5;
        if (this.keys[r15] == r22) goto L11;
        r14 = r14 & (r14 - 1);
        goto L5
    L11:
        return r15;
    L14:
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) != 0) goto L15;
        r7 = r17 + 8;
        r6 = (r6 + r7) & r5;
        goto L3
    L15:
        int r16 = findFirstAvailableSlot(r3);
        if (this.growthLimit == 0) goto L18;
    L23:
        this._size++;
        int r19 = this.growthLimit;
        long[] r20 = this.metadata;
        int r21 = r16 >> 3;
        long r23 = r20[r21];
        int r110 = (r16 & 7) << 3;
        if (((r23 >> r110) & 255) != 128) goto L26;
        int r111 = 1;
    L27:
        this.growthLimit = r19 - r111;
        int r24 = this._capacity;
        long r25 = ((~(255 << r110)) & r23) | (r12 << r110);
        r20[r21] = r25;
        r20[(((r16 - 7) & r24) + (r24 & 7)) >> 3] = r25;
        return ~r16;
    L26:
        r111 = 0;
        goto L27
    L18:
        if (((this.metadata[r16 >> 3] >> ((r16 & 7) << 3)) & 255) != 254) goto L20;
        boolean r26 = true;
    L21:
        if (r26 == true) goto L23;
        adjustStorage$collection();
        r16 = findFirstAvailableSlot(r3);
        goto L23
    L20:
        r26 = false;
        goto L21
    L7:
        r18 = false;
        goto L8
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
        this.keys = new long[r3];
        this.values = new int[r3];
        return;
    L4:
        r3 = 0;
        goto L5
    }

    public final void minusAssign(LongSet r15) {
        Intrinsics.checkNotNullParameter(r15, "keys");
        long[] r0 = r15.elements;
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
        remove(r0[(r3 << 3) + r8]);
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

    public final void plusAssign(LongIntMap r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    public final void putAll(LongIntMap r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        long[] r1 = r17.keys;
        int[] r2 = r17.values;
        long[] r0 = r17.metadata;
        int r3 = r0.length - 2;
        if (r3 < 0) goto L24;
        int r5 = 0;
    L5:
        long r6 = r0[r5];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r8 = 8 - ((~(r5 - r3)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L18;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
        int r12 = (r5 << 3) + r10;
        set(r1[r12], r2[r12]);
    L16:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L18:
        if (r8 == 8) goto L21;
        return;
    L21:
        if (r5 == r3) goto L31;
        r5 = r5 + 1;
        goto L5
    L31:
        return;
    }

    public final void remove(long r1) {
        int r2 = findKeyIndex(r1);
        if (r2 < 0) goto L6;
        removeValueAt(r2);
        return;
    }

    public final void removeIf(Function2<? super Long, ? super Integer, Boolean> r15) {
        Intrinsics.checkNotNullParameter(r15, "predicate");
        long[] r0 = this.metadata;
        int r1 = r0.length - 2;
        if (r1 < 0) goto L21;
        int r3 = 0;
    L5:
        long r4 = r0[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L18;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L17;
        int r10 = (r3 << 3) + r8;
        if (((Boolean) r15.invoke(Long.valueOf(this.keys[r10]), Integer.valueOf(this.values[r10]))).booleanValue() == false) goto L17;
        removeValueAt(r10);
    L17:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L18:
        if (r6 == 8) goto L19;
        return;
    L19:
        if (r3 == r1) goto L29;
        r3 = r3 + 1;
        goto L5
    L29:
        return;
    }

    public final void removeValueAt(int r9) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r9 >> 3;
        int r3 = (r9 & 7) << 3;
        long r4 = (r0[r2] & (~(255 << r3))) | (254 << r3);
        r0[r2] = r4;
        r0[(((r9 - 7) & r1) + (r1 & 7)) >> 3] = r4;
    }

    public final void resizeStorage$collection(int r23) {
        MutableLongIntMap r0 = this;
        long[] r1 = r0.metadata;
        long[] r2 = r0.keys;
        int[] r3 = r0.values;
        int r4 = r0._capacity;
        initializeStorage(r23);
        long[] r5 = r0.metadata;
        long[] r6 = r0.keys;
        int[] r7 = r0.values;
        int r8 = r0._capacity;
        int r10 = 0;
    L3:
        if (r10 >= r4) goto L12;
        if (((r1[r10 >> 3] >> ((r10 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
        long r12 = r2[r10];
        int r17 = r10;
        int r13 = ((int) (r12 ^ (r12 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r9 = (r13 << 16) ^ r13;
        int r14 = r0.findFirstAvailableSlot(r9 >>> 7);
        long r15 = r9 & 127;
        int r16 = r14 >> 3;
        int r18 = (r14 & 7) << 3;
        long r19 = (r5[r16] & (~(255 << r18))) | (r15 << r18);
        r5[r16] = r19;
        r5[(((r14 - 7) & r8) + (r8 & 7)) >> 3] = r19;
        r6[r14] = r12;
        r7[r14] = r3[r17];
    L11:
        r10 = r17 + 1;
        r0 = this;
        r1 = r1;
        goto L3
    L10:
        r17 = r10;
        goto L11
    L7:
        r11 = false;
        goto L8
    }

    public final void minusAssign(LongList r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        long[] r0 = r5.content;
        int r6 = r5._size;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(long[] r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(long r1) {
        remove(r1);
    }

    public final int getOrPut(long r2, Function0<Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        int r0 = findKeyIndex(r2);
        if (r0 >= 0) goto L6;
        int r5 = ((Number) r4.invoke()).intValue();
        put(r2, r5);
        return r5;
    L6:
        return this.values[r0];
    }

    public final void put(long r1, int r3) {
        set(r1, r3);
    }

    public final boolean remove(long r1, int r3) {
        int r2 = findKeyIndex(r1);
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (this.values[r2] != r3) goto L10;
        removeValueAt(r2);
        return true;
    L10:
        return false;
    }

    public final void set(long r3, int r5) {
        int r0 = findInsertIndex(r3);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L5:
        this.keys[r0] = r3;
        this.values[r0] = r5;
    }

    public /* synthetic */ MutableLongIntMap(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }

    public final int put(long r3, int r5, int r6) {
        int r0 = findInsertIndex(r3);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L6:
        this.keys[r0] = r3;
        this.values[r0] = r5;
        return r6;
    L5:
        r6 = this.values[r0];
        goto L6
    }
}
