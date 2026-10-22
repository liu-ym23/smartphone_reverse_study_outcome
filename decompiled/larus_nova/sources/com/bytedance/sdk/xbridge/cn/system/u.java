package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.makePhoneCall")
public final class u extends ye7.a {
    public u() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        ye7.a.b r113 = (ye7.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r114 = r113.getPhoneNumber();
        if (r114.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "phoneNumber can not be empty", null, 4, null);
        return;
    L8:
        Intent r101 = new Intent("android.intent.action.DIAL", Uri.fromParts("tel", r114, null));
        Activity r115 = r110.getOwnerActivity();
        if (r115 != null) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L11:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(ye7.a.c.class)), null, 2, null);
        r115.startActivity(r101);
        return;
    L5:
        r100 = false;
        goto L6
    }
}
