package wl3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f560187a;

    public c() {
        this.f560187a = new ArrayList();
    }

    public final void a(d r100) {
        Iterator r101 = ((ArrayList) this.f560187a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((d) r102).f560188a, r100.f560188a) == false) goto L4;
    L9:
        d r103 = (d) r102;
        if (r103 == null) goto L12;
        ((ArrayList) this.f560187a).remove(r103);
    L12:
        ((ArrayList) this.f560187a).add(r100);
        return;
    L8:
        r102 = null;
        goto L9
    }
}
