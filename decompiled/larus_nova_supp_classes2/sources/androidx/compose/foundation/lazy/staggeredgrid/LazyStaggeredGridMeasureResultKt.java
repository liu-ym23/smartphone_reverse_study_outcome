package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0018\u0010\f\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"findVisibleItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "itemIndex", "", "EmptyArray", "", "EmptyLazyStaggeredGridLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "getEmptyLazyStaggeredGridLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "visibleItemsAverageSize", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasureResultKt {
    private static final int[] EmptyArray = null;
    private static final LazyStaggeredGridMeasureResult EmptyLazyStaggeredGridLayoutInfo = null;

    static {
        int[] r0 = new int[0];
        EmptyArray = r0;
        MeasureResult r1 = new LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1();
        List r14 = CollectionsKt.emptyList();
        long r15 = IntSize.Companion.getZero-YbymL2g();
        EmptyLazyStaggeredGridLayoutInfo = new LazyStaggeredGridMeasureResult(r0, r0, MenuKt.ClosedAlphaTarget, r1, MenuKt.ClosedAlphaTarget, false, false, false, new LazyStaggeredGridSlots(r0, r0), new LazyStaggeredGridSpanProvider(new MutableIntervalList()), DensityKt.Density$default(1.0f, MenuKt.ClosedAlphaTarget, 2, null), 0, r14, r15, 0, 0, 0, 0, 0, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), null);
    }

    public static /* synthetic */ int a(int r0, LazyStaggeredGridItemInfo r1) {
        return findVisibleItem$lambda$0(r0, r1);
    }

    public static final LazyStaggeredGridMeasureResult getEmptyLazyStaggeredGridLayoutInfo() {
        return EmptyLazyStaggeredGridLayoutInfo;
    }

    public static final int getSingleAxisViewportSize(LazyStaggeredGridLayoutInfo r4) {
        if (r4.getOrientation() != Orientation.Vertical) goto L5;
        long r0 = r4.mo1218getViewportSizeYbymL2g() & 4294967295L;
    L7:
        return (int) r0;
    L5:
        r0 = r4.mo1218getViewportSizeYbymL2g() >> 32;
        goto L7
    }

    public static final int visibleItemsAverageSize(LazyStaggeredGridLayoutInfo r8) {
        List<LazyStaggeredGridItemInfo> r0 = r8.getVisibleItemsInfo();
        int r2 = 0;
        if (r0.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r1 = r0.size();
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L13;
        LazyStaggeredGridItemInfo r4 = (LazyStaggeredGridItemInfo) ListProtector.get(r0, r2);
        if (r8.getOrientation() != Orientation.Vertical) goto L10;
        long r5 = r4.mo1214getSizeYbymL2g() & 4294967295L;
    L11:
        r3 = r3 + ((int) r5);
        r2 = r2 + 1;
        goto L6
    L10:
        r5 = r4.mo1214getSizeYbymL2g() >> 32;
        goto L11
    L13:
        return (r3 / r0.size()) + r8.getMainAxisItemSpacing();
    }

    public static final LazyStaggeredGridItemInfo findVisibleItem(LazyStaggeredGridLayoutInfo r10, final int r11) {
        if (r10.getVisibleItemsInfo().isEmpty() == false) goto L5;
        return null;
    L5:
        int r0 = ((LazyStaggeredGridItemInfo) CollectionsKt.first(r10.getVisibleItemsInfo())).getIndex();
        boolean r3 = false;
        if (r11 > ((LazyStaggeredGridItemInfo) CollectionsKt.last(r10.getVisibleItemsInfo())).getIndex()) goto L9;
        if (r0 > r11) goto L9;
        r3 = true;
    L9:
        if (r3 == true) goto L11;
        return null;
    L11:
        int r12 = CollectionsKt.binarySearch$default(r10.getVisibleItemsInfo(), 0, 0, new q(r11), 3, null);
        return (LazyStaggeredGridItemInfo) CollectionsKt.getOrNull(r10.getVisibleItemsInfo(), r12);
    }

    private static final int findVisibleItem$lambda$0(int r0, LazyStaggeredGridItemInfo r1) {
        return r1.getIndex() - r0;
    }
}
