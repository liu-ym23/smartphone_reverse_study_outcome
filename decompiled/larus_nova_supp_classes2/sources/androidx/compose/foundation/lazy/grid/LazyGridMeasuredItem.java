package androidx.compose.foundation.lazy.grid;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0017\u0010>\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J(\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0016J6\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020F2\u0006\u00100\u001a\u00020\u0004J\u0016\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\bJ\u0016\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\bJ(\u0010W\u001a\u00020\u0014*\u00020\u00142\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\"R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010'R\u0014\u0010\u001a\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0014\u0010\u001b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010*\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0014\u0010.\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001fR\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u000205X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b6\u0010'R \u00108\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014@RX\u0096\u000e¢\u0006\n\n\u0002\u0010$\u001a\u0004\b9\u0010'R\u001e\u0010:\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001fR\u001e\u0010<\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001fR\u001a\u0010A\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010DR\u0018\u0010S\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0018\u0010*\u001a\u00020\u0004*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010V¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "<init>", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getCrossAxisSize", "J", "getContentType", "getConstraints-msEJaDk", "()J", "getLane", "getSpan", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "placeablesCount", "getPlaceablesCount", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "getParentData", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "offset", "getOffset-nOcc-ac", "row", "getRow", "column", "getColumn", "getOffset", "getOffset-Bjo55l4", "(I)J", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int r1, Object r2, boolean r3, int r4, int r5, boolean r6, LayoutDirection r7, int r8, int r9, List r10, long r11, Object r13, LazyLayoutItemAnimator r14, long r15, int r17, int r18, DefaultConstructorMarker r19) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r17, r18);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo1092getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo1117getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo1118getSizeYbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1123getMainAxisgyyYBs(long r2) {
        if (isVertical() == false) goto L6;
        return IntOffset.getY-impl(r2);
    L6:
        return IntOffset.getX-impl(r2);
    }

    private final int getMainAxisSize(Placeable r2) {
        if (isVertical() == false) goto L6;
        return r2.getHeight();
    L6:
        return r2.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public long mo1093getOffsetBjo55l4(int r3) {
        return mo1117getOffsetnOccac();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int r2) {
        return ((Placeable) ListProtector.get(this.placeables, r2)).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean r1) {
        this.nonScrollableItem = r1;
    }

    public final void updateMainAxisLayoutSize(int r2) {
        this.mainAxisLayoutSize = r2;
        this.maxMainAxisOffset = r2 + this.afterContentPadding;
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1122copy4Tuh3kE(long r5, Function1<? super Integer, Integer> r7) {
        if (isVertical() == false) goto L5;
        int r0 = IntOffset.getX-impl(r5);
    L6:
        boolean r1 = isVertical();
        int r6 = IntOffset.getY-impl(r5);
        if (r1 == false) goto L10;
        r6 = ((Number) r7.invoke(Integer.valueOf(r6))).intValue();
    L10:
        return IntOffset.constructor-impl((((long) r0) << 32) | (((long) r6) & 4294967295L));
    L5:
        r0 = ((Number) r7.invoke(Integer.valueOf(IntOffset.getX-impl(r5)))).intValue();
        goto L6
    }

    public final void applyScrollDelta(int r11, boolean r12) {
        if (getNonScrollableItem() == false) goto L5;
        return;
    L5:
        long r0 = mo1117getOffsetnOccac();
        if (isVertical() == false) goto L8;
        int r2 = IntOffset.getX-impl(r0);
    L9:
        boolean r3 = isVertical();
        int r1 = IntOffset.getY-impl(r0);
        if (r3 == false) goto L12;
        r1 = r1 + r11;
    L12:
        this.offset = IntOffset.constructor-impl((((long) r2) << 32) | (((long) r1) & 4294967295L));
        if (r12 == false) goto L27;
        int r13 = getPlaceablesCount();
        int r4 = 0;
    L15:
        if (r4 >= r13) goto L31;
        LazyLayoutItemAnimation r5 = this.animator.getAnimation(getKey(), r4);
        if (r5 == null) goto L26;
        long r6 = r5.m1147getRawOffsetnOccac();
        if (isVertical() == false) goto L21;
        int r7 = IntOffset.getX-impl(r6);
    L22:
        boolean r8 = isVertical();
        int r9 = IntOffset.getY-impl(r6);
        if (r8 == false) goto L25;
        r9 = Integer.valueOf(r9 + r11).intValue();
    L25:
        long r10 = ((long) r9) & 4294967295L;
        r5.m1150setRawOffsetgyyYBs(IntOffset.constructor-impl(r10 | (((long) r7) << 32)));
        goto L26
    L21:
        r7 = Integer.valueOf(IntOffset.getX-impl(r6) + r11).intValue();
    L26:
        r4 = r4 + 1;
        goto L15
    L31:
        return;
    L27:
        return;
    L8:
        r2 = IntOffset.getX-impl(r0) + r11;
        goto L9
    }

    public final void place(Placeable.PlacementScope r13, boolean r14) {
        int r2 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        int r1 = getPlaceablesCount();
    L9:
        if (r2 >= r1) goto L54;
        Placeable r4 = (Placeable) ListProtector.get(this.placeables, r2);
        int r3 = this.minMainAxisOffset - getMainAxisSize(r4);
        int r5 = this.maxMainAxisOffset;
        long r6 = mo1117getOffsetnOccac();
        LazyLayoutItemAnimation r7 = this.animator.getAnimation(getKey(), r2);
        if (r7 == null) goto L29;
        if (r14 == false) goto L15;
        r7.m1149setLookaheadOffsetgyyYBs(r6);
    L28:
        GraphicsLayer r8 = r7.getLayer();
    L31:
        if (this.reverseLayout == true) goto L33;
    L41:
        long r9 = IntOffset.plus-qkQi6aY(r6, this.visualOffset);
        if (r14 == true) goto L46;
        if (r7 == null) goto L46;
        r7.m1148setFinalOffsetgyyYBs(r9);
    L46:
        if (isVertical() == false) goto L50;
        if (r8 == null) goto L49;
        Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(r13, r4, r9, r8, MenuKt.ClosedAlphaTarget, 4, null);
    L53:
        r2 = r2 + 1;
        goto L9
    L49:
        Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(r13, r4, r9, MenuKt.ClosedAlphaTarget, null, 6, null);
        goto L53
    L50:
        if (r8 == null) goto L52;
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r13, r4, r9, r8, MenuKt.ClosedAlphaTarget, 4, null);
        goto L53
    L52:
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r13, r4, r9, MenuKt.ClosedAlphaTarget, null, 6, null);
        goto L53
    L33:
        if (isVertical() == false) goto L35;
        int r10 = IntOffset.getX-impl(r6);
    L37:
        if (isVertical() == false) goto L39;
        int r11 = IntOffset.getY-impl(r6);
        int r12 = (this.mainAxisLayoutSize - r11) - getMainAxisSize(r4);
    L40:
        long r15 = ((long) r12) & 4294967295L;
        r6 = IntOffset.constructor-impl(r15 | (((long) r10) << 32));
        goto L41
    L39:
        r12 = IntOffset.getY-impl(r6);
        goto L40
    L35:
        int r16 = IntOffset.getX-impl(r6);
        r10 = (this.mainAxisLayoutSize - r16) - getMainAxisSize(r4);
        goto L37
    L15:
        if (IntOffset.equals-impl0(r7.m1145getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m1151getNotInitializednOccac()) == true) goto L17;
        long r17 = r7.m1145getLookaheadOffsetnOccac();
    L18:
        long r18 = IntOffset.plus-qkQi6aY(r17, r7.m1146getPlacementDeltanOccac());
        if (m1123getMainAxisgyyYBs(r6) > r3) goto L23;
        if (m1123getMainAxisgyyYBs(r18) > r3) goto L23;
    L26:
        r7.cancelPlacementAnimation();
    L27:
        r6 = r18;
    L23:
        if (m1123getMainAxisgyyYBs(r6) < r5) goto L27;
        if (m1123getMainAxisgyyYBs(r18) < r5) goto L27;
    L17:
        r17 = r6;
        goto L18
    L29:
        r8 = null;
        goto L31
    L54:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int r8, int r9, int r10, int r11) {
        position(r8, r9, r10, r11, -1, -1);
    }

    public final void position(int r5, int r6, int r7, int r8, int r9, int r10) {
        if (isVertical() == false) goto L5;
        int r0 = r8;
    L6:
        this.mainAxisLayoutSize = r0;
        if (isVertical() == true) goto L11;
        r7 = r8;
    L11:
        if (isVertical() == false) goto L16;
        if (this.layoutDirection != LayoutDirection.Rtl) goto L16;
        r6 = (r7 - r6) - this.crossAxisSize;
    L16:
        if (isVertical() == false) goto L18;
        long r11 = IntOffset.constructor-impl((((long) r6) << 32) | (4294967295L & ((long) r5)));
    L19:
        this.offset = r11;
        this.row = r9;
        this.column = r10;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
        return;
    L18:
        long r12 = ((long) r5) << 32;
        r11 = IntOffset.constructor-impl((((long) r6) & 4294967295L) | r12);
        goto L19
    L5:
        r0 = r7;
        goto L6
    }

    private LazyGridMeasuredItem(int r9, Object r10, boolean r11, int r12, int r13, boolean r14, LayoutDirection r15, int r16, int r17, List<? extends Placeable> r18, long r19, Object r21, LazyLayoutItemAnimator<LazyGridMeasuredItem> r22, long r23, int r25, int r26) {
        this.index = r9;
        this.key = r10;
        this.isVertical = r11;
        this.crossAxisSize = r12;
        this.reverseLayout = r14;
        this.layoutDirection = r15;
        this.beforeContentPadding = r16;
        this.afterContentPadding = r17;
        this.placeables = r18;
        this.visualOffset = r19;
        this.contentType = r21;
        this.animator = r22;
        this.constraints = r23;
        this.lane = r25;
        this.span = r26;
        this.mainAxisLayoutSize = RtlSpacingHelper.UNDEFINED;
        int r2 = r18.size();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L9;
        Placeable r6 = (Placeable) ListProtector.get(r18, r4);
        if (isVertical() == false) goto L7;
        int r7 = r6.getHeight();
    L8:
        r5 = Math.max(r5, r7);
        r4 = r4 + 1;
        goto L3
    L7:
        r7 = r6.getWidth();
        goto L8
    L9:
        this.mainAxisSize = r5;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(r5 + r13, 0);
        if (isVertical() == false) goto L12;
        long r8 = ((long) this.crossAxisSize) << 32;
        long r1 = IntSize.constructor-impl((((long) r5) & 4294967295L) | r8);
    L13:
        this.size = r1;
        this.offset = IntOffset.Companion.getZero-nOcc-ac();
        this.row = -1;
        this.column = -1;
        return;
    L12:
        long r3 = ((long) this.crossAxisSize) & 4294967295L;
        r1 = IntSize.constructor-impl(r3 | (((long) r5) << 32));
        goto L13
    }
}
