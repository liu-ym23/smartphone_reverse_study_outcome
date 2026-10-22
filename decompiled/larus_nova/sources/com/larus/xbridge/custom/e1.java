package com.larus.xbridge.custom;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "flow.getPipoCreateOrderContext";
    }

    public e1() {
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        XCoreBridgeMethod.onFailure$default(this, r101, 0, "fail, getPipoCreateOrderContext is not supported on mainland", null, 8, null);
    }
}
