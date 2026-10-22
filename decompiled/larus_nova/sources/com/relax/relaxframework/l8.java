package com.relax.relaxframework;

/* JADX INFO: loaded from: classes34.dex */
public final class l8 extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f405181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f405182b;

    @Override // com.relax.relaxframework.b2
    public final o8 b() {
        return new o8(TransformType.Scale.getValue(), com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(this.f405181a), Double.valueOf(this.f405182b)}));
    }

    public l8(double r100, double r101) {
        this.f405181a = r100;
        this.f405182b = r101;
    }
}
