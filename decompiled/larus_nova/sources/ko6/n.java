package ko6;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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
public abstract class n extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504487c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.getGoodsDetailMonitorInfo", params = {LocationMonitorConst.IDENTIFIER}, results = {"originSessionInfo", "sessionChangeHistory", "goodsDetailExtraInfo", "originQueries"})
    public final String f504488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504489b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LocationMonitorConst.IDENTIFIER, required = true)
        String getIdentifier();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "goodsDetailExtraInfo", required = true)
        Map<String, Object> getGoodsDetailExtraInfo();

        @XBridgeParamField(isGetter = true, keyPath = "originQueries", required = true)
        Map<String, Object> getOriginQueries();

        @XBridgeParamField(isGetter = true, keyPath = "originSessionInfo", required = true)
        Map<String, Object> getOriginSessionInfo();

        @XBridgeParamField(isGetter = true, keyPath = "sessionChangeHistory", required = true)
        Map<String, Object> getSessionChangeHistory();

        @XBridgeParamField(isGetter = false, keyPath = "goodsDetailExtraInfo", required = true)
        void setGoodsDetailExtraInfo(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "originQueries", required = true)
        void setOriginQueries(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "originSessionInfo", required = true)
        void setOriginSessionInfo(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "sessionChangeHistory", required = true)
        void setSessionChangeHistory(Map<String, ? extends Object> r100);
    }

    static {
        f504487c = MapsKt.mapOf(TuplesKt.to("TicketID", "36887"));
    }

    public n() {
        this.f504488a = "localLife.getGoodsDetailMonitorInfo";
        this.f504489b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504489b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f504488a;
    }
}
