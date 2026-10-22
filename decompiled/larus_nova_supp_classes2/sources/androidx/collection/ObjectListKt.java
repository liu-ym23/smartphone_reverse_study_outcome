package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a \u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000f0\r\"\u0004\b\u0000\u0010\u000f\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\r\"\u0004\b\u0000\u0010\u000f\u001a\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\r\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0011\u001a\u0002H\u000f¢\u0006\u0002\u0010\u0012\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\r\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0011\u001a\u0002H\u000f2\u0006\u0010\u0013\u001a\u0002H\u000f¢\u0006\u0002\u0010\u0014\u001a/\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\r\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0011\u001a\u0002H\u000f2\u0006\u0010\u0013\u001a\u0002H\u000f2\u0006\u0010\u0015\u001a\u0002H\u000f¢\u0006\u0002\u0010\u0016\u001a+\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\r\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\t\"\u0002H\u000f¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001a\"\u0004\b\u0000\u0010\u000fH\u0086\b\u001a\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001a\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0011\u001a\u0002H\u000f¢\u0006\u0002\u0010\u001b\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001a\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0011\u001a\u0002H\u000f2\u0006\u0010\u0013\u001a\u0002H\u000f¢\u0006\u0002\u0010\u001c\u001a/\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001a\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0011\u001a\u0002H\u000f2\u0006\u0010\u0013\u001a\u0002H\u000f2\u0006\u0010\u0015\u001a\u0002H\u000f¢\u0006\u0002\u0010\u001d\u001a.\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001a\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\t\"\u0002H\u000fH\u0086\b¢\u0006\u0002\u0010\u001e\"\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b\"\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"checkIndex", "", "", "index", "", "checkSubIndex", "fromIndex", "toIndex", "EmptyArray", "", "", "[Ljava/lang/Object;", "EmptyObjectList", "Landroidx/collection/ObjectList;", "emptyObjectList", "E", "objectListOf", "element1", "(Ljava/lang/Object;)Landroidx/collection/ObjectList;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "elements", "([Ljava/lang/Object;)Landroidx/collection/ObjectList;", "mutableObjectListOf", "Landroidx/collection/MutableObjectList;", "(Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "([Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObjectListKt {
    private static final Object[] EmptyArray = null;
    private static final ObjectList<Object> EmptyObjectList = null;

    static {
        EmptyArray = new Object[0];
        EmptyObjectList = new MutableObjectList(0);
    }

    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<E> r0 = (ObjectList<E>) EmptyObjectList;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return r0;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        int r3 = 0;
        return new MutableObjectList(r3, 1, null);
    }

    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<E> r0 = (ObjectList<E>) EmptyObjectList;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return r0;
    }

    public static final /* synthetic */ Object[] access$getEmptyArray$p() {
        return EmptyArray;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableObjectList<E> r0 = new MutableObjectList(r2.length);
        r0.plusAssign(r2);
        return r0;
    }

    public static final <E> ObjectList<E> objectListOf(E... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableObjectList r0 = new MutableObjectList(r2.length);
        r0.plusAssign(r2);
        return r0;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E r2) {
        MutableObjectList<E> r0 = new MutableObjectList(1);
        r0.add(r2);
        return r0;
    }

    public static final <E> ObjectList<E> objectListOf(E r0) {
        return mutableObjectListOf(r0);
    }

    public static final /* synthetic */ void access$checkIndex(List r0, int r1) {
        checkIndex(r0, r1);
    }

    private static final void checkIndex(List<?> r2, int r3) {
        int r4 = r2.size();
        if (r3 < 0) goto L5;
        if (r3 >= r4) goto L5;
        return;
    L5:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index " + r3 + " is out of bounds. The list has " + r4 + " elements.");
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E r2, E r3) {
        MutableObjectList<E> r0 = new MutableObjectList(2);
        r0.add(r2);
        r0.add(r3);
        return r0;
    }

    public static final <E> ObjectList<E> objectListOf(E r0, E r1) {
        return mutableObjectListOf(r0, r1);
    }

    public static final /* synthetic */ void access$checkSubIndex(List r0, int r1, int r2) {
        checkSubIndex(r0, r1, r2);
    }

    private static final void checkSubIndex(List<?> r2, int r3, int r4) {
        int r5 = r2.size();
        if (r3 <= r4) goto L5;
        RuntimeHelpersKt.throwIllegalArgumentException("Indices are out of order. fromIndex (" + r3 + ") is greater than toIndex (" + r4 + ").");
    L5:
        if (r3 >= 0) goto L7;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("fromIndex (" + r3 + ") is less than 0.");
    L7:
        if (r4 <= r5) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("toIndex (" + r4 + ") is more than than the list size (" + r5 + ')');
        return;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E r2, E r3, E r4) {
        MutableObjectList<E> r0 = new MutableObjectList(3);
        r0.add(r2);
        r0.add(r3);
        r0.add(r4);
        return r0;
    }

    public static final <E> ObjectList<E> objectListOf(E r0, E r1, E r2) {
        return mutableObjectListOf(r0, r1, r2);
    }
}
