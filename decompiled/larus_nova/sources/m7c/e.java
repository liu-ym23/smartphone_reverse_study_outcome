package m7c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f512400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f512401d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f512398a, r101.f512398a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512399b, r101.f512399b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512400c, r101.f512400c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512401d, r101.f512401d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f512398a.hashCode() * 31) + this.f512399b.hashCode()) * 31) + this.f512400c.hashCode()) * 31) + this.f512401d.hashCode();
    }

    public final String toString() {
        return "ListTaskItemDragData(taskGuid=" + this.f512398a + ", toSectionGuid=" + this.f512399b + ", beforeTaskGuid=" + this.f512400c + ", afterTaskGuid=" + this.f512401d + ')';
    }

    public e(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "taskGuid");
        Intrinsics.checkNotNullParameter(r101, "toSectionGuid");
        Intrinsics.checkNotNullParameter(r102, "beforeTaskGuid");
        Intrinsics.checkNotNullParameter(r103, "afterTaskGuid");
        this.f512398a = r100;
        this.f512399b = r101;
        this.f512400c = r102;
        this.f512401d = r103;
    }
}
