package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;

    public NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(DrawerState r1, MutableState<Boolean> r2) {
        this.$drawerState = r1;
        this.$anchorsInitialized$delegate = r2;
    }

    public static /* synthetic */ Unit a(float r0, DraggableAnchorsConfig r1) {
        return measure_3p2s80s$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(DrawerState r0, Placeable r1, Placeable r2, MutableState r3, Placeable.PlacementScope r4) {
        return measure_3p2s80s$lambda$1(r0, r1, r2, r3, r4);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    private static final Unit measure_3p2s80s$lambda$1$lambda$0(float r1, DraggableAnchorsConfig r2) {
        r2.at(DrawerValue.Closed, r1);
        r2.at(DrawerValue.Open, MenuKt.ClosedAlphaTarget);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2911measure3p2s80s(MeasureScope r9, List<? extends Measurable> r10, long r11) {
        final Placeable r0 = ((Measurable) ListProtector.get(r10, 0)).measure-BRTryo0(r11);
        final Placeable r12 = ((Measurable) ListProtector.get(r10, 1)).measure-BRTryo0(r11);
        int r2 = r12.getWidth();
        int r3 = r12.getHeight();
        final DrawerState r13 = this.$drawerState;
        final MutableState<Boolean> r14 = this.$anchorsInitialized$delegate;
        return MeasureScope.-CC.layout$default(r9, r2, r3, null, new ih(r13, r0, r12, r14), 4, null);
    }

    private static final Unit measure_3p2s80s$lambda$1(DrawerState r8, Placeable r9, Placeable r10, MutableState r11, Placeable.PlacementScope r12) {
        float r0 = r8.getAnchoredDraggableState$material3().getAnchors().positionOf(DrawerValue.Closed);
        final float r1 = -r9.getWidth();
        if (NavigationDrawerKt.access$DismissibleNavigationDrawer$lambda$27(r11) == false) goto L10;
        if (r0 != r1) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
    L13:
        Placeable.PlacementScope.placeRelative$default(r12, r10, r9.getWidth() + MathKt.roundToInt(r8.requireOffset$material3()), 0, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r12, r9, MathKt.roundToInt(r8.requireOffset$material3()), 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L7:
        r2 = false;
    L10:
        if (NavigationDrawerKt.access$DismissibleNavigationDrawer$lambda$27(r11) == true) goto L12;
        NavigationDrawerKt.access$DismissibleNavigationDrawer$lambda$28(r11, true);
    L12:
        AnchoredDraggableState.updateAnchors$default(r8.getAnchoredDraggableState$material3(), AnchoredDraggableKt.DraggableAnchors(new hh(r1)), null, 2, null);
        goto L13
    }
}
