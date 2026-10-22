package com.obric.oui.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tla.c f400113a;

    public m(tla.c r100) {
        this.f400113a = r100;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        return (float) this.f400113a.a(r100);
    }
}
