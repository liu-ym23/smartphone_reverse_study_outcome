package com.bytedance.ies.bullet.prefetchv2;

import android.app.Application;
import android.net.Uri;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Triple;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f247563o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f247566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f247567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f247568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f247569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f247570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f247571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f247572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f247573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f247574k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f247575l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f247576m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f247577n;

    public static final class a {
        public static String c(String r100) {
            if (r100.equals("AID") == false) goto L7;
            return com.bytedance.ies.bullet.core.h.f246501h.f246505d;
        L7:
            if (r100.equals("OS") == false) goto L11;
            return "Android";
        L11:
            if (r100.equals("APP_VERSION") == false) goto L15;
            return com.bytedance.ies.bullet.core.h.f246501h.f246507f;
        L15:
            if (r100.equals("DID") == true) goto L17;
            return null;
        L17:
            return com.bytedance.ies.bullet.core.h.f246501h.f246508g;
        }

        public static JSONObject b(Map r100, d0 r101) {
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator r103 = ((LinkedHashMap) r100).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L28;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            l r106 = (l) r104.getValue();
            if (Intrinsics.areEqual(r106.getType(), "static") == true) goto L7;
            if (Intrinsics.areEqual(r106.getType(), "query") == true) goto L10;
            if (Intrinsics.areEqual(r106.getType(), "queryObject") == true) goto L15;
            if (Intrinsics.areEqual(r106.getType(), "userDomainStorage") == true) goto L20;
            if (Intrinsics.areEqual(r106.getType(), "env") == false) goto L4;
            String r107 = c(r106.f247550b.toString());
            if (r107 == null) goto L4;
            r102.put(r105, r107);
            goto L4
        L20:
            Object r108 = e(r106, r101);
            if (r108 == null) goto L4;
            r102.put(r105, r108);
            goto L4
        L15:
            String r109 = r101.b(r106.f247550b.toString());
            if (r109 == null) goto L4;
            r102.put(r105, r109);
            goto L4
        L10:
            String r110 = r101.a(r106.f247550b.toString());
            if (r110 == null) goto L4;
            r102.put(r105, r110);
            goto L4
        L7:
            r102.put(r105, r106.f247550b);
            goto L4
        L28:
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
            return new JSONObject(r102);
        }

        public static Map d(Map r100, d0 r101) {
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator r103 = ((LinkedHashMap) r100).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L31;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            l r106 = (l) r104.getValue();
            if (Intrinsics.areEqual(r106.getType(), "static") == true) goto L7;
            if (Intrinsics.areEqual(r106.getType(), "query") == true) goto L10;
            if (Intrinsics.areEqual(r106.getType(), "queryObject") == true) goto L15;
            if (Intrinsics.areEqual(r106.getType(), "userDomainStorage") == true) goto L20;
            if (Intrinsics.areEqual(r106.getType(), "env") == true) goto L25;
            if (r106.f247553e == false) goto L4;
            r102.put(r105, r106.f247552d);
            goto L4
        L25:
            String r107 = c(r106.f247550b.toString());
            if (r107 == null) goto L4;
            r102.put(r105, r107);
            goto L4
        L20:
            Object r108 = e(r106, r101);
            if (r108 == null) goto L4;
            r102.put(r105, r108.toString());
            goto L4
        L15:
            String r109 = r101.b(r106.f247550b.toString());
            if (r109 == null) goto L4;
            r102.put(r105, r109);
            goto L4
        L10:
            String r110 = r101.a(r106.f247550b.toString());
            if (r110 == null) goto L4;
            r102.put(r105, r110);
            goto L4
        L7:
            r102.put(r105, r106.f247550b.toString());
            goto L4
        L31:
            return r102;
        }

        public static Object e(l r100, d0 r101) {
            XBaseRuntime.f270095a.getClass();
            IHostUserDepend r102 = XBaseRuntime.f270103i;
            if (r102 == null) goto L5;
            String r103 = r102.getUserId();
        L6:
            boolean r104 = true;
            if (r103 != null) goto L9;
        L12:
            boolean r105 = true;
        L13:
            if (r105 == false) goto L21;
            IHostUserDepend r106 = XBaseRuntime.f270103i;
            if (r106 == null) goto L17;
            Boolean r107 = Boolean.valueOf(r106.hasLogin());
        L18:
            int r108 = j.f247548a;
            j.b("UID 为空，当前登录状态: " + r107);
            return null;
        L17:
            r107 = null;
            goto L18
        L21:
            if (r100.f247551c == false) goto L36;
            String r109 = r101.a("app_id");
            if (r109 != null) goto L25;
        L28:
            if (r104 == false) goto L31;
            j.b("appId为空");
            return null;
        L31:
            Application r110 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
            Intrinsics.checkNotNull(r110);
            Triple<Boolean, Boolean, Object> r111 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r110).c(r103 + "appId_" + r109, r100.f247550b.toString(), ErrorType.PREFETCH, "prefetch_session_id");
            boolean r112 = r111.component1().booleanValue();
            boolean r113 = r111.component2().booleanValue();
            Object r114 = r111.component3();
            if (r112 == false) goto L35;
            if (r113 == true) goto L35;
            return r114;
        L35:
            return null;
        L25:
            if (r109.length() == 0) goto L28;
            r104 = false;
            goto L28
        L36:
            Application r115 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
            Intrinsics.checkNotNull(r115);
            Triple<Boolean, Boolean, Object> r116 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r115).c(r103, r100.f247550b.toString(), ErrorType.PREFETCH, "prefetch_session_id");
            boolean r117 = r116.component1().booleanValue();
            boolean r118 = r116.component2().booleanValue();
            Object r119 = r116.component3();
            if (r117 == false) goto L40;
            if (r118 == true) goto L40;
            return r119;
        L40:
            return null;
        L9:
            if (r103.length() == 0) goto L12;
            r105 = false;
            goto L13
        L5:
            r103 = null;
            goto L6
        }

        public static p a(t r110, d0 r210, h r211) {
            Intrinsics.checkNotNullParameter(r110, "apiConfig");
            Intrinsics.checkNotNullParameter(r210, "schemaModel");
            Intrinsics.checkNotNullParameter(r211, "prefetchConfig");
            String r100 = r110.f247584a;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
            return null;
        L12:
            String r102 = r110.f247585b;
            Locale r103 = Locale.ROOT;
            if (r102 == null) goto L28;
            String r104 = r102.toLowerCase(r103);
            if (i.a(r104) == true) goto L29;
            int r105 = j.f247548a;
            j.b("不支持的请求类型: " + r104);
            return null;
        L29:
        L24:
            e = move-exception;
            int r106 = j.f247548a;
            j.b(e.getMessage());
            return null;
        L19:
            if (r110.a(r210) == true) goto L22;
            int r107 = j.f247548a;     // Catch: Exception -> L24
            j.c("不满足配置的条件，不发起prefetch请求，请检查condition配置：" + r110.f247584a);     // Catch: Exception -> L24
            return null;
        L22:
            p r108 = new p(r100, r104, d(r110.f247586c, r210), d(r110.f247587d, r210), b(r110.f247588e, r210), r110.f247589f, d(r110.f247596m, r210), d(r110.f247597n, r210), r110.f247598o, r110.f247599p, r110.f247600q);     // Catch: Exception -> L24
            String r109 = r211.f247545b;     // Catch: Exception -> L24
            Intrinsics.checkNotNullParameter(r109, "<set-?>");     // Catch: Exception -> L24
            r108.f247576m = r109;     // Catch: Exception -> L24
            String r111 = r211.f247547d;     // Catch: Exception -> L24
            Intrinsics.checkNotNullParameter(r111, "<set-?>");     // Catch: Exception -> L24
            r108.f247577n = r111;     // Catch: Exception -> L24
            return r108;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L10
        }
    }

    static {
    }

    public static String a(String r100, Map r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
        if (r101 == null) goto L8;
        Iterator r104 = r101.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.appendQueryParameter((String) r105.getKey(), (String) r105.getValue());
    L8:
        if (r102 == null) goto L14;
        Iterator r106 = r102.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L14;
        Map.Entry r107 = (Map.Entry) r106.next();
        r103.appendQueryParameter((String) r107.getKey(), (String) r107.getValue());
    L14:
        return r103.toString();
    }

    public static String b(String r100, Map r101, Map r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        if (r101 == null) goto L8;
        Iterator r105 = r101.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.appendQueryParameter((String) r106.getKey(), (String) r106.getValue());
    L8:
        if (r102 == null) goto L13;
        Iterator r107 = r102.entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r107.next();
        r104.appendQueryParameter((String) r108.getKey(), (String) r108.getValue());
    L13:
        r104.appendQueryParameter("appended_global_props", new JSONObject(r103).toString()).build();
        return r104.toString();
    }

    public /* synthetic */ p(String r110, String r111, Map r112, Map r113, JSONObject r114, boolean r210, boolean r211, boolean r212, int r213) {
        if ((r213 & 32) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r213 & 256) == 0) goto L9;
        boolean r115 = false;
    L11:
        if ((r213 & 512) == 0) goto L13;
        boolean r116 = false;
    L14:
        this(r110, r111, r112, r113, r114, r100, null, null, r115, r116, null);
        return;
    L13:
        r116 = r212;
        goto L14
    L9:
        r115 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public p(String r100, String r101, Map<String, String> r102, Map<String, String> r103, JSONObject r104, boolean r105, Map<String, String> r106, Map<String, String> r107, boolean r110, boolean r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f247564a = r100;
        this.f247565b = r101;
        this.f247566c = r102;
        this.f247567d = r103;
        this.f247568e = r104;
        this.f247569f = r105;
        this.f247570g = r106;
        this.f247571h = r107;
        this.f247572i = r110;
        this.f247573j = r111;
        this.f247574k = r112;
        this.f247576m = "unknown";
        this.f247577n = "default_bid";
        Object r108 = null;
        if (r102 == null) goto L13;
        LinkedHashMap r109 = new LinkedHashMap();
        Iterator r113 = ((LinkedHashMap) r102).entrySet().iterator();
    L6:
        if (r113.hasNext() == false) goto L12;
        Map.Entry r114 = (Map.Entry) r113.next();
        String r115 = (String) r114.getKey();
        if (r115 == null) goto L11;
        r109.put(r115.toLowerCase(), r114.getValue());
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        Object r116 = MapsKt.toSortedMap(r109);
    L14:
        Map<String, String> r117 = this.f247567d;
        if (r117 == null) goto L17;
        Object r118 = MapsKt.toSortedMap(r117);
    L18:
        JSONObject r119 = this.f247568e;
        if (r119 == null) goto L21;
        r108 = MapsKt.toSortedMap(i.b(r119));
    L21:
        StringBuilder r120 = new StringBuilder();
        r120.append(this.f247564a);
        r120.append(',');
        String r121 = this.f247565b;
        Locale r122 = Locale.ROOT;
        if (r121 == null) goto L35;
        r120.append(r121.toLowerCase(r122));
        r120.append(',');
        if (r116 != null) goto L26;
        r116 = SliceInitService.DEFAULT_SWITCH;
    L26:
        r120.append(r116);
        r120.append(',');
        if (r118 != null) goto L29;
        r118 = SliceInitService.DEFAULT_SWITCH;
    L29:
        r120.append(r118);
        r120.append(',');
        if (r108 != null) goto L32;
        r108 = SliceInitService.DEFAULT_SWITCH;
    L32:
        r120.append(r108);
        r120.append(',');
        r120.append(this.f247569f);
        r120.append(", ");
        r120.append(this.f247572i);
        r120.append(", ");
        r120.append(this.f247573j);
        this.f247575l = r120.toString();
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L17:
        r118 = null;
        goto L18
    L13:
        r116 = null;
        goto L14
    }
}
