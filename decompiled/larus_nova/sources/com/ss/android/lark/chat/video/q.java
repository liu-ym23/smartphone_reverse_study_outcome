package com.ss.android.lark.chat.video;

import android.transition.Transition;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f416834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoPreviewActivity f416835b;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r100) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r100) {
        this.f416834a.tD();
        this.f416835b.setRequestedOrientation(-1);
        this.f416835b.getWindow().getSharedElementEnterTransition().removeListener(this);
    }

    public q(p r100, VideoPreviewActivity r101) {
        this.f416834a = r100;
        this.f416835b = r101;
    }
}
