package m7c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512427b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f512426a, r101.f512426a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512427b, r101.f512427b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f512426a.hashCode() * 31) + this.f512427b.hashCode();
    }

    public final String toString() {
        return "SectionRenameData(sectionGuid=" + this.f512426a + ", sectionName=" + this.f512427b + ')';
    }

    public j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        Intrinsics.checkNotNullParameter(r101, "sectionName");
        this.f512426a = r100;
        this.f512427b = r101;
    }
}
