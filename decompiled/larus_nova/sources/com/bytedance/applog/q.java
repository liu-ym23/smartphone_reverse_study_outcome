package com.bytedance.applog;

import android.text.TextUtils;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdinstall.x;
import com.bytedance.bdinstall.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public x0 A;
    public boolean B;
    public x C;
    public boolean D;
    public boolean E;
    public d F;
    public boolean G;
    public boolean H;
    public f84.c I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f192810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f192812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f0 f192813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f192814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f192815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f192816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f192817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f192818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f192819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f192820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f192821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f192822n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f192823o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f192824p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f192825q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f192826r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f192827s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g0 f192828t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f192829u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f192830v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f192831w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f192832x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f192833y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f192834z;

    public final String a() {
        if (TextUtils.isEmpty(this.f192833y) == false) goto L11;
        StringBuilder r100 = new StringBuilder();
        String r101 = this.f192809a;
        if (r101 == null) goto L7;
        String r102 = r101.toString();
    L8:
        r100.append(r102);
        r100.append("@bd_tea_agent.db");
        return r100.toString();
    L7:
        r102 = "";
        goto L8
    L11:
        return this.f192833y;
    }

    public q(String r100, String r101) {
        this.f192810b = true;
        this.f192816h = false;
        this.f192817i = 0;
        this.f192830v = true;
        this.f192831w = false;
        this.f192832x = true;
        this.C = null;
        this.E = false;
        this.G = false;
        this.H = true;
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.f192809a = r100;
        this.f192811c = r101;
        return;
    L9:
        throw new IllegalStateException("Channel must not be empty!");
    L11:
        throw new IllegalStateException("App id must not be empty!");
    }
}
