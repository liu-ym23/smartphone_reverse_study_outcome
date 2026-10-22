package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.tools.utils.i;

/* JADX INFO: loaded from: classes40.dex */
public class ScrollCenterLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f455065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f455066b;

    public static class a extends LinearSmoothScroller {
        public a(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics r100) {
            return 200.0f / r100.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
            return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        scrollToPositionWithOffset(r100, (int) ((getWidth() / 2) - i.a(this.f455066b, 45.0f)));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Context r103 = r100.getContext();
        if (this.f455065a != null) goto L5;
        this.f455065a = new a(r103);
    L5:
        a r104 = this.f455065a;
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }

    public ScrollCenterLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f455066b = r100;
    }
}
