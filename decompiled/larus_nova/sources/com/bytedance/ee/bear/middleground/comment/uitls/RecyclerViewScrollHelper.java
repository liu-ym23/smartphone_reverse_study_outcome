package com.bytedance.ee.bear.middleground.comment.uitls;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public final class RecyclerViewScrollHelper {

    public static class SetSmoothScroller extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f232188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f232189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f232190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f232191d;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int getHorizontalSnapPreference() {
            return this.f232188a;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int getVerticalSnapPreference() {
            return this.f232188a;
        }

        public SetSmoothScroller(Context r100) {
            super(r100);
            this.f232188a = -1;
            this.f232189b = 0;
            this.f232190c = Integer.MAX_VALUE;
            this.f232191d = -1.0f;
            setTargetPosition(-1);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForDeceleration(int r100) {
            return Math.min(super.calculateTimeForDeceleration(r100), this.f232190c);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDyToMakeVisible(View r100, int r101) {
            float r102 = this.f232191d;
            int r103 = 0;
            if (r102 == (-1.0f)) goto L19;
            int r104 = this.f232188a;
            if (r104 != (-1)) goto L8;
        L11:
            RecyclerView.LayoutManager r105 = getLayoutManager();
            if (r105 != null) goto L14;
        L17:
            r103 = (int) ((r104 * r103) * r102);
            goto L19
        L14:
            if (r105.canScrollVertically() == false) goto L17;
            RecyclerView.LayoutParams r106 = (RecyclerView.LayoutParams) r100.getLayoutParams();
            r103 = (r105.getDecoratedBottom(r100) + ((ViewGroup.MarginLayoutParams) r106).bottomMargin) - (r105.getDecoratedTop(r100) - ((ViewGroup.MarginLayoutParams) r106).topMargin);
            goto L17
        L8:
            if (r104 != 1) goto L10;
            r102 = 1.0f - r102;
            goto L11
        L10:
            r102 = 0.0f;
        L19:
            return (super.calculateDyToMakeVisible(r100, r101) - this.f232189b) + r103;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
            int r103 = calculateDxToMakeVisible(r100, getHorizontalSnapPreference());
            int r104 = calculateDyToMakeVisible(r100, getVerticalSnapPreference());
            int r105 = calculateTimeForDeceleration((int) Math.sqrt((r103 * r103) + (r104 * r104)));
            if (r105 <= 0) goto L6;
            r102.update(-r103, -r104, r105, this.mDecelerateInterpolator);
            return;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f232192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f232193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f232194c;

        public final String toString() {
            return "ScrollData{targetPosition=" + this.f232192a + ", percentage=" + this.f232193b + ", height=" + this.f232194c + '}';
        }

        public a(int r100, float r101, int r102) {
            this.f232192a = r100;
            this.f232193b = r101;
            this.f232194c = r102;
        }
    }

    public static a a(RecyclerView r100, int r101) {
        float r102 = 0.0f;
        int r103 = -1;
        int r104 = 0;
        if (r100 != null) goto L5;
    L18:
        tt5.a.d("Comment#RecyclerViewScrollHelper", "calculateScrollPosition()... recyclerView is null or layoutManager is not instance of LinearLayoutManager");
        return new a(-1, 0.0f, 0);
    L5:
        if ((r100.getLayoutManager() instanceof LinearLayoutManager) == false) goto L18;
        int r105 = ((LinearLayoutManager) r100.getLayoutManager()).findFirstVisibleItemPosition();
        int r106 = 0;
    L9:
        if (r106 >= r100.getChildCount()) goto L17;
        View r107 = r100.getChildAt(r106);
        if (r107.getTop() > r101) goto L15;
        if (r107.getBottom() <= r101) goto L15;
        r103 = r106 + r105;
        r104 = r107.getHeight();
        r102 = (r101 - r107.getTop()) / r107.getHeight();
    L15:
        r106 = r106 + 1;
    L17:
        return new a(r103, r102, r104);
    }

    public static void b(RecyclerView r100, SetSmoothScroller r101) {
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L6;
        r100.stopScroll();
        ((LinearLayoutManager) r102).startSmoothScroll(r101);
        return;
    }
}
