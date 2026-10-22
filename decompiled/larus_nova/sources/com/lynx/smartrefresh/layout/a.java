package com.lynx.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.lynx.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout.i f381549a;

    public a(SmartRefreshLayout.i r100) {
        this.f381549a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f381549a.f381548a.T1.d(RefreshState.TwoLevel);
    }
}
