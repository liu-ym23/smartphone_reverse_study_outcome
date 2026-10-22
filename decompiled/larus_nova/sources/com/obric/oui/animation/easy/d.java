package com.obric.oui.animation.easy;

import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements jla.b.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b<View> f398748a;

    public d(b<View> r100) {
        this.f398748a = r100;
    }

    @Override // jla.b.j
    public final void a(jla.b<? extends jla.b<?>> r100, float r101, float r102) {
        jla.b.j r103 = this.f398748a.f398744g;
        if (r103 == null) goto L7;
        r103.a(r100, r101, r102);
        return;
    }
}
