package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends Animation {
    public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

    public d(DoubleBallSwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r2, Transformation r3) {
        this.a.setAnimationProgress(1.0f - r2);
    }
}
