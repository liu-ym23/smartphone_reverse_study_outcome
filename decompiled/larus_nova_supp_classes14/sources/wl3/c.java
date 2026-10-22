package wl3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final List<d> a;

    public c() {
        this.a = new ArrayList();
    }

    public final void a(d r5) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((d) r1).a, r5.a) == false) goto L4;
    L9:
        d r2 = (d) r1;
        if (r2 == null) goto L12;
        ((ArrayList) this.a).remove(r2);
    L12:
        ((ArrayList) this.a).add(r5);
        return;
    L8:
        r1 = null;
        goto L9
    }
}
