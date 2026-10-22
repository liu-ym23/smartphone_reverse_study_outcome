package com.bytedance.ies.tools.prefetch;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import kotlin.TypeCastException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f248781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f248782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f248783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SortedMap<String, String> f248784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SortedMap<String, f0<?>> f248785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SortedMap<String, f0<?>> f248786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f248787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f248788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f248789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f248790j;

    public a0() {
        throw null;
    }

    public final String toString() {
        return "hashCode: " + hashCode() + ", url: " + this.f248781a + ", method: " + this.f248782b + ", expireTimeout: " + this.f248787g;
    }

    public a0(JSONObject r110) {
        String r100 = r110.optString("url");
        String r101 = r110.optString(com.alipay.sdk.m.p.e.f25671s, "GET");
        Locale r102 = Locale.ROOT;
        if (r101 == null) goto L27;
        String r103 = r101.toLowerCase(r102);
        JSONObject r104 = r110.optJSONObject("headers");
        if (r104 == null) goto L7;
        SortedMap<String, String> r105 = g0.e(r104);
    L8:
        JSONObject r106 = r110.optJSONObject("params");
        if (r106 == null) goto L11;
        SortedMap<String, f0<?>> r107 = g0.f(r106);
    L12:
        JSONObject r108 = r110.optJSONObject("data");
        if (r108 == null) goto L15;
        SortedMap<String, f0<?>> r109 = g0.f(r108);
    L16:
        long r111 = r110.optLong("expire", -1) * ((long) 1000);
        if (r111 >= 0) goto L20;
        r111 = 30000;
    L20:
        boolean r112 = r110.optBoolean("needCommonParams", false);
        JSONObject r113 = r110.optJSONObject("extras");
        if (r113 == null) goto L23;
        SortedMap<String, String> r114 = g0.e(r113);
    L24:
        Boolean r115 = Boolean.valueOf(r110.optBoolean("ignore_headers", false));
        this.f248781a = r100;
        this.f248782b = r103;
        this.f248783c = null;
        this.f248784d = r105;
        this.f248785e = r107;
        this.f248786f = r109;
        this.f248787g = r111;
        this.f248788h = r112;
        this.f248789i = r114;
        this.f248790j = r115;
        return;
    L23:
        r114 = null;
        goto L24
    L15:
        r109 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L7:
        r105 = null;
        goto L8
    L27:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
