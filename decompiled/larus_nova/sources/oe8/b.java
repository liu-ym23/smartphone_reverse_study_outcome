package oe8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523020b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f523019a, r101.f523019a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523020b, r101.f523020b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f523019a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f523020b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "CodeParserModel(language=" + this.f523019a + ", content=" + this.f523020b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f523019a = r100;
        this.f523020b = r101;
    }
}
