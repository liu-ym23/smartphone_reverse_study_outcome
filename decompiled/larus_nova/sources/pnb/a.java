package pnb;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements tnb.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f529990a;

    public a(b r100) {
        this.f529990a = r100;
    }

    @Override // tnb.f
    public final void c(String r100) {
        b r101 = this.f529990a;
        Set<d> r102 = r101.f529993c;
        if (r102 != null) goto L5;
    L11:
        rnb.c.c("bridge_receive", "responseFromDocs: no listener");
        return;
    L5:
        if (((CopyOnWriteArraySet) r102).isEmpty() == true) goto L11;
        Iterator r103 = ((CopyOnWriteArraySet) r101.f529993c).iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        ((d) r103.next()).b(r100);
        goto L9
    }

    @Override // tnb.f
    public final void d(String r100) {
        b r101 = this.f529990a;
        Set<d> r102 = r101.f529993c;
        if (r102 != null) goto L5;
    L11:
        rnb.c.c("bridge_receive", "responseFromJs: no listener");
        return;
    L5:
        if (((CopyOnWriteArraySet) r102).isEmpty() == true) goto L11;
        Iterator r103 = ((CopyOnWriteArraySet) r101.f529993c).iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        ((d) r103.next()).a(r100);
        goto L9
    }
}
