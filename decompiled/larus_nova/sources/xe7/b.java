package xe7;

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
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC8223b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f563369c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getUserDomainStorageItem", params = {"key"}, results = {"status", "value"})
    public final String f563370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f563371b;

    public static final class a {
    }

    /* JADX INFO: renamed from: xe7.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC8223b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "enableAppIdIsolation", required = false)
        Boolean getEnableAppIdIsolation();

        @XBridgeParamField(isGetter = true, keyPath = "key", required = true)
        String getKey();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "status", required = false)
        String getStatus();

        @XBridgeParamField(isGetter = true, keyPath = "value", required = false)
        Object getValue();

        @XBridgeParamField(isGetter = false, keyPath = "status", required = false)
        void setStatus(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "value", required = false)
        void setValue(Object r100);
    }

    static {
        f563369c = MapsKt.mapOf(TuplesKt.to("TicketID", "24854"));
    }

    public b() {
        this.f563370a = "x.getUserDomainStorageItem";
        this.f563371b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f563371b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f563370a;
    }
}
