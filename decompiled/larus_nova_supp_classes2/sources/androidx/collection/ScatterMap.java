package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!J'\u0010\"\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00028\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010$J/\u0010%\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020&0(H\u0081\bø\u0001\u0000JD\u0010,\u001a\u00020&26\u0010'\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020&0-H\u0086\bø\u0001\u0000J/\u0010/\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020&0(H\u0086\bø\u0001\u0000J/\u00100\u001a\u00020&2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020&0(H\u0086\bø\u0001\u0000J&\u00101\u001a\u00020\u00182\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00180-H\u0086\bø\u0001\u0000J&\u0010\u0017\u001a\u00020\u00182\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00180-H\u0086\bø\u0001\u0000J\u0006\u00103\u001a\u00020\u0010J&\u00103\u001a\u00020\u00102\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00180-H\u0086\bø\u0001\u0000J\u0016\u00104\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u00105J\u0013\u00107\u001a\u00020\u00182\u0006\u0010.\u001a\u00028\u0001¢\u0006\u0002\u00105Jv\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020\u00102\b\b\u0002\u0010?\u001a\u00020;2:\b\u0002\u0010@\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020;\u0018\u00010-H\u0007J\b\u0010A\u001a\u00020\u0010H\u0016J\u0013\u0010B\u001a\u00020\u00182\b\u0010C\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010D\u001a\u000209H\u0016J\r\u0010E\u001a\u000209H\u0000¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\bH\u0010IJ\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010KR\u0018\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0005R\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000b\u0010\u0005R\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013\u0082\u0001\u0001L\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"Landroidx/collection/ScatterMap;", "K", "V", "", "<init>", "()V", "metadata", "", "getMetadata$annotations", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "values", "getValues$annotations", "_capacity", "", "capacity", "getCapacity", "()I", "_size", "size", "getSize", "any", "", "none", "isEmpty", "isNotEmpty", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "forEachIndexed", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "forEach", "Lkotlin/Function2;", "value", "forEachKey", "forEachValue", "all", "predicate", "count", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "hashCode", "equals", "other", "toString", "asDebugString", "asDebugString$collection", "findKeyIndex", "findKeyIndex$collection", "(Ljava/lang/Object;)I", "asMap", "", "Landroidx/collection/MutableScatterMap;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ScatterMap<K, V> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ ScatterMap(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
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

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String asDebugString$collection() {
        StringBuilder r0 = new StringBuilder("{metadata=[");
        int r1 = getCapacity();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L13;
        long r5 = (this.metadata[r3 >> 3] >> ((r3 & 7) << 3)) & 255;
        if (r5 != 128) goto L9;
        r0.append("Empty");
    L12:
        r0.append(", ");
        r3 = r3 + 1;
        goto L4
    L9:
        if (r5 != 254) goto L11;
        r0.append("Deleted");
        goto L12
    L11:
        r0.append(r5);
        goto L12
    L13:
        r0.append("], keys=[");
        int r4 = this.keys.length;
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L16;
        r0.append(this.keys[r6]);
        r0.append(", ");
        r6 = r6 + 1;
        goto L14
    L16:
        r0.append("], values=[");
        int r7 = this.values.length;
    L17:
        if (r2 >= r7) goto L19;
        r0.append(this.values[r2]);
        r0.append(", ");
        r2 = r2 + 1;
        goto L17
    L19:
        r0.append("]}");
        return r0.toString();
    }

    public final Map<K, V> asMap() {
        return new MapWrapper(this);
    }

    public int hashCode() {
        Object[] r1 = this.keys;
        Object[] r2 = this.values;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        int r5 = 0;
        if (r4 < 0) goto L28;
        int r6 = 0;
        int r7 = 0;
    L5:
        long r8 = r3[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r10 = 8 - ((~(r6 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L23;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L22;
        int r14 = (r6 << 3) + r12;
        Object r15 = r1[r14];
        Object r16 = r2[r14];
        if (r15 == null) goto L17;
        int r17 = r15.hashCode();
    L18:
        if (r16 == null) goto L20;
        int r18 = r16.hashCode();
    L21:
        r7 = r7 + (r18 ^ r17);
        goto L22
    L20:
        r18 = 0;
        goto L21
    L17:
        r17 = 0;
    L22:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L23:
        if (r10 == 8) goto L24;
        return r7;
    L24:
        if (r6 == r4) goto L26;
        r6 = r6 + 1;
        goto L5
    L26:
        r5 = r7;
    L28:
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
        Object[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L31;
        int r7 = 0;
        int r8 = 0;
    L9:
        long r9 = r4[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L29;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L28;
        if ((255 & r9) >= 128) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L27;
        int r15 = (r7 << 3) + r13;
        Object r16 = r2[r15];
        Object r17 = r3[r15];
        if (r16 != this) goto L21;
        r16 = "(this)";
    L21:
        r1.append(r16);
        r1.append("=");
        if (r17 != this) goto L24;
        r17 = "(this)";
    L24:
        r1.append(r17);
        r8 = r8 + 1;
        if (r8 >= this._size) goto L27;
        r1.append(", ");
    L27:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L12
    L16:
        r14 = false;
        goto L17
    L28:
        if (r11 != 8) goto L31;
    L29:
        if (r7 == r5) goto L31;
        r7 = r7 + 1;
    L31:
        r1.append('}');
        return r1.toString();
    }

    private ScatterMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        Object[] r0 = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = r0;
        this.values = r0;
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

    public final boolean all(Function2<? super K, ? super V, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
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
        if (((Boolean) r20.invoke(r2[r15], r3[r15])).booleanValue() == true) goto L17;
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

    public final boolean any(Function2<? super K, ? super V, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
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
        if (((Boolean) r20.invoke(r2[r14], r3[r14])).booleanValue() == false) goto L17;
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

    public final boolean contains(K r18) {
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

    public final boolean containsKey(K r18) {
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

    public final boolean containsValue(V r18) {
        Object[] r1 = this.values;
        long[] r2 = this.metadata;
        int r3 = r2.length - 2;
        if (r3 < 0) goto L25;
        int r5 = 0;
    L5:
        long r6 = r2[r5];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r8 = 8 - ((~(r5 - r3)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L20;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L18;
        if (Intrinsics.areEqual(r18, r1[(r5 << 3) + r10]) == false) goto L18;
        return true;
    L18:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L20:
        if (r8 != 8) goto L25;
    L23:
        if (r5 == r3) goto L25;
        r5 = r5 + 1;
    L25:
        return false;
    }

    public final int count(Function2<? super K, ? super V, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
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
        if (((Boolean) r20.invoke(r2[r15], r3[r15])).booleanValue() == false) goto L17;
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
        if ((r20 instanceof ScatterMap) == true) goto L8;
        return false;
    L8:
        ScatterMap r1 = (ScatterMap) r20;
        if (r1.getSize() == getSize()) goto L11;
        return false;
    L11:
        Object[] r3 = this.keys;
        Object[] r5 = this.values;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L37;
        int r8 = 0;
    L14:
        long r9 = r6[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L35;
        int r11 = 8 - ((~(r8 - r7)) >>> 31);
        int r13 = 0;
    L17:
        if (r13 >= r11) goto L34;
        if ((255 & r9) >= 128) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L33;
        int r15 = (r8 << 3) + r13;
        Object r16 = r3[r15];
        Object r17 = r5[r15];
        if (r17 != null) goto L31;
        if (r1.get(r16) != null) goto L29;
        if (r1.containsKey(r16) == true) goto L33;
    L29:
        return false;
    L31:
        if (Intrinsics.areEqual(r17, r1.get(r16)) == true) goto L33;
        return false;
    L33:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L17
    L21:
        r14 = false;
        goto L22
    L34:
        if (r11 != 8) goto L37;
    L35:
        if (r8 == r7) goto L37;
        r8 = r8 + 1;
    L37:
        return true;
    }

    public final int findKeyIndex$collection(K r18) {
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

    public final void forEach(Function2<? super K, ? super V, Unit> r19) {
        Intrinsics.checkNotNullParameter(r19, "block");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
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
        r19.invoke(r2[r14], r3[r14]);
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

    public final void forEachValue(Function1<? super V, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        Object[] r2 = this.values;
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

    public final V get(K r18) {
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
        if (r17 >= 0) goto L28;
        return null;
    L28:
        return (V) this.values[r17];
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

    public final V getOrDefault(K r18, V r19) {
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
        return r19;
    L22:
        return (V) this.values[r17];
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

    public final V getOrElse(K r2, Function0<? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        V r4 = get(r2);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (V) r3.invoke();
    }

    public final String joinToString(CharSequence r23, CharSequence r24, CharSequence r25, int r26, CharSequence r27, Function2<? super K, ? super V, ? extends CharSequence> r28) {
        Intrinsics.checkNotNullParameter(r23, "separator");
        Intrinsics.checkNotNullParameter(r24, "prefix");
        Intrinsics.checkNotNullParameter(r25, "postfix");
        Intrinsics.checkNotNullParameter(r27, "truncated");
        StringBuilder r6 = new StringBuilder();
        r6.append(r24);
        Object[] r2 = this.keys;
        Object[] r7 = this.values;
        long[] r8 = this.metadata;
        int r9 = r8.length - 2;
        if (r9 < 0) goto L32;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r8[r11];
        int r15 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r10 = 8 - ((~(r15 - r9)) >>> 31);
        int r14 = 0;
    L8:
        if (r14 >= r10) goto L25;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L24;
        int r18 = (r15 << 3) + r14;
        Object r0 = r2[r18];
        Object r3 = r7[r18];
        if (r12 == r26) goto L16;
        if (r12 == 0) goto L19;
        r6.append(r23);
    L19:
        if (r28 != null) goto L21;
        r6.append(r0);
        r6.append('=');
        r6.append(r3);
    L22:
        r12 = r12 + 1;
        goto L24
    L21:
        r6.append((CharSequence) r28.invoke(r0, r3));
        goto L22
    L16:
        r6.append(r27);
    L34:
        return r6.toString();
    L24:
        r13 = r13 >> 8;
        r14 = r14 + 1;
        r7 = r7;
        r2 = r2;
        goto L8
    L12:
        r17 = false;
        goto L13
    L25:
        Object[] r19 = r2;
        Object[] r110 = r7;
        if (r10 != 8) goto L32;
    L30:
        if (r15 == r9) goto L32;
        r11 = r15 + 1;
        r7 = r110;
        r2 = r19;
        goto L5
    L28:
        r19 = r2;
        r110 = r7;
    L32:
        r6.append(r25);
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(ScatterMap r4, CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, Function2 r10, int r11, Object r12) {
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
        Function2 r3 = r10;
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
