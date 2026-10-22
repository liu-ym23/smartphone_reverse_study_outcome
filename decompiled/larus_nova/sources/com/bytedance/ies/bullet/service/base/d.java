package com.bytedance.ies.bullet.service.base;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public final long A;
    public final boolean A0;
    public final long B;
    public final boolean B0;
    public final int C;
    public final boolean C0;
    public final long D;
    public final long D0;
    public final int E;
    public final int E0;
    public final int F;
    public final int F0;
    public final double G;
    public final int G0;
    public final long H;
    public final com.bytedance.ies.bullet.base.settings.b H0;
    public final long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final long f247805J;
    public final long K;
    public final long L;
    public final long M;
    public final long N;
    public final boolean O;
    public final long P;
    public final boolean Q;
    public final Long R;
    public final boolean S;
    public final Integer T;
    public final long U;
    public final long V;
    public final int W;
    public final float X;
    public final float Y;
    public final float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f247806a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f247807a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f247808b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f247809b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f247810c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final int f247811c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f247812d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f247813d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f247814e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final boolean f247815e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Number f247816f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final boolean f247817f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f247818g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final int f247819g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f247820h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final long f247821h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f247822i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final long f247823i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f247824j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final int f247825j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f247826k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final int f247827k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f247828l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final double f247829l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f247830m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final double f247831m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.bytedance.sdk.xbridge.cn.optimize.c> f247832n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final int f247833n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f247834o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final int f247835o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, ? extends List<String>> f247836p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int f247837p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f247838q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final long f247839q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f247840r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final int f247841r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f247842s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final int f247843s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f247844t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final int f247845t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f247846u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final int f247847u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f247848v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final int f247849v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f247850w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final boolean f247851w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f247852x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final boolean f247853x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f247854y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final boolean f247855y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f247856z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final boolean f247857z0;

    public d() {
        this.f247806a = 2097152;
        this.f247808b = new ArrayList();
        new ArrayList();
        this.f247810c = true;
        this.f247812d = true;
        this.f247814e = CollectionsKt.emptyList();
        this.f247816f = 0;
        this.f247818g = CollectionsKt.emptyList();
        this.f247820h = CollectionsKt.emptyList();
        this.f247822i = true;
        this.f247824j = 1;
        this.f247826k = true;
        this.f247828l = true;
        this.f247830m = true;
        this.f247832n = new ArrayList();
        this.f247834o = true;
        this.f247836p = new LinkedHashMap();
        this.f247838q = Boolean.FALSE;
        this.f247840r = true;
        this.f247842s = 200;
        this.f247844t = 10000;
        this.f247846u = 1500;
        this.f247848v = 500;
        this.f247850w = 360.0f;
        this.f247852x = 0.9f;
        this.f247854y = 500;
        this.f247856z = 500;
        this.A = ((long) 60) * 1000;
        this.B = 60000;
        this.C = 10;
        this.D = 2000;
        this.E = 10;
        this.F = 10;
        this.G = 0.2d;
        this.H = 500;
        this.I = 10000;
        this.f247805J = 20;
        this.K = 240;
        this.L = 240;
        this.M = 1000;
        this.N = 1000;
        this.O = true;
        this.P = 30000;
        this.Q = true;
        this.R = 0L;
        this.S = true;
        this.T = 0;
        this.U = 1000;
        this.V = 1000;
        this.W = 10;
        this.X = 0.2f;
        this.Y = 0.2f;
        this.Z = 0.1f;
        this.f247807a0 = 1;
        this.f247809b0 = 2;
        this.f247811c0 = 10;
        this.f247813d0 = 1;
        this.f247815e0 = true;
        this.f247817f0 = true;
        this.f247819g0 = 3;
        this.f247821h0 = 3000;
        this.f247823i0 = 2000;
        this.f247825j0 = 100;
        this.f247827k0 = 50;
        this.f247829l0 = 0.7d;
        this.f247831m0 = 0.7d;
        this.f247833n0 = 5;
        this.f247835o0 = 1000;
        this.f247837p0 = 1000;
        this.f247839q0 = ((((long) 24) * 30) * ((long) AnnouncementViewModel.HOUR_DURATION)) * ((long) 1000);
        this.f247841r0 = 5;
        this.f247843s0 = 10;
        this.f247845t0 = 5;
        this.f247847u0 = 5;
        this.f247849v0 = 5;
        this.f247851w0 = true;
        this.f247853x0 = true;
        this.f247855y0 = true;
        this.f247857z0 = true;
        this.A0 = true;
        this.B0 = true;
        this.C0 = true;
        this.D0 = 1000;
        this.E0 = 512;
        this.F0 = 3;
        this.G0 = 20;
        this.H0 = new com.bytedance.ies.bullet.base.settings.b(0);
    }
}
