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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0086\bø\u0001\u0000J\u0019\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u0086\u0002J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rJ\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0086\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rJ&\u0010\u001a\u001a\u00020\b2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190\u001cH\u0086\bø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020 H\u0086\nJ\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!H\u0086\nJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0003H\u0001J\u0006\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0006\u0010(\u001a\u00020\u0003J\r\u0010)\u001a\u00020\bH\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\bH\u0000¢\u0006\u0002\b,J\u0015\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0003H\u0000¢\u0006\u0002\b/R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/collection/MutableIntFloatMap;", "Landroidx/collection/IntFloatMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "", "key", "defaultValue", "Lkotlin/Function0;", "set", "value", "put", "default", "putAll", "from", "plusAssign", "remove", "", "removeIf", "predicate", "Lkotlin/Function2;", "minusAssign", "keys", "", "Landroidx/collection/IntSet;", "Landroidx/collection/IntList;", "removeValueAt", "index", "clear", "findInsertIndex", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableIntFloatMap extends IntFloatMap {
    private int growthLimit;

    public MutableIntFloatMap() {
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
        int[] r3 = this.keys;
        float[] r4 = this.values;
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
        int r16 = r3[r12] * ScatterMapKt.MurmurHashC1;
        int r17 = r16 ^ (r16 << 16);
        int r18 = r17 >>> 7;
        int r19 = findFirstAvailableSlot(r18);
        int r20 = r18 & r2;
        if ((((r19 - r20) & r2) / 8) == (((r12 - r20) & r2) / 8)) goto L15;
        int r21 = r19 >> 3;
        long r110 = r1[r21];
        int r111 = (r19 & 7) << 3;
        if (((r110 >> r111) & 255) != 128) goto L19;
        r1[r21] = ((~(255 << r111)) & r110) | (((long) (r17 & 127)) << r111);
        r1[r13] = (r1[r13] & (~(255 << r14))) | (128 << r14);
        r3[r19] = r3[r12];
        r3[r12] = 0;
        r4[r19] = r4[r12];
        r4[r12] = 0.0f;
    L20:
        r11 = 72057594037927935L;
        r1[ArraysKt.getLastIndex(r1)] = (r1[0] & 72057594037927935L) | Long.MIN_VALUE;
        r12 = r12 + 1;
        r6 = 0;
        goto L6
    L19:
        r1[r21] = (((long) (r17 & 127)) << r111) | ((~(255 << r111)) & r110);
        int r22 = r3[r19];
        r3[r19] = r3[r12];
        r3[r12] = r22;
        float r23 = r4[r19];
        r4[r19] = r4[r12];
        r4[r12] = r23;
        r12 = r12 - 1;
        goto L20
    L15:
        long r24 = ((long) (r17 & 127)) << r14;
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

    public MutableIntFloatMap(int r2) {
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

    private final int findInsertIndex(int r21) {
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
        if (this.keys[r16] == r21) goto L11;
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
        return ~r1;
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
        this.keys = new int[r3];
        this.values = new float[r3];
        return;
    L4:
        r3 = 0;
        goto L5
    }

    public final void minusAssign(IntSet r15) {
        Intrinsics.checkNotNullParameter(r15, "keys");
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

    public final void plusAssign(IntFloatMap r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    public final void putAll(IntFloatMap r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        int[] r1 = r17.keys;
        float[] r2 = r17.values;
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

    public final void remove(int r1) {
        int r2 = findKeyIndex(r1);
        if (r2 < 0) goto L6;
        removeValueAt(r2);
        return;
    }

    public final void removeIf(Function2<? super Integer, ? super Float, Boolean> r15) {
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
        if (((Boolean) r15.invoke(Integer.valueOf(this.keys[r10]), Float.valueOf(this.values[r10]))).booleanValue() == false) goto L17;
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

    public final void resizeStorage$collection(int r21) {
        long[] r1 = this.metadata;
        int[] r2 = this.keys;
        float[] r3 = this.values;
        int r4 = this._capacity;
        initializeStorage(r21);
        long[] r5 = this.metadata;
        int[] r6 = this.keys;
        float[] r7 = this.values;
        int r8 = this._capacity;
        int r10 = 0;
    L3:
        if (r10 >= r4) goto L12;
        if (((r1[r10 >> 3] >> ((r10 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
        int r12 = r2[r10];
        int r13 = ScatterMapKt.MurmurHashC1 * r12;
        int r14 = r13 ^ (r13 << 16);
        int r15 = findFirstAvailableSlot(r14 >>> 7);
        int r16 = r10;
        long r9 = r14 & 127;
        int r17 = r15 >> 3;
        int r18 = (r15 & 7) << 3;
        long r19 = (r9 << r18) | (r5[r17] & (~(255 << r18)));
        r5[r17] = r19;
        r5[(((r15 - 7) & r8) + (r8 & 7)) >> 3] = r19;
        r6[r15] = r12;
        r7[r15] = r3[r16];
    L11:
        r10 = r16 + 1;
        goto L3
    L10:
        r16 = r10;
        goto L11
    L7:
        r11 = false;
        goto L8
    }

    public final void minusAssign(IntList r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        int[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(int r1) {
        remove(r1);
    }

    public final float getOrPut(int r2, Function0<Float> r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        int r0 = findKeyIndex(r2);
        if (r0 >= 0) goto L6;
        float r4 = ((Number) r3.invoke()).floatValue();
        put(r2, r4);
        return r4;
    L6:
        return this.values[r0];
    }

    public final void put(int r1, float r2) {
        set(r1, r2);
    }

    public final boolean remove(int r4, float r5) {
        int r6 = findKeyIndex(r4);
        if (r6 >= 0) goto L5;
    L11:
        return false;
    L5:
        if (this.values[r6] != r5) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L11;
        removeValueAt(r6);
        return true;
    L7:
        r7 = false;
        goto L8
    }

    public final void set(int r3, float r4) {
        int r0 = findInsertIndex(r3);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L5:
        this.keys[r0] = r3;
        this.values[r0] = r4;
    }

    public /* synthetic */ MutableIntFloatMap(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }

    public final float put(int r3, float r4, float r5) {
        int r0 = findInsertIndex(r3);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L6:
        this.keys[r0] = r3;
        this.values[r0] = r4;
        return r5;
    L5:
        r5 = this.values[r0];
        goto L6
    }
}
