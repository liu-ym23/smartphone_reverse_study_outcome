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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001d\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001e\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u001c\u0010 \u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float r1, float r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1036getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1037getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m1039setMinHeight0680j_4(float r1) {
        this.minHeight = r1;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m1040setMinWidth0680j_4(float r1) {
        this.minWidth = r1;
    }

    private UnspecifiedConstraintsNode(float r1, float r2) {
        this.minWidth = r1;
        this.minHeight = r2;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.placeRelative$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        int r4 = r2.maxIntrinsicHeight(r3);
        if ((!Float.isNaN(this.minHeight)) == false) goto L5;
        int r5 = r1.roundToPx-0680j_4(this.minHeight);
    L6:
        if (r4 < r5) goto L8;
        return r4;
    L8:
        return r5;
    L5:
        r5 = 0;
        goto L6
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        int r4 = r2.maxIntrinsicWidth(r3);
        if ((!Float.isNaN(this.minWidth)) == false) goto L5;
        int r5 = r1.roundToPx-0680j_4(this.minWidth);
    L6:
        if (r4 < r5) goto L8;
        return r4;
    L8:
        return r5;
    L5:
        r5 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1038measure3p2s80s(MeasureScope r8, Measurable r9, long r10) {
        int r1 = 0;
        if ((!Float.isNaN(this.minWidth)) == true) goto L5;
    L12:
        int r2 = Constraints.getMinWidth-impl(r10);
    L13:
        int r0 = Constraints.getMaxWidth-impl(r10);
        if ((!Float.isNaN(this.minHeight)) == true) goto L16;
    L24:
        int r4 = Constraints.getMinHeight-impl(r10);
    L25:
        final Placeable r11 = r9.measure-BRTryo0(ConstraintsKt.Constraints(r2, r0, r4, Constraints.getMaxHeight-impl(r10)));
        return MeasureScope.-CC.layout$default(r8, r11.getWidth(), r11.getHeight(), null, new f2(r11), 4, null);
    L16:
        if (Constraints.getMinHeight-impl(r10) != 0) goto L24;
        int r3 = r8.roundToPx-0680j_4(this.minHeight);
        r4 = Constraints.getMaxHeight-impl(r10);
        if (r3 < 0) goto L21;
        r1 = r3;
    L21:
        if (r1 > r4) goto L25;
        r4 = r1;
        goto L25
    L5:
        if (Constraints.getMinWidth-impl(r10) != 0) goto L12;
        int r5 = r8.roundToPx-0680j_4(this.minWidth);
        r2 = Constraints.getMaxWidth-impl(r10);
        if (r5 >= 0) goto L9;
        r5 = 0;
    L9:
        if (r5 > r2) goto L13;
        r2 = r5;
        goto L13
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        int r4 = r2.minIntrinsicHeight(r3);
        if ((!Float.isNaN(this.minHeight)) == false) goto L5;
        int r5 = r1.roundToPx-0680j_4(this.minHeight);
    L6:
        if (r4 < r5) goto L8;
        return r4;
    L8:
        return r5;
    L5:
        r5 = 0;
        goto L6
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        int r4 = r2.minIntrinsicWidth(r3);
        if ((!Float.isNaN(this.minWidth)) == false) goto L5;
        int r5 = r1.roundToPx-0680j_4(this.minWidth);
    L6:
        if (r4 < r5) goto L8;
        return r4;
    L8:
        return r5;
    L5:
        r5 = 0;
        goto L6
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L8:
        this(r1, r2, null);
    }
}
