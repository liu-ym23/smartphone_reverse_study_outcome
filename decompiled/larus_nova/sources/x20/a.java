package x20;

import com.bytedance.common.wschannel.WsConstants;
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

/* JADX INFO: loaded from: classes45.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f562165c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "live.sendByteLinkApiRequest", params = {"serviceID", "queryParams", "headers", "uri", WsConstants.KEY_PAYLOAD, "timeout", com.alipay.sdk.m.p.e.f25671s, "httpURL"}, results = {"serviceID", "headers", WsConstants.KEY_PAYLOAD, "statusCode", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG})
    public final String f562166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f562167b;

    /* JADX INFO: renamed from: x20.a$a, reason: collision with other inner class name */
    public static final class C8184a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "headers", required = false)
        Map<String, Object> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = "httpURL", required = false)
        String getHttpURL();

        @XBridgeParamField(isGetter = true, keyPath = com.alipay.sdk.m.p.e.f25671s, required = true)
        Number getMethod();

        @XBridgeParamField(isGetter = true, keyPath = WsConstants.KEY_PAYLOAD, required = false)
        String getPayload();

        @XBridgeParamField(isGetter = true, keyPath = "queryParams", required = false)
        Map<String, Object> getQueryParams();

        @XBridgeParamField(isGetter = true, keyPath = "serviceID", required = true)
        Number getServiceID();

        @XBridgeParamField(isGetter = true, keyPath = "timeout", required = false)
        Number getTimeout();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "headers", required = false)
        Map<String, Object> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = WsConstants.KEY_PAYLOAD, required = false)
        String getPayload();

        @XBridgeParamField(isGetter = true, keyPath = "serviceID", required = true)
        Number getServiceID();

        @XBridgeParamField(isGetter = true, keyPath = "statusCode", required = false)
        Number getStatusCode();

        @XBridgeParamField(isGetter = true, keyPath = com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, required = false)
        String getStatusMsg();

        @XBridgeParamField(isGetter = false, keyPath = "headers", required = false)
        void setHeaders(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = WsConstants.KEY_PAYLOAD, required = false)
        void setPayload(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "serviceID", required = true)
        void setServiceID(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "statusCode", required = false)
        void setStatusCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, required = false)
        void setStatusMsg(String r100);
    }

    static {
        f562165c = MapsKt.mapOf(TuplesKt.to("TicketID", "39109"));
    }

    public a() {
        this.f562166a = "live.sendByteLinkApiRequest";
        this.f562167b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f562167b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f562166a;
    }
}
