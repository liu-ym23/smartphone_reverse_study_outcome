package rjc;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f538229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f538230b;

    public final Object clone() throws CloneNotSupportedException {
        PointF r100 = this.f538229a;
        float r101 = r100.x;
        float r102 = r100.y;
        b r103 = this.f538230b;
        return new a(r101, r102, r103.f538231a, r103.f538232b);
    }

    public final String toString() {
        return "[" + this.f538229a + "," + this.f538230b + "]";
    }

    public a() {
        this.f538229a = new PointF();
        this.f538230b = new b();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L17;
        a r101 = (a) r100;
        if (this.f538229a.equals(r101.f538229a) == true) goto L13;
    L15:
        return false;
    L13:
        if (this.f538230b.equals(r101.f538230b) == false) goto L15;
        return true;
    }

    public a(PointF r100, b r101) {
        this.f538229a = r100;
        this.f538230b = r101;
    }

    public a(float r100, float r101, float r102, float r103) {
        this(new PointF(r100, r101), new b(r102, r103));
    }
}
