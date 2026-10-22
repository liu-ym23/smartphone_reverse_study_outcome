package y84;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final float a;
    public final float b;
    public final int c;
    public final float d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "Seg(bearing=" + this.a + ", distance=" + this.b + ", idx=" + this.c + ", dt=" + this.d + ")";
    }

    public c(float r1, float r2, int r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
