package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\f\u0010\f\u001a\u00020\b*\u00020\u0003H\u0002\u001a\u0017\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b\u001a8\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0000¨\u0006\u0018"}, d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "calculateFinalSnappingBound", "Lkotlin/Function3;", "", "isScrollingForward", "", "velocity", "dragGestureDelta", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerSnapLayoutInfoProviderKt {
    private static final void debugLog(Function0<String> r0) {
    }

    private static final float dragGestureDelta(PagerState r4) {
        if (r4.getLayoutInfo().getOrientation() != Orientation.Horizontal) goto L6;
        return Float.intBitsToFloat((int) (r4.m1268getUpDownDifferenceF1C5BW0$foundation_release() >> 32));
    L6:
        return Float.intBitsToFloat((int) (r4.m1268getUpDownDifferenceF1C5BW0$foundation_release() & 4294967295L));
    }

    public static final /* synthetic */ boolean access$isScrollingForward(PagerState r0, float r1) {
        return isScrollingForward(r0, r1);
    }

    private static final boolean isScrollingForward(PagerState r3, float r4) {
        boolean r0 = r3.getLayoutInfo().getReverseLayout();
        if (r3.isNotGestureAction$foundation_release() == false) goto L5;
        float r5 = -r4;
    L7:
        if (r5 <= MenuKt.ClosedAlphaTarget) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        if (r0 == false) goto L12;
        return true;
    L12:
        if (r6 == true) goto L15;
        if (r0 == true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = dragGestureDelta(r3);
        goto L7
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState r1, final PagerSnapDistance r2, final Function3<? super Float, ? super Float, ? super Float, Float> r3) {
        return new AnonymousClass1(r1, r3, r2);
    }

    public static final float calculateFinalSnappingBound(PagerState r5, LayoutDirection r6, float r7, float r8, float r9, float r10) {
        boolean r0 = isScrollingForward(r5, r8);
        if (r5.getLayoutInfo().getOrientation() != Orientation.Vertical) goto L6;
    L11:
        int r11 = r5.getLayoutInfo().getPageSize();
        if (r11 != 0) goto L14;
        float r2 = MenuKt.ClosedAlphaTarget;
    L15:
        float r12 = r2 - ((int) r2);
        int r13 = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(r5.getDensity$foundation_release(), r8);
        FinalSnappingItem.Companion r3 = FinalSnappingItem.Companion;
        if (FinalSnappingItem.m734equalsimpl0(r13, r3.m738getClosestItembbeMdSM()) == false) goto L29;
        if (Math.abs(r12) <= r7) goto L22;
        if (r0 == true) goto L37;
        return r9;
    L37:
        return r10;
    L22:
        if (Math.abs(r2) < Math.abs(r5.getPositionThresholdFraction$foundation_release())) goto L26;
        if (r0 == false) goto L37;
        return r9;
    L26:
        if (Math.abs(r9) >= Math.abs(r10)) goto L37;
        return r9;
    L29:
        if (FinalSnappingItem.m734equalsimpl0(r13, r3.m739getNextItembbeMdSM()) == true) goto L37;
        if (FinalSnappingItem.m734equalsimpl0(r13, r3.m740getPreviousItembbeMdSM()) == true) goto L40;
        return MenuKt.ClosedAlphaTarget;
    L40:
        return r9;
    L14:
        r2 = dragGestureDelta(r5) / r11;
        goto L15
    L6:
        if (r6 == LayoutDirection.Ltr) goto L11;
        if (r0 == true) goto L10;
        r0 = true;
        goto L11
    L10:
        r0 = false;
        goto L11
    }
}
