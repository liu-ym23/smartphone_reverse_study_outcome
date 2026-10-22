package com.larus.dora.impl.bridge;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.dora.api.IDoraService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.base.networkRequest")
public final class r extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.base.networkRequest")
    public final String f332109a;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f332110d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f332111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f332112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f332113c;

        /* JADX INFO: renamed from: com.larus.dora.impl.bridge.r$a$a, reason: collision with other inner class name */
        public static final class C4212a {
            public static a a(String r100, d r101) {
                Intrinsics.checkNotNullParameter(r100, "msg");
                Intrinsics.checkNotNullParameter(r101, "resultModel");
                return new a(false, r101, r100);
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f332111a == r101.f332111a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f332112b, r101.f332112b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f332113c, r101.f332113c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f332111a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f332112b.hashCode()) * 31;
            String r102 = this.f332113c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "BridgeResult(isSuccess=" + this.f332111a + ", resultModel=" + this.f332112b + ", msg=" + this.f332113c + ')';
        }

        public a(boolean r100, d r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "resultModel");
            this.f332111a = r100;
            this.f332112b = r101;
            this.f332113c = r102;
        }
    }

    public static final class b {
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "headers", required = false)
        Map<String, String> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = com.alipay.sdk.m.p.e.f25671s, required = true)
        String getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "needCommonParams", required = false)
        Boolean getNeedCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "requireSignature", required = false)
        Boolean getRequireSignature();

        @XBridgeParamField(isGetter = true, keyPath = "timeoutMs", required = false)
        Number getTimeoutMs();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = false)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = false)
        Number getHttpCode();

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

        @XBridgeParamField(isGetter = false, keyPath = "rawResponse", required = false)
        void setRawResponse(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Object r100);

        @XBridgeParamField(isGetter = false, keyPath = "responseType", required = false)
        void setResponseType(String r100);
    }

    static {
    }

    public r() {
        this.f332109a = "dora.base.networkRequest";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332109a;
    }

    public static Object f(Object r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if ((r100 instanceof Boolean) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof Number) == false) goto L8;
        return r100;
    L8:
        if ((r100 instanceof String) == false) goto L11;
        return r100;
    L11:
        if ((r100 instanceof JSONObject) == false) goto L17;
        Map r101 = MapsKt.createMapBuilder();
        JSONObject r102 = (JSONObject) r100;
        Iterator<String> r103 = r102.keys();
    L14:
        if (r103.hasNext() == false) goto L68;
        String r104 = r103.next();
        r101.put(r104, f(r102.opt(r104)));
        goto L14
    L68:
        return MapsKt.build(r101);
    L17:
        int r105 = 0;
        if ((r100 instanceof JSONArray) == false) goto L24;
        List r106 = CollectionsKt.createListBuilder();
        JSONArray r107 = (JSONArray) r100;
        int r108 = r107.length();
    L20:
        if (r105 >= r108) goto L69;
        r106.add(f(r107.opt(r105)));
        r105 = r105 + 1;
        goto L20
    L69:
        return CollectionsKt.build(r106);
    L24:
        if ((r100 instanceof Map) == false) goto L35;
        Map r109 = MapsKt.createMapBuilder();
        Iterator r110 = ((Map) r100).entrySet().iterator();
    L27:
        if (r110.hasNext() == false) goto L70;
        Map.Entry r111 = (Map.Entry) r110.next();
        Object r112 = r111.getKey();
        Object r113 = r111.getValue();
        if (r112 == null) goto L27;
        String r114 = r112.toString();
        if (r114 == null) goto L27;
        r109.put(r114, f(r113));
        goto L27
    L70:
        return MapsKt.build(r109);
    L35:
        if ((r100 instanceof Iterable) == false) goto L42;
        Iterable r115 = (Iterable) r100;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r117 = r115.iterator();
    L38:
        if (r117.hasNext() == false) goto L71;
        r116.add(f(r117.next()));
    L71:
        return r116;
    L42:
        if ((r100 instanceof Object[]) == false) goto L51;
        Object[] r118 = (Object[]) r100;
        r116 = new ArrayList(r118.length);
        int r119 = r118.length;
    L44:
        if (r105 >= r119) goto L71;
        r116.add(f(r118[r105]));
        r105 = r105 + 1;
    L48:
        th = move-exception;
        throw th;
    L51:
        return r100.toString();
    }

    public final a b(com.larus.network.http.a<? extends Object> r110) {
        if ((r110 instanceof y) == false) goto L28;
        y r111 = (y) r110;
        Object r100 = f(r111.f360135b);
        String r101 = r111.f360136c;
        if (r100 != null) goto L21;
        Long r102 = r111.f360205g;
        if (r102 != null) goto L10;
    L12:
        if (r101 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == true) goto L20;
        String r104 = TemplateNodeType.RAW;
    L22:
        String r105 = r104;
    L23:
        int r106 = a.f332110d;
        Long r112 = r111.f360205g;
        if (r112 == null) goto L26;
        Integer r107 = Integer.valueOf((int) r112.longValue());
    L27:
        d r113 = e(this, r107, r100, r105, r101, 5);
        Intrinsics.checkNotNullParameter(r113, "resultModel");
        return new a(true, r113, null);
    L26:
        r107 = null;
        goto L27
    L20:
        r105 = null;
        goto L23
    L14:
        if (r101.length() == 0) goto L17;
        r103 = false;
        goto L18
    L10:
        if (r102.longValue() != 0) goto L12;
    L21:
        r104 = "json";
        goto L22
    L28:
        boolean r108 = r110 instanceof com.larus.network.http.f;
        String r109 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
        if (r108 == false) goto L35;
        com.larus.network.http.f r114 = (com.larus.network.http.f) r110;
        String r115 = r114.f360157d.getMessage();
        if (r115 == null) goto L34;
        r109 = r115;
    L34:
        int r116 = a.f332110d;
        return a.C4212a.a(r109, e(this, Integer.valueOf((int) r114.f360157d.getCode()), null, TemplateNodeType.RAW, r109, 13));
    L35:
        int r117 = a.f332110d;
        return a.C4212a.a(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, c(this, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN));
    }

    public final Object g(Object r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if ((r100 instanceof Boolean) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof Number) == false) goto L8;
        return r100;
    L8:
        if ((r100 instanceof String) == false) goto L10;
        return r100;
    L10:
        if ((r100 instanceof JSONObject) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof JSONArray) == false) goto L15;
        return r100;
    L15:
        if ((r100 instanceof Map) == false) goto L18;
        return h(r100);
    L18:
        if ((r100 instanceof Iterable) == false) goto L25;
        JSONArray r101 = new JSONArray();
        Iterator r102 = ((Iterable) r100).iterator();
    L21:
        if (r102.hasNext() == false) goto L40;
        r101.put(g(r102.next()));
    L40:
        return r101;
    L25:
        if ((r100 instanceof Object[]) == false) goto L31;
        Iterable r103 = ArraysKt.asIterable((Object[]) r100);
        r101 = new JSONArray();
        Iterator r104 = r103.iterator();
    L28:
        if (r104.hasNext() == false) goto L40;
        r101.put(g(r104.next()));
        goto L28
    L31:
        return r100.toString();
    }

    public final JSONObject h(Object r100) {
        if (r100 != null) goto L5;
        return new JSONObject();
    L5:
        if ((r100 instanceof JSONObject) == false) goto L8;
        return (JSONObject) r100;
    L8:
        if ((r100 instanceof String) == false) goto L15;
        if (StringsKt.isBlank((CharSequence) r100) == true) goto L35;
        JSONObject r101 = new JSONObject((String) r100);
    L36:
        return r101;
    L35:
        return new JSONObject();
    L15:
        if ((r100 instanceof Map) == false) goto L26;
        r101 = new JSONObject();
        Iterator r102 = ((Map) r100).entrySet().iterator();
    L18:
        if (r102.hasNext() == false) goto L36;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r104 == null) goto L18;
        String r106 = r104.toString();
        if (r106 == null) goto L18;
        r101.put(r106, g(r105));
        goto L18
    L26:
        throw new IllegalArgumentException("unsupported params type: ".concat(r100.getClass().getSimpleName()));
    }

    public static d c(r r100, String r101) {
        r100.getClass();
        return e(r100, null, null, TemplateNodeType.RAW, r101, 13);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        c r100 = (c) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = r100.getUrl();
        String r113 = r100.getMethod();
        if (r113 == null) goto L5;
        String r102 = r113.toUpperCase(Locale.ROOT);
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        r112.onFailure(-3, "url is empty", c(this, "url is empty"));
        return;
    L17:
        if (Intrinsics.areEqual(r102, "GET") == false) goto L19;
    L21:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new DoraNetworkRequestMethod$handle$1(this, r101, r102, r100, r112, null), 3, null);
        return;
    L19:
        if (Intrinsics.areEqual(r102, "POST") == true) goto L21;
        String r114 = "unsupported method: " + r100.getMethod();
        r112.onFailure(-3, r114, c(this, r114));
        return;
    L9:
        if (StringsKt.isBlank(r101) == true) goto L12;
        r103 = false;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public static d e(r r100, Integer r101, Object r102, String r103, String r104, int r105) {
        Map<String, ? extends Object> r106 = null;
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L8;
        Map<String, ? extends Object> r107 = MapsKt.emptyMap();
    L10:
        if ((r105 & 8) == 0) goto L13;
        r102 = null;
    L13:
        if ((r105 & 16) == 0) goto L16;
        r103 = null;
    L16:
        if ((r105 & 32) == 0) goto L18;
        r104 = null;
    L18:
        r100.getClass();
        d r108 = (d) ne7.e.b(d.class);
        r108.setHttpCode(null);
        r108.setClientCode(r101);
        if ((!r107.isEmpty()) == false) goto L21;
        r106 = r107;
    L21:
        r108.setHeader(r106);
        r108.setResponse(r102);
        r108.setResponseType(r103);
        r108.setRawResponse(r104);
        return r108;
    L8:
        r107 = null;
        goto L10
    }

    public static final Object a(r r110, String r111, String r112, Object r113, Map r210, boolean r211, Long r212, Continuation r213) {
        r110.getClass();
        if ((r213 instanceof DoraNetworkRequestMethod$executeRequest$1) == false) goto L7;
        DoraNetworkRequestMethod$executeRequest$1 r100 = (DoraNetworkRequestMethod$executeRequest$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraNetworkRequestMethod$executeRequest$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L55:
        a r105 = r110.b((com.larus.network.http.a) r102);
    L56:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
    L42:
        r105 = r110.b((com.larus.network.http.a) r102);
        goto L56
    L16:
        ResultKt.throwOnFailure(r102);
        Map<String, String> r106 = null;
        if (r212 != null) goto L19;
        RequestContext r115 = null;
    L21:
        if (Intrinsics.areEqual(r112, "GET") == false) goto L44;
        JSONObject r107 = r110.h(r113);
        Map r108 = MapsKt.createMapBuilder();
        Iterator<String> r109 = r107.keys();
    L24:
        if (r109.hasNext() == false) goto L39;
        String r116 = r109.next();
        Object r117 = r107.opt(r116);
        Intrinsics.checkNotNull(r116);
        if (r117 != null) goto L28;
    L37:
        String r118 = "";
    L38:
        r108.put(r116, r118);
        goto L24
    L28:
        if (Intrinsics.areEqual(r117, JSONObject.NULL) == true) goto L37;
        if ((r117 instanceof JSONObject) == false) goto L33;
    L36:
        r118 = r117.toString();
        goto L38
    L33:
        if ((r117 instanceof JSONArray) == true) goto L36;
        r118 = r117.toString();
        goto L38
    L39:
        Map r119 = MapsKt.build(r108);
        r114.label = 1;
        r102 = HttpExtKt.g(ServiceType.DORA, Object.class, r111, r119, r210, false, null, r115, r114);
        if (r102 != r103) goto L42;
        return r103;
    L44:
        JSONObject r120 = r110.h(r113);
        Map r121 = MapsKt.toMutableMap(r210);
        if (r211 == false) goto L52;
        IDoraService r122 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r122 == null) goto L49;
        r106 = r122.w0(r120);
    L49:
        if (r106 != null) goto L51;
        r106 = MapsKt.emptyMap();
    L51:
        r121.putAll(r106);
    L52:
        r114.label = 2;
        r102 = HttpExtKt.k(ServiceType.DORA, Object.class, r111, r120, null, r121, false, null, r115, null, r114, TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER);
        if (r102 != r103) goto L55;
        return r103;
    L19:
        RequestContext r123 = new RequestContext();
        r123.timeout_connect = r212.longValue();
        r123.timeout_read = r212.longValue();
        r123.timeout_write = r212.longValue();
        r123.protect_timeout = r212.longValue();
        r123.socket_connect_timeout = r212.longValue();
        r123.socket_read_timeout = r212.longValue();
        r123.socket_write_timeout = r212.longValue();
        r115 = r123;
    L7:
        r100 = new DoraNetworkRequestMethod$executeRequest$1(r110, r213);
        goto L8
    }
}
