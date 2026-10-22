package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u0005¢\u0006\u0002\u0010\b\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n\u001a/\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u0005¢\u0006\u0002\u0010\f\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000e\"\u0002H\u0005¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0011\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0012\u001a/\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001a+\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000e\"\u0002H\u0005¢\u0006\u0002\u0010\u0014\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EmptyOrderedScatterSet", "Landroidx/collection/MutableOrderedScatterSet;", "", "emptyOrderedScatterSet", "Landroidx/collection/OrderedScatterSet;", "E", "orderedScatterSetOf", "element1", "(Ljava/lang/Object;)Landroidx/collection/OrderedScatterSet;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/OrderedScatterSet;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/OrderedScatterSet;", "elements", "", "([Ljava/lang/Object;)Landroidx/collection/OrderedScatterSet;", "mutableOrderedScatterSetOf", "(Ljava/lang/Object;)Landroidx/collection/MutableOrderedScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableOrderedScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableOrderedScatterSet;", "([Ljava/lang/Object;)Landroidx/collection/MutableOrderedScatterSet;", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OrderedScatterSetKt {
    private static final MutableOrderedScatterSet<Object> EmptyOrderedScatterSet = null;

    static {
        EmptyOrderedScatterSet = new MutableOrderedScatterSet(0);
    }

    public static final <E> OrderedScatterSet<E> emptyOrderedScatterSet() {
        MutableOrderedScatterSet<Object> r0 = EmptyOrderedScatterSet;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.OrderedScatterSet<E of androidx.collection.OrderedScatterSetKt.emptyOrderedScatterSet>");
        return r0;
    }

    public static final <E> MutableOrderedScatterSet<E> mutableOrderedScatterSetOf() {
        return new MutableOrderedScatterSet(0, 1, null);
    }

    public static final <E> OrderedScatterSet<E> orderedScatterSetOf() {
        MutableOrderedScatterSet<Object> r0 = EmptyOrderedScatterSet;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.OrderedScatterSet<E of androidx.collection.OrderedScatterSetKt.orderedScatterSetOf>");
        return r0;
    }

    public static final <E> MutableOrderedScatterSet<E> mutableOrderedScatterSetOf(E... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableOrderedScatterSet<E> r0 = new MutableOrderedScatterSet(r2.length);
        r0.plusAssign(r2);
        return r0;
    }

    public static final <E> OrderedScatterSet<E> orderedScatterSetOf(E... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableOrderedScatterSet r0 = new MutableOrderedScatterSet(r2.length);
        r0.plusAssign(r2);
        return r0;
    }

    public static final <E> MutableOrderedScatterSet<E> mutableOrderedScatterSetOf(E r2) {
        MutableOrderedScatterSet<E> r0 = new MutableOrderedScatterSet(1);
        r0.plusAssign(r2);
        return r0;
    }

    public static final <E> OrderedScatterSet<E> orderedScatterSetOf(E r0) {
        return mutableOrderedScatterSetOf(r0);
    }

    public static final <E> MutableOrderedScatterSet<E> mutableOrderedScatterSetOf(E r2, E r3) {
        MutableOrderedScatterSet<E> r0 = new MutableOrderedScatterSet(2);
        r0.plusAssign(r2);
        r0.plusAssign(r3);
        return r0;
    }

    public static final <E> OrderedScatterSet<E> orderedScatterSetOf(E r0, E r1) {
        return mutableOrderedScatterSetOf(r0, r1);
    }

    public static final <E> MutableOrderedScatterSet<E> mutableOrderedScatterSetOf(E r2, E r3, E r4) {
        MutableOrderedScatterSet<E> r0 = new MutableOrderedScatterSet(3);
        r0.plusAssign(r2);
        r0.plusAssign(r3);
        r0.plusAssign(r4);
        return r0;
    }

    public static final <E> OrderedScatterSet<E> orderedScatterSetOf(E r0, E r1, E r2) {
        return mutableOrderedScatterSetOf(r0, r1, r2);
    }
}
