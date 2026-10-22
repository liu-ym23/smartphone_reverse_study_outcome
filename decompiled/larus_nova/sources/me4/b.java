package me4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513478b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f513477a, r101.f513477a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513478b, r101.f513478b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f513477a.hashCode() * 31) + this.f513478b.hashCode();
    }

    public final String toString() {
        return "CertSignResult(encData=" + this.f513477a + ", q1Id=" + this.f513478b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "encData");
        Intrinsics.checkNotNullParameter(r101, "q1Id");
        this.f513477a = r100;
        this.f513478b = r101;
    }
}
