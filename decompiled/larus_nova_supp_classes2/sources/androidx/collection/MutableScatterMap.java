package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\nH\u0002J'\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012JS\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u000028\u0010\u0014\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00028\u00010\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0002\u0010\u001dJ'\u0010\u001e\u001a\u00020\n2\u001a\u0010\u001f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 ¢\u0006\u0002\u0010\"J \u0010\u001e\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0#J \u0010\u001e\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0$J\u001a\u0010\u001e\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\u001a\u0010\u001e\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\u001d\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0086\nJ*\u0010'\u001a\u00020\n2\u001a\u0010\u001f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0 H\u0086\n¢\u0006\u0002\u0010\"J#\u0010'\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0#H\u0086\nJ#\u0010'\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!0$H\u0086\nJ\u001d\u0010'\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0086\nJ\u001d\u0010'\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\nJ\u0015\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010*J\u001b\u0010)\u001a\u00020+2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0002\u0010,J&\u0010-\u001a\u00020\n2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020+0\u0015H\u0086\bø\u0001\u0000J\u0016\u0010/\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u00100J\u001e\u0010/\u001a\u00020\n2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000 H\u0086\n¢\u0006\u0002\u00102J\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086\nJ\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0086\nJ\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0086\nJ\u0017\u0010/\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0086\nJ\u0017\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00107J\u0006\u00108\u001a\u00020\nJ\u0015\u00109\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0006\u0010=\u001a\u00020\u0005J\r\u0010>\u001a\u00020\nH\u0000¢\u0006\u0002\b?J\r\u0010@\u001a\u00020\nH\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0005H\u0000¢\u0006\u0002\bDJ\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FR\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006G"}, d2 = {"Landroidx/collection/MutableScatterMap;", "K", "V", "Landroidx/collection/ScatterMap;", "initialCapacity", "", "<init>", "(I)V", "growthLimit", "initializeStorage", "", "initializeMetadata", "capacity", "initializeGrowth", "getOrPut", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "compute", "computeBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "from", "", "plusAssign", "pair", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "minusAssign", "(Ljava/lang/Object;)V", "keys", "([Ljava/lang/Object;)V", "Landroidx/collection/ScatterSet;", "Landroidx/collection/ObjectList;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "clear", "findInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "trim", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "asMutableMap", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {
    private int growthLimit;

    public MutableScatterMap() {
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

    public final Map<K, V> asMutableMap() {
        return new MutableMapWrapper(this);
    }

    public final void dropDeletes$collection() {
        long[] r1 = this.metadata;
        int r2 = this._capacity;
        Object[] r3 = this.keys;
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
        r1[r10] = (r1[r10] & 72057594037927935L) | (-72057594037927936L);
        r1[r9] = r1[0];
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
        Object[] r22 = r3;
        r1[r21] = ((~(255 << r112)) & r111) | (((long) (r18 & 127)) << r112);
        r1[r12] = (r1[r12] & (~(255 << r13))) | (128 << r13);
        r22[r110] = r22[r11];
        r22[r11] = null;
        r4[r110] = r4[r11];
        r4[r11] = null;
    L24:
        r1[ArraysKt.getLastIndex(r1)] = r1[0];
        r11 = r11 + 1;
        r2 = r2;
        r3 = r22;
        r6 = 0;
        goto L6
    L23:
        r22 = r3;
        r1[r21] = (((long) (r18 & 127)) << r112) | ((~(255 << r112)) & r111);
        Object r23 = r22[r110];
        r22[r110] = r22[r11];
        r22[r11] = r23;
        Object r24 = r4[r110];
        r4[r110] = r4[r11];
        r4[r11] = r24;
        r11 = r11 - 1;
        goto L24
    L19:
        long r25 = ((long) (r18 & 127)) << r13;
        r1[r12] = r25 | ((~(255 << r13)) & r1[r12]);
        r1[ArraysKt.getLastIndex(r1)] = r1[r6];
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

    public MutableScatterMap(int r2) {
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

    private final void initializeMetadata(int r9) {
        if (r9 != 0) goto L4;
        long[] r10 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r10;
        initializeGrowth();
        return;
    L4:
        long[] r0 = new long[((((r9 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r0, -9187201950435737472L, 0, 0, 6, null);
        int r1 = r9 >> 3;
        long r4 = 255 << ((r9 & 7) << 3);
        r0[r1] = (r0[r1] & (~r4)) | r4;
        r10 = r0;
        goto L5
    }

    private final void initializeStorage(int r2) {
        if (r2 <= 0) goto L4;
        int r3 = Math.max(7, ScatterMapKt.normalizeCapacity(r2));
    L5:
        this._capacity = r3;
        initializeMetadata(r3);
        if (r3 != 0) goto L8;
        Object[] r0 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.keys = r0;
        if (r3 != 0) goto L12;
        Object[] r4 = ContainerHelpersKt.EMPTY_OBJECTS;
    L13:
        this.values = r4;
        return;
    L12:
        r4 = new Object[r3];
        goto L13
    L8:
        r0 = new Object[r3];
        goto L9
    L4:
        r3 = 0;
        goto L5
    }

    public final int findInsertIndex(K r21) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Pair<? extends K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r2, "pair");
        set(r2.getFirst(), r2.getSecond());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ScatterMap<K, V> r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        Object[] r1 = r17.keys;
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

    public final V remove(K r18) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 >= 0) goto L22;
        return null;
    L22:
        return removeValueAt(r17);
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

    public final void removeIf(Function2<? super K, ? super V, Boolean> r15) {
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
        if (((Boolean) r15.invoke(this.keys[r10], this.values[r10])).booleanValue() == false) goto L17;
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
        this.keys[r9] = null;
        Object[] r5 = this.values;
        V r6 = (V) r5[r9];
        r5[r9] = null;
        return r6;
    }

    public final void resizeStorage$collection(int r21) {
        long[] r1 = this.metadata;
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        int r4 = this._capacity;
        initializeStorage(r21);
        long[] r5 = this.metadata;
        Object[] r6 = this.keys;
        Object[] r7 = this.values;
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

    public final void plusAssign(ScatterMap<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    public final void putAll(Map<K, ? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        Iterator<Map.Entry<K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r0 = r4.next();
        set(r0.getKey(), r0.getValue());
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

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> r3) {
        Intrinsics.checkNotNullParameter(r3, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r0 = r4.next();
        set(r0.component1(), r0.component2());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<K> r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(Map<K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Sequence<? extends Pair<? extends K, ? extends V>> r3) {
        Intrinsics.checkNotNullParameter(r3, "pairs");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Pair r0 = (Pair) r4.next();
        set(r0.component1(), r0.component2());
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

    public final void plusAssign(Sequence<? extends Pair<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Pair<? extends K, ? extends V>[] r5) {
        Intrinsics.checkNotNullParameter(r5, "pairs");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair<? extends K, ? extends V> r2 = r5[r1];
        set(r2.component1(), r2.component2());
        r1 = r1 + 1;
        goto L3
    }

    public final void minusAssign(K r1) {
        remove(r1);
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        putAll(r2);
    }

    public final V compute(K r4, Function2<? super K, ? super V, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "computeBlock");
        int r0 = findInsertIndex(r4);
        if (r0 >= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        Object r2 = null;
    L9:
        V r6 = (V) r5.invoke(r4, r2);
        if (r1 == false) goto L12;
        int r3 = ~r0;
        this.keys[r3] = r4;
        this.values[r3] = r6;
    L13:
        return r6;
    L12:
        this.values[r0] = r6;
        goto L13
    L8:
        r2 = this.values[r0];
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public final V getOrPut(K r2, Function0<? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        V r0 = get(r2);
        if (r0 != null) goto L6;
        V r1 = (V) r3.invoke();
        set(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public final V put(K r5, V r6) {
        int r0 = findInsertIndex(r5);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L5:
        Object[] r1 = this.values;
        V r2 = (V) r1[r0];
        this.keys[r0] = r5;
        r1[r0] = r6;
        return r2;
    }

    public final boolean remove(K r18, V r19) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L20;
        r15 = r15 & (r15 - 1);
    L20:
        if (r17 >= 0) goto L22;
    L25:
        return false;
    L22:
        if (Intrinsics.areEqual(this.values[r17], r19) == false) goto L25;
        removeValueAt(r17);
        return true;
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

    public final void set(K r3, V r4) {
        int r0 = findInsertIndex(r3);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L5:
        this.keys[r0] = r3;
        this.values[r0] = r4;
    }

    public /* synthetic */ MutableScatterMap(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 6;
    L5:
        this(r1);
    }
}
