package uw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f551946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551947b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f551946a == r101.f551946a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f551947b, r101.f551947b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f551946a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f551947b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ErrorEventInfo(isClient=" + this.f551946a + ", tracerErrorMsg=" + this.f551947b + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tracerErrorMsg");
        this.f551946a = true;
        this.f551947b = r100;
    }
}
