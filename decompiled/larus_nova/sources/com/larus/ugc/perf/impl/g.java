package com.larus.ugc.perf.impl;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f375112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f375113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f375114d;

    public static final class a {
    }

    static {
    }

    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, String>> r101 = this.f375113c.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L6:
        r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, String.valueOf(System.currentTimeMillis() - this.f375112b));
        Iterator<Map.Entry<String, Object>> r103 = this.f375114d.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, Object> r104 = r103.next();
        r100.putOpt(r104.getKey(), r104.getValue());
        goto L8
    L10:
        return r100;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f375112b;
    }

    public final String toString() {
        return c().toString();
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f375111a = r100;
        this.f375113c = new ConcurrentHashMap();
        this.f375114d = new ConcurrentHashMap();
        this.f375112b = System.currentTimeMillis();
    }

    public final Object b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.f375113c.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return this.f375114d.get(r100);
    }

    public final void e(Pair<String, ? extends Object> r100) {
        if (r100 == null) goto L5;
        this.f375114d.put(r100.getFirst(), r100.getSecond());
        return;
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f375113c.put(r100, r101);
    }
}
