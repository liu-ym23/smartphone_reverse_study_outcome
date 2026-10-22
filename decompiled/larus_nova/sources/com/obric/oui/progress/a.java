package com.obric.oui.progress;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ODownloadProgressView.a f402544a;

    public a(ODownloadProgressView.a r100) {
        this.f402544a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f402544a.f402528a.invalidate();
    }
}
