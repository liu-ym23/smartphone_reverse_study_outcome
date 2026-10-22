package vb3;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f554011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f554012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f554013c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f554011a == r101.f554011a) goto L8;
        return false;
    L8:
        if (this.f554012b == r101.f554012b) goto L10;
        return false;
    L10:
        if (this.f554013c == r101.f554013c) goto L19;
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
        long r100 = this.f554011a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f554012b;
        ?? r103 = r102;
        if (r102 == false) goto L5;
        r103 = 1;
    L5:
        long r104 = this.f554013c;
        return ((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "CommentDiggEvent(commentId=" + this.f554011a + ", isDigg=" + this.f554012b + ", diggCount=" + this.f554013c + ")";
    }

    public a(long r100, boolean r101, long r102) {
        this.f554011a = r100;
        this.f554012b = r101;
        this.f554013c = r102;
    }
}
