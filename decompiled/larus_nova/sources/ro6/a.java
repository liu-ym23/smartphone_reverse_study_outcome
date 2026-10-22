package ro6;

import com.bytedance.locallife.cube.bridge.POINativeModule;
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
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f538772c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "life_storage_get", params = {"key", "domain"}, results = {"value", POINativeModule.RESP_EXIST})
    public final String f538773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f538774b;

    /* JADX INFO: renamed from: ro6.a$a, reason: collision with other inner class name */
    public static final class C7509a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "domain", required = false)
        String getDomain();

        @XBridgeParamField(isGetter = true, keyPath = "key", required = true)
        String getKey();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = POINativeModule.RESP_EXIST, required = true)
        Boolean getExist();

        @XBridgeParamField(isGetter = true, keyPath = "value", required = true)
        Object getValue();

        @XBridgeParamField(isGetter = false, keyPath = POINativeModule.RESP_EXIST, required = true)
        void setExist(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "value", required = true)
        void setValue(Object r100);
    }

    static {
        f538772c = MapsKt.mapOf(TuplesKt.to("TicketID", "29257"));
    }

    public a() {
        this.f538773a = "life_storage_get";
        this.f538774b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f538774b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f538773a;
    }
}
