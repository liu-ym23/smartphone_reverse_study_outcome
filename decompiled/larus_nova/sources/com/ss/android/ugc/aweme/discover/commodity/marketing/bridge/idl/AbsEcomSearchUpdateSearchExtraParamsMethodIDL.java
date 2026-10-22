package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL$EcomSearchUpdateSearchExtraParamsParamModel;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL$EcomSearchUpdateSearchExtraParamsResultModel;", "<init>", "()V", "Companion", "EcomSearchUpdateSearchExtraParamsParamModel", "EcomSearchUpdateSearchExtraParamsResultModel", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsEcomSearchUpdateSearchExtraParamsMethodIDL extends XCoreIDLBridgeMethod<EcomSearchUpdateSearchExtraParamsParamModel, EcomSearchUpdateSearchExtraParamsResultModel> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f450298b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f450299a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL$EcomSearchUpdateSearchExtraParamsParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "bannerExtra", "", "", "", "getBannerExtra", "()Ljava/util/Map;", "extra", "getExtra", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EcomSearchUpdateSearchExtraParamsParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "banner_extra", required = true)
        Map<String, Object> getBannerExtra();

        @XBridgeParamField(isGetter = true, keyPath = "extra", required = true)
        Map<String, Object> getExtra();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSearchUpdateSearchExtraParamsMethodIDL$EcomSearchUpdateSearchExtraParamsResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "", "<set-?>", "getCode", "()Ljava/lang/Number;", "setCode", "(Ljava/lang/Number;)V", "code", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @XBridgeResultModel
    public interface EcomSearchUpdateSearchExtraParamsResultModel extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);
    }

    static {
        new Companion(0);
        f450298b = MapsKt.mapOf(TuplesKt.to("TicketID", "28577"));
    }

    public AbsEcomSearchUpdateSearchExtraParamsMethodIDL() {
        this.f450299a = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f450299a;
    }
}
