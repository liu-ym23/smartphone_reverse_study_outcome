package cq5;

import com.bytedance.ee.bear.contract.route.parcelable.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements g {
    public final ArrayList<g.a> a;

    public b() {
        this.a = new ArrayList();
    }

    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.remove(r2);
    }

    public final void c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.add(r2);
    }

    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r4, "spaceClassId");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g.a) r0.next()).a(r3, r4);
        goto L4
    }
}
