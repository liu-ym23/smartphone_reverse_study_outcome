package com.bytedance.ee.bear.route;

import android.content.Context;
import com.bytedance.ee.bear.basesdk.services.route.UserRouteServiceImpl;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements com.bytedance.ee.bear.basesdk.services.route.c {
    public final t45.c a;
    public final CopyOnWriteArrayList<d> b;
    public final CopyOnWriteArrayList<com.bytedance.ee.bear.basesdk.services.route.c.a> c;

    public static final class a {
    }

    static {
    }

    public final void a(UserRouteServiceImpl.c r2) {
        if (this.c.contains(r2) == true) goto L6;
        this.c.add(r2);
        return;
    }

    public final void b(d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.b.contains(r3) == true) goto L9;
        this.b.add(0, r3);
        return;
    }

    public final void d(d r2) {
        if (r2 == null) goto L5;
        this.b.remove(r2);
        return;
    }

    public f(List<? extends d> r2, t45.c r3) {
        Intrinsics.checkNotNullParameter(r2, "routeInterceptors");
        Intrinsics.checkNotNullParameter(r3, "spaceKitUrlHelper");
        this.a = r3;
        CopyOnWriteArrayList<d> r4 = new CopyOnWriteArrayList();
        r4.addAll(r2);
        this.b = r4;
        this.c = new CopyOnWriteArrayList();
    }

    public final void c(z05.h r6, Class r7, Class r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (this.b.contains(r6) == true) goto L28;
        Iterator<d> r0 = this.b.iterator();
        int r2 = 0;
    L8:
        if (r0.hasNext() == false) goto L19;
        d r3 = r0.next();
        if (Intrinsics.areEqual(r3.getClass(), r7) == false) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L20;
        r2 = r2 + 1;
    L20:
        if (r2 < 0) goto L22;
        this.b.add(r2, r6);
        return;
    L22:
        this.b.add(0, r6);
        return;
    L12:
        if (Intrinsics.areEqual(r3.getClass(), r8) == true) goto L15;
        r4 = false;
        goto L16
    L19:
        r2 = -1;
        goto L20
    }

    public final void e(Context r6, String r7, RouteBean r8) {
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        BearUrl r9 = this.a.Z(r7);
        Iterator<com.bytedance.ee.bear.basesdk.services.route.c.a> r2 = this.c.iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        r2.next().a(r9, r8);
        goto L13
    L15:
        Iterator<d> r3 = this.b.iterator();
    L17:
        if (r3.hasNext() == false) goto L24;
        if (r3.next().b(r6, r9, r8) == false) goto L17;
        return;
    L22:
        e = move-exception;
        tt5.a.e("OfficeSimpleRouterManager", "route interceptor exception", e, false);
        goto L17
    L24:
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
