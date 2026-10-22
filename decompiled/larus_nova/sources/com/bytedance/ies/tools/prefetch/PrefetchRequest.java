package com.bytedance.ies.tools.prefetch;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class PrefetchRequest {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f248744l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f248745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f248746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f248747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f248748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f248749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SortedMap<String, String> f248750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SortedMap<String, Object> f248751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f248752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f248753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f248754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f248755k;

    static {
        f248744l = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchRequest.class), "str", "getStr()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchRequest.class), "jsonObject", "getJsonObject()Lorg/json/JSONObject;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchRequest.class), "hashCode", "getHashCode()I"))};
    }

    public final int hashCode() {
        Lazy r100 = this.f248747c;
        KProperty r101 = f248744l[2];
        return ((Number) r100.getValue()).intValue();
    }

    public final String toString() {
        Lazy r100 = this.f248745a;
        KProperty r101 = f248744l[0];
        return (String) r100.getValue();
    }

    public PrefetchRequest(JSONObject r110) {
        String r100 = r110.optString("url");
        String r101 = r110.optString(com.alipay.sdk.m.p.e.f25671s, MonitorConstants.CONNECT_TYPE_GET);
        JSONObject r102 = r110.optJSONObject("headers");
        SortedMap<String, String> r103 = null;
        if (r102 == null) goto L5;
        SortedMap<String, String> r104 = g0.e(r102);
    L6:
        JSONObject r105 = r110.optJSONObject("params");
        if (r105 == null) goto L12;
        TreeMap r106 = new TreeMap();
        Iterator<String> r107 = r105.keys();
    L10:
        if (r107.hasNext() == false) goto L13;
        String r108 = r107.next();
        r106.put(r108, r105.get(r108));
    L13:
        JSONObject r109 = r110.optJSONObject("data");
        boolean r111 = r110.optBoolean("needCommonParams", false);
        JSONObject r112 = r110.optJSONObject("extras");
        if (r112 == null) goto L16;
        r103 = g0.e(r112);
    L16:
        this(r100, r101, r104, r106, r109, r111, r103, Boolean.valueOf(r110.optBoolean("ignore_headers", false)));
        return;
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof PrefetchRequest) == true) goto L5;
        return false;
    L5:
        PrefetchRequest r101 = (PrefetchRequest) r100;
        if (Intrinsics.areEqual(this.f248748d, r101.f248748d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f248749e, r101.f248749e) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f248750f, r101.f248750f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f248751g, r101.f248751g) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f248752h, r101.f248752h) == true) goto L16;
        return false;
    L16:
        if (this.f248753i == r101.f248753i) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f248754j, r101.f248754j) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f248755k, r101.f248755k) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public PrefetchRequest(String r100, String r101, SortedMap<String, String> r102, SortedMap<String, Object> r103, JSONObject r104, boolean r105, Map<String, String> r106, Boolean r107) {
        this.f248748d = r100;
        this.f248749e = r101;
        this.f248750f = r102;
        this.f248751g = r103;
        this.f248752h = r104;
        this.f248753i = r105;
        this.f248754j = r106;
        this.f248755k = r107;
        this.f248745a = LazyKt.lazy(new PrefetchRequest$str$2(this));
        this.f248746b = LazyKt.lazy(new PrefetchRequest$jsonObject$2(this));
        this.f248747c = LazyKt.lazy(new AnonymousClass2(this));
    }
}
