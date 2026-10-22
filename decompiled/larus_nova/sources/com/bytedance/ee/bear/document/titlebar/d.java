package com.bytedance.ee.bear.document.titlebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f222204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeImmersiveTitleBarBehavior f222205b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f222204a.setVisibility(4);
        BaseTitlePlugin.a r101 = this.f222205b.f222157h;
        if (r101 == null) goto L6;
        ((EditModeSwitchPlugin.b) r101).f217880a.hideButton();
        return;
    }

    public d(OfficeImmersiveTitleBarBehavior r100, AppBarLayout r101) {
        this.f222205b = r100;
        this.f222204a = r101;
    }
}
