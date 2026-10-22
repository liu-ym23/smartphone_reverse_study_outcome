package es3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public final int a;
    public int b;
    public final long c;
    public final int d;
    public int e;

    public final String toString() {
        return this.d + "," + this.a + "," + this.e + "," + this.b + "," + this.c;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof m) == false) goto L10;
        m r4 = (m) r3;
        if (r4.a == this.a) goto L7;
        return false;
    L7:
        if (r4.d != this.d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public m(int r2, int r3, long r4, int r6) {
        this.e = 1;
        this.a = r2;
        this.b = r3;
        this.d = r6;
        this.c = r4;
    }
}
