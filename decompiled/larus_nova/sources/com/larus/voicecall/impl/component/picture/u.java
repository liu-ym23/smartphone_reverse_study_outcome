package com.larus.voicecall.impl.component.picture;

import android.view.animation.Animation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes32.dex */
public final class u implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleDraweeView f377614a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    public u(SimpleDraweeView r100) {
        this.f377614a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        SimpleDraweeView r101 = this.f377614a;
        if (r101 == null) goto L6;
        e1.o(r101);
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        SimpleDraweeView r101 = this.f377614a;
        if (r101 == null) goto L6;
        e1.x(r101);
        return;
    }
}
