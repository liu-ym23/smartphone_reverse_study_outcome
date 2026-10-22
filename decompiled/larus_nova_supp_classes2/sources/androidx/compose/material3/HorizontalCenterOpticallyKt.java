package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"horizontalCenterOptically", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "maxStartOffset", "Landroidx/compose/ui/unit/Dp;", "maxEndOffset", "horizontalCenterOptically-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/shape/CornerBasedShape;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ShapeWithHorizontalCenterOptically;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ShapeWithHorizontalCenterOptically;FF)Landroidx/compose/ui/Modifier;", "CenterOpticallyCoefficient", "", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HorizontalCenterOpticallyKt {
    public static final float CenterOpticallyCoefficient = 0.11f;

    public static /* synthetic */ MeasureResult a(float r0, float r1, CornerBasedShape r2, MeasureScope r3, Measurable r4, Constraints r5) {
        return horizontalCenterOptically_4j6BHR0$lambda$1(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(ShapeWithHorizontalCenterOptically r0, float r1, float r2, Placeable r3, Placeable.PlacementScope r4) {
        return horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(float r0, float r1, float r2, Placeable r3, Placeable.PlacementScope r4) {
        return horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ MeasureResult d(float r0, float r1, ShapeWithHorizontalCenterOptically r2, MeasureScope r3, Measurable r4, Constraints r5) {
        return horizontalCenterOptically_4j6BHR0$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: horizontalCenterOptically-4j6BHR0, reason: not valid java name */
    public static final Modifier m2733horizontalCenterOptically4j6BHR0(Modifier r1, final CornerBasedShape r2, final float r3, final float r4) {
        return LayoutModifierKt.layout(r1, new xb(r3, r4, r2));
    }

    /* JADX INFO: renamed from: horizontalCenterOptically-4j6BHR0, reason: not valid java name */
    public static final Modifier m2734horizontalCenterOptically4j6BHR0(Modifier r1, final ShapeWithHorizontalCenterOptically r2, final float r3, final float r4) {
        return LayoutModifierKt.layout(r1, new wb(r3, r4, r2));
    }

    private static final Unit horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0(float r7, float r8, float r9, Placeable r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.place$default(r11, r10, MathKt.roundToInt(RangesKt.coerceIn(r7, r8, r9)), 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2(ShapeWithHorizontalCenterOptically r7, float r8, float r9, Placeable r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.place$default(r11, r10, MathKt.roundToInt(RangesKt.coerceIn(r7.offset(), r8, r9)), 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: horizontalCenterOptically-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2735horizontalCenterOptically4j6BHR0$default(Modifier r1, CornerBasedShape r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = Dp.constructor-impl(0);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = Dp.constructor-impl(0);
    L9:
        return m2733horizontalCenterOptically4j6BHR0(r1, r2, r3, r4);
    }

    private static final MeasureResult horizontalCenterOptically_4j6BHR0$lambda$1(float r9, float r10, CornerBasedShape r11, MeasureScope r12, Measurable r13, Constraints r14) {
        final Placeable r15 = r13.measure-BRTryo0(r14.unbox-impl());
        int r1 = r15.getWidth();
        int r2 = r15.getHeight();
        long r3 = Size.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r2)) & 4294967295L));
        final float r16 = -r12.toPx-0680j_4(r9);
        final float r17 = r12.toPx-0680j_4(r10);
        float r18 = r11.getTopStart().mo1321toPxTmRCtEA(r3, r12);
        float r0 = r11.getTopEnd().mo1321toPxTmRCtEA(r3, r12);
        float r5 = r11.getBottomStart().mo1321toPxTmRCtEA(r3, r12);
        float r19 = r11.getBottomEnd().mo1321toPxTmRCtEA(r3, r12);
        float r4 = 2;
        final float r110 = (((r18 + r5) / r4) - ((r0 + r19) / r4)) * 0.11f;
        return MeasureScope.-CC.layout$default(r12, r1, r2, null, new yb(r110, r16, r17, r15), 4, null);
    }

    private static final MeasureResult horizontalCenterOptically_4j6BHR0$lambda$3(float r7, float r8, final ShapeWithHorizontalCenterOptically r9, MeasureScope r10, Measurable r11, Constraints r12) {
        final Placeable r13 = r11.measure-BRTryo0(r12.unbox-impl());
        int r1 = r13.getWidth();
        int r2 = r13.getHeight();
        final float r14 = -r10.toPx-0680j_4(r7);
        final float r15 = r10.toPx-0680j_4(r8);
        return MeasureScope.-CC.layout$default(r10, r1, r2, null, new zb(r9, r14, r15, r13), 4, null);
    }

    /* JADX INFO: renamed from: horizontalCenterOptically-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2736horizontalCenterOptically4j6BHR0$default(Modifier r1, ShapeWithHorizontalCenterOptically r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = Dp.constructor-impl(0);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = Dp.constructor-impl(0);
    L9:
        return m2734horizontalCenterOptically4j6BHR0(r1, r2, r3, r4);
    }
}
