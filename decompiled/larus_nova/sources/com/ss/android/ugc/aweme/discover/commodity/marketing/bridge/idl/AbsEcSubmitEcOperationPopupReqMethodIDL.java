package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL$EcSubmitEcOperationPopupReqParamModel;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL$EcSubmitEcOperationPopupReqResultModel;", "<init>", "()V", "Companion", "EcSubmitEcOperationPopupReqParamModel", "EcSubmitEcOperationPopupReqResultModel", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsEcSubmitEcOperationPopupReqMethodIDL extends XCoreIDLBridgeMethod<EcSubmitEcOperationPopupReqParamModel, EcSubmitEcOperationPopupReqResultModel> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f450291b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f450292a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\n\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL$EcSubmitEcOperationPopupReqParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "bizId", "", "getBizId", "()Ljava/lang/String;", "isLastPopup", "", "()Ljava/lang/Number;", "priority", "getPriority", "scene", "getScene", "searchId", "getSearchId", "timestamp", "getTimestamp", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EcSubmitEcOperationPopupReqParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bizId", required = false)
        String getBizId();

        @XBridgeParamField(isGetter = true, keyPath = "priority", required = true)
        Number getPriority();

        @XBridgeParamField(isGetter = true, keyPath = "scene", required = true)
        String getScene();

        @XBridgeParamField(isGetter = true, keyPath = "searchId", required = true)
        String getSearchId();

        @XBridgeParamField(isGetter = true, keyPath = "timestamp", required = false)
        Number getTimestamp();

        @XBridgeParamField(isGetter = true, keyPath = "isLastPopup", required = false)
        Number isLastPopup();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL$EcSubmitEcOperationPopupReqResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "reason", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "", "showPopup", "getShowPopup", "()Ljava/lang/Number;", "setShowPopup", "(Ljava/lang/Number;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @XBridgeResultModel
    public interface EcSubmitEcOperationPopupReqResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "reason", required = false)
        String getReason();

        @XBridgeParamField(isGetter = true, keyPath = "showPopup", required = true)
        Number getShowPopup();

        @XBridgeParamField(isGetter = false, keyPath = "reason", required = false)
        void setReason(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "showPopup", required = true)
        void setShowPopup(Number r100);
    }

    static {
        new Companion(0);
        f450291b = MapsKt.mapOf(TuplesKt.to("TicketID", "41241"));
    }

    public AbsEcSubmitEcOperationPopupReqMethodIDL() {
        this.f450292a = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f450292a;
    }
}
