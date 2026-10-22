package com.obric.oui.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes34.dex */
public final class v implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tla.c f400227a;

    public v(tla.c r100) {
        this.f400227a = r100;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        return (float) this.f400227a.a(r100);
    }
}
