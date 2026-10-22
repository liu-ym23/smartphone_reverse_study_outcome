package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J\u001c\u0010(\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u001c\u0010*\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J\u001c\u0010+\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "<init>", "()V", "insets", "Landroidx/compose/foundation/layout/ValueInsets;", "getInsets", "()Landroidx/compose/foundation/layout/ValueInsets;", "oldPosition", "Landroidx/compose/ui/unit/IntOffset;", "getOldPosition-nOcc-ac", "()J", "setOldPosition--gyyYBs", "(J)V", "J", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RecalculateWindowInsetsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutModifierNode, GlobalPositionAwareModifierNode {
    private final ValueInsets insets;
    private long oldPosition;
    private final ModifierLocalMap providedValues;

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(RecalculateWindowInsetsModifierNode r0, Measurable r1, int r2, int r3, Placeable.PlacementScope r4) {
        return measure_3p2s80s$lambda$2(r0, r1, r2, r3, r4);
    }

    public final /* synthetic */ Object getCurrent(ModifierLocal r1) {
        return ModifierLocalModifierNode.-CC.$default$getCurrent(this, r1);
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final /* synthetic */ void provide(ModifierLocal r1, Object r2) {
        ModifierLocalModifierNode.-CC.$default$provide(this, r1, r2);
    }

    public RecalculateWindowInsetsModifierNode() {
        ValueInsets r0 = new ValueInsets(new InsetsValues(0, 0, 0, 0), "reset");
        this.insets = r0;
        this.oldPosition = IntOffset.Companion.getZero-nOcc-ac();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), r0));
    }

    public final ValueInsets getInsets() {
        return this.insets;
    }

    /* JADX INFO: renamed from: getOldPosition-nOcc-ac, reason: not valid java name */
    public final long m989getOldPositionnOccac() {
        return this.oldPosition;
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    public void onGloballyPositioned(LayoutCoordinates r5) {
        long r0 = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(r5));
        boolean r6 = !IntOffset.equals-impl0(this.oldPosition, r0);
        this.oldPosition = r0;
        if (r6 == false) goto L6;
        LayoutModifierNodeKt.invalidatePlacement(this);
        return;
    }

    /* JADX INFO: renamed from: setOldPosition--gyyYBs, reason: not valid java name */
    public final void m991setOldPositiongyyYBs(long r1) {
        this.oldPosition = r1;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.maxIntrinsicHeight(r3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.maxIntrinsicWidth(r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m990measure3p2s80s(MeasureScope r9, final Measurable r10, long r11) {
        if (Constraints.getHasFixedWidth-impl(r11) == true) goto L5;
    L8:
        ModifierLocalModifierNode.-CC.$default$provide(this, WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), ModifierLocalModifierNode.-CC.$default$getCurrent(this, WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets()));
        final Placeable r12 = r10.measure-BRTryo0(r11);
        return MeasureScope.-CC.layout$default(r9, r12.getWidth(), r12.getHeight(), null, new u1(r12), 4, null);
    L5:
        if (Constraints.getHasFixedHeight-impl(r11) == false) goto L8;
        final int r2 = Constraints.getMaxWidth-impl(r11);
        final int r3 = Constraints.getMaxHeight-impl(r11);
        return MeasureScope.-CC.layout$default(r9, r2, r3, null, new v1(this, r10, r2, r3), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.minIntrinsicHeight(r3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return r2.minIntrinsicWidth(r3);
    }

    private static final Unit measure_3p2s80s$lambda$2(RecalculateWindowInsetsModifierNode r14, Measurable r15, int r16, int r17, Placeable.PlacementScope r18) {
        LayoutCoordinates r1 = r18.getCoordinates();
        if (r1 == null) goto L5;
        r14.oldPosition = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(r1));
    L5:
        if (r1 != null) goto L7;
        ProvidableModifierLocal<WindowInsets> r2 = WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
        r14.getClass();
        Object r3 = (WindowInsets) ModifierLocalModifierNode.-CC.$default$getCurrent(r14, r2);
    L17:
        ProvidableModifierLocal<WindowInsets> r4 = WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
        r14.getClass();
        ModifierLocalModifierNode.-CC.$default$provide(r14, r4, r3);
        Placeable.PlacementScope.place$default(r18, r15.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r16, r17)), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L7:
        long r5 = LayoutCoordinatesKt.positionInRoot(r1);
        long r6 = r1.getSize-YbymL2g();
        float r7 = (int) (r6 >> 32);
        long r10 = Float.floatToRawIntBits(r7);
        long r8 = r1.localToRoot-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits((int) (r6 & 4294967295L))) & 4294967295L) | (r10 << 32)));
        long r11 = LayoutCoordinatesKt.findRootCoordinates(r1).getSize-YbymL2g();
        int r9 = Math.round(Float.intBitsToFloat((int) (r5 >> 32)));
        int r12 = Math.round(Float.intBitsToFloat((int) (r5 & 4294967295L)));
        int r13 = ((int) (r11 >> 32)) - Math.round(Float.intBitsToFloat((int) (r8 >> 32)));
        int r19 = ((int) (r11 & 4294967295L)) - Math.round(Float.intBitsToFloat((int) (r8 & 4294967295L)));
        InsetsValues r20 = r14.insets.getValue$foundation_layout();
        if (r20.getLeft() == r9) goto L10;
    L15:
        r14.insets.setValue$foundation_layout(new InsetsValues(r9, r12, r13, r19));
    L16:
        r3 = r14.insets;
        goto L17
    L10:
        if (r20.getTop() != r12) goto L15;
        if (r20.getRight() != r13) goto L15;
        if (r20.getBottom() == r19) goto L16;
        goto L15
    }
}
