package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000b\u001a\u00020\fJ*\u0010\u0016\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/ScrollableTabData;", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "selectedTab", "", "Ljava/lang/Integer;", "onLaidOut", "", "density", "Landroidx/compose/ui/unit/Density;", "edgeOffset", "tabPositions", "", "Landroidx/compose/material3/TabPosition;", "calculateTabOffset", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollableTabData {
    private final FiniteAnimationSpec<Float> animationSpec;
    private final CoroutineScope coroutineScope;
    private final ScrollState scrollState;
    private Integer selectedTab;

    public static final /* synthetic */ FiniteAnimationSpec access$getAnimationSpec$p(ScrollableTabData r0) {
        return r0.animationSpec;
    }

    public static final /* synthetic */ ScrollState access$getScrollState$p(ScrollableTabData r0) {
        return r0.scrollState;
    }

    public ScrollableTabData(ScrollState r1, CoroutineScope r2, FiniteAnimationSpec<Float> r3) {
        this.scrollState = r1;
        this.coroutineScope = r2;
        this.animationSpec = r3;
    }

    private final int calculateTabOffset(TabPosition r3, Density r4, int r5, List<TabPosition> r6) {
        int r7 = r4.roundToPx-0680j_4(((TabPosition) CollectionsKt.last(r6)).m3254getRightD9Ej5fM()) + r5;
        int r8 = r7 - this.scrollState.getMaxValue();
        return RangesKt.coerceIn(r4.roundToPx-0680j_4(r3.m3253getLeftD9Ej5fM()) - ((r8 / 2) - (r4.roundToPx-0680j_4(r3.m3255getWidthD9Ej5fM()) / 2)), 0, RangesKt.coerceAtLeast(r7 - r8, 0));
    }

    public final void onLaidOut(Density r7, int r8, List<TabPosition> r9, int r10) {
        Integer r0 = this.selectedTab;
        if (r0 != null) goto L6;
    L7:
        this.selectedTab = Integer.valueOf(r10);
        TabPosition r11 = (TabPosition) CollectionsKt.getOrNull(r9, r10);
        if (r11 == null) goto L14;
        int r12 = calculateTabOffset(r11, r7, r8, r9);
        if (this.scrollState.getValue() == r12) goto L15;
        BuildersKt.launch$default(this.coroutineScope, null, null, new ScrollableTabData$onLaidOut$1$1(this, r12, null), 3, null);
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (r0.intValue() != r10) goto L7;
    }
}
