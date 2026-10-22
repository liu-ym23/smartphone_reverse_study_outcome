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
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "app.renderCodeLynxPreviewResult")
public final class o1 extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "app.renderCodeLynxPreviewResult", params = {"success"})
    public final String f379779a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        Boolean getSuccess();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public o1() {
        this.f379779a = "app.renderCodeLynxPreviewResult";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379779a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        b r112 = (b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r101 = r100.getContainerID();
        Boolean r113 = r112.getSuccess();
        boolean r102 = false;
        if (r113 == null) goto L5;
        boolean r114 = r113.booleanValue();
    L6:
        FLogger r103 = FLogger.f375446a;
        r103.i("FlowRenderCodeLynxPreviewResultMethod", "[handle] containerId=" + r101 + ", success=" + r114);
        ConcurrentHashMap<String, eh8.a.InterfaceC5779a> r104 = eh8.a.f472670a;
        if (r101 != null) goto L9;
    L12:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r103.w("CodeRenderLynxManager", "[dispatchResult] skip empty containerId, success=" + r114);
    L20:
        if (r102 == true) goto L22;
        r103.w("FlowRenderCodeLynxPreviewResultMethod", "[handle] no callback dispatched for containerId=" + r101);
    L22:
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L16:
        eh8.a.InterfaceC5779a r106 = eh8.a.f472670a.get(r101);
        if (r106 != null) goto L19;
        r103.w("CodeRenderLynxManager", "[dispatchResult] no callback for containerId=" + r101);
        goto L20
    L19:
        r103.i("CodeRenderLynxManager", "[dispatchResult] containerId=" + r101 + ", success=" + r114);
        r106.onResult(r114);
        r102 = true;
        goto L20
    L9:
        if (r101.length() == 0) goto L12;
        r105 = false;
        goto L14
    L5:
        r114 = false;
        goto L6
    }
}
