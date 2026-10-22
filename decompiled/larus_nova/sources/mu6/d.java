package mu6;

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
public abstract class d extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f515764c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.bindDouyin", params = {"mainTitle", "subTitle", "buttonDesc", "sourcePage", "sourceMethod"}, results = {"result", "errorMsg"})
    public final String f515765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f515766b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "buttonDesc", required = true)
        String getButtonDesc();

        @XBridgeParamField(isGetter = true, keyPath = "mainTitle", required = true)
        String getMainTitle();

        @XBridgeParamField(isGetter = true, keyPath = "sourceMethod", required = true)
        String getSourceMethod();

        @XBridgeParamField(isGetter = true, keyPath = "sourcePage", required = true)
        String getSourcePage();

        @XBridgeParamField(isGetter = true, keyPath = "subTitle", required = true)
        String getSubTitle();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = false)
        String getErrorMsg();

        @XBridgeParamField(isGetter = true, keyPath = "result", required = true)
        Boolean getResult();

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = false)
        void setErrorMsg(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "result", required = true)
        void setResult(Boolean r100);
    }

    static {
        f515764c = MapsKt.mapOf(TuplesKt.to("TicketID", "41361"));
    }

    public d() {
        this.f515765a = "localLife.bindDouyin";
        this.f515766b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f515766b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f515765a;
    }
}
