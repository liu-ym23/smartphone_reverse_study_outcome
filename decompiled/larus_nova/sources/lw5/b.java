package lw5;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f511020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f511021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f511022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f511023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f511024e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f511020a == r101.f511020a) goto L12;
        return false;
    L12:
        if (this.f511021b == r101.f511021b) goto L15;
        return false;
    L15:
        if (Double.compare(this.f511022c, r101.f511022c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f511023d, r101.f511023d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f511024e, r101.f511024e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f511020a * 31) + this.f511021b) * 31;
        long r101 = Double.doubleToLongBits(this.f511022c);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f511023d);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.f511024e);
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public final String toString() {
        return "FlowVoiceInputMetersGeneratorConfig(meterGroupNum=" + this.f511020a + ", meterPerGroup=" + this.f511021b + ", minHeight=" + this.f511022c + ", maxHeight=" + this.f511023d + ", scaleFactor=" + this.f511024e + ')';
    }

    public b(int r100) {
        this.f511020a = 7;
        this.f511021b = 5;
        this.f511022c = 0.1d;
        this.f511023d = 0.8d;
        this.f511024e = 8.0d;
    }
}
