package com.bytedance.ies.bullet.prefetchv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a36.c f247555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f247556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f247557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f247558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f247559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f247560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f247561h;

    public final a36.c getIdentifier() {
        return this.f247555b;
    }

    public n(String r100, a36.a r101, String r102, boolean r103, int r104, String r105, long r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r102, "prefetchApi");
        Intrinsics.checkNotNullParameter("bridge", "prefetchFrom");
        Intrinsics.checkNotNullParameter(r105, "errorMsg");
        this.f247554a = r100;
        this.f247555b = r101;
        this.f247556c = r102;
        this.f247557d = r103;
        this.f247558e = r104;
        this.f247559f = r105;
        this.f247560g = r106;
        this.f247561h = r110;
    }
}
