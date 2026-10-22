package io.noties.markwon.html.tag;

import java.util.Arrays;
import java.util.Collection;
import lsc.t;
import lsc.x;
import org.commonmark.node.StrongEmphasis;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"b", "strong"});
    }

    public k() {
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r100, t r101, tsc.l r102) {
        x r103 = ((lsc.l) r100.f510595e).a(StrongEmphasis.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.a(r100, r101);
    }
}
