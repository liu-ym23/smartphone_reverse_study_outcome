package io.noties.markwon.html.tag;

import lsc.t;
import lsc.y;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i extends a0 {
    public abstract Object e(lsc.h r100, t r101, tsc.l r102);

    public i() {
    }

    @Override // tsc.a0
    public final void a(lsc.m r100, v r101, tsc.l r102) {
        if (r102.isBlock() == false) goto L5;
        a0.d(r100, r101, r102.a());
    L5:
        Object r103 = e(r100.B(), r100.r(), r102);
        if (r103 == null) goto L9;
        y.f(r100.builder(), r103, r102.start(), r102.end());
        return;
    }
}
