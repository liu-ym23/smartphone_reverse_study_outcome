package io.opentelemetry.sdk.trace;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f492737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f492738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ntc.c> f492739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final itc.g f492740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ntc.g f492743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f492744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f492745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f492746j;

    public final int hashCode() {
        int r100 = (((((((((((((((this.f492737a.hashCode() ^ 1000003) * 1000003) ^ this.f492738b.hashCode()) * 1000003) ^ this.f492739c.hashCode()) * 1000003) ^ this.f492740d.hashCode()) * 1000003) ^ this.f492741e) * 1000003) ^ this.f492742f) * 1000003) ^ this.f492743g.hashCode()) * 1000003) ^ this.f492744h.hashCode()) * 1000003;
        long r101 = this.f492745i;
        int r102 = (r100 ^ ((int) (r101 ^ (r101 >>> 32)))) * 1000003;
        if (this.f492746j == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 ^ r103;
    L5:
        r103 = 1237;
        goto L7
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final itc.g f() {
        return this.f492740d;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final h g() {
        return this.f492737a;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final long h() {
        return this.f492745i;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final boolean i() {
        return this.f492746j;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final String j() {
        return this.f492744h;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final List<ntc.c> k() {
        return this.f492739c;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final List<Object> l() {
        return this.f492738b;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final ntc.g m() {
        return this.f492743g;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final int n() {
        return this.f492741e;
    }

    @Override // io.opentelemetry.sdk.trace.r
    public final int o() {
        return this.f492742f;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == false) goto L30;
        r r101 = (r) r100;
        if (this.f492737a.equals(r101.g()) == true) goto L10;
    L28:
        return false;
    L10:
        if (this.f492738b.equals(r101.l()) == false) goto L28;
        if (this.f492739c.equals(r101.k()) == false) goto L28;
        if (this.f492740d.equals(r101.f()) == false) goto L28;
        if (this.f492741e != r101.n()) goto L28;
        if (this.f492742f != r101.o()) goto L28;
        if (this.f492743g.equals(r101.m()) == false) goto L28;
        if (this.f492744h.equals(r101.j()) == false) goto L28;
        if (this.f492745i != r101.h()) goto L28;
        if (this.f492746j != r101.i()) goto L28;
        return true;
    L30:
        return false;
    }

    public c(h r100, List r101, List r102, itc.g r103, int r104, int r105, ntc.b r106, String r107, long r108, boolean r110) {
        if (r100 == null) goto L27;
        this.f492737a = r100;
        if (r101 == null) goto L25;
        this.f492738b = r101;
        if (r102 == null) goto L23;
        this.f492739c = r102;
        if (r103 == null) goto L21;
        this.f492740d = r103;
        this.f492741e = r104;
        this.f492742f = r105;
        if (r106 == null) goto L19;
        this.f492743g = r106;
        if (r107 == null) goto L17;
        this.f492744h = r107;
        this.f492745i = r108;
        this.f492746j = r110;
        return;
    L17:
        throw new NullPointerException("Null name");
    L19:
        throw new NullPointerException("Null status");
    L21:
        throw new NullPointerException("Null attributes");
    L23:
        throw new NullPointerException("Null resolvedEvents");
    L25:
        throw new NullPointerException("Null resolvedLinks");
    L27:
        throw new NullPointerException("Null delegate");
    }
}
