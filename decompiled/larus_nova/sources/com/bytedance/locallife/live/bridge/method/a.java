package com.bytedance.locallife.live.bridge.method;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "openLiveLifeGrouponPage")
public final class a extends yu6.a {
    public a() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        yu6.a.b r103 = (yu6.a.b) r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        ConcurrentHashMap<Class<?>, Object> r104 = LifeServiceManager.f162660a;
        ((com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class)).g(r103);
        Intrinsics.checkNotNullParameter(yu6.a.c.class, "<this>");
        r101.onSuccess((XBaseResultModel) com.bytedance.ies.xbridge.utils.g.c(yu6.a.c.class), "");
    }
}
