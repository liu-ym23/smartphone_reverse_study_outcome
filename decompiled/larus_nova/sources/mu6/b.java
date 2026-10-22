package mu6;

import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC6856b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f515758c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "life.saasFetch", params = {"addCommonParams", "url", com.alipay.sdk.m.p.e.f25671s, ContainerPosition.BODY, "bodyType", "params", "header", LynxBridgeModule.KEY_USE_UI_THREAD, "usePrefetch"}, results = {"httpCode", "clientCode", "header", "response", "responseType", "rawResponse", "prefetchStatus"})
    public final String f515759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f515760b;

    public static final class a {
    }

    /* JADX INFO: renamed from: mu6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC6856b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "addCommonParams", required = false)
        Boolean getAddCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = ContainerPosition.BODY, required = false)
        Object getBody();

        @XBridgeStringEnum(option = {"arraybuffer", TTVideoEngineInterface.PLAY_API_KEY_BASE64})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "bodyType", required = false)
        String getBodyType();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = com.alipay.sdk.m.p.e.f25671s, required = true)
        String getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();

        @XBridgeParamField(isGetter = true, keyPath = "usePrefetch", required = false)
        Boolean getUsePrefetch();

        @XBridgeParamField(isGetter = true, keyPath = LynxBridgeModule.KEY_USE_UI_THREAD, required = false)
        Boolean getUseUIThread();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = false)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = false)
        Number getHttpCode();

        @XBridgeParamField(isGetter = true, keyPath = "prefetchStatus", required = false)
        Number getPrefetchStatus();

        @XBridgeParamField(isGetter = true, keyPath = "rawResponse", required = false)
        String getRawResponse();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        Object getResponse();

        @XBridgeParamField(isGetter = true, keyPath = "responseType", required = false)
        String getResponseType();

        @XBridgeParamField(isGetter = false, keyPath = "clientCode", required = false)
        void setClientCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "httpCode", required = false)
        void setHttpCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "prefetchStatus", required = false)
        void setPrefetchStatus(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "rawResponse", required = false)
        void setRawResponse(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Object r100);

        @XBridgeParamField(isGetter = false, keyPath = "responseType", required = false)
        void setResponseType(String r100);
    }

    static {
        f515758c = MapsKt.mapOf(TuplesKt.to("TicketID", "36203"));
    }

    public b() {
        this.f515759a = "life.saasFetch";
        this.f515760b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f515760b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f515759a;
    }
}
