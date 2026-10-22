package efa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472595b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f472594a, r101.f472594a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472595b, r101.f472595b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f472594a.hashCode() * 31;
        String r101 = this.f472595b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ObricActionSpec(action=" + this.f472594a + ", data=" + this.f472595b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f472594a = r100;
        this.f472595b = r101;
    }
}
