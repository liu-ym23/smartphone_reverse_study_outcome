package com.bytedance.salamander.anniex;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f268105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f268106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f268107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<j0> f268108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<j0> f268109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f268110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f268111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f268112h;

    public final i0 a() {
        i0 r100 = new i0();
        String r101 = this.f268105a;
        Intrinsics.checkNotNullParameter(r101, "annieXId");
        r100.f268105a = r101;
        g r102 = this.f268106b;
        Intrinsics.checkNotNullParameter(r102, "backgroundColor");
        r100.f268106b = r102;
        r100.f268107c = this.f268107c;
        ArrayList<j0> r103 = this.f268108d;
        Intrinsics.checkNotNullParameter(r103, "items");
        r100.f268108d = r103;
        ArrayList<j0> r104 = this.f268109e;
        Intrinsics.checkNotNullParameter(r104, "items");
        r100.f268109e = r104;
        String r105 = this.f268110f;
        Intrinsics.checkNotNullParameter(r105, "title");
        r100.f268110f = r105;
        g r106 = this.f268111g;
        Intrinsics.checkNotNullParameter(r106, "titleColor");
        r100.f268111g = r106;
        r100.f268112h = this.f268112h;
        return r100;
    }

    public i0() {
        this.f268105a = "";
        com.bytedance.anniex.bd.foundation.impl.m r100 = g.f268070d;
        this.f268106b = g.a.a();
        this.f268108d = com.bytedance.rts.foundation.j.k(new j0[0]);
        this.f268109e = com.bytedance.rts.foundation.j.k(new j0[0]);
        this.f268110f = "";
        this.f268111g = g.a.b();
        this.f268112h = true;
    }
}
