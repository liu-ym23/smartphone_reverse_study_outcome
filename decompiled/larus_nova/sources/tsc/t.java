package tsc;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lsc.m f547481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f547482b;

    public final void a(List<l.b> r100) {
        Iterator<l.b> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        l.b r102 = r101.next();
        if (r102.isClosed() == false) goto L4;
        a0 r103 = this.f547482b.b(r102.name());
        if (r103 == null) goto L4;
        r103.a(this.f547481a, this.f547482b, r102);
        goto L4
    }

    public t(v r100, lsc.p r101) {
        this.f547482b = r100;
        this.f547481a = r101;
    }
}
