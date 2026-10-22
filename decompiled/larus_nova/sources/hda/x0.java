package hda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f484791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484792b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (this.f484791a == r101.f484791a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484792b, r101.f484792b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f484791a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f484792b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MemoryReviewSubmitResultDto(accepted=" + this.f484791a + ", message=" + this.f484792b + ')';
    }

    public x0(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f484791a = r100;
        this.f484792b = r101;
    }
}
