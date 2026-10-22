package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends Animation {
    public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

    public c(DoubleBallSwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r2, Transformation r3) {
        DoubleBallSwipeRefreshLayout r4 = this.a;
        r4.scrollTo(0, (int) (r4.e * r2));
    }
}
