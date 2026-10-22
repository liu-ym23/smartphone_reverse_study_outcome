package com.bytedance.locallife.live.bridge.method;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "postLiveLifeMsg")
public final class c extends yu6.b {
    public c() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r110) {
        yu6.b.InterfaceC8390b r102 = (yu6.b.InterfaceC8390b) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        p56.b r111 = (p56.b) g(p56.b.class);
        if (r111 == null) goto L6;
        final String r112 = r111.provideContainerID();
        if (r112 == null) goto L6;
    L7:
        final IDLXBridgeMethod.b r103 = (IDLXBridgeMethod.b) g(IDLXBridgeMethod.b.class);
        ConcurrentHashMap<Class<?>, Object> r104 = LifeServiceManager.f162660a;
        com.bytedance.locallife.live.service.a r105 = (com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class);
        String r106 = r102.getEventName();
        Map<String, ? extends Object> r107 = null;
        JsonObject r108 = zu6.b.a(r102.getParams(), null);
        JsonObject r109 = r105.postMsg(r106, zu6.b.a(r102.getExtra(), new XPostMsgMethod$handle$result$1(r112)), r108, new XPostMsgMethod$handle$result$2(r103));
        if (r109.get("status").getAsInt() != 0) goto L10;
        CompletionBlock.a.a(r101, 0, null, null, 6);
        return;
    L10:
        Intrinsics.checkNotNullParameter(yu6.b.c.class, "<this>");
        XBaseModel r113 = com.bytedance.ies.xbridge.utils.g.c(yu6.b.c.class);
        yu6.b.c r114 = (yu6.b.c) r113;
        Object r115 = r109.get("data");
        if (r115 == null) goto L19;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        Gson r116 = LiveLifeSaaSUtil.r();
        Type r117 = new b().getType();
        if ((r115 instanceof String) == false) goto L15;
        String r118 = (String) r115;
    L21:
        r107 = (Map) r116.fromJson(r118, r117);     // Catch: Exception -> L18
    L18:
        r107 = new LinkedHashMap();
        goto L19
    L15:
        r118 = GsonProtectorUtils.toJson(r116, r115);
    L19:
        r114.setData(r107);
        r101.onSuccess((XBaseResultModel) r113, "");
        return;
    L6:
        r112 = "";
        goto L7
    }
}
