package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "flow.popNativePage";
    }

    public k1() {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        FLogger r104 = FLogger.f375446a;
        if (r103 == null) goto L6;
        String r105 = r103.getLocalClassName();
        if (r105 == null) goto L6;
    L7:
        r104.i("FlowPopNativePage", "[handle] activity name = ".concat(r105));
        IUgcAIGCService.f373945a.r(r103);
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
        return;
    L6:
        r105 = "";
        goto L7
    }
}
