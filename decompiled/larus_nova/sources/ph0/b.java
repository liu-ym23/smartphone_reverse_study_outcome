package ph0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f529231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f529232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f529233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f529234d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f529231a, r101.f529231a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f529232b, r101.f529232b) == true) goto L10;
        return false;
    L10:
        if (this.f529233c == r101.f529233c) goto L12;
        return false;
    L12:
        if (this.f529234d == r101.f529234d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.f529231a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f529232b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((r103 + r101) * 31) + this.f529233c) * 31;
        boolean r106 = this.f529234d;
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
        return "RtsLinkTypeEvent(uid=" + this.f529231a + ", interactId=" + this.f529232b + ", linkType=" + this.f529233c + ", forceResumeVideo=" + this.f529234d + ")";
    }

    public b(String r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "interactId");
        this.f529231a = r100;
        this.f529232b = r101;
        this.f529233c = r102;
        this.f529234d = r103;
    }
}
