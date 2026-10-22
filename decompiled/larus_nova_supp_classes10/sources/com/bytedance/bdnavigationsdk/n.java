package com.bytedance.bdnavigationsdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.bytedance.bdnavigationsdk.network.route.p c;

    public /* synthetic */ n(String r1, int r2, com.bytedance.bdnavigationsdk.network.route.p r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r8) {
        String r1 = this.a;
        int r2 = this.b;
        com.bytedance.bdnavigationsdk.network.route.p r3 = this.c;
        w r9 = (w) r8;
        Intrinsics.checkNotNullParameter(r9, "listener");
        r9.u(new com.bytedance.bdnavigationsdk.navigation.x(r1, r2, r3, null, 8));
        return Unit.INSTANCE;
    }
}
