package io.noties.markwon.ext.onetex;

import io.noties.markwon.onetex.LatexMathBlock;
import lsc.y;
import uvc.b;

/* JADX INFO: loaded from: classes41.dex */
public final class r<N extends uvc.b> implements lsc.m.c<LatexMathBlock> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f492467a;

    public r(o r100) {
        this.f492467a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r110, uvc.b r111) {
        LatexMathBlock r112 = (LatexMathBlock) r111;
        r110.C(r112);
        String r100 = r112.f492652h;
        int r101 = r110.length();
        y r102 = r110.builder();
        this.f492467a.getClass();
        r102.c(o.r(r100));
        r110.o(r101, this.f492467a.p(r110.B().f510591a, r100, true, null, null, Integer.valueOf(this.f492467a.f492455e.f492402a.f492475f), Float.valueOf(this.f492467a.f492455e.f492402a.f492471b)));
        r110.q(r112);
    }
}
