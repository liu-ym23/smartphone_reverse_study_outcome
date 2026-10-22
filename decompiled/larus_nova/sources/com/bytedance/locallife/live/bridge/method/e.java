package com.bytedance.locallife.live.bridge.method;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "startLiveFloatWindow")
public final class e extends yu6.d {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        yu6.d.b r103 = (yu6.d.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ConcurrentHashMap<Class<?>, Object> r104 = LifeServiceManager.f162660a;     // Catch: Throwable -> L5 Exception -> L10
        ((com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class)).d(r103);     // Catch: Throwable -> L5 Exception -> L10
    L5:
        th = move-exception;
        XBaseModel r105 = ne7.e.b(yu6.d.c.class);
        ((yu6.d.c) r105).setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r105, null, 2, null);
        throw th;
    L8:
        XBaseModel r106 = ne7.e.b(yu6.d.c.class);
        ((yu6.d.c) r106).setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r106, null, 2, null);
    }
}
