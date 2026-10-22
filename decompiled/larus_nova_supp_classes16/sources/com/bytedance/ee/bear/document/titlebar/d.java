package com.bytedance.ee.bear.document.titlebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ OfficeImmersiveTitleBarBehavior b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.setVisibility(4);
        BaseTitlePlugin.a r3 = this.b.h;
        if (r3 == null) goto L6;
        ((EditModeSwitchPlugin.b) r3).a.hideButton();
        return;
    }

    public d(OfficeImmersiveTitleBarBehavior r1, AppBarLayout r2) {
        this.b = r1;
        this.a = r2;
    }
}
