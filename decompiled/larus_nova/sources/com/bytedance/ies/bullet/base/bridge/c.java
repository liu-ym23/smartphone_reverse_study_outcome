package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m16.b f246283d;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "bullet";
    }

    public c(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f246283d = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = c(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L6;
        return null;
    L6:
        Method r102 = r101.getDeclaredMethod("create", new Class[]{m16.b.class});     // Catch: Throwable -> L11
        r102.setAccessible(true);     // Catch: Throwable -> L11
        Object r103 = r102.invoke(null, new Object[]{this.f246283d});     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod");     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.core.kit.bridge.c r104 = (com.bytedance.ies.bullet.core.kit.bridge.c) r103;     // Catch: Throwable -> L11
        if ((r104 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == true) goto L9;
        m16.b r105 = new m16.b();     // Catch: Throwable -> L11
        r104.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L11
        r104.f246545a = r105;     // Catch: Throwable -> L11
    L9:
        return i.b(r104);
    L12:
        return null;
    }
}
