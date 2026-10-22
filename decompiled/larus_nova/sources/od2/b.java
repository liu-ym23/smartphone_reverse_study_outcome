package od2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f522817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522818c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f522816a, r101.f522816a) == true) goto L8;
        return false;
    L8:
        if (this.f522817b == r101.f522817b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f522818c, r101.f522818c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r100 = this.f522816a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f522817b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f522818c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenInfo(source=" + this.f522816a + ", isAdjust=" + this.f522817b + ", tabName=" + this.f522818c + ")";
    }

    public b(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f522816a = r100;
        this.f522817b = r101;
        this.f522818c = r102;
    }
}
