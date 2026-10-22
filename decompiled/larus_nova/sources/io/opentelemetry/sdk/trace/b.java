package io.opentelemetry.sdk.trace;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends p.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f492731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f492732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f492733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f492736g;

    public final int hashCode() {
        return ((((((((((this.f492731b ^ 1000003) * 1000003) ^ this.f492732c) * 1000003) ^ this.f492733d) * 1000003) ^ this.f492734e) * 1000003) ^ this.f492735f) * 1000003) ^ this.f492736g;
    }

    public final String toString() {
        return "SpanLimitsValue{maxNumberOfAttributes=" + this.f492731b + ", maxNumberOfEvents=" + this.f492732c + ", maxNumberOfLinks=" + this.f492733d + ", maxNumberOfAttributesPerEvent=" + this.f492734e + ", maxNumberOfAttributesPerLink=" + this.f492735f + ", maxAttributeValueLength=" + this.f492736g + com.alipay.sdk.m.u.i.f25855d;
    }

    public b() {
        this.f492731b = 128;
        this.f492732c = 128;
        this.f492733d = 128;
        this.f492734e = 128;
        this.f492735f = 128;
        this.f492736g = Integer.MAX_VALUE;
    }

    @Override // io.opentelemetry.sdk.trace.p.a, io.opentelemetry.sdk.trace.p
    public final int a() {
        return this.f492736g;
    }

    @Override // io.opentelemetry.sdk.trace.p
    public final int b() {
        return this.f492731b;
    }

    @Override // io.opentelemetry.sdk.trace.p
    public final int c() {
        return this.f492734e;
    }

    @Override // io.opentelemetry.sdk.trace.p
    public final int d() {
        return this.f492735f;
    }

    @Override // io.opentelemetry.sdk.trace.p
    public final int e() {
        return this.f492732c;
    }

    @Override // io.opentelemetry.sdk.trace.p
    public final int f() {
        return this.f492733d;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof p.a) == false) goto L22;
        p.a r101 = (p.a) r100;
        if (this.f492731b == r101.b()) goto L10;
    L20:
        return false;
    L10:
        if (this.f492732c != r101.e()) goto L20;
        if (this.f492733d != r101.f()) goto L20;
        if (this.f492734e != r101.c()) goto L20;
        if (this.f492735f != r101.d()) goto L20;
        if (this.f492736g != r101.a()) goto L20;
        return true;
    L22:
        return false;
    }
}
