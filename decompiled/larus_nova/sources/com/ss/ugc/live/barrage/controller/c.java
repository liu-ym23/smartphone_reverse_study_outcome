package com.ss.ugc.live.barrage.controller;

import android.view.View;
import com.ss.ugc.live.barrage.view.SurfaceBarrageLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends com.ss.ugc.live.barrage.util.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AbsBarrageController f458136l;

    public c(AbsBarrageController r100) {
        this.f458136l = r100;
    }

    @Override // com.ss.ugc.live.barrage.util.d
    public final void a(int r100, int r101) {
        AbsBarrageController r102 = this.f458136l;
        float r103 = r102.f458098e;
        float r104 = r100 / r101;
        float r105 = 1000;
        float r106 = r104 * r105;
        r102.f458098e = r106;
        float r107 = r106 - r103;
        if (r106 >= r103) goto L5;
        r107 = (r105 - r103) + r106;
    L5:
        r102.j(r102.f458094a, r107);
        if (this.f458136l.f458095b.isEmpty() == true) goto L8;
    L12:
        View r108 = this.f458136l.f458104k;
        if ((r108 instanceof SurfaceBarrageLayout) == false) goto L15;
        ((SurfaceBarrageLayout) r108).c();
        return;
    L15:
        r108.invalidate();
        return;
    L8:
        if (this.f458136l.f458096c.isEmpty() == false) goto L12;
        if (this.f458136l.f458094a.isEmpty() == false) goto L12;
        this.f458136l.p();
        goto L12
    }
}
