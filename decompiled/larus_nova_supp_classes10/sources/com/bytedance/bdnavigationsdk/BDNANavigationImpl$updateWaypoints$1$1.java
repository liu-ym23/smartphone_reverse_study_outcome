package com.bytedance.bdnavigationsdk;

import com.bytedance.bdnavigationsdk.navigation.NavigationService;
import com.bytedance.bdnavigationsdk.network.route.RoutePath;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class BDNANavigationImpl$updateWaypoints$1$1 extends FunctionReferenceImpl implements Function2<String, com.bytedance.bdnavigationsdk.network.route.p, Unit> {
    public BDNANavigationImpl$updateWaypoints$1$1(Object r8) {
        super(2, r8, BDNANavigationImpl.class, "handleUpdateWaypointsRoutePlanSuccess", "handleUpdateWaypointsRoutePlanSuccess(Ljava/lang/String;Lcom/bytedance/bdnavigationsdk/network/route/RouteResponse;)V", 0);
    }

    public final void invoke(String r9, com.bytedance.bdnavigationsdk.network.route.p r10) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        BDNANavigationImpl r0 = (BDNANavigationImpl) ((CallableReference) this).receiver;
        Object r1 = r0.c;
        monitor-enter(r1);
        BDNANavigationImpl.b r2 = r0.o(r9, 2);     // Catch: Throwable -> L17
        if (r2 != null) goto L9;
        monitor-exit(r1);
        return;
    L9:
        com.bytedance.bdnavigationsdk.network.route.d r3 = r10.d;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L17
        List<RoutePath> r4 = r3.d;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L17
        RoutePath r5 = (RoutePath) CollectionsKt.first(r4);     // Catch: Throwable -> L17
        com.bytedance.bdnavigationsdk.network.route.j r6 = BDNANavigationImpl.q(r2.c, r3);     // Catch: Throwable -> L17
        NavigationService r7 = r0.d;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L17
        if (r7.a(r6, r5) == true) goto L14;
        r84.a.b("Navigation status is not route updating", null, 5);     // Catch: Throwable -> L17
        monitor-exit(r1);
        return;
    L14:
        r0.g = r6;     // Catch: Throwable -> L17
        r0.h = BDNANavigationImpl.l(r6.k);     // Catch: Throwable -> L17
        r0.j = null;     // Catch: Throwable -> L17
        BDNANavigationImpl.p(r9, r2, r5, r3.e.size());     // Catch: Throwable -> L17
        r0.n(new n(r9, r2.b, r10));     // Catch: Throwable -> L17
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r1);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (com.bytedance.bdnavigationsdk.network.route.p) r2);
        return Unit.INSTANCE;
    }
}
