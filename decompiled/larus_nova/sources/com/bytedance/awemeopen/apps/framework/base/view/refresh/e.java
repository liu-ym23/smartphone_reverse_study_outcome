package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f193430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f193431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoubleBallSwipeRefreshLayout f193432c;

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        MaterialProgressDrawable r102 = this.f193432c.f193322x;
        int r103 = this.f193430a;
        r102.f193384b.f193414u = (int) (r103 + ((this.f193431b - r103) * r100));
    }

    public e(DoubleBallSwipeRefreshLayout r100, int r101, int r102) {
        this.f193432c = r100;
        this.f193430a = r101;
        this.f193431b = r102;
    }
}
