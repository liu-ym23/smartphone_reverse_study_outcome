package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f277175e = "a";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f277176f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f277177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f277178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f277179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f277180d;

    static {
        f277176f = new ConcurrentHashMap(16);
    }

    public a(c r100, c r101, g r102) {
        this.f277177a = new ConcurrentHashMap(16);
        this.f277179c = r101;
        this.f277178b = r100;
        this.f277180d = r102;
        r102.a(this);
    }

    private void a(GrsBaseInfo r100, b r110, Context r111, String r112) {
        String r101 = r100.getGrsParasKey(true, true, r111);
        Long r102 = this.f277177a.get(r101);
        if (e.a(r102) == false) goto L7;
        r110.a(2);
        return;
    L7:
        if (e.a(r102, 300000) == false) goto L9;
        com.huawei.hms.framework.network.grs.g.j.c r103 = new com.huawei.hms.framework.network.grs.g.j.c(r100, r111);
        this.f277180d.a(r103, null, r112, this.f277179c, -1);
    L9:
        r110.a(1);
    }

    private void a(GrsBaseInfo r100, String r101, Context r102) {
        if (e.a(this.f277177a.get(r101), 300000) == false) goto L6;
        com.huawei.hms.framework.network.grs.g.j.c r103 = new com.huawei.hms.framework.network.grs.g.j.c(r100, r102);
        this.f277180d.a(r103, null, null, this.f277179c, -1);
        return;
    }

    public c a() {
        return this.f277178b;
    }

    public Map<String, String> a(GrsBaseInfo r100, String r101, b r102, Context r103) {
        String r104 = r100.getGrsParasKey(true, true, r103);
        Map<String, Map<String, Map<String, String>>> r105 = f277176f;
        Map<String, Map<String, String>> r106 = r105.get(r104);
        if (r106 != null) goto L5;
    L9:
        Logger.d(f277175e, "Cache size is: " + r105.size());
        return new HashMap();
    L5:
        if (r106.isEmpty() == true) goto L9;
        a(r100, r102, r103, r101);
        return r106.get(r101);
    }

    public void a(GrsBaseInfo r100, Context r101) {
        String r102 = r100.getGrsParasKey(true, true, r101);
        this.f277178b.b(r102 + "time", "0");
        this.f277177a.remove(r102 + "time");
        Map<String, Map<String, Map<String, String>>> r103 = f277176f;
        r103.remove(r102);
        Logger.d(f277175e, "Cache size is: " + r103.size());
        this.f277180d.a(r102);
    }

    public void a(GrsBaseInfo r100, d r101, Context r102, com.huawei.hms.framework.network.grs.g.j.c r103) {
        if (r101.f() != 2) goto L7;
        Logger.w(f277175e, "update cache from server failed");
        return;
    L7:
        if (r103.d().size() != 0) goto L16;
        String r104 = r100.getGrsParasKey(true, true, r102);
        if (r101.m() == false) goto L11;
        f277176f.put(r104, com.huawei.hms.framework.network.grs.a.a(this.f277178b.a(r104, "")));
    L13:
        if (TextUtils.isEmpty(r101.e()) == true) goto L15;
        this.f277178b.b(r104 + "ETag", r101.e());
    L15:
        this.f277178b.b(r104 + "time", r101.a());
        this.f277177a.put(r104, Long.valueOf(CastLongProtector.parseLong(r101.a())));
    L17:
        Logger.d(f277175e, "Cache size is: " + f277176f.size());
        return;
    L11:
        this.f277178b.b(r104, r101.j());
        f277176f.put(r104, com.huawei.hms.framework.network.grs.a.a(r101.j()));
        goto L13
    L16:
        this.f277178b.b("geoipCountryCode", r101.j());
        this.f277178b.b("geoipCountryCodetime", r101.a());
        goto L17
    }

    public g b() {
        return this.f277180d;
    }

    public void b(GrsBaseInfo r100, Context r101) {
        String r102 = r100.getGrsParasKey(true, true, r101);
        String r103 = this.f277178b.a(r102, "");
        String r104 = this.f277178b.a(r102 + "time", "0");
        long r105 = 0;
        if (TextUtils.isEmpty(r104) == false) goto L5;
    L10:
        Map<String, Map<String, Map<String, String>>> r106 = f277176f;
        r106.put(r102, com.huawei.hms.framework.network.grs.a.a(r103));
        Logger.d(f277175e, "Cache size is: " + r106.size());
        this.f277177a.put(r102, Long.valueOf(r105));
        a(r100, r102, r101);
        return;
    L5:
        if (r104.matches("\\d+") == false) goto L10;
        r105 = CastLongProtector.parseLong(r104);     // Catch: NumberFormatException -> L8
    L8:
        e = move-exception;
        Logger.w(f277175e, "convert urlParamKey from String to Long catch NumberFormatException.", e);
        goto L10
    }

    public c c() {
        return this.f277179c;
    }
}
