package com.bytedance.locallife.hybrid.xbridge.service;

import com.bytedance.ies.bullet.base.bridge.i;
import com.bytedance.locallife.biz.common.utils.c;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f259092a;

    public final IDLXBridgeMethod a() {
        Object r100 = this.f259092a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L9
        if ((r100 instanceof IDLXBridgeMethod) == false) goto L6;
        IDLXBridgeMethod r101 = (IDLXBridgeMethod) r100;     // Catch: Exception -> L9
    L13:
        return r101;
    L6:
        if ((r100 instanceof com.bytedance.ies.xbridge.IDLXBridgeMethod) == false) goto L11;
        int r102 = i.f246288a;     // Catch: Exception -> L9
        r101 = i.c((com.bytedance.ies.xbridge.IDLXBridgeMethod) r100);     // Catch: Exception -> L9
        goto L13
    L16:
        r101 = null;
    L9:
        e = move-exception;
        c.b("LifeBridgeService", "MethodCreator clazz = " + this.f259092a.getName() + " error :" + e.getMessage());
        e.printStackTrace();
    L11:
        r101 = null;
        goto L13
    }

    public b(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f259092a = r100;
    }
}
