package androidx.compose.foundation.pager;

import androidx.collection.SieveCacheKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/pager/PagerSnapDistanceMaxPages;", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pagesLimit", "", "<init>", "(I)V", "calculateTargetPage", "startPage", "suggestedTargetPage", "velocity", "", "pageSize", "pageSpacing", "equals", "", "other", "", "hashCode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {
    public static final int $stable = 0;
    private final int pagesLimit;

    public int hashCode() {
        return this.pagesLimit;
    }

    public PagerSnapDistanceMaxPages(int r1) {
        this.pagesLimit = r1;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof PagerSnapDistanceMaxPages) == true) goto L5;
        return false;
    L5:
        if (this.pagesLimit != ((PagerSnapDistanceMaxPages) r3).pagesLimit) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int calculateTargetPage(int r5, int r6, float r7, int r8, int r9) {
        long r10 = r5;
        return RangesKt.coerceIn(r6, (int) RangesKt.coerceAtLeast(r10 - ((long) this.pagesLimit), 0), (int) RangesKt.coerceAtMost(r10 + ((long) this.pagesLimit), SieveCacheKt.NodeLinkMask));
    }
}
