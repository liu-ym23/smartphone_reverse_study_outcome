package com.bytedance.ee.bear.doc.screenshot;

import android.view.animation.Animation;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends DocShotView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShotView f218117a;

    @Override // com.bytedance.ee.bear.doc.screenshot.DocShotView.b, android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public c(DocShotView r100) {
        this.f218117a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        xu5.b.a r101 = this.f218117a.f218102g;
        if (r101 == null) goto L6;
        r101.saveState();
        this.f218117a.f218102g.d(R.color.bg_body, true);
        return;
    }
}
