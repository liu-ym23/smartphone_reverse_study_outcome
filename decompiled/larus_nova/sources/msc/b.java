package msc;

import io.noties.markwon.core.CoreProps;
import org.commonmark.node.Heading;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements lsc.m.c<Heading> {
    public b() {
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        Heading r102 = (Heading) r101;
        r100.C(r102);
        int r103 = r100.length();
        r100.c(r102);
        CoreProps.f492264f.c(r100.r(), Integer.valueOf(r102.f525767h));
        r100.G(r102, r103);
        r100.q(r102);
    }
}
