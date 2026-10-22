package ws9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f561107b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f561106a, r101.f561106a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f561107b, r101.f561107b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f561106a.hashCode() * 31) + this.f561107b.hashCode();
    }

    public final String toString() {
        return "GlobalSearchResultItemWrapper(snapshotQuery=" + this.f561106a + ", globalSearchResultItem=" + this.f561107b + ')';
    }

    public c() {
        this("", new b(null, 7));
    }

    public c(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshotQuery");
        Intrinsics.checkNotNullParameter(r101, "globalSearchResultItem");
        this.f561106a = r100;
        this.f561107b = r101;
    }
}
