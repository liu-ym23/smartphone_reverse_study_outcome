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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL$EcomSelectBannerFilterParamModel;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL$EcomSelectBannerFilterResultModel;", "<init>", "()V", "Companion", "EcomSelectBannerFilterParamModel", "EcomSelectBannerFilterResultModel", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsEcomSelectBannerFilterMethodIDL extends XCoreIDLBridgeMethod<EcomSelectBannerFilterParamModel, EcomSelectBannerFilterResultModel> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f450300b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f450301a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL$EcomSelectBannerFilterParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "dataId", "", "getDataId", "()Ljava/lang/String;", "filterData", "", "", "getFilterData", "()Ljava/util/Map;", "isBanSearch", "", "()Z", "isSelect", "statusPath", "getStatusPath", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EcomSelectBannerFilterParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "data_id", required = true)
        String getDataId();

        @XBridgeParamField(isGetter = true, keyPath = "filter_data", required = true)
        Map<String, Object> getFilterData();

        @XBridgeParamField(isGetter = true, keyPath = "status_path", required = false)
        String getStatusPath();

        @XBridgeParamField(isGetter = true, keyPath = "is_ban_search", required = true)
        boolean isBanSearch();

        @XBridgeParamField(isGetter = true, keyPath = "is_select", required = true)
        boolean isSelect();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcomSelectBannerFilterMethodIDL$EcomSelectBannerFilterResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "", "<set-?>", "getCode", "()Ljava/lang/Number;", "setCode", "(Ljava/lang/Number;)V", "code", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @XBridgeResultModel
    public interface EcomSelectBannerFilterResultModel extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);
    }

    static {
        new Companion(0);
        f450300b = MapsKt.mapOf(TuplesKt.to("TicketID", "34511"));
    }

    public AbsEcomSelectBannerFilterMethodIDL() {
        this.f450301a = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f450301a;
    }
}
