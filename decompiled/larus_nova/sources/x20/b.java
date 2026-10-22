package x20;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC8185b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f562168c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "live.updateByteLinkListener", params = {"messageMethod", ReportConstant.COMMON_ACTION_TYPE})
    public final String f562169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f562170b;

    public static final class a {
    }

    /* JADX INFO: renamed from: x20.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC8185b extends XBaseParamModel {
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(intValue = 0, type = DefaultType.INT), isGetter = true, keyPath = ReportConstant.COMMON_ACTION_TYPE, required = true)
        Number getActionType();

        @XBridgeParamField(isGetter = true, keyPath = "messageMethod", primitiveClassType = String.class, required = true)
        List<String> getMessageMethod();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f562168c = MapsKt.mapOf(TuplesKt.to("TicketID", "38941"));
    }

    public b() {
        this.f562169a = "live.updateByteLinkListener";
        this.f562170b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f562170b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f562169a;
    }
}
