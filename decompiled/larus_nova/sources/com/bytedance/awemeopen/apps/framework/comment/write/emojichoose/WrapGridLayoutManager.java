package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: classes14.dex */
public class WrapGridLayoutManager extends GridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f194447a;

    public class a extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WrapGridLayoutManager f194448a;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForScrolling(int r100) {
            return (int) (super.calculateTimeForScrolling(r100) * this.f194448a.f194447a);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final PointF computeScrollVectorForPosition(int r100) {
            return this.f194448a.computeScrollVectorForPosition(r100);
        }

        public a(WrapGridLayoutManager r100, Context r101) {
            this.f194448a = r100;
            super(r101);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        super.onAdapterChanged(r100, r101);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: IndexOutOfBoundsException -> L4 NullPointerException -> L6
        goto L10
    L9:
        return;
    L4:
        AoLogger.c("probe", new Object[]{"meet a IndexOutOfBoundsException in RecyclerView"});
        return;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L5:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        a r103 = new a(this, r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    public WrapGridLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f194447a = 3.0f;
    }
}
