package com.bytedance.ee.bear.wikiv2.home.banner;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import tb2.c;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class WikiHomePageSpaceSnapHelper extends SnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OrientationHelper f240717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f240718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f240719c;

    public WikiHomePageSpaceSnapHelper() {
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        return a(r100, getHorizontalHelper(r100));
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r100) {
        if (this.f240717a != null) goto L6;
        this.f240717a = OrientationHelper.createHorizontalHelper(r100);
    L6:
        return this.f240717a;
    }

    public final View a(RecyclerView.LayoutManager r100, OrientationHelper r101) {
        if ((r100 instanceof LinearLayoutManager) == false) goto L17;
        LinearLayoutManager r102 = (LinearLayoutManager) r100;
        int r103 = r102.findFirstVisibleItemPosition();
        if (r103 != (-1)) goto L8;
        return null;
    L8:
        if (r102.findLastCompletelyVisibleItemPosition() != (r100.getItemCount() - 1)) goto L10;
        return null;
    L10:
        View r104 = r100.findViewByPosition(r103);
        if (r101.getDecoratedEnd(r104) < (r101.getDecoratedMeasurement(r104) / 2)) goto L16;
        if (r101.getDecoratedEnd(r104) <= 0) goto L16;
        return r104;
    L16:
        return r100.findViewByPosition(r103 + this.f240719c);
    L17:
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        int[] r102 = new int[2];
        if (r100.canScrollHorizontally() == false) goto L5;
        OrientationHelper r103 = getHorizontalHelper(r100);
        r102[0] = (r103.getDecoratedStart(r101) - r103.getStartAfterPadding()) + this.f240718b;
    L6:
        return r102;
    L5:
        r102[0] = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r110, int r111, int r210) {
        if ((r110 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r100 = r110.getItemCount();
        if (r100 != 0) goto L9;
        return -1;
    L9:
        if (a(r110, getHorizontalHelper(r110)) != null) goto L11;
        return -1;
    L11:
        int r101 = ((LinearLayoutManager) r110).findFirstVisibleItemPosition();
        int r102 = r100 - 1;
        PointF r103 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r110).computeScrollVectorForPosition(r102);
        if (r103 != null) goto L15;
        return -1;
    L15:
        if (r110.canScrollHorizontally() == false) goto L50;
        OrientationHelper r104 = getHorizontalHelper(r110);
        int[] r112 = calculateScrollDistance(r111, 0);
        int r113 = r110.getChildCount();
        if (r113 != 0) goto L20;
        int r114 = r102;
    L38:
        float r115 = 1.0f;
    L39:
        float r116 = r115 / 2.0f;
        a.h("WikiHomePageSpaceSnapHelper", "estimateNextPositionDiffForFling   " + r112[0] + c.DEFAULT_TEXT + r116);
        if (r116 > 0.0f) goto L42;
        int r105 = 0;
    L47:
        a.h("WikiHomePageSpaceSnapHelper", "hDeltaJump " + r105);
        if (r103.x >= 0.0f) goto L51;
        r105 = -r105;
    L51:
        int r106 = r105 + r101;
        if (r106 >= 0) goto L54;
        int r107 = 0;
    L55:
        if (r107 < r100) goto L57;
        int r108 = r114;
    L58:
        a.h("WikiHomePageSpaceSnapHelper", "current position " + r101);
        return r108;
    L57:
        r108 = r107;
        goto L58
    L54:
        r107 = r106;
        goto L55
    L42:
        int r109 = r112[0];
        if (r109 <= 0) goto L45;
        double r117 = Math.ceil(r109 / r116);
    L46:
        r105 = (int) r117;
        goto L47
    L45:
        r117 = Math.floor(r109 / r116);
        goto L46
    L20:
        View r118 = null;
        View r119 = null;
        int r120 = Integer.MIN_VALUE;
        int r121 = 0;
        int r122 = Integer.MAX_VALUE;
    L21:
        if (r121 >= r113) goto L30;
        View r123 = r110.getChildAt(r121);
        int r124 = r102;
        int r125 = r110.getPosition(r123);
        if (r125 == (-1)) goto L29;
        if (r125 >= r122) goto L27;
        r118 = r123;
        r122 = r125;
    L27:
        if (r125 <= r120) goto L29;
        r119 = r123;
        r120 = r125;
    L29:
        r121 = r121 + 1;
        r102 = r124;
        goto L21
    L30:
        r114 = r102;
        if (r118 == null) goto L38;
        if (r119 == null) goto L38;
        int r126 = Math.max(r104.getDecoratedEnd(r118), r104.getDecoratedEnd(r119)) - Math.min(r104.getDecoratedStart(r118), r104.getDecoratedStart(r119));
        if (r126 == 0) goto L38;
        r115 = (r126 * 1.0f) / ((r120 - r122) + 1);
        goto L39
    L50:
        r114 = r102;
        r105 = 0;
        goto L51
    }
}
