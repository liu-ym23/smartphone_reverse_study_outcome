package com.bytedance.upc.bridge.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.openSchema", owner = "wanglijie.skin")
public final class l extends gp7.i {
    public l() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        gp7.i.b r102 = (gp7.i.b) r101;
        boolean r103 = ip7.b.f495310a;
        com.bytedance.upc.a r104 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        Uri r105 = UriProtector.parse(r102.getUrl());
        if (StringsKt.contains$default(r102.getUrl(), "upcsdk://upc.webview", false, 2, null) == false) goto L11;
        String r106 = UriProtector.getQueryParameter(r105, "url");     // Catch: Throwable -> L27
        if (r106 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(UriProtector.parse(r106).getScheme(), "https") == false) goto L35;
        r104.f272401b.load();     // Catch: Throwable -> L27
        return;
    L35:
        return;
    L42:
        return;
    L11:
        if (StringsKt.contains$default(r102.getUrl(), "upcsdk://upc.system", false, 2, null) == true) goto L30;
        r104.getClass();     // Catch: Throwable -> L24
        r102.getUrl();     // Catch: Throwable -> L24
        throw null;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ip7.b.a(th);
        return;
    L30:
    L20:
        th = move-exception;
        ip7.b.a(th);
        return;
    L13:
        if (UriProtector.getQueryParameters(r105, PickerReporterConstants.KEY.TARGET) == null) goto L36;
        String r107 = UriProtector.getQueryParameter(r105, "package");     // Catch: Throwable -> L20
        Intent r108 = new Intent(UriProtector.getQueryParameter(r105, "action"));     // Catch: Throwable -> L20
        r108.setData(Uri.fromParts("package", r107, null));     // Catch: Throwable -> L20
        View r109 = r100.getEngineView();     // Catch: Throwable -> L20
        if (r109 == null) goto L37;
        Context r111 = r109.getContext();     // Catch: Throwable -> L20
        if (r111 == null) goto L38;
        r111.startActivity(r108);     // Catch: Throwable -> L20
        return;
    L38:
        return;
    L37:
        return;
    }
}
