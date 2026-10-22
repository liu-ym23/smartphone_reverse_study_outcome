package m7c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512423b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f512422a, r101.f512422a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512423b, r101.f512423b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f512422a.hashCode() * 31) + this.f512423b.hashCode();
    }

    public final String toString() {
        return "SectionCreateData(sectionGuid=" + this.f512422a + ", sectionName=" + this.f512423b + ')';
    }

    public h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        Intrinsics.checkNotNullParameter(r101, "sectionName");
        this.f512422a = r100;
        this.f512423b = r101;
    }
}
