package rjc;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f538233e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f538234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f538235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f538236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f538237d;

    static {
        f538233e = new c(0, 600);
        new c(600, 600);
    }

    public c() {
        this(0, 600);
    }

    public final Object clone() throws CloneNotSupportedException {
        return new c(this.f538234a, this.f538235b, this.f538236c, this.f538237d);
    }

    public final String toString() {
        return "[value = " + this.f538234a + " timeScale = " + this.f538235b + " timeUs = " + this.f538237d + "]";
    }

    public c(float r100) {
        this((long) (r100 * 600.0f), 600);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == true) goto L5;
        return false;
    L5:
        c r101 = (c) r100;
        if (this.f538234a == r101.f538234a) goto L8;
        return false;
    L8:
        if (this.f538235b != r101.f538235b) goto L12;
        return true;
    L12:
        return false;
    }

    public c(long r100, int r101) {
        this.f538234a = r100;
        this.f538235b = r101;
        this.f538236c = (r100 * 1.0f) / r101;
        this.f538237d = (r100 * 1000000) / ((long) r101);
    }

    public c(long r100, int r101, float r102, long r103) {
        this.f538234a = r100;
        this.f538237d = r103;
        this.f538236c = r102;
        this.f538235b = r101;
    }
}
