package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0019J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u001b\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u001e¢\u0006\u0002\u0010#J'\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0%H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010&J/\u0010'\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020(0*H\u0081\bø\u0001\u0000JD\u0010.\u001a\u00020(26\u0010)\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020(0/H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020(0*H\u0086\bø\u0001\u0000J/\u00102\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020(0*H\u0086\bø\u0001\u0000J&\u00103\u001a\u00020\u00192\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190/H\u0086\bø\u0001\u0000J&\u0010\u0018\u001a\u00020\u00192\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190/H\u0086\bø\u0001\u0000J\u0006\u00105\u001a\u00020\u000fJ&\u00105\u001a\u00020\u000f2\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190/H\u0086\bø\u0001\u0000J\u0016\u00106\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u00107J\u000e\u00109\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u001eJ:\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020\u000f2\b\b\u0002\u0010A\u001a\u00020=H\u0007Jx\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020\u000f2\b\b\u0002\u0010A\u001a\u00020=28\b\u0004\u0010B\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020=0/H\u0087\bø\u0001\u0000J\b\u0010C\u001a\u00020\u000fH\u0016J\u0013\u0010D\u001a\u00020\u00192\b\u0010E\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010F\u001a\u00020;H\u0016J\u0015\u0010G\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010HR\u0018\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\n\u0010\u0004R\u0018\u0010\f\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0004R\u0011\u0010\u0011\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0004R\u0011\u0010\u0016\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013\u0082\u0001\u0001I\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006J"}, d2 = {"Landroidx/collection/ObjectLongMap;", "K", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "values", "getValues$annotations", "_capacity", "", "get_capacity$collection$annotations", "capacity", "getCapacity", "()I", "_size", "get_size$collection$annotations", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", "get", "", "key", "(Ljava/lang/Object;)J", "getOrDefault", "defaultValue", "(Ljava/lang/Object;J)J", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)J", "forEachIndexed", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "forEach", "Lkotlin/Function2;", "value", "forEachKey", "forEachValue", "all", "predicate", "count", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "hashCode", "equals", "other", "toString", "findKeyIndex", "(Ljava/lang/Object;)I", "Landroidx/collection/MutableObjectLongMap;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObjectLongMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ ObjectLongMap(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
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

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        Object[] r1 = this.keys;
        long[] r2 = this.values;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        int r5 = 0;
        if (r4 < 0) goto L25;
        int r6 = 0;
        int r7 = 0;
    L5:
        long r8 = r3[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r10 = 8 - ((~(r6 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L20;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L19;
        int r14 = (r6 << 3) + r12;
        Object r15 = r1[r14];
        long r16 = r2[r14];
        if (r15 == null) goto L17;
        int r17 = r15.hashCode();
    L18:
        r7 = r7 + (r17 ^ ((int) (r16 ^ (r16 >>> 32))));
        goto L19
    L17:
        r17 = 0;
    L19:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L20:
        if (r10 == 8) goto L21;
        return r7;
    L21:
        if (r6 == r4) goto L23;
        r6 = r6 + 1;
        goto L5
    L23:
        r5 = r7;
    L25:
        return r5;
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

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder("{");
        Object[] r2 = this.keys;
        long[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L32;
        int r7 = 0;
        int r8 = 0;
    L9:
        long r9 = r4[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L29;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L26;
        if ((255 & r9) >= 128) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L24;
        int r15 = (r7 << 3) + r13;
        Object r16 = r2[r15];
        int r17 = r7;
        long r6 = r3[r15];
        if (r16 != this) goto L21;
        r16 = "(this)";
    L21:
        r1.append(r16);
        r1.append("=");
        r1.append(r6);
        r8 = r8 + 1;
        if (r8 >= this._size) goto L25;
        r1.append(", ");
    L25:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        r7 = r17;
        goto L12
    L24:
        r17 = r7;
        goto L25
    L16:
        r14 = false;
        goto L17
    L26:
        int r18 = r7;
        if (r11 != 8) goto L32;
        int r10 = r18;
    L30:
        if (r10 == r5) goto L32;
        r7 = r10 + 1;
        goto L9
    L29:
        r10 = r7;
    L32:
        r1.append('}');
        return r1.toString();
    }

    private ObjectLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = LongSetKt.getEmptyLongArray();
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

    public final boolean all(Function2<? super K, ? super Long, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        long[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L21;
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
        if (((Boolean) r20.invoke(r2[r15], Long.valueOf(r3[r15]))).booleanValue() == true) goto L17;
        return false;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L21;
    L19:
        if (r8 == r5) goto L21;
        r8 = r8 + 1;
    L21:
        return true;
    }

    public final boolean any(Function2<? super K, ? super Long, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        long[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r4[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        int r14 = (r7 << 3) + r12;
        if (((Boolean) r20.invoke(r2[r14], Long.valueOf(r3[r14]))).booleanValue() == false) goto L17;
        return true;
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
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
    L21:
        return false;
    }

    public final boolean contains(K r1) {
        return containsKey(r1);
    }

    public final boolean containsKey(K r1) {
        if (findKeyIndex(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsValue(long r18) {
        long[] r1 = this.values;
        long[] r2 = this.metadata;
        int r3 = r2.length - 2;
        if (r3 < 0) goto L21;
        int r5 = 0;
    L5:
        long r6 = r2[r5];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r8 = 8 - ((~(r5 - r3)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L18;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L17;
        if (r18 != r1[(r5 << 3) + r10]) goto L17;
        return true;
    L17:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L18:
        if (r8 != 8) goto L21;
    L19:
        if (r5 == r3) goto L21;
        r5 = r5 + 1;
    L21:
        return false;
    }

    public final int count(Function2<? super K, ? super Long, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        long[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        int r6 = 0;
        if (r5 < 0) goto L23;
        int r7 = 0;
        int r8 = 0;
    L5:
        long r9 = r4[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r7 << 3) + r13;
        if (((Boolean) r20.invoke(r2[r15], Long.valueOf(r3[r15]))).booleanValue() == false) goto L17;
        r8 = r8 + 1;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 == 8) goto L19;
        return r8;
    L19:
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
        goto L5
    L21:
        r6 = r8;
    L23:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r20) {
        if (r20 != this) goto L6;
        return true;
    L6:
        if ((r20 instanceof ObjectLongMap) == true) goto L8;
        return false;
    L8:
        ObjectLongMap r1 = (ObjectLongMap) r20;
        if (r1.getSize() == getSize()) goto L11;
        return false;
    L11:
        Object[] r3 = this.keys;
        long[] r5 = this.values;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L32;
        int r8 = 0;
    L14:
        long r9 = r6[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L30;
        int r11 = 8 - ((~(r8 - r7)) >>> 31);
        int r13 = 0;
    L17:
        if (r13 >= r11) goto L29;
        if ((255 & r9) >= 128) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L28;
        int r15 = (r8 << 3) + r13;
        Object r16 = r3[r15];
        long r17 = r5[r15];
        int r18 = r1.findKeyIndex(r16);
        if (r18 < 0) goto L27;
        if (r17 == r1.values[r18]) goto L28;
    L27:
        return false;
    L28:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L17
    L21:
        r14 = false;
        goto L22
    L29:
        if (r11 != 8) goto L32;
    L30:
        if (r8 == r7) goto L32;
        r8 = r8 + 1;
    L32:
        return true;
    }

    public final int findKeyIndex(K r18) {
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
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L15;
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

    public final void forEach(Function2<? super K, ? super Long, Unit> r19) {
        Intrinsics.checkNotNullParameter(r19, "block");
        Object[] r2 = this.keys;
        long[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L19;
        int r7 = 0;
    L5:
        long r8 = r4[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L16;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        int r14 = (r7 << 3) + r12;
        r19.invoke(r2[r14], Long.valueOf(r3[r14]));
    L15:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L16:
        if (r10 == 8) goto L17;
        return;
    L17:
        if (r7 == r5) goto L26;
        r7 = r7 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> r15) {
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

    public final void forEachKey(Function1<? super K, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        Object[] r2 = this.keys;
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

    public final void forEachValue(Function1<? super Long, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        long[] r2 = this.values;
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

    public final long get(K r4) {
        int r0 = findKeyIndex(r4);
        if (r0 >= 0) goto L6;
        RuntimeHelpersKt.throwNoSuchElementException("There is no key " + r4 + " in the map");
    L6:
        return this.values[r0];
    }

    public final String joinToString(Function2<? super K, ? super Long, ? extends CharSequence> r22) {
        Intrinsics.checkNotNullParameter(r22, "transform");
        StringBuilder r2 = new StringBuilder("");
        Object[] r4 = this.keys;
        long[] r5 = this.values;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L25;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r6[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r13 = 8 - ((~(r9 - r7)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L22;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = (r9 << 3) + r15;
        Object r8 = r4[r17];
        long r18 = r5[r17];
        if (r10 == (-1)) goto L16;
        if (r10 == 0) goto L19;
        r2.append(", ");
    L19:
        r2.append((CharSequence) r22.invoke(r8, Long.valueOf(r18)));
        r10 = r10 + 1;
        goto L20
    L16:
        r2.append("...");
    L27:
        return r2.toString();
    L20:
        r11 = r11 >> 8;
        r15 = r15 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        if (r13 != 8) goto L25;
    L23:
        if (r9 == r7) goto L25;
        r9 = r9 + 1;
    L25:
        r2.append("");
        goto L27
    }

    public final long getOrDefault(K r1, long r2) {
        int r3 = findKeyIndex(r1);
        if (r3 >= 0) goto L5;
        return r2;
    L5:
        return this.values[r3];
    }

    public final long getOrElse(K r2, Function0<Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        int r4 = findKeyIndex(r2);
        if (r4 < 0) goto L7;
        return this.values[r4];
    L7:
        return ((Number) r3.invoke()).longValue();
    }

    public final String joinToString(CharSequence r23, Function2<? super K, ? super Long, ? extends CharSequence> r24) {
        Intrinsics.checkNotNullParameter(r23, "separator");
        Intrinsics.checkNotNullParameter(r24, "transform");
        StringBuilder r3 = new StringBuilder("");
        Object[] r5 = this.keys;
        long[] r6 = this.values;
        long[] r7 = this.metadata;
        int r8 = r7.length - 2;
        if (r8 < 0) goto L25;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r7[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r14 = 8 - ((~(r10 - r8)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r10 << 3) + r9;
        Object r15 = r5[r18];
        long r19 = r6[r18];
        if (r11 == (-1)) goto L16;
        if (r11 == 0) goto L19;
        r3.append(r23);
    L19:
        r3.append((CharSequence) r24.invoke(r15, Long.valueOf(r19)));
        r11 = r11 + 1;
        goto L20
    L16:
        r3.append("...");
    L27:
        return r3.toString();
    L20:
        r12 = r12 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r17 = false;
        goto L13
    L22:
        if (r14 != 8) goto L25;
    L23:
        if (r10 == r8) goto L25;
        r10 = r10 + 1;
    L25:
        r3.append("");
        goto L27
    }

    public final String joinToString(CharSequence r22, CharSequence r23, Function2<? super K, ? super Long, ? extends CharSequence> r24) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "transform");
        StringBuilder r4 = new StringBuilder();
        r4.append(r23);
        Object[] r2 = this.keys;
        long[] r5 = this.values;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L25;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r6[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r13 = 8 - ((~(r9 - r7)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L22;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = (r9 << 3) + r15;
        Object r8 = r2[r17];
        long r18 = r5[r17];
        if (r10 == (-1)) goto L16;
        if (r10 == 0) goto L19;
        r4.append(r22);
    L19:
        r4.append((CharSequence) r24.invoke(r8, Long.valueOf(r18)));
        r10 = r10 + 1;
        goto L20
    L16:
        r4.append("...");
    L27:
        return r4.toString();
    L20:
        r11 = r11 >> 8;
        r15 = r15 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        if (r13 != 8) goto L25;
    L23:
        if (r9 == r7) goto L25;
        r9 = r9 + 1;
    L25:
        r4.append("");
        goto L27
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, Function2<? super K, ? super Long, ? extends CharSequence> r25) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r25, "transform");
        StringBuilder r5 = new StringBuilder();
        r5.append(r23);
        Object[] r2 = this.keys;
        long[] r6 = this.values;
        long[] r7 = this.metadata;
        int r8 = r7.length - 2;
        if (r8 < 0) goto L25;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r7[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r14 = 8 - ((~(r10 - r8)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = (r10 << 3) + r9;
        Object r15 = r2[r17];
        long r18 = r6[r17];
        if (r11 == (-1)) goto L16;
        if (r11 == 0) goto L19;
        r5.append(r22);
    L19:
        r5.append((CharSequence) r25.invoke(r15, Long.valueOf(r18)));
        r11 = r11 + 1;
        goto L20
    L16:
        r5.append("...");
    L27:
        return r5.toString();
    L20:
        r12 = r12 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        if (r14 != 8) goto L25;
    L23:
        if (r10 == r8) goto L25;
        r10 = r10 + 1;
    L25:
        r5.append(r24);
        goto L27
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, int r25, CharSequence r26) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r26, "truncated");
        StringBuilder r5 = new StringBuilder();
        r5.append(r23);
        Object[] r2 = this.keys;
        long[] r6 = this.values;
        long[] r7 = this.metadata;
        int r8 = r7.length - 2;
        if (r8 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r7[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8 - ((~(r10 - r8)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L21;
        int r17 = (r10 << 3) + r9;
        Object r15 = r2[r17];
        long r3 = r6[r17];
        if (r11 == r25) goto L16;
        if (r11 == 0) goto L19;
        r5.append(r22);
    L19:
        r5.append(r15);
        r5.append('=');
        r5.append(r3);
        r11 = r11 + 1;
        goto L21
    L16:
        r5.append(r26);
    L30:
        return r5.toString();
    L21:
        r12 = r12 >> 8;
        r9 = r9 + 1;
        r2 = r2;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        Object[] r18 = r2;
        if (r14 != 8) goto L28;
    L26:
        if (r10 == r8) goto L28;
        r10 = r10 + 1;
        r2 = r18;
        goto L5
    L25:
        r18 = r2;
    L28:
        r5.append(r24);
        goto L30
    }

    public final String joinToString(CharSequence r22, CharSequence r23, CharSequence r24, int r25, Function2<? super K, ? super Long, ? extends CharSequence> r26) {
        Intrinsics.checkNotNullParameter(r22, "separator");
        Intrinsics.checkNotNullParameter(r23, "prefix");
        Intrinsics.checkNotNullParameter(r24, "postfix");
        Intrinsics.checkNotNullParameter(r26, "transform");
        StringBuilder r5 = new StringBuilder();
        r5.append(r23);
        Object[] r2 = this.keys;
        long[] r6 = this.values;
        long[] r7 = this.metadata;
        int r8 = r7.length - 2;
        if (r8 < 0) goto L25;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r7[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r14 = 8 - ((~(r10 - r8)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = (r10 << 3) + r9;
        Object r15 = r2[r17];
        long r18 = r6[r17];
        if (r11 == r25) goto L16;
        if (r11 == 0) goto L19;
        r5.append(r22);
    L19:
        r5.append((CharSequence) r26.invoke(r15, Long.valueOf(r18)));
        r11 = r11 + 1;
        goto L20
    L16:
        r5.append("...");
    L27:
        return r5.toString();
    L20:
        r12 = r12 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        if (r14 != 8) goto L25;
    L23:
        if (r10 == r8) goto L25;
        r10 = r10 + 1;
    L25:
        r5.append(r24);
        goto L27
    }

    public final String joinToString(CharSequence r23, CharSequence r24, CharSequence r25, int r26, CharSequence r27, Function2<? super K, ? super Long, ? extends CharSequence> r28) {
        CharSequence r1 = r23;
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r24, "prefix");
        Intrinsics.checkNotNullParameter(r25, "postfix");
        Intrinsics.checkNotNullParameter(r27, "truncated");
        Intrinsics.checkNotNullParameter(r28, "transform");
        StringBuilder r6 = new StringBuilder();
        r6.append(r24);
        Object[] r2 = this.keys;
        long[] r7 = this.values;
        long[] r8 = this.metadata;
        int r9 = r8.length - 2;
        if (r9 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r8[r11];
        int r15 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r10 = 8 - ((~(r15 - r9)) >>> 31);
        int r14 = 0;
    L8:
        if (r14 >= r10) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L21;
        int r18 = (r15 << 3) + r14;
        Object r0 = r2[r18];
        long r19 = r7[r18];
        if (r12 == r26) goto L16;
        if (r12 == 0) goto L19;
        r6.append(r1);
    L19:
        r6.append((CharSequence) r28.invoke(r0, Long.valueOf(r19)));
        r12 = r12 + 1;
        goto L21
    L16:
        r6.append(r27);
    L31:
        return r6.toString();
    L21:
        r13 = r13 >> 8;
        r14 = r14 + 1;
        r1 = r23;
        r2 = r2;
        goto L8
    L12:
        r17 = false;
        goto L13
    L22:
        Object[] r110 = r2;
        if (r10 != 8) goto L29;
    L27:
        if (r15 == r9) goto L29;
        r11 = r15 + 1;
        r1 = r23;
        r2 = r110;
        goto L5
    L25:
        r110 = r2;
    L29:
        r6.append(r25);
        goto L31
    }

    public static /* synthetic */ String joinToString$default(ObjectLongMap r3, CharSequence r4, CharSequence r5, CharSequence r6, int r7, CharSequence r8, int r9, Object r10) {
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

    public static /* synthetic */ String joinToString$default(ObjectLongMap r21, CharSequence r22, CharSequence r23, CharSequence r24, int r25, CharSequence r26, Function2 r27, int r28, Object r29) {
        if (r29 != null) goto L55;
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
        Object[] r8 = r21.keys;
        long[] r9 = r21.values;
        long[] r0 = r21.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L51;
        int r11 = 0;
        int r12 = 0;
    L27:
        long r13 = r0[r11];
        int r210 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L47;
        int r14 = 8 - ((~(r210 - r10)) >>> 31);
        int r15 = 0;
    L30:
        if (r15 >= r14) goto L44;
        if ((r13 & 255) >= 128) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == false) goto L43;
        int r17 = (r210 << 3) + r15;
        Object r18 = r8[r17];
        long r19 = r9[r17];
        if (r12 == r5) goto L38;
        if (r12 == 0) goto L41;
        r7.append(r2);
    L41:
        r7.append((CharSequence) r27.invoke(r18, Long.valueOf(r19)));
        r12 = r12 + 1;
        goto L43
    L38:
        r7.append(r6);
    L53:
        return r7.toString();
    L43:
        r13 = r13 >> 8;
        r15 = r15 + 1;
        r0 = r0;
        goto L30
    L34:
        r16 = false;
        goto L35
    L44:
        long[] r110 = r0;
        if (r14 != 8) goto L51;
    L49:
        if (r210 == r10) goto L51;
        r11 = r210 + 1;
        r0 = r110;
        goto L27
    L47:
        r110 = r0;
    L51:
        r7.append(r4);
        goto L53
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
    L55:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
