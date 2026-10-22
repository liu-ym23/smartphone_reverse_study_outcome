package com.bytedance.ee.bear.bizwidget.banner.util;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ScrollSpeedManger extends LinearLayoutManager {
    public final Banner a;

    public class a extends LinearSmoothScroller {
        public final /* synthetic */ ScrollSpeedManger a;

        public final int calculateTimeForDeceleration(int r1) {
            return this.a.a.getScrollTime();
        }

        public a(ScrollSpeedManger r1, Context r2) {
            this.a = r1;
            super(r2);
        }
    }

    public ScrollSpeedManger(Banner r3, LinearLayoutManager r4) {
        super(r3.getContext(), r4.getOrientation(), false);
        this.a = r3;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        a r4 = new a(this, r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
