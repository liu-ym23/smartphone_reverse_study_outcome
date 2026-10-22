package m7c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512430b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f512429a, r101.f512429a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512430b, r101.f512430b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f512429a.hashCode() * 31) + this.f512430b.hashCode();
    }

    public final String toString() {
        return "TaskShareData(taskGuid=" + this.f512429a + ", digest=" + this.f512430b + ')';
    }

    public l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "taskGuid");
        Intrinsics.checkNotNullParameter(r101, "digest");
        this.f512429a = r100;
        this.f512430b = r101;
    }
}
