package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001a\u0014\u0010\u000e\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "sizeOnMainAxis", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "offsetOnMainAxis", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridSnapLayoutInfoProviderKt {
    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo r4) {
        if (r4.getOrientation() != Orientation.Vertical) goto L5;
        long r0 = r4.mo1120getViewportSizeYbymL2g() & 4294967295L;
    L7:
        return (int) r0;
    L5:
        r0 = r4.mo1120getViewportSizeYbymL2g() >> 32;
        goto L7
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final LazyGridState r1, final SnapPosition r2) {
        return new AnonymousClass1(r1, r2);
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo r1, Orientation r2) {
        if (r2 != Orientation.Vertical) goto L6;
        return IntOffset.getY-impl(r1.mo1117getOffsetnOccac());
    L6:
        return IntOffset.getX-impl(r1.mo1117getOffsetnOccac());
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo r2, Orientation r3) {
        if (r3 != Orientation.Vertical) goto L5;
        long r4 = r2.mo1118getSizeYbymL2g() & 4294967295L;
    L7:
        return (int) r4;
    L5:
        r4 = r2.mo1118getSizeYbymL2g() >> 32;
        goto L7
    }

    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState r0, SnapPosition r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = SnapPosition.Center.INSTANCE;
    L6:
        return SnapLayoutInfoProvider(r0, r1);
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyGridState r2, SnapPosition r3, Composer r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = SnapPosition.Center.INSTANCE;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(-234434234, r5, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyGridSnapLayoutInfoProvider.kt:114)");
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
