package com.obric.common.oea.foundation.animation.spec.spring;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f396387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f396388b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Double.compare(this.f396387a, r101.f396387a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f396388b, r101.f396388b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f396387a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f396388b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.f396387a + ", _imaginary=" + this.f396388b + ")";
    }

    public a(double r100, double r101) {
        this.f396387a = r100;
        this.f396388b = r101;
    }
}
