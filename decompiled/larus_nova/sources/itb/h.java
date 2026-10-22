package itb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f495764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495765c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f495763a, r101.f495763a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495764b, r101.f495764b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495765c, r101.f495765c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f495763a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f495764b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f495765c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeBuiltInResourceResult(path=" + this.f495763a + ", version=" + this.f495764b + ", failMsg=" + this.f495765c + ')';
    }

    public h(String r100, Long r101, String r102) {
        this.f495763a = r100;
        this.f495764b = r101;
        this.f495765c = r102;
    }
}
