package ki4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503612b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f503611a, r101.f503611a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503612b, r101.f503612b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f503611a.hashCode() * 31) + this.f503612b.hashCode();
    }

    public final String toString() {
        return "FolderKey(name=" + this.f503611a + ", id=" + this.f503612b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f503611a = r100;
        this.f503612b = r101;
    }
}
