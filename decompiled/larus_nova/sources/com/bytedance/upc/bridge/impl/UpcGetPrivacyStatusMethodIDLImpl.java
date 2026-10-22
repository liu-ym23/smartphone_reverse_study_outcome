package com.bytedance.upc.bridge.impl;

import android.text.TextUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.getPrivacyStatus", owner = "wanglijie.skin")
public final class UpcGetPrivacyStatusMethodIDLImpl extends gp7.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f272422d;

    public UpcGetPrivacyStatusMethodIDLImpl() {
        this.f272422d = LazyKt.lazy(UpcGetPrivacyStatusMethodIDLImpl$mConfiguration$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        gp7.f.b r103 = (gp7.f.b) r101;
        com.bytedance.upc.e r104 = ((com.bytedance.upc.a) this.f272422d.getValue()).f272402c;     // Catch: Throwable -> L8
        r103.getType();     // Catch: Throwable -> L8
        String r105 = r104.c();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r105) == false) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "don't known this type status", null, 4, null);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, new i(r105), null, 2, null);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "get privacy status error: " + th, null, 4, null);
    }
}
