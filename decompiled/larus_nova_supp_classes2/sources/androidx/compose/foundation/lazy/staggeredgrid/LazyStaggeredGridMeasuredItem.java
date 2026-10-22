package androidx.compose.foundation.lazy.staggeredgrid;

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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0017\u0010<\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J\u001e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J(\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J\u001e\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u000bJ\u000e\u0010N\u001a\u00020@2\u0006\u0010/\u001a\u00020\u0004J\u0016\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u000bJ(\u0010U\u001a\u000209*\u0002092\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040WH\u0082\b¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020[H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010%R\u0016\u00105\u001a\u000206X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b7\u0010!R \u0010:\u001a\u0002092\u0006\u00108\u001a\u000209@RX\u0096\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b;\u0010!R\u0011\u0010C\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u0018\u0010A\u001a\u00020\u0004*\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010T¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getLane", "getSpan", "getContentType", "getConstraints-msEJaDk", "()J", "J", "isVisible", "setVisible", "(Z)V", "placeablesCount", "getPlaceablesCount", "getParentData", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "getOffset", "getOffset-Bjo55l4", "(I)J", "position", "", "mainAxis", "crossAxis", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "getMainAxisOffset", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "isLookingAhead", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int r1, Object r2, List r3, boolean r4, int r5, int r6, int r7, int r8, int r9, Object r10, LazyLayoutItemAnimator r11, long r12, DefaultConstructorMarker r14) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final int getMainAxisOffset() {
        if (isVertical() == true) goto L6;
        return IntOffset.getX-impl(mo1213getOffsetnOccac());
    L6:
        return IntOffset.getY-impl(mo1213getOffsetnOccac());
    }

    public String toString() {
        return super.toString();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo1092getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
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

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo1213getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo1214getSizeYbymL2g() {
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

    public final boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1232getMainAxisgyyYBs(long r2) {
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
        return mo1213getOffsetnOccac();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int r2) {
        return ((Placeable) ListProtector.get(this.placeables, r2)).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean r1) {
        this.nonScrollableItem = r1;
    }

    public final void setVisible(boolean r1) {
        this.isVisible = r1;
    }

    public final void updateMainAxisLayoutSize(int r2) {
        this.mainAxisLayoutSize = r2;
        this.maxMainAxisOffset = r2 + this.afterContentPadding;
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1231copy4Tuh3kE(long r5, Function1<? super Integer, Integer> r7) {
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
        long r0 = mo1213getOffsetnOccac();
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

    public final void place(Placeable.PlacementScope r15, LazyStaggeredGridMeasureContext r16, boolean r17) {
        int r3 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        List<Placeable> r2 = this.placeables;
        int r4 = r2.size();
    L9:
        if (r3 >= r4) goto L61;
        Placeable r6 = (Placeable) ListProtector.get(r2, r3);
        int r5 = this.minMainAxisOffset;
        if (isVertical() == false) goto L13;
        int r7 = r6.getHeight();
    L14:
        int r8 = r5 - r7;
        int r9 = this.maxMainAxisOffset;
        long r10 = mo1213getOffsetnOccac();
        LazyLayoutItemAnimation r11 = this.animator.getAnimation(getKey(), r3);
        if (r11 == null) goto L33;
        if (r17 == false) goto L19;
        r11.m1149setLookaheadOffsetgyyYBs(r10);
    L32:
        GraphicsLayer r12 = r11.getLayer();
    L35:
        if (r16.getReverseLayout() == true) goto L37;
    L53:
        long r13 = IntOffset.plus-qkQi6aY(r10, r16.m1220getContentOffsetnOccac());
        if (r17 == true) goto L57;
        if (r11 == null) goto L57;
        r11.m1148setFinalOffsetgyyYBs(r13);
    L57:
        if (r12 == null) goto L59;
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r15, r6, r13, r12, MenuKt.ClosedAlphaTarget, 4, null);
    L60:
        r3 = r3 + 1;
        goto L9
    L59:
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r15, r6, r13, MenuKt.ClosedAlphaTarget, null, 6, null);
        goto L60
    L37:
        if (isVertical() == false) goto L39;
        int r14 = IntOffset.getX-impl(r10);
    L45:
        if (isVertical() == false) goto L51;
        int r18 = IntOffset.getY-impl(r10);
        int r19 = this.mainAxisLayoutSize - r18;
        if (isVertical() == false) goto L49;
        int r20 = r6.getHeight();
    L50:
        int r21 = r19 - r20;
    L52:
        long r22 = ((long) r21) & 4294967295L;
        r10 = IntOffset.constructor-impl(r22 | (((long) r14) << 32));
        goto L53
    L49:
        r20 = r6.getWidth();
        goto L50
    L51:
        r21 = IntOffset.getY-impl(r10);
        goto L52
    L39:
        int r23 = IntOffset.getX-impl(r10);
        int r110 = this.mainAxisLayoutSize - r23;
        if (isVertical() == false) goto L42;
        int r24 = r6.getHeight();
    L43:
        r14 = r110 - r24;
        goto L45
    L42:
        r24 = r6.getWidth();
        goto L43
    L19:
        if (IntOffset.equals-impl0(r11.m1145getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m1151getNotInitializednOccac()) == true) goto L21;
        long r111 = r11.m1145getLookaheadOffsetnOccac();
    L22:
        long r112 = IntOffset.plus-qkQi6aY(r111, r11.m1146getPlacementDeltanOccac());
        if (m1232getMainAxisgyyYBs(r10) > r8) goto L27;
        if (m1232getMainAxisgyyYBs(r112) > r8) goto L27;
    L30:
        r11.cancelPlacementAnimation();
    L31:
        r10 = r112;
    L27:
        if (m1232getMainAxisgyyYBs(r10) < r9) goto L31;
        if (m1232getMainAxisgyyYBs(r112) < r9) goto L31;
    L21:
        r111 = r10;
        goto L22
    L33:
        r12 = null;
        goto L35
    L13:
        r7 = r6.getWidth();
        goto L14
    L61:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void position(int r6, int r7, int r8) {
        this.mainAxisLayoutSize = r8;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = r8 + this.afterContentPadding;
        if (isVertical() == false) goto L5;
        long r9 = IntOffset.constructor-impl((((long) r7) << 32) | (4294967295L & ((long) r6)));
    L6:
        this.offset = r9;
        return;
    L5:
        long r2 = ((long) r6) << 32;
        r9 = IntOffset.constructor-impl((((long) r7) & 4294967295L) | r2);
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int r2, int r3, int r4, int r5) {
        if (isVertical() == false) goto L5;
        r4 = r5;
    L5:
        position(r2, r3, r4);
    }

    private LazyStaggeredGridMeasuredItem(int r1, Object r2, List<? extends Placeable> r3, boolean r4, int r5, int r6, int r7, int r8, int r9, Object r10, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> r11, long r12) {
        this.index = r1;
        this.key = r2;
        this.placeables = r3;
        this.isVertical = r4;
        this.lane = r6;
        this.span = r7;
        this.beforeContentPadding = r8;
        this.afterContentPadding = r9;
        this.contentType = r10;
        this.animator = r11;
        this.constraints = r12;
        int r13 = 1;
        this.isVisible = true;
        int r14 = 0;
        if (r3.isEmpty() == false) goto L5;
        int r15 = 0;
    L20:
        this.mainAxisSize = r15;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(r15 + r5, 0);
        List<Placeable> r16 = this.placeables;
        if (r16.isEmpty() == true) goto L38;
        Placeable r17 = (Placeable) ListProtector.get(r16, 0);
        if (isVertical() == false) goto L26;
        int r18 = r17.getWidth();
    L27:
        int r19 = CollectionsKt.getLastIndex(r16);
        if (1 > r19) goto L37;
    L29:
        Placeable r20 = (Placeable) ListProtector.get(r16, r13);
        if (isVertical() == false) goto L32;
        int r21 = r20.getWidth();
    L33:
        if (r21 <= r18) goto L35;
        r18 = r21;
    L35:
        if (r13 == r19) goto L37;
        r13 = r13 + 1;
        goto L29
    L32:
        r21 = r20.getHeight();
    L37:
        r14 = r18;
        goto L38
    L26:
        r18 = r17.getHeight();
    L38:
        this.crossAxisSize = r14;
        this.mainAxisLayoutSize = RtlSpacingHelper.UNDEFINED;
        if (isVertical() == false) goto L41;
        long r22 = ((long) r14) << 32;
        long r23 = IntSize.constructor-impl((((long) this.mainAxisSize) & 4294967295L) | r22);
    L42:
        this.size = r23;
        this.offset = IntOffset.Companion.getZero-nOcc-ac();
        return;
    L41:
        long r24 = ((long) this.mainAxisSize) << 32;
        r23 = IntSize.constructor-impl((((long) r14) & 4294967295L) | r24);
        goto L42
    L5:
        Placeable r25 = (Placeable) ListProtector.get(r3, 0);
        if (isVertical() == false) goto L8;
        r15 = r25.getHeight();
    L9:
        int r26 = CollectionsKt.getLastIndex(r3);
        if (1 > r26) goto L20;
        int r27 = 1;
    L12:
        Placeable r28 = (Placeable) ListProtector.get(r3, r27);
        if (isVertical() == false) goto L15;
        int r29 = r28.getHeight();
    L16:
        if (r29 <= r15) goto L18;
        r15 = r29;
    L18:
        if (r27 == r26) goto L20;
        r27 = r27 + 1;
        goto L12
    L15:
        r29 = r28.getWidth();
        goto L16
    L8:
        r15 = r25.getWidth();
        goto L9
    }
}
