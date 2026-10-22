package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends h {
    public final d3 d;
    public String e;
    public String f;
    public String g;
    public List<String> h;
    public String i;
    public String j;
    public String k;
    public List<String> l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public boolean s;
    public String t;
    public int u;
    public String v;
    public int w;
    public List<String> x;

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public g(WikiAction r2, d3 r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
        this.d = r3;
        this.e = "";
        this.f = "";
        this.g = "";
        new ArrayList();
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = new ArrayList();
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.t = "";
        this.v = "";
        this.w = MoveSource.FROM_OTHER.getValue();
        this.x = new ArrayList();
    }
}
