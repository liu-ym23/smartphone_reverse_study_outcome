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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010#\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0013\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u001e\u0010\u001d\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J \u0010\u001f\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!H\u0086\bø\u0001\u0000J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000#J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J \u0010\"\u001a\u00020\u000e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0!H\u0086\bø\u0001\u0000J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0001J\u0011\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0082\bJ\u0011\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0082\bJ\u0006\u0010(\u001a\u00020\tJ\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0007J\u000e\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0004J\r\u00100\u001a\u00020\tH\u0000¢\u0006\u0002\b1J\r\u00102\u001a\u00020\tH\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0004H\u0000¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020\t2\u0006\u00108\u001a\u000209H\u0002J\u0010\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020:H\u0002J\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, d2 = {"Landroidx/collection/MutableOrderedScatterSet;", "E", "Landroidx/collection/OrderedScatterSet;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "add", "", "element", "(Ljava/lang/Object;)Z", "plusAssign", "(Ljava/lang/Object;)V", "addAll", "elements", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "Landroidx/collection/ScatterSet;", "Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)V", "remove", "minusAssign", "removeAll", "removeIf", "predicate", "Lkotlin/Function1;", "retainAll", "", "removeElementAt", "index", "moveNodeToHead", "removeNode", "clear", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "trimToSize", "maxSize", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "fixupNodes", "mapping", "", "", "asMutableSet", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableOrderedScatterSet<E> extends OrderedScatterSet<E> {
    private int growthLimit;

    public MutableOrderedScatterSet() {
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
        ArraysKt.fill$default(this.nodes, 4611686018427387903L, 0, 0, 6, null);
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
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
        return new MutableOrderedSetWrapper(this);
    }

    public final void dropDeletes$collection() {
        long[] r1 = this.metadata;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = this._capacity;
        Object[] r3 = this.elements;
        long[] r4 = this.nodes;
        long[] r5 = new long[r2];
        ArraysKt.fill(r5, SieveCacheKt.InvalidMapping, 0, r2);
        int r9 = (r2 + 7) >> 3;
        int r10 = 0;
    L6:
        if (r10 >= r9) goto L8;
        long r11 = r1[r10] & (-9187201950435737472L);
        r1[r10] = (-72340172838076674L) & ((~r11) + (r11 >>> 7));
        r10 = r10 + 1;
        goto L6
    L8:
        int r12 = ArraysKt.getLastIndex(r1);
        int r13 = r12 - 1;
        r1[r13] = (r1[r13] & 72057594037927935L) | (-72057594037927936L);
        r1[r12] = r1[0];
        int r14 = 0;
    L9:
        if (r14 == r2) goto L40;
        int r15 = r14 >> 3;
        int r16 = (r14 & 7) << 3;
        long r17 = (r1[r15] >> r16) & 255;
        if (r17 == 128) goto L12;
        if (r17 != 254) goto L12;
        Object r18 = r3[r14];
        if (r18 == null) goto L19;
        int r19 = r18.hashCode();
    L20:
        int r110 = r19 * ScatterMapKt.MurmurHashC1;
        int r111 = r110 ^ (r110 << 16);
        int r112 = r111 >>> 7;
        int r8 = findFirstAvailableSlot(r112);
        int r113 = r112 & r2;
        if ((((r8 - r113) & r2) / 8) != (((r14 - r113) & r2) / 8)) goto L27;
        r1[r15] = (((long) (r111 & 127)) << r16) | (r1[r15] & (~(255 << r16)));
        if (r5[r14] != SieveCacheKt.InvalidMapping) goto L25;
        long r6 = r14;
        r5[r14] = r6 | (r6 << 32);
    L25:
        r1[r1.length - 1] = r1[0];
        r14 = r14 + 1;
        goto L9
    L27:
        int r7 = r8 >> 3;
        long r21 = r1[r7];
        int r20 = (r8 & 7) << 3;
        if (((r21 >> r20) & 255) != 128) goto L34;
        long[] r29 = r4;
        long[] r30 = r5;
        r1[r7] = (r21 & (~(255 << r20))) | (((long) (r111 & 127)) << r20);
        r1[r15] = (r1[r15] & (~(255 << r16))) | (128 << r16);
        r3[r8] = r3[r14];
        r3[r14] = null;
        r29[r8] = r29[r14];
        r29[r14] = 4611686018427387903L;
        int r22 = (int) ((r30[r14] >> 32) & 4294967295L);
        if (r22 == Integer.MAX_VALUE) goto L32;
        r30[r22] = (r30[r22] & (-4294967296L)) | ((long) r8);
        r30[r14] = (r30[r14] & 4294967295L) | (-4294967296L);
        char r23 = ' ';
    L33:
        r30[r8] = (((long) r14) << r23) | ((long) Integer.MAX_VALUE);
    L39:
        r1[r1.length - 1] = r1[0];
        r14 = r14 + 1;
        r4 = r29;
        r5 = r30;
        goto L9
    L32:
        r23 = ' ';
        r30[r14] = (((long) Integer.MAX_VALUE) << 32) | ((long) r8);
        goto L33
    L34:
        r29 = r4;
        r30 = r5;
        r1[r7] = (((long) (r111 & 127)) << r20) | (r21 & (~(255 << r20)));
        Object r24 = r3[r8];
        r3[r8] = r3[r14];
        r3[r14] = r24;
        long r25 = r29[r8];
        r29[r8] = r29[r14];
        r29[r14] = r25;
        int r26 = (int) ((r30[r14] >> 32) & 4294967295L);
        if (r26 == Integer.MAX_VALUE) goto L37;
        long r114 = r8;
        r30[r26] = (r30[r26] & (-4294967296L)) | r114;
        r30[r14] = (r30[r14] & 4294967295L) | (r114 << 32);
    L38:
        r30[r8] = (((long) r26) << 32) | ((long) r14);
        r14 = r14 - 1;
        goto L39
    L37:
        long r27 = r8;
        r30[r14] = r27 | (r27 << 32);
        r26 = r14;
        goto L38
    L19:
        r19 = 0;
    L12:
        r14 = r14 + 1;
        goto L9
    L40:
        initializeGrowth();
        fixupNodes(r5);
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

    public MutableOrderedScatterSet(int r2) {
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

    private final void fixupNodes(long[] r14) {
        long[] r0 = this.nodes;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        int r5 = Integer.MAX_VALUE;
        if (r2 >= r1) goto L14;
        long r6 = r0[r2];
        int r10 = (int) ((r6 >> 31) & SieveCacheKt.NodeLinkMask);
        int r9 = (int) (SieveCacheKt.NodeLinkMask & r6);
        long r7 = r6 & SieveCacheKt.NodeMetaMask;
        if (r10 != Integer.MAX_VALUE) goto L8;
        int r11 = Integer.MAX_VALUE;
    L9:
        long r8 = (r7 | ((long) r11)) << 31;
        if (r9 == Integer.MAX_VALUE) goto L13;
        r5 = (int) (4294967295L & r14[r9]);
    L13:
        r0[r2] = ((long) r5) | r8;
        r2 = r2 + 1;
        goto L3
    L8:
        r11 = (int) (r14[r10] & 4294967295L);
        goto L9
    L14:
        int r3 = this.head;
        if (r3 == Integer.MAX_VALUE) goto L17;
        this.head = (int) (r14[r3] & 4294967295L);
    L17:
        int r4 = this.tail;
        if (r4 == Integer.MAX_VALUE) goto L24;
        this.tail = (int) (r14[r4] & 4294967295L);
        return;
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

    private final void initializeStorage(int r8) {
        if (r8 <= 0) goto L4;
        int r9 = Math.max(7, ScatterMapKt.normalizeCapacity(r8));
    L5:
        this._capacity = r9;
        initializeMetadata(r9);
        if (r9 != 0) goto L8;
        Object[] r0 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.elements = r0;
        if (r9 != 0) goto L12;
        long[] r10 = SieveCacheKt.getEmptyNodes();
    L13:
        this.nodes = r10;
        return;
    L12:
        r10 = new long[r9];
        ArraysKt.fill$default(r10, 4611686018427387903L, 0, 0, 6, null);
        goto L13
    L8:
        r0 = new Object[r9];
        goto L9
    L4:
        r9 = 0;
        goto L5
    }

    private final void moveNodeToHead(int r11) {
        long[] r0 = this.nodes;
        int r1 = this.head;
        r0[r11] = (((long) r1) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r1 == Integer.MAX_VALUE) goto L5;
        long r6 = r0[r1] & SieveCacheKt.NodeMetaAndNextMask;
        r0[r1] = ((((long) r11) & SieveCacheKt.NodeLinkMask) << 31) | r6;
    L5:
        this.head = r11;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r11;
        return;
    }

    private final void removeNode(int r13) {
        long[] r0 = this.nodes;
        long r1 = r0[r13];
        int r5 = (int) ((r1 >> 31) & SieveCacheKt.NodeLinkMask);
        int r2 = (int) (r1 & SieveCacheKt.NodeLinkMask);
        if (r5 == Integer.MAX_VALUE) goto L5;
        r0[r5] = (r0[r5] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r2) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r2 == Integer.MAX_VALUE) goto L8;
        long r8 = r0[r2] & SieveCacheKt.NodeMetaAndNextMask;
        r0[r2] = ((((long) r5) & SieveCacheKt.NodeLinkMask) << 31) | r8;
    L9:
        r0[r13] = 4611686018427387903L;
        return;
    L8:
        this.tail = r5;
        goto L9
    L5:
        this.head = r2;
        goto L6
    }

    public final boolean add(E r12) {
        int r0 = getSize();
        int r1 = findAbsoluteInsertIndex(r12);
        this.elements[r1] = r12;
        long[] r13 = this.nodes;
        int r2 = this.head;
        r13[r1] = (((long) r2) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r2 == Integer.MAX_VALUE) goto L5;
        long r7 = r13[r2] & SieveCacheKt.NodeMetaAndNextMask;
        r13[r2] = ((((long) r1) & SieveCacheKt.NodeLinkMask) << 31) | r7;
    L5:
        this.head = r1;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r1;
    L9:
        if (getSize() == r0) goto L11;
        return true;
    L11:
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

    public final void removeElementAt(int r13) {
        this._size--;
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r13 >> 3;
        int r3 = (r13 & 7) << 3;
        long r4 = (r0[r2] & (~(255 << r3))) | (254 << r3);
        r0[r2] = r4;
        r0[(((r13 - 7) & r1) + (r1 & 7)) >> 3] = r4;
        this.elements[r13] = null;
        long[] r5 = this.nodes;
        long r6 = r5[r13];
        int r7 = (int) ((r6 >> 31) & SieveCacheKt.NodeLinkMask);
        int r8 = (int) (r6 & SieveCacheKt.NodeLinkMask);
        if (r7 == Integer.MAX_VALUE) goto L5;
        r5[r7] = (r5[r7] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r8) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r8 == Integer.MAX_VALUE) goto L8;
        r5[r8] = ((((long) r7) & SieveCacheKt.NodeLinkMask) << 31) | (r5[r8] & SieveCacheKt.NodeMetaAndNextMask);
    L9:
        r5[r13] = 4611686018427387903L;
        return;
    L8:
        this.tail = r7;
        goto L9
    L5:
        this.head = r8;
        goto L6
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

    public final void resizeStorage$collection(int r24) {
        long[] r1 = this.metadata;
        Object[] r2 = this.elements;
        long[] r3 = this.nodes;
        int r4 = this._capacity;
        int[] r5 = new int[r4];
        initializeStorage(r24);
        long[] r6 = this.metadata;
        Object[] r7 = this.elements;
        long[] r8 = this.nodes;
        int r9 = this._capacity;
        int r11 = 0;
    L3:
        if (r11 >= r4) goto L16;
        if (((r1[r11 >> 3] >> ((r11 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L15;
        Object r13 = r2[r11];
        if (r13 == null) goto L12;
        int r14 = r13.hashCode();
    L13:
        int r15 = r14 * ScatterMapKt.MurmurHashC1;
        int r16 = r15 ^ (r15 << 16);
        int r10 = findFirstAvailableSlot(r16 >>> 7);
        long r17 = r16 & 127;
        int r18 = r10 >> 3;
        int r19 = (r10 & 7) << 3;
        long r20 = (r6[r18] & (~(255 << r19))) | (r17 << r19);
        r6[r18] = r20;
        r6[(((r10 - 7) & r9) + (r9 & 7)) >> 3] = r20;
        r7[r10] = r13;
        r8[r10] = r3[r11];
        r5[r11] = r10;
        goto L15
    L12:
        r14 = 0;
    L15:
        r11 = r11 + 1;
        r1 = r1;
        r2 = r2;
        goto L3
    L7:
        r12 = false;
        goto L8
    L16:
        fixupNodes(r5);
    }

    public final boolean retainAll(Function1<? super E, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.elements;
        int r3 = getSize();
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
        if (r3 != getSize()) goto L32;
        return false;
    L32:
        return true;
    }

    public final void trimToSize(int r7) {
        long[] r0 = this.nodes;
        int r1 = this.head;
    L4:
        if (r1 == Integer.MAX_VALUE) goto L9;
        int r2 = this._size;
        if (r2 <= r7) goto L13;
        if (r2 == 0) goto L14;
        int r3 = (int) (r0[r1] & SieveCacheKt.NodeLinkMask);
        removeElementAt(r1);
        r1 = r3;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    private final void fixupNodes(int[] r12) {
        long[] r0 = this.nodes;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        int r3 = Integer.MAX_VALUE;
        if (r2 >= r1) goto L14;
        long r4 = r0[r2];
        int r8 = (int) ((r4 >> 31) & SieveCacheKt.NodeLinkMask);
        int r7 = (int) (SieveCacheKt.NodeLinkMask & r4);
        long r5 = r4 & SieveCacheKt.NodeMetaMask;
        if (r8 != Integer.MAX_VALUE) goto L8;
        int r9 = Integer.MAX_VALUE;
    L9:
        long r6 = (r5 | ((long) r9)) << 31;
        if (r7 == Integer.MAX_VALUE) goto L13;
        r3 = r12[r7];
    L13:
        r0[r2] = r6 | ((long) r3);
        r2 = r2 + 1;
        goto L3
    L8:
        r9 = r12[r8];
        goto L9
    L14:
        int r10 = this.head;
        if (r10 == Integer.MAX_VALUE) goto L17;
        this.head = r12[r10];
    L17:
        int r11 = this.tail;
        if (r11 == Integer.MAX_VALUE) goto L24;
        this.tail = r12[r11];
        return;
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

    public final void plusAssign(E r11) {
        int r0 = findAbsoluteInsertIndex(r11);
        this.elements[r0] = r11;
        long[] r12 = this.nodes;
        int r1 = this.head;
        r12[r0] = (((long) r1) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r1 == Integer.MAX_VALUE) goto L5;
        long r6 = r12[r1] & SieveCacheKt.NodeMetaAndNextMask;
        r12[r1] = ((((long) r0) & SieveCacheKt.NodeLinkMask) << 31) | r6;
    L5:
        this.head = r0;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r0;
        return;
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

    public final void plusAssign(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator<? extends E> r3 = r2.iterator();
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
    public final void plusAssign(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        plusAssign(r3.next());
        goto L4
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

    public /* synthetic */ MutableOrderedScatterSet(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }
}
