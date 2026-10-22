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
@XBridgeMethod(name = "x.sendSMS")
public final class v extends ye7.b {
    public v() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        ye7.b.InterfaceC8335b r113 = (ye7.b.InterfaceC8335b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r114 = r110.getOwnerActivity();
        if (r114 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        boolean r100 = false;
        if (r113.getContent().length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "content can not be empty", null, 4, null);
        return;
    L12:
        if (r113.getPhoneNumber().length() != 0) goto L14;
        r100 = true;
    L14:
        if (r100 == false) goto L16;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "phoneNumber can not be empty", null, 4, null);
        return;
    L16:
        Intent r102 = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", r113.getPhoneNumber(), null));
        r102.putExtra("sms_body", r113.getContent());
        r114.startActivity(r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(ye7.b.c.class)), null, 2, null);
        return;
    L8:
        r101 = false;
        goto L9
    }
}
