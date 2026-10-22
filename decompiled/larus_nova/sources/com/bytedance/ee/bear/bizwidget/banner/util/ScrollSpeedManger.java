package com.bytedance.ee.bear.bizwidget.banner.util;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;

/* JADX INFO: loaded from: classes16.dex */
public class ScrollSpeedManger extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Banner f216364a;

    public class a extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollSpeedManger f216365a;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForDeceleration(int r100) {
            return this.f216365a.f216364a.getScrollTime();
        }

        public a(ScrollSpeedManger r100, Context r101) {
            this.f216365a = r100;
            super(r101);
        }
    }

    public ScrollSpeedManger(Banner r100, LinearLayoutManager r101) {
        super(r100.getContext(), r101.getOrientation(), false);
        this.f216364a = r100;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        a r103 = new a(this, r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
