package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"asReversed", "", ExifInterface.GPS_DIRECTION_TRUE, "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reverseIteratorIndex", "reverseIteratorIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public CollectionsKt__ReversedViewsKt() {
    }

    public static <T> List<T> asReversed(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new ReversedListReadOnly(r100);
    }

    public static <T> List<T> asReversedMutable(List<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new ReversedList(r100);
    }

    public static final /* synthetic */ int access$reverseElementIndex(List r100, int r101) {
        return reverseElementIndex$CollectionsKt__ReversedViewsKt(r100, r101);
    }

    public static final /* synthetic */ int access$reverseIteratorIndex(List r100, int r101) {
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt(r100, r101);
    }

    public static final /* synthetic */ int access$reversePositionIndex(List r100, int r101) {
        return reversePositionIndex$CollectionsKt__ReversedViewsKt(r100, r101);
    }

    private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> r100, int r101) {
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        return CollectionsKt.getLastIndex(r100) - r101;
    L12:
        throw new IndexOutOfBoundsException("Element index " + r101 + " must be in range [" + new IntRange(0, CollectionsKt.getLastIndex(r100)) + "].");
    L5:
        if (r101 > CollectionsKt.getLastIndex(r100)) goto L7;
        r102 = true;
        goto L8
    }

    private static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List<?> r100, int r101) {
        return CollectionsKt.getLastIndex(r100) - r101;
    }

    private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> r100, int r101) {
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        return r100.size() - r101;
    L12:
        throw new IndexOutOfBoundsException("Position index " + r101 + " must be in range [" + new IntRange(0, r100.size()) + "].");
    L5:
        if (r101 > r100.size()) goto L7;
        r102 = true;
        goto L8
    }
}
