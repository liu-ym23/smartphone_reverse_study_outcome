package com.bytedance.anniex.bd.foundation.impl;

import android.util.Pair;
import com.bytedance.anniex.bd.utils.ISLNetworkAPI;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SLNetworkImpl {
    public SLNetworkImpl() {
    }

    public static final String a(SLNetworkImpl r1, String r2) {
        r1.getClass();
        SLNetworkImpl r3 = f.a;     // Catch: Throwable -> L5
        String r4 = URLEncoder.encode(r2, "UTF-8");     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L5
        return r4;
    L5:
        th = move-exception;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.foundation.RTSErrorKt.RTSError }");
        String r5 = th.getMessage();
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        throw new Throwable("Encoding error: ".concat(r5));
    }

    public final String b(String r8, final Map<String, String> r9) {
        if (r9 != null) goto L4;
        return r8;
    L4:
        if (r9.size() == 0) goto L20;
        ArrayList r0 = com.bytedance.rts.foundation.m.c(r9);
        if (com.bytedance.rts.foundation.j.d(r0) != 0) goto L9;
        String r10 = "";
    L11:
        if (r8.length() != 0) goto L14;
        return r10;
    L14:
        if (StringsKt.indexOf$default(r8, "?", 0, false, 6, null) < 0) goto L16;
        StringBuilder r1 = new StringBuilder();
        r1.append(r8);
        SLNetworkImpl r11 = f.a;
        r1.append("&");
    L17:
        r1.append(r10);
        return r1.toString();
    L16:
        r1 = new StringBuilder();
        r1.append(r8);
        r1.append('?');
        goto L17
    L9:
        final StringBuilder r2 = new StringBuilder();
        com.bytedance.rts.foundation.j.h(r0, new SLNetworkImpl$formatUrl$1(r2, this, r9));
        r10 = r2.toString();
        Intrinsics.checkNotNull(r10);
        goto L11
    L20:
        return r8;
    }

    public final void c(final lr3.c r6, Function2<? super lr3.b, ? super lr3.d, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "req");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r0 = b(r6.a, r6.d);     // Catch: Throwable -> L20
        Map r1 = TypeIntrinsics.asMutableMap(new LinkedHashMap());     // Catch: Throwable -> L20
        Pair r2 = UrlUtils.parseUrl(new UrlBuilder(r0).build(), r1);     // Catch: Throwable -> L20
        String r3 = null;
        if (r2 == null) goto L6;
        String r4 = (String) r2.first;     // Catch: Throwable -> L20
    L7:
        String r5 = "";
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (r2 == null) goto L12;
        r3 = (String) r2.second;     // Catch: Throwable -> L20
    L12:
        if (r3 == null) goto L15;
        r5 = r3;
    L15:
        v r8 = new v(r4, r5, r1);     // Catch: Throwable -> L20
        final ArrayList r9 = new ArrayList();     // Catch: Throwable -> L20
        Map<String, String> r10 = r6.e;     // Catch: Throwable -> L20
        if (r10 == null) goto L18;
        com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.m.c(r10), new SLNetworkImpl$parseHeaderList$1(r6, r9));     // Catch: Throwable -> L20
    L18:
        d(r6, r8, r9, r7);     // Catch: Throwable -> L20
        return;
    L6:
        r4 = null;
    }

    public static void d(lr3.c r10, v r11, ArrayList r12, Function2 r13) {
        String r0 = r11.a;
        String r4 = r11.b;
        Map<String, String> r14 = r11.c;
        JSONObject r9 = null;
        if (r14 == null) goto L5;
        Map<String, String> r5 = r14;
    L6:
        final LinkedHashMap r15 = new LinkedHashMap();
        Object r1 = RetrofitUtils.createSsService(r0, ISLNetworkAPI.class);
        Intrinsics.checkNotNull(r1);
        String r2 = r10.b;
        if (Intrinsics.areEqual(r2, "GET") == false) goto L10;
        boolean r3 = !Intrinsics.areEqual(r10.c, Boolean.FALSE);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header>");
        Call<String> r16 = ((ISLNetworkAPI) r1).doGetForString(r3, -1, r4, r5, r12, null);
    L28:
        if (r16 == null) goto L68;
        int r17 = 0;
        SsResponse r18 = r16.execute();     // Catch: Throwable -> L38
        if (r18 == null) goto L37;
        r17 = r18.code();     // Catch: Throwable -> L38
        String r6 = (String) r18.body();     // Catch: Throwable -> L38
        List r19 = r18.headers();     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.retrofit2.client.Header>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<com.bytedance.retrofit2.client.Header> }");     // Catch: Throwable -> L35
        com.bytedance.rts.foundation.j.h((ArrayList) r19, new SLNetworkImpl$requestInternal$2(r15));     // Catch: Throwable -> L35
    L67:
        lr3.b r7 = null;
    L71:
        if (r6 == null) goto L73;
        r9 = o.d(r6);
    L73:
        r13.invoke(r7, new lr3.d(r17, r15, r9));
        return;
    L35:
        th = th;
    L41:
        if ((th instanceof HttpResponseException) == false) goto L43;
        HttpResponseException r8 = (HttpResponseException) th;
    L45:
        if ((th instanceof NetworkNotAvailabeException) == false) goto L47;
        NetworkNotAvailabeException r20 = th;
    L49:
        if ((th instanceof CronetIOException) == false) goto L51;
        CronetIOException r110 = (CronetIOException) th;
    L52:
        if (r8 == null) goto L54;
        r17 = r8.getStatusCode();
        goto L67
    L54:
        String r21 = "";
        if (r20 == null) goto L61;
        String r111 = r20.getMessage();
        if (r111 == null) goto L60;
        r21 = r111;
    L60:
        lr3.b r112 = new lr3.b(r21);
    L69:
        r7 = r112;
        r17 = -1;
        goto L71
    L61:
        if (r110 == null) goto L67;
        r17 = r110.getStatusCode();
        String r22 = r110.getMessage();
        if (r22 == null) goto L66;
        r21 = r22;
    L66:
        r110.getStatusCode();
        r7 = new lr3.b(r21);
        goto L71
    L51:
        r110 = null;
        goto L52
    L47:
        r20 = null;
        goto L49
    L43:
        r8 = null;
        goto L45
    L37:
        r6 = null;
        r7 = null;
    L38:
        th = th;
        r6 = null;
        goto L41
    L68:
        r112 = null;
        r6 = null;
        goto L69
    L10:
        if (Intrinsics.areEqual(r2, "POST") == false) goto L27;
        SLNetworkImpl r23 = f.a;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header>");
        List<Header> r24 = CollectionsKt.toMutableList(r12);
        Iterator r113 = r12.iterator();
    L13:
        if (r113.hasNext() == false) goto L17;
        Object r25 = r113.next();
        String r26 = ((Header) r25).getName();
        SLNetworkImpl r27 = f.a;
        if (Intrinsics.areEqual(r26, "Content-Type") == false) goto L13;
    L18:
        Header r28 = (Header) r25;
        if (r28 == null) goto L21;
        String r114 = r28.getValue();
        Intrinsics.checkNotNull(r114);
    L22:
        Object r29 = r10.f;
        if (r29 == null) goto L25;
        Intrinsics.checkNotNull(r29);
        String r30 = o.e(TypeIntrinsics.asMutableMap(r29)).toString();
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type kotlin.String");
        TypedOutput r31 = new TypedByteArray(r114, StringsKt.encodeToByteArray(r30), new String[]{null});
    L26:
        boolean r32 = !Intrinsics.areEqual(r10.c, Boolean.FALSE);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header>");
        r16 = ((ISLNetworkAPI) r1).doPostForString(r32, -1, r4, r5, r24, r31, null);
        goto L28
    L25:
        r31 = null;
        goto L26
    L21:
        SLNetworkImpl r33 = f.a;
        r24.add(new Header("Content-Type", "application/json"));
        r114 = "application/json";
        goto L22
    L17:
        r25 = null;
        goto L18
    L27:
        SLNetworkImpl r115 = f.a;
        r13.invoke(new lr3.b("Unsupported Request Method"), null);
        r16 = null;
        goto L28
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("queryMap");
        r5 = null;
        goto L6
    }
}
