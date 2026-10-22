package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u0005¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0018\u001a7\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\u001aG\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001a\u001aW\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001b\u001ag\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001c\u001aD\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001d\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aL\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\"\u001a\u00020#2\u001d\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"EmptyLongObjectMap", "Landroidx/collection/MutableLongObjectMap;", "", "emptyLongObjectMap", "Landroidx/collection/LongObjectMap;", "V", "longObjectMapOf", "key1", "", "value1", "(JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key2", "value2", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key3", "value3", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key4", "value4", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key5", "value5", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "mutableLongObjectMapOf", "(JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "buildLongObjectMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap = null;

    static {
        EmptyLongObjectMap = new MutableLongObjectMap(0);
    }

    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap r0 = EmptyLongObjectMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return r0;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap r0 = EmptyLongObjectMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return r0;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap(0, 1, null);
    }

    public static final <V> LongObjectMap<V> buildLongObjectMap(Function1<? super MutableLongObjectMap<V>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        MutableLongObjectMap r0 = new MutableLongObjectMap(0, 1, null);
        r4.invoke(r0);
        return r0;
    }

    public static final <V> LongObjectMap<V> buildLongObjectMap(int r1, Function1<? super MutableLongObjectMap<V>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        MutableLongObjectMap r0 = new MutableLongObjectMap(r1);
        r2.invoke(r0);
        return r0;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long r4, V r6) {
        MutableLongObjectMap r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        return r0;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long r4, V r6) {
        MutableLongObjectMap<V> r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        return r0;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long r4, V r6, long r7, V r9) {
        MutableLongObjectMap r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        return r0;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long r4, V r6, long r7, V r9) {
        MutableLongObjectMap<V> r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        return r0;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long r4, V r6, long r7, V r9, long r10, V r12) {
        MutableLongObjectMap r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        return r0;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long r4, V r6, long r7, V r9, long r10, V r12) {
        MutableLongObjectMap<V> r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        return r0;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long r4, V r6, long r7, V r9, long r10, V r12, long r13, V r15) {
        MutableLongObjectMap r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        return r0;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long r4, V r6, long r7, V r9, long r10, V r12, long r13, V r15) {
        MutableLongObjectMap<V> r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        return r0;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long r4, V r6, long r7, V r9, long r10, V r12, long r13, V r15, long r16, V r18) {
        MutableLongObjectMap r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        r0.set(r16, r18);
        return r0;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long r4, V r6, long r7, V r9, long r10, V r12, long r13, V r15, long r16, V r18) {
        MutableLongObjectMap<V> r0 = new MutableLongObjectMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        r0.set(r16, r18);
        return r0;
    }
}
