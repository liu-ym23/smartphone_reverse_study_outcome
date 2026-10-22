package ko6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class m extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504484c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.batchSendPoiLog", params = {"eventList", "commonParams"})
    public final String f504485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504486b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "commonParams", required = true)
        Map<String, Object> getCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "eventList", nestedClassType = d.class, required = true)
        List<d> getEventList();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "addBtmChain", required = false)
        Boolean getAddBtmChain();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = false)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "chainLength", required = false)
        Number getChainLength();

        @XBridgeParamField(isGetter = true, keyPath = "enterNewPage", required = false)
        Boolean getEnterNewPage();

        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = true)
        Map<String, Object> getParams();
    }

    static {
        f504484c = MapsKt.mapOf(TuplesKt.to("TicketID", "39421"));
    }

    public m() {
        this.f504485a = "localLife.batchSendPoiLog";
        this.f504486b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504486b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f504485a;
    }
}
