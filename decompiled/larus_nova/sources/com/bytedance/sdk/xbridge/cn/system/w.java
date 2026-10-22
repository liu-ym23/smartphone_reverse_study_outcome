package com.bytedance.sdk.xbridge.cn.system;

import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.setScreenOn")
public final class w extends g {
    public w() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        g.b r103 = (g.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = this.f270190a;
        StringBuilder r105 = new StringBuilder("engine view: ");
        if (r100.getEngineView() != null) goto L5;
        boolean r106 = true;
    L6:
        r105.append(r106);
        com.bytedance.sdk.xbridge.cn.utils.i.b(r104, "start keep screen on", r105.toString(), String.valueOf(r100.getContainerID()));
        View r107 = r100.getEngineView();
        if (r107 == null) goto L10;
        r107.setKeepScreenOn(r103.isOn());
    L10:
        r102.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(g.c.class)), "keep screen on success");
        return;
    L5:
        r106 = false;
        goto L6
    }
}
