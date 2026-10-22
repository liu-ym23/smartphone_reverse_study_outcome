package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002#$B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003JW\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", "", "maxItemsInMainAxis", "", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "maxLines", "mainAxisSpacing", "crossAxisSpacing", "<init>", "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getWrapEllipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "wrapInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "hasNext", "", "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "getWrapInfo", "nextItemHasNext", "leftOver", "Landroidx/collection/IntIntPair;", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "WrapInfo", "WrapEllipsisInfo", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutBuildingBlocks {
    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "", "ellipsis", "Landroidx/compose/ui/layout/Measurable;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "ellipsisSize", "Landroidx/collection/IntIntPair;", "placeEllipsisOnLastContentLine", "", "<init>", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "getEllipsisSize-OO21N7I", "()J", "J", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WrapEllipsisInfo {
        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        public /* synthetic */ WrapEllipsisInfo(Measurable r1, Placeable r2, long r3, boolean r5, DefaultConstructorMarker r6) {
            this(r1, r2, r3, r5);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        /* JADX INFO: renamed from: getEllipsisSize-OO21N7I, reason: not valid java name */
        public final long m866getEllipsisSizeOO21N7I() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean r1) {
            this.placeEllipsisOnLastContentLine = r1;
        }

        private WrapEllipsisInfo(Measurable r1, Placeable r2, long r3, boolean r5) {
            this.ellipsis = r1;
            this.placeable = r2;
            this.ellipsisSize = r3;
            this.placeEllipsisOnLastContentLine = r5;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable r8, Placeable r9, long r10, boolean r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 8) == 0) goto L5;
            boolean r5 = true;
        L6:
            this(r8, r9, r10, r5, null);
            return;
        L5:
            r5 = r12;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "", "isLastItemInLine", "", "isLastItemInContainer", "<init>", "(ZZ)V", "()Z", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WrapInfo {
        public static final int $stable = 0;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        public WrapInfo() {
            boolean r2 = false;
            this(r2, r2, 3, null);
        }

        public final boolean isLastItemInContainer() {
            return this.isLastItemInContainer;
        }

        public final boolean isLastItemInLine() {
            return this.isLastItemInLine;
        }

        public WrapInfo(boolean r1, boolean r2) {
            this.isLastItemInLine = r1;
            this.isLastItemInContainer = r2;
        }

        public /* synthetic */ WrapInfo(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = false;
        L8:
            this(r2, r3);
        }
    }

    public /* synthetic */ FlowLayoutBuildingBlocks(int r1, FlowLayoutOverflowState r2, long r3, int r5, int r6, int r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r5, r6, r7);
    }

    private FlowLayoutBuildingBlocks(int r1, FlowLayoutOverflowState r2, long r3, int r5, int r6, int r7) {
        this.maxItemsInMainAxis = r1;
        this.overflow = r2;
        this.constraints = r3;
        this.maxLines = r5;
        this.mainAxisSpacing = r6;
        this.crossAxisSpacing = r7;
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo r2, boolean r3, int r4, int r5, int r6, int r7) {
        if (r2.isLastItemInContainer() == true) goto L5;
        return null;
    L5:
        WrapEllipsisInfo r8 = this.overflow.ellipsisInfo$foundation_layout(r3, r4, r5);
        if (r8 != null) goto L8;
        return null;
    L8:
        if (r4 < 0) goto L15;
        if (r7 != 0) goto L11;
    L14:
        boolean r9 = true;
    L16:
        r8.setPlaceEllipsisOnLastContentLine(r9);
        return r8;
    L11:
        if ((r6 - IntIntPair.m100getFirstimpl(r8.m866getEllipsisSizeOO21N7I())) < 0) goto L15;
        if (r7 < this.maxItemsInMainAxis) goto L14;
    L15:
        r9 = false;
        goto L16
    }

    /* JADX INFO: renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    public final WrapInfo m865getWrapInfoOpUlnko(boolean r16, int r17, long r18, IntIntPair r20, int r21, int r22, int r23, boolean r24, boolean r25) {
        int r7 = r22 + r23;
        if (r20 != null) goto L7;
        return new WrapInfo(true, true);
    L7:
        if (this.overflow.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.Visible) goto L10;
    L8:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L17;
        if (r17 != 0) goto L21;
    L19:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L32;
        if (r24 == false) goto L31;
        return new WrapInfo(true, true);
    L31:
        return new WrapInfo(true, m865getWrapInfoOpUlnko(r16, 0, IntIntPair.m96constructorimpl(Constraints.getMaxWidth-impl(this.constraints), (IntIntPair.m101getSecondimpl(r18) - this.crossAxisSpacing) - r23), IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(IntIntPair.m100getFirstimpl(r20.m104unboximpl()) - this.mainAxisSpacing, IntIntPair.m101getSecondimpl(r20.m104unboximpl()))), r21 + 1, r7, 0, true, false).isLastItemInContainer());
    L32:
        int r8 = r22 + Math.max(r23, IntIntPair.m101getSecondimpl(r20.m104unboximpl()));
        if (r25 == false) goto L35;
        IntIntPair r5 = null;
    L36:
        IntIntPair r6 = r5;
        if (r6 == null) goto L44;
        r6.m104unboximpl();
        if ((r17 + 1) < this.maxItemsInMainAxis) goto L42;
    L40:
        boolean r0 = true;
    L45:
        if (r0 == false) goto L52;
        if (r25 == true) goto L48;
        WrapInfo r1 = m865getWrapInfoOpUlnko(false, 0, IntIntPair.m96constructorimpl(Constraints.getMaxWidth-impl(this.constraints), (IntIntPair.m101getSecondimpl(r18) - this.crossAxisSpacing) - Math.max(r23, IntIntPair.m101getSecondimpl(r20.m104unboximpl()))), r6, r21 + 1, r8, 0, true, true);
        return new WrapInfo(r1.isLastItemInContainer(), r1.isLastItemInContainer());
    L48:
        return new WrapInfo(true, true);
    L52:
        return new WrapInfo(false, false);
    L42:
        if ((((IntIntPair.m100getFirstimpl(r18) - IntIntPair.m100getFirstimpl(r20.m104unboximpl())) - this.mainAxisSpacing) - IntIntPair.m100getFirstimpl(r6.m104unboximpl())) < 0) goto L40;
    L44:
        r0 = false;
        goto L45
    L35:
        r5 = this.overflow.m872ellipsisSizeF35zmw$foundation_layout(r16, r21, r8);
        goto L36
    L21:
        if (r17 < this.maxItemsInMainAxis) goto L24;
    L22:
        r4 = true;
        goto L26
    L24:
        if ((IntIntPair.m100getFirstimpl(r18) - IntIntPair.m100getFirstimpl(r20.m104unboximpl())) >= 0) goto L19;
    L17:
        return new WrapInfo(true, true);
    L10:
        if (r21 < this.maxLines) goto L13;
    L11:
        r3 = true;
        goto L15
    L13:
        if ((IntIntPair.m101getSecondimpl(r18) - IntIntPair.m101getSecondimpl(r20.m104unboximpl())) >= 0) goto L8;
        goto L8
    }
}
