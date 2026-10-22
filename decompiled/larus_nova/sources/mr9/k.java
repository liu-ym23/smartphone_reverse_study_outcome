package mr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f515020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f515021b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f515020a, r101.f515020a) == true) goto L12;
        return false;
    L12:
        if (this.f515021b == r101.f515021b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f515020a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f515021b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceUploadProgressResult(process=" + this.f515020a + ", isPending=" + this.f515021b + ')';
    }

    public k(Long r100, boolean r101) {
        this.f515020a = r100;
        this.f515021b = r101;
    }
}
