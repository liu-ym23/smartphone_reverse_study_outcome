package oq2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f524840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f524842c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f524840a, r101.f524840a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f524841b, r101.f524841b) == true) goto L10;
        return false;
    L10:
        if (this.f524842c == r101.f524842c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f524840a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f524841b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f524842c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevCustomMultiBg(topBgUrl=" + this.f524840a + ", bottomBgUrl=" + this.f524841b + ", isAnim=" + this.f524842c + ")";
    }

    public a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "topBgUrl");
        Intrinsics.checkNotNullParameter(r101, "bottomBgUrl");
        this.f524840a = r100;
        this.f524841b = r101;
        this.f524842c = r102;
    }
}
