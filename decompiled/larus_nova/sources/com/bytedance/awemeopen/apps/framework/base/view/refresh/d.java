package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleBallSwipeRefreshLayout f193429a;

    public d(DoubleBallSwipeRefreshLayout r100) {
        this.f193429a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        this.f193429a.setAnimationProgress(1.0f - r100);
    }
}
