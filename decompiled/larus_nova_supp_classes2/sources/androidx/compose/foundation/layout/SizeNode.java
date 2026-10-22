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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u0010-\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016J\u001c\u0010/\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u00100\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float r1, float r2, float r3, float r4, boolean r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$3(r0, r1);
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m1023getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m1024getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1025getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1026getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m1022getTargetConstraintsOenEA2s(Density r7) {
        int r2 = 0;
        if ((!Float.isNaN(this.maxWidth)) == false) goto L7;
        int r0 = r7.roundToPx-0680j_4(this.maxWidth);
        if (r0 >= 0) goto L9;
        r0 = 0;
    L9:
        if ((!Float.isNaN(this.maxHeight)) == false) goto L13;
        int r3 = r7.roundToPx-0680j_4(this.maxHeight);
        if (r3 >= 0) goto L15;
        r3 = 0;
    L15:
        if ((!Float.isNaN(this.minWidth)) == false) goto L23;
        int r4 = r7.roundToPx-0680j_4(this.minWidth);
        if (r4 >= 0) goto L19;
        r4 = 0;
    L19:
        if (r4 <= r0) goto L21;
        r4 = r0;
    L21:
        if (r4 == Integer.MAX_VALUE) goto L23;
    L25:
        if ((!Float.isNaN(this.minHeight)) == false) goto L34;
        int r8 = r7.roundToPx-0680j_4(this.minHeight);
        if (r8 >= 0) goto L29;
        r8 = 0;
    L29:
        if (r8 <= r3) goto L31;
        r8 = r3;
    L31:
        if (r8 == Integer.MAX_VALUE) goto L34;
        r2 = r8;
    L34:
        return ConstraintsKt.Constraints(r4, r0, r2, r3);
    L23:
        r4 = 0;
        goto L25
    L13:
        r3 = Integer.MAX_VALUE;
        goto L15
    L7:
        r0 = Integer.MAX_VALUE;
        goto L9
    }

    public final void setEnforceIncoming(boolean r1) {
        this.enforceIncoming = r1;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m1028setMaxHeight0680j_4(float r1) {
        this.maxHeight = r1;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m1029setMaxWidth0680j_4(float r1) {
        this.maxWidth = r1;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m1030setMinHeight0680j_4(float r1) {
        this.minHeight = r1;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m1031setMinWidth0680j_4(float r1) {
        this.minWidth = r1;
    }

    private static final Unit measure_3p2s80s$lambda$3(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.placeRelative$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        long r0 = m1022getTargetConstraintsOenEA2s(r3);
        if (Constraints.getHasFixedHeight-impl(r0) == false) goto L6;
        return Constraints.getMaxHeight-impl(r0);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r5 = ConstraintsKt.constrainWidth-K40F9xA(r0, r5);
    L10:
        return ConstraintsKt.constrainHeight-K40F9xA(r0, r4.maxIntrinsicHeight(r5));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        long r0 = m1022getTargetConstraintsOenEA2s(r3);
        if (Constraints.getHasFixedWidth-impl(r0) == false) goto L6;
        return Constraints.getMaxWidth-impl(r0);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r5 = ConstraintsKt.constrainHeight-K40F9xA(r0, r5);
    L10:
        return ConstraintsKt.constrainWidth-K40F9xA(r0, r4.maxIntrinsicWidth(r5));
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1027measure3p2s80s(MeasureScope r8, Measurable r9, long r10) {
        long r0 = m1022getTargetConstraintsOenEA2s(r8);
        if (this.enforceIncoming == false) goto L6;
        long r11 = ConstraintsKt.constrain-N9IONVI(r10, r0);
    L30:
        final Placeable r12 = r9.measure-BRTryo0(r11);
        return MeasureScope.-CC.layout$default(r8, r12.getWidth(), r12.getHeight(), null, new d2(r12), 4, null);
    L6:
        if ((!Float.isNaN(this.minWidth)) == false) goto L8;
        int r2 = Constraints.getMinWidth-impl(r0);
    L12:
        if ((!Float.isNaN(this.maxWidth)) == false) goto L14;
        int r3 = Constraints.getMaxWidth-impl(r0);
    L18:
        if ((!Float.isNaN(this.minHeight)) == false) goto L20;
        int r4 = Constraints.getMinHeight-impl(r0);
    L24:
        if ((!Float.isNaN(this.maxHeight)) == false) goto L26;
        int r13 = Constraints.getMaxHeight-impl(r0);
    L29:
        r11 = ConstraintsKt.Constraints(r2, r3, r4, r13);
        goto L30
    L26:
        r13 = Constraints.getMaxHeight-impl(r10);
        int r14 = Constraints.getMinHeight-impl(r0);
        if (r13 >= r14) goto L29;
        r13 = r14;
        goto L29
    L20:
        r4 = Constraints.getMinHeight-impl(r10);
        int r5 = Constraints.getMaxHeight-impl(r0);
        if (r4 <= r5) goto L24;
        r4 = r5;
        goto L24
    L14:
        r3 = Constraints.getMaxWidth-impl(r10);
        int r6 = Constraints.getMinWidth-impl(r0);
        if (r3 >= r6) goto L18;
        r3 = r6;
        goto L18
    L8:
        r2 = Constraints.getMinWidth-impl(r10);
        int r7 = Constraints.getMaxWidth-impl(r0);
        if (r2 <= r7) goto L12;
        r2 = r7;
        goto L12
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        long r0 = m1022getTargetConstraintsOenEA2s(r3);
        if (Constraints.getHasFixedHeight-impl(r0) == false) goto L6;
        return Constraints.getMaxHeight-impl(r0);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r5 = ConstraintsKt.constrainWidth-K40F9xA(r0, r5);
    L10:
        return ConstraintsKt.constrainHeight-K40F9xA(r0, r4.minIntrinsicHeight(r5));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        long r0 = m1022getTargetConstraintsOenEA2s(r3);
        if (Constraints.getHasFixedWidth-impl(r0) == false) goto L6;
        return Constraints.getMaxWidth-impl(r0);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r5 = ConstraintsKt.constrainHeight-K40F9xA(r0, r5);
    L10:
        return ConstraintsKt.constrainWidth-K40F9xA(r0, r4.minIntrinsicWidth(r5));
    }

    private SizeNode(float r1, float r2, float r3, float r4, boolean r5) {
        this.minWidth = r1;
        this.minHeight = r2;
        this.maxWidth = r3;
        this.maxHeight = r4;
        this.enforceIncoming = r5;
    }

    public /* synthetic */ SizeNode(float r8, float r9, float r10, float r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r8 = Dp.Companion.getUnspecified-D9Ej5fM();
    L5:
        float r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        r9 = Dp.Companion.getUnspecified-D9Ej5fM();
    L8:
        float r2 = r9;
        if ((r13 & 4) == 0) goto L11;
        r10 = Dp.Companion.getUnspecified-D9Ej5fM();
    L11:
        float r3 = r10;
        if ((r13 & 8) == 0) goto L14;
        r11 = Dp.Companion.getUnspecified-D9Ej5fM();
    L14:
        this(r1, r2, r3, r11, r12, null);
    }
}
