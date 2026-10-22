package iw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f496239b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f496238a, r101.f496238a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496239b, r101.f496239b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f496238a.hashCode() * 31;
        Integer r101 = this.f496239b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "LatexLruKey(url=" + this.f496238a + ", order=" + this.f496239b + ')';
    }

    public c(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f496238a = r100;
        this.f496239b = r101;
    }
}
