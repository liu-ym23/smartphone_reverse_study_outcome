package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt$ModalNavigationDrawer$2$6$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ MutableFloatState $minValue$delegate;

    public NavigationDrawerKt$ModalNavigationDrawer$2$6$1(DrawerState r1, MutableState<Boolean> r2, MutableFloatState r3, float r4) {
        this.$drawerState = r1;
        this.$anchorsInitialized$delegate = r2;
        this.$minValue$delegate = r3;
        this.$maxValue = r4;
    }

    public static /* synthetic */ Unit a(float r0, MutableFloatState r1, DraggableAnchorsConfig r2) {
        return measure_3p2s80s$lambda$5$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(DrawerState r0, int r1, List r2, MutableState r3, MutableFloatState r4, float r5, Placeable.PlacementScope r6) {
        return measure_3p2s80s$lambda$5(r0, r1, r2, r3, r4, r5, r6);
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

    private static final Unit measure_3p2s80s$lambda$5$lambda$3(float r1, MutableFloatState r2, DraggableAnchorsConfig r3) {
        r3.at(DrawerValue.Closed, NavigationDrawerKt.access$ModalNavigationDrawer_FHprtrg$lambda$8(r2));
        r3.at(DrawerValue.Open, r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2912measure3p2s80s(MeasureScope r12, List<? extends Measurable> r13, long r14) {
        long r15 = Constraints.copy-Zbe2FdA$default(r14, 0, 0, 0, 0, 10, null);
        final ArrayList r3 = new ArrayList(r13.size());
        int r0 = r13.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3.add(((Measurable) ListProtector.get(r13, r2)).measure-BRTryo0(r15));
        r2 = r2 + 1;
        goto L3
    L5:
        Integer r16 = null;
        int r17 = 1;
        if (r3.isEmpty() == false) goto L8;
        Integer r18 = null;
    L16:
        Integer r19 = r18;
        if (r19 == null) goto L19;
        int r110 = r19.intValue();
    L21:
        if (r3.isEmpty() == true) goto L30;
        r16 = Integer.valueOf(((Placeable) ListProtector.get(r3, 0)).getHeight());
        int r1 = CollectionsKt.getLastIndex(r3);
        if (1 > r1) goto L30;
    L25:
        Integer r4 = Integer.valueOf(((Placeable) ListProtector.get(r3, r17)).getHeight());
        if (r4.compareTo(r16) <= 0) goto L28;
        r16 = r4;
    L28:
        if (r17 == r1) goto L30;
        r17 = r17 + 1;
    L30:
        Integer r111 = r16;
        if (r111 == null) goto L33;
        int r112 = r111.intValue();
    L34:
        final DrawerState r5 = this.$drawerState;
        final MutableState<Boolean> r6 = this.$anchorsInitialized$delegate;
        final MutableFloatState r7 = this.$minValue$delegate;
        final float r8 = this.$maxValue;
        final int r9 = r110;
        return MeasureScope.-CC.layout$default(r12, r110, r112, null, new mh(r5, r9, r3, r6, r7, r8), 4, null);
    L33:
        r112 = 0;
        goto L34
    L19:
        r110 = 0;
        goto L21
    L8:
        r18 = Integer.valueOf(((Placeable) ListProtector.get(r3, 0)).getWidth());
        int r10 = CollectionsKt.getLastIndex(r3);
        if (1 > r10) goto L16;
        int r11 = 1;
    L11:
        Integer r20 = Integer.valueOf(((Placeable) ListProtector.get(r3, r11)).getWidth());
        if (r20.compareTo(r18) <= 0) goto L14;
        r18 = r20;
    L14:
        if (r11 == r10) goto L16;
        r11 = r11 + 1;
        goto L11
    }

    private static final Unit measure_3p2s80s$lambda$5(DrawerState r13, int r14, List r15, MutableState r16, final MutableFloatState r17, final float r18, Placeable.PlacementScope r19) {
        float r2 = r13.getAnchoredDraggableState$material3().getAnchors().positionOf(DrawerValue.Closed);
        float r3 = -r14;
        int r5 = 0;
        if (NavigationDrawerKt.access$ModalNavigationDrawer_FHprtrg$lambda$5(r16) == false) goto L10;
        if (r2 != r3) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
    L13:
        int r1 = r15.size();
    L14:
        if (r5 >= r1) goto L17;
        Placeable.PlacementScope.placeRelative$default(r19, (Placeable) ListProtector.get(r15, r5), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r5 = r5 + 1;
        goto L14
    L17:
        return Unit.INSTANCE;
    L7:
        r4 = false;
    L10:
        if (NavigationDrawerKt.access$ModalNavigationDrawer_FHprtrg$lambda$5(r16) == true) goto L12;
        NavigationDrawerKt.access$ModalNavigationDrawer_FHprtrg$lambda$6(r16, true);
    L12:
        NavigationDrawerKt.access$ModalNavigationDrawer_FHprtrg$lambda$9(r17, r3);
        AnchoredDraggableState.updateAnchors$default(r13.getAnchoredDraggableState$material3(), AnchoredDraggableKt.DraggableAnchors(new lh(r18, r17)), null, 2, null);
        goto L13
    }
}
