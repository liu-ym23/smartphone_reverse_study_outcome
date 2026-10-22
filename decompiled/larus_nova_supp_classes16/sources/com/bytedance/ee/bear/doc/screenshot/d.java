package com.bytedance.ee.bear.doc.screenshot;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends DocShotView.b {
    public final /* synthetic */ DocShotView a;

    public d(DocShotView r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        this.a.n.setVisibility(8);
        this.a.f.setVisibility(8);
        this.a.setVisibility(8);
    }
}
