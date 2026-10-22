package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000b\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J?\u0010\u001f\u001a\u00028\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&JA\u0010'\u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&J\u000b\u0010(\u001a\u00028\u0000¢\u0006\u0002\u0010 J?\u0010(\u001a\u00028\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&JA\u0010)\u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010&J?\u0010*\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020+0\"H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\b.J:\u0010/\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020+0\"H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00100\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020+0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00101\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020+0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00102\u001a\u00020+2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020+0\"H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0086\bJ:\u00105\u001a\u00020\u001b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001a\u001a\u00020\u001b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u00106\u001a\u00020\u000fH\u0007J:\u00106\u001a\u00020\u000f2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u00107\u001a\u00020\u001b2\u0006\u0010%\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00108JR\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020\u000f2\b\b\u0002\u0010@\u001a\u00020<2\u0016\b\u0002\u0010A\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020<\u0018\u00010\"H\u0007J\b\u0010B\u001a\u00020\u000fH\u0016J\u0013\u0010C\u001a\u00020\u001b2\b\u0010D\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010E\u001a\u00020:H\u0016J\u0018\u0010F\u001a\u00020\u000f2\u0006\u0010%\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\bG\u0010HJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000JR\u0018\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\n\u0010\u0004R\u0018\u0010\f\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u0012\u0010\u0013\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016\u0082\u0001\u0001K\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006L"}, d2 = {"Landroidx/collection/OrderedScatterSet;", "E", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", "elements", "", "getElements$annotations", "[Ljava/lang/Object;", "nodes", "getNodes$annotations", "head", "", "getHead$annotations", "tail", "getTail$annotations", "_capacity", "capacity", "getCapacity", "()I", "_size", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", "first", "()Ljava/lang/Object;", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "element", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "forEachIndex", "", "block", "index", "forEachIndex$collection", "unorderedForEachIndex", "forEach", "forEachReverse", "unorderedForEach", "toList", "", "all", "count", "contains", "(Ljava/lang/Object;)Z", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "hashCode", "equals", "other", "toString", "findElementIndex", "findElementIndex$collection", "(Ljava/lang/Object;)I", "asSet", "", "Landroidx/collection/MutableOrderedScatterSet;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OrderedScatterSet<E> {
    public int _capacity;
    public int _size;
    public Object[] elements;
    public int head;
    public long[] metadata;
    public long[] nodes;
    public int tail;

    public /* synthetic */ OrderedScatterSet(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ CharSequence a(OrderedScatterSet r0, Object r1) {
        return toString$lambda$16(r0, r1);
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getNodes$annotations() {
    }

    public static /* synthetic */ void getTail$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final String joinToString(CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "separator");
        return joinToString$default(this, r11, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        return joinToString$default(this, r11, r12, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12, CharSequence r13) {
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        Intrinsics.checkNotNullParameter(r13, "postfix");
        return joinToString$default(this, r11, r12, r13, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12, CharSequence r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        Intrinsics.checkNotNullParameter(r13, "postfix");
        return joinToString$default(this, r11, r12, r13, r14, null, null, 48, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15) {
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        Intrinsics.checkNotNullParameter(r13, "postfix");
        Intrinsics.checkNotNullParameter(r15, "truncated");
        return joinToString$default(this, r11, r12, r13, r14, r15, null, 32, null);
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new b(this), 25, null);
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Set<E> asSet() {
        return new OrderedSetWrapper(this);
    }

    public final E first() {
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.tail;
        if (r2 == Integer.MAX_VALUE) goto L6;
        long r3 = r1[r2];
        return (E) r0[r2];
    L6:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        int r1 = (this._capacity * 31) + this._size;
        Object[] r2 = this.elements;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L24;
        int r6 = 0;
    L5:
        long r7 = r3[r6];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r9 = 8 - ((~(r6 - r4)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L21;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L20;
        Object r13 = r2[(r6 << 3) + r11];
        if (Intrinsics.areEqual(r13, this) == true) goto L20;
        if (r13 == null) goto L18;
        int r14 = r13.hashCode();
    L19:
        r1 = r1 + r14;
        goto L20
    L18:
        r14 = 0;
    L20:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L21:
        if (r9 != 8) goto L24;
    L22:
        if (r6 == r4) goto L24;
        r6 = r6 + 1;
    L24:
        return r1;
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

    public final E last() {
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.head;
        if (r2 == Integer.MAX_VALUE) goto L6;
        long r3 = r1[r2];
        return (E) r0[r2];
    L6:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("The OrderedScatterSet is empty");
        throw new KotlinNothingValueException();
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<E> toList() {
        ArrayList r0 = new ArrayList(getSize());
        Object[] r1 = this.elements;
        long[] r2 = this.nodes;
        int r3 = this.tail;
    L4:
        if (r3 == Integer.MAX_VALUE) goto L6;
        int r5 = (int) ((r2[r3] >> 31) & SieveCacheKt.NodeLinkMask);
        r0.add(r1[r3]);
        r3 = r5;
        goto L4
    L6:
        return r0;
    }

    private OrderedScatterSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
    }

    public final int count() {
        return getSize();
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean all(Function1<? super E, Boolean> r19) {
        Intrinsics.checkNotNullParameter(r19, "predicate");
        Object[] r2 = this.elements;
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
        if (((Boolean) r19.invoke(r2[(r7 << 3) + r12])).booleanValue() == true) goto L17;
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

    public final boolean any(Function1<? super E, Boolean> r19) {
        Intrinsics.checkNotNullParameter(r19, "predicate");
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
        if (((Boolean) r19.invoke(r2[(r6 << 3) + r11])).booleanValue() == false) goto L17;
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

    public final boolean contains(E r18) {
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
        return true;
    L27:
        return false;
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

    public final int count(Function1<? super E, Boolean> r19) {
        Intrinsics.checkNotNullParameter(r19, "predicate");
        Object[] r2 = this.elements;
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
        if (((Boolean) r19.invoke(r2[(r6 << 3) + r12])).booleanValue() == false) goto L17;
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

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r19) {
        if (r19 != this) goto L6;
        return true;
    L6:
        if ((r19 instanceof OrderedScatterSet) == true) goto L8;
        return false;
    L8:
        OrderedScatterSet r1 = (OrderedScatterSet) r19;
        if (r1.getSize() == getSize()) goto L11;
        return false;
    L11:
        Object[] r3 = this.elements;
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

    public final int findElementIndex$collection(E r18) {
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
        if (Intrinsics.areEqual(this.elements[r17], r18) == true) goto L15;
        r15 = r15 & (r15 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        return -1;
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final E first(Function1<? super E, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.tail;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L9;
        int r4 = (int) ((r1[r2] >> 31) & SieveCacheKt.NodeLinkMask);
        E r3 = (E) r0[r2];
        if (((Boolean) r8.invoke(r3)).booleanValue() == true) goto L7;
        r2 = r4;
        goto L4
    L7:
        return r3;
    L9:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    public final E firstOrNull(Function1<? super E, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.tail;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L9;
        int r4 = (int) ((r1[r2] >> 31) & SieveCacheKt.NodeLinkMask);
        E r3 = (E) r0[r2];
        if (((Boolean) r8.invoke(r3)).booleanValue() == true) goto L7;
        r2 = r4;
        goto L4
    L7:
        return r3;
    L9:
        return null;
    }

    public final void forEach(Function1<? super E, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.tail;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L6;
        int r4 = (int) ((r1[r2] >> 31) & SieveCacheKt.NodeLinkMask);
        r8.invoke(r0[r2]);
        r2 = r4;
        goto L4
    }

    public final void forEachIndex$collection(Function1<? super Integer, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "block");
        long[] r0 = this.nodes;
        int r1 = this.tail;
    L4:
        if (r1 == Integer.MAX_VALUE) goto L6;
        int r3 = (int) ((r0[r1] >> 31) & SieveCacheKt.NodeLinkMask);
        r7.invoke(Integer.valueOf(r1));
        r1 = r3;
        goto L4
    }

    public final void forEachReverse(Function1<? super E, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.head;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L6;
        int r4 = (int) (r1[r2] & SieveCacheKt.NodeLinkMask);
        r8.invoke(r0[r2]);
        r2 = r4;
        goto L4
    }

    public final E last(Function1<? super E, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.head;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L9;
        int r4 = (int) (r1[r2] & SieveCacheKt.NodeLinkMask);
        E r3 = (E) r0[r2];
        if (((Boolean) r8.invoke(r3)).booleanValue() == true) goto L7;
        r2 = r4;
        goto L4
    L7:
        return r3;
    L9:
        RuntimeHelpersKt.throwNoSuchElementExceptionForInline("Could not find a match");
        throw new KotlinNothingValueException();
    }

    public final E lastOrNull(Function1<? super E, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.head;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L9;
        int r4 = (int) (r1[r2] & SieveCacheKt.NodeLinkMask);
        E r3 = (E) r0[r2];
        if (((Boolean) r8.invoke(r3)).booleanValue() == true) goto L7;
        r2 = r4;
        goto L4
    L7:
        return r3;
    L9:
        return null;
    }

    public final void unorderedForEach(Function1<? super E, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        Object[] r2 = this.elements;
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
        r18.invoke(r2[(r6 << 3) + r11]);
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

    public final void unorderedForEachIndex(Function1<? super Integer, Unit> r15) {
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

    private static final CharSequence toString$lambda$16(OrderedScatterSet r0, Object r1) {
        if (r1 != r0) goto L5;
        return "(this)";
    L5:
        return String.valueOf(r1);
    }

    public final String joinToString(CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, Function1<? super E, ? extends CharSequence> r14) {
        Intrinsics.checkNotNullParameter(r9, "separator");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        Intrinsics.checkNotNullParameter(r11, "postfix");
        Intrinsics.checkNotNullParameter(r13, "truncated");
        StringBuilder r0 = new StringBuilder();
        r0.append(r10);
        Object[] r15 = this.elements;
        long[] r1 = this.nodes;
        int r2 = this.tail;
        int r3 = 0;
    L4:
        if (r2 == Integer.MAX_VALUE) goto L14;
        int r5 = (int) ((r1[r2] >> 31) & SieveCacheKt.NodeLinkMask);
        Object r4 = r15[r2];
        if (r3 == r12) goto L7;
        if (r3 == 0) goto L10;
        r0.append(r9);
    L10:
        if (r14 != null) goto L12;
        r0.append(r4);
    L13:
        r3 = r3 + 1;
        r2 = r5;
        goto L4
    L12:
        r0.append((CharSequence) r14.invoke(r4));
        goto L13
    L7:
        r0.append(r13);
    L16:
        return r0.toString();
    L14:
        r0.append(r11);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(OrderedScatterSet r4, CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, Function1 r10, int r11, Object r12) {
        if (r12 != null) goto L27;
        if ((r11 & 1) == 0) goto L6;
        r5 = ", ";
    L6:
        CharSequence r0 = "";
        if ((r11 & 2) == 0) goto L9;
        CharSequence r13 = "";
    L11:
        if ((r11 & 4) != 0) goto L15;
        r0 = r7;
    L15:
        if ((r11 & 8) == 0) goto L17;
        int r1 = -1;
    L19:
        if ((r11 & 16) == 0) goto L21;
        r9 = "...";
    L21:
        CharSequence r2 = r9;
        if ((r11 & 32) == 0) goto L24;
        r10 = null;
    L24:
        Function1 r3 = r10;
        return r4.joinToString(r5, r13, r0, r1, r2, r3);
    L17:
        r1 = r8;
        goto L19
    L9:
        r13 = r6;
        goto L11
    L27:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
