package com.larus.init.task.accountsdk;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f351142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f351143b = null;

    public g() {
    }

    static {
        f351142a = new g();
        f351143b = LazyKt.lazy(new f());
    }

    public static d48.a a(Call r110, String r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        SsResponse r101 = r110.execute();     // Catch: Throwable -> L12
        List<Header> r102 = r101.headers();     // Catch: Throwable -> L12
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));     // Catch: Throwable -> L12
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L12
    L4:
        if (r104.hasNext() == false) goto L6;
        Object r105 = r104.next();     // Catch: Throwable -> L12
        r103.put(((Header) r105).getName(), ((Header) r105).getValue());     // Catch: Throwable -> L12
        goto L4
    L6:
        fm9.c.a(r103);     // Catch: Throwable -> L12
        int r106 = r101.code();     // Catch: Throwable -> L12
        String r107 = (String) r101.body();     // Catch: Throwable -> L12
        String r108 = r101.message();     // Catch: Throwable -> L12
        Request r112 = r110.request();     // Catch: Throwable -> L12
        if (r112 == null) goto L9;
        String r113 = r112.getUrl();     // Catch: Throwable -> L12
    L10:
        Object r114 = Result.m9449constructorimpl(new d48.a(r111, r106, r103, r107, r108, null, r113, 96));     // Catch: Throwable -> L12
    L14:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r114);
        if (r109 == null) goto L40;
        String r115 = "";
        if ((r109 instanceof CronetIOException) == false) goto L27;
        CronetIOException r116 = (CronetIOException) r109;
        if (r116.getCronetInternalErrorCode() != (-555)) goto L22;
        int r117 = r116.getCronetInternalErrorCode();
    L23:
        String r118 = r109.getMessage();
        if (r118 == null) goto L37;
    L31:
        int r119 = r117;
        String r120 = r118;
    L38:
        e.f351141a.b("FlowAccountSaasNetworkDepend", "handleException, relativePath:" + r111 + ", code:" + r119 + ", msg:" + r120, r109);
        r114 = new d48.a(r111, r119, null, null, r120, r109, null, 160);
    L37:
        r119 = r117;
        r120 = r115;
        goto L38
    L22:
        r117 = r116.getStatusCode();
        goto L23
    L27:
        if ((r109 instanceof NetworkNotAvailabeException) == false) goto L32;
        r117 = ((NetworkNotAvailabeException) r109).getCronetInternalErrorCode();
        r118 = r109.getMessage();
        if (r118 != null) goto L31;
    L32:
        String r121 = r109.getMessage();
        if (r121 == null) goto L36;
        r115 = r121;
    L36:
        r117 = fm9.a.b(r109);
    L40:
        return (d48.a) r114;
    L9:
        r113 = null;
    L12:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final d48.a b(String r110, Object r111, Map<String, String> r112, Map<String, String> r113) {
        Intrinsics.checkNotNullParameter(r110, "path");
        Intrinsics.checkNotNullParameter(r111, ContainerPosition.BODY);
        boolean r100 = true;
        if (r113 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
    L48:
        Object r102 = r111;
        if ((r102 instanceof RequestBody) == false) goto L57;
        FlowAccountSaasApi r103 = (FlowAccountSaasApi) f351143b.getValue();
        if (r112 != null) goto L53;
        r112 = MapsKt.emptyMap();
    L53:
        Map<String, String> r104 = r112;
        RequestBody r105 = (RequestBody) r102;
        if (r113 != null) goto L56;
        r113 = MapsKt.emptyMap();
    L56:
        d48.a r114 = a(r103.doPostWithRequestBody(r110, r104, r105, r113, null), r110);
    L64:
        e.f351141a.c("FlowAccountSaasNetworkDepend", "executePost, path:" + r110 + ", result:" + r114.f466826b);
        return r114;
    L57:
        FlowAccountSaasApi r106 = (FlowAccountSaasApi) f351143b.getValue();
        if (r112 != null) goto L60;
        r112 = MapsKt.emptyMap();
    L60:
        Map<String, String> r107 = r112;
        if (r113 != null) goto L63;
        r113 = MapsKt.emptyMap();
    L63:
        r114 = a(r106.doPost(r110, r107, r102, r113, null), r110);
        goto L64
    L12:
        if ((r111 instanceof String) == false) goto L48;
        String r108 = (String) r111;
        if (r108 != null) goto L16;
    L19:
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
    L39:
        r100 = false;
    L40:
        if (r100 == false) goto L48;
        String r115 = r113.get("Content-Type");
        if (r115 == null) goto L48;
        if (StringsKt.startsWith$default(r115, "application/json", false, 2, null) == false) goto L48;
        r111 = RequestBody.create(MediaType.parse("application/json; encoding=utf-8"), r108);
        goto L48
    L23:
        if (r108.length() < 2) goto L39;
        if (StringsKt.startsWith$default(r108, "{", false, 2, null) == false) goto L39;
        if (StringsKt.endsWith$default(r108, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L39;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L32
        Object r117 = Result.m9449constructorimpl(new JSONObject(r108));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r117) == false) goto L37;
        r117 = null;
    L37:
        if (r117 == null) goto L39;
    L32:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L16:
        if (StringsKt.isBlank(r108) == true) goto L19;
        r109 = false;
        goto L21
    L5:
        if (r113.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }
}
