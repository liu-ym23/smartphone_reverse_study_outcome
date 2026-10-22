package f4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475440b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f475439a, r101.f475439a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475440b, r101.f475440b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f475439a.hashCode() * 31;
        String r101 = this.f475440b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AuthorizationState(legacyStatus=" + this.f475439a + ", detail=" + this.f475440b + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "legacyStatus");
        this.f475439a = r100;
        this.f475440b = r101;
    }
}
