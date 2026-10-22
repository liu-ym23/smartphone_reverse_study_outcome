package com.larus.bmhome.utils;

import androidx.collection.ArrayMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f315083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f315084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayMap<String, Integer> f315085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayMap<String, Integer> f315086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f315087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f315088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f315089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f315090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f315091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f315092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f315093l;

    public static final class a {
    }

    static {
    }

    public p0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f315082a = r100;
        this.f315085d = new ArrayMap();
        this.f315086e = new ArrayMap();
        this.f315087f = LazyKt.lazy(new m0());
        this.f315088g = LazyKt.lazy(new n0());
        this.f315089h = LazyKt.lazy(new o0());
        this.f315090i = "CREATE_VH_DEFAULT";
        this.f315091j = "BIND_VH_DEFAULT";
        this.f315092k = "CREATE_VH_COUNT_DEFAULT";
        this.f315093l = "BIND_VH_COUNT_DEFAULT";
    }
}
