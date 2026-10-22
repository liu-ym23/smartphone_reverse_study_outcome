package ud7;

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
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC7865b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f549741c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.canIUse", params = {com.alipay.sdk.m.p.e.f25671s}, results = {"isAvailable", "params", "results"})
    public final String f549742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f549743b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ud7.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC7865b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = com.alipay.sdk.m.p.e.f25671s, required = true)
        String getMethod();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "params", primitiveClassType = String.class, required = false)
        List<String> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "results", primitiveClassType = String.class, required = false)
        List<String> getResults();

        @XBridgeParamField(isGetter = true, keyPath = "isAvailable", required = true)
        Boolean isAvailable();

        @XBridgeParamField(isGetter = false, keyPath = "isAvailable", required = true)
        void setAvailable(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "params", primitiveClassType = String.class, required = false)
        void setParams(List<String> r100);

        @XBridgeParamField(isGetter = false, keyPath = "results", primitiveClassType = String.class, required = false)
        void setResults(List<String> r100);
    }

    static {
        f549741c = MapsKt.mapOf(TuplesKt.to("TicketID", "16579"));
    }

    public b() {
        this.f549742a = "x.canIUse";
        this.f549743b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f549743b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f549742a;
    }
}
