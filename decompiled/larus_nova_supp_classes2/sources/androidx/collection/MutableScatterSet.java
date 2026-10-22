package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0010#\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0013\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u001d\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J \u0010\u001f\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!H\u0086\bø\u0001\u0000J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u001a\u0010\"\u001a\u00020\u000e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0001J\u0006\u0010&\u001a\u00020\tJ\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0007J\r\u0010,\u001a\u00020\tH\u0000¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0004H\u0000¢\u0006\u0002\b2J\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/collection/MutableScatterSet;", "E", "Landroidx/collection/ScatterSet;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "add", "", "element", "(Ljava/lang/Object;)Z", "plusAssign", "(Ljava/lang/Object;)V", "addAll", "elements", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "Landroidx/collection/OrderedScatterSet;", "Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)V", "remove", "minusAssign", "removeAll", "removeIf", "predicate", "Lkotlin/Function1;", "retainAll", "", "removeElementAt", "index", "clear", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "asMutableSet", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    public MutableScatterSet() {
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
        ArraysKt.fill(this.elements, null, 0, this._capacity);
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

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper(this);
    }

    public final void dropDeletes$collection() {
        long[] r1 = this.metadata;
        int r2 = this._capacity;
        Object[] r3 = this.elements;
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
        if (r11 == r2) goto L25;
        int r12 = r11 >> 3;
        int r13 = (r11 & 7) << 3;
        long r14 = (r1[r12] >> r13) & 255;
        if (r14 == 128) goto L9;
        if (r14 != 254) goto L9;
        Object r15 = r3[r11];
        if (r15 == null) goto L16;
        int r16 = r15.hashCode();
    L17:
        int r17 = r16 * ScatterMapKt.MurmurHashC1;
        int r18 = r17 ^ (r17 << 16);
        int r19 = r18 >>> 7;
        int r110 = findFirstAvailableSlot(r19);
        int r20 = r19 & r2;
        if ((((r110 - r20) & r2) / 8) == (((r11 - r20) & r2) / 8)) goto L19;
        int r21 = r110 >> 3;
        long r111 = r1[r21];
        int r112 = (r110 & 7) << 3;
        if (((r111 >> r112) & 255) != 128) goto L23;
        r1[r21] = ((~(255 << r112)) & r111) | (((long) (r18 & 127)) << r112);
        r1[r12] = (r1[r12] & (~(255 << r13))) | (128 << r13);
        r3[r110] = r3[r11];
        r3[r11] = null;
    L24:
        r10 = 72057594037927935L;
        r1[ArraysKt.getLastIndex(r1)] = (r1[0] & 72057594037927935L) | Long.MIN_VALUE;
        r11 = r11 + 1;
        r5 = 0;
        goto L6
    L23:
        r1[r21] = (((long) (r18 & 127)) << r112) | ((~(255 << r112)) & r111);
        Object r22 = r3[r110];
        r3[r110] = r3[r11];
        r3[r11] = r22;
        r11 = r11 - 1;
        goto L24
    L19:
        long r23 = ((long) (r18 & 127)) << r13;
        r1[r12] = r23 | ((~(255 << r13)) & r1[r12]);
        r1[ArraysKt.getLastIndex(r1)] = (r1[r5] & r10) | Long.MIN_VALUE;
        goto L9
    L16:
        r16 = 0;
    L9:
        r11 = r11 + 1;
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

    public MutableScatterSet(int r2) {
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

    private final int findAbsoluteInsertIndex(E r21) {
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
        if (Intrinsics.areEqual(this.elements[r17], r21) == true) goto L15;
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
        return r1;
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
        if (r3 != 0) goto L8;
        Object[] r4 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.elements = r4;
        return;
    L8:
        r4 = new Object[r3];
        goto L9
    L4:
        r3 = 0;
        goto L5
    }

    public final boolean add(E r4) {
        int r0 = getSize();
        int r1 = findAbsoluteInsertIndex(r4);
        this.elements[r1] = r4;
        if (getSize() == r0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E r18) {
        if (r18 == null) goto L5;
        int r3 = r18.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 & 127;
        int r7 = this._capacity;
        int r8 = (r5 >>> 7) & r7;
        int r9 = 0;
    L7:
        long[] r10 = this.metadata;
        int r11 = r8 >> 3;
        int r12 = (r8 & 7) << 3;
        long r13 = ((r10[r11 + 1] << (64 - r12)) & ((-r12) >> 63)) | (r10[r11] >>> r12);
        long r14 = (((long) r6) * ScatterMapKt.BitmaskLsb) ^ r13;
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r15 == 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L18;
        int r17 = ((Long.numberOfTrailingZeros(r15) >> 3) + r8) & r7;
        if (Intrinsics.areEqual(this.elements[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 < 0) goto L27;
        removeElementAt(r17);
        return;
    L27:
        return;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        r17 = -1;
        goto L20
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> r15) {
        Intrinsics.checkNotNullParameter(r15, "elements");
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

    public final boolean remove(E r18) {
        boolean r2 = false;
        if (r18 == null) goto L5;
        int r3 = r18.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 & 127;
        int r7 = this._capacity;
        int r8 = (r5 >>> 7) & r7;
        int r9 = 0;
    L7:
        long[] r10 = this.metadata;
        int r11 = r8 >> 3;
        int r12 = (r8 & 7) << 3;
        long r13 = ((r10[r11 + 1] << (64 - r12)) & ((-r12) >> 63)) | (r10[r11] >>> r12);
        long r14 = (((long) r6) * ScatterMapKt.BitmaskLsb) ^ r13;
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r15 == 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L18;
        int r17 = ((Long.numberOfTrailingZeros(r15) >> 3) + r8) & r7;
        if (Intrinsics.areEqual(this.elements[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 < 0) goto L22;
        r2 = true;
    L22:
        if (r2 == false) goto L24;
        removeElementAt(r17);
    L24:
        return r2;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        r17 = -1;
        goto L20
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final boolean removeAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void removeElementAt(int r9) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r9 >> 3;
        int r3 = (r9 & 7) << 3;
        long r4 = (r0[r2] & (~(255 << r3))) | (254 << r3);
        r0[r2] = r4;
        r0[(((r9 - 7) & r1) + (r1 & 7)) >> 3] = r4;
        this.elements[r9] = null;
    }

    public final void removeIf(Function1<? super E, Boolean> r18) {
        Intrinsics.checkNotNullParameter(r18, "predicate");
        Object[] r2 = this.elements;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L21;
        int r6 = 0;
    L5:
        long r7 = r3[r6];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r9 = 8 - ((~(r6 - r4)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L18;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L17;
        int r13 = (r6 << 3) + r11;
        if (((Boolean) r18.invoke(r2[r13])).booleanValue() == false) goto L17;
        removeElementAt(r13);
    L17:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L18:
        if (r9 == 8) goto L19;
        return;
    L19:
        if (r6 == r4) goto L29;
        r6 = r6 + 1;
        goto L5
    L29:
        return;
    }

    public final void resizeStorage$collection(int r20) {
        long[] r1 = this.metadata;
        Object[] r2 = this.elements;
        int r3 = this._capacity;
        initializeStorage(r20);
        long[] r4 = this.metadata;
        Object[] r5 = this.elements;
        int r6 = this._capacity;
        int r8 = 0;
    L3:
        if (r8 >= r3) goto L15;
        if (((r1[r8 >> 3] >> ((r8 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L14;
        Object r10 = r2[r8];
        if (r10 == null) goto L12;
        int r11 = r10.hashCode();
    L13:
        int r12 = r11 * ScatterMapKt.MurmurHashC1;
        int r13 = r12 ^ (r12 << 16);
        int r14 = findFirstAvailableSlot(r13 >>> 7);
        long r15 = r13 & 127;
        int r16 = r14 >> 3;
        int r17 = (r14 & 7) << 3;
        long r18 = (r4[r16] & (~(255 << r17))) | (r15 << r17);
        r4[r16] = r18;
        r4[(((r14 - 7) & r6) + (r6 & 7)) >> 3] = r18;
        r5[r14] = r10;
        goto L14
    L12:
        r11 = 0;
    L14:
        r8 = r8 + 1;
        goto L3
    L7:
        r9 = false;
        goto L8
    }

    public final boolean retainAll(Function1<? super E, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.elements;
        int r3 = this._size;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L22;
        int r8 = 0;
    L5:
        long r9 = r4[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        if (((Boolean) r20.invoke(r2[r15])).booleanValue() == true) goto L17;
        removeElementAt(r15);
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L22;
    L19:
        if (r8 == r5) goto L22;
        r8 = r8 + 1;
    L22:
        if (r3 != this._size) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean addAll(OrderedScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> r15) {
        Intrinsics.checkNotNullParameter(r15, "elements");
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(OrderedScatterSet<E> r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        Object[] r0 = r7.elements;
        long[] r1 = r7.nodes;
        int r8 = r7.tail;
    L4:
        if (r8 == Integer.MAX_VALUE) goto L6;
        int r3 = (int) ((r1[r8] >> 31) & SieveCacheKt.NodeLinkMask);
        plusAssign(r0[r8]);
        r8 = r3;
        goto L4
    }

    public final boolean removeAll(OrderedScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Collection<? extends E> r20) {
        Intrinsics.checkNotNullParameter(r20, "elements");
        Object[] r2 = this.elements;
        int r3 = this._size;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L22;
        int r8 = 0;
    L5:
        long r9 = r4[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        if (CollectionsKt.contains(r20, r2[r15]) == true) goto L17;
        removeElementAt(r15);
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L22;
    L19:
        if (r8 == r5) goto L22;
        r8 = r8 + 1;
    L22:
        if (r3 == this._size) goto L24;
        return true;
    L24:
        return false;
    }

    public final boolean addAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(OrderedScatterSet<E> r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        Object[] r0 = r7.elements;
        long[] r1 = r7.nodes;
        int r8 = r7.tail;
    L4:
        if (r8 == Integer.MAX_VALUE) goto L6;
        int r3 = (int) ((r1[r8] >> 31) & SieveCacheKt.NodeLinkMask);
        minusAssign(r0[r8]);
        r8 = r3;
        goto L4
    }

    public final void plusAssign(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator<? extends E> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        plusAssign(r3.next());
        goto L4
    }

    public final boolean removeAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(OrderedScatterSet<E> r20) {
        Intrinsics.checkNotNullParameter(r20, "elements");
        Object[] r2 = this.elements;
        int r3 = this._size;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L22;
        int r8 = 0;
    L5:
        long r9 = r4[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        if (r20.contains(r2[r15]) == true) goto L17;
        removeElementAt(r15);
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L22;
    L19:
        if (r8 == r5) goto L22;
        r8 = r8 + 1;
    L22:
        if (r3 != this._size) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean addAll(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator<? extends E> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        minusAssign(r3.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        plusAssign(r3.next());
        goto L4
    }

    public final boolean removeAll(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ScatterSet<E> r20) {
        Intrinsics.checkNotNullParameter(r20, "elements");
        Object[] r2 = this.elements;
        int r3 = this._size;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L22;
        int r8 = 0;
    L5:
        long r9 = r4[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        if (r20.contains(r2[r15]) == true) goto L17;
        removeElementAt(r15);
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L22;
    L19:
        if (r8 == r5) goto L22;
        r8 = r8 + 1;
    L22:
        if (r3 != this._size) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean addAll(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        minusAssign(r3.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ObjectList<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        plusAssign(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final boolean removeAll(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean addAll(E[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        plusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        minusAssign(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(E[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        plusAssign(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final boolean removeAll(E[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = getSize();
        minusAssign(r2);
        if (r0 == getSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        minusAssign(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(E r3) {
        int r0 = findAbsoluteInsertIndex(r3);
        this.elements[r0] = r3;
    }

    public /* synthetic */ MutableScatterSet(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }
}
