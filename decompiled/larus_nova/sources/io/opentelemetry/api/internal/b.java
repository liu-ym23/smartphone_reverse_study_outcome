package io.opentelemetry.api.internal;

import jtc.m;
import jtc.n;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f492665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f492666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f492667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f492668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f492669g;

    public final int hashCode() {
        int r100 = (((((((this.f492664b.hashCode() ^ 1000003) * 1000003) ^ this.f492665c.hashCode()) * 1000003) ^ this.f492666d.hashCode()) * 1000003) ^ this.f492667e.hashCode()) * 1000003;
        int r101 = 1231;
        if (this.f492668f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 ^ r102) * 1000003;
        if (this.f492669g == true) goto L11;
        r101 = 1237;
    L11:
        return r103 ^ r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImmutableSpanContext{traceId=" + this.f492664b + ", spanId=" + this.f492665c + ", traceFlags=" + this.f492666d + ", traceState=" + this.f492667e + ", remote=" + this.f492668f + ", valid=" + this.f492669g + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // io.opentelemetry.api.internal.h
    public final boolean a() {
        return this.f492669g;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == false) goto L22;
        h r101 = (h) r100;
        if (this.f492664b.equals(((b) r101).f492664b) == false) goto L20;
        b r102 = (b) r101;
        if (this.f492665c.equals(r102.f492665c) == false) goto L20;
        if (this.f492666d.equals(r102.f492666d) == false) goto L20;
        if (this.f492667e.equals(r102.f492667e) == false) goto L20;
        if (this.f492668f != r102.f492668f) goto L20;
        if (this.f492669g != r101.a()) goto L20;
        return true;
    L20:
        return false;
    L22:
        return false;
    }

    public b(String r100, String r101, jtc.f r102, n r103, boolean r104) {
        if (r100 == null) goto L19;
        this.f492664b = r100;
        if (r101 == null) goto L17;
        this.f492665c = r101;
        if (r102 == null) goto L15;
        this.f492666d = r102;
        if (r103 == null) goto L13;
        this.f492667e = r103;
        this.f492668f = false;
        this.f492669g = r104;
        return;
    L13:
        throw new NullPointerException("Null traceState");
    L15:
        throw new NullPointerException("Null traceFlags");
    L17:
        throw new NullPointerException("Null spanId");
    L19:
        throw new NullPointerException("Null traceId");
    }
}
