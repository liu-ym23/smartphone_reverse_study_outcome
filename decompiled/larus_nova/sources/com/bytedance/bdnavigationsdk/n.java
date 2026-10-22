package com.bytedance.bdnavigationsdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class n implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f200021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f200022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.bdnavigationsdk.network.route.p f200023c;

    public /* synthetic */ n(String r100, int r101, com.bytedance.bdnavigationsdk.network.route.p r102) {
        this.f200021a = r100;
        this.f200022b = r101;
        this.f200023c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f200021a;
        int r102 = this.f200022b;
        com.bytedance.bdnavigationsdk.network.route.p r103 = this.f200023c;
        w r104 = (w) r100;
        Intrinsics.checkNotNullParameter(r104, "listener");
        r104.u(new com.bytedance.bdnavigationsdk.navigation.x(r101, r102, r103, null, 8));
        return Unit.INSTANCE;
    }
}
