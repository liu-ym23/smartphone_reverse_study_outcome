package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleBallSwipeRefreshLayout f193428a;

    public c(DoubleBallSwipeRefreshLayout r100) {
        this.f193428a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        DoubleBallSwipeRefreshLayout r102 = this.f193428a;
        r102.scrollTo(0, (int) (r102.f193303e * r100));
    }
}
