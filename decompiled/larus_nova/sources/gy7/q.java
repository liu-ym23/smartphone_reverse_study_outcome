package gy7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483350b;

    public final int hashCode() {
        return (this.f483350b.hashCode() * 31) + this.f483349a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f483350b, r101.f483350b) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f483349a, r101.f483349a) == false) goto L13;
        return true;
    }

    public q(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "sessionKey");
        this.f483350b = r100;
        this.f483349a = r101;
    }
}
