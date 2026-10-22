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
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0016J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0016J)\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016Jg\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0 2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016¢\u0006\u0002\u0010'J7\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J*\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002J\"\u00105\u001a\u00020\n*\u0002062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002070\u00112\u0006\u00108\u001a\u00020\nH\u0016J\"\u00109\u001a\u00020\n*\u0002062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002070\u00112\u0006\u0010:\u001a\u00020\nH\u0016J\"\u0010;\u001a\u00020\n*\u0002062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002070\u00112\u0006\u00108\u001a\u00020\nH\u0016J\"\u0010<\u001a\u00020\n*\u0002062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002070\u00112\u0006\u0010:\u001a\u00020\nH\u0016J\t\u0010=\u001a\u00020\u0004HÂ\u0003J\t\u0010>\u001a\u00020\u0006HÂ\u0003J\u001d\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010@\u001a\u00020.2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\nHÖ\u0001J\t\u0010D\u001a\u00020EHÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/compose/foundation/layout/RowMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;)V", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "", "mainAxisPositions", "measureScope", "placeHelper", "placeables", "", "beforeCrossAxisAlignmentLine", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "createConstraints", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "getCrossAxisPosition", "placeable", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RowMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    public static final int $stable = 0;
    private final Arrangement.Horizontal horizontalArrangement;
    private final Alignment.Vertical verticalAlignment;

    public static /* synthetic */ Unit a(Placeable[] r0, RowMeasurePolicy r1, int r2, int r3, int[] r4, Placeable.PlacementScope r5) {
        return placeHelper$lambda$3$lambda$2(r0, r1, r2, r3, r4, r5);
    }

    private final Arrangement.Horizontal component1() {
        return this.horizontalArrangement;
    }

    private final Alignment.Vertical component2() {
        return this.verticalAlignment;
    }

    public static /* synthetic */ RowMeasurePolicy copy$default(RowMeasurePolicy r0, Arrangement.Horizontal r1, Alignment.Vertical r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.horizontalArrangement;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.verticalAlignment;
    L9:
        return r0.copy(r1, r2);
    }

    public final RowMeasurePolicy copy(Arrangement.Horizontal r2, Alignment.Vertical r3) {
        return new RowMeasurePolicy(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RowMeasurePolicy) == true) goto L8;
        return false;
    L8:
        RowMeasurePolicy r6 = (RowMeasurePolicy) r5;
        if (Intrinsics.areEqual(this.horizontalArrangement, r6.horizontalArrangement) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.verticalAlignment, r6.verticalAlignment) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.horizontalArrangement.hashCode() * 31) + this.verticalAlignment.hashCode();
    }

    public String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.horizontalArrangement + ", verticalAlignment=" + this.verticalAlignment + ')';
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(Placeable r1) {
        return r1.getHeight();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(Placeable r1) {
        return r1.getWidth();
    }

    public RowMeasurePolicy(Arrangement.Horizontal r1, Alignment.Vertical r2) {
        this.horizontalArrangement = r1;
        this.verticalAlignment = r2;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxHeight(r4, r5, r3.roundToPx-0680j_4(this.horizontalArrangement.mo812getSpacingD9Ej5fM()));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxWidth(r4, r5, r3.roundToPx-0680j_4(this.horizontalArrangement.mo812getSpacingD9Ej5fM()));
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m993measure3p2s80s(MeasureScope r17, List<? extends Measurable> r18, long r19) {
        return RowColumnMeasurePolicyKt.measure$default(this, Constraints.getMinWidth-impl(r19), Constraints.getMinHeight-impl(r19), Constraints.getMaxWidth-impl(r19), Constraints.getMaxHeight-impl(r19), r17.roundToPx-0680j_4(this.horizontalArrangement.mo812getSpacingD9Ej5fM()), r17, r18, new Placeable[r18.size()], 0, r18.size(), null, 0, 3072, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinHeight(r4, r5, r3.roundToPx-0680j_4(this.horizontalArrangement.mo812getSpacingD9Ej5fM()));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r3, List<? extends IntrinsicMeasurable> r4, int r5) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinWidth(r4, r5, r3.roundToPx-0680j_4(this.horizontalArrangement.mo812getSpacingD9Ej5fM()));
    }

    private final int getCrossAxisPosition(Placeable r2, RowColumnParentData r3, int r4, int r5) {
        if (r3 == null) goto L4;
        CrossAxisAlignment r6 = r3.getCrossAxisAlignment();
    L5:
        if (r6 == null) goto L8;
        return r6.align$foundation_layout(r4 - r2.getHeight(), LayoutDirection.Ltr, r2, r5);
    L8:
        return this.verticalAlignment.align(0, r4 - r2.getHeight());
    L4:
        r6 = null;
        goto L5
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int r7, int[] r8, int[] r9, MeasureScope r10) {
        this.horizontalArrangement.arrange(r10, r7, r8, r10.getLayoutDirection(), r9);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    public long mo846createConstraintsxF2OJ5Q(int r1, int r2, int r3, int r4, boolean r5) {
        return RowKt.createRowConstraints(r5, r1, r2, r3, r4);
    }

    private static final Unit placeHelper$lambda$3$lambda$2(Placeable[] r15, RowMeasurePolicy r16, int r17, int r18, int[] r19, Placeable.PlacementScope r20) {
        int r1 = r15.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Placeable r5 = r15[r2];
        Intrinsics.checkNotNull(r5);
        int r7 = r16.getCrossAxisPosition(r5, RowColumnImplKt.getRowColumnParentData(r5), r17, r18);
        Placeable.PlacementScope.place$default(r20, r5, r19[r3], r7, MenuKt.ClosedAlphaTarget, 4, null);
        r2 = r2 + 1;
        r3 = r3 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult placeHelper(final Placeable[] r12, MeasureScope r13, final int r14, final int[] r15, int r16, final int r17, int[] r18, int r19, int r20, int r21) {
        return MeasureScope.-CC.layout$default(r13, r16, r17, null, new w1(r12, this, r17, r14, r15), 4, null);
    }
}
