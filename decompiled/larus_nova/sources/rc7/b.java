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
public abstract class b extends XCoreIDLBridgeMethod<a, InterfaceC7460b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "account.setVerifyStatus", params = {"status", "verifyWay", "verifyTicket", "verifyExtraParams", "extraBizParams"})
    public final String f537162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f537163b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "afid", required = false)
        Number getAfid();

        @XBridgeParamField(isGetter = true, keyPath = "extraBizParams", required = false)
        Map<String, Object> getExtraBizParams();

        @XBridgeParamField(isGetter = true, keyPath = "status", required = false)
        Number getStatus();

        @XBridgeParamField(isGetter = true, keyPath = "verifyExtraParams", required = false)
        Map<String, Object> getVerifyExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "verifyTicket", required = false)
        String getVerifyTicket();

        @XBridgeParamField(isGetter = true, keyPath = "verifyWay", required = false)
        String getVerifyWay();
    }

    /* JADX INFO: renamed from: rc7.b$b, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC7460b extends XBaseResultModel {
    }

    public b() {
        this.f537162a = "account.setVerifyStatus";
        this.f537163b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f537163b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.f537162a;
    }
}
