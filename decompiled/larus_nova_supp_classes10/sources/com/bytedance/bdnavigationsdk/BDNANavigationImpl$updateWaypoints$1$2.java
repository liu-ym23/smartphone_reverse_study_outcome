package com.bytedance.bdnavigationsdk;

import com.bytedance.bdnavigationsdk.navigation.NavigationService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class BDNANavigationImpl$updateWaypoints$1$2 extends FunctionReferenceImpl implements Function2<String, Exception, Unit> {
    public BDNANavigationImpl$updateWaypoints$1$2(Object r8) {
        super(2, r8, BDNANavigationImpl.class, "handleUpdateWaypointsRoutePlanFailure", "handleUpdateWaypointsRoutePlanFailure(Ljava/lang/String;Ljava/lang/Exception;)V", 0);
    }

    public final void invoke(String r7, Exception r8) {
        Intrinsics.checkNotNullParameter(r7, "p0");
        Intrinsics.checkNotNullParameter(r8, "p1");
        BDNANavigationImpl r0 = (BDNANavigationImpl) ((CallableReference) this).receiver;
        Object r2 = r0.c;
        monitor-enter(r2);
        BDNANavigationImpl.b r3 = r0.o(r7, 2);     // Catch: Throwable -> L12
        if (r3 != null) goto L9;
        monitor-exit(r2);
        return;
    L9:
        NavigationService r4 = r0.d;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L12
        r4.g();     // Catch: Throwable -> L12
        r0.j = null;     // Catch: Throwable -> L12
        e r5 = r84.a.a;     // Catch: Throwable -> L12
        r84.a.b("route update failed: routeUpdateId=" + r7 + ", reason=" + r3.b, r8, 1);     // Catch: Throwable -> L12
        r0.n(new h(r7, r3.b, r8));     // Catch: Throwable -> L12
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Exception) r2);
        return Unit.INSTANCE;
    }
}
