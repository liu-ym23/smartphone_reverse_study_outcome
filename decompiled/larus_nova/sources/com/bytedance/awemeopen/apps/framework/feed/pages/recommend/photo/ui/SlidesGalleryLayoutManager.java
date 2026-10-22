package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes14.dex */
public class SlidesGalleryLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f195267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f195268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f195269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f195270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OrientationHelper f195271e;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public LayoutParams() {
            super(-2, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    public class a extends LinearSmoothScroller {
        public a(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
            RecyclerView.LayoutManager r103 = getLayoutManager();
            int r104 = 0;
            if (r103 != null) goto L5;
        L8:
            int r105 = 0;
        L9:
            RecyclerView.LayoutManager r106 = getLayoutManager();
            if (r106 != null) goto L12;
        L15:
            float r107 = r105;
            float r108 = (r107 * 1.0f) * r107;
            float r109 = r104;
            int r110 = calculateTimeForDeceleration((int) Math.sqrt(r108 + ((1.0f * r109) * r109)));
            if (r110 <= 0) goto L19;
            r102.update(-r105, -r104, r110, this.mDecelerateInterpolator);
            return;
        L19:
            return;
        L12:
            if (r106.canScrollVertically() == false) goto L15;
            RecyclerView.LayoutParams r111 = (RecyclerView.LayoutParams) r100.getLayoutParams();
            int r112 = r106.getDecoratedTop(r100) - ((ViewGroup.MarginLayoutParams) r111).topMargin;
            int r113 = r106.getDecoratedBottom(r100) + ((ViewGroup.MarginLayoutParams) r111).bottomMargin;
            int r114 = r112 + ((int) ((r113 - r112) / 2.0f));
            r104 = ((int) (((r106.getHeight() - r106.getPaddingBottom()) - r106.getPaddingTop()) / 2.0f)) - r114;
            goto L15
        L5:
            if (r103.canScrollHorizontally() == false) goto L8;
            RecyclerView.LayoutParams r115 = (RecyclerView.LayoutParams) r100.getLayoutParams();
            int r116 = r103.getDecoratedLeft(r100) - ((ViewGroup.MarginLayoutParams) r115).leftMargin;
            int r117 = r103.getDecoratedRight(r100) + ((ViewGroup.MarginLayoutParams) r115).rightMargin;
            int r118 = r103.getPaddingLeft();
            int r119 = r116 + ((int) ((r117 - r116) / 2.0f));
            r105 = ((int) (((r103.getWidth() - r103.getPaddingRight()) - r118) / 2.0f)) - r119;
            goto L9
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Rect> f195272a;

        public b() {
            this.f195272a = new SparseArray();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final OrientationHelper q() {
        if (this.f195271e != null) goto L6;
        this.f195271e = OrientationHelper.createHorizontalHelper(this);
    L6:
        return this.f195271e;
    }

    public final b r() {
        if (this.f195270d != null) goto L6;
        this.f195270d = new b();
    L6:
        return this.f195270d;
    }

    public final void t() {
        b r100 = this.f195270d;
        if (r100 == null) goto L5;
        r100.f195272a.clear();
    L5:
        int r101 = this.f195269c;
        if (r101 == (-1)) goto L8;
        this.f195268b = r101;
    L8:
        int r102 = Math.min(Math.max(0, this.f195268b), getItemCount() - 1);
        this.f195268b = r102;
        this.f195267a = r102;
        this.f195269c = -1;
    }

    public final int s() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int r100) {
        int r101 = -1;
        if (getChildCount() != 0) goto L6;
    L9:
        PointF r102 = new PointF();
        if (r101 != 0) goto L13;
        return null;
    L13:
        r102.x = r101;
        r102.y = 0.0f;
        return r102;
    L6:
        if (r100 < this.f195267a) goto L9;
        r101 = 1;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L7:
        return new LayoutParams(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
        return new LayoutParams(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r110, RecyclerView.State r111) {
        if (getItemCount() != 0) goto L7;
        t();
        detachAndScrapAttachedViews(r110);
        return;
    L7:
        if (r111.isPreLayout() == false) goto L10;
        return;
    L10:
        if (r111.getItemCount() == 0) goto L15;
        if (r111.didStructureChange() == true) goto L15;
        return;
    L15:
        if (getChildCount() != 0) goto L17;
    L18:
        t();
    L19:
        this.f195268b = Math.min(Math.max(0, this.f195268b), getItemCount() - 1);
        detachAndScrapAttachedViews(r110);
        detachAndScrapAttachedViews(r110);
        int r100 = q().getStartAfterPadding();
        int r112 = q().getEndAfterPadding();
        int r113 = this.f195268b;
        Rect r114 = new Rect();
        int r101 = s();
        View r115 = r110.getViewForPosition(this.f195268b);
        addView(r115, 0);
        measureChildWithMargins(r115, 0, 0);
        int r102 = getDecoratedMeasuredWidth(r115);
        int r103 = getDecoratedMeasuredHeight(r115);
        int r104 = (int) (getPaddingTop() + ((r101 - r103) / 2.0f));
        int r105 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r102) / 2.0f));
        r114.set(r105, r104, r102 + r105, r103 + r104);
        layoutDecorated(r115, r114.left, r114.top, r114.right, r114.bottom);
        if (r().f195272a.get(r113) != null) goto L22;
        r().f195272a.put(r113, r114);
    L23:
        this.f195267a = r113;
        int r106 = getDecoratedLeft(r115);
        int r116 = getDecoratedRight(r115);
        int r107 = this.f195268b - 1;
        Rect r117 = new Rect();
        int r118 = s();
        int r119 = r107;
    L24:
        if (r119 < 0) goto L31;
        if (r106 <= r100) goto L31;
        View r108 = r110.getViewForPosition(r119);
        addView(r108, 0);
        measureChildWithMargins(r108, 0, 0);
        int r109 = getDecoratedMeasuredWidth(r108);
        int r120 = getDecoratedMeasuredHeight(r108);
        int r121 = (int) (getPaddingTop() + ((r118 - r120) / 2.0f));
        r117.set(r106 - r109, r121, r106, r120 + r121);
        layoutDecorated(r108, r117.left, r117.top, r117.right, r117.bottom);
        r106 = r117.left;
        this.f195267a = r119;
        if (r().f195272a.get(r119) != null) goto L29;
        r().f195272a.put(r119, r117);
    L30:
        r119 = r119 - 1;
        goto L24
    L29:
        r().f195272a.get(r119).set(r117);
    L31:
        int r122 = this.f195268b + 1;
        Rect r123 = new Rect();
        int r124 = s();
        int r125 = r122;
        int r126 = r116;
    L33:
        if (r125 >= getItemCount()) goto L41;
        if (r126 >= r112) goto L41;
        View r127 = r110.getViewForPosition(r125);
        addView(r127);
        measureChildWithMargins(r127, 0, 0);
        int r128 = getDecoratedMeasuredWidth(r127);
        int r129 = getDecoratedMeasuredHeight(r127);
        int r130 = (int) (getPaddingTop() + ((r124 - r129) / 2.0f));
        r123.set(r126, r130, r128 + r126, r129 + r130);
        layoutDecorated(r127, r123.left, r123.top, r123.right, r123.bottom);
        r126 = r123.right;
        if (r().f195272a.get(r125) != null) goto L38;
        r().f195272a.put(r125, r123);
    L39:
        r125 = r125 + 1;
        goto L33
    L38:
        r().f195272a.get(r125).set(r123);
    L41:
        throw null;
    L22:
        r().f195272a.get(r113).set(r114);
        goto L23
    L17:
        if (r111.didStructureChange() == false) goto L19;
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        super.onItemsRemoved(r100, r101, r102);
    }

    public final void p(RecyclerView.Recycler r110, RecyclerView.State r111, int r210) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        int r100 = q().getStartAfterPadding();
        int r101 = q().getEndAfterPadding();
        int r112 = -1;
        if (getChildCount() <= 0) goto L20;
        if (r210 < 0) goto L14;
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r102 >= getChildCount()) goto L20;
        View r104 = getChildAt(r102 + r103);
        if ((getDecoratedRight(r104) - r210) >= r100) goto L20;
        removeAndRecycleView(r104, r110);
        this.f195267a++;
        r103 = r103 - 1;
        r102 = r102 + 1;
        goto L10
    L14:
        int r105 = getChildCount() - 1;
    L15:
        if (r105 < 0) goto L20;
        View r106 = getChildAt(r105);
        if ((getDecoratedLeft(r106) - r210) <= r101) goto L19;
        removeAndRecycleView(r106, r110);
    L19:
        r105 = r105 - 1;
    L20:
        int r107 = this.f195267a;
        int r113 = s();
        if (r210 < 0) goto L41;
        if (getChildCount() == 0) goto L25;
        View r108 = getChildAt(getChildCount() - 1);
        int r109 = getPosition(r108) + 1;
        int r114 = getDecoratedRight(r108);
        int r115 = r109;
    L26:
        int r116 = r115;
    L28:
        if (r116 >= getItemCount()) goto L51;
        if (r114 >= (r101 + r210)) goto L65;
        Rect r117 = r().f195272a.get(r116);
        View r118 = r110.getViewForPosition(r116);
        addView(r118);
        if (r117 != null) goto L34;
        r117 = new Rect();
        r().f195272a.put(r116, r117);
    L34:
        Rect r119 = r117;
        measureChildWithMargins(r118, 0, 0);
        int r120 = getDecoratedMeasuredWidth(r118);
        int r121 = getDecoratedMeasuredHeight(r118);
        int r122 = (int) (getPaddingTop() + ((r113 - r121) / 2.0f));
        if (r114 != (-1)) goto L38;
        if (r115 != 0) goto L38;
        int r123 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r120) / 2.0f));
        r119.set(r123, r122, r120 + r123, r121 + r122);
    L39:
        layoutDecorated(r118, r119.left, r119.top, r119.right, r119.bottom);
        r114 = r119.right;
        r116 = r116 + 1;
    L38:
        r119.set(r114, r122, r120 + r114, r121 + r122);
        goto L39
    L65:
        return;
    L51:
        return;
    L25:
        r115 = r107;
        r114 = -1;
        goto L26
    L41:
        if (getChildCount() <= 0) goto L43;
        View r124 = getChildAt(0);
        int r125 = getPosition(r124) - 1;
        r112 = getDecoratedLeft(r124);
        r107 = r125;
    L43:
        int r126 = r107;
    L44:
        if (r126 < 0) goto L66;
        if (r112 <= (r100 + r210)) goto L67;
        Rect r127 = r().f195272a.get(r126);
        View r128 = r110.getViewForPosition(r126);
        addView(r128, 0);
        if (r127 != null) goto L50;
        r127 = new Rect();
        r().f195272a.put(r126, r127);
    L50:
        Rect r129 = r127;
        measureChildWithMargins(r128, 0, 0);
        int r130 = getDecoratedMeasuredWidth(r128);
        int r131 = getDecoratedMeasuredHeight(r128);
        int r132 = (int) (getPaddingTop() + ((r113 - r131) / 2.0f));
        r129.set(r112 - r130, r132, r112, r131 + r132);
        layoutDecorated(r128, r129.left, r129.top, r129.right, r129.bottom);
        r112 = r129.left;
        this.f195267a = r126;
        r126 = r126 - 1;
        goto L44
    L67:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getChildCount() == 0) goto L17;
        if (r100 == 0) goto L18;
        int r103 = -r100;
        int r104 = ((q().getEndAfterPadding() - q().getStartAfterPadding()) / 2) + q().getStartAfterPadding();
        if (r100 <= 0) goto L12;
        if (getPosition(getChildAt(getChildCount() - 1)) != (getItemCount() - 1)) goto L15;
        View r105 = getChildAt(getChildCount() - 1);
        int r106 = Math.max(0, Math.min(r100, (((r105.getRight() - r105.getLeft()) / 2) + r105.getLeft()) - r104));
    L14:
        r103 = -r106;
    L15:
        int r107 = -r103;
        r().getClass();
        p(r101, r102, r107);
        offsetChildrenHorizontal(r103);
        return r107;
    L12:
        if (this.f195267a != 0) goto L15;
        View r108 = getChildAt(0);
        r106 = Math.min(0, Math.max(r100, (((r108.getRight() - r108.getLeft()) / 2) + r108.getLeft()) - r104));
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getChildCount() == 0) goto L17;
        if (r100 == 0) goto L18;
        int r103 = -r100;
        int r104 = ((q().getEndAfterPadding() - q().getStartAfterPadding()) / 2) + q().getStartAfterPadding();
        if (r100 <= 0) goto L12;
        if (getPosition(getChildAt(getChildCount() - 1)) != (getItemCount() - 1)) goto L15;
        View r105 = getChildAt(getChildCount() - 1);
        int r106 = Math.max(0, Math.min(r100, (((getDecoratedBottom(r105) - getDecoratedTop(r105)) / 2) + getDecoratedTop(r105)) - r104));
    L14:
        r103 = -r106;
    L15:
        int r107 = -r103;
        r().getClass();
        p(r101, r102, r107);
        offsetChildrenVertical(r103);
        return r107;
    L12:
        if (this.f195267a != 0) goto L15;
        View r108 = getChildAt(0);
        r106 = Math.min(0, Math.max(r100, (((getDecoratedBottom(r108) - getDecoratedTop(r108)) / 2) + getDecoratedTop(r108)) - r104));
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        a r103 = new a(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
