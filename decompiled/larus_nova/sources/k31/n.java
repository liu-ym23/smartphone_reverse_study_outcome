package k31;

/* JADX INFO: loaded from: classes47.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f501681c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f501682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501683b;

    public static final class a {
        public a() {
        }
    }

    static {
        f501681c = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L10;
        n r101 = (n) r100;
        if (this.f501682a == r101.f501682a) goto L8;
        return false;
    L8:
        if (this.f501683b == r101.f501683b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f501682a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f501683b;
    }

    public final String toString() {
        return "TopReserveOption(transForReserve=" + this.f501682a + ", reserveHeight=" + this.f501683b + ")";
    }

    public n(boolean r100, int r101) {
        this.f501682a = r100;
        this.f501683b = r101;
    }
}
