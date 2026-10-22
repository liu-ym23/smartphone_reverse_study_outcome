package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl.AbsEcomSearchUpdateQueryMethodIDL;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.constans.UpdateSearchKeyWordEvent;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes40.dex */
@XBridgeMethod(name = "ecomSearch.updateQuery")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/EcomSearchUpdateQueryMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateQueryMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomSearchUpdateQueryMethod extends AbsEcomSearchUpdateQueryMethodIDL implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450290b;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public EcomSearchUpdateQueryMethod() {
        this.f450290b = "ecomSearch.updateQuery";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f450290b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        AbsEcomSearchUpdateQueryMethodIDL.EcomSearchUpdateQueryParamModel r112 = (AbsEcomSearchUpdateQueryMethodIDL.EcomSearchUpdateQueryParamModel) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r101 = r112.getSearchWord();     // Catch: Exception -> L17
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        String r102 = r112.getEnterMethod();     // Catch: Exception -> L17
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        String r103 = r112.getEnterFrom();     // Catch: Exception -> L17
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        String r113 = r112.getClientEngineExtra();     // Catch: Exception -> L17
        if (r113 != null) goto L15;
        r113 = "";
    L15:
        SearchResultParam r104 = new SearchResultParam().setKeyword(r101).setSearchFrom(r103).setEnterMethod(r102).setOpenNewSearchContainer(false);     // Catch: Exception -> L17
        r104.setClientEngineExtra(r113);     // Catch: Exception -> L17
        r104.setSearchFrom(r103);     // Catch: Exception -> L17
        EventBus.getDefault().post(new UpdateSearchKeyWordEvent(r104));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Logger.c("EcomSearchUpdateQueryMethod", " " + this.f450290b + " error", e);
        String r105 = e.getMessage();
        if (r105 != null) goto L21;
        String r106 = "";
    L22:
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, r106, null, 4, null);
        return;
    L21:
        r106 = r105;
        goto L22
    }
}
