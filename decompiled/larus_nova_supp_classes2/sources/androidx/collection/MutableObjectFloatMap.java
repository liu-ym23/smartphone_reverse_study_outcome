package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J'\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015J#\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u001b\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u0013\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020\t2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\"H\u0086\bø\u0001\u0000J\u0016\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u001dJ\u001e\u0010#\u001a\u00020\t2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000%H\u0086\n¢\u0006\u0002\u0010&J\u0017\u0010#\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0086\nJ\u0017\u0010#\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0086\nJ\u0017\u0010#\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0086\nJ\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0004H\u0001J\u0006\u0010,\u001a\u00020\tJ\u0015\u0010-\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002J\u0006\u00101\u001a\u00020\u0004J\r\u00102\u001a\u00020\tH\u0000¢\u0006\u0002\b3J\r\u00104\u001a\u00020\tH\u0000¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0004H\u0000¢\u0006\u0002\b8R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"Landroidx/collection/MutableObjectFloatMap;", "K", "Landroidx/collection/ObjectFloatMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)F", "set", "value", "(Ljava/lang/Object;F)V", "put", "default", "(Ljava/lang/Object;FF)F", "putAll", "from", "plusAssign", "remove", "(Ljava/lang/Object;)V", "", "(Ljava/lang/Object;F)Z", "removeIf", "predicate", "Lkotlin/Function2;", "minusAssign", "keys", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "Landroidx/collection/ScatterSet;", "removeValueAt", "index", "clear", "findIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableObjectFloatMap<K> extends ObjectFloatMap<K> {
    private int growthLimit;

    public MutableObjectFloatMap() {
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
        ArraysKt.fill(this.keys, null, 0, this._capacity);
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
        Object[] r3 = this.keys;
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
        if (r12 == r2) goto L25;
        int r13 = r12 >> 3;
        int r14 = (r12 & 7) << 3;
        long r15 = (r1[r13] >> r14) & 255;
        if (r15 == 128) goto L9;
        if (r15 != 254) goto L9;
        Object r16 = r3[r12];
        if (r16 == null) goto L16;
        int r17 = r16.hashCode();
    L17:
        int r18 = r17 * ScatterMapKt.MurmurHashC1;
        int r19 = r18 ^ (r18 << 16);
        int r20 = r19 >>> 7;
        int r110 = findFirstAvailableSlot(r20);
        int r21 = r20 & r2;
        if ((((r110 - r21) & r2) / 8) == (((r12 - r21) & r2) / 8)) goto L19;
        int r22 = r110 >> 3;
        long r111 = r1[r22];
        int r112 = (r110 & 7) << 3;
        if (((r111 >> r112) & 255) != 128) goto L23;
        r1[r22] = ((~(255 << r112)) & r111) | (((long) (r19 & 127)) << r112);
        r1[r13] = (r1[r13] & (~(255 << r14))) | (128 << r14);
        r3[r110] = r3[r12];
        r3[r12] = null;
        r4[r110] = r4[r12];
        r4[r12] = 0.0f;
    L24:
        r11 = 72057594037927935L;
        r1[ArraysKt.getLastIndex(r1)] = (r1[0] & 72057594037927935L) | Long.MIN_VALUE;
        r12 = r12 + 1;
        r6 = 0;
        goto L6
    L23:
        r1[r22] = (((long) (r19 & 127)) << r112) | ((~(255 << r112)) & r111);
        Object r23 = r3[r110];
        r3[r110] = r3[r12];
        r3[r12] = r23;
        float r24 = r4[r110];
        r4[r110] = r4[r12];
        r4[r12] = r24;
        r12 = r12 - 1;
        goto L24
    L19:
        long r25 = ((long) (r19 & 127)) << r14;
        r1[r13] = r25 | ((~(255 << r14)) & r1[r13]);
        r1[ArraysKt.getLastIndex(r1)] = (r1[r6] & r11) | Long.MIN_VALUE;
        goto L9
    L16:
        r17 = 0;
    L9:
        r12 = r12 + 1;
        goto L6
    L25:
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

    public MutableObjectFloatMap(int r2) {
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

    private final int findIndex(K r21) {
        if (r21 == null) goto L5;
        int r3 = r21.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 >>> 7;
        int r7 = r5 & 127;
        int r8 = this._capacity;
        int r9 = r6 & r8;
        int r10 = 0;
    L7:
        long[] r11 = this.metadata;
        int r12 = r9 >> 3;
        int r13 = (r9 & 7) << 3;
        long r14 = ((r11[r12 + 1] << (64 - r13)) & ((-r13) >> 63)) | (r11[r12] >>> r13);
        long r15 = r7;
        int r18 = r7;
        long r2 = r14 ^ (r15 * ScatterMapKt.BitmaskLsb);
        long r16 = ((~r2) & (r2 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r16 == 0) goto L11;
        boolean r19 = true;
    L12:
        if (r19 == false) goto L18;
        int r17 = (r9 + (Long.numberOfTrailingZeros(r16) >> 3)) & r8;
        if (Intrinsics.areEqual(this.keys[r17], r21) == true) goto L15;
        r16 = r16 & (r16 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((((~r14) << 6) & r14) & (-9187201950435737472L)) != 0) goto L19;
        r10 = r10 + 8;
        r9 = (r9 + r10) & r8;
        r7 = r18;
        goto L7
    L19:
        int r1 = findFirstAvailableSlot(r6);
        if (this.growthLimit == 0) goto L22;
    L27:
        this._size++;
        int r20 = this.growthLimit;
        long[] r22 = this.metadata;
        int r23 = r1 >> 3;
        long r24 = r22[r23];
        int r25 = (r1 & 7) << 3;
        if (((r24 >> r25) & 255) != 128) goto L30;
        int r110 = 1;
    L31:
        this.growthLimit = r20 - r110;
        int r26 = this._capacity;
        long r27 = ((~(255 << r25)) & r24) | (r15 << r25);
        r22[r23] = r27;
        r22[(((r1 - 7) & r26) + (r26 & 7)) >> 3] = r27;
        return ~r1;
    L30:
        r110 = 0;
        goto L31
    L22:
        if (((this.metadata[r1 >> 3] >> ((r1 & 7) << 3)) & 255) != 254) goto L24;
        boolean r28 = true;
    L25:
        if (r28 == true) goto L27;
        adjustStorage$collection();
        r1 = findFirstAvailableSlot(r6);
        goto L27
    L24:
        r28 = false;
        goto L25
    L11:
        r19 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
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
        this.keys = new Object[r3];
        this.values = new float[r3];
        return;
    L4:
        r3 = 0;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> r15) {
        Intrinsics.checkNotNullParameter(r15, "keys");
        Object[] r0 = r15.elements;
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

    public final void plusAssign(ObjectFloatMap<K> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ObjectFloatMap<K> r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        Object[] r1 = r17.keys;
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

    public final void remove(K r1) {
        int r2 = findKeyIndex(r1);
        if (r2 < 0) goto L6;
        removeValueAt(r2);
        return;
    }

    public final void removeIf(Function2<? super K, ? super Float, Boolean> r15) {
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
        if (((Boolean) r15.invoke(this.keys[r10], Float.valueOf(this.values[r10]))).booleanValue() == false) goto L17;
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
        this.keys[r9] = null;
    }

    public final void resizeStorage$collection(int r21) {
        long[] r1 = this.metadata;
        Object[] r2 = this.keys;
        float[] r3 = this.values;
        int r4 = this._capacity;
        initializeStorage(r21);
        long[] r5 = this.metadata;
        Object[] r6 = this.keys;
        float[] r7 = this.values;
        int r8 = this._capacity;
        int r10 = 0;
    L3:
        if (r10 >= r4) goto L16;
        if (((r1[r10 >> 3] >> ((r10 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L14;
        Object r12 = r2[r10];
        if (r12 == null) goto L12;
        int r13 = r12.hashCode();
    L13:
        int r14 = r13 * ScatterMapKt.MurmurHashC1;
        int r15 = r14 ^ (r14 << 16);
        int r16 = findFirstAvailableSlot(r15 >>> 7);
        int r17 = r10;
        long r9 = r15 & 127;
        int r18 = r16 >> 3;
        int r19 = (r16 & 7) << 3;
        long r20 = (r9 << r19) | (r5[r18] & (~(255 << r19)));
        r5[r18] = r20;
        r5[(((r16 - 7) & r8) + (r8 & 7)) >> 3] = r20;
        r6[r16] = r12;
        r7[r16] = r3[r17];
    L15:
        r10 = r17 + 1;
        goto L3
    L12:
        r13 = 0;
        goto L13
    L14:
        r17 = r10;
        goto L15
    L7:
        r11 = false;
        goto L8
    }

    public final void minusAssign(Iterable<? extends K> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        Iterator<? extends K> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Sequence<? extends K> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    public final void minusAssign(K[] r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(K r1) {
        remove(r1);
    }

    public final float getOrPut(K r2, Function0<Float> r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        int r0 = findKeyIndex(r2);
        if (r0 >= 0) goto L5;
        float r4 = ((Number) r3.invoke()).floatValue();
        set(r2, r4);
        return r4;
    L5:
        return this.values[r0];
    }

    public final void put(K r1, float r2) {
        set(r1, r2);
    }

    public final boolean remove(K r4, float r5) {
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

    public final void set(K r3, float r4) {
        int r0 = findIndex(r3);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L5:
        this.keys[r0] = r3;
        this.values[r0] = r4;
    }

    public /* synthetic */ MutableObjectFloatMap(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }

    public final float put(K r3, float r4, float r5) {
        int r0 = findIndex(r3);
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
