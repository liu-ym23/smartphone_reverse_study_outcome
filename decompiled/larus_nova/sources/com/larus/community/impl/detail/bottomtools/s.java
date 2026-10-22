package com.larus.community.impl.detail.bottomtools;

import android.view.animation.Animation;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class s implements Animation.AnimationListener {
    public s() {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        FLogger.f375446a.i("CreationDetailBottomToolsView", "onAnimationEnd");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        FLogger.f375446a.i("CreationDetailBottomToolsView", "onAnimationRepeat");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        FLogger.f375446a.i("CreationDetailBottomToolsView", "onAnimationStart");
    }
}
