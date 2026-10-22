package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/BaseHeadPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseHeadPagerSnapHelper extends PagerSnapHelper {
    public OrientationHelper a;
    public OrientationHelper b;
    public final s c;

    public static final class a {
    }

    static {
    }

    public final int c() {
        return this.c.W4();
    }

    public final boolean e() {
        if (this.c.n0() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.c.isExpanded() == true) goto L10;
        if (c() <= 0) goto L10;
        return false;
    }

    public BaseHeadPagerSnapHelper(s r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        this.c = r2;
    }

    public static boolean d(RecyclerView.LayoutManager r4) {
        int r0 = r4.getItemCount();
        if ((r4 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r5 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r4).computeScrollVectorForPosition(r0 - 1);
        if (r5 == null) goto L13;
        float r3 = 0;
        if (r5.x >= r3) goto L9;
    L10:
        return true;
    L9:
        if (r5.y < r3) goto L10;
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final View a(RecyclerView.LayoutManager r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        return super.findSnapView(r2);
    }

    public final void attachToRecyclerView(RecyclerView r1) {
        super/*androidx.recyclerview.widget.SnapHelper*/.attachToRecyclerView(r1);
    }

    public View findSnapView(RecyclerView.LayoutManager r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        if (e() == false) goto L7;
        return super.findSnapView(r2);
    L7:
        if (r2.canScrollVertically() == false) goto L11;
        return b(r2, getVerticalHelper(r2));
    L11:
        if (r2.canScrollHorizontally() == true) goto L13;
        return null;
    L13:
        return b(r2, getHorizontalHelper(r2));
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r2) {
        if (this.b != null) goto L5;
        this.b = OrientationHelper.createHorizontalHelper(r2);
    L5:
        OrientationHelper r3 = this.b;
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    public final OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L6;
        return getVerticalHelper(r2);
    L6:
        if (r2.canScrollHorizontally() == true) goto L11;
        return null;
    L11:
        return getHorizontalHelper(r2);
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r2) {
        if (this.a != null) goto L5;
        this.a = OrientationHelper.createVerticalHelper(r2);
    L5:
        OrientationHelper r3 = this.a;
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    public static View b(RecyclerView.LayoutManager r8, OrientationHelper r9) {
        int r0 = r8.getChildCount();
        View r1 = null;
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = r9.getStartAfterPadding() + (r9.getTotalSpace() / 2);
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L6:
        if (r4 >= r0) goto L11;
        View r5 = r8.getChildAt(r4);
        int r6 = (int) Math.abs((r9.getDecoratedStart(r5) + (r9.getDecoratedMeasurement(r5) / 2)) - r2);
        if (r6 >= r3) goto L10;
        r1 = r5;
        r3 = r6;
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        return r1;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        if (e() == false) goto L7;
        return super.calculateDistanceToFinalSnap(r5, r6);
    L7:
        if (r5.getPosition(r6) < (c() - 1)) goto L15;
        int[] r0 = new int[2];
        if (r5.canScrollHorizontally() == false) goto L11;
        OrientationHelper r7 = getHorizontalHelper(r5);
        r0[0] = (r7.getDecoratedStart(r6) + r7.getDecoratedMeasurement(r6)) - (r7.getStartAfterPadding() + r7.getTotalSpace());
    L12:
        r0[1] = 0;
        return r0;
    L11:
        r0[0] = 0;
        goto L12
    L15:
        return new int[2];
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r17, int r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "layoutManager");
        int r3 = 1;
        int r4 = 0;
        if (e() == false) goto L47;
        int r2 = r17.getItemCount();
        if (r2 == 0) goto L115;
        OrientationHelper r6 = getOrientationHelper(r17);
        if (r6 == null) goto L116;
        int r7 = r17.getChildCount();
        View r8 = null;
        View r9 = null;
        int r10 = Integer.MIN_VALUE;
        int r11 = Integer.MAX_VALUE;
    L11:
        if (r4 >= r7) goto L26;
        View r12 = r17.getChildAt(r4);
        if (r12 == null) goto L25;
        if (r12.getWidth() <= 0) goto L25;
        int r13 = (r6.getDecoratedStart(r12) + (r6.getDecoratedMeasurement(r12) / 2)) - (r6.getStartAfterPadding() + (r6.getTotalSpace() / 2));
        if (r13 > 0) goto L22;
        if (r13 <= r10) goto L22;
        r9 = r12;
        r10 = r13;
    L22:
        if (r13 < 0) goto L25;
        if (r13 >= r11) goto L25;
        r8 = r12;
        r11 = r13;
    L25:
        r4 = r4 + 1;
        goto L11
    L26:
        boolean r5 = isForwardFling(r17, r18, r19);
        if (r5 == false) goto L30;
        if (r8 == null) goto L30;
        return r17.getPosition(r8);
    L30:
        if (r5 == true) goto L33;
        if (r9 == null) goto L33;
        return r17.getPosition(r9);
    L33:
        if (r5 == false) goto L35;
        r8 = r9;
    L35:
        if (r8 == null) goto L117;
        int r14 = r17.getPosition(r8);
        if (d(r17) != r5) goto L40;
        r3 = -1;
    L40:
        int r15 = r14 + r3;
        if (r15 < 0) goto L114;
        if (r15 < r2) goto L45;
        return -1;
    L45:
        return r15;
    L114:
        return -1;
    L117:
        return -1;
    L116:
        return -1;
    L115:
        return -1;
    L47:
        if ((r17 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L49;
        return -1;
    L49:
        int r16 = r17.getItemCount();
        if (r16 != 0) goto L52;
        return -1;
    L52:
        View r20 = findSnapView(r17);
        if (r20 != null) goto L55;
        return -1;
    L55:
        int r21 = r17.getPosition(r20);
        if (r21 < c()) goto L60;
        return super.findTargetSnapPosition(r17, r18, r19);
    L60:
        if (r21 == (c() - 1)) goto L62;
    L65:
        if (r21 != (-1)) goto L67;
        return -1;
    L67:
        int r22 = r16 - 1;
        PointF r23 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r17).computeScrollVectorForPosition(r22);
        if (r23 != null) goto L71;
        return -1;
    L71:
        if (r17.canScrollHorizontally() == false) goto L75;
        int r24 = estimateNextPositionDiffForFling(r17, getHorizontalHelper(r17), r18, 0);
        if (r23.x >= 0) goto L77;
        r24 = -r24;
    L77:
        if (r17.canScrollVertically() == false) goto L81;
        int r110 = estimateNextPositionDiffForFling(r17, getVerticalHelper(r17), 0, r19);
        if (r23.y >= 0) goto L83;
        r110 = -r110;
    L83:
        if (r17.canScrollVertically() == false) goto L85;
        r24 = r110;
    L85:
        if (r24 != 0) goto L87;
        return -1;
    L87:
        int r25 = r24 + r21;
        if (r25 < 0) goto L91;
        r4 = r25;
    L91:
        if (r4 >= r16) goto L95;
        r22 = r4;
    L95:
        if (r21 >= c()) goto L100;
        if (r22 >= c()) goto L100;
        return -1;
    L100:
        if (r21 >= c()) goto L105;
        if (r22 < c()) goto L105;
        return (-1) + c();
    L105:
        return super.findTargetSnapPosition(r17, r18, r19);
    L81:
        r110 = 0;
        goto L83
    L75:
        r24 = 0;
        goto L77
    L62:
        if (isForwardFling(r17, r18, r19) == false) goto L65;
        return super.findTargetSnapPosition(r17, r18, r19);
    }

    public final boolean isForwardFling(RecyclerView.LayoutManager r3, int r4, int r5) {
        if (r3.canScrollHorizontally() == false) goto L6;
        if (r4 > 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L6:
        if (r5 <= 0) goto L8;
        return true;
    }

    public final int estimateNextPositionDiffForFling(RecyclerView.LayoutManager r12, OrientationHelper r13, int r14, int r15) {
        int[] r16 = calculateScrollDistance(r14, r15);
        int r17 = r12.getChildCount();
        float r2 = 1.0f;
        if (r17 == 0) goto L23;
        View r3 = null;
        View r4 = null;
        int r5 = Integer.MAX_VALUE;
        int r6 = Integer.MIN_VALUE;
        int r7 = 0;
    L6:
        if (r7 >= r17) goto L15;
        View r8 = r12.getChildAt(r7);
        Intrinsics.checkNotNull(r8);
        int r9 = r12.getPosition(r8);
        if (r9 == (-1)) goto L14;
        if (r9 >= r5) goto L12;
        r3 = r8;
        r5 = r9;
    L12:
        if (r9 <= r6) goto L14;
        r4 = r8;
        r6 = r9;
    L14:
        r7 = r7 + 1;
        goto L6
    L15:
        if (r3 == null) goto L23;
        if (r4 == null) goto L23;
        int r18 = ((int) Math.max(r13.getDecoratedEnd(r3), r13.getDecoratedEnd(r4))) - ((int) Math.min(r13.getDecoratedStart(r3), r13.getDecoratedStart(r4)));
        if (r18 == 0) goto L23;
        r2 = (r18 * 1.0f) / ((r6 - r5) + 1);
    L23:
        if (r2 > 0) goto L26;
        return 0;
    L26:
        if (Math.abs(r16[0]) <= Math.abs(r16[1])) goto L28;
        int r19 = r16[0];
    L30:
        return Math.round(r19 / r2);
    L28:
        r19 = r16[1];
        goto L30
    }
}
