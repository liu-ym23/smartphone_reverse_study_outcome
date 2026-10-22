package rjc;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f538231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f538232b;

    public b() {
        this(1.0f, 1.0f);
    }

    public final Object clone() throws CloneNotSupportedException {
        return new b(this.f538231a, this.f538232b);
    }

    public final String toString() {
        return "[" + this.f538231a + "," + this.f538232b + "]";
    }

    static {
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (r101.f538231a == this.f538231a) goto L8;
        return false;
    L8:
        if (r101.f538232b != this.f538232b) goto L12;
        return true;
    L12:
        return false;
    }

    public b(float r100, float r101) {
        this.f538231a = r100;
        this.f538232b = r101;
    }
}
