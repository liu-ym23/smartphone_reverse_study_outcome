package com.ss.android.cert.manager.jsb.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$CertOpenByteCertParamModel;", "Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$CertOpenByteCertResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "CertOpenByteCertParamModel", "CertOpenByteCertResultModel", "Companion", "byted_cert_manager_release"}, k = 1, mv = {1, 1, 16})
public abstract class AbsCertOpenByteCertMethodIDL extends XCoreIDLBridgeMethod<CertOpenByteCertParamModel, CertOpenByteCertResultModel> {
    public static final Companion Companion = null;

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = null;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access;

    @XBridgeMethodName(name = "cert.openByteCert", params = {"scene", BytedCertConstant.CertKey.FLOW, "ticket", "certAppId", "faceOnly", "extraParams", "h5QueryParams", "identityName", "identityCode"}, results = {"errorCode", "errorMsg", "ticket", "certStatus", "manualStatus", CommonConstant.KEY_AGE_RANGE, "extData"})
    private final String name;

    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u0014\u0010\u0017\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$CertOpenByteCertParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "certAppId", "", "getCertAppId", "()Ljava/lang/String;", "extraParams", "", "", "getExtraParams", "()Ljava/util/Map;", "faceOnly", "", "getFaceOnly", "()Ljava/lang/Boolean;", BytedCertConstant.CertKey.FLOW, "getFlow", "h5QueryParams", "getH5QueryParams", "identityCode", "getIdentityCode", "identityName", "getIdentityName", "scene", "getScene", "ticket", "getTicket", "byted_cert_manager_release"}, k = 1, mv = {1, 1, 16})
    public interface CertOpenByteCertParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "certAppId", required = false)
        String getCertAppId();

        @XBridgeParamField(isGetter = true, keyPath = "extraParams", required = false)
        Map<String, Object> getExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "faceOnly", required = false)
        Boolean getFaceOnly();

        @XBridgeParamField(isGetter = true, keyPath = BytedCertConstant.CertKey.FLOW, required = false)
        String getFlow();

        @XBridgeParamField(isGetter = true, keyPath = "h5QueryParams", required = false)
        Map<String, Object> getH5QueryParams();

        @XBridgeParamField(isGetter = true, keyPath = "identityCode", required = false)
        String getIdentityCode();

        @XBridgeParamField(isGetter = true, keyPath = "identityName", required = false)
        String getIdentityName();

        @XBridgeParamField(isGetter = true, keyPath = "scene", required = true)
        String getScene();

        @XBridgeParamField(isGetter = true, keyPath = "ticket", required = false)
        String getTicket();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\bg\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R@\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR(\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$CertOpenByteCertResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", CommonConstant.KEY_AGE_RANGE, "getAgeRange", "()Ljava/lang/Number;", "setAgeRange", "(Ljava/lang/Number;)V", "certStatus", "getCertStatus", "setCertStatus", "errorCode", "getErrorCode", "setErrorCode", "", "errorMsg", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "", "", "extData", "getExtData", "()Ljava/util/Map;", "setExtData", "(Ljava/util/Map;)V", "manualStatus", "getManualStatus", "setManualStatus", "ticket", "getTicket", "setTicket", "byted_cert_manager_release"}, k = 1, mv = {1, 1, 16})
    @XBridgeResultModel
    public interface CertOpenByteCertResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = CommonConstant.KEY_AGE_RANGE, required = false)
        Number getAgeRange();

        @XBridgeParamField(isGetter = true, keyPath = "certStatus", required = false)
        Number getCertStatus();

        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = true)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = false)
        String getErrorMsg();

        @XBridgeParamField(isGetter = true, keyPath = "extData", required = false)
        Map<String, Object> getExtData();

        @XBridgeParamField(isGetter = true, keyPath = "manualStatus", required = false)
        Number getManualStatus();

        @XBridgeParamField(isGetter = true, keyPath = "ticket", required = false)
        String getTicket();

        @XBridgeParamField(isGetter = false, keyPath = CommonConstant.KEY_AGE_RANGE, required = false)
        void setAgeRange(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "certStatus", required = false)
        void setCertStatus(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = true)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = false)
        void setErrorMsg(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "extData", required = false)
        void setExtData(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "manualStatus", required = false)
        void setManualStatus(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "ticket", required = false)
        void setTicket(String r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/cert/manager/jsb/idl/AbsCertOpenByteCertMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "byted_cert_manager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsCertOpenByteCertMethodIDL.access$getExtensionMetaInfo$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "28874"));
    }

    public AbsCertOpenByteCertMethodIDL() {
        this.name = "cert.openByteCert";
        this.access = IDLXBridgeMethod.Access.PRIVATE;
    }

    public static final /* synthetic */ Map access$getExtensionMetaInfo$cp() {
        return extensionMetaInfo;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }
}
