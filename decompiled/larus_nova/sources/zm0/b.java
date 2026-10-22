package zm0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements tn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<tn0.a> f572853a;

    @Override // tn0.a
    public final void a() {
        Iterator<T> r100 = this.f572853a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tn0.a) r100.next()).a();
        goto L4
    }

    @Override // tn0.a
    public final void b() {
        Iterator<T> r100 = this.f572853a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tn0.a) r100.next()).b();
        goto L4
    }

    @Override // tn0.a
    public final void c() {
        Iterator<T> r100 = this.f572853a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tn0.a) r100.next()).c();
        goto L4
    }

    public b() {
        ArrayList r100 = new ArrayList();
        this.f572853a = r100;
        r100.add(new un0.a());
    }
}
