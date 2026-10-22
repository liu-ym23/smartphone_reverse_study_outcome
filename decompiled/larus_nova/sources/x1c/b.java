package x1c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f562156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f562157d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f562154a, r101.f562154a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562155b, r101.f562155b) == true) goto L15;
        return false;
    L15:
        if (this.f562156c == r101.f562156c) goto L18;
        return false;
    L18:
        if (this.f562157d == r101.f562157d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f562154a.hashCode() * 31) + this.f562155b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f562156c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f562157d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoubaoUserInfo(userId=" + this.f562154a + ", userName=" + this.f562155b + ", isEnterPriseUser=" + this.f562156c + ", isUserInValid=" + this.f562157d + ')';
    }

    public b(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        this.f562154a = r100;
        this.f562155b = r101;
        this.f562156c = r102;
        this.f562157d = r103;
    }
}
