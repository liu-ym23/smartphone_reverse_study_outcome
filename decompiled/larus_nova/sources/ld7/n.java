package ld7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508758a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f508758a, ((n) r100).f508758a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f508758a.hashCode();
    }

    public final String toString() {
        return "PublicKey(rsa=" + this.f508758a + ')';
    }

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rsa");
        this.f508758a = r100;
    }
}
