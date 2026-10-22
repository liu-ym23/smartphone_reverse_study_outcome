package com.lynx.tasm.behavior.ui.swiper;

import android.view.View;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XSwiperUI f383073a;

    public d(XSwiperUI r100) {
        this.f383073a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        XSwiperUI r101 = this.f383073a;
        r101.f383057u = true;
        if (r101.f383050n == false) goto L6;
        r101.C.removeCallbacks(r101.E);
        XSwiperUI r102 = this.f383073a;
        r102.C.postDelayed(r102.E, r102.f383053q);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        XSwiperUI r101 = this.f383073a;
        if (r101.f383061y == true) goto L5;
    L13:
        XSwiperUI r102 = this.f383073a;
        r102.f383057u = false;
        r102.C.removeCallbacks(r102.E);
        return;
    L5:
        if (((SwiperView) XSwiperUI.M(r101)).f382994a.f383016j == false) goto L13;
        ViewPager r103 = ((SwiperView) XSwiperUI.N(this.f383073a)).f382994a;
        if (r103.f383012g1 != Integer.MIN_VALUE) goto L9;
    L12:
        r103.f383012g1 = Integer.MIN_VALUE;
        goto L13
    L9:
        if (r103.m() == false) goto L11;
        r103.scrollTo(r103.f383015i.getCurrX(), r103.f383012g1);
        goto L12
    L11:
        r103.scrollTo(r103.f383012g1, r103.f383015i.getCurrY());
        goto L12
    }
}
