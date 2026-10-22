package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getLocation")
public final class t extends e {
    public t() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((e.b) r101, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Activity r102 = r100.getOwnerActivity();
        if (r102 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "context can not convert to activity", null, 4, null);
        return;
    L5:
        int r103 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostLocationPermissionDepend r104 = XBaseRuntime.f270108n;
        if (r104 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "LocationPermissionDepend is null", null, 4, null);
        return;
    L8:
        r104.requestPermission(r102, r100, this.f270184a, new s(r102, r110, this, r100));
    }
}
