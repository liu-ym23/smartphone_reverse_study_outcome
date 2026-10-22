package sy3;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f543876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f543877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f543878c;

    public i() {
        this(false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f543876a == r101.f543876a) goto L12;
        return false;
    L12:
        if (this.f543877b == r101.f543877b) goto L15;
        return false;
    L15:
        if (this.f543878c == r101.f543878c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f543876a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f543877b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f543878c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "CommentViewConfig(enableDiggBury=" + this.f543876a + ", enableCmtAvatarClick=" + this.f543877b + ", isCardMode=" + this.f543878c + ')';
    }

    public i(boolean r100, boolean r101, boolean r102) {
        this.f543876a = r100;
        this.f543877b = r101;
        this.f543878c = r102;
    }
}
