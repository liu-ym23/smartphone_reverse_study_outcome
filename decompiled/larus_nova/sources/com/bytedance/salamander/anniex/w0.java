package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f268461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f268462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f268463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f268464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f268465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f268466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f268467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f268468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f268469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f268470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f268471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f268472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f268473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f268474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f268475o;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public final w0 b() {
        w0 r100 = new w0();
        r100.f268461a = this.f268461a;
        r100.f268462b = this.f268462b;
        r100.f268463c = this.f268463c;
        r100.f268464d = this.f268464d;
        r100.f268465e = this.f268465e;
        r100.f268466f = this.f268466f;
        r100.f268467g = this.f268467g;
        g r101 = this.f268468h;
        Intrinsics.checkNotNullParameter(r101, "maskBgColor");
        r100.f268468h = r101;
        r100.f268469i = this.f268469i;
        r100.f268470j = this.f268470j;
        r100.f268471k = this.f268471k;
        r100.f268472l = this.f268472l;
        r100.f268473m = this.f268473m;
        r100.f268474n = this.f268474n;
        r100.f268475o = this.f268475o;
        return r100;
    }

    public w0() {
        this.f268462b = true;
        double r100 = 0;
        this.f268463c = r100;
        this.f268464d = r100;
        this.f268465e = r100;
        this.f268466f = r100;
        this.f268467g = r100;
        com.bytedance.anniex.bd.foundation.impl.m r101 = g.f268070d;
        this.f268468h = g.a.c();
        this.f268469i = r100;
        this.f268470j = r100;
        this.f268471k = r100;
        this.f268472l = r100;
        this.f268473m = r100;
        this.f268474n = r100;
        this.f268475o = r100;
    }

    public final boolean a(double r100, double r101) {
        double r102 = this.f268469i;
        if (r100 >= r102) goto L5;
    L11:
        return false;
    L5:
        if (r100 > (r102 + this.f268464d)) goto L11;
        double r103 = this.f268470j;
        if (r101 < r103) goto L11;
        if (r101 > (r103 + this.f268463c)) goto L11;
        return true;
    }
}
