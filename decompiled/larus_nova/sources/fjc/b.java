package fjc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Runnable> f477548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f477549b;

    public b() {
    }

    public final void b() {
        if (this.f477549b == false) goto L6;
        return;
    L6:
        if (c() == false) goto L8;
        return;
    L8:
        this.f477549b = true;
        Iterator r100 = new ArrayList(this.f477548a).iterator();
    L10:
        if (r100.hasNext() == false) goto L12;
        ((Runnable) r100.next()).run();
        goto L10
    L12:
        ((ArrayList) this.f477548a).clear();
        this.f477549b = false;
    }

    public final boolean c() {
        List<Runnable> r100 = this.f477548a;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (((ArrayList) r100).isEmpty() == true) goto L8;
        return false;
    }

    public final void a() {
        if (c() == false) goto L5;
        return;
    L5:
        ((ArrayList) this.f477548a).clear();
    }
}
