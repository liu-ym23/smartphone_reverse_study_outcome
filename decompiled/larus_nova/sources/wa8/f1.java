package wa8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f558854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f558855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558856c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (Intrinsics.areEqual(this.f558854a, r101.f558854a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558855b, r101.f558855b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558856c, r101.f558856c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        e1 r100 = this.f558854a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        e1 r104 = this.f558855b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f558856c;
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
        return "CreationReferenceMediaInfo(icon=" + this.f558854a + ", darkModeIcon=" + this.f558855b + ", descriptionText=" + this.f558856c + ')';
    }

    public f1(e1 r100, e1 r101, String r102) {
        this.f558854a = r100;
        this.f558855b = r101;
        this.f558856c = r102;
    }
}
