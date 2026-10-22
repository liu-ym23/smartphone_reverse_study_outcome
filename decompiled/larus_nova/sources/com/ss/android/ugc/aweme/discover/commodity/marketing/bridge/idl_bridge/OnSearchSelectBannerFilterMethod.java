package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl_bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl.AbsEcomSelectBannerFilterMethodIDL;
import com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingRitManager;
import com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.utils.FormatExtensionKtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@XBridgeMethod(name = "ecomSelectBannerFilter")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl_bridge/OnSearchSelectBannerFilterMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnSearchSelectBannerFilterMethod extends AbsEcomSelectBannerFilterMethodIDL implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450307c;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public OnSearchSelectBannerFilterMethod() {
        this.f450307c = "ecomSelectBannerFilter";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f450307c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        AbsEcomSelectBannerFilterMethodIDL.EcomSelectBannerFilterParamModel r102 = (AbsEcomSelectBannerFilterMethodIDL.EcomSelectBannerFilterParamModel) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Logger.d("MarketingRitManager", "jsb: ecomSelectBannerFilter invoke: " + r102);     // Catch: Exception -> L8
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("is_select", r102.isSelect());     // Catch: Exception -> L8
        r103.put("data_id", r102.getDataId());     // Catch: Exception -> L8
        r103.put("filter_data", FormatExtensionKtKt.a(r102.getFilterData()));     // Catch: Exception -> L8
        r103.put("is_ban_search", r102.isBanSearch());     // Catch: Exception -> L8
        r103.put("status_path", r102.getStatusPath());     // Catch: Exception -> L8
        ECSearchMarketingService r104 = ECSearchMarketingRitManager.c();     // Catch: Exception -> L8
        if (r104 == null) goto L6;
        r104.a(r103);     // Catch: Exception -> L8
    L6:
        XBaseModel r105 = e.c(Reflection.getOrCreateKotlinClass(AbsEcomSelectBannerFilterMethodIDL.EcomSelectBannerFilterResultModel.class));     // Catch: Exception -> L8
        ((AbsEcomSelectBannerFilterMethodIDL.EcomSelectBannerFilterResultModel) r105).setCode(1);     // Catch: Exception -> L8
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L8
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r105, null, 2, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Logger.c("MarketingRitManager", "onBannerFilterSelect error", e);
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, String.valueOf(e.getMessage()), null, 4, null);
    }
}
