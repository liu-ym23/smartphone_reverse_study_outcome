package eba;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jba.b f471971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471972b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f471971a, r101.f471971a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471972b, r101.f471972b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f471971a.hashCode() * 31) + this.f471972b.hashCode();
    }

    public final String toString() {
        return "ResolvedHorizontalCutoutInsets(insets=" + this.f471971a + ", source=" + this.f471972b + ')';
    }

    public o(jba.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f471971a = r100;
        this.f471972b = r101;
    }
}
