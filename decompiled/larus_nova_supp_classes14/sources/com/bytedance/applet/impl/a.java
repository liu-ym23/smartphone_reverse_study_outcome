package com.bytedance.applet.impl;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Interceptor {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final SsResponse<?> intercept(Interceptor.Chain r12) {
        Intrinsics.checkNotNullParameter(r12, "chain");
        Request r0 = r12.request();
        String r1 = UriProtector.parse(r0.getUrl()).getHost();
        Header r4 = null;
        if (r1 == null) goto L28;
        String r2 = r1.toLowerCase(Locale.ROOT);
        if (r2 == null) goto L28;
        List r5 = com.larus.platform.api.b2.a.i();
        if ((r5 instanceof Collection) == true) goto L9;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L28;
        String r7 = StringsKt.trim((String) r6.next()).toString().toLowerCase(Locale.ROOT);
        if (r7.length() <= 0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L21;
        r7 = null;
    L21:
        if (r7 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L13;
        boolean r3 = true;
    L30:
        if (r3 == false) goto L38;
        Map r10 = com.larus.platform.api.b2.a.f();
        String r11 = a(r10, "X-Aweme-Visitor-Session-Id");
        if (r11 == null) goto L35;
        r4 = new Header("X-Aweme-Visitor-Session-Id", r11);
        goto L38
    L35:
        String r13 = a(r10, "X-Doubao-Access-Token");
        if (r13 == null) goto L38;
        r4 = new Header("X-Doubao-Access-Token", r13);
    L38:
        if (r4 == null) goto L40;
        Intrinsics.checkNotNull(r0);
        List r14 = r0.getHeaders();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L43:
        if (r16.hasNext() == false) goto L53;
        Object r17 = r16.next();
        Header r18 = (Header) r17;
        if (StringsKt.equals(r18.getName(), "X-Aweme-Visitor-Session-Id", true) == false) goto L47;
    L50:
        boolean r19 = true;
    L51:
        if (r19 == true) goto L43;
        r15.add(r17);
        goto L43
    L47:
        if (StringsKt.equals(r18.getName(), "X-Doubao-Access-Token", true) == true) goto L50;
        r19 = false;
        goto L51
    L53:
        List r20 = CollectionsKt.toMutableList(r15);
        r20.add(r4);
        return r12.proceed(r0.newBuilder().headers(r20).build());
    L40:
        return r12.proceed(r0);
    L23:
        if (StringsKt.contains$default(r2, r7, false, 2, null) != true) goto L25;
        r9 = true;
        goto L26
    L17:
        r8 = false;
        goto L18
    L9:
        if (r5.isEmpty() == false) goto L11;
    L28:
        r3 = false;
        goto L30
    }

    public static String a(Map r4, String r5) {
        Iterator r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (StringsKt.equals((String) ((Map.Entry) r0).getKey(), r5, true) == false) goto L4;
    L9:
        Map.Entry r1 = (Map.Entry) r0;
        if (r1 == null) goto L20;
        String r7 = (String) r1.getValue();
        if (r7 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r7)) == true) goto L16;
        return null;
    L16:
        return r7;
    L20:
        return null;
    L8:
        r0 = null;
        goto L9
    }
}
