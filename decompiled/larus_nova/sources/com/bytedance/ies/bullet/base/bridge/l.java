package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m16.b f246294d;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final void j() {
        super.j();
    }

    public l(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        this.f246294d = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = c(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L6;
        return null;
    L6:
        Method r102 = r101.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L18
        r102.setAccessible(true);     // Catch: Throwable -> L18
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ies.xbridge.XBridgeMethod");     // Catch: Throwable -> L18
        XBridgeMethod r104 = (XBridgeMethod) r103;     // Catch: Throwable -> L18
        if ((r104 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L12;
        s26.d r105 = s26.d.f540305c;     // Catch: Throwable -> L18
        m0 r106 = (m0) s26.d.f540305c.c(m0.class);     // Catch: Throwable -> L18
        if (r106 == null) goto L11;
        r106.a0();     // Catch: Throwable -> L18
    L11:
        r104.setProviderFactory(BDXCompatMethodFinderKt.a(this.f246294d));     // Catch: Throwable -> L18
    L13:
        int r107 = i.f246288a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);     // Catch: Throwable -> L18
        if ((r104 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L17;
        return new g(r104);
    L17:
        return new k(r104);
    L12:
        r104.setProviderFactory(new g66.c());     // Catch: Throwable -> L18
        goto L13
    L19:
        return null;
    }
}
