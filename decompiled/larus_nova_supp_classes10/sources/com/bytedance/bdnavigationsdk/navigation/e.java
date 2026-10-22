package com.bytedance.bdnavigationsdk.navigation;

import com.bytedance.bdnavigationsdk.network.route.RoutePath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends NavigationService {
    public e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "navigationSessionId");
        Intrinsics.checkNotNullParameter(r3, "navigationBusinessId");
        super(r2, r3, NavigationTransport.TransportType.EBicycling);
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.NavigationService
    public final void C(RoutePath r20, com.bytedance.bdnavigationsdk.pojo.a r21) {
        Intrinsics.checkNotNullParameter(r20, "routePath");
        Intrinsics.checkNotNullParameter(r21, "routeDestination");
        this.e = r21;
        int r2 = 0;
        this.r = false;
        this.s = null;
        if (this.o != null) goto L6;
        this.o = new LinkedHashMap();
    L6:
        if (this.p != null) goto L8;
        this.p = new ArrayList();
    L8:
        this.h = 0.0f;
        this.i = 0.0f;
        if (this.j != null) goto L12;
        this.j = new ArrayList();
    L12:
        if (this.g != null) goto L14;
        this.g = new ArrayList();
    L14:
        List<com.bytedance.bdnavigationsdk.pojo.d> r4 = this.j;
        Intrinsics.checkNotNull(r4);
        if (r4.isEmpty() == true) goto L30;
        List<List<com.bytedance.bdnavigationsdk.pojo.d>> r5 = this.g;
        Intrinsics.checkNotNull(r5);
        List<com.bytedance.bdnavigationsdk.pojo.d> r6 = this.j;
        Intrinsics.checkNotNull(r6);
        r5.add(r6);
        ArrayList r7 = new ArrayList();
        this.j = r7;
        Intrinsics.checkNotNull(r7);
        int r8 = r7.size() - 1;
        if (r8 < 0) goto L30;
        boolean r9 = true;
        int r10 = 0;
        int r11 = -1;
        int r12 = -1;
    L20:
        int r13 = r8 - 1;
        List<com.bytedance.bdnavigationsdk.pojo.d> r14 = this.j;
        Intrinsics.checkNotNull(r14);
        com.bytedance.bdnavigationsdk.pojo.d r15 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r14, r8);
        int r16 = r15.d;
        if (r9 == false) goto L23;
        r15.d = r11;
        r15.c = r12;
        r9 = false;
    L26:
        this.h += r15.e;
        this.i += r15.f;
        r12 = r12 - 1;
        if (r13 < 0) goto L30;
        r8 = r13;
        r10 = r16;
        goto L20
    L23:
        if (r10 == r16) goto L25;
        r11 = r11 - 1;
    L25:
        r15.d = r11;
        r15.c = r12;
    L30:
        this.k = 0.0f;
        this.l = 0.0f;
        List<com.bytedance.bdnavigationsdk.pojo.d> r3 = this.m;
        if (r3 != null) goto L33;
        this.m = new ArrayList();
    L35:
        if (this.f != null) goto L37;
        this.f = new ArrayList();
    L37:
        ArrayList r17 = new ArrayList();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        this.n = r17;
        List<com.bytedance.bdnavigationsdk.network.route.q> r18 = r20.d;
        Intrinsics.checkNotNull(r18);
        int r19 = r18.size();
        int r22 = 0;
        int r23 = 0;
    L38:
        if (r22 >= r19) goto L43;
        List<com.bytedance.bdnavigationsdk.network.route.q> r24 = r20.d;
        Intrinsics.checkNotNull(r24);
        com.bytedance.bdnavigationsdk.network.route.q r110 = (com.bytedance.bdnavigationsdk.network.route.q) ListProtector.get(r24, r22);
        float r111 = r110.c;
        com.bytedance.bdnavigationsdk.network.route.e r25 = r110.d;
        Intrinsics.checkNotNull(r25);
        float r112 = r25.a;
        List<com.bytedance.bdnavigationsdk.pojo.a> r26 = r110.g;
        Intrinsics.checkNotNull(r26);
        int r113 = r26.size() - 1;
        int r114 = r23;
        int r27 = 0;
    L40:
        if (r27 >= r113) goto L42;
        List<com.bytedance.bdnavigationsdk.pojo.a> r28 = r110.g;
        Intrinsics.checkNotNull(r28);
        com.bytedance.bdnavigationsdk.pojo.a r29 = (com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r28, r27);
        List<com.bytedance.bdnavigationsdk.pojo.a> r30 = r110.g;
        Intrinsics.checkNotNull(r30);
        int r115 = r27 + 1;
        com.bytedance.bdnavigationsdk.pojo.d r116 = new com.bytedance.bdnavigationsdk.pojo.d(r29, (com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r30, r115), r114, r22, 2032);
        r116.f = (r116.e / r111) * r112;
        List<com.bytedance.bdnavigationsdk.pojo.d> r31 = this.m;
        Intrinsics.checkNotNull(r31);
        r31.add(r116);
        this.k += r116.e;
        this.l += r116.f;
        r114 = r114 + 1;
        r27 = r115;
        goto L40
    L42:
        r22 = r22 + 1;
        r23 = r114;
        goto L38
    L43:
        this.d = r20;
        List<RoutePath> r32 = this.f;
        Intrinsics.checkNotNull(r32);
        RoutePath r33 = this.d;
        Intrinsics.checkNotNull(r33);
        r32.add(r33);
        int r1 = RangesKt.coerceAtLeast(r20.e.size() - 2, 0);
    L44:
        if (r2 >= r1) goto L46;
        this.n.add(new m(r2));
        r2 = r2 + 1;
        goto L44
    L46:
        this.q.a.clear();
        if (this.E != null) goto L49;
        this.E = new y84.f();
    L49:
        y84.h r34 = this.E;
        Intrinsics.checkNotNull(r34);
        r34.clear();
        y84.h r35 = this.E;
        Intrinsics.checkNotNull(r35);
        RoutePath r36 = this.d;
        Intrinsics.checkNotNull(r36);
        r35.b(r36);
        return;
    L33:
        Intrinsics.checkNotNull(r3);
        r3.clear();
        goto L35
    }
}
