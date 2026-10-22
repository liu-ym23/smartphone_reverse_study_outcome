package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ScrollLinearLayoutManager extends LinearLayoutManager {

    public class a extends LinearSmoothScroller {
        public a(Context r1) {
            super(r1);
        }

        public final float calculateSpeedPerPixel(DisplayMetrics r2) {
            return 200.0f / r2.densityDpi;
        }

        public final PointF computeScrollVectorForPosition(int r1) {
            return super/*androidx.recyclerview.widget.RecyclerView.SmoothScroller*/.computeScrollVectorForPosition(r1);
        }
    }

    public ScrollLinearLayoutManager(Context r2) {
        super(r2, 0, false);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        a r4 = new a(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
