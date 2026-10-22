package io.noties.markwon.ext.onetex;

import io.noties.markwon.onetex.LatexMathNode;
import lsc.y;
import uvc.b;

/* JADX INFO: loaded from: classes41.dex */
public final class s<N extends uvc.b> implements lsc.m.c<LatexMathNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f492468a;

    public s(o r100) {
        this.f492468a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r110) {
        String r101 = ((LatexMathNode) r110).f492653h;
        int r111 = r100.length();
        y r102 = r100.builder();
        this.f492468a.getClass();
        r102.c(o.r(r101));
        r100.o(r111, this.f492468a.p(r100.B().f510591a, r101, false, null, null, Integer.valueOf(this.f492468a.f492455e.f492402a.f492474e), Float.valueOf(this.f492468a.f492455e.f492402a.f492470a)));
    }
}
