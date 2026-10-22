package o4c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f522023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522024b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f522023a == r101.f522023a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522024b, r101.f522024b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f522023a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f522024b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "VerifySecLinkResult(isSafe=" + this.f522023a + ", targetLink=" + this.f522024b + ')';
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetLink");
        this.f522023a = true;
        this.f522024b = r100;
    }
}
