package to6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC7753b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f546931c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.poiWarmUp", params = {"bizCode", "level", "enterFrom"})
    public final String f546932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f546933b;

    public static final class a {
    }

    /* JADX INFO: renamed from: to6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC7753b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bizCode", required = false)
        String getBizCode();

        @XBridgeParamField(isGetter = true, keyPath = "enterFrom", required = false)
        String getEnterFrom();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(intValue = 1, type = DefaultType.INT), isGetter = true, keyPath = "level", required = true)
        Number getLevel();
    }

    static {
        f546931c = MapsKt.mapOf(TuplesKt.to("TicketID", "39376"));
    }

    public b() {
        this.f546932a = "localLife.poiWarmUp";
        this.f546933b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f546933b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f546932a;
    }
}
