package gm3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f481661c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f481659a == r101.f481659a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f481660b, r101.f481660b) == true) goto L10;
        return false;
    L10:
        if (this.f481661c == r101.f481661c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = this.f481659a * 31;
        String r101 = this.f481660b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f481661c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActionItem(id=" + this.f481659a + ", name=" + this.f481660b + ", dismissAfterClick=" + this.f481661c + ")";
    }

    public a(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f481659a = r100;
        this.f481660b = r101;
        this.f481661c = r102;
    }
}
