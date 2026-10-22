package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f247584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, l> f247586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, l> f247587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, l> f247588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f247589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f247590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f247591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f247592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<g> f247593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f247594k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f247595l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, l> f247596m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, l> f247597n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f247598o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f247599p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f247600q;

    public static final class a {
    }

    static {
    }

    public t(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        this.f247585b = "GET";
        this.f247586c = new LinkedHashMap();
        this.f247587d = new LinkedHashMap();
        this.f247588e = new LinkedHashMap();
        this.f247593j = new ArrayList();
        boolean r100 = true;
        this.f247594k = true;
        this.f247596m = new LinkedHashMap();
        this.f247597n = new LinkedHashMap();
        this.f247584a = r110.optString("url");
        this.f247585b = r110.optString(com.alipay.sdk.m.p.e.f25671s);
        JSONObject r101 = r110.optJSONObject("headers");
        if (r101 == null) goto L13;
        Iterator<String> r102 = r101.keys();
        if (r102 == null) goto L13;
    L7:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        JSONObject r104 = r101.optJSONObject(r103);
        Map<String, l> r105 = this.f247586c;
        if (r104 == null) goto L11;
        l r106 = new l(r104);
    L12:
        r105.put(r103, r106);
        goto L7
    L11:
        r106 = new l(r101.optString(r103));
    L13:
        this.f247587d = new LinkedHashMap();
        JSONObject r107 = r110.optJSONObject("params");
        if (r107 == null) goto L20;
        Iterator<String> r108 = r107.keys();
        if (r108 == null) goto L20;
    L18:
        if (r108.hasNext() == false) goto L20;
        String r109 = r108.next();
        this.f247587d.put(r109, new l(r107.optJSONObject(r109)));
    L20:
        this.f247588e = new LinkedHashMap();
        JSONObject r111 = r110.optJSONObject("data");
        if (r111 == null) goto L27;
        Iterator<String> r112 = r111.keys();
        if (r112 == null) goto L27;
    L25:
        if (r112.hasNext() == false) goto L27;
        String r113 = r112.next();
        this.f247588e.put(r113, new l(r111.optJSONObject(r113)));
    L27:
        this.f247589f = r110.optBoolean("needCommonParams", true);
        this.f247598o = r110.optBoolean("isCustomizedCookie", false);
        if (r110.has("expireMs") == false) goto L30;
        this.f247590g = Long.valueOf(r110.optLong("expireMs"));
    L30:
        long r114 = r110.optLong("expireTimestamp", -1);
        List<String> r115 = null;
        if (r114 > 0) goto L33;
        Long r116 = null;
    L34:
        this.f247591h = r116;
        this.f247592i = r110.optString("globalPropsName");
        JSONArray r117 = r110.optJSONArray("conditions");
        if (r117 == null) goto L41;
        ArrayList r118 = new ArrayList();
        int r119 = r117.length();
        int r120 = 0;
    L37:
        if (r120 >= r119) goto L39;
        r118.add(new g(JSONArrayProtectorUtils.getJSONObject(r117, r120)));
        r120 = r120 + 1;
        goto L37
    L39:
        this.f247593j = r118;
    L41:
        if (r110.optInt("requestIgnoreCache", 1) != 1) goto L43;
        boolean r121 = true;
    L44:
        this.f247594k = r121;
        if (r110.optInt("clearCacheBeforeRequest", 0) != 1) goto L47;
        boolean r122 = true;
    L48:
        this.f247595l = r122;
        if (r110.optInt("streamLoadType", 0) == 1) goto L52;
        r100 = false;
    L52:
        this.f247599p = r100;
        JSONArray r123 = r110.optJSONArray("appendGlobalProps");
        if (r123 == null) goto L55;
        r115 = com.bytedance.ies.bullet.service.base.x.b(r123);
    L55:
        this.f247600q = r115;
        this.f247596m = new LinkedHashMap();
        JSONObject r124 = r110.optJSONObject("extraHeaders");
        if (r124 == null) goto L62;
        Iterator<String> r125 = r124.keys();
        if (r125 == null) goto L62;
    L60:
        if (r125.hasNext() == false) goto L62;
        String r126 = r125.next();
        this.f247596m.put(r126, new l(r124.optJSONObject(r126)));
    L62:
        this.f247597n = new LinkedHashMap();
        JSONObject r127 = r110.optJSONObject("extraParams");
        if (r127 == null) goto L69;
        Iterator<String> r128 = r127.keys();
        if (r128 != null) goto L67;
        return;
    L67:
        if (r128.hasNext() == false) goto L79;
        String r129 = r128.next();
        this.f247597n.put(r129, new l(r127.optJSONObject(r129)));
        goto L67
    L79:
        return;
    L69:
        return;
    L47:
        r122 = false;
        goto L48
    L43:
        r121 = false;
        goto L44
    L33:
        r116 = Long.valueOf(r114);
        goto L34
    }

    public final boolean a(d0 r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaModel");
        Iterator r100 = ((ArrayList) this.f247593j).iterator();
    L3:
        boolean r101 = true;
        if (r100.hasNext() == false) goto L28;
        g r102 = (g) r100.next();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "schemaModel");
        String r103 = r102.f247540a;
        if (Intrinsics.areEqual(r103, "query") == false) goto L9;
        String r104 = r110.a(r102.f247541b);
    L12:
        if (r104 != null) goto L14;
        r104 = "null";
    L14:
        String r105 = r102.f247542c;
        if (Intrinsics.areEqual(r105, ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L18;
        r101 = ((ArrayList) r102.f247543d).contains(r104);
    L23:
        int r106 = j.f247548a;
        String r107 = "检查预取条件, key: " + r102.f247541b + ", query: " + r104 + ", value: " + r102.f247543d + ", result: " + r101;
        if (r107 == null) goto L26;
        HybridLogger.m("XPrefetch", r107, null, null, 12);
    L26:
        if (r101 == true) goto L3;
        return false;
    L18:
        if (Intrinsics.areEqual(r105, "!=") == false) goto L23;
        if (((ArrayList) r102.f247543d).contains(r104) == false) goto L23;
        r101 = false;
        goto L23
    L9:
        if (Intrinsics.areEqual(r103, "queryObject") == false) goto L11;
        r104 = r110.b(r102.f247541b);
        goto L12
    L11:
        r104 = null;
        goto L12
    L28:
        return true;
    }
}
