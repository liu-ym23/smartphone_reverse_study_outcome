package rw0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f539558b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f539557a, r101.f539557a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f539558b, r101.f539558b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f539557a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f539558b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RechargeFastPayLog(isFastPay=" + this.f539557a + ", fastPayOpt=" + this.f539558b + ")";
    }

    public c() {
        this("", "");
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "isFastPay");
        Intrinsics.checkNotNullParameter(r101, "fastPayOpt");
        this.f539557a = r100;
        this.f539558b = r101;
    }
}
