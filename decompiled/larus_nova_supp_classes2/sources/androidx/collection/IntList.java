package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.RuntimeHelpersKt;
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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0015\u001a\u00020\u0016H\u0086\bJ\t\u0010\u0017\u001a\u00020\u0016H\u0086\bJ:\u0010\u0017\u001a\u00020\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010\u001d\u001a\u00020\u00162!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0000J\t\u0010!\u001a\u00020\u0003H\u0086\bJ:\u0010!\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\"\u001a\u00020\u0003J:\u0010\"\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001Jb\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u0002H$26\u0010&\u001a2\u0012\u0013\u0012\u0011H$¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H$0'H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010)Jw\u0010*\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u0002H$2K\u0010&\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H$¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H$0+H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jb\u0010.\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u0002H$26\u0010&\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H$¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H$0'H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010)Jw\u0010/\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u0002H$2K\u0010&\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H$¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H$0+H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-J:\u00100\u001a\u0002012!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002010\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00103\u001a\u00020126\u00102\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002010'H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00104\u001a\u0002012!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002010\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00105\u001a\u00020126\u00102\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002010'H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u00106\u001a\u00020\u00032\b\b\u0001\u0010,\u001a\u00020\u0003H\u0086\u0002J\u0010\u00107\u001a\u00020\u00032\b\b\u0001\u0010,\u001a\u00020\u0003J9\u00108\u001a\u00020\u00032\b\b\u0001\u0010,\u001a\u00020\u00032!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00030\u0019H\u0086\bø\u0001\u0000J\u000e\u0010:\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003J:\u0010;\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010<\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\t\u0010=\u001a\u00020\u0016H\u0086\bJ\t\u0010>\u001a\u00020\u0016H\u0086\bJ\u0006\u0010?\u001a\u00020\u0003J:\u0010?\u001a\u00020\u00032!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000e\u0010@\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003J$\u0010A\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u0003H\u0007J:\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020G2\b\b\u0002\u0010I\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020\u00032\b\b\u0002\u0010K\u001a\u00020GH\u0007JT\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020G2\b\b\u0002\u0010I\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020\u00032\b\b\u0002\u0010K\u001a\u00020G2\u0014\b\u0004\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020G0\u0019H\u0087\bø\u0001\u0000J\b\u0010M\u001a\u00020\u0003H\u0016J\u0013\u0010N\u001a\u00020\u00162\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010P\u001a\u00020EH\u0016R\u0018\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0001Q\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, d2 = {"Landroidx/collection/IntList;", "", "initialCapacity", "", "<init>", "(I)V", "content", "", "getContent$annotations", "()V", "_size", "get_size$annotations", "size", "getSize", "()I", "lastIndex", "getLastIndex", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "none", "", "any", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "element", "reversedAny", "contains", "containsAll", "elements", "count", "first", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "index", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "elementAt", "elementAtOrElse", "defaultValue", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "binarySearch", "fromIndex", "toIndex", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "hashCode", "equals", "other", "toString", "Landroidx/collection/MutableIntList;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class IntList {
    public int _size;
    public int[] content;

    public /* synthetic */ IntList(int r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final int binarySearch(int r7) {
        return binarySearch$default(this, r7, 0, 0, 6, null);
    }

    public final int binarySearch(int r7, int r8) {
        return binarySearch$default(this, r7, r8, 0, 4, null);
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
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

    public final int first() {
        if (this._size != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        RuntimeHelpersKt.throwNoSuchElementException("IntList is empty.");
    L9:
        return this.content[0];
    L5:
        r0 = false;
        goto L6
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public int hashCode() {
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r3 = r3 + (r0[r2] * 31);
        r2 = r2 + 1;
        goto L3
    L5:
        return r3;
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

    public final int last() {
        if (this._size != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        RuntimeHelpersKt.throwNoSuchElementException("IntList is empty.");
    L9:
        return this.content[this._size - 1];
    L5:
        r0 = false;
        goto L6
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final int getSize() {
        return this._size;
    }

    private IntList(int r1) {
        if (r1 != 0) goto L5;
        int[] r2 = IntSetKt.getEmptyIntArray();
    L6:
        this.content = r2;
        return;
    L5:
        r2 = new int[r1];
        goto L6
    }

    public final boolean any(Function1<? super Integer, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        int[] r0 = this.content;
        int r1 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (((Boolean) r6.invoke(Integer.valueOf(r0[r3]))).booleanValue() == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean contains(int r6) {
        int[] r0 = this.content;
        int r1 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r0[r3] == r6) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean containsAll(IntList r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        IntRange r0 = RangesKt.until(0, r5._size);
        int r2 = r0.getFirst();
        int r1 = r0.getLast();
        if (r2 <= r1) goto L5;
        return true;
    L5:
        if (contains(r5.get(r2)) == false) goto L6;
        if (r2 == r1) goto L13;
        r2 = r2 + 1;
        goto L5
    L13:
        return true;
    L6:
        return false;
    }

    public final int count(Function1<? super Integer, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (((Boolean) r6.invoke(Integer.valueOf(r0[r2]))).booleanValue() == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }

    public final int elementAt(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L10:
        return this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof IntList) == false) goto L16;
        IntList r8 = (IntList) r7;
        int r0 = r8._size;
        int r2 = this._size;
        if (r0 != r2) goto L16;
        int[] r1 = this.content;
        int[] r9 = r8.content;
        IntRange r3 = RangesKt.until(0, r2);
        int r4 = r3.getFirst();
        int r5 = r3.getLast();
        if (r4 <= r5) goto L10;
        return true;
    L10:
        if (r1[r4] != r9[r4]) goto L11;
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

    public final int first(Function1<? super Integer, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        int r3 = r0[r2];
        if (((Boolean) r6.invoke(Integer.valueOf(r3))).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    public final void forEach(Function1<? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r5.invoke(Integer.valueOf(r0[r2]));
        r2 = r2 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "block");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r6.invoke(Integer.valueOf(r2), Integer.valueOf(r0[r2]));
        r2 = r2 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r4.invoke(Integer.valueOf(r0[r1]));
        goto L3
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r5.invoke(Integer.valueOf(r1), Integer.valueOf(r0[r1]));
        goto L3
    }

    public final int get(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L10:
        return this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final int indexOf(int r5) {
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r5 == r0[r2]) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -1;
    }

    public final int indexOfFirst(Function1<? super Integer, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (((Boolean) r5.invoke(Integer.valueOf(r0[r2]))).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -1;
    }

    public final int indexOfLast(Function1<? super Integer, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "predicate");
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L9;
        if (((Boolean) r4.invoke(Integer.valueOf(r0[r1]))).booleanValue() == false) goto L3;
        return r1;
    L9:
        return -1;
    }

    public final String joinToString(Function1<? super Integer, ? extends CharSequence> r8) {
        Intrinsics.checkNotNullParameter(r8, "transform");
        StringBuilder r0 = new StringBuilder("");
        int[] r2 = this.content;
        int r3 = this._size;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L10;
        int r5 = r2[r4];
        if (r4 == (-1)) goto L6;
        if (r4 == 0) goto L9;
        r0.append(", ");
    L9:
        r0.append((CharSequence) r8.invoke(Integer.valueOf(r5)));
        r4 = r4 + 1;
        goto L3
    L6:
        r0.append("...");
    L12:
        return r0.toString();
    L10:
        r0.append("");
        goto L12
    }

    public final int last(Function1<? super Integer, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L10;
        int r2 = r0[r1];
        if (((Boolean) r5.invoke(Integer.valueOf(r2))).booleanValue() == false) goto L3;
        return r2;
    L10:
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    public final int lastIndexOf(int r4) {
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L9;
        if (r0[r1] != r4) goto L3;
        return r1;
    L9:
        return -1;
    }

    public final boolean reversedAny(Function1<? super Integer, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        int[] r0 = this.content;
        int r1 = this._size - 1;
    L4:
        if ((-1) >= r1) goto L9;
        if (((Boolean) r5.invoke(Integer.valueOf(r0[r1]))).booleanValue() == true) goto L7;
        r1 = r1 - 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    public final int elementAtOrElse(int r3, Function1<? super Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return ((Number) r4.invoke(Integer.valueOf(r3))).intValue();
    L11:
        return this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final <R> R fold(R r5, Function2<? super R, ? super Integer, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r6, "operation");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        R r7 = r5;
        r5 = (R) r6.invoke(r7, Integer.valueOf(r0[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r5;
    }

    public final <R> R foldIndexed(R r6, Function3<? super Integer, ? super R, ? super Integer, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r7, "operation");
        int[] r0 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = r0[r2];
        R r8 = r6;
        r6 = (R) r7.invoke(Integer.valueOf(r2), r8, Integer.valueOf(r3));
        r2 = r2 + 1;
        goto L3
    L5:
        return r6;
    }

    public final <R> R foldRight(R r4, Function2<? super Integer, ? super R, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r5, "operation");
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r4 = (R) r5.invoke(Integer.valueOf(r0[r1]), r4);
        goto L3
    L6:
        return r4;
    }

    public final <R> R foldRightIndexed(R r5, Function3<? super Integer, ? super Integer, ? super R, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r6, "operation");
        int[] r0 = this.content;
        int r1 = this._size;
    L3:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L6;
        r5 = (R) r6.invoke(Integer.valueOf(r1), Integer.valueOf(r0[r1]), r5);
        goto L3
    L6:
        return r5;
    }

    public final String joinToString(CharSequence r8, Function1<? super Integer, ? extends CharSequence> r9) {
        Intrinsics.checkNotNullParameter(r8, "separator");
        Intrinsics.checkNotNullParameter(r9, "transform");
        StringBuilder r0 = new StringBuilder("");
        int[] r2 = this.content;
        int r3 = this._size;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L10;
        int r5 = r2[r4];
        if (r4 == (-1)) goto L6;
        if (r4 == 0) goto L9;
        r0.append(r8);
    L9:
        r0.append((CharSequence) r9.invoke(Integer.valueOf(r5)));
        r4 = r4 + 1;
        goto L3
    L6:
        r0.append("...");
    L12:
        return r0.toString();
    L10:
        r0.append("");
        goto L12
    }

    public final int binarySearch(int r3, int r4, int r5) {
        if (r4 < 0) goto L6;
        if (r4 >= r5) goto L6;
        if (r5 > this._size) goto L6;
    L7:
        int r6 = r5 - 1;
    L8:
        if (r4 > r6) goto L16;
        int r0 = (r4 + r6) >>> 1;
        int r1 = this.content[r0];
        if (r1 < r3) goto L11;
        if (r1 <= r3) goto L14;
        r6 = r0 - 1;
        goto L8
    L14:
        return r0;
    L11:
        r4 = r0 + 1;
        goto L8
    L16:
        return -(r4 + 1);
    L6:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        goto L7
    }

    public final String joinToString(CharSequence r6, CharSequence r7, Function1<? super Integer, ? extends CharSequence> r8) {
        Intrinsics.checkNotNullParameter(r6, "separator");
        Intrinsics.checkNotNullParameter(r7, "prefix");
        Intrinsics.checkNotNullParameter(r8, "transform");
        StringBuilder r0 = new StringBuilder();
        r0.append(r7);
        int[] r9 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        int r3 = r9[r2];
        if (r2 == (-1)) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r6);
    L9:
        r0.append((CharSequence) r8.invoke(Integer.valueOf(r3)));
        r2 = r2 + 1;
        goto L3
    L6:
        r0.append("...");
    L12:
        return r0.toString();
    L10:
        r0.append("");
        goto L12
    }

    public final String joinToString(CharSequence r6, CharSequence r7, CharSequence r8, Function1<? super Integer, ? extends CharSequence> r9) {
        Intrinsics.checkNotNullParameter(r6, "separator");
        Intrinsics.checkNotNullParameter(r7, "prefix");
        Intrinsics.checkNotNullParameter(r8, "postfix");
        Intrinsics.checkNotNullParameter(r9, "transform");
        StringBuilder r0 = new StringBuilder();
        r0.append(r7);
        int[] r10 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        int r3 = r10[r2];
        if (r2 == (-1)) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r6);
    L9:
        r0.append((CharSequence) r9.invoke(Integer.valueOf(r3)));
        r2 = r2 + 1;
        goto L3
    L6:
        r0.append("...");
    L12:
        return r0.toString();
    L10:
        r0.append(r8);
        goto L12
    }

    public final String joinToString(CharSequence r5, CharSequence r6, CharSequence r7, int r8, Function1<? super Integer, ? extends CharSequence> r9) {
        Intrinsics.checkNotNullParameter(r5, "separator");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        Intrinsics.checkNotNullParameter(r7, "postfix");
        Intrinsics.checkNotNullParameter(r9, "transform");
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        int[] r10 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        int r3 = r10[r2];
        if (r2 == r8) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r5);
    L9:
        r0.append((CharSequence) r9.invoke(Integer.valueOf(r3)));
        r2 = r2 + 1;
        goto L3
    L6:
        r0.append("...");
    L12:
        return r0.toString();
    L10:
        r0.append(r7);
        goto L12
    }

    public final String joinToString(CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9) {
        Intrinsics.checkNotNullParameter(r5, "separator");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        Intrinsics.checkNotNullParameter(r7, "postfix");
        Intrinsics.checkNotNullParameter(r9, "truncated");
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        int[] r10 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        int r3 = r10[r2];
        if (r2 == r8) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r5);
    L9:
        r0.append(r3);
        r2 = r2 + 1;
        goto L3
    L6:
        r0.append(r9);
    L12:
        return r0.toString();
    L10:
        r0.append(r7);
        goto L12
    }

    public static /* synthetic */ int binarySearch$default(IntList r0, int r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = r0._size;
    L10:
        return r0.binarySearch(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: binarySearch");
    }

    public final String joinToString(CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, Function1<? super Integer, ? extends CharSequence> r10) {
        Intrinsics.checkNotNullParameter(r5, "separator");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        Intrinsics.checkNotNullParameter(r7, "postfix");
        Intrinsics.checkNotNullParameter(r9, "truncated");
        Intrinsics.checkNotNullParameter(r10, "transform");
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        int[] r11 = this.content;
        int r1 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        int r3 = r11[r2];
        if (r2 == r8) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r5);
    L9:
        r0.append((CharSequence) r10.invoke(Integer.valueOf(r3)));
        r2 = r2 + 1;
        goto L3
    L6:
        r0.append(r9);
    L12:
        return r0.toString();
    L10:
        r0.append(r7);
        goto L12
    }

    public static /* synthetic */ String joinToString$default(IntList r3, CharSequence r4, CharSequence r5, CharSequence r6, int r7, CharSequence r8, int r9, Object r10) {
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

    public static /* synthetic */ String joinToString$default(IntList r1, CharSequence r2, CharSequence r3, CharSequence r4, int r5, CharSequence r6, Function1 r7, int r8, Object r9) {
        if (r9 != null) goto L30;
        if ((r8 & 1) == 0) goto L7;
        r2 = ", ";
    L7:
        if ((r8 & 2) == 0) goto L10;
        r3 = "";
    L10:
        if ((r8 & 4) == 0) goto L13;
        r4 = "";
    L13:
        if ((r8 & 8) == 0) goto L16;
        r5 = -1;
    L16:
        if ((r8 & 16) == 0) goto L18;
        r6 = "...";
    L18:
        Intrinsics.checkNotNullParameter(r2, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r6, "truncated");
        Intrinsics.checkNotNullParameter(r7, "transform");
        StringBuilder r10 = new StringBuilder();
        r10.append(r3);
        int[] r11 = r1.content;
        int r12 = r1._size;
        int r13 = 0;
    L19:
        if (r13 >= r12) goto L26;
        int r0 = r11[r13];
        if (r13 == r5) goto L22;
        if (r13 == 0) goto L25;
        r10.append(r2);
    L25:
        r10.append((CharSequence) r7.invoke(Integer.valueOf(r0)));
        r13 = r13 + 1;
        goto L19
    L22:
        r10.append(r6);
    L28:
        return r10.toString();
    L26:
        r10.append(r4);
        goto L28
    L30:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }
}
