package com.ss.android.lark.widget.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
public class FoldedLayoutManager extends RecyclerView.LayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448161a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FOLD = 0;
        public static final int UNFOLD = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);
        if (getItemCount() != 0) goto L7;
        detachAndScrapAttachedViews(r100);
        return;
    L7:
        if (getChildCount() == 0) goto L9;
    L11:
        detachAndScrapAttachedViews(r100);
        if (getItemCount() <= 0) goto L14;
        View r102 = r100.getViewForPosition(0);
        r102.setVisibility(4);
        measureChildWithMargins(r102, 0, 0);
        getDecoratedMeasuredWidth(r102);
        getDecoratedMeasuredHeight(r102);
        calculateItemDecorationsForChild(r102, new Rect());
        throw null;
    L14:
        if (getItemCount() > 0) goto L16;
        return;
    L16:
        if (r101.isPreLayout() == false) goto L19;
        return;
    L19:
        if (getItemCount() > 0) goto L21;
        Log.e("TenantLayoutManager", "itemCount = " + getChildCount());
        return;
    L21:
        View r103 = r100.getViewForPosition(0);
        measureChildWithMargins(r103, 0, 0);
        addView(r103);
        r103.setVisibility(0);
        throw null;
    L9:
        if (r101.isPreLayout() == false) goto L11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (((getWidth() - getPaddingLeft()) - getPaddingRight()) < 0) goto L5;
        int r103 = 0;
    L6:
        int r104 = this.f448161a;
        int r105 = 0 - r103;
        if (r104 > r105) goto L9;
        this.f448161a = r104 + r100;
    L9:
        int r106 = this.f448161a;
        if (r106 <= r105) goto L12;
        this.f448161a = r105;
    L14:
        return 0;
    L12:
        if (r106 >= 0) goto L16;
        this.f448161a = 0;
        goto L14
    L16:
        return r100;
    L5:
        r103 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    }
}
