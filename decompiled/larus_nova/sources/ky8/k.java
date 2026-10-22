package ky8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f506722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f506723b;

    public k() {
        boolean r100 = false;
        this(r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f506722a == r101.f506722a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506723b, r101.f506723b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f506722a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        j r102 = this.f506723b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OriginalImageItem(isUploading=" + this.f506722a + ", image=" + this.f506723b + ')';
    }

    public /* synthetic */ k(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100, null);
    }

    public k(boolean r100, j r101) {
        this.f506722a = r100;
        this.f506723b = r101;
    }
}
