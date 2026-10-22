package p68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527929b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f527928a, r101.f527928a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527929b, r101.f527929b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f527928a.hashCode() * 31) + this.f527929b.hashCode();
    }

    public final String toString() {
        return "DownloadBean(url=" + this.f527928a + ", speakerStyleId=" + this.f527929b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "speakerStyleId");
        this.f527928a = r100;
        this.f527929b = r101;
    }
}
