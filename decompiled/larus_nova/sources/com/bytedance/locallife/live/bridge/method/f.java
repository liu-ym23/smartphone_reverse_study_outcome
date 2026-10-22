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
@XBridgeMethod(name = "stopLiveFloatWindow")
public final class f extends yu6.e {
    public f() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((yu6.e.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ConcurrentHashMap<Class<?>, Object> r103 = LifeServiceManager.f162660a;
        ((com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class)).hideLiveFloatWindow();
        XBaseModel r104 = ne7.e.b(yu6.e.c.class);
        ((yu6.e.c) r104).setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r104, null, 2, null);
    }
}
