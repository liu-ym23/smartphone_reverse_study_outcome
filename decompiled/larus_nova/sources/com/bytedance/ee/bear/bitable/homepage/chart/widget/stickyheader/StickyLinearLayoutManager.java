package com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ts4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00015BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\u0010\n\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0005J$\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0005H\u0016J\u001c\u0010$\u001a\u00020\u001a2\n\u0010%\u001a\u00060&R\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0005H\u0016J$\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\n\u0010%\u001a\u00060&R\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J$\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\n\u0010%\u001a\u00060&R\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010,\u001a\u00020\u001a2\n\u0010%\u001a\u00060&R\u00020 H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020 2\n\u0010%\u001a\u00060&R\u00020 H\u0016J\b\u00100\u001a\u00020\u001aH\u0002J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020302H\u0002J\b\u00104\u001a\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bj\u0002`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/StickyLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "mViewHolderProviderFactory", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/IViewHolderProvider$Factory;", "mHeaderPositionProvider", "Lkotlin/Function0;", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/HeaderPositionProvider;", "<init>", "(Landroid/content/Context;IZLcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/IViewHolderProvider$Factory;Lkotlin/jvm/functions/Function0;)V", "mHeaderHandler", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/StickyHeaderHandler;", "mHeaderPositions", "", "viewHolderFactory", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/IViewHolderProvider;", "headerElevation", "mHeaderListener", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/stickyheader/StickyLinearLayoutManager$StickyHeaderListener;", "setStickyHeaderListener", "", "listener", "elevateHeaders", "dpElevation", "smoothScrollToPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "scrollHorizontallyBy", "dx", "removeAndRecycleAllViews", "onAttachedToWindow", "view", "onDetachedFromWindow", "resetHeaderHandler", "getVisibleHeaders", "", "Landroid/view/View;", "cacheHeaderPositions", "StickyHeaderListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StickyLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f212701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Collection<Integer>> f212702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ts4.a f212703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f212704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f212705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f212706f;

    public final Map<Integer, View> p() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L10;
        int r104 = getPosition(r103);
        List<Integer> r105 = this.f212704d;
        ArrayList r106 = (ArrayList) r105;
        if (r106.contains(Integer.valueOf(r104)) == false) goto L10;
        r100.put(Integer.valueOf(r104), r103);
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return r100;
    }

    public final void q() {
        ts4.a r100 = this.f212703c;
        boolean r101 = true;
        if (r100 == null) goto L5;
        r100.f547376b = getOrientation();
        r100.f547377c = -1;
        r100.f547378d = true;
        ViewParent r102 = r100.f547382h.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r102).post(new c(r100, -1));
    L5:
        ts4.a r103 = this.f212703c;
        if (r103 == null) goto L13;
        int r104 = findFirstVisibleItemPosition();
        Map<Integer, View> r105 = p();
        b r106 = this.f212705e;
        if (findFirstCompletelyVisibleItemPosition() == 0) goto L11;
        r101 = false;
    L11:
        r103.d(r104, r105, r106, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f212705e = this.f212701a.a(r100);
        ts4.a r101 = new ts4.a(r100);
        this.f212703c = r101;
        int r102 = this.f212706f;
        if (r102 == (-1)) goto L5;
        r101.f547385k = r102;
    L7:
        if (((ArrayList) this.f212704d).size() <= 0) goto L12;
        ts4.a r103 = this.f212703c;
        if (r103 == null) goto L11;
        r103.f547375a = this.f212704d;
    L11:
        q();
    L12:
        super.onAttachedToWindow(r100);
        return;
    L5:
        r101.f547384j = -1;
        r101.f547385k = -1;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void removeAndRecycleAllViews(RecyclerView.Recycler r100) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        super.removeAndRecycleAllViews(r100);
        ts4.a r101 = this.f212703c;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        super.scrollToPositionWithOffset(r100, 0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "recycler");
        ts4.a r102 = this.f212703c;
        if (r102 == null) goto L5;
        r102.f547382h.getViewTreeObserver().removeOnGlobalLayoutListener(r102.f547383i);
    L5:
        super.onDetachedFromWindow(r100, r101);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        super.onLayoutChildren(r100, r101);
        ((ArrayList) this.f212704d).clear();
        Collection<Integer> r102 = this.f212702b.invoke();
        ((ArrayList) this.f212704d).addAll(r102);
        ts4.a r103 = this.f212703c;
        if (r103 == null) goto L5;
        r103.f547375a = this.f212704d;
    L5:
        if (r103 == null) goto L8;
        q();
        return;
    }

    public StickyLinearLayoutManager(Context r100, b.a r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "mViewHolderProviderFactory");
        Intrinsics.checkNotNullParameter(r102, "mHeaderPositionProvider");
        super(r100, 1, false);
        this.f212701a = r101;
        this.f212702b = r102;
        this.f212704d = new ArrayList();
        this.f212706f = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = super.scrollHorizontallyBy(r100, r101, r102);
        if (Math.abs(r103) <= 0) goto L11;
        ts4.a r104 = this.f212703c;
        if (r104 == null) goto L11;
        int r105 = findFirstVisibleItemPosition();
        Map<Integer, View> r106 = p();
        b r107 = this.f212705e;
        if (findFirstCompletelyVisibleItemPosition() != 0) goto L9;
        boolean r108 = true;
    L10:
        r104.d(r105, r106, r107, r108);
        goto L11
    L9:
        r108 = false;
    L11:
        return r103;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = super.scrollVerticallyBy(r100, r101, r102);
        if (Math.abs(r103) <= 0) goto L11;
        ts4.a r104 = this.f212703c;
        if (r104 == null) goto L11;
        int r105 = findFirstVisibleItemPosition();
        Map<Integer, View> r106 = p();
        b r107 = this.f212705e;
        if (findFirstCompletelyVisibleItemPosition() != 0) goto L9;
        boolean r108 = true;
    L10:
        r104.d(r105, r106, r107, r108);
        goto L11
    L9:
        r108 = false;
    L11:
        return r103;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        final Context r103 = r100.getContext();
        LinearSmoothScroller r104 = new StickyLinearLayoutManager$smoothScrollToPosition$smoothScroller$1(r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }
}
