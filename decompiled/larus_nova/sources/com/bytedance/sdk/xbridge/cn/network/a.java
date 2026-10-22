package com.bytedance.sdk.xbridge.cn.network;

import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
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

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f269918c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.request", params = {"addCommonParams", "url", com.alipay.sdk.m.p.e.f25671s, ContainerPosition.BODY, "bodyType", "params", "header", LynxBridgeModule.KEY_USE_UI_THREAD, "usePrefetch", "isCustomizedCookie", "extraInfo", "maxLength", "streamLoadType", "streamSessionId"}, results = {"httpCode", "clientCode", "header", "response", "responseType", "rawResponse", "prefetchStatus"})
    public final String f269919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f269920b;

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.network.a$a, reason: collision with other inner class name */
    public static final class C3772a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), isGetter = true, keyPath = "addCommonParams", required = true)
        boolean getAddCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = ContainerPosition.BODY, required = false)
        Object getBody();

        @XBridgeStringEnum(option = {"arraybuffer", TTVideoEngineInterface.PLAY_API_KEY_BASE64})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "bodyType", required = false)
        String getBodyType();

        @XBridgeParamField(isGetter = true, keyPath = "extraInfo", required = false)
        Map<String, Object> getExtraInfo();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "maxLength", required = false)
        Number getMaxLength();

        @XBridgeParamField(isGetter = true, keyPath = com.alipay.sdk.m.p.e.f25671s, required = true)
        String getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "streamLoadType", required = false)
        Number getStreamLoadType();

        @XBridgeParamField(isGetter = true, keyPath = "streamSessionId", required = false)
        String getStreamSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();

        @XBridgeParamField(isGetter = true, keyPath = "usePrefetch", required = false)
        Boolean getUsePrefetch();

        @XBridgeParamField(isGetter = true, keyPath = LynxBridgeModule.KEY_USE_UI_THREAD, required = false)
        Boolean getUseUIThread();

        @XBridgeParamField(isGetter = true, keyPath = "isCustomizedCookie", required = false)
        Boolean isCustomizedCookie();
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

        @XBridgeStringEnum(option = {"arraybuffer", TTVideoEngineInterface.PLAY_API_KEY_BASE64})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "responseType", required = false)
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

        @XBridgeStringEnum(option = {"arraybuffer", TTVideoEngineInterface.PLAY_API_KEY_BASE64})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "responseType", required = false)
        void setResponseType(String r100);
    }

    static {
        f269918c = MapsKt.mapOf(TuplesKt.to("TicketID", "34610"));
    }

    public a() {
        this.f269919a = "x.request";
        this.f269920b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f269920b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.f269919a;
    }
}
