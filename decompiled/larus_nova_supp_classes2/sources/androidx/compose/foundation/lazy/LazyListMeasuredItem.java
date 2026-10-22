package androidx.compose.foundation.lazy;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010@\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J(\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J\u001e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020B2\u0006\u00109\u001a\u00020\u0004J\u0017\u0010*\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010IJ\u0016\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\tJ\u0016\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\tJ(\u0010W\u001a\u00020\u0015*\u00020\u00152\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010!R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0014\u0010-\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0014\u0010/\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0014\u00101\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u001a\u00105\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010 R\u0018\u0010Q\u001a\u00020\u0004*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0018\u0010T\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "()Z", "J", "getKey", "()Ljava/lang/Object;", "getContentType", "getConstraints-msEJaDk", "()J", "value", "offset", "getOffset", "size", "getSize", "lane", "getLane", "span", "getSpan", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "getParentData", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "getOffset-Bjo55l4", "(I)J", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int r1, List r2, boolean r3, Alignment.Horizontal r4, Alignment.Vertical r5, LayoutDirection r6, boolean r7, int r8, int r9, int r10, long r11, Object r13, Object r14, LazyLayoutItemAnimator r15, long r16, DefaultConstructorMarker r18) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public long mo1092getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1091getMainAxisgyyYBs(long r2) {
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
    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo1093getOffsetBjo55l4(int r7) {
        if (r7 == 0) goto L5;
    L11:
        int[] r3 = this.placeableOffsets;
        int r8 = r7 * 2;
        int r4 = r3[r8];
        int r9 = r3[r8 + 1];
        long r2 = ((long) r4) << 32;
        return IntOffset.constructor-impl((4294967295L & ((long) r9)) | r2);
    L5:
        if (getPlaceablesCount() != 0) goto L11;
        if (isVertical() == false) goto L9;
        long r0 = 4294967295L & ((long) getOffset());
        long r1 = r0 | (((long) 0) << 32);
    L13:
        return IntOffset.constructor-impl(r1);
    L9:
        long r5 = 4294967295L & ((long) 0);
        r1 = r5 | (((long) getOffset()) << 32);
        goto L13
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
    private final long m1090copy4Tuh3kE(long r6, Function1<? super Integer, Integer> r8) {
        if (isVertical() == false) goto L5;
        int r0 = IntOffset.getX-impl(r6);
        int r7 = ((Number) r8.invoke(Integer.valueOf(IntOffset.getY-impl(r6)))).intValue();
        long r9 = r0;
    L7:
        return IntOffset.constructor-impl((r9 << 32) | (((long) r7) & 4294967295L));
    L5:
        int r10 = ((Number) r8.invoke(Integer.valueOf(IntOffset.getX-impl(r6)))).intValue();
        r7 = IntOffset.getY-impl(r6);
        r9 = r10;
        goto L7
    }

    public final void applyScrollDelta(int r10, boolean r11) {
        if (getNonScrollableItem() == false) goto L5;
        return;
    L5:
        this.offset = getOffset() + r10;
        int r0 = this.placeableOffsets.length;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L15;
        int r3 = r2 & 1;
        if (isVertical() == false) goto L11;
        if (r3 == 0) goto L11;
    L13:
        int[] r4 = this.placeableOffsets;
        r4[r2] = r4[r2] + r10;
    L14:
        r2 = r2 + 1;
    L11:
        if (isVertical() == true) goto L14;
        if (r3 != 0) goto L14;
    L15:
        if (r11 == false) goto L26;
        int r12 = getPlaceablesCount();
    L17:
        if (r1 >= r12) goto L34;
        LazyLayoutItemAnimation r5 = this.animator.getAnimation(getKey(), r1);
        if (r5 == null) goto L25;
        long r6 = r5.m1147getRawOffsetnOccac();
        if (isVertical() == false) goto L23;
        int r7 = IntOffset.getX-impl(r6);
        int r8 = Integer.valueOf(IntOffset.getY-impl(r6) + r10).intValue();
    L24:
        r5.m1150setRawOffsetgyyYBs(IntOffset.constructor-impl((((long) r7) << 32) | (4294967295L & ((long) r8))));
        goto L25
    L23:
        r7 = Integer.valueOf(IntOffset.getX-impl(r6) + r10).intValue();
        r8 = IntOffset.getY-impl(r6);
    L25:
        r1 = r1 + 1;
        goto L17
    L34:
        return;
    }

    public final void place(Placeable.PlacementScope r14, boolean r15) {
        int r2 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        int r1 = getPlaceablesCount();
    L9:
        if (r2 >= r1) goto L49;
        Placeable r4 = (Placeable) ListProtector.get(this.placeables, r2);
        int r3 = this.minMainAxisOffset - getMainAxisSize(r4);
        int r5 = this.maxMainAxisOffset;
        long r6 = mo1093getOffsetBjo55l4(r2);
        LazyLayoutItemAnimation r7 = this.animator.getAnimation(getKey(), r2);
        if (r7 == null) goto L28;
        if (r15 == false) goto L15;
        r7.m1149setLookaheadOffsetgyyYBs(r6);
    L27:
        GraphicsLayer r8 = r7.getLayer();
    L30:
        if (this.reverseLayout == true) goto L32;
    L36:
        long r9 = IntOffset.plus-qkQi6aY(r6, this.visualOffset);
        if (r15 == true) goto L41;
        if (r7 == null) goto L41;
        r7.m1148setFinalOffsetgyyYBs(r9);
    L41:
        if (isVertical() == false) goto L45;
        if (r8 == null) goto L44;
        Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(r14, r4, r9, r8, MenuKt.ClosedAlphaTarget, 4, null);
    L48:
        r2 = r2 + 1;
        goto L9
    L44:
        Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(r14, r4, r9, MenuKt.ClosedAlphaTarget, null, 6, null);
        goto L48
    L45:
        if (r8 == null) goto L47;
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r14, r4, r9, r8, MenuKt.ClosedAlphaTarget, 4, null);
        goto L48
    L47:
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r14, r4, r9, MenuKt.ClosedAlphaTarget, null, 6, null);
        goto L48
    L32:
        if (isVertical() == false) goto L34;
        int r10 = IntOffset.getX-impl(r6);
        int r11 = IntOffset.getY-impl(r6);
        long r12 = ((long) ((this.mainAxisLayoutSize - r11) - getMainAxisSize(r4))) & 4294967295L;
        long r13 = r12 | (((long) r10) << 32);
    L35:
        r6 = IntOffset.constructor-impl(r13);
        goto L36
    L34:
        int r16 = IntOffset.getX-impl(r6);
        int r17 = (this.mainAxisLayoutSize - r16) - getMainAxisSize(r4);
        int r18 = IntOffset.getY-impl(r6);
        r13 = (((long) r17) << 32) | (4294967295L & ((long) r18));
        goto L35
    L15:
        if (IntOffset.equals-impl0(r7.m1145getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m1151getNotInitializednOccac()) == true) goto L17;
        r6 = r7.m1145getLookaheadOffsetnOccac();
    L17:
        long r19 = IntOffset.plus-qkQi6aY(r6, r7.m1146getPlacementDeltanOccac());
        if (m1091getMainAxisgyyYBs(r6) > r3) goto L22;
        if (m1091getMainAxisgyyYBs(r19) > r3) goto L22;
    L25:
        r7.cancelPlacementAnimation();
    L26:
        r6 = r19;
    L22:
        if (m1091getMainAxisgyyYBs(r6) < r5) goto L26;
        if (m1091getMainAxisgyyYBs(r19) < r5) goto L26;
    L28:
        r8 = null;
        goto L30
    L49:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void position(int r10, int r11, int r12) {
        this.offset = r10;
        if (isVertical() == false) goto L5;
        int r0 = r12;
    L6:
        this.mainAxisLayoutSize = r0;
        List<Placeable> r1 = this.placeables;
        int r2 = r1.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L21;
        Placeable r4 = (Placeable) ListProtector.get(r1, r3);
        int r5 = r3 * 2;
        if (isVertical() == false) goto L15;
        int[] r6 = this.placeableOffsets;
        Alignment.Horizontal r7 = this.horizontalAlignment;
        if (r7 == null) goto L13;
        r6[r5] = r7.align(r4.getWidth(), r11, this.layoutDirection);
        this.placeableOffsets[r5 + 1] = r10;
        int r8 = r4.getHeight();
    L18:
        r10 = r10 + r8;
        r3 = r3 + 1;
        goto L7
    L13:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == true");
        throw new KotlinNothingValueException();
    L15:
        int[] r9 = this.placeableOffsets;
        r9[r5] = r10;
        int r13 = r5 + 1;
        Alignment.Vertical r14 = this.verticalAlignment;
        if (r14 == null) goto L19;
        r9[r13] = r14.align(r4.getHeight(), r12);
        r8 = r4.getWidth();
        goto L18
    L19:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment when isVertical == false");
        throw new KotlinNothingValueException();
    L21:
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
        return;
    L5:
        r0 = r11;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int r1, int r2, int r3, int r4) {
        position(r1, r3, r4);
    }

    private LazyListMeasuredItem(int r10, List<? extends Placeable> r11, boolean r12, Alignment.Horizontal r13, Alignment.Vertical r14, LayoutDirection r15, boolean r16, int r17, int r18, int r19, long r20, Object r22, Object r23, LazyLayoutItemAnimator<LazyListMeasuredItem> r24, long r25) {
        this.index = r10;
        this.placeables = r11;
        this.isVertical = r12;
        this.horizontalAlignment = r13;
        this.verticalAlignment = r14;
        this.layoutDirection = r15;
        this.reverseLayout = r16;
        this.beforeContentPadding = r17;
        this.afterContentPadding = r18;
        this.spacing = r19;
        this.visualOffset = r20;
        this.key = r22;
        this.contentType = r23;
        this.animator = r24;
        this.constraints = r25;
        this.span = 1;
        this.mainAxisLayoutSize = RtlSpacingHelper.UNDEFINED;
        int r2 = r11.size();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r4 >= r2) goto L13;
        Placeable r7 = (Placeable) ListProtector.get(r11, r4);
        if (isVertical() == false) goto L7;
        int r8 = r7.getHeight();
    L8:
        r5 = r5 + r8;
        if (isVertical() == true) goto L11;
        int r9 = r7.getHeight();
    L12:
        r6 = Math.max(r6, r9);
        r4 = r4 + 1;
        goto L3
    L11:
        r9 = r7.getWidth();
        goto L12
    L7:
        r8 = r7.getWidth();
        goto L8
    L13:
        this.size = r5;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = r6;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }
}
