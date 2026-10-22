package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public static /* synthetic */ Unit a(Placeable r0, int r1, int r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$1(r0, r1, r2, r3);
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

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public PaddingValuesModifier(PaddingValues r1) {
        this.paddingValues = r1;
    }

    public final void setPaddingValues(PaddingValues r1) {
        this.paddingValues = r1;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m987measure3p2s80s(MeasureScope r14, Measurable r15, long r16) {
        float r4 = this.paddingValues.mo899calculateLeftPaddingu2uoSUM(r14.getLayoutDirection());
        float r5 = this.paddingValues.mo901calculateTopPaddingD9Ej5fM();
        float r6 = this.paddingValues.mo900calculateRightPaddingu2uoSUM(r14.getLayoutDirection());
        float r7 = this.paddingValues.mo898calculateBottomPaddingD9Ej5fM();
        boolean r8 = false;
        float r9 = 0;
        if (Dp.compareTo-0680j_4(r4, Dp.constructor-impl(r9)) < 0) goto L5;
        boolean r10 = true;
    L7:
        if (Dp.compareTo-0680j_4(r5, Dp.constructor-impl(r9)) < 0) goto L9;
        boolean r12 = true;
    L10:
        boolean r11 = r10 & r12;
        if (Dp.compareTo-0680j_4(r6, Dp.constructor-impl(r9)) < 0) goto L13;
        boolean r13 = true;
    L14:
        boolean r17 = r11 & r13;
        if (Dp.compareTo-0680j_4(r7, Dp.constructor-impl(r9)) < 0) goto L18;
        r8 = true;
    L18:
        if ((r8 & r17) == true) goto L20;
        InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
    L20:
        final int r18 = r14.roundToPx-0680j_4(r4);
        int r19 = r14.roundToPx-0680j_4(r6) + r18;
        final int r20 = r14.roundToPx-0680j_4(r5);
        int r21 = r14.roundToPx-0680j_4(r7) + r20;
        final Placeable r22 = r15.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r16, -r19, -r21));
        return MeasureScope.-CC.layout$default(r14, ConstraintsKt.constrainWidth-K40F9xA(r16, r22.getWidth() + r19), ConstraintsKt.constrainHeight-K40F9xA(r16, r22.getHeight() + r21), null, new t1(r22, r18, r20), 4, null);
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    private static final Unit measure_3p2s80s$lambda$1(Placeable r7, int r8, int r9, Placeable.PlacementScope r10) {
        Placeable.PlacementScope.place$default(r10, r7, r8, r9, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }
}
