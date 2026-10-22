package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b extends a {
    public final List<d> a;

    public b(d... r2) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.addAll(Arrays.asList(r2));
    }

    public final void f(d r2) {
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }

    public final boolean g(Context r4, BearUrl r5, RouteBean r6) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        d r1 = (d) r0.next();
        if (r1.b(r4, r5, r6) == false) goto L4;
        tt5.a.h("AbsRoutePriorityInterceptor", "dispatchHighPriority()...interceptor = " + r1);
        return true;
    L9:
        return false;
    }
}
