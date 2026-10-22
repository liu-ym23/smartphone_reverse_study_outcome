package ro6;

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

/* JADX INFO: loaded from: classes21.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC7510b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f538775c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "life_storage_set", params = {"key", "domain", "value"})
    public final String f538776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f538777b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ro6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC7510b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "domain", required = false)
        String getDomain();

        @XBridgeParamField(isGetter = true, keyPath = "key", required = true)
        String getKey();

        @XBridgeParamField(isGetter = true, keyPath = "value", required = true)
        Object getValue();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f538775c = MapsKt.mapOf(TuplesKt.to("TicketID", "29238"));
    }

    public b() {
        this.f538776a = "life_storage_set";
        this.f538777b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f538777b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f538776a;
    }
}
