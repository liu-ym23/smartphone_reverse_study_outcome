package nt1;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f520466c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f520464a == r101.f520464a) goto L8;
        return false;
    L8:
        if (this.f520465b == r101.f520465b) goto L10;
        return false;
    L10:
        if (this.f520466c == r101.f520466c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        int r100 = ((this.f520464a * 31) + this.f520465b) * 31;
        boolean r101 = this.f520466c;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "NotificationSetting(imageResId=" + this.f520464a + ", textResId=" + this.f520465b + ", isChecked=" + this.f520466c + ")";
    }

    public b(int r100, int r101, boolean r102) {
        this.f520464a = r100;
        this.f520465b = r101;
        this.f520466c = r102;
    }
}
