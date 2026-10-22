package com.bytedance.locallife.live.bridge.method;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "unRegisterLiveLifeMsgCenter")
public final class g extends yu6.f {
    public g() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        yu6.f.b r103 = (yu6.f.b) r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        p56.b r104 = (p56.b) g(p56.b.class);
        if (r104 == null) goto L6;
        final String r105 = r104.provideContainerID();
        if (r105 == null) goto L6;
    L7:
        final IDLXBridgeMethod.b r106 = (IDLXBridgeMethod.b) g(IDLXBridgeMethod.b.class);
        ConcurrentHashMap<Class<?>, Object> r107 = LifeServiceManager.f162660a;
        if (((com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class)).unRegisterLiveLifeMsgCenter(r103.getEventName(), zu6.b.a(r103.getExtra(), new XUnRegisterMsgCenterMethod$handle$result$1(r105)), new XUnRegisterMsgCenterMethod$handle$result$2(r106)) != 0) goto L10;
        CompletionBlock.a.a(r101, 0, null, null, 6);
        return;
    L10:
        Intrinsics.checkNotNullParameter(yu6.f.c.class, "<this>");
        r101.onSuccess((XBaseResultModel) com.bytedance.ies.xbridge.utils.g.c(yu6.f.c.class), "");
        return;
    L6:
        r105 = "";
        goto L7
    }
}
