package qa7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f532272d;

    @Override // qa7.b
    public final void a() {
        Iterator r100 = ((ArrayList) this.f532272d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).a();
        goto L4
    L6:
        super.a();
    }

    public final b c() {
        b r100 = new b();
        f.a();
        ((ArrayList) this.f532272d).add(r100);
        return r100;
    }

    public c() {
        this.f532272d = new ArrayList();
    }
}
