package com.bytedance.ee.bear.document.titlebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f222196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImmersiveTitleBarBehavior f222197b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f222196a.setVisibility(4);
        BaseTitlePlugin.a r101 = this.f222197b.f222129h;
        if (r101 == null) goto L6;
        ((EditModeSwitchPlugin.b) r101).f217880a.hideButton();
        return;
    }

    public b(ImmersiveTitleBarBehavior r100, AppBarLayout r101) {
        this.f222197b = r100;
        this.f222196a = r101;
    }
}
