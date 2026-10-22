package jx5;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f500874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f500875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f500876c;

    public c() {
        this.f500875b = -1.0d;
        this.f500874a = (int) Math.ceil(20.0d);
    }

    public final void a(double r100) {
        int r101 = this.f500876c;
        if (r101 <= this.f500874a) goto L5;
        this.f500875b = Math.exp((0.95d * Math.log(this.f500875b)) + (0.05d * Math.log(r100)));
    L8:
        this.f500876c++;
        return;
    L5:
        if (r101 <= 0) goto L7;
        double r102 = r101;
        double r103 = (0.95d * r102) / (r102 + 1.0d);
        this.f500875b = Math.exp((r103 * Math.log(this.f500875b)) + ((1.0d - r103) * Math.log(r100)));
        goto L8
    L7:
        this.f500875b = r100;
        goto L8
    }
}
