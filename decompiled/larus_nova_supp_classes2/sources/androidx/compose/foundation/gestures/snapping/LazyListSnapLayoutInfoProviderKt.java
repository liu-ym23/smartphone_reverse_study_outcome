package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001a\u0019\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0010\u0013\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "calculateFinalSnappingItem", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "Landroidx/compose/ui/unit/Density;", "velocity", "", "(Landroidx/compose/ui/unit/Density;F)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListSnapLayoutInfoProviderKt {
    public static final int getSingleAxisViewportSize(LazyListLayoutInfo r4) {
        if (r4.getOrientation() != Orientation.Vertical) goto L5;
        long r0 = r4.mo1084getViewportSizeYbymL2g() & 4294967295L;
    L7:
        return (int) r0;
    L5:
        r0 = r4.mo1084getViewportSizeYbymL2g() >> 32;
        goto L7
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final LazyListState r1, final SnapPosition r2) {
        return new AnonymousClass1(r1, r2);
    }

    public static final int calculateFinalSnappingItem(Density r2, float r3) {
        if (Math.abs(r3) >= r2.toPx-0680j_4(SnapFlingBehaviorKt.getMinFlingVelocityDp())) goto L6;
        return FinalSnappingItem.Companion.m738getClosestItembbeMdSM();
    L6:
        if (r3 <= MenuKt.ClosedAlphaTarget) goto L9;
        return FinalSnappingItem.Companion.m739getNextItembbeMdSM();
    L9:
        return FinalSnappingItem.Companion.m740getPreviousItembbeMdSM();
    }

    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyListState r0, SnapPosition r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = SnapPosition.Center.INSTANCE;
    L6:
        return SnapLayoutInfoProvider(r0, r1);
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyListState r2, SnapPosition r3, Composer r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = SnapPosition.Center.INSTANCE;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(-338621290, r5, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:115)");
    L9:
        if (((r5 & 14) ^ 6) <= 4) goto L13;
        if (r4.changed(r2) == false) goto L13;
    L14:
        boolean r7 = true;
    L16:
        Object r8 = r4.rememberedValue();
        if (r7 == false) goto L19;
    L20:
        r8 = SnapLayoutInfoProvider(r2, r3);
        r4.updateRememberedValue(r8);
    L21:
        TargetedFlingBehavior r9 = SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider) r8, r4, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r9;
    L19:
        if (r8 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r5 & 6) == 4) goto L14;
        r7 = false;
        goto L16
    }
}
