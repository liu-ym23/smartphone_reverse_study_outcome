package com.bytedance.awemeopen.infra.base.net;

import android.app.Application;
import com.alipay.sdk.m.p.e;
import com.bytedance.awemeopen.infra.base.net.mime.d;
import com.bytedance.awemeopen.infra.base.net.request.b;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q64.c;

/* JADX INFO: loaded from: classes46.dex */
public final class AoNet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function0<String> f198669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function0<String> f198670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f198671c = null;

    public AoNet() {
    }

    static {
        f198669a = AoNet$accessToken$1.INSTANCE;
        f198670b = AoNet$openId$1.INSTANCE;
        f198671c = LazyKt.lazy(AoNet$baseContext$2.INSTANCE);
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        AoNetResponse r101 = a(r100, null);
        if (r101.isSuccessful() == true) goto L5;
    L9:
        return null;
    L5:
        if (r101.getBody() == null) goto L9;
        return r101.stringBody();
    }

    public static Pair c(String r100) {
        Map r101 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headerMap");
        AoNetResponse r102 = a(r100, r101);
        String r103 = r102.getHeaderString(NetResponse.HEADER_KEY_LOG_ID);
        if (r102.isSuccessful() == false) goto L9;
        if (r102.getBody() == null) goto L9;
        return new Pair(r102.stringBody(), r103);
    L9:
        return new Pair(null, r103);
    }

    public static b64.a d(AoNetRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        ConcurrentHashMap<Integer, b> r101 = com.bytedance.awemeopen.infra.base.net.request.a.f198703a;
        Application r102 = (Application) f198671c.getValue();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "request");
        return new b64.a(r102, r100);
    }

    public static AoNetResponse a(String r210, Map r211) {
        Intrinsics.checkNotNullParameter(r210, "url");
        if (r211 != null) goto L5;
        AoFromSource r100 = AoFromSource.f98default;
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r100, "fromSource");
        Intrinsics.checkNotNullParameter(r210, "httpUrl");
        Intrinsics.checkNotNullParameter(r100, "fromSource");
        ArrayList r101 = new ArrayList();
        AoRequestType r110 = AoRequestType.HOST;
        HashMap r102 = new HashMap();
        Intrinsics.checkNotNullParameter("GET", e.f25671s);
        return d(new AoNetRequest(r210, "GET", r100, false, true, false, false, false, new c(r101), true, r110, null, 60000, 60000, 60000, true, null, false, r102)).execute();
    L5:
        AoFromSource r103 = AoFromSource.f98default;
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r103, "fromSource");
        Intrinsics.checkNotNullParameter(r211, "headers");
        AoNetRequest.a r104 = new AoNetRequest.a(r210, r103);
        r104.c(r211);
        r104.f198678g = false;
        Intrinsics.checkNotNullParameter("GET", e.f25671s);
        r104.f198673b = "GET";
        r104.f198686o = null;
        return d(r104.a()).execute();
    }

    public static AoNetResponse e(String r100, Map r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, "jsonParams");
        return h(r100, AoFromSource.f98default, r102, r101);
    }

    public static AoNetResponse f(String r100, AoFromSource r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "fromSource");
        Intrinsics.checkNotNullParameter(r102, "headers");
        com.bytedance.awemeopen.infra.base.net.mime.c r103 = new com.bytedance.awemeopen.infra.base.net.mime.c();
        AoNetRequest.a r104 = new AoNetRequest.a(r100, r101);
        r104.c(r102);
        r104.b(r103);
        return d(r104.a()).execute();
    }

    public static AoNetResponse g(String r210, AoFromSource r211, JSONObject r212) {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "fromSource");
        Intrinsics.checkNotNullParameter(r212, "data");
        d r110 = new d(r212);
        Intrinsics.checkNotNullParameter(r210, "httpUrl");
        Intrinsics.checkNotNullParameter(r211, "fromSource");
        ArrayList r100 = new ArrayList();
        AoRequestType r111 = AoRequestType.HOST;
        HashMap r213 = new HashMap();
        Intrinsics.checkNotNullParameter(r110, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter("POST", e.f25671s);
        return d(new AoNetRequest(r210, "POST", r211, false, true, false, false, false, new c(r100), true, r111, r110, 60000, 60000, 60000, true, null, false, r213)).execute();
    }

    public static AoNetResponse i(String r100, Map r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, "params");
        AoFromSource r103 = AoFromSource.f98default;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "fromSource");
        Intrinsics.checkNotNullParameter(r101, "headers");
        com.bytedance.awemeopen.infra.base.net.mime.b r104 = new com.bytedance.awemeopen.infra.base.net.mime.b();
        if (r102 == null) goto L16;
        Intrinsics.checkNotNullParameter(r102, "map");
        Iterator r105 = r102.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L16;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r107 = (String) r106.getKey();
        String r108 = (String) r106.getValue();
        Intrinsics.checkNotNullParameter(r107, "name");
        Intrinsics.checkNotNullParameter(r108, "value");
        Intrinsics.checkNotNullParameter(r107, "name");
        Intrinsics.checkNotNullParameter(r108, "value");
        if (r104.f198702a.size() <= 0) goto L18;
        r104.f198702a.write(38);
    L18:
        String r109 = URLEncoder.encode(r107, "UTF-8");     // Catch: IOException -> L13
        String r110 = URLEncoder.encode(r108, "UTF-8");     // Catch: IOException -> L13
        r104.f198702a.write(r109.getBytes(Charset.forName("UTF-8")));     // Catch: IOException -> L13
        r104.f198702a.write(61);     // Catch: IOException -> L13
        r104.f198702a.write(r110.getBytes(Charset.forName("UTF-8")));     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        AoNetRequest.a r111 = new AoNetRequest.a(r100, r103);
        r111.b(r104);
        r111.c(r101);
        return d(r111.a()).execute();
    }

    public static AoNetResponse h(String r100, AoFromSource r101, JSONObject r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "fromSource");
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r103, "headers");
        d r104 = new d(r102);
        AoNetRequest.a r105 = new AoNetRequest.a(r100, r101);
        r105.b(r104);
        r105.c(r103);
        return d(r105.a()).execute();
    }
}
