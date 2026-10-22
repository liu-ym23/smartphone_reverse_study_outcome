package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"binarySearch", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "itemIndex", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntervalListKt {
    public static final /* synthetic */ int access$binarySearch(MutableVector r0, int r1) {
        return binarySearch(r0, r1);
    }

    private static final <T> int binarySearch(MutableVector<IntervalList.Interval<T>> r4, int r5) {
        int r0 = r4.getSize() - 1;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        int r2 = ((r0 - r1) / 2) + r1;
        int r3 = ((IntervalList.Interval) r4.content[r2]).getStartIndex();
        if (r3 == r5) goto L6;
        if (r3 < r5) goto L8;
        r0 = r2 - 1;
        goto L3
    L8:
        r1 = r2 + 1;
        if (r5 >= ((IntervalList.Interval) r4.content[r1]).getStartIndex()) goto L3;
        return r2;
    L6:
        return r2;
    L12:
        return r1;
    }
}
