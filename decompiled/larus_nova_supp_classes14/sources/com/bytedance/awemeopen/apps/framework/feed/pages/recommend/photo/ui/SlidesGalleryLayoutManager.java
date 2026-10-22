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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SlidesGalleryLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public int a;
    public int b;
    public int c;
    public b d;
    public OrientationHelper e;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public LayoutParams() {
            super(-2, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    public class a extends LinearSmoothScroller {
        public a(Context r1) {
            super(r1);
        }

        public final void onTargetFound(View r7, RecyclerView.State r8, RecyclerView.SmoothScroller.Action r9) {
            RecyclerView.LayoutManager r10 = getLayoutManager();
            int r1 = 0;
            if (r10 != null) goto L5;
        L8:
            int r11 = 0;
        L9:
            RecyclerView.LayoutManager r2 = getLayoutManager();
            if (r2 != null) goto L12;
        L15:
            float r12 = r11;
            float r3 = (r12 * 1.0f) * r12;
            float r13 = r1;
            int r14 = calculateTimeForDeceleration((int) Math.sqrt(r3 + ((1.0f * r13) * r13)));
            if (r14 <= 0) goto L19;
            r9.update(-r11, -r1, r14, ((LinearSmoothScroller) this).mDecelerateInterpolator);
            return;
        L19:
            return;
        L12:
            if (r2.canScrollVertically() == false) goto L15;
            RecyclerView.LayoutParams r4 = r7.getLayoutParams();
            int r5 = r2.getDecoratedTop(r7) - ((ViewGroup.MarginLayoutParams) r4).topMargin;
            int r15 = r2.getDecoratedBottom(r7) + ((ViewGroup.MarginLayoutParams) r4).bottomMargin;
            int r6 = r5 + ((int) ((r15 - r5) / 2.0f));
            r1 = ((int) (((r2.getHeight() - r2.getPaddingBottom()) - r2.getPaddingTop()) / 2.0f)) - r6;
            goto L15
        L5:
            if (r10.canScrollHorizontally() == false) goto L8;
            RecyclerView.LayoutParams r16 = r7.getLayoutParams();
            int r17 = r10.getDecoratedLeft(r7) - ((ViewGroup.MarginLayoutParams) r16).leftMargin;
            int r18 = r10.getDecoratedRight(r7) + ((ViewGroup.MarginLayoutParams) r16).rightMargin;
            int r19 = r10.getPaddingLeft();
            int r20 = r17 + ((int) ((r18 - r17) / 2.0f));
            r11 = ((int) (((r10.getWidth() - r10.getPaddingRight()) - r19) / 2.0f)) - r20;
            goto L9
        }
    }

    public class b {
        public final SparseArray<Rect> a;

        public b() {
            this.a = new SparseArray();
        }
    }

    public final boolean canScrollHorizontally() {
        return true;
    }

    public final boolean canScrollVertically() {
        return false;
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final OrientationHelper q() {
        if (this.e != null) goto L6;
        this.e = OrientationHelper.createHorizontalHelper(this);
    L6:
        return this.e;
    }

    public final b r() {
        if (this.d != null) goto L6;
        this.d = new b();
    L6:
        return this.d;
    }

    public final void t() {
        b r0 = this.d;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        int r1 = this.c;
        if (r1 == (-1)) goto L8;
        this.b = r1;
    L8:
        int r2 = Math.min(Math.max(0, this.b), getItemCount() - 1);
        this.b = r2;
        this.a = r2;
        this.c = -1;
    }

    public final int s() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    public final boolean checkLayoutParams(RecyclerView.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public final PointF computeScrollVectorForPosition(int r3) {
        int r1 = -1;
        if (getChildCount() != 0) goto L6;
    L9:
        PointF r4 = new PointF();
        if (r1 != 0) goto L13;
        return null;
    L13:
        r4.x = r1;
        r4.y = 0.0f;
        return r4;
    L6:
        if (r3 < this.a) goto L9;
        r1 = 1;
        goto L9
    }

    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L7:
        return new LayoutParams(r2);
    }

    public final RecyclerView.LayoutParams generateLayoutParams(Context r2, AttributeSet r3) {
        return new LayoutParams(r2, r3);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r18, RecyclerView.State r19) {
        if (getItemCount() != 0) goto L7;
        t();
        detachAndScrapAttachedViews(r18);
        return;
    L7:
        if (r19.isPreLayout() == false) goto L10;
        return;
    L10:
        if (r19.getItemCount() == 0) goto L15;
        if (r19.didStructureChange() == true) goto L15;
        return;
    L15:
        if (getChildCount() != 0) goto L17;
    L18:
        t();
    L19:
        this.b = Math.min(Math.max(0, this.b), getItemCount() - 1);
        detachAndScrapAttachedViews(r18);
        detachAndScrapAttachedViews(r18);
        int r9 = q().getStartAfterPadding();
        int r10 = q().getEndAfterPadding();
        int r11 = this.b;
        Rect r12 = new Rect();
        int r0 = s();
        View r13 = r18.getViewForPosition(this.b);
        addView(r13, 0);
        measureChildWithMargins(r13, 0, 0);
        int r1 = getDecoratedMeasuredWidth(r13);
        int r2 = getDecoratedMeasuredHeight(r13);
        int r3 = (int) (getPaddingTop() + ((r0 - r2) / 2.0f));
        int r4 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r1) / 2.0f));
        r12.set(r4, r3, r1 + r4, r2 + r3);
        layoutDecorated(r13, r12.left, r12.top, r12.right, r12.bottom);
        if (r().a.get(r11) != null) goto L22;
        r().a.put(r11, r12);
    L23:
        this.a = r11;
        int r5 = getDecoratedLeft(r13);
        int r14 = getDecoratedRight(r13);
        int r6 = this.b - 1;
        Rect r15 = new Rect();
        int r16 = s();
        int r17 = r6;
    L24:
        if (r17 < 0) goto L31;
        if (r5 <= r9) goto L31;
        View r7 = r18.getViewForPosition(r17);
        addView(r7, 0);
        measureChildWithMargins(r7, 0, 0);
        int r8 = getDecoratedMeasuredWidth(r7);
        int r20 = getDecoratedMeasuredHeight(r7);
        int r21 = (int) (getPaddingTop() + ((r16 - r20) / 2.0f));
        r15.set(r5 - r8, r21, r5, r20 + r21);
        layoutDecorated(r7, r15.left, r15.top, r15.right, r15.bottom);
        r5 = r15.left;
        this.a = r17;
        if (r().a.get(r17) != null) goto L29;
        r().a.put(r17, r15);
    L30:
        r17 = r17 - 1;
        goto L24
    L29:
        r().a.get(r17).set(r15);
    L31:
        int r22 = this.b + 1;
        Rect r23 = new Rect();
        int r110 = s();
        int r111 = r22;
        int r24 = r14;
    L33:
        if (r111 >= getItemCount()) goto L41;
        if (r24 >= r10) goto L41;
        View r25 = r18.getViewForPosition(r111);
        addView(r25);
        measureChildWithMargins(r25, 0, 0);
        int r26 = getDecoratedMeasuredWidth(r25);
        int r27 = getDecoratedMeasuredHeight(r25);
        int r28 = (int) (getPaddingTop() + ((r110 - r27) / 2.0f));
        r23.set(r24, r28, r26 + r24, r27 + r28);
        layoutDecorated(r25, r23.left, r23.top, r23.right, r23.bottom);
        r24 = r23.right;
        if (r().a.get(r111) != null) goto L38;
        r().a.put(r111, r23);
    L39:
        r111 = r111 + 1;
        goto L33
    L38:
        r().a.get(r111).set(r23);
    L41:
        throw null;
    L22:
        r().a.get(r11).set(r12);
        goto L23
    L17:
        if (r19.didStructureChange() == false) goto L19;
        goto L18
    }

    public final void onItemsRemoved(RecyclerView r1, int r2, int r3) {
        super.onItemsRemoved(r1, r2, r3);
    }

    public final void p(RecyclerView.Recycler r18, RecyclerView.State r19, int r20) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        int r8 = q().getStartAfterPadding();
        int r9 = q().getEndAfterPadding();
        int r11 = -1;
        if (getChildCount() <= 0) goto L20;
        if (r20 < 0) goto L14;
        int r0 = 0;
        int r1 = 0;
    L10:
        if (r0 >= getChildCount()) goto L20;
        View r2 = getChildAt(r0 + r1);
        if ((getDecoratedRight(r2) - r20) >= r8) goto L20;
        removeAndRecycleView(r2, r18);
        this.a++;
        r1 = r1 - 1;
        r0 = r0 + 1;
        goto L10
    L14:
        int r3 = getChildCount() - 1;
    L15:
        if (r3 < 0) goto L20;
        View r4 = getChildAt(r3);
        if ((getDecoratedLeft(r4) - r20) <= r9) goto L19;
        removeAndRecycleView(r4, r18);
    L19:
        r3 = r3 - 1;
    L20:
        int r5 = this.a;
        int r12 = s();
        if (r20 < 0) goto L41;
        if (getChildCount() == 0) goto L25;
        View r6 = getChildAt(getChildCount() - 1);
        int r7 = getPosition(r6) + 1;
        int r10 = getDecoratedRight(r6);
        int r13 = r7;
    L26:
        int r14 = r13;
    L28:
        if (r14 >= getItemCount()) goto L51;
        if (r10 >= (r9 + r20)) goto L65;
        Rect r15 = r().a.get(r14);
        View r16 = r18.getViewForPosition(r14);
        addView(r16);
        if (r15 != null) goto L34;
        r15 = new Rect();
        r().a.put(r14, r15);
    L34:
        Rect r17 = r15;
        measureChildWithMargins(r16, 0, 0);
        int r21 = getDecoratedMeasuredWidth(r16);
        int r22 = getDecoratedMeasuredHeight(r16);
        int r23 = (int) (getPaddingTop() + ((r12 - r22) / 2.0f));
        if (r10 != (-1)) goto L38;
        if (r13 != 0) goto L38;
        int r24 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r21) / 2.0f));
        r17.set(r24, r23, r21 + r24, r22 + r23);
    L39:
        layoutDecorated(r16, r17.left, r17.top, r17.right, r17.bottom);
        r10 = r17.right;
        r14 = r14 + 1;
    L38:
        r17.set(r10, r23, r21 + r10, r22 + r23);
        goto L39
    L65:
        return;
    L51:
        return;
    L25:
        r13 = r5;
        r10 = -1;
        goto L26
    L41:
        if (getChildCount() <= 0) goto L43;
        View r25 = getChildAt(0);
        int r26 = getPosition(r25) - 1;
        r11 = getDecoratedLeft(r25);
        r5 = r26;
    L43:
        int r27 = r5;
    L44:
        if (r27 < 0) goto L66;
        if (r11 <= (r8 + r20)) goto L67;
        Rect r28 = r().a.get(r27);
        View r29 = r18.getViewForPosition(r27);
        addView(r29, 0);
        if (r28 != null) goto L50;
        r28 = new Rect();
        r().a.put(r27, r28);
    L50:
        Rect r110 = r28;
        measureChildWithMargins(r29, 0, 0);
        int r30 = getDecoratedMeasuredWidth(r29);
        int r31 = getDecoratedMeasuredHeight(r29);
        int r32 = (int) (getPaddingTop() + ((r12 - r31) / 2.0f));
        r110.set(r11 - r30, r32, r11, r31 + r32);
        layoutDecorated(r29, r110.left, r110.top, r110.right, r110.bottom);
        r11 = r110.left;
        this.a = r27;
        r27 = r27 - 1;
        goto L44
    L67:
        return;
    }

    public final int scrollHorizontallyBy(int r6, RecyclerView.Recycler r7, RecyclerView.State r8) {
        if (getChildCount() == 0) goto L17;
        if (r6 == 0) goto L18;
        int r0 = -r6;
        int r2 = ((q().getEndAfterPadding() - q().getStartAfterPadding()) / 2) + q().getStartAfterPadding();
        if (r6 <= 0) goto L12;
        if (getPosition(getChildAt(getChildCount() - 1)) != (getItemCount() - 1)) goto L15;
        View r1 = getChildAt(getChildCount() - 1);
        int r9 = Math.max(0, Math.min(r6, (((r1.getRight() - r1.getLeft()) / 2) + r1.getLeft()) - r2));
    L14:
        r0 = -r9;
    L15:
        int r3 = -r0;
        r().getClass();
        p(r7, r8, r3);
        offsetChildrenHorizontal(r0);
        return r3;
    L12:
        if (this.a != 0) goto L15;
        View r4 = getChildAt(0);
        r9 = Math.min(0, Math.max(r6, (((r4.getRight() - r4.getLeft()) / 2) + r4.getLeft()) - r2));
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    }

    public final int scrollVerticallyBy(int r6, RecyclerView.Recycler r7, RecyclerView.State r8) {
        if (getChildCount() == 0) goto L17;
        if (r6 == 0) goto L18;
        int r0 = -r6;
        int r2 = ((q().getEndAfterPadding() - q().getStartAfterPadding()) / 2) + q().getStartAfterPadding();
        if (r6 <= 0) goto L12;
        if (getPosition(getChildAt(getChildCount() - 1)) != (getItemCount() - 1)) goto L15;
        View r1 = getChildAt(getChildCount() - 1);
        int r9 = Math.max(0, Math.min(r6, (((getDecoratedBottom(r1) - getDecoratedTop(r1)) / 2) + getDecoratedTop(r1)) - r2));
    L14:
        r0 = -r9;
    L15:
        int r3 = -r0;
        r().getClass();
        p(r7, r8, r3);
        offsetChildrenVertical(r0);
        return r3;
    L12:
        if (this.a != 0) goto L15;
        View r4 = getChildAt(0);
        r9 = Math.min(0, Math.max(r6, (((getDecoratedBottom(r4) - getDecoratedTop(r4)) / 2) + getDecoratedTop(r4)) - r2));
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        a r4 = new a(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
