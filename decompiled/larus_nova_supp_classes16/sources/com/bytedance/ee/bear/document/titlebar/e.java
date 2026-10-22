package com.bytedance.ee.bear.document.titlebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ OfficeImmersiveTitleBarBehavior b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        BaseTitlePlugin.a r3 = this.b.h;
        if (r3 == null) goto L8;
        EditModeSwitchPlugin.b r4 = (EditModeSwitchPlugin.b) r3;
        if (EditModeSwitchPlugin.access$600(r4.a) == false) goto L9;
        r4.a.showButton();
        return;
    L9:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.setVisibility(0);
    }

    public e(OfficeImmersiveTitleBarBehavior r1, AppBarLayout r2) {
        this.b = r1;
        this.a = r2;
    }
}
