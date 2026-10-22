package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;

/* JADX INFO: loaded from: classes36.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f457345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f457346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f457347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f457348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f457349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f457350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f457351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f457352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f457353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f457354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f457355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f457356l;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "primaryKey: " + this.f457345a + ", type: " + this.f457346b + ", effectId: " + this.f457347c + ", panel: " + this.f457348d + ", resource_id: " + this.f457349e + ", uri: " + this.f457350f + ", biz_space: " + this.f457351g + ", last_access_time: " + this.f457352h + ", use_count: " + this.f457353i + ", file_size: " + this.f457354j + ", source: " + this.f457355k + ", model_name: " + this.f457356l;
    }

    public k() {
        this.f457345a = "";
        this.f457346b = -1;
        this.f457347c = "";
        this.f457348d = "";
        this.f457349e = "";
        this.f457350f = "";
        this.f457351g = -1;
        this.f457352h = 0;
        this.f457353i = 0;
        this.f457354j = 0;
        this.f457355k = -1;
        this.f457356l = "";
    }

    public final int getType() {
        return this.f457346b;
    }

    public k(Effect r100) {
        this();
        String r101 = com.ss.ugc.effectplatform.model.b.a(r100);
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        this.f457345a = r101;
        this.f457346b = 0;
        this.f457347c = r100.getEffect_id();
        this.f457348d = r100.getPanel();
        this.f457349e = r100.getResource_id();
        this.f457350f = r100.getUnzipPath();
        int r102 = b0.a.f16820a;
        this.f457352h = System.currentTimeMillis();
        this.f457355k = 0;
    }

    public k(ModelInfo r100, String r101) {
        this();
        this.f457345a = com.ss.ugc.effectplatform.util.k.a(r100);
        this.f457346b = 1;
        this.f457350f = r101;
        int r102 = b0.a.f16820a;
        this.f457352h = System.currentTimeMillis();
        this.f457355k = 0;
        this.f457356l = r100.getName();
    }
}
