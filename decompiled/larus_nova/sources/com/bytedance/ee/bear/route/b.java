package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f236658a;

    public b(d... r100) {
        ArrayList r101 = new ArrayList();
        this.f236658a = r101;
        r101.addAll(Arrays.asList(r100));
    }

    public final void f(d r100) {
        if (((ArrayList) this.f236658a).contains(r100) == true) goto L6;
        ((ArrayList) this.f236658a).add(r100);
        return;
    }

    public final boolean g(Context r100, BearUrl r101, RouteBean r102) {
        Iterator r103 = ((ArrayList) this.f236658a).iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        d r104 = (d) r103.next();
        if (r104.b(r100, r101, r102) == false) goto L4;
        tt5.a.h("AbsRoutePriorityInterceptor", "dispatchHighPriority()...interceptor = " + r104);
        return true;
    L9:
        return false;
    }
}
