package com.larus.network.http;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.platform.api.b2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.json.JSONObject;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f360118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f360119b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f360120c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f360121d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ouc.v f360122e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Gson f360123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f360124g = null;

    static {
        ExecutorService r100 = PThreadExecutorsUtils.newFixedThreadPool(8, new h2a.a(new i()));
        f360118a = r100;
        ExecutorService r101 = PThreadExecutorsUtils.newFixedThreadPool(1, new h2a.a(new j()));
        f360119b = r101;
        f360120c = ExecutorsKt.from(r100);
        f360121d = ExecutorsKt.from(r101);
        f360122e = ouc.w.a(new k());
        f360123f = new GsonBuilder().create();
        f360124g = LazyKt.lazy(new l());
    }

    public static final Map<String, String> d() {
        LinkedHashMap r100 = new LinkedHashMap();
    L11:
        e = move-exception;
        FLogger.f375446a.e("getExtraQueryParams()", e.getLocalizedMessage());
    L13:
        return r100;
    L4:
        if (AppHost.f326268a.isOversea() == false) goto L6;
        AppLocaleUtils.f375332a.getClass();     // Catch: Exception -> L11
        Locale r101 = AppLocaleUtils.c();     // Catch: Exception -> L11
    L7:
        r100.put(EffectConfiguration.KEY_REGION, r101.getCountry());     // Catch: Exception -> L11
        r100.put("flow_sdk_version", "15020070");     // Catch: Exception -> L11
        int r102 = b2.f364870a.getPluginVersion();     // Catch: Exception -> L11
        if (r102 <= 0) goto L13;
        r100.put("flow_plugins_version", String.valueOf(r102));     // Catch: Exception -> L11
        goto L13
    L6:
        r101 = Locale.CHINA;     // Catch: Exception -> L11
        goto L7
    }

    public static final h e() {
        return (h) f360124g.getValue();
    }

    public static final String p(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(f360123f.toJson(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final <Req> JSONObject o(Req r100, juc.d<Req> r101) {
        Intrinsics.checkNotNullParameter(r100, "requestBody");
        Intrinsics.checkNotNullParameter(r101, "bodySerializer");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        String r103 = f360122e.a(r101, r100);     // Catch: Throwable -> L13
        String r104 = StringsKt.trim(r103).toString();     // Catch: Throwable -> L13
        boolean r105 = false;
        if (StringsKt.startsWith$default(r104, "{", false, 2, null) == true) goto L6;
    L8:
        if (r105 == true) goto L10;
        FLogger.f375446a.e("HttpExt", "serializeKmpRequestBody only supports json object body");     // Catch: Throwable -> L13
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L13
    L11:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L13
    L15:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        FLogger.f375446a.e("HttpExt", "serializeKmpRequestBody failed", r108);
        r107 = new JSONObject();
    L20:
        return (JSONObject) r107;
    L10:
        r106 = p0.b(r103);     // Catch: Throwable -> L13
        goto L11
    L6:
        if (StringsKt.endsWith$default(r104, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L8;
        r105 = true;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static final a a(BizResponse r100, dm9.a.C5690a r101, Throwable r102) {
        String r103 = "";
        if (r100 != null) goto L5;
        if (r101 == null) goto L20;
        long r104 = r101.f469228a;
        String r105 = r101.f469229b;
        Throwable r106 = r101.f469230c;
        if (r106 != null) goto L31;
        r106 = NetworkThrowable.INSTANCE;
    L31:
        return new f(new AsyncThrowable(r104, r105, r106), null);
    L20:
        if (r102 == null) goto L25;
        String r107 = r102.getMessage();
        if (r107 == null) goto L25;
        r103 = r107;
    L25:
        if (r102 != null) goto L28;
        r102 = NetworkThrowable.INSTANCE;
    L28:
        return new f(new AsyncThrowable(-999, r103, r102), null);
    L5:
        if (r100.isSuccess() == true) goto L29;
        long r108 = r100.getCode();
        String r109 = r100.getMsg();
        if (r109 == null) goto L11;
        r103 = r109;
    L11:
        if (r102 != null) goto L30;
        r102 = ServerThrowable.INSTANCE;
    L30:
        return new f(new AsyncThrowable(r108, r103, r102), null);
    L29:
        return new y(r100.getData(), r100.getPayload(), r100.getMsg(), Long.valueOf(r100.getCode()));
    }

    public static g n(String r110, JSONObject r111, RequestContext r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        Map<String, String> r100 = MapsKt.emptyMap();
    L7:
        if ((r113 & 8) == 0) goto L9;
        Map<String, String> r101 = MapsKt.emptyMap();
    L11:
        if ((r113 & 16) == 0) goto L13;
        RequestContext r102 = null;
    L14:
        Intrinsics.checkNotNullParameter(r110, "relativeUrl");
        Intrinsics.checkNotNullParameter(r111, ContainerPosition.BODY);
        FlowHttpConnection r103 = FlowHttpConnection.f359975a;
        CommonApi r104 = (CommonApi) FlowHttpConnection.b(FlowHttpConnection.a(), CollectionsKt.emptyList(), rx5.a.a()).create(CommonApi.class);
        TypedByteArray r105 = new TypedByteArray("application/json", r111.toString().getBytes(Charsets.UTF_8), new String[0]);
        if (r102 == null) goto L23;
        if (r100 != null) goto L18;
        r100 = MapsKt.emptyMap();
    L18:
        Map<String, String> r106 = r100;
        if (r101 != null) goto L21;
        Map<String, String> r107 = MapsKt.emptyMap();
    L22:
        Call<TypedInput> r108 = r104.streamPull(r110, r106, r105, r107, r102);
    L57:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L37
        SsResponse<TypedInput> r114 = r108.execute();     // Catch: Throwable -> L37
        TypedInput r115 = r114.body();     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r115, "value");     // Catch: Throwable -> L37
        String r116 = "UTF-8";
        if (r115.mimeType() == null) goto L31;
        r116 = MimeUtil.parseCharset(r115.mimeType(), "UTF-8");     // Catch: Throwable -> L37
    L31:
        BufferedReader r117 = new BufferedReader(new InputStreamReader(r115.in(), r116));     // Catch: Throwable -> L37
        List<Header> r118 = r114.headers();     // Catch: Throwable -> L37
        LinkedHashMap r119 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r118, 10)), 16));     // Catch: Throwable -> L37
        Iterator<T> r120 = r118.iterator();     // Catch: Throwable -> L37
    L33:
        if (r120.hasNext() == false) goto L35;
        Object r121 = r120.next();     // Catch: Throwable -> L37
        r119.put(((Header) r121).getName(), ((Header) r121).getValue());     // Catch: Throwable -> L37
        goto L33
    L35:
        Object r122 = Result.m9449constructorimpl(new g(r110, r114.code(), r119, "", "", r117, null, 64));     // Catch: Throwable -> L37
    L39:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L56;
        String r124 = "";
        if ((r123 instanceof CronetIOException) == false) goto L49;
        int r125 = ((CronetIOException) r123).getStatusCode();
        String r126 = r123.getMessage();
        if (r126 == null) goto L52;
    L47:
        r124 = r126;
    L52:
        int r127 = r125;
        String r128 = r124;
    L54:
        r122 = new g(r110, r127, null, null, r128, null, r123, 32);
        goto L56
    L49:
        if ((r123 instanceof NetworkNotAvailabeException) == false) goto L53;
        r125 = ((NetworkNotAvailabeException) r123).getCronetInternalErrorCode();
        r126 = r123.getMessage();
        if (r126 != null) goto L47;
    L53:
        r128 = "";
        r127 = -1;
    L56:
        return (g) r122;
    L37:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L21:
        r107 = r101;
        goto L22
    L23:
        if (r100 != null) goto L25;
        r100 = MapsKt.emptyMap();
    L25:
        if (r101 != null) goto L27;
        r101 = MapsKt.emptyMap();
    L27:
        r108 = r104.streamPull(r110, r100, r105, r101);
        goto L57
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public static /* synthetic */ Object h(String r100, Class r110, String r111, Map r112, Continuation r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r112 = null;
    L6:
        return g(r100, r110, r111, r112, null, false, null, null, r113);
    }

    public static /* synthetic */ Object m(String r110, Type r111, String r112, JSONObject r113, Map r114, boolean r115, Continuation r116) {
        return l(r110, r111, r112, r113, "application/json", r114, r115, null, null, null, r116);
    }

    public static /* synthetic */ Object j(Class r110, String r111, d0 r112, juc.d r113, juc.d r114, Map r115, Continuation r116, int r210) {
        if ((r210 & 64) == 0) goto L5;
        String r100 = "application/json";
    L6:
        String r101 = r100;
        if ((r210 & 128) == 0) goto L9;
        Map r102 = MapsKt.emptyMap();
    L11:
        if ((r210 & 256) == 0) goto L13;
        boolean r103 = false;
    L15:
        return i(ServiceType.UGC, r110, r111, r112, r113, r114, r101, r102, r103, null, null, null, r116);
    L13:
        r103 = true;
        goto L15
    L9:
        r102 = r115;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    public static Object f(String r110, Class r111, String r112, String r113, String r114, Map r115, Map r116, Continuation r117, int r118) {
        if ((r118 & 32) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r118 & 64) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        return BuildersKt.withContext(f360121d, new HttpExtKt$httpFile$2(r110, r111, r112, r113, r114, r100, r101, null), r117);
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }

    public static final <T> Object g(String r110, Class<T> r111, String r112, Map<String, String> r113, Map<String, String> r114, boolean r115, Map<String, ? extends Object> r116, RequestContext r117, Continuation<? super a<? extends T>> r210) {
        return BuildersKt.withContext(f360120c, new HttpExtKt$httpGet$2(r110, r111, r112, r113, r114, r115, r116, r117, null), r210);
    }

    public static final <T> Object l(String r110, Type r111, String r112, JSONObject r113, String r114, Map<String, String> r115, boolean r210, Map<String, ? extends Object> r211, RequestContext r212, v r213, Continuation<? super a<? extends T>> r214) {
        return BuildersKt.withContext(f360120c, new HttpExtKt$httpPostByType$2(r115, r114, r110, r111, r112, r113, r210, r211, r212, r213, null), r214);
    }

    public static final Triple b(String r110, Type r111, final String r112, final String r113, final Map r114, final JSONObject r115, Map r210, boolean r211, Map r212, final RequestContext r213, final v r214, juc.d r215) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "outType");
        Intrinsics.checkNotNullParameter(r112, "path");
        Intrinsics.checkNotNullParameter(r113, com.alipay.sdk.m.p.e.f25671s);
        yp9.b.f568723b.a("doExecuteStandard", r112 + ' ' + r113);
        if (r210 == null) goto L5;
        final Map r100 = MapsKt.toMutableMap(r210);
    L6:
        if (r100 == null) goto L8;
        r100.put("req_biz_id", r110);
    L8:
        CommonApi.a r116 = CommonApi.f360115a;
        Function1 r117 = new m(r113, r115, r100, r214, r112, r114, r213);
        r116.getClass();
        dm9.a r101 = CommonApi.a.a(r110, r111, r112, r211, r212, r215, r117);
        if ((r101 instanceof dm9.a.b) == false) goto L12;
        dm9.a.b r102 = (dm9.a.b) r101;
        return new Triple(r102.f469231a, null, r102.f469232b);
    L12:
        if ((r101 instanceof dm9.a.C5690a) == false) goto L15;
        return new Triple(null, r101, ((dm9.a.C5690a) r101).f469230c);
    L15:
        return new Triple(null, null, null);
    L5:
        r100 = null;
        goto L6
    }

    public static /* synthetic */ Triple c(String r110, Type r111, String r112, String r113, Map r114, JSONObject r115, Map r210, boolean r211, Map r212, RequestContext r213, v r214, int r215) {
        if ((r215 & 256) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r215 & 512) == 0) goto L9;
        Map r116 = null;
    L11:
        if ((r215 & 1024) == 0) goto L13;
        RequestContext r117 = null;
    L15:
        if ((r215 & 2048) == 0) goto L17;
        v r118 = null;
    L19:
        return b(r110, r111, r112, r113, r114, r115, r210, r100, r116, r117, r118, null);
    L17:
        r118 = r214;
        goto L19
    L13:
        r117 = r213;
        goto L15
    L9:
        r116 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public static Object k(String r110, Class r111, String r112, JSONObject r113, String r114, Map r115, boolean r116, Map r210, RequestContext r211, com.larus.bmhome.upload.audio.f r212, Continuation r213, int r214) {
        if ((r214 & 16) == 0) goto L5;
        String r100 = "application/json";
    L7:
        if ((r214 & 32) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r214 & 64) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r214 & 128) == 0) goto L17;
        Map r103 = null;
    L19:
        if ((r214 & 256) == 0) goto L21;
        RequestContext r117 = null;
    L23:
        if ((r214 & 512) == 0) goto L25;
        com.larus.bmhome.upload.audio.f r118 = null;
    L27:
        return l(r110, r111, r112, r113, r100, r101, r102, r103, r117, r118, r213);
    L25:
        r118 = r212;
        goto L27
    L21:
        r117 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }

    public static final <T, Req> Object i(String r110, Class<T> r111, String r112, Req r113, juc.d<Req> r210, juc.d<T> r211, String r212, Map<String, String> r213, boolean r214, Map<String, ? extends Object> r215, RequestContext r216, v r217, Continuation<? super a<? extends T>> r218) {
        return BuildersKt.withContext(f360120c, new HttpExtKt$httpPostByType$5(r213, r212, r113, r210, r110, r111, r112, r214, r215, r216, r217, r211, null), r218);
    }
}
