package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateQueryMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateQueryMethodIDL$EcomSearchUpdateQueryParamModel;", "", "<init>", "()V", "EcomSearchUpdateQueryParamModel", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsEcomSearchUpdateQueryMethodIDL extends XCoreIDLBridgeMethod<EcomSearchUpdateQueryParamModel, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f450297a;

    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateQueryMethodIDL$EcomSearchUpdateQueryParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "clientEngineExtra", "", "getClientEngineExtra", "()Ljava/lang/String;", "enterFrom", "getEnterFrom", "enterMethod", "getEnterMethod", "searchWord", "getSearchWord", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EcomSearchUpdateQueryParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "client_engine_extra", required = false)
        String getClientEngineExtra();

        @XBridgeParamField(isGetter = true, keyPath = "enterFrom", required = false)
        String getEnterFrom();

        @XBridgeParamField(isGetter = true, keyPath = "enter_method", required = false)
        String getEnterMethod();

        @XBridgeParamField(isGetter = true, keyPath = "search_word", required = false)
        String getSearchWord();
    }

    public AbsEcomSearchUpdateQueryMethodIDL() {
        this.f450297a = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f450297a;
    }
}
