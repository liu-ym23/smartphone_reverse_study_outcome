package gp7;

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
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC6053c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f482107c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "upc.checkFace", params = {"name", "idCard"}, results = {"errorCode", "errorMsg"})
    public final String f482108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f482109b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "idCard", required = true)
        String getIdCard();

        @XBridgeParamField(isGetter = true, keyPath = "name", required = true)
        String getName();
    }

    /* JADX INFO: renamed from: gp7.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC6053c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = true)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = true)
        String getErrorMsg();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = true)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = true)
        void setErrorMsg(String r100);
    }

    static {
        f482107c = MapsKt.mapOf(TuplesKt.to("TicketID", "24983"));
    }

    public c() {
        this.f482108a = "upc.checkFace";
        this.f482109b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f482109b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f482108a;
    }
}
