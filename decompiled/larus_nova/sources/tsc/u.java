package tsc;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lsc.m f547483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f547484b;

    public final void a(List<l.a> r100) {
        Iterator<l.a> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        l.a r102 = r101.next();
        if (r102.isClosed() == false) goto L4;
        a0 r103 = this.f547484b.b(r102.name());
        if (r103 != null) goto L10;
        a(r102.children());
        goto L4
    L10:
        r103.a(this.f547483a, this.f547484b, r102);
        goto L4
    }

    public u(v r100, lsc.p r101) {
        this.f547484b = r100;
        this.f547483a = r101;
    }
}
