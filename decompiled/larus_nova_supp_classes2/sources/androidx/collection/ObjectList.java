package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J:\u0010\u0019\u001a\u00020\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001f\u001a\u00020\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010$J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0006\u0010'\u001a\u00020\u0004J:\u0010'\u001a\u00020\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000b\u0010(\u001a\u00028\u0000¢\u0006\u0002\u0010)J?\u0010(\u001a\u00028\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010)JA\u0010+\u001a\u0004\u0018\u00018\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*Jb\u0010,\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-26\u0010/\u001a2\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H-00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00102Jw\u00103\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H-04H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00106Jb\u00107\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-26\u0010/\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H-00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00102Jw\u00108\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u0002H-2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H-¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H-04H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00106J:\u00109\u001a\u00020:2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:0\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010<\u001a\u00020:26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010=\u001a\u00020:2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:0\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010>\u001a\u00020:26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:00H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0018\u0010?\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010@J\u0015\u0010A\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u0004¢\u0006\u0002\u0010@J\u0015\u0010B\u001a\u00020:2\u0006\u00105\u001a\u00020\u0004H\u0000¢\u0006\u0002\bCJ>\u0010D\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u00042!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(5\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010HJ:\u0010I\u001a\u00020\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010J\u001a\u00020\u00042!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010K\u001a\u00020\u0018J\u0006\u0010L\u001a\u00020\u0018J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u0010)J?\u0010M\u001a\u00028\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*J\u0010\u0010N\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010)JA\u0010N\u001a\u0004\u0018\u00018\u00002!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*J\u0013\u0010O\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010HJR\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020S2\b\b\u0002\u0010T\u001a\u00020S2\b\b\u0002\u0010U\u001a\u00020S2\b\b\u0002\u0010V\u001a\u00020\u00042\b\b\u0002\u0010W\u001a\u00020S2\u0016\b\u0002\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020S\u0018\u00010\u001bH\u0007J\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000%H&J\b\u0010Z\u001a\u00020\u0004H\u0016J\u0013\u0010[\u001a\u00020\u00182\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010]\u001a\u00020QH\u0016R\"\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00048Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u00148Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0001^\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, d2 = {"Landroidx/collection/ObjectList;", "E", "", "initialCapacity", "", "<init>", "(I)V", "content", "", "getContent$annotations", "()V", "[Ljava/lang/Object;", "_size", "get_size$annotations", "size", "getSize", "()I", "lastIndex", "getLastIndex", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "none", "", "any", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "element", "reversedAny", "contains", "(Ljava/lang/Object;)Z", "containsAll", "elements", "([Ljava/lang/Object;)Z", "", "", "count", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "index", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "elementAt", "throwIndexOutOfBoundsExclusiveException", "throwIndexOutOfBoundsExclusiveException$collection", "elementAtOrElse", "defaultValue", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastOrNull", "lastIndexOf", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "asList", "hashCode", "equals", "other", "toString", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ CharSequence a(ObjectList r0, Object r1) {
        return toString$lambda$22(r0, r1);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public abstract List<E> asList();

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
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
        return joinToString$default(this, null, "[", "]", 0, null, new a(this), 25, null);
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public int hashCode() {
        Object[] r0 = this.content;
        int r1 = this._size;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L9;
        Object r5 = r0[r3];
        if (r5 == null) goto L7;
        int r6 = r5.hashCode();
    L8:
        r4 = r4 + (r6 * 31);
        r3 = r3 + 1;
        goto L3
    L7:
        r6 = 0;
        goto L8
    L9:
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

    public final boolean any() {
        return isNotEmpty();
    }

    public final E first() {
        if (isEmpty() == false) goto L6;
        RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
    L6:
        return (E) this.content[0];
    }

    public final E firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return get(0);
    }

    public final E last() {
        if (isEmpty() == false) goto L6;
        RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
    L6:
        return (E) this.content[this._size - 1];
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final int count() {
        return this._size;
    }

    public final int getSize() {
        return this._size;
    }

    private ObjectList(int r1) {
        if (r1 != 0) goto L5;
        Object[] r2 = ObjectListKt.access$getEmptyArray$p();
    L6:
        this.content = r2;
        return;
    L5:
        r2 = new Object[r1];
        goto L6
    }

    public final boolean any(Function1<? super E, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (((Boolean) r6.invoke(r0[r3])).booleanValue() == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean contains(E r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(List<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (contains(ListProtector.get(r5, r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final int count(Function1<? super E, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (((Boolean) r6.invoke(r0[r2])).booleanValue() == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }

    public final E elementAt(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        throwIndexOutOfBoundsExclusiveException$collection(r3);
    L10:
        return (E) this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof ObjectList) == false) goto L16;
        ObjectList r8 = (ObjectList) r7;
        int r0 = r8._size;
        int r2 = this._size;
        if (r0 != r2) goto L16;
        Object[] r1 = this.content;
        Object[] r9 = r8.content;
        IntRange r3 = RangesKt.until(0, r2);
        int r4 = r3.getFirst();
        int r5 = r3.getLast();
        if (r4 <= r5) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r1[r4], r9[r4]) == false) goto L11;
        if (r4 == r5) goto L19;
        r4 = r4 + 1;
        goto L10
    L19:
        return true;
    L11:
        return false;
    L16:
        return false;
    }

    public final E first(Function1<? super E, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        E r3 = (E) r0[r2];
        if (((Boolean) r6.invoke(r3)).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final E firstOrNull(Function1<? super E, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        E r3 = (E) r0[r2];
        if (((Boolean) r6.invoke(r3)).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public final void forEach(Function1<? super E, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r5.invoke(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super E, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "block");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r6.invoke(Integer.valueOf(r2), r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super E, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r4.invoke(r0[r1]);
        goto L3
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super E, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r5.invoke(Integer.valueOf(r1), r0[r1]);
        goto L3
    }

    public final E get(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        throwIndexOutOfBoundsExclusiveException$collection(r3);
    L10:
        return (E) this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final int indexOf(E r5) {
        int r0 = 0;
        if (r5 != null) goto L10;
        Object[] r6 = this.content;
        int r1 = this._size;
    L5:
        if (r0 >= r1) goto L16;
        if (r6[r0] == null) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return r0;
    L16:
        return -1;
    L10:
        Object[] r2 = this.content;
        int r3 = this._size;
    L11:
        if (r0 >= r3) goto L22;
        if (r5.equals(r2[r0]) == true) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        return r0;
    L22:
        return -1;
    }

    public final int indexOfFirst(Function1<? super E, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (((Boolean) r5.invoke(r0[r2])).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -1;
    }

    public final int indexOfLast(Function1<? super E, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L9;
        if (((Boolean) r4.invoke(r0[r1])).booleanValue() == false) goto L3;
        return r1;
    L9:
        return -1;
    }

    public final E last(Function1<? super E, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L10;
        E r2 = (E) r0[r1];
        if (((Boolean) r5.invoke(r2)).booleanValue() == false) goto L3;
        return r2;
    L10:
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final int lastIndexOf(E r5) {
        if (r5 != null) goto L10;
        Object[] r6 = this.content;
        int r1 = this._size - 1;
    L5:
        if ((-1) >= r1) goto L16;
        if (r6[r1] == null) goto L8;
        r1 = r1 - 1;
        goto L5
    L8:
        return r1;
    L16:
        return -1;
    L10:
        Object[] r2 = this.content;
        int r3 = this._size - 1;
    L11:
        if ((-1) >= r3) goto L16;
        if (r5.equals(r2[r3]) == true) goto L14;
        r3 = r3 - 1;
        goto L11
    L14:
        return r3;
    }

    public final E lastOrNull(Function1<? super E, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L9;
        E r2 = (E) r0[r1];
        if (((Boolean) r5.invoke(r2)).booleanValue() == false) goto L3;
        return r2;
    L9:
        return null;
    }

    public final boolean reversedAny(Function1<? super E, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Object[] r0 = this.content;
        int r1 = this._size - 1;
    L4:
        if ((-1) >= r1) goto L9;
        if (((Boolean) r5.invoke(r0[r1])).booleanValue() == true) goto L7;
        r1 = r1 - 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    public final void throwIndexOutOfBoundsExclusiveException$collection(int r3) {
        StringBuilder r0 = new StringBuilder("Index ");
        r0.append(r3);
        r0.append(" must be in 0..");
        r0.append(this._size - 1);
        RuntimeHelpersKt.throwIndexOutOfBoundsException(r0.toString());
    }

    public final boolean containsAll(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator<? extends E> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Object[] r0 = r5.content;
        int r6 = r5._size;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L8;
        if (contains(r0[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final boolean containsAll(E[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (contains(r5[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static final CharSequence toString$lambda$22(ObjectList r0, Object r1) {
        if (r1 != r0) goto L5;
        return "(this)";
    L5:
        return String.valueOf(r1);
    }

    public final E elementAtOrElse(int r3, Function1<? super Integer, ? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return (E) r4.invoke(Integer.valueOf(r3));
    L11:
        return (E) this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final <R> R fold(R r5, Function2<? super R, ? super E, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r6, "operation");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        R r7 = r5;
        r5 = (R) r6.invoke(r7, r0[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r5;
    }

    public final <R> R foldIndexed(R r6, Function3<? super Integer, ? super R, ? super E, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r7, "operation");
        Object[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Object r3 = r0[r2];
        r6 = (R) r7.invoke(Integer.valueOf(r2), r6, r3);
        r2 = r2 + 1;
        goto L3
    L5:
        return r6;
    }

    public final <R> R foldRight(R r4, Function2<? super E, ? super R, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r5, "operation");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r4 = (R) r5.invoke(r0[r1], r4);
        goto L3
    L6:
        return r4;
    }

    public final <R> R foldRightIndexed(R r5, Function3<? super Integer, ? super E, ? super R, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r6, "operation");
        Object[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r5 = (R) r6.invoke(Integer.valueOf(r1), r0[r1], r5);
        goto L3
    L6:
        return r5;
    }

    public final String joinToString(CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, Function1<? super E, ? extends CharSequence> r10) {
        Intrinsics.checkNotNullParameter(r5, "separator");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        Intrinsics.checkNotNullParameter(r7, "postfix");
        Intrinsics.checkNotNullParameter(r9, "truncated");
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        Object[] r11 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        Object r3 = r11[r2];
        if (r2 == r8) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r5);
    L9:
        if (r10 != null) goto L11;
        r0.append(r3);
    L12:
        r2 = r2 + 1;
        goto L3
    L11:
        r0.append((CharSequence) r10.invoke(r3));
        goto L12
    L6:
        r0.append(r9);
    L15:
        return r0.toString();
    L13:
        r0.append(r7);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String joinToString$default(ObjectList r4, CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, Function1 r10, int r11, Object r12) {
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
