package com.larus.bmhome.chat;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0018\u00010\nR\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/WrapStaggeredGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "<init>", "(II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "smoothScrollToPosition", "recyclerView", "position", "CenterSmoothScroller", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrapStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    public static final class a extends LinearSmoothScroller {
        public a(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDtToFit(int r100, int r101, int r102, int r110, int r111) {
            int r112 = (((r110 - r102) / 2) + r102) - (((r101 - r100) / 2) + r100);
            if (r102 != 0) goto L5;
            if (r110 != 0) goto L5;
        L7:
            return super.calculateDtToFit(r100, r101, r102, r110, -1);
        L5:
            if (r112 < 0) goto L7;
            return r112;
        }
    }

    public WrapStaggeredGridLayoutManager(int r100, int r101) {
        super(r100, r101);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.w("WrapStaggeredGridLayoutManager", "exception: " + e);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        a r103 = new a(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
