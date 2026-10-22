package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m16.b f246300d;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge2";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final void j() {
        super.j();
    }

    public p(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        this.f246300d = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = c(r100);     // Catch: Throwable -> L15
        if (r101 != null) goto L6;
        return null;
    L6:
        Method r102 = r101.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L15
        r102.setAccessible(true);     // Catch: Throwable -> L15
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ies.xbridge.IDLXBridgeMethod");     // Catch: Throwable -> L15
        com.bytedance.ies.xbridge.IDLXBridgeMethod r104 = (com.bytedance.ies.xbridge.IDLXBridgeMethod) r103;     // Catch: Throwable -> L15
        if ((r104 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L12;
        s26.d r105 = s26.d.f540305c;     // Catch: Throwable -> L15
        m0 r106 = (m0) s26.d.f540305c.c(m0.class);     // Catch: Throwable -> L15
        if (r106 == null) goto L11;
        r106.a0();     // Catch: Throwable -> L15
    L11:
        r104.setProviderFactory(BDXCompatMethodFinderKt.a(this.f246300d));     // Catch: Throwable -> L15
    L13:
        return i.c(r104);
    L12:
        r104.setProviderFactory(new g66.c());     // Catch: Throwable -> L15
    L16:
        return null;
    }
}
