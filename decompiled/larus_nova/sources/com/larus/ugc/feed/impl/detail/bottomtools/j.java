package com.larus.ugc.feed.impl.detail.bottomtools;

import android.view.animation.Animation;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class j implements Animation.AnimationListener {
    public j() {
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
