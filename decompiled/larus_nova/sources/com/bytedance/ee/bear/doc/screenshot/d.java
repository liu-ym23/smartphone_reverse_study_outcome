package com.bytedance.ee.bear.doc.screenshot;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends DocShotView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShotView f218118a;

    public d(DocShotView r100) {
        this.f218118a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f218118a.f218109n.setVisibility(8);
        this.f218118a.f218101f.setVisibility(8);
        this.f218118a.setVisibility(8);
    }
}
