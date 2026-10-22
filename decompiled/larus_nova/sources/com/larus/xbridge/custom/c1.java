package com.larus.xbridge.custom;

import android.app.Activity;
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
import com.larus.common.venue.api.IFlowCommonVenueService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "flow.commonVenueApplyPocket", owner = "daitianji")
public final class c1 extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.commonVenueApplyPocket")
    public final String f379713a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = true)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = true, keyPath = "extraInfo", required = false)
        Map<String, Object> getExtra();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public c1() {
        this.f379713a = "flow.commonVenueApplyPocket";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379713a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r104 = r100.getOwnerActivity();
        FLogger r105 = FLogger.f375446a;
        if (r104 == null) goto L6;
        String r106 = r104.getLocalClassName();
        if (r106 == null) goto L6;
    L7:
        r105.i("FlowCommonVenueApplyPocketMethod", "[handle] activity name = ".concat(r106));
        IFlowCommonVenueService.f326466a.b(r104, r103.getData(), r103.getExtra());
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L6:
        r106 = "";
        goto L7
    }
}
