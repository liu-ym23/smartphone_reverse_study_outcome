package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "alignmentLinesCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "updateAlignmentLines", "", "sizePx", "placeable", "Landroidx/compose/ui/layout/Placeable;", "getAlignmentLinesCache", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Map<AlignmentLine, Integer> alignmentLinesCache;

    public static /* synthetic */ Unit a(int r0, Placeable r1, int r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$0(r0, r1, r2, r3);
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

    private final Map<AlignmentLine, Integer> getAlignmentLinesCache() {
        Map<AlignmentLine, Integer> r0 = this.alignmentLinesCache;
        if (r0 != null) goto L6;
        LinkedHashMap r1 = new LinkedHashMap(2);
        this.alignmentLinesCache = r1;
        return r1;
    L6:
        return r0;
    }

    public MinimumInteractiveModifierNode() {
    }

    private final void updateAlignmentLines(int r6, Placeable r7) {
        Map<AlignmentLine, Integer> r0 = getAlignmentLinesCache();
        r0.put(InteractiveComponentSizeKt.getMinimumInteractiveLeftAlignmentLine(), Integer.valueOf(RangesKt.coerceAtLeast(Math.round((r6 - r7.getWidth()) / 2.0f), 0)));
        r0.put(InteractiveComponentSizeKt.getMinimumInteractiveTopAlignmentLine(), Integer.valueOf(RangesKt.coerceAtLeast(Math.round((r6 - r7.getHeight()) / 2.0f), 0)));
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2867measure3p2s80s(MeasureScope r5, Measurable r6, long r7) {
        int r1 = 0;
        float r2 = 0;
        float r0 = Dp.constructor-impl(RangesKt.coerceAtLeast(((Dp) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl(), Dp.constructor-impl(r2)));
        final Placeable r8 = r6.measure-BRTryo0(r7);
        if (isAttached() == true) goto L5;
    L9:
        boolean r9 = false;
    L11:
        if ((true ^ Float.isNaN(r0)) == false) goto L13;
        r1 = r5.roundToPx-0680j_4(r0);
    L13:
        if (r9 == false) goto L15;
        final int r10 = Math.max(r8.getWidth(), r1);
    L16:
        if (r9 == false) goto L18;
        final int r3 = Math.max(r8.getHeight(), r1);
    L19:
        if (r9 == false) goto L21;
        updateAlignmentLines(r1, r8);
    L21:
        Map<AlignmentLine, Integer> r11 = this.alignmentLinesCache;
        if (r11 != null) goto L25;
        r11 = MapsKt.emptyMap();
    L25:
        return r5.layout(r10, r3, r11, new wd(r10, r8, r3));
    L18:
        r3 = r8.getHeight();
        goto L19
    L15:
        r10 = r8.getWidth();
        goto L16
    L5:
        if ((!Float.isNaN(r0)) == false) goto L9;
        if (Dp.compareTo-0680j_4(r0, Dp.constructor-impl(r2)) <= 0) goto L9;
        r9 = true;
        goto L11
    }

    private static final Unit measure_3p2s80s$lambda$0(int r8, Placeable r9, int r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.place$default(r11, r9, MathKt.roundToInt((r8 - r9.getWidth()) / 2.0f), MathKt.roundToInt((r10 - r9.getHeight()) / 2.0f), MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }
}
