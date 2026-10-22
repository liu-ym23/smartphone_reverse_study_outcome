package vb3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final long a;
    public final boolean b;
    public final long c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L12;
        a r7 = (a) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        boolean r2 = this.b;
        ?? r3 = r2;
        if (r2 == false) goto L5;
        r3 = 1;
    L5:
        long r4 = this.c;
        return ((r1 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "CommentDiggEvent(commentId=" + this.a + ", isDigg=" + this.b + ", diggCount=" + this.c + ")";
    }

    public a(long r1, boolean r3, long r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
