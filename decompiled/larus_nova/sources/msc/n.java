package msc;

import lsc.x;
import org.commonmark.node.Image;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements lsc.m.c<Image> {
    public n() {
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        Image r102 = (Image) r101;
        x r103 = ((lsc.l) r100.B().f510595e).a(Image.class);
        if (r103 != null) goto L5;
        r100.c(r102);
        return;
    L5:
        int r104 = r100.length();
        r100.c(r102);
        if (r104 != r100.length()) goto L8;
        r100.builder().a(65532);
    L8:
        lsc.h r105 = r100.B();
        boolean r106 = r102.f551900a instanceof Link;
        xsc.a r107 = r105.f510594d;
        String r108 = r102.f525770h;
        ((xsc.a.C8270a) r107).getClass();
        lsc.t r109 = r100.r();
        wsc.n.f561168a.c(r109, r108);
        wsc.n.f561169b.c(r109, Boolean.valueOf(r106));
        wsc.n.f561170c.c(r109, null);
        r100.o(r104, r103.a(r105, r109));
    }
}
