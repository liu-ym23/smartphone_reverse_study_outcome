package com.bytedance.ee.bear.doc.screenshot;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends DocShotView.b {
    public final /* synthetic */ DocShotView a;

    @Override // com.bytedance.ee.bear.doc.screenshot.DocShotView.b, android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public c(DocShotView r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        xu5.b.a r4 = this.a.g;
        if (r4 == null) goto L6;
        r4.saveState();
        this.a.g.d(2131100548, true);
        return;
    }
}
