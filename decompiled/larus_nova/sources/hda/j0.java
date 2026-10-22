package hda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484702b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f484701a, r101.f484701a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484702b, r101.f484702b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f484701a.hashCode() * 31) + this.f484702b.hashCode();
    }

    public final String toString() {
        return "MemoryReviewInfoChip(label=" + this.f484701a + ", value=" + this.f484702b + ')';
    }

    public j0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f484701a = r100;
        this.f484702b = r101;
    }
}
