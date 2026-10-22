package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RectRulers;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"fitInside", "Landroidx/compose/ui/Modifier;", "rulers", "Landroidx/compose/ui/layout/RectRulers;", "fitOutside", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RulerAlignmentKt {
    public static /* synthetic */ Unit a(Measurable r0, Placeable.PlacementScope r1) {
        return fitOutside$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit b(RectRulers r0, int r1, int r2, Measurable r3, Placeable.PlacementScope r4) {
        return fitInside$lambda$2$lambda$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ MeasureResult c(RectRulers r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return fitOutside$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ MeasureResult d(RectRulers r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return fitInside$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(RectRulers r0, int r1, int r2, Placeable r3, Placeable.PlacementScope r4) {
        return fitInside$lambda$2$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit f(RectRulers r0, int r1, int r2, Measurable r3, Placeable.PlacementScope r4) {
        return fitOutside$lambda$5$lambda$3(r0, r1, r2, r3, r4);
    }

    public static final Modifier fitInside(Modifier r1, final RectRulers r2) {
        return LayoutModifierKt.layout(r1, new x1(r2));
    }

    public static final Modifier fitOutside(Modifier r1, final RectRulers r2) {
        return LayoutModifierKt.layout(r1, new y1(r2));
    }

    private static final Unit fitOutside$lambda$5$lambda$4(Measurable r9, Placeable.PlacementScope r10) {
        Placeable.PlacementScope.place$default(r10, r9.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(0, 0)), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult fitInside$lambda$2(final RectRulers r9, MeasureScope r10, final Measurable r11, Constraints r12) {
        if (Constraints.getHasBoundedWidth-impl(r12.unbox-impl()) == true) goto L5;
    L7:
        final Placeable r13 = r11.measure-BRTryo0(r12.unbox-impl());
        final int r1 = r13.getWidth();
        final int r2 = r13.getHeight();
        return MeasureScope.-CC.layout$default(r10, r1, r2, null, new c2(r9, r1, r2, r13), 4, null);
    L5:
        if (Constraints.getHasBoundedHeight-impl(r12.unbox-impl()) == false) goto L7;
        final int r3 = Constraints.getMaxWidth-impl(r12.unbox-impl());
        final int r4 = Constraints.getMaxHeight-impl(r12.unbox-impl());
        return MeasureScope.-CC.layout$default(r10, r3, r4, null, new b2(r9, r3, r4, r11), 4, null);
    }

    private static final MeasureResult fitOutside$lambda$5(final RectRulers r9, MeasureScope r10, final Measurable r11, Constraints r12) {
        if (Constraints.getHasBoundedWidth-impl(r12.unbox-impl()) == false) goto L8;
        if (Constraints.getHasBoundedHeight-impl(r12.unbox-impl()) == false) goto L8;
        final int r3 = Constraints.getMaxWidth-impl(r12.unbox-impl());
        final int r4 = Constraints.getMaxHeight-impl(r12.unbox-impl());
        return MeasureScope.-CC.layout$default(r10, r3, r4, null, new z1(r9, r3, r4, r11), 4, null);
    L8:
        return MeasureScope.-CC.layout$default(r10, 0, 0, null, new a2(r11), 4, null);
    }

    private static final Unit fitInside$lambda$2$lambda$0(RectRulers r10, int r11, int r12, Measurable r13, Placeable.PlacementScope r14) {
        int r0 = MathKt.roundToInt(r14.current(r10.getLeft(), MenuKt.ClosedAlphaTarget));
        int r2 = 0;
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        if (r0 <= r11) goto L7;
        int r5 = r11;
    L8:
        int r1 = MathKt.roundToInt(r14.current(r10.getTop(), MenuKt.ClosedAlphaTarget));
        if (r1 >= 0) goto L11;
        r1 = 0;
    L11:
        if (r1 <= r12) goto L13;
        int r6 = r12;
    L14:
        int r3 = MathKt.roundToInt(r14.current(r10.getRight(), r11));
        if (r3 >= 0) goto L17;
        r3 = 0;
    L17:
        if (r3 > r11) goto L20;
        r11 = r3;
    L20:
        int r15 = MathKt.roundToInt(r14.current(r10.getBottom(), r12));
        if (r15 < 0) goto L24;
        r2 = r15;
    L24:
        if (r2 > r12) goto L27;
        r12 = r2;
    L27:
        Placeable.PlacementScope.place$default(r14, r13.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r11 - r5, r12 - r6)), r5, r6, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L13:
        r6 = r1;
        goto L14
    L7:
        r5 = r0;
        goto L8
    }

    private static final Unit fitInside$lambda$2$lambda$1(RectRulers r10, int r11, int r12, Placeable r13, Placeable.PlacementScope r14) {
        int r0 = MathKt.roundToInt(r14.current(r10.getLeft(), MenuKt.ClosedAlphaTarget));
        int r2 = 0;
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        if (r0 <= r11) goto L7;
        r0 = r11;
    L7:
        int r1 = MathKt.roundToInt(r14.current(r10.getTop(), MenuKt.ClosedAlphaTarget));
        if (r1 >= 0) goto L10;
        r1 = 0;
    L10:
        if (r1 <= r12) goto L12;
        r1 = r12;
    L12:
        int r3 = MathKt.roundToInt(r14.current(r10.getRight(), r11));
        if (r3 >= 0) goto L15;
        r3 = 0;
    L15:
        if (r3 <= r11) goto L17;
        r3 = r11;
    L17:
        int r15 = MathKt.roundToInt(r14.current(r10.getBottom(), r12));
        if (r15 < 0) goto L21;
        r2 = r15;
    L21:
        if (r2 <= r12) goto L23;
        r2 = r12;
    L23:
        Placeable.PlacementScope.place$default(r14, r13, ((r0 + r3) - r11) / 2, ((r1 + r2) - r12) / 2, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit fitOutside$lambda$5$lambda$3(RectRulers r11, int r12, int r13, Measurable r14, Placeable.PlacementScope r15) {
        int r0 = MathKt.roundToInt(r15.current(r11.getLeft(), MenuKt.ClosedAlphaTarget));
        int r1 = MathKt.roundToInt(r15.current(r11.getTop(), MenuKt.ClosedAlphaTarget));
        int r2 = MathKt.roundToInt(r15.current(r11.getRight(), r12));
        int r16 = MathKt.roundToInt(r15.current(r11.getBottom(), r13));
        if (r0 <= 0) goto L7;
        r12 = r0;
    L5:
        int r6 = 0;
    L6:
        int r7 = 0;
    L14:
        Placeable.PlacementScope.place$default(r15, r14.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r12, r13)), r6, r7, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L7:
        if (r1 <= 0) goto L9;
        r13 = r1;
        goto L5
    L9:
        if (r2 >= r12) goto L11;
        r12 = r12 - r2;
        r6 = r2;
        goto L6
    L11:
        if (r16 >= r13) goto L13;
        r13 = r13 - r16;
        r7 = r16;
        r6 = 0;
        goto L14
    L13:
        r12 = 0;
        r13 = 0;
        goto L5
    }
}
