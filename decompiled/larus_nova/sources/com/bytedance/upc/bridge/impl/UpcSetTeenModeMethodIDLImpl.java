package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.m;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.setTeenMode", owner = "wanglijie.skin")
public final class UpcSetTeenModeMethodIDLImpl extends gp7.j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f272426d;

    public static final class a {
    }

    static {
    }

    public UpcSetTeenModeMethodIDLImpl() {
        this.f272426d = LazyKt.lazy(UpcSetTeenModeMethodIDLImpl$mConfiguration$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        gp7.j.b r103 = (gp7.j.b) r101;
        m r104 = ((com.bytedance.upc.a) this.f272426d.getValue()).f272404e;     // Catch: Throwable -> L7
        if (r104 == null) goto L12;
        r103.getStatus();     // Catch: Throwable -> L7
        r103.getPassword();     // Catch: Throwable -> L7
        new AnonymousClass1(r102);     // Catch: Throwable -> L7
        r104.a();     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ip7.b.a(th);
    }
}
