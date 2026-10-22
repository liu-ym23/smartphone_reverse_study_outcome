package androidx.compose.foundation.lazy.grid;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.unit.Density;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u00112\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00105\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\b\u00106\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010-\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0013R\u0015\u0010)\u001a\u00020\u0011*\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridCacheWindowScope;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "<init>", "()V", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "setLayoutInfo", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)V", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "getPrefetchScope", "()Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "setPrefetchScope", "(Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;)V", "totalItemsCount", "", "getTotalItemsCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "mainAxisExtraSpaceStart", "getMainAxisExtraSpaceStart", "mainAxisExtraSpaceEnd", "getMainAxisExtraSpaceEnd", "firstVisibleLineIndex", "getFirstVisibleLineIndex", "lastVisibleLineIndex", "getLastVisibleLineIndex", "mainAxisViewportSize", "getMainAxisViewportSize", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "schedulePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "onItemPrefetched", "Lkotlin/Function2;", "", "visibleLineCount", "getVisibleLineCount", "getVisibleItemSize", "indexInVisibleLines", "getVisibleItemLine", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "getLineIndex", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;)I", "getLastIndexInLine", "getLastLineIndex", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyGridCacheWindowScope implements CacheWindowScope {
    public LazyGridLayoutInfo layoutInfo;
    public LazyGridPrefetchScope prefetchScope;

    public LazyGridCacheWindowScope() {
    }

    public static /* synthetic */ Unit a(Function2 r0, int r1, LazyGridPrefetchResultScope r2) {
        return schedulePrefetch$lambda$1(r0, r1, r2);
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        LazyGridLayoutInfo r0 = this.layoutInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        return null;
    }

    public final LazyGridPrefetchScope getPrefetchScope() {
        LazyGridPrefetchScope r0 = this.prefetchScope;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("prefetchScope");
        return null;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Density getDensity() {
        LazyGridLayoutInfo r0 = getLayoutInfo();
        if ((r0 instanceof LazyGridMeasureResult) == false) goto L5;
        LazyGridMeasureResult r1 = (LazyGridMeasureResult) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getDensity();
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getFirstVisibleLineIndex() {
        return getLineIndex((LazyGridItemInfo) CollectionsKt.first(getLayoutInfo().getVisibleItemsInfo()));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public boolean getHasVisibleItems() {
        return !getLayoutInfo().getVisibleItemsInfo().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastLineIndex() {
        LazyGridLayoutInfo r0 = getLayoutInfo();
        if ((r0 instanceof LazyGridMeasureResult) == false) goto L5;
        LazyGridMeasureResult r1 = (LazyGridMeasureResult) r0;
    L7:
        if (r1 != null) goto L10;
        return -1;
    L10:
        if (getTotalItemsCount() != 0) goto L13;
        return -1;
    L13:
        return ((Number) r1.getLineIndexProvider().invoke(Integer.valueOf(getTotalItemsCount() - 1))).intValue();
    L5:
        r1 = null;
        goto L7
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastVisibleLineIndex() {
        return getLineIndex((LazyGridItemInfo) CollectionsKt.last(getLayoutInfo().getVisibleItemsInfo()));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisExtraSpaceEnd() {
        LazyGridItemInfo r0 = (LazyGridItemInfo) CollectionsKt.last(getLayoutInfo().getVisibleItemsInfo());
        return Math.abs(((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r0, getLayoutInfo().getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(r0, getLayoutInfo().getOrientation())) + getLayoutInfo().getMainAxisItemSpacing()) - getLayoutInfo().getViewportEndOffset());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisExtraSpaceStart() {
        return Math.abs(RangesKt.coerceAtMost(LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first(getLayoutInfo().getVisibleItemsInfo()), getLayoutInfo().getOrientation()) + getLayoutInfo().getBeforeContentPadding(), 0));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisViewportSize() {
        return LazyGridLayoutInfoKt.getSingleAxisViewportSize(getLayoutInfo());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getTotalItemsCount() {
        return getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleLineCount() {
        return (getLastVisibleLineIndex() - getFirstVisibleLineIndex()) + 1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastIndexInLine(int r3) {
        LazyGridLayoutInfo r0 = getLayoutInfo();
        if ((r0 instanceof LazyGridMeasureResult) == false) goto L5;
        LazyGridMeasureResult r1 = (LazyGridMeasureResult) r0;
    L7:
        if (r1 != null) goto L9;
        return -1;
    L9:
        List r4 = (List) r1.getPrefetchInfoRetriever().invoke(Integer.valueOf(r3));
        if (r4.isEmpty() == false) goto L13;
        return -1;
    L13:
        return (((Number) ((Pair) CollectionsKt.first(r4)).getFirst()).intValue() + r4.size()) - 1;
    L5:
        r1 = null;
        goto L7
    }

    public final int getLineIndex(LazyGridItemInfo r2) {
        return LazyGridItemInfoKt.lineIndex(r2, getLayoutInfo().getOrientation());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemLine(int r2) {
        return getFirstVisibleLineIndex() + r2;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemSize(int r8) {
        int r9 = r8 + getFirstVisibleLineIndex();
        List<LazyGridItemInfo> r0 = getLayoutInfo().getVisibleItemsInfo();
        ArrayList r1 = new ArrayList(r0.size());
        int r2 = r0.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        Object r5 = ListProtector.get(r0, r4);
        if (getLineIndex((LazyGridItemInfo) r5) != r9) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        r1.add(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
        goto L8
    L11:
        int r10 = r1.size();
        int r7 = 0;
    L12:
        if (r3 >= r10) goto L14;
        r7 = Math.max(LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis((LazyGridItemInfo) ListProtector.get(r1, r3), getLayoutInfo().getOrientation()), r7);
        r3 = r3 + 1;
        goto L12
    L14:
        return r7;
    }

    public final void setLayoutInfo(LazyGridLayoutInfo r1) {
        this.layoutInfo = r1;
    }

    public final void setPrefetchScope(LazyGridPrefetchScope r1) {
        this.prefetchScope = r1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> schedulePrefetch(final int r3, final Function2<? super Integer, ? super Integer, Unit> r4) {
        return getPrefetchScope().scheduleLinePrefetch(r3, new a(r4, r3));
    }

    private static final Unit schedulePrefetch$lambda$1(Function2 r6, int r7, LazyGridPrefetchResultScope r8) {
        int r0 = r8.getLineItemCount();
        int r3 = 0;
        int r4 = RtlSpacingHelper.UNDEFINED;
    L3:
        if (r3 >= r0) goto L5;
        r4 = ComparisonsKt.maxOf(r8.getMainAxisSize(r3), new int[0]);
        r3 = r3 + 1;
        goto L3
    L5:
        if (r4 == Integer.MIN_VALUE) goto L8;
        r6.invoke(Integer.valueOf(r7), Integer.valueOf(r4));
    L8:
        return Unit.INSTANCE;
    }
}
