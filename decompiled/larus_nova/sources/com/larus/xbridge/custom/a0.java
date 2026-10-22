package com.larus.xbridge.custom;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "app.sendEventToApplet")
public final class a0 extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f379687b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "app.sendEventToApplet", params = {"appId", "eventName", "params"})
    public final String f379688a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "appId", required = false)
        String getAppId();

        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f379687b = new Gson();
    }

    public a0() {
        this.f379688a = "app.sendEventToApplet";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379688a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (StringsKt.isBlank(r103.getEventName()) == false) goto L25;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -3, "eventName is empty", null, 4, null);
        return;
    L25:
        Map<String, Object> r104 = r103.getParams();     // Catch: Throwable -> L22
        if (r104 == null) goto L9;
        JsonObject r105 = f379687b.toJsonTree(r104).getAsJsonObject();     // Catch: Throwable -> L22
    L10:
        l3.a r106 = new l3.a(r103.getEventName(), r105, 4);
        String r107 = r103.getAppId();
        if (r107 != null) goto L13;
    L21:
        l3.d.c(r106);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L13:
        if (r107.length() <= 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L19;
        r107 = null;
    L19:
        if (r107 == null) goto L21;
        r106.f507199d = r107;
        goto L21
    L15:
        r108 = false;
        goto L16
    L9:
        r105 = null;
    L22:
        th = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -3, "params serialize failed: " + th.getMessage(), null, 4, null);
    }
}
