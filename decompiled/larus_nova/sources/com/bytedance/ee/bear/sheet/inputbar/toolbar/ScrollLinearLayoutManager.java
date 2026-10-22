package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class ScrollLinearLayoutManager extends LinearLayoutManager {

    public class a extends LinearSmoothScroller {
        public a(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics r100) {
            return 200.0f / r100.densityDpi;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final PointF computeScrollVectorForPosition(int r100) {
            return super.computeScrollVectorForPosition(r100);
        }
    }

    public ScrollLinearLayoutManager(Context r100) {
        super(r100, 0, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        a r103 = new a(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
