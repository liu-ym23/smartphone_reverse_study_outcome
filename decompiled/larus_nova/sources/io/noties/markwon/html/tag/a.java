package io.noties.markwon.html.tag;

import java.util.Collection;
import java.util.Collections;
import lsc.x;
import lsc.y;
import org.commonmark.node.BlockQuote;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends a0 {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Collections.singleton("blockquote");
    }

    public a() {
    }

    @Override // tsc.a0
    public final void a(lsc.m r100, v r101, tsc.l r102) {
        if (r102.isBlock() == false) goto L5;
        a0.d(r100, r101, r102.a());
    L5:
        lsc.h r103 = r100.B();
        x r104 = ((lsc.l) r103.f510595e).a(BlockQuote.class);
        if (r104 == null) goto L9;
        y.f(r100.builder(), r104.a(r103, r100.r()), r102.start(), r102.end());
        return;
    }
}
