package com.bytedance.bdnavigationsdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class BDNANavigationImpl$onNavigationYaw$1$2 extends FunctionReferenceImpl implements Function2<String, Exception, Unit> {
    public BDNANavigationImpl$onNavigationYaw$1$2(Object r8) {
        super(2, r8, BDNANavigationImpl.class, "handleYawRoutePlanFailure", "handleYawRoutePlanFailure(Ljava/lang/String;Ljava/lang/Exception;)V", 0);
    }

    public final void invoke(String r8, final Exception r9) {
        Intrinsics.checkNotNullParameter(r8, "p0");
        Intrinsics.checkNotNullParameter(r9, "p1");
        BDNANavigationImpl r0 = (BDNANavigationImpl) ((CallableReference) this).receiver;
        Object r2 = r0.c;
        monitor-enter(r2);
        BDNANavigationImpl.b r4 = r0.o(r8, 1);     // Catch: Throwable -> L13
        if (r4 != null) goto L10;
        monitor-exit(r2);
        return;
    L10:
        r0.j = null;     // Catch: Throwable -> L13
        r84.a.b("导航引擎错误", r9, 1);     // Catch: Throwable -> L13
        r0.n(new v(r9));     // Catch: Throwable -> L13
        r84.a.b("route update failed: routeUpdateId=" + r8 + ", reason=" + r4.b, r9, 1);     // Catch: Throwable -> L13
        r0.n(new h(r8, r4.b, r9));     // Catch: Throwable -> L13
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Exception) r2);
        return Unit.INSTANCE;
    }
}
