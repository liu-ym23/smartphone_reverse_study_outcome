package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Animation.AnimationListener {
    public final /* synthetic */ KtvPreviewSongsWidget a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public a(KtvPreviewSongsWidget r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        this.a.g.setShowPreviewCard(false, "UnloadWidgetAfterAnimation");
    }
}
