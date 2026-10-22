package gtc;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a {
    public a() {
    }

    public final void a(List<? extends g.b> r100) {
        Iterator<? extends g.b> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        g.b r102 = r101.next();
        if (r102.d() == true) goto L7;
        ((etc.c) this).f473965c.append(((g.e) r102).b());
        goto L4
    L7:
        g.d r103 = (g.d) r102;
        etc.c r104 = (etc.c) this;
        int r105 = r104.f473965c.length();
        r104.a(r103.children());
        int r106 = r104.f473965c.length();
        if (r106 == r105) goto L4;
        r104.f473964b.b(r104.f473963a, r103, r104.f473965c, r105, r106);
        goto L4
    }
}
