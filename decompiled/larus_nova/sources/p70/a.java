package p70;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c<P>> f527975a;

    public a() {
        this.f527975a = new ArrayList();
    }

    public final boolean a(P r100) {
        Iterator r101 = ((ArrayList) this.f527975a).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((c) r101.next()).a(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
