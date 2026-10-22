package com.larus.common_ui.photoviewer.circular;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010!\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/common_ui/photoviewer/circular/CircularLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "isLooperEnabled", "", "()Z", "setLooperEnabled", "(Z)V", "pendingScrollPosition", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollHorizontally", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "scrollToPosition", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "scrollHorizontallyBy", "dx", LynxVideoManagerLite.FILL, "x", "recycleHideView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircularLayoutManager extends RecyclerView.LayoutManager {
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return true;
    }

    public final Context getContext() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r110, "recycler");
        Intrinsics.checkNotNullParameter(r111, "state");
        if (getItemCount() > 0) goto L5;
        return;
    L5:
        if (r111.isPreLayout() == true) goto L15;
        detachAndScrapAttachedViews(r110);
        int r112 = getItemCount();
        int r100 = 0;
        int r101 = 0;
    L8:
        if (r100 >= r112) goto L16;
        View r102 = r110.getViewForPosition(r100);
        addView(r102);
        measureChildWithMargins(r102, 0, 0);
        int r103 = getDecoratedMeasuredWidth(r102);
        int r104 = r101 + r103;
        layoutDecorated(r102, r101, 0, r104, getDecoratedMeasuredHeight(r102));
        if (r104 > getWidth()) goto L17;
        r100 = r100 + 1;
        r101 = r104;
        goto L8
    L17:
        return;
    L16:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r110, "recycler");
        Intrinsics.checkNotNullParameter(r111, "state");
        Intrinsics.checkNotNullParameter(r110, "recycler");
        Intrinsics.checkNotNullParameter(r111, "state");
        int r112 = 0;
        if (r100 <= 0) goto L16;
        View r101 = getChildAt(getChildCount() - 1);
        if (r101 == null) goto L18;
        int r102 = getPosition(r101);
        if (r101.getRight() < getWidth()) goto L10;
    L27:
        int r103 = r100;
    L28:
        if (r103 != 0) goto L30;
        return 0;
    L30:
        offsetChildrenHorizontal(-r103);
        int r104 = getChildCount();
    L31:
        if (r112 >= r104) goto L43;
        View r105 = getChildAt(r112);
        if (r105 == null) goto L42;
        if (r100 <= 0) goto L40;
        if (r105.getRight() >= 0) goto L42;
        removeAndRecycleView(r105, r110);
        goto L42
    L40:
        if (r105.getLeft() <= getWidth()) goto L42;
        removeAndRecycleView(r105, r110);
    L42:
        r112 = r112 + 1;
        goto L31
    L43:
        return r103;
    L10:
        if (r102 != (getItemCount() - 1)) goto L12;
        View r106 = null;
        r103 = 0;
    L13:
        if (r106 == null) goto L28;
        addView(r106);
        measureChildWithMargins(r106, 0, 0);
        int r107 = getDecoratedMeasuredWidth(r106);
        layoutDecorated(r106, r101.getRight(), 0, r101.getRight() + r107, getDecoratedMeasuredHeight(r106));
        goto L28
    L12:
        r106 = r110.getViewForPosition(r102 + 1);
        r103 = r100;
    L18:
        r103 = 0;
        goto L28
    L16:
        View r108 = getChildAt(0);
        if (r108 == null) goto L18;
        int r109 = getPosition(r108);
        if (r108.getLeft() < 0) goto L27;
        if (r109 != 0) goto L23;
        View r113 = null;
        r103 = 0;
    L24:
        if (r113 == null) goto L18;
        addView(r113, 0);
        measureChildWithMargins(r113, 0, 0);
        int r114 = getDecoratedMeasuredWidth(r113);
        layoutDecorated(r113, r108.getLeft() - r114, 0, r108.getLeft(), getDecoratedMeasuredHeight(r113));
        goto L28
    L23:
        r113 = r110.getViewForPosition(r109 - 1);
        r103 = r100;
        goto L24
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        LinearSmoothScroller r103 = new LinearSmoothScroller(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
