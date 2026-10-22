package androidx.collection;

import androidx.autofill.HintConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\t\u0010\u0016\u001a\u00020\u0017H\u0086\bJ:\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001d\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001e0\u0019H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010!\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\"\u001a\u00020\u00122!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u0011\u001a\u00020\u00122!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010#\u001a\u00020\nH\u0007J:\u0010#\u001a\u00020\n2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010$\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0017H\u0086\u0002J:\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020(H\u0007JT\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020(2\u0014\b\u0004\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020(0\u0019H\u0087\bø\u0001\u0000J\b\u0010.\u001a\u00020\nH\u0016J\u0013\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00101\u001a\u00020&H\u0016J\u0016\u00102\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0017H\u0080\b¢\u0006\u0002\b3R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0012\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r\u0082\u0001\u00014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/collection/LongSet;", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", "elements", "getElements$annotations", "_capacity", "", "capacity", "getCapacity", "()I", "_size", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", "first", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "element", "forEachIndex", "", "block", "index", "forEach", "all", "count", "contains", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "hashCode", "equals", "other", "toString", "findElementIndex", "findElementIndex$collection", "Landroidx/collection/MutableLongSet;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LongSet {
    public int _capacity;
    public int _size;
    public long[] elements;
    public long[] metadata;

    public /* synthetic */ LongSet(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "separator");
        return joinToString$default(this, r10, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "separator");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        return joinToString$default(this, r10, r11, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence r10, CharSequence r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r10, "separator");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        Intrinsics.checkNotNullParameter(r12, "postfix");
        return joinToString$default(this, r10, r11, r12, 0, null, 24, null);
    }

    public final String joinToString(CharSequence r10, CharSequence r11, CharSequence r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "separator");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        Intrinsics.checkNotNullParameter(r12, "postfix");
        return joinToString$default(this, r10, r11, r12, r13, null, 16, null);
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long first() {
        long[] r0 = this.elements;
        long[] r1 = this.metadata;
        int r2 = r1.length - 2;
        if (r2 < 0) goto L21;
        int r4 = 0;
    L5:
        long r5 = r1[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L17;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L15;
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L15:
        return r0[(r4 << 3) + r9];
    L12:
        r10 = false;
        goto L13
    L17:
        if (r7 != 8) goto L21;
    L18:
        if (r4 == r2) goto L21;
        r4 = r4 + 1;
    L21:
        throw new NoSuchElementException("The LongSet is empty");
    }

    public int hashCode() {
        long[] r1 = this.elements;
        long[] r2 = this.metadata;
        int r3 = r2.length - 2;
        int r4 = 0;
        if (r3 < 0) goto L21;
        int r5 = 0;
        int r6 = 0;
    L5:
        long r7 = r2[r5];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r9 = 8 - ((~(r5 - r3)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L16;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        long r13 = r1[(r5 << 3) + r11];
        r6 = r6 + ((int) (r13 ^ (r13 >>> 32)));
    L15:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L16:
        if (r9 == 8) goto L17;
        return r6;
    L17:
        if (r5 == r3) goto L19;
        r5 = r5 + 1;
        goto L5
    L19:
        r4 = r6;
    L21:
        return r4;
    }

    public final boolean isEmpty() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private LongSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = LongSetKt.getEmptyLongArray();
    }

    public final int count() {
        return this._size;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean all(Function1<? super Long, Boolean> r19) {
        Intrinsics.checkNotNullParameter(r19, "predicate");
        long[] r2 = this.elements;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r3[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        if (((Boolean) r19.invoke(Long.valueOf(r2[(r7 << 3) + r12]))).booleanValue() == true) goto L17;
        return false;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 != 8) goto L21;
    L19:
        if (r7 == r4) goto L21;
        r7 = r7 + 1;
    L21:
        return true;
    }

    public final boolean any(Function1<? super Long, Boolean> r19) {
        Intrinsics.checkNotNullParameter(r19, "predicate");
        long[] r2 = this.elements;
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
        if (((Boolean) r19.invoke(Long.valueOf(r2[(r6 << 3) + r11]))).booleanValue() == false) goto L17;
        return true;
    L17:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L18:
        if (r9 != 8) goto L21;
    L19:
        if (r6 == r4) goto L21;
        r6 = r6 + 1;
    L21:
        return false;
    }

    public final boolean contains(long r18) {
        int r2 = ((int) (r18 ^ (r18 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r1 = (r2 << 16) ^ r2;
        int r3 = r1 & 127;
        int r4 = this._capacity;
        int r5 = (r1 >>> 7) & r4;
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
        if (r13 == false) goto L14;
        int r14 = ((Long.numberOfTrailingZeros(r12) >> 3) + r5) & r4;
        if (this.elements[r14] == r18) goto L16;
        r12 = r12 & (r12 - 1);
    L16:
        if (r14 < 0) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (((r10 & ((~r10) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r6 = r6 + 8;
        r5 = (r5 + r6) & r4;
        goto L3
    L15:
        r14 = -1;
        goto L16
    L7:
        r13 = false;
        goto L8
    }

    public final int count(Function1<? super Long, Boolean> r19) {
        Intrinsics.checkNotNullParameter(r19, "predicate");
        long[] r2 = this.elements;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        int r5 = 0;
        if (r4 < 0) goto L23;
        int r6 = 0;
        int r7 = 0;
    L5:
        long r8 = r3[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r6 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        if (((Boolean) r19.invoke(Long.valueOf(r2[(r6 << 3) + r12]))).booleanValue() == false) goto L17;
        r7 = r7 + 1;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 == 8) goto L19;
        return r7;
    L19:
        if (r6 == r4) goto L21;
        r6 = r6 + 1;
        goto L5
    L21:
        r5 = r7;
    L23:
        return r5;
    }

    public boolean equals(Object r19) {
        if (r19 != this) goto L6;
        return true;
    L6:
        if ((r19 instanceof LongSet) == true) goto L8;
        return false;
    L8:
        LongSet r1 = (LongSet) r19;
        if (r1._size == this._size) goto L11;
        return false;
    L11:
        long[] r3 = this.elements;
        long[] r5 = this.metadata;
        int r6 = r5.length - 2;
        if (r6 < 0) goto L30;
        int r7 = 0;
    L14:
        long r8 = r5[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r10 = 8 - ((~(r7 - r6)) >>> 31);
        int r12 = 0;
    L17:
        if (r12 >= r10) goto L27;
        if ((255 & r8) >= 128) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L26;
        if (r1.contains(r3[(r7 << 3) + r12]) == true) goto L26;
        return false;
    L26:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L17
    L21:
        r13 = false;
        goto L22
    L27:
        if (r10 != 8) goto L30;
    L28:
        if (r7 == r6) goto L30;
        r7 = r7 + 1;
    L30:
        return true;
    }

    public final int findElementIndex$collection(long r18) {
        int r2 = ((int) (r18 ^ (r18 >>> 32))) * ScatterMapKt.MurmurHashC1;
        int r1 = (r2 << 16) ^ r2;
        int r3 = r1 & 127;
        int r4 = this._capacity;
        int r5 = (r1 >>> 7) & r4;
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
        if (r13 == false) goto L14;
        int r14 = ((Long.numberOfTrailingZeros(r12) >> 3) + r5) & r4;
        if (this.elements[r14] == r18) goto L11;
        r12 = r12 & (r12 - 1);
        goto L5
    L11:
        return r14;
    L14:
        if (((r10 & ((~r10) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r6 = r6 + 8;
        r5 = (r5 + r6) & r4;
        goto L3
    L15:
        return -1;
    L7:
        r13 = false;
        goto L8
    }

    public final long first(Function1<? super Long, Boolean> r18) {
        Intrinsics.checkNotNullParameter(r18, "predicate");
        long[] r2 = this.elements;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L22;
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
        long r13 = r2[(r6 << 3) + r11];
        if (((Boolean) r18.invoke(Long.valueOf(r13))).booleanValue() == false) goto L17;
        return r13;
    L17:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L18:
        if (r9 != 8) goto L22;
    L19:
        if (r6 == r4) goto L22;
        r6 = r6 + 1;
    L22:
        throw new NoSuchElementException("Could not find a match");
    }

    public final void forEach(Function1<? super Long, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        long[] r2 = this.elements;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L19;
        int r6 = 0;
    L5:
        long r7 = r3[r6];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r9 = 8 - ((~(r6 - r4)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L16;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        r18.invoke(Long.valueOf(r2[(r6 << 3) + r11]));
    L15:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L16:
        if (r9 == 8) goto L17;
        return;
    L17:
        if (r6 == r4) goto L26;
        r6 = r6 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndex(Function1<? super Integer, Unit> r15) {
        Intrinsics.checkNotNullParameter(r15, "block");
        long[] r0 = this.metadata;
        int r1 = r0.length - 2;
        if (r1 < 0) goto L20;
        int r3 = 0;
    L5:
        long r4 = r0[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        r15.invoke(Integer.valueOf((r3 << 3) + r8));
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L18;
        return;
    L18:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final String joinToString(Function1<? super Long, ? extends CharSequence> r21) {
        Intrinsics.checkNotNullParameter(r21, "transform");
        StringBuilder r2 = new StringBuilder("");
        long[] r4 = this.elements;
        long[] r5 = this.metadata;
        int r6 = r5.length - 2;
        if (r6 < 0) goto L24;
        int r8 = 0;
        int r9 = 0;
    L5:
        long r10 = r5[r8];
        if (((((~r10) << 7) & r10) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r12 = 8 - ((~(r8 - r6)) >>> 31);
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L21;
        if ((255 & r10) >= 128) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L20;
        long r16 = r4[(r8 << 3) + r14];
        if (r9 == (-1)) goto L16;
        if (r9 == 0) goto L19;
        r2.append(", ");
    L19:
        r2.append((CharSequence) r21.invoke(Long.valueOf(r16)));
        r9 = r9 + 1;
        goto L20
    L16:
        r2.append("...");
    L26:
        return r2.toString();
    L20:
        r10 = r10 >> 8;
        r14 = r14 + 1;
        goto L8
    L12:
        r15 = false;
        goto L13
    L21:
        if (r12 != 8) goto L24;
    L22:
        if (r8 == r6) goto L24;
        r8 = r8 + 1;
    L24:
        r2.append("");
        goto L26
    }

    public final String joinToString(CharSequence r22, Function1<? super Long, ? extends CharSequence> r23) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "transform");
        StringBuilder r3 = new StringBuilder("");
        long[] r5 = this.elements;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L24;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r6[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r13 = 8 - ((~(r9 - r7)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L21;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        long r17 = r5[(r9 << 3) + r15];
        if (r10 == (-1)) goto L16;
        if (r10 == 0) goto L19;
        r3.append(r22);
    L19:
        r3.append((CharSequence) r23.invoke(Long.valueOf(r17)));
        r10 = r10 + 1;
        goto L20
    L16:
        r3.append("...");
    L26:
        return r3.toString();
    L20:
        r11 = r11 >> 8;
        r15 = r15 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L21:
        if (r13 != 8) goto L24;
    L22:
        if (r9 == r7) goto L24;
        r9 = r9 + 1;
    L24:
        r3.append("");
        goto L26
    }

    public final String joinToString(CharSequence r21, CharSequence r22, Function1<? super Long, ? extends CharSequence> r23) {
        Intrinsics.checkNotNullParameter(r21, "separator");
        Intrinsics.checkNotNullParameter(r22, "prefix");
        Intrinsics.checkNotNullParameter(r23, "transform");
        StringBuilder r4 = new StringBuilder();
        r4.append(r22);
        long[] r2 = this.elements;
        long[] r5 = this.metadata;
        int r6 = r5.length - 2;
        if (r6 < 0) goto L24;
        int r8 = 0;
        int r9 = 0;
    L5:
        long r10 = r5[r8];
        if (((((~r10) << 7) & r10) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r12 = 8 - ((~(r8 - r6)) >>> 31);
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L21;
        if ((255 & r10) >= 128) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L20;
        long r16 = r2[(r8 << 3) + r14];
        if (r9 == (-1)) goto L16;
        if (r9 == 0) goto L19;
        r4.append(r21);
    L19:
        r4.append((CharSequence) r23.invoke(Long.valueOf(r16)));
        r9 = r9 + 1;
        goto L20
    L16:
        r4.append("...");
    L26:
        return r4.toString();
    L20:
        r10 = r10 >> 8;
        r14 = r14 + 1;
        goto L8
    L12:
        r15 = false;
        goto L13
    L21:
        if (r12 != 8) goto L24;
    L22:
        if (r8 == r6) goto L24;
        r8 = r8 + 1;
    L24:
        r4.append("");
        goto L26
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, Function1<? super Long, ? extends CharSequence> r25) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r25, "transform");
        StringBuilder r5 = new StringBuilder();
        r5.append(r23);
        long[] r2 = this.elements;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L24;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r6[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r13 = 8 - ((~(r9 - r7)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L21;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        long r17 = r2[(r9 << 3) + r15];
        if (r10 == (-1)) goto L16;
        if (r10 == 0) goto L19;
        r5.append(r22);
    L19:
        r5.append((CharSequence) r25.invoke(Long.valueOf(r17)));
        r10 = r10 + 1;
        goto L20
    L16:
        r5.append("...");
    L26:
        return r5.toString();
    L20:
        r11 = r11 >> 8;
        r15 = r15 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L21:
        if (r13 != 8) goto L24;
    L22:
        if (r9 == r7) goto L24;
        r9 = r9 + 1;
    L24:
        r5.append(r24);
        goto L26
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, int r25, CharSequence r26) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r26, "truncated");
        StringBuilder r5 = new StringBuilder();
        r5.append(r23);
        long[] r2 = this.elements;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L28;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r6[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r13 = 8 - ((~(r9 - r7)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L22;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L21;
        long r8 = r2[(r9 << 3) + r15];
        if (r10 == r25) goto L16;
        if (r10 == 0) goto L19;
        r5.append(r22);
    L19:
        r5.append(r8);
        r10 = r10 + 1;
        goto L21
    L16:
        r5.append(r26);
    L30:
        return r5.toString();
    L21:
        r11 = r11 >> 8;
        r15 = r15 + 1;
        r9 = r9;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        int r17 = r9;
        if (r13 != 8) goto L28;
        int r12 = r17;
    L26:
        if (r12 == r7) goto L28;
        r9 = r12 + 1;
        goto L5
    L25:
        r12 = r9;
    L28:
        r5.append(r24);
        goto L30
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, int r25, Function1<? super Long, ? extends CharSequence> r26) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r26, "transform");
        StringBuilder r5 = new StringBuilder();
        r5.append(r23);
        long[] r2 = this.elements;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L28;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r6[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r14 = 8;
        int r13 = 8 - ((~(r9 - r7)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L23;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L21;
        long r17 = r2[(r9 << 3) + r15];
        if (r10 == r25) goto L16;
        if (r10 == 0) goto L19;
        r5.append(r22);
    L19:
        r5.append((CharSequence) r26.invoke(Long.valueOf(r17)));
        r10 = r10 + 1;
        r14 = 8;
        goto L21
    L16:
        r5.append("...");
    L30:
        return r5.toString();
    L21:
        r11 = r11 >> r14;
        r15 = r15 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L23:
        if (r13 != r14) goto L28;
    L26:
        if (r9 == r7) goto L28;
        r9 = r9 + 1;
    L28:
        r5.append(r24);
        goto L30
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, int r25, CharSequence r26, Function1<? super Long, ? extends CharSequence> r27) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r26, "truncated");
        Intrinsics.checkNotNullParameter(r27, "transform");
        StringBuilder r6 = new StringBuilder();
        r6.append(r23);
        long[] r2 = this.elements;
        long[] r7 = this.metadata;
        int r8 = r7.length - 2;
        if (r8 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r7[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r14 = 8 - ((~(r10 - r8)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r14) goto L23;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L21;
        long r17 = r2[(r10 << 3) + r9];
        if (r11 == r25) goto L16;
        if (r11 == 0) goto L19;
        r6.append(r22);
    L19:
        r6.append((CharSequence) r27.invoke(Long.valueOf(r17)));
        r11 = r11 + 1;
        goto L21
    L16:
        r6.append(r26);
    L30:
        return r6.toString();
    L21:
        r12 = r12 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L23:
        if (r14 != 8) goto L28;
    L26:
        if (r10 == r8) goto L28;
        r10 = r10 + 1;
    L28:
        r6.append(r24);
        goto L30
    }

    public static /* synthetic */ String joinToString$default(LongSet r3, CharSequence r4, CharSequence r5, CharSequence r6, int r7, CharSequence r8, int r9, Object r10) {
        if (r10 != null) goto L24;
        if ((r9 & 1) == 0) goto L6;
        r4 = ", ";
    L6:
        CharSequence r0 = "";
        if ((r9 & 2) == 0) goto L9;
        CharSequence r11 = "";
    L11:
        if ((r9 & 4) != 0) goto L15;
        r0 = r6;
    L15:
        if ((r9 & 8) == 0) goto L17;
        int r1 = -1;
    L19:
        if ((r9 & 16) == 0) goto L21;
        r8 = "...";
    L21:
        CharSequence r2 = r8;
        return r3.joinToString(r4, r11, r0, r1, r2);
    L17:
        r1 = r7;
        goto L19
    L9:
        r11 = r5;
        goto L11
    L24:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static /* synthetic */ String joinToString$default(LongSet r21, CharSequence r22, CharSequence r23, CharSequence r24, int r25, CharSequence r26, Function1 r27, int r28, Object r29) {
        if (r29 != null) goto L50;
        if ((r28 & 1) == 0) goto L7;
        CharSequence r2 = ", ";
    L8:
        CharSequence r4 = "";
        if ((r28 & 2) == 0) goto L11;
        CharSequence r3 = "";
    L13:
        if ((r28 & 4) != 0) goto L17;
        r4 = r24;
    L17:
        if ((r28 & 8) == 0) goto L19;
        int r5 = -1;
    L21:
        if ((r28 & 16) == 0) goto L23;
        CharSequence r6 = "...";
    L24:
        Intrinsics.checkNotNullParameter(r2, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r6, "truncated");
        Intrinsics.checkNotNullParameter(r27, "transform");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        long[] r8 = r21.elements;
        long[] r0 = r21.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L46;
        int r10 = 0;
        int r11 = 0;
    L27:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L44;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L30:
        if (r13 >= r14) goto L43;
        if ((r12 & 255) >= 128) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == false) goto L42;
        long r17 = r8[(r10 << 3) + r13];
        if (r11 == r5) goto L38;
        if (r11 == 0) goto L41;
        r7.append(r2);
    L41:
        r7.append((CharSequence) r27.invoke(Long.valueOf(r17)));
        r11 = r11 + 1;
        r15 = 8;
        goto L42
    L38:
        r7.append(r6);
    L48:
        return r7.toString();
    L42:
        r12 = r12 >> r15;
        r13 = r13 + 1;
        goto L30
    L34:
        r16 = false;
        goto L35
    L43:
        if (r14 != r15) goto L46;
    L44:
        if (r10 == r9) goto L46;
        r10 = r10 + 1;
    L46:
        r7.append(r4);
        goto L48
    L23:
        r6 = r26;
        goto L24
    L19:
        r5 = r25;
        goto L21
    L11:
        r3 = r23;
        goto L13
    L7:
        r2 = r22;
        goto L8
    L50:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
