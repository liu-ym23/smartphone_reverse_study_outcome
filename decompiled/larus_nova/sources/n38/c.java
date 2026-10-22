package n38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516994b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f516993a, r101.f516993a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516994b, r101.f516994b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f516993a.hashCode() * 31) + this.f516994b.hashCode();
    }

    public final String toString() {
        return "AccountUser(userId=" + this.f516993a + ", secUserId=" + this.f516994b + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "secUserId");
        this.f516993a = r100;
        this.f516994b = r101;
    }
}
