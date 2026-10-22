package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u001c\u0010\"\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001eH\u0016J\u001c\u0010$\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u001c\u0010%\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001eH\u0016J\f\u0010&\u001a\u00020'*\u00020(H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0013\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/foundation/ScrollNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "isVertical", "<init>", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "getState", "()Landroidx/compose/foundation/ScrollState;", "setState", "(Landroidx/compose/foundation/ScrollState;)V", "getReverseScrolling", "()Z", "setReverseScrolling", "(Z)V", "setVertical", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollNode extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private boolean isVertical;
    private boolean reverseScrolling;
    private ScrollState state;

    public static /* synthetic */ Unit a(ScrollNode r0, int r1, Placeable r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ float b(ScrollNode r0) {
        return applySemantics$lambda$3(r0);
    }

    public static /* synthetic */ float c(ScrollNode r0) {
        return applySemantics$lambda$2(r0);
    }

    public static /* synthetic */ Unit d(Placeable r0, int r1, int r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final ScrollState getState() {
        return this.state;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    private static final float applySemantics$lambda$2(ScrollNode r0) {
        return r0.state.getValue();
    }

    private static final float applySemantics$lambda$3(ScrollNode r0) {
        return r0.state.getMaxValue();
    }

    public void applySemantics(SemanticsPropertyReceiver r5) {
        SemanticsPropertiesKt.setTraversalGroup(r5, true);
        ScrollAxisRange r0 = new ScrollAxisRange(new g1(this), new h1(this), this.reverseScrolling);
        if (this.isVertical == false) goto L5;
        SemanticsPropertiesKt.setVerticalScrollAxisRange(r5, r0);
        return;
    L5:
        SemanticsPropertiesKt.setHorizontalScrollAxisRange(r5, r0);
    }

    public final void setReverseScrolling(boolean r1) {
        this.reverseScrolling = r1;
    }

    public final void setState(ScrollState r1) {
        this.state = r1;
    }

    public final void setVertical(boolean r1) {
        this.isVertical = r1;
    }

    public ScrollNode(ScrollState r1, boolean r2, boolean r3) {
        this.state = r1;
        this.reverseScrolling = r2;
        this.isVertical = r3;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (this.isVertical == true) goto L7;
        r3 = Integer.MAX_VALUE;
    L7:
        return r2.maxIntrinsicHeight(r3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (this.isVertical == false) goto L6;
        r3 = Integer.MAX_VALUE;
    L6:
        return r2.maxIntrinsicWidth(r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m451measure3p2s80s(MeasureScope r11, Measurable r12, long r13) {
        if (this.isVertical == false) goto L5;
        Orientation r0 = Orientation.Vertical;
    L6:
        CheckScrollableContainerConstraintsKt.m370checkScrollableContainerConstraintsK40F9xA(r13, r0);
        if (this.isVertical == false) goto L9;
        int r7 = Integer.MAX_VALUE;
    L11:
        if (this.isVertical == false) goto L13;
        int r5 = Constraints.getMaxWidth-impl(r13);
    L14:
        final Placeable r14 = r12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r13, 0, r5, 0, r7, 5, null));
        int r3 = RangesKt.coerceAtMost(r14.getWidth(), Constraints.getMaxWidth-impl(r13));
        int r4 = RangesKt.coerceAtMost(r14.getHeight(), Constraints.getMaxHeight-impl(r13));
        final int r15 = r14.getHeight() - r4;
        int r16 = r14.getWidth() - r3;
        if (this.isVertical == true) goto L18;
        r15 = r16;
    L18:
        this.state.setMaxValue$foundation_release(r15);
        ScrollState r17 = this.state;
        if (this.isVertical == false) goto L21;
        int r1 = r4;
    L22:
        r17.setViewportSize$foundation_release(r1);
        return MeasureScope.-CC.layout$default(r11, r3, r4, null, new i1(this, r15, r14), 4, null);
    L21:
        r1 = r3;
        goto L22
    L13:
        r5 = Integer.MAX_VALUE;
        goto L14
    L9:
        r7 = Constraints.getMaxHeight-impl(r13);
        goto L11
    L5:
        r0 = Orientation.Horizontal;
        goto L6
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (this.isVertical == true) goto L7;
        r3 = Integer.MAX_VALUE;
    L7:
        return r2.minIntrinsicHeight(r3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (this.isVertical == false) goto L6;
        r3 = Integer.MAX_VALUE;
    L6:
        return r2.minIntrinsicWidth(r3);
    }

    private static final Unit measure_3p2s80s$lambda$1(ScrollNode r3, int r4, final Placeable r5, Placeable.PlacementScope r6) {
        int r0 = r3.state.getValue();
        final int r1 = 0;
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        if (r0 <= r4) goto L8;
        r0 = r4;
    L8:
        if (r3.reverseScrolling == false) goto L10;
        int r2 = r0 - r4;
    L11:
        boolean r7 = r3.isVertical;
        if (r7 == false) goto L14;
        final int r8 = 0;
    L15:
        if (r7 == false) goto L17;
        r1 = r2;
    L17:
        r6.withMotionFrameOfReferencePlacement(new j1(r5, r8, r1));
        return Unit.INSTANCE;
    L14:
        r8 = r2;
        goto L15
    L10:
        r2 = -r0;
        goto L11
    }

    private static final Unit measure_3p2s80s$lambda$1$lambda$0(Placeable r8, int r9, int r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.placeRelativeWithLayer$default(r11, r8, r9, r10, MenuKt.ClosedAlphaTarget, null, 12, null);
        return Unit.INSTANCE;
    }
}
