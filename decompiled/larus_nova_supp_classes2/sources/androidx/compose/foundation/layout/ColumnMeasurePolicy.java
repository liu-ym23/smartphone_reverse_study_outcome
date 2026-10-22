package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0016J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016Jg\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J7\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J)\u00100\u001a\u00020\u0016*\u00020\u00142\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u00020'H\u0016¢\u0006\u0004\b5\u00106J\"\u00107\u001a\u00020\n*\u0002082\f\u00101\u001a\b\u0012\u0004\u0012\u000209022\u0006\u0010:\u001a\u00020\nH\u0016J\"\u0010;\u001a\u00020\n*\u0002082\f\u00101\u001a\b\u0012\u0004\u0012\u000209022\u0006\u0010<\u001a\u00020\nH\u0016J\"\u0010=\u001a\u00020\n*\u0002082\f\u00101\u001a\b\u0012\u0004\u0012\u000209022\u0006\u0010:\u001a\u00020\nH\u0016J\"\u0010>\u001a\u00020\n*\u0002082\f\u00101\u001a\b\u0012\u0004\u0012\u000209022\u0006\u0010<\u001a\u00020\nH\u0016J\t\u0010?\u001a\u00020\u0004HÂ\u0003J\t\u0010@\u001a\u00020\u0006HÂ\u0003J\u001d\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010B\u001a\u00020-2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020GHÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Landroidx/compose/foundation/layout/ColumnMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;)V", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "populateMainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "", "mainAxisPositions", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "beforeCrossAxisAlignmentLine", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "getCrossAxisPosition", "placeable", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "measure", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColumnMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    public static final int $stable = 0;
    private final Alignment.Horizontal horizontalAlignment;
    private final Arrangement.Vertical verticalArrangement;

    public static /* synthetic */ Unit a(Placeable[] r0, ColumnMeasurePolicy r1, int r2, int r3, MeasureScope r4, int[] r5, Placeable.PlacementScope r6) {
        return placeHelper$lambda$3$lambda$2(r0, r1, r2, r3, r4, r5, r6);
    }

    private final Arrangement.Vertical component1() {
        return this.verticalArrangement;
    }

    private final Alignment.Horizontal component2() {
        return this.horizontalAlignment;
    }

    public static /* synthetic */ ColumnMeasurePolicy copy$default(ColumnMeasurePolicy r0, Arrangement.Vertical r1, Alignment.Horizontal r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.verticalArrangement;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.horizontalAlignment;
    L9:
        return r0.copy(r1, r2);
    }

    public final ColumnMeasurePolicy copy(Arrangement.Vertical r2, Alignment.Horizontal r3) {
        return new ColumnMeasurePolicy(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ColumnMeasurePolicy) == true) goto L8;
        return false;
    L8:
        ColumnMeasurePolicy r6 = (ColumnMeasurePolicy) r5;
        if (Intrinsics.areEqual(this.verticalArrangement, r6.verticalArrangement) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.horizontalAlignment, r6.horizontalAlignment) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.verticalArrangement.hashCode() * 31) + this.horizontalAlignment.hashCode();
    }

    public String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ')';
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(Placeable r1) {
        return r1.getWidth();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(Placeable r1) {
        return r1.getHeight();
    }

    public ColumnMeasurePolicy(Arrangement.Vertical r1, Alignment.Horizontal r2) {
        this.verticalArrangement = r1;
        this.horizontalAlignment = r2;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxHeight(r4, r5, r3.roundToPx-0680j_4(this.verticalArrangement.mo812getSpacingD9Ej5fM()));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxWidth(r4, r5, r3.roundToPx-0680j_4(this.verticalArrangement.mo812getSpacingD9Ej5fM()));
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m847measure3p2s80s(MeasureScope r17, List<? extends Measurable> r18, long r19) {
        return RowColumnMeasurePolicyKt.measure$default(this, Constraints.getMinHeight-impl(r19), Constraints.getMinWidth-impl(r19), Constraints.getMaxHeight-impl(r19), Constraints.getMaxWidth-impl(r19), r17.roundToPx-0680j_4(this.verticalArrangement.mo812getSpacingD9Ej5fM()), r17, r18, new Placeable[r18.size()], 0, r18.size(), null, 0, 3072, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinHeight(r4, r5, r3.roundToPx-0680j_4(this.verticalArrangement.mo812getSpacingD9Ej5fM()));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinWidth(r4, r5, r3.roundToPx-0680j_4(this.verticalArrangement.mo812getSpacingD9Ej5fM()));
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int r2, int[] r3, int[] r4, MeasureScope r5) {
        this.verticalArrangement.arrange(r5, r2, r3, r4);
    }

    private final int getCrossAxisPosition(Placeable r2, RowColumnParentData r3, int r4, int r5, LayoutDirection r6) {
        if (r3 == null) goto L4;
        CrossAxisAlignment r7 = r3.getCrossAxisAlignment();
    L5:
        if (r7 == null) goto L8;
        return r7.align$foundation_layout(r4 - r2.getWidth(), r6, r2, r5);
    L8:
        return this.horizontalAlignment.align(0, r4 - r2.getWidth(), r6);
    L4:
        r7 = null;
        goto L5
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q, reason: not valid java name */
    public long mo846createConstraintsxF2OJ5Q(int r1, int r2, int r3, int r4, boolean r5) {
        return ColumnKt.createColumnConstraints(r5, r1, r2, r3, r4);
    }

    private static final Unit placeHelper$lambda$3$lambda$2(Placeable[] r12, ColumnMeasurePolicy r13, int r14, int r15, MeasureScope r16, int[] r17, Placeable.PlacementScope r18) {
        int r1 = r12.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Placeable r10 = r12[r2];
        Intrinsics.checkNotNull(r10);
        Placeable.PlacementScope.place$default(r18, r10, r13.getCrossAxisPosition(r10, RowColumnImplKt.getRowColumnParentData(r10), r14, r15, r16.getLayoutDirection()), r17[r3], MenuKt.ClosedAlphaTarget, 4, null);
        r2 = r2 + 1;
        r3 = r3 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult placeHelper(final Placeable[] r13, final MeasureScope r14, final int r15, final int[] r16, int r17, final int r18, int[] r19, int r20, int r21, int r22) {
        return MeasureScope.-CC.layout$default(r14, r18, r17, null, new r(r13, this, r18, r15, r14, r16), 4, null);
    }
}
