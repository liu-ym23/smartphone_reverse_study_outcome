package com.bytedance.ee.bear.bitable.homepage.recommend.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/widget/FastScrollStaggerLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "<init>", "(II)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "findFirstCompletelyVisibleItemPositions", "", "into", "findLastCompletelyVisibleItemPositions", "findFirstVisibleItemPositions", "findLastVisibleItemPositions", "getSafeCacheArray", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FastScrollStaggerLayoutManager extends StaggeredGridLayoutManager {
    public FastScrollStaggerLayoutManager(int r100) {
        super(r100, 1);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager
    public final int[] findFirstCompletelyVisibleItemPositions(int[] r100) {
        return super.findFirstCompletelyVisibleItemPositions(p(r100));
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager
    public final int[] findFirstVisibleItemPositions(int[] r100) {
        return super.findFirstVisibleItemPositions(p(r100));
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager
    public final int[] findLastCompletelyVisibleItemPositions(int[] r100) {
        return super.findLastCompletelyVisibleItemPositions(p(r100));
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager
    public final int[] findLastVisibleItemPositions(int[] r100) {
        return super.findLastVisibleItemPositions(p(r100));
    }

    public final int[] p(int[] r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length < getSpanCount()) goto L7;
        return r100;
    L7:
        return new int[getSpanCount()];
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "state");
        final Context r103 = r100.getContext();
        LinearSmoothScroller r104 = new FastScrollStaggerLayoutManager$smoothScrollToPosition$smoothScroller$1(r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }
}
