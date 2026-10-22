package com.bytedance.ee.bear.middleground.comment.uitls;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class RecyclerViewScrollHelper {

    public static class SetSmoothScroller extends LinearSmoothScroller {
        public int a;
        public int b;
        public int c;
        public float d;

        public final int getHorizontalSnapPreference() {
            return this.a;
        }

        public final int getVerticalSnapPreference() {
            return this.a;
        }

        public SetSmoothScroller(Context r2) {
            super(r2);
            this.a = -1;
            this.b = 0;
            this.c = Integer.MAX_VALUE;
            this.d = -1.0f;
            setTargetPosition(-1);
        }

        public final int calculateTimeForDeceleration(int r2) {
            return Math.min(super.calculateTimeForDeceleration(r2), this.c);
        }

        public final int calculateDyToMakeVisible(View r7, int r8) {
            float r0 = this.d;
            int r2 = 0;
            if (r0 == (-1.0f)) goto L19;
            int r1 = this.a;
            if (r1 != (-1)) goto L8;
        L11:
            RecyclerView.LayoutManager r3 = getLayoutManager();
            if (r3 != null) goto L14;
        L17:
            r2 = (int) ((r1 * r2) * r0);
            goto L19
        L14:
            if (r3.canScrollVertically() == false) goto L17;
            RecyclerView.LayoutParams r4 = r7.getLayoutParams();
            r2 = (r3.getDecoratedBottom(r7) + ((ViewGroup.MarginLayoutParams) r4).bottomMargin) - (r3.getDecoratedTop(r7) - ((ViewGroup.MarginLayoutParams) r4).topMargin);
            goto L17
        L8:
            if (r1 != 1) goto L10;
            r0 = 1.0f - r0;
            goto L11
        L10:
            r0 = 0.0f;
        L19:
            return (super.calculateDyToMakeVisible(r7, r8) - this.b) + r2;
        }

        public final void onTargetFound(View r3, RecyclerView.State r4, RecyclerView.SmoothScroller.Action r5) {
            int r6 = calculateDxToMakeVisible(r3, getHorizontalSnapPreference());
            int r7 = calculateDyToMakeVisible(r3, getVerticalSnapPreference());
            int r0 = calculateTimeForDeceleration((int) Math.sqrt((r6 * r6) + (r7 * r7)));
            if (r0 <= 0) goto L6;
            r5.update(-r6, -r7, r0, ((LinearSmoothScroller) this).mDecelerateInterpolator);
            return;
        }
    }

    public static class a {
        public final int a;
        public final float b;
        public final int c;

        public final String toString() {
            return "ScrollData{targetPosition=" + this.a + ", percentage=" + this.b + ", height=" + this.c + '}';
        }

        public a(int r1, float r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static a a(RecyclerView r7, int r8) {
        float r0 = 0.0f;
        int r1 = -1;
        int r2 = 0;
        if (r7 != null) goto L5;
    L18:
        tt5.a.d("Comment#RecyclerViewScrollHelper", "calculateScrollPosition()... recyclerView is null or layoutManager is not instance of LinearLayoutManager");
        return new a(-1, 0.0f, 0);
    L5:
        if ((r7.getLayoutManager() instanceof LinearLayoutManager) == false) goto L18;
        int r3 = r7.getLayoutManager().findFirstVisibleItemPosition();
        int r4 = 0;
    L9:
        if (r4 >= r7.getChildCount()) goto L17;
        View r5 = r7.getChildAt(r4);
        if (r5.getTop() > r8) goto L15;
        if (r5.getBottom() <= r8) goto L15;
        r1 = r4 + r3;
        r2 = r5.getHeight();
        r0 = (r8 - r5.getTop()) / r5.getHeight();
    L15:
        r4 = r4 + 1;
    L17:
        return new a(r1, r0, r2);
    }

    public static void b(RecyclerView r2, SetSmoothScroller r3) {
        LinearLayoutManager r0 = r2.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L6;
        r2.stopScroll();
        r0.startSmoothScroll(r3);
        return;
    }
}
