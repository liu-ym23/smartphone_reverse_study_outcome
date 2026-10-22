package com.bytedance.salamander.anniex;

import com.bytedance.android.ec.slice.SliceInitService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f268305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f268306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f268307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f268308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f268309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f268310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f268311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f268312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONArray f268313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f268314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f268315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f268316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f268317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f268318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f268319o;

    public final String a() {
        int r100 = or3.a.f524932a;
        JSONObject r101 = new JSONObject();
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "status_code", String.valueOf(this.f268305a));
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "origin_schema", this.f268306b);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "resolved_schema", this.f268307c);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "config_type", this.f268308d);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "config_version", this.f268309e);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "entry", this.f268310f);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "default_schema", this.f268311g);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "code_type", this.f268315k);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "api_type", this.f268316l);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "schema_host", this.f268317m);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "loop_index", String.valueOf(this.f268312h));
        JSONArray r102 = this.f268313i;
        Intrinsics.checkNotNullParameter(r102, "jsonArray");
        Intrinsics.checkNotNullParameter(r102, "jsonArray");
        String r103 = r102.toString();
        if (r103 != null) goto L5;
        r103 = SliceInitService.DEFAULT_SWITCH;
    L5:
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "rule_types", r103);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "error_code", String.valueOf(this.f268314j));
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "error_message", this.f268318n);
        com.bytedance.anniex.bd.foundation.impl.o.r(r101, "schema_source", this.f268319o);
        return com.bytedance.anniex.bd.foundation.impl.o.a(r101);
    }

    public q2() {
        this.f268306b = "";
        this.f268307c = "";
        this.f268308d = "";
        this.f268309e = "";
        this.f268310f = "";
        this.f268311g = "";
        int r100 = com.bytedance.anniex.bd.foundation.impl.b.f190140a;
        int r101 = or3.a.f524932a;
        this.f268313i = new JSONArray();
        this.f268315k = "RTS";
        this.f268316l = "";
        this.f268317m = "";
        this.f268318n = "";
        this.f268319o = "";
    }
}
