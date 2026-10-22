package io.opentelemetry.sdk.trace.samplers;

import com.alipay.sdk.m.u.i;
import itc.g;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SamplingDecision f492806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f492807d;

    public final int hashCode() {
        return ((this.f492806c.hashCode() ^ 1000003) * 1000003) ^ this.f492807d.hashCode();
    }

    public final String toString() {
        return "ImmutableSamplingResult{decision=" + this.f492806c + ", attributes=" + this.f492807d + i.f25855d;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.b
    public final g a() {
        return this.f492807d;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.b
    public final SamplingDecision b() {
        return this.f492806c;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f492806c.equals(r101.b()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.f492807d.equals(r101.a()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public a(SamplingDecision r100, itc.b r101) {
        if (r100 == null) goto L11;
        this.f492806c = r100;
        if (r101 == null) goto L9;
        this.f492807d = r101;
        return;
    L9:
        throw new NullPointerException("Null attributes");
    L11:
        throw new NullPointerException("Null decision");
    }
}
