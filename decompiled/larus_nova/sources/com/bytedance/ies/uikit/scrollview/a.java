package com.bytedance.ies.uikit.scrollview;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PagerSlidingTabStrip f249218a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f249218a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        PagerSlidingTabStrip r100 = this.f249218a;
        r100.f249195h = r100.f249193f.getCurrentItem();
        PagerSlidingTabStrip r101 = this.f249218a;
        PagerSlidingTabStrip.a(r101, r101.f249195h, 0);
    }

    public a(PagerSlidingTabStrip r100) {
        this.f249218a = r100;
    }
}
