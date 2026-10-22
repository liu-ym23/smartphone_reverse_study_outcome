package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.os.Vibrator;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.stopVibrate")
public final class z extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f270243d;

    public z() {
        this.f270243d = "x.stopVibrate";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((h.b) r101, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r102 = r100.getContainerID();
        Activity r103 = r100.getOwnerActivity();
        String r104 = this.f270243d;
        StringBuilder r105 = new StringBuilder("context:");
        if (r103 != null) goto L5;
        Object r106 = "null";
    L6:
        r105.append(r106);
        com.bytedance.sdk.xbridge.cn.utils.i.b(r104, r105.toString(), "BridgeParam", r102);
        if (r103 != null) goto L14;
        id7.c.a("Context is null");
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "Context is null.", null, 4, null);
        return;
    L14:
        Object r107 = r103.getSystemService("vibrator");     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.os.Vibrator");     // Catch: Exception -> L11
        ((Vibrator) r107).cancel();     // Catch: Exception -> L11
        r110.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(h.c.class)), "stop vibrate execute success.");     // Catch: Exception -> L11
        com.bytedance.sdk.xbridge.cn.utils.i.b(this.f270243d, "message:stop vibrate execute success", "BridgeResult", r102);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "Can not get vibrate service.", null, 4, null);
        com.bytedance.sdk.xbridge.cn.utils.i.b(this.f270243d, "stop vibrate err:" + e.getMessage(), "BridgeResult", r102);
        return;
    L5:
        r106 = r103;
        goto L6
    }
}
