package qo6;

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
public abstract class r extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534233c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "sendLifeMallLog", params = {"eventName", "params", "btm", "enter_new_page", "add_btm_chain", "chain_length"})
    public final String f534234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534235b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "add_btm_chain", required = false)
        Boolean getAddBtmChain();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = false)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "chain_length", required = false)
        Number getChainLength();

        @XBridgeParamField(isGetter = true, keyPath = "enter_new_page", required = false)
        Boolean getEnterNewPage();

        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = true)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f534233c = MapsKt.mapOf(TuplesKt.to("TicketID", "34558"));
    }

    public r() {
        this.f534234a = "sendLifeMallLog";
        this.f534235b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534235b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534234a;
    }
}
