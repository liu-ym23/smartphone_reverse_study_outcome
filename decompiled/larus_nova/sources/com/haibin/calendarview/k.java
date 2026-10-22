package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CalendarView f276154a;

    public k(CalendarView r100) {
        this.f276154a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f276154a.f276090a.getClass();
        CalendarView r101 = this.f276154a;
        CalendarLayout r102 = r101.f276096g;
        if (r102 == null) goto L12;
        ViewGroup r103 = r102.f276070g;
        if (r103 == null) goto L9;
        r103.setTranslationY(r102.getHeight() - r102.f276066c.getHeight());
        r102.f276070g.setVisibility(0);
        r102.f276070g.animate().translationY(0.0f).setDuration(180).setInterpolator(new LinearInterpolator()).setListener(new d());
    L9:
        if (this.f276154a.f276096g.c() == false) goto L11;
        this.f276154a.f276091b.setVisibility(0);
    L13:
        this.f276154a.f276091b.clearAnimation();
        return;
    L11:
        this.f276154a.f276092c.setVisibility(0);
        this.f276154a.f276096g.d(240);
        goto L13
    L12:
        r101.f276091b.setVisibility(0);
        goto L13
    }
}
