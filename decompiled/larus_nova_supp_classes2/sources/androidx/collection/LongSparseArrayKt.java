package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\u001a(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b¢\u0006\u0002\u0010\u0007\u001a.\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0080\b\u001a!\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a.\u0010\u000b\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b\u001a0\u0010\u0013\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\t\u001a6\u0010\u0013\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u0002H\u00032\u0006\u0010\u0015\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a.\u0010\u0018\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u0019\u001a)\u0010\u001a\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0004H\u0080\b\u001a0\u0010\u001c\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u001d\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a\u0019\u0010\u001e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a!\u0010\u001f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b\u001a&\u0010 \u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010#\u001a!\u0010$\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a&\u0010%\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010&\u001a!\u0010'\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a&\u0010(\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010)\u001a\u0019\u0010*\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a.\u0010+\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010,\u001a\u00020-\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a!\u00104\u001a\u00020\r\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\n\u001a.\u00105\u001a\u00020\f\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H/H\u0086\n¢\u0006\u0002\u0010\u0019\u001a-\u00106\u001a\b\u0012\u0004\u0012\u0002H/0\u0004\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H/0\u0004H\u0086\u0002\u001a.\u00107\u001a\u0002H/\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u0002H/H\u0086\b¢\u0006\u0002\u0010\t\u001a7\u00108\u001a\u0002H/\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H/09H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010:\u001a\u0019\u0010;\u001a\u00020\r\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u0004H\u0086\b\u001a-\u0010<\u001a\u00020\r\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H/H\u0007¢\u0006\u0002\u0010\u000f\u001aT\u0010=\u001a\u00020\f\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u000426\u0010>\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u0011H/¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\f0?H\u0086\bø\u0001\u0000\u001a\u0016\u0010B\u001a\u00020C\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u0004\u001a\u001c\u0010D\u001a\b\u0012\u0004\u0012\u0002H/0E\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010.\u001a\u00020\u0012\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00048Æ\u0002¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"DELETED", "", "commonGet", "E", "Landroidx/collection/LongSparseArray;", "key", "", "(Landroidx/collection/LongSparseArray;J)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "commonGetInternal", "commonRemove", "", "", "value", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "commonRemoveAt", "index", "", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;Ljava/lang/Object;)Z", "commonGc", "commonPut", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "commonPutAll", "other", "commonPutIfAbsent", "commonSize", "commonIsEmpty", "commonKeyAt", "commonValueAt", "(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;", "commonSetValueAt", "(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)I", "commonContainsKey", "commonContainsValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)Z", "commonClear", "commonAppend", "commonToString", "", "size", "T", "getSize$annotations", "(Landroidx/collection/LongSparseArray;)V", "getSize", "(Landroidx/collection/LongSparseArray;)I", "contains", "set", "plus", "getOrDefault", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "remove", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "keyIterator", "Lkotlin/collections/LongIterator;", "valueIterator", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LongSparseArrayKt {
    private static final Object DELETED = null;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/LongSparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C00841<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray<T> r0 = this.$this_valueIterator;
            int r1 = this.index;
            this.index = r1 + 1;
            return (T) r0.valueAt(r1);
        }

        public final int getIndex() {
            return this.index;
        }

        public C00841(LongSparseArray<T> r1) {
            this.$this_valueIterator = r1;
        }

        public final void setIndex(int r1) {
            this.index = r1;
        }
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray r0) {
    }

    static {
        DELETED = new Object();
    }

    public static final /* synthetic */ Object access$getDELETED$p() {
        return DELETED;
    }

    public static final <E> void commonClear(LongSparseArray<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.size;
        Object[] r1 = r5.values;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        r5.size = 0;
        r5.garbage = false;
    }

    public static final <E> void commonGc(LongSparseArray<E> r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = r9.size;
        long[] r1 = r9.keys;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L9;
        if (r4 == r5) goto L8;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L8:
        r5 = r5 + 1;
    L9:
        r4 = r4 + 1;
        goto L3
    L10:
        r9.garbage = false;
        r9.size = r5;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> int commonSize(LongSparseArray<E> r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.garbage == false) goto L14;
        int r0 = r9.size;
        long[] r1 = r9.keys;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L11;
        if (r4 == r5) goto L10;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L10:
        r5 = r5 + 1;
    L11:
        r4 = r4 + 1;
        goto L5
    L12:
        r9.garbage = false;
        r9.size = r5;
    L14:
        return r9.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.size() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder(r5.size * 28);
        r1.append('{');
        int r0 = r5.size;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L15;
        if (r2 <= 0) goto L10;
        r1.append(", ");
    L10:
        r1.append(r5.keyAt(r2));
        r1.append('=');
        Object r3 = r5.valueAt(r2);
        if (r3 == r1) goto L13;
        r1.append(r3);
    L14:
        r2 = r2 + 1;
        goto L7
    L13:
        r1.append("(this Map)");
        goto L14
    L15:
        r1.append('}');
        return r1.toString();
    }

    public static final <T> int getSize(LongSparseArray<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !r1.isEmpty();
    }

    public static final <T> LongIterator keyIterator(final LongSparseArray<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new C00841(r1);
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> r1, E r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfValue(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> E commonGet(LongSparseArray<E> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
    L8:
        return null;
    L5:
        if (r2.values[r4] == access$getDELETED$p()) goto L8;
        return (E) r2.values[r4];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.garbage == false) goto L14;
        int r0 = r9.size;
        long[] r1 = r9.keys;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L11;
        if (r4 == r5) goto L10;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L10:
        r5 = r5 + 1;
    L11:
        r4 = r4 + 1;
        goto L5
    L12:
        r9.garbage = false;
        r9.size = r5;
    L14:
        return ContainerHelpersKt.binarySearch(r9.keys, r9.size, r10);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> r9, E r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r1 = 0;
        if (r9.garbage == false) goto L13;
        int r0 = r9.size;
        long[] r2 = r9.keys;
        Object[] r3 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r0) goto L12;
        Object r6 = r3[r4];
        if (r6 == access$getDELETED$p()) goto L11;
        if (r4 == r5) goto L10;
        r2[r5] = r2[r4];
        r3[r5] = r6;
        r3[r4] = null;
    L10:
        r5 = r5 + 1;
    L11:
        r4 = r4 + 1;
        goto L5
    L12:
        r9.garbage = false;
        r9.size = r5;
    L13:
        int r7 = r9.size;
    L14:
        if (r1 >= r7) goto L19;
        if (r9.values[r1] == r10) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        return r1;
    L19:
        return -1;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r10);
    L11:
        if (r9.garbage == false) goto L22;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L13:
        if (r5 >= r2) goto L20;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L19;
        if (r5 == r6) goto L18;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L18:
        r6 = r6 + 1;
    L19:
        r5 = r5 + 1;
        goto L13
    L20:
        r9.garbage = false;
        r9.size = r6;
    L22:
        return r9.keys[r10];
    L5:
        if (r10 >= r9.size) goto L7;
        r1 = true;
        goto L8
    }

    public static final <E> void commonPutAll(LongSparseArray<E> r5, LongSparseArray<? extends E> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.put(r6.keyAt(r1), r6.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <E> void commonRemove(LongSparseArray<E> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r2.values[r4] == access$getDELETED$p()) goto L9;
        r2.values[r4] = access$getDELETED$p();
        r2.garbage = true;
        return;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.values[r3] == access$getDELETED$p()) goto L6;
        r2.values[r3] = access$getDELETED$p();
        r2.garbage = true;
        return;
    }

    public static final <E> E commonValueAt(LongSparseArray<E> r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r10);
    L11:
        if (r9.garbage == false) goto L22;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L13:
        if (r5 >= r2) goto L20;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L19;
        if (r5 == r6) goto L18;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L18:
        r6 = r6 + 1;
    L19:
        r5 = r5 + 1;
        goto L13
    L20:
        r9.garbage = false;
        r9.size = r6;
    L22:
        return (E) r9.values[r10];
    L5:
        if (r10 >= r9.size) goto L7;
        r1 = true;
        goto L8
    }

    public static final <T> boolean contains(LongSparseArray<T> r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.containsKey(r2);
    }

    public static final <T> void forEach(LongSparseArray<T> r4, Function2<? super Long, ? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.invoke(Long.valueOf(r4.keyAt(r1)), r4.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> r3, LongSparseArray<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        LongSparseArray<T> r0 = new LongSparseArray(r3.size() + r4.size());
        r0.putAll(r3);
        r0.putAll(r4);
        return r0;
    }

    public static final <E> void commonAppend(LongSparseArray<E> r9, long r10, E r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = r9.size;
        if (r0 == 0) goto L9;
        if (r10 > r9.keys[r0 - 1]) goto L9;
        r9.put(r10, r12);
        return;
    L9:
        if (r9.garbage == false) goto L21;
        long[] r1 = r9.keys;
        if (r0 < r1.length) goto L21;
        Object[] r2 = r9.values;
        int r4 = 0;
        int r5 = 0;
    L13:
        if (r4 >= r0) goto L20;
        Object r6 = r2[r4];
        if (r6 == access$getDELETED$p()) goto L19;
        if (r4 == r5) goto L18;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L18:
        r5 = r5 + 1;
    L19:
        r4 = r4 + 1;
        goto L13
    L20:
        r9.garbage = false;
        r9.size = r5;
    L21:
        int r3 = r9.size;
        if (r3 < r9.keys.length) goto L24;
        int r7 = ContainerHelpersKt.idealLongArraySize(r3 + 1);
        r9.keys = Arrays.copyOf(r9.keys, r7);
        r9.values = Arrays.copyOf(r9.values, r7);
    L24:
        r9.keys[r3] = r10;
        r9.values[r3] = r12;
        r9.size = r3 + 1;
    }

    public static final <E> E commonGet(LongSparseArray<E> r2, long r3, E r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
        return r5;
    L5:
        if (r2.values[r4] != access$getDELETED$p()) goto L8;
        return r5;
    L8:
        return (E) r2.values[r4];
    }

    public static final Object commonGetInternal(LongSparseArray<?> r2, long r3, Object r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r4 = ContainerHelpersKt.binarySearch(r2.keys, r2.size, r3);
        if (r4 >= 0) goto L5;
        return r5;
    L5:
        if (r2.values[r4] != access$getDELETED$p()) goto L8;
        return r5;
    L8:
        return r2.values[r4];
    }

    public static final <E> void commonPut(LongSparseArray<E> r9, long r10, E r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = ContainerHelpersKt.binarySearch(r9.keys, r9.size, r10);
        if (r0 < 0) goto L5;
        r9.values[r0] = r12;
        return;
    L5:
        int r1 = ~r0;
        if (r1 >= r9.size) goto L12;
        if (r9.values[r1] != access$getDELETED$p()) goto L12;
        r9.keys[r1] = r10;
        r9.values[r1] = r12;
        return;
    L12:
        if (r9.garbage == false) goto L24;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        if (r2 < r3.length) goto L24;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L16:
        if (r5 >= r2) goto L23;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L22;
        if (r5 == r6) goto L21;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L21:
        r6 = r6 + 1;
    L22:
        r5 = r5 + 1;
        goto L16
    L23:
        r9.garbage = false;
        r9.size = r6;
        r1 = ~ContainerHelpersKt.binarySearch(r9.keys, r6, r10);
    L24:
        int r8 = r9.size;
        if (r8 < r9.keys.length) goto L27;
        int r11 = ContainerHelpersKt.idealLongArraySize(r8 + 1);
        r9.keys = Arrays.copyOf(r9.keys, r11);
        r9.values = Arrays.copyOf(r9.values, r11);
    L27:
        int r13 = r9.size;
        if ((r13 - r1) == 0) goto L30;
        long[] r14 = r9.keys;
        int r15 = r1 + 1;
        ArraysKt.copyInto(r14, r14, r15, r1, r13);
        Object[] r16 = r9.values;
        ArraysKt.copyInto(r16, r16, r15, r1, r9.size);
    L30:
        r9.keys[r1] = r10;
        r9.values[r1] = r12;
        r9.size++;
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> r1, long r2, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        E r0 = (E) r1.get(r2);
        if (r0 != null) goto L5;
        r1.put(r2, r4);
    L5:
        return r0;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> r1, long r2, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOfKey(r2);
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4, r1.valueAt(r3)) == false) goto L10;
        r1.removeAt(r3);
        return true;
    L10:
        return false;
    }

    public static final <E> E commonReplace(LongSparseArray<E> r1, long r2, E r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOfKey(r2);
        if (r3 < 0) goto L6;
        Object[] r5 = r1.values;
        E r6 = (E) r5[r3];
        r5[r3] = r4;
        return r6;
    L6:
        return null;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> r9, int r10, E r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r10 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r10);
    L11:
        if (r9.garbage == false) goto L21;
        int r2 = r9.size;
        long[] r3 = r9.keys;
        Object[] r4 = r9.values;
        int r5 = 0;
        int r6 = 0;
    L13:
        if (r5 >= r2) goto L20;
        Object r7 = r4[r5];
        if (r7 == access$getDELETED$p()) goto L19;
        if (r5 == r6) goto L18;
        r3[r6] = r3[r5];
        r4[r6] = r7;
        r4[r5] = null;
    L18:
        r6 = r6 + 1;
    L19:
        r5 = r5 + 1;
        goto L13
    L20:
        r9.garbage = false;
        r9.size = r6;
    L21:
        r9.values[r10] = r11;
        return;
    L5:
        if (r10 >= r9.size) goto L7;
        r1 = true;
        goto L8
    }

    public static final <T> T getOrDefault(LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (T) r1.get(r2, r4);
    }

    public static final <T> T getOrElse(LongSparseArray<T> r1, long r2, Function0<? extends T> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        T r3 = (T) r1.get(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return (T) r4.invoke();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(LongSparseArray r1, long r2, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.remove(r2, r4);
    }

    public static final <T> void set(LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put(r2, r4);
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> r1, long r2, E r4, E r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = r1.indexOfKey(r2);
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r1.values[r3], r4) == false) goto L10;
        r1.values[r3] = r5;
        return true;
    L10:
        return false;
    }
}
