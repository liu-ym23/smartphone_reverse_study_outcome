package zb3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final long b;
    public final long c;
    public final String d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L16;
        d r7 = (d) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.d;
        if (r7 == null) goto L9;
        r1 = r7.hashCode();
    L9:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.e;
        ?? r10 = r9;
        if (r9 == false) goto L13;
        r10 = 1;
    L13:
        return r8 + r10;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentListRequestParam(productId=" + this.a + ", cursor=" + this.b + ", count=" + this.c + ", entrance=" + this.d + ", needAdaptAddr=" + this.e + ")";
    }

    public d() {
        this("", 0, 0, "", false);
    }

    public d(String r2, long r3, long r5, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "productId");
        Intrinsics.checkNotNullParameter(r7, "entrance");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
    }
}
