package hw6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487424b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487423a, r101.f487423a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487424b, r101.f487424b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f487423a.hashCode() * 31) + this.f487424b.hashCode();
    }

    public final String toString() {
        return "CJCallState(cjError=" + this.f487423a + ", cjDuration=" + this.f487424b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cjError");
        Intrinsics.checkNotNullParameter(r101, "cjDuration");
        this.f487423a = r100;
        this.f487424b = r101;
    }
}
