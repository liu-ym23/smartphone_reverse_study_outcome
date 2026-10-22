package ki4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503614b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f503613a, r101.f503613a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503614b, r101.f503614b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f503613a.hashCode() * 31) + this.f503614b.hashCode();
    }

    public final String toString() {
        return "GroupKey(name=" + this.f503613a + ", id=" + this.f503614b + ')';
    }

    public b() {
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter("", "id");
        this.f503613a = "";
        this.f503614b = "";
    }
}
