package com.bytedance.pythia.predict;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements n87.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f267117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f267118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f267119c;

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f267117a) * 31) + Float.floatToIntBits(this.f267118b)) * 31) + Float.floatToIntBits(this.f267119c);
    }

    public final String toString() {
        return "PerfLevelImpl(instantValue=" + this.f267117a + ", recentValue=" + this.f267118b + ", stableValue=" + this.f267119c + ")";
    }

    @Override // n87.a
    public final float a() {
        return this.f267117a;
    }

    @Override // n87.a
    public final float b() {
        return this.f267119c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Float.compare(this.f267117a, r101.f267117a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f267118b, r101.f267118b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f267119c, r101.f267119c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public a(float r100, float r101, float r102) {
        this.f267117a = r100;
        this.f267118b = r101;
        this.f267119c = r102;
    }
}
