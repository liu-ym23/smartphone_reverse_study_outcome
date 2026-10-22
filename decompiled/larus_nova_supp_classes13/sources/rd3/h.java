package rd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final String a;
    public final Integer b;
    public final long c;
    public final boolean d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L14;
        h r7 = (h) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.c;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        boolean r8 = this.d;
        ?? r9 = r8;
        if (r8 == false) goto L13;
        r9 = 1;
    L13:
        return r7 + r9;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "InflowFeedCommentVO(urlSchema=" + this.a + ", style=" + this.b + ", count=" + this.c + ", isShowCommentCounts=" + this.d + ")";
    }

    public h(String r1, Integer r2, long r3, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
