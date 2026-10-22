package io.noties.markwon.html.tag;

import android.text.style.UnderlineSpan;
import java.util.Arrays;
import java.util.Collection;
import lsc.y;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: classes5.dex */
public class n extends a0 {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"u", "ins"});
    }

    public n() {
    }

    @Override // tsc.a0
    public void a(lsc.m r100, v r101, tsc.l r102) {
        if (r102.isBlock() == false) goto L5;
        a0.d(r100, r101, r102.a());
    L5:
        y.f(r100.builder(), new UnderlineSpan(), r102.start(), r102.end());
    }
}
