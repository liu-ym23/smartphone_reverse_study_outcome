package com.bytedance.android.livesdk.livecommerce;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.a;
import el2.b;
import el2.c;
import el2.d;
import el2.e;
import el2.f;
import hh2.g;
import sg2.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveConfigurationModule_ProvideFactory implements Factory<g> {
    private final a0 module;

    public g get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m539get() {
        return get();
    }

    public LiveConfigurationModule_ProvideFactory(a0 r1) {
        this.module = r1;
    }

    public static LiveConfigurationModule_ProvideFactory create(a0 r1) {
        return new LiveConfigurationModule_ProvideFactory(r1);
    }

    public static g provideInstance(a0 r0) {
        return proxyProvide(r0);
    }

    public static g proxyProvide(a0 r4) {
        r4.getClass();
        ECAppInfoService r5 = ECAppInfoService.e;
        if (ECAppInfoService.j() == false) goto L6;
        g r6 = a0.a();
    L20:
        return (g) Preconditions.checkNotNull(r6, "Cannot return null from a non-@Nullable @Provides method");
    L6:
        if (ECAppInfoService.k() == false) goto L9;
        r6 = new g();
        r6.y("https://lianmengapi.snssdk.com");
        r6.a = new a();
        r6.b = new d();
        Boolean r0 = Boolean.FALSE;
        r6.B(r0);
        r6.E(r0);
        r6.w(null);
        r6.A(null);
        Boolean r1 = Boolean.TRUE;
        r6.v(r1);
        r6.H(r0);
        r6.I(r0);
        r6.r(r1);
        r6.s(r1);
        r6.u(r1);
        r6.G(r0);
        r6.t(r0);
        r6.z(r1);
        goto L20
    L9:
        if (ECAppInfoService.l() == false) goto L12;
        r6 = new g();
        r6.y("https://lianmengapi.snssdk.com");
        r6.a = new b();
        r6.b = new e();
        Boolean r2 = Boolean.FALSE;
        r6.B(r2);
        r6.E(r2);
        r6.w(null);
        r6.A(null);
        Boolean r3 = Boolean.TRUE;
        r6.v(r3);
        r6.H(r2);
        r6.I(r2);
        r6.r(r3);
        r6.s(r3);
        r6.u(r3);
        r6.G(r2);
        r6.t(r2);
        r6.z(r3);
        goto L20
    L12:
        if (we.a.a == false) goto L18;
        g r7 = new g();
        if (r5.n() == false) goto L16;
        String r8 = "https://saas.ecombdapi.com";
    L17:
        r7.y(r8);
        r7.a = new c();
        r7.b = new f();
        Boolean r9 = Boolean.TRUE;
        r7.B(r9);
        r7.E(r9);
        r7.w("tobsdk_");
        r7.A("ec_open_local_cache_sp");
        Boolean r10 = Boolean.FALSE;
        r7.v(r10);
        r7.H(r9);
        r7.I(r9);
        r7.r(r10);
        r7.s(Boolean.valueOf(EComABUtils.enableSaasPromotionCardOpt()));
        r7.u(Boolean.valueOf(EComABUtils.enableSaasDeviceDegrade()));
        r7.G(Boolean.valueOf(r5.n()));
        r7.t(r10);
        r7.x(r9);
        r7.F(r9);
        r7.C(r9);
        r7.z(r10);
        r6 = r7;
        goto L20
    L16:
        r8 = "https://isaas.ecombdapi.com";
        goto L17
    L18:
        r6 = a0.a();
        goto L20
    }
}
