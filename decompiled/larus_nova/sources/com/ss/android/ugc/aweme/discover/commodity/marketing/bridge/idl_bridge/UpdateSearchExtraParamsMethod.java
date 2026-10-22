package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl_bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl.AbsEcomSearchUpdateSearchExtraParamsMethodIDL;
import com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingRitManager;
import com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.utils.FormatExtensionKtKt;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Deprecated(message = "该方法废弃", replaceWith = @ReplaceWith(expression = "ChangeSearchExtraParamsMethod", imports = {}))
@XBridgeMethod(name = "ecomSearch.updateSearchExtraParams")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl_bridge/UpdateSearchExtraParamsMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateSearchExtraParamsMethod extends AbsEcomSearchUpdateSearchExtraParamsMethodIDL implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450312c;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public UpdateSearchExtraParamsMethod() {
        this.f450312c = "ecomSearch.updateSearchExtraParams";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f450312c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        AbsEcomSearchUpdateSearchExtraParamsMethodIDL.EcomSearchUpdateSearchExtraParamsParamModel r102 = (AbsEcomSearchUpdateSearchExtraParamsMethodIDL.EcomSearchUpdateSearchExtraParamsParamModel) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Logger.d("MarketingRitManager", "jsb: ecomSearch.updateSearchExtraParams invoke: " + r102);     // Catch: Exception -> L11
        Map<String, Object> r103 = r102.getExtra();     // Catch: Exception -> L11
        ECSearchMarketingService r104 = ECSearchMarketingRitManager.c();     // Catch: Exception -> L11
        if (r104 == null) goto L9;
        if (r103 == null) goto L7;
        JSONObject r105 = FormatExtensionKtKt.a(r103);     // Catch: Exception -> L11
    L8:
        r104.b(r105);     // Catch: Exception -> L11
        goto L9
    L7:
        r105 = null;
    L9:
        XBaseModel r106 = e.c(Reflection.getOrCreateKotlinClass(AbsEcomSearchUpdateSearchExtraParamsMethodIDL.EcomSearchUpdateSearchExtraParamsResultModel.class));     // Catch: Exception -> L11
        ((AbsEcomSearchUpdateSearchExtraParamsMethodIDL.EcomSearchUpdateSearchExtraParamsResultModel) r106).setCode(1);     // Catch: Exception -> L11
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L11
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r106, null, 2, null);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Logger.c("MarketingRitManager", "updateSearchExtraParams error", e);
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, String.valueOf(e.getMessage()), null, 4, null);
    }
}
