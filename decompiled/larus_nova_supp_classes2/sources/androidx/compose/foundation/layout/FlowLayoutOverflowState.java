package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0081\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ'\u0010+\u001a\u0004\u0018\u00010\"2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/J'\u00100\u001a\u0004\u0018\u0001012\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0000¢\u0006\u0002\b2J3\u00103\u001a\u0002042\b\u0010\u001b\u001a\u0004\u0018\u0001052\b\u0010\u001f\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0000¢\u0006\u0004\b9\u0010:J3\u00103\u001a\u0002042\u0006\u0010;\u001a\u00020<2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u000208H\u0000¢\u0006\u0004\b9\u0010=JY\u00103\u001a\u0002042\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u00020828\u0010$\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010\u001c0%H\u0000¢\u0006\u0004\b?\u0010@J\u000e\u0010A\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bBJ\u000e\u0010C\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\bDJ\u000e\u0010E\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\bFJ'\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010H\u001a\u00020&2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\t\u0010K\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u0017R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010$\u001a6\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", "getType$foundation_layout", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "getMinLinesToShowCollapse$foundation_layout", "()I", "getMinCrossAxisSizeToShowCollapse$foundation_layout", "shownItemCount", "getShownItemCount$foundation_layout", "shownItemLazyErrorMessage", "", "getShownItemLazyErrorMessage$foundation_layout", "()Ljava/lang/String;", "itemShown", "getItemShown$foundation_layout", "setItemShown$foundation_layout", "(I)V", "itemCount", "getItemCount$foundation_layout", "setItemCount$foundation_layout", "seeMoreMeasurable", "Landroidx/compose/ui/layout/Measurable;", "seeMorePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapseMeasurable", "collapsePlaceable", "seeMoreSize", "Landroidx/collection/IntIntPair;", "collapseSize", "getOverflowMeasurable", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "isExpandable", "noOfItemsShown", "ellipsisSize", "hasNext", "lineIndex", "totalCrossAxisSize", "ellipsisSize-F35zm-w$foundation_layout", "ellipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "ellipsisInfo$foundation_layout", "setOverflowMeasurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "isHorizontal", "constraints", "Landroidx/compose/ui/unit/Constraints;", "setOverflowMeasurables--hBUhpc$foundation_layout", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", "numberOfItemsShown", "setOverflowMeasurables-VKLhPVY$foundation_layout", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function2;)V", "component1", "component1$foundation_layout", "component2", "component2$foundation_layout", "component3", "component3$foundation_layout", "copy", "equals", "other", "hashCode", "toString", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutOverflowState {
    public static final int $stable = 8;
    private Measurable collapseMeasurable;
    private Placeable collapsePlaceable;
    private IntIntPair collapseSize;
    private Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable;
    private int itemCount;
    private int itemShown;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private Measurable seeMoreMeasurable;
    private Placeable seeMorePlaceable;
    private IntIntPair seeMoreSize;
    private final String shownItemLazyErrorMessage;
    private final FlowLayoutOverflow.OverflowType type;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FlowLayoutOverflow.OverflowType.values().length];
            r0[FlowLayoutOverflow.OverflowType.Visible.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FlowLayoutOverflow.OverflowType.Clip.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FlowLayoutOverflow.OverflowType.ExpandIndicator.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ Unit a(FlowLayoutOverflowState r0, FlowLineMeasurePolicy r1, Placeable r2) {
        return setOverflowMeasurables__hBUhpc$lambda$5$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(FlowLayoutOverflowState r0, FlowLineMeasurePolicy r1, Placeable r2) {
        return setOverflowMeasurables__hBUhpc$lambda$9$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ FlowLayoutOverflowState copy$default(FlowLayoutOverflowState r0, FlowLayoutOverflow.OverflowType r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.minLinesToShowCollapse;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.minCrossAxisSizeToShowCollapse;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final FlowLayoutOverflow.OverflowType component1$foundation_layout() {
        return this.type;
    }

    public final int component2$foundation_layout() {
        return this.minLinesToShowCollapse;
    }

    public final int component3$foundation_layout() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final FlowLayoutOverflowState copy(FlowLayoutOverflow.OverflowType r2, int r3, int r4) {
        return new FlowLayoutOverflowState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowLayoutOverflowState) == true) goto L8;
        return false;
    L8:
        FlowLayoutOverflowState r6 = (FlowLayoutOverflowState) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (this.minLinesToShowCollapse == r6.minLinesToShowCollapse) goto L15;
        return false;
    L15:
        if (this.minCrossAxisSizeToShowCollapse == r6.minCrossAxisSizeToShowCollapse) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.minLinesToShowCollapse) * 31) + this.minCrossAxisSizeToShowCollapse;
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.type + ", minLinesToShowCollapse=" + this.minLinesToShowCollapse + ", minCrossAxisSizeToShowCollapse=" + this.minCrossAxisSizeToShowCollapse + ')';
    }

    public final int getShownItemCount$foundation_layout() {
        int r0 = this.itemShown;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(this.shownItemLazyErrorMessage);
    }

    public final int getItemCount$foundation_layout() {
        return this.itemCount;
    }

    public final int getItemShown$foundation_layout() {
        return this.itemShown;
    }

    public final int getMinCrossAxisSizeToShowCollapse$foundation_layout() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final int getMinLinesToShowCollapse$foundation_layout() {
        return this.minLinesToShowCollapse;
    }

    public final String getShownItemLazyErrorMessage$foundation_layout() {
        return this.shownItemLazyErrorMessage;
    }

    public final FlowLayoutOverflow.OverflowType getType$foundation_layout() {
        return this.type;
    }

    public final void setItemCount$foundation_layout(int r1) {
        this.itemCount = r1;
    }

    public final void setItemShown$foundation_layout(int r1) {
        this.itemShown = r1;
    }

    public FlowLayoutOverflowState(FlowLayoutOverflow.OverflowType r1, int r2, int r3) {
        this.type = r1;
        this.minLinesToShowCollapse = r2;
        this.minCrossAxisSizeToShowCollapse = r3;
        this.shownItemLazyErrorMessage = "Accessing shownItemCount before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.";
        this.itemShown = -1;
    }

    private static final Unit setOverflowMeasurables__hBUhpc$lambda$5$lambda$4(FlowLayoutOverflowState r2, FlowLineMeasurePolicy r3, Placeable r4) {
        if (r4 == null) goto L4;
        int r0 = r3.mainAxisSize(r4);
        int r5 = r3.crossAxisSize(r4);
    L5:
        r2.seeMoreSize = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r0, r5));
        r2.seeMorePlaceable = r4;
        return Unit.INSTANCE;
    L4:
        r0 = 0;
        r5 = 0;
        goto L5
    }

    private static final Unit setOverflowMeasurables__hBUhpc$lambda$9$lambda$8(FlowLayoutOverflowState r2, FlowLineMeasurePolicy r3, Placeable r4) {
        if (r4 == null) goto L4;
        int r0 = r3.mainAxisSize(r4);
        int r5 = r3.crossAxisSize(r4);
    L5:
        r2.collapseSize = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r0, r5));
        r2.collapsePlaceable = r4;
        return Unit.INSTANCE;
    L4:
        r0 = 0;
        r5 = 0;
        goto L5
    }

    public final FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout(boolean r12, int r13, int r14) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (r0 != 1) goto L5;
        return null;
    L5:
        if (r0 != 2) goto L7;
        return null;
    L7:
        if (r0 != 3) goto L9;
    L13:
        if (r12 == false) goto L23;
        Function2<? super Boolean, ? super Integer, ? extends Measurable> r15 = this.getOverflowMeasurable;
        if (r15 == null) goto L18;
        Measurable r16 = (Measurable) r15.invoke(Boolean.TRUE, Integer.valueOf(getShownItemCount$foundation_layout()));
        if (r16 == null) goto L18;
    L19:
        IntIntPair r17 = this.seeMoreSize;
        if (this.getOverflowMeasurable != null) goto L36;
        Placeable r18 = this.seeMorePlaceable;
    L35:
        Measurable r4 = r16;
        Placeable r5 = r18;
    L37:
        if (r4 != null) goto L39;
        return null;
    L39:
        Intrinsics.checkNotNull(r17);
        return new FlowLayoutBuildingBlocks.WrapEllipsisInfo(r4, r5, r17.m104unboximpl(), false, 8, null);
    L36:
        r4 = r16;
        r5 = null;
    L18:
        r16 = this.seeMoreMeasurable;
        goto L19
    L23:
        if (r13 >= (this.minLinesToShowCollapse - 1)) goto L25;
    L31:
        r16 = null;
    L32:
        r17 = this.collapseSize;
        if (this.getOverflowMeasurable != null) goto L36;
        r18 = this.collapsePlaceable;
        goto L35
    L25:
        if (r14 < this.minCrossAxisSizeToShowCollapse) goto L31;
        Function2<? super Boolean, ? super Integer, ? extends Measurable> r19 = this.getOverflowMeasurable;
        if (r19 == null) goto L30;
        r16 = (Measurable) r19.invoke(Boolean.FALSE, Integer.valueOf(getShownItemCount$foundation_layout()));
        if (r16 != null) goto L32;
    L30:
        r16 = this.collapseMeasurable;
        goto L32
    L9:
        if (r0 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: ellipsisSize-F35zm-w$foundation_layout, reason: not valid java name */
    public final IntIntPair m872ellipsisSizeF35zmw$foundation_layout(boolean r5, int r6, int r7) {
        FlowLayoutOverflow.OverflowType r0 = this.type;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        return null;
    L5:
        if (r1 != 2) goto L7;
        return null;
    L7:
        if (r1 != 3) goto L9;
        if (r5 == true) goto L21;
        return null;
    L21:
        return this.seeMoreSize;
    L9:
        if (r1 != 4) goto L18;
        if (r5 == false) goto L13;
        return this.seeMoreSize;
    L13:
        if ((r6 + 1) >= this.minLinesToShowCollapse) goto L15;
        return null;
    L15:
        if (r7 >= this.minCrossAxisSizeToShowCollapse) goto L27;
        return null;
    L27:
        return this.collapseSize;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: setOverflowMeasurables-VKLhPVY$foundation_layout, reason: not valid java name */
    public final void m875setOverflowMeasurablesVKLhPVY$foundation_layout(FlowLineMeasurePolicy r9, long r10, Function2<? super Boolean, ? super Integer, ? extends Measurable> r12) {
        this.itemShown = 0;
        this.getOverflowMeasurable = r12;
        m873setOverflowMeasurableshBUhpc$foundation_layout(r9, (Measurable) r12.invoke(Boolean.TRUE, 0), (Measurable) r12.invoke(Boolean.FALSE, 0), r10);
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout, reason: not valid java name */
    public final void m874setOverflowMeasurableshBUhpc$foundation_layout(IntrinsicMeasurable r4, IntrinsicMeasurable r5, boolean r6, long r7) {
        if (r6 == false) goto L4;
        LayoutOrientation r0 = LayoutOrientation.Horizontal;
    L5:
        long r8 = OrientationIndependentConstraints.m928constructorimpl(r7, r0);
        if (r4 == null) goto L12;
        int r1 = FlowLayoutKt.mainAxisMin(r4, r6, Constraints.getMaxHeight-impl(r8));
        this.seeMoreSize = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r1, FlowLayoutKt.crossAxisMin(r4, r6, r1)));
        if ((r4 instanceof Measurable) == false) goto L10;
        Measurable r9 = (Measurable) r4;
    L11:
        this.seeMoreMeasurable = r9;
        this.seeMorePlaceable = null;
        goto L12
    L10:
        r9 = null;
    L12:
        if (r5 == null) goto L19;
        int r10 = FlowLayoutKt.mainAxisMin(r5, r6, Constraints.getMaxHeight-impl(r8));
        this.collapseSize = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r10, FlowLayoutKt.crossAxisMin(r5, r6, r10)));
        if ((r5 instanceof Measurable) == false) goto L16;
        Measurable r11 = (Measurable) r5;
    L17:
        this.collapseMeasurable = r11;
        this.collapsePlaceable = null;
        return;
    L16:
        r11 = null;
        goto L17
    L19:
        return;
    L4:
        r0 = LayoutOrientation.Vertical;
        goto L5
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout, reason: not valid java name */
    public final void m873setOverflowMeasurableshBUhpc$foundation_layout(final FlowLineMeasurePolicy r10, Measurable r11, Measurable r12, long r13) {
        if (r10.isHorizontal() == false) goto L5;
        LayoutOrientation r0 = LayoutOrientation.Horizontal;
    L6:
        long r14 = OrientationIndependentConstraints.m941toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m930copyyUG9Ft0$default(OrientationIndependentConstraints.m928constructorimpl(r13, r0), 0, 0, 0, 0, 10, null), r0);
        if (r11 == null) goto L9;
        FlowLayoutKt.m868measureAndCacherqJ1uqs(r11, r10, r14, new r0(this, r10));
        this.seeMoreMeasurable = r11;
    L9:
        if (r12 == null) goto L12;
        FlowLayoutKt.m868measureAndCacherqJ1uqs(r12, r10, r14, new s0(this, r10));
        this.collapseMeasurable = r12;
        return;
    L12:
        return;
    L5:
        r0 = LayoutOrientation.Vertical;
        goto L6
    }
}
