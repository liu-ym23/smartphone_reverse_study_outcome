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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J'\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u001a\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u0015\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001b\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ&\u0010\u001f\u001a\u00020\t2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0!H\u0086\bø\u0001\u0000J\u0011\u0010\"\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\nJ\u0011\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0086\nJ\u0011\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020%H\u0086\nJ\u0011\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020&H\u0086\nJ\u0017\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010(\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\tJ\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0006\u0010.\u001a\u00020\u0004J\r\u0010/\u001a\u00020\tH\u0000¢\u0006\u0002\b0J\r\u00101\u001a\u00020\tH\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0004H\u0000¢\u0006\u0002\b5R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00066"}, d2 = {"Landroidx/collection/MutableFloatObjectMap;", "V", "Landroidx/collection/FloatObjectMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "key", "", "defaultValue", "Lkotlin/Function0;", "(FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "set", "value", "(FLjava/lang/Object;)V", "put", "(FLjava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "plusAssign", "remove", "(F)Ljava/lang/Object;", "", "(FLjava/lang/Object;)Z", "removeIf", "predicate", "Lkotlin/Function2;", "minusAssign", "keys", "", "Landroidx/collection/FloatSet;", "Landroidx/collection/FloatList;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableFloatObjectMap<V> extends FloatObjectMap<V> {
    private int growthLimit;

    public MutableFloatObjectMap() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final void clear() {
        this._size = 0;
        long[] r1 = this.metadata;
        if (r1 == ScatterMapKt.EmptyGroup) goto L5;
        ArraysKt.fill$default(r1, -9187201950435737472L, 0, 0, 6, null);
        long[] r2 = this.metadata;
        int r3 = this._capacity;
        int r4 = r3 >> 3;
        long r6 = 255 << ((r3 & 7) << 3);
        r2[r4] = (r2[r4] & (~r6)) | r6;
    L5:
        ArraysKt.fill(this.values, null, 0, this._capacity);
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
        float[] r3 = this.keys;
        Object[] r4 = this.values;
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
        int r16 = Float.floatToIntBits(r3[r12]) * ScatterMapKt.MurmurHashC1;
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
        r3[r12] = 0.0f;
        r4[r19] = r4[r12];
        r4[r12] = null;
    L20:
        r11 = 72057594037927935L;
        r1[ArraysKt.getLastIndex(r1)] = (r1[0] & 72057594037927935L) | Long.MIN_VALUE;
        r12 = r12 + 1;
        r6 = 0;
        goto L6
    L19:
        r1[r21] = (((long) (r17 & 127)) << r111) | ((~(255 << r111)) & r110);
        float r22 = r3[r19];
        r3[r19] = r3[r12];
        r3[r12] = r22;
        Object r23 = r4[r19];
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

    public MutableFloatObjectMap(int r2) {
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

    private final int findAbsoluteInsertIndex(float r20) {
        int r1 = Float.floatToIntBits(r20) * ScatterMapKt.MurmurHashC1;
        int r2 = r1 ^ (r1 << 16);
        int r3 = r2 >>> 7;
        int r4 = r2 & 127;
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
        if (r18 == false) goto L17;
        int r15 = ((Long.numberOfTrailingZeros(r14) >> 3) + r6) & r5;
        if (this.keys[r15] != r20) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == true) goto L14;
        r14 = r14 & (r14 - 1);
        goto L5
    L14:
        return r15;
    L12:
        r16 = false;
        goto L13
    L17:
        if (((((~r11) << 6) & r11) & (-9187201950435737472L)) != 0) goto L18;
        r7 = r17 + 8;
        r6 = (r6 + r7) & r5;
        goto L3
    L18:
        int r19 = findFirstAvailableSlot(r3);
        if (this.growthLimit == 0) goto L21;
    L26:
        this._size++;
        int r21 = this.growthLimit;
        long[] r22 = this.metadata;
        int r23 = r19 >> 3;
        long r24 = r22[r23];
        int r110 = (r19 & 7) << 3;
        if (((r24 >> r110) & 255) != 128) goto L29;
        int r111 = 1;
    L30:
        this.growthLimit = r21 - r111;
        int r25 = this._capacity;
        long r26 = ((~(255 << r110)) & r24) | (r12 << r110);
        r22[r23] = r26;
        r22[(((r19 - 7) & r25) + (r25 & 7)) >> 3] = r26;
        return r19;
    L29:
        r111 = 0;
        goto L30
    L21:
        if (((this.metadata[r19 >> 3] >> ((r19 & 7) << 3)) & 255) != 254) goto L23;
        boolean r27 = true;
    L24:
        if (r27 == true) goto L26;
        adjustStorage$collection();
        r19 = findFirstAvailableSlot(r3);
        goto L26
    L23:
        r27 = false;
        goto L24
    L7:
        r18 = false;
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
        this.keys = new float[r3];
        this.values = new Object[r3];
        return;
    L4:
        r3 = 0;
        goto L5
    }

    public final void minusAssign(FloatSet r15) {
        Intrinsics.checkNotNullParameter(r15, "keys");
        float[] r0 = r15.elements;
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

    public final void plusAssign(FloatObjectMap<V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(FloatObjectMap<V> r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        float[] r1 = r17.keys;
        Object[] r2 = r17.values;
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

    public final V remove(float r17) {
        int r1 = Float.floatToIntBits(r17) * ScatterMapKt.MurmurHashC1;
        int r2 = r1 ^ (r1 << 16);
        int r3 = r2 & 127;
        int r4 = this._capacity;
        int r5 = (r2 >>> 7) & r4;
        int r6 = 0;
    L3:
        long[] r7 = this.metadata;
        int r8 = r5 >> 3;
        int r9 = (r5 & 7) << 3;
        long r10 = ((r7[r8 + 1] << (64 - r9)) & ((-r9) >> 63)) | (r7[r8] >>> r9);
        long r11 = (((long) r3) * ScatterMapKt.BitmaskLsb) ^ r10;
        long r12 = ((~r11) & (r11 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r12 == 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L17;
        int r14 = ((Long.numberOfTrailingZeros(r12) >> 3) + r5) & r4;
        if (this.keys[r14] != r17) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == true) goto L19;
        r12 = r12 & (r12 - 1);
    L19:
        if (r14 >= 0) goto L21;
        return null;
    L21:
        return removeValueAt(r14);
    L12:
        r15 = false;
        goto L13
    L17:
        if (((r10 & ((~r10) << 6)) & (-9187201950435737472L)) != 0) goto L18;
        r6 = r6 + 8;
        r5 = (r5 + r6) & r4;
        goto L3
    L18:
        r14 = -1;
        goto L19
    L7:
        r13 = false;
        goto L8
    }

    public final void removeIf(Function2<? super Float, ? super V, Boolean> r15) {
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
        if (((Boolean) r15.invoke(Float.valueOf(this.keys[r10]), this.values[r10])).booleanValue() == false) goto L17;
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

    public final V removeValueAt(int r9) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r9 >> 3;
        int r3 = (r9 & 7) << 3;
        long r4 = (r0[r2] & (~(255 << r3))) | (254 << r3);
        r0[r2] = r4;
        r0[(((r9 - 7) & r1) + (r1 & 7)) >> 3] = r4;
        Object[] r5 = this.values;
        V r6 = (V) r5[r9];
        r5[r9] = null;
        return r6;
    }

    public final void resizeStorage$collection(int r21) {
        long[] r1 = this.metadata;
        float[] r2 = this.keys;
        Object[] r3 = this.values;
        int r4 = this._capacity;
        initializeStorage(r21);
        long[] r5 = this.metadata;
        float[] r6 = this.keys;
        Object[] r7 = this.values;
        int r8 = this._capacity;
        int r10 = 0;
    L3:
        if (r10 >= r4) goto L12;
        if (((r1[r10 >> 3] >> ((r10 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
        float r12 = r2[r10];
        int r13 = Float.floatToIntBits(r12) * ScatterMapKt.MurmurHashC1;
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

    public final void minusAssign(FloatList r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        float[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(float[] r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(float r1) {
        remove(r1);
    }

    public final V getOrPut(float r2, Function0<? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        V r0 = get(r2);
        if (r0 != null) goto L6;
        V r1 = (V) r3.invoke();
        set(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public final V put(float r5, V r6) {
        int r0 = findAbsoluteInsertIndex(r5);
        Object[] r1 = this.values;
        V r2 = (V) r1[r0];
        this.keys[r0] = r5;
        r1[r0] = r6;
        return r2;
    }

    public final boolean remove(float r17, V r18) {
        int r1 = Float.floatToIntBits(r17) * ScatterMapKt.MurmurHashC1;
        int r2 = r1 ^ (r1 << 16);
        int r3 = r2 & 127;
        int r4 = this._capacity;
        int r5 = (r2 >>> 7) & r4;
        int r6 = 0;
    L3:
        long[] r7 = this.metadata;
        int r8 = r5 >> 3;
        int r9 = (r5 & 7) << 3;
        long r10 = ((r7[r8 + 1] << (64 - r9)) & ((-r9) >> 63)) | (r7[r8] >>> r9);
        long r11 = (((long) r3) * ScatterMapKt.BitmaskLsb) ^ r10;
        long r12 = ((~r11) & (r11 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r12 == 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L17;
        int r14 = ((Long.numberOfTrailingZeros(r12) >> 3) + r5) & r4;
        if (this.keys[r14] != r17) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == true) goto L19;
        r12 = r12 & (r12 - 1);
    L19:
        if (r14 >= 0) goto L21;
    L24:
        return false;
    L21:
        if (Intrinsics.areEqual(this.values[r14], r18) == false) goto L24;
        removeValueAt(r14);
        return true;
    L12:
        r15 = false;
        goto L13
    L17:
        if (((r10 & ((~r10) << 6)) & (-9187201950435737472L)) != 0) goto L18;
        r6 = r6 + 8;
        r5 = (r5 + r6) & r4;
        goto L3
    L18:
        r14 = -1;
        goto L19
    L7:
        r13 = false;
        goto L8
    }

    public final void set(float r3, V r4) {
        int r0 = findAbsoluteInsertIndex(r3);
        this.keys[r0] = r3;
        this.values[r0] = r4;
    }

    public /* synthetic */ MutableFloatObjectMap(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }
}
