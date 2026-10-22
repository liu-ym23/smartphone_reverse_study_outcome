package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends MethodFinder {

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge.a$a, reason: collision with other inner class name */
    public static final class C2934a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge3";
    }

    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = c(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        Method r102 = r101.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        return (IDLXBridgeMethod) r102.invoke(null, new Object[0]);
    L8:
        th = move-exception;
        ve4.a.f554342a.getClass();
        ALogService r103 = (ALogService) ve4.a.a(ALogService.class);
        if (r103 == null) goto L12;
        r103.e("XBridge3Finder", "### Load method by reflect failed, method name: " + r100 + ", error_info: " + th.getMessage());
    L12:
        return null;
    }
}
