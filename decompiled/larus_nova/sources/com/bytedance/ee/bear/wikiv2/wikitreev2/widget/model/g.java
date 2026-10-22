package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d3 f241873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f241874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f241875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f241876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f241877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f241878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f241879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f241880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f241881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f241882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f241883n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f241884o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f241885p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f241886q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f241887r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f241888s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f241889t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f241890u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f241891v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f241892w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<String> f241893x;

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f241883n = r100;
    }

    public g(WikiAction r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f241873d = r101;
        this.f241874e = "";
        this.f241875f = "";
        this.f241876g = "";
        new ArrayList();
        this.f241878i = "";
        this.f241879j = "";
        this.f241880k = "";
        this.f241881l = new ArrayList();
        this.f241882m = "";
        this.f241883n = "";
        this.f241884o = "";
        this.f241885p = "";
        this.f241886q = "";
        this.f241887r = "";
        this.f241889t = "";
        this.f241891v = "";
        this.f241892w = MoveSource.FROM_OTHER.getValue();
        this.f241893x = new ArrayList();
    }
}
