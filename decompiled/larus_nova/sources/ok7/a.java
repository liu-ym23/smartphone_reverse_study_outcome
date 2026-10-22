package ok7;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public abstract void e(XReadableMap r100, i r101);

    public a() {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        if (rk7.m.f538357k == false) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckycatXBridge", "handle " + getName());
    L5:
        e(r100, new i(r101));
    }
}
