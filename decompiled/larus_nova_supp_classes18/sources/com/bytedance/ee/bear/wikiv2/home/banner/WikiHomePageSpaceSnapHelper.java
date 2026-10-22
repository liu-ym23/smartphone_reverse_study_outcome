package com.bytedance.ee.bear.wikiv2.home.banner;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiHomePageSpaceSnapHelper extends SnapHelper {
    public OrientationHelper a;
    public int b;
    public int c;

    public WikiHomePageSpaceSnapHelper() {
    }

    public final View findSnapView(RecyclerView.LayoutManager r2) {
        return a(r2, getHorizontalHelper(r2));
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r2) {
        if (this.a != null) goto L6;
        this.a = OrientationHelper.createHorizontalHelper(r2);
    L6:
        return this.a;
    }

    public final View a(RecyclerView.LayoutManager r5, OrientationHelper r6) {
        if ((r5 instanceof LinearLayoutManager) == false) goto L17;
        LinearLayoutManager r0 = (LinearLayoutManager) r5;
        int r2 = r0.findFirstVisibleItemPosition();
        if (r2 != (-1)) goto L8;
        return null;
    L8:
        if (r0.findLastCompletelyVisibleItemPosition() != (r5.getItemCount() - 1)) goto L10;
        return null;
    L10:
        View r1 = r5.findViewByPosition(r2);
        if (r6.getDecoratedEnd(r1) < (r6.getDecoratedMeasurement(r1) / 2)) goto L16;
        if (r6.getDecoratedEnd(r1) <= 0) goto L16;
        return r1;
    L16:
        return r5.findViewByPosition(r2 + this.c);
    L17:
        return null;
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r4, View r5) {
        int[] r0 = new int[2];
        if (r4.canScrollHorizontally() == false) goto L5;
        OrientationHelper r6 = getHorizontalHelper(r4);
        r0[0] = (r6.getDecoratedStart(r5) - r6.getStartAfterPadding()) + this.b;
    L6:
        return r0;
    L5:
        r0[0] = 0;
        goto L6
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r18, int r19, int r20) {
        if ((r18 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r2 = r18.getItemCount();
        if (r2 != 0) goto L9;
        return -1;
    L9:
        if (a(r18, getHorizontalHelper(r18)) != null) goto L11;
        return -1;
    L11:
        int r4 = ((LinearLayoutManager) r18).findFirstVisibleItemPosition();
        int r6 = r2 - 1;
        PointF r5 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r18).computeScrollVectorForPosition(r6);
        if (r5 != null) goto L15;
        return -1;
    L15:
        if (r18.canScrollHorizontally() == false) goto L50;
        OrientationHelper r7 = getHorizontalHelper(r18);
        int[] r10 = calculateScrollDistance(r19, 0);
        int r11 = r18.getChildCount();
        if (r11 != 0) goto L20;
        int r16 = r6;
    L38:
        float r12 = 1.0f;
    L39:
        float r13 = r12 / 2.0f;
        a.h("WikiHomePageSpaceSnapHelper", "estimateNextPositionDiffForFling   " + r10[0] + "  " + r13);
        if (r13 > 0.0f) goto L42;
        int r3 = 0;
    L47:
        a.h("WikiHomePageSpaceSnapHelper", "hDeltaJump " + r3);
        if (r5.x >= 0.0f) goto L51;
        r3 = -r3;
    L51:
        int r8 = r3 + r4;
        if (r8 >= 0) goto L54;
        int r9 = 0;
    L55:
        if (r9 < r2) goto L57;
        int r14 = r16;
    L58:
        a.h("WikiHomePageSpaceSnapHelper", "current position " + r4);
        return r14;
    L57:
        r14 = r9;
        goto L58
    L54:
        r9 = r8;
        goto L55
    L42:
        int r15 = r10[0];
        if (r15 <= 0) goto L45;
        double r17 = Math.ceil(r15 / r13);
    L46:
        r3 = (int) r17;
        goto L47
    L45:
        r17 = Math.floor(r15 / r13);
        goto L46
    L20:
        View r110 = null;
        View r111 = null;
        int r21 = Integer.MIN_VALUE;
        int r112 = 0;
        int r113 = Integer.MAX_VALUE;
    L21:
        if (r112 >= r11) goto L30;
        View r0 = r18.getChildAt(r112);
        int r114 = r6;
        int r22 = r18.getPosition(r0);
        if (r22 == (-1)) goto L29;
        if (r22 >= r113) goto L27;
        r110 = r0;
        r113 = r22;
    L27:
        if (r22 <= r21) goto L29;
        r111 = r0;
        r21 = r22;
    L29:
        r112 = r112 + 1;
        r6 = r114;
        goto L21
    L30:
        r16 = r6;
        if (r110 == null) goto L38;
        if (r111 == null) goto L38;
        int r1 = Math.max(r7.getDecoratedEnd(r110), r7.getDecoratedEnd(r111)) - Math.min(r7.getDecoratedStart(r110), r7.getDecoratedStart(r111));
        if (r1 == 0) goto L38;
        r12 = (r1 * 1.0f) / ((r21 - r113) + 1);
        goto L39
    L50:
        r16 = r6;
        r3 = 0;
        goto L51
    }
}
