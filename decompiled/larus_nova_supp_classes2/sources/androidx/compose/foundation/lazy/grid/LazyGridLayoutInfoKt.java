package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"visibleLinesAverageMainAxisSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridLayoutInfoKt {
    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo r4) {
        if (r4.getOrientation() != Orientation.Vertical) goto L5;
        long r0 = r4.mo1120getViewportSizeYbymL2g() & 4294967295L;
    L7:
        return (int) r0;
    L5:
        r0 = r4.mo1120getViewportSizeYbymL2g() >> 32;
        goto L7
    }

    public static final int visibleLinesAverageMainAxisSize(LazyGridLayoutInfo r12) {
        if (r12.getOrientation() != Orientation.Vertical) goto L5;
        boolean r0 = true;
    L6:
        List<LazyGridItemInfo> r1 = r12.getVisibleItemsInfo();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r3 >= r1.size()) goto L23;
        int r6 = visibleLinesAverageMainAxisSize$lineOf(r0, r12, r3);
        if (r6 == (-1)) goto L11;
        int r7 = 0;
    L14:
        if (r3 >= r1.size()) goto L21;
        if (visibleLinesAverageMainAxisSize$lineOf(r0, r12, r3) != r6) goto L21;
        if (r0 == false) goto L19;
        long r8 = ((LazyGridItemInfo) ListProtector.get(r1, r3)).mo1118getSizeYbymL2g() & 4294967295L;
    L20:
        r7 = Math.max(r7, (int) r8);
        r3 = r3 + 1;
        goto L14
    L19:
        r8 = ((LazyGridItemInfo) ListProtector.get(r1, r3)).mo1118getSizeYbymL2g() >> 32;
    L21:
        r4 = r4 + r7;
        r5 = r5 + 1;
        goto L8
    L11:
        r3 = r3 + 1;
        goto L8
    L23:
        return (r4 / r5) + r12.getMainAxisItemSpacing();
    L5:
        r0 = false;
        goto L6
    }

    private static final int visibleLinesAverageMainAxisSize$lineOf(boolean r0, LazyGridLayoutInfo r1, int r2) {
        if (r0 == false) goto L5;
        return ((LazyGridItemInfo) ListProtector.get(r1.getVisibleItemsInfo(), r2)).getRow();
    L5:
        return ((LazyGridItemInfo) ListProtector.get(r1.getVisibleItemsInfo(), r2)).getColumn();
    }
}
