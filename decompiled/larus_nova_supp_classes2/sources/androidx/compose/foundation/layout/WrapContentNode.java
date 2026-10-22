package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public static /* synthetic */ Unit a(WrapContentNode r0, int r1, Placeable r2, int r3, MeasureScope r4, Placeable.PlacementScope r5) {
        return measure_3p2s80s$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    public final void setAlignmentCallback(Function2<? super IntSize, ? super LayoutDirection, IntOffset> r1) {
        this.alignmentCallback = r1;
    }

    public final void setDirection(Direction r1) {
        this.direction = r1;
    }

    public final void setUnbounded(boolean r1) {
        this.unbounded = r1;
    }

    public WrapContentNode(Direction r1, boolean r2, Function2<? super IntSize, ? super LayoutDirection, IntOffset> r3) {
        this.direction = r1;
        this.unbounded = r2;
        this.alignmentCallback = r3;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1079measure3p2s80s(final MeasureScope r15, Measurable r16, long r17) {
        Direction r0 = this.direction;
        Direction r1 = Direction.Vertical;
        int r2 = 0;
        if (r0 == r1) goto L5;
        int r3 = 0;
    L6:
        Direction r4 = this.direction;
        Direction r5 = Direction.Horizontal;
        if (r4 != r5) goto L10;
        r2 = Constraints.getMinHeight-impl(r17);
    L10:
        int r6 = Integer.MAX_VALUE;
        if (this.direction != r1) goto L13;
    L15:
        int r7 = Constraints.getMaxWidth-impl(r17);
    L17:
        if (this.direction != r5) goto L19;
    L21:
        r6 = Constraints.getMaxHeight-impl(r17);
    L22:
        final Placeable r8 = r16.measure-BRTryo0(ConstraintsKt.Constraints(r3, r7, r2, r6));
        final int r9 = RangesKt.coerceIn(r8.getWidth(), Constraints.getMinWidth-impl(r17), Constraints.getMaxWidth-impl(r17));
        final int r10 = RangesKt.coerceIn(r8.getHeight(), Constraints.getMinHeight-impl(r17), Constraints.getMaxHeight-impl(r17));
        return MeasureScope.-CC.layout$default(r15, r9, r10, null, new v2(this, r9, r8, r10, r15), 4, null);
    L19:
        if (this.unbounded == false) goto L21;
    L13:
        if (this.unbounded == false) goto L15;
        r7 = Integer.MAX_VALUE;
        goto L17
    L5:
        r3 = Constraints.getMinWidth-impl(r17);
        goto L6
    }

    private static final Unit measure_3p2s80s$lambda$0(WrapContentNode r7, int r8, Placeable r9, int r10, MeasureScope r11, Placeable.PlacementScope r12) {
        Function2<? super IntSize, ? super LayoutDirection, IntOffset> r13 = r7.alignmentCallback;
        int r14 = r8 - r9.getWidth();
        int r15 = r10 - r9.getHeight();
        Placeable.PlacementScope.place-70tqf50$default(r12, r9, ((IntOffset) r13.invoke(IntSize.box-impl(IntSize.constructor-impl((((long) r14) << 32) | (((long) r15) & 4294967295L))), r11.getLayoutDirection())).unbox-impl(), MenuKt.ClosedAlphaTarget, 2, null);
        return Unit.INSTANCE;
    }
}
