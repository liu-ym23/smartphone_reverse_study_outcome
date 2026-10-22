package com.bytedance.ee.bear.document.titlebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f222199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImmersiveTitleBarBehavior f222200b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        BaseTitlePlugin.a r101 = this.f222200b.f222129h;
        if (r101 == null) goto L8;
        EditModeSwitchPlugin.b r102 = (EditModeSwitchPlugin.b) r101;
        if (EditModeSwitchPlugin.access$600(r102.f217880a) == false) goto L9;
        r102.f217880a.showButton();
        return;
    L9:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f222199a.setVisibility(0);
    }

    public c(ImmersiveTitleBarBehavior r100, AppBarLayout r101) {
        this.f222200b = r100;
        this.f222199a = r101;
    }
}
