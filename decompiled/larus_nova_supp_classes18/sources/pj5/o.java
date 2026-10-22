package pj5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final int a;
    public final String b;
    public final boolean c;
    public final long d;
    public final int e;

    public o() {
        this(-1, "", false, -1, -1);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        long r3 = this.d;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "FreshnessParam(objType=" + this.a + ", objToken=" + this.b + ", isCustomer=" + this.c + ", deadlineTime=" + this.d + ", freshStatus=" + this.e + ')';
    }

    public o(int r2, String r3, boolean r4, long r5, int r7) {
        Intrinsics.checkNotNullParameter(r3, "objToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }
}
