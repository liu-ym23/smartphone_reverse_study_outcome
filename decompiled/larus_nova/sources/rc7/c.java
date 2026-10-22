package rc7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "account.verify", params = {"verifyDecision"}, results = {"verifyWay", "verifyTicket", "verifyExtraParams", "bizParams"})
    public final String f537164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f537165b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "verifyDecision", required = true)
        Map<String, Object> getVerifyDecision();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "bizParams", required = false)
        Map<String, Object> getBizParams();

        @XBridgeParamField(isGetter = true, keyPath = "verifyExtraParams", required = false)
        Map<String, Object> getVerifyExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "verifyTicket", required = false)
        String getVerifyTicket();

        @XBridgeParamField(isGetter = true, keyPath = "verifyWay", required = false)
        String getVerifyWay();

        @XBridgeParamField(isGetter = false, keyPath = "bizParams", required = false)
        void setBizParams(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "verifyExtraParams", required = false)
        void setVerifyExtraParams(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "verifyTicket", required = false)
        void setVerifyTicket(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "verifyWay", required = false)
        void setVerifyWay(String r100);
    }

    public c() {
        this.f537164a = "account.verify";
        this.f537165b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f537165b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f537164a;
    }
}
