package sz4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements qz4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543943b;

    public c() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f543942a, r101.f543942a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543943b, r101.f543943b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f543942a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f543943b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DCRouteEvent(title=" + this.f543942a + ", url=" + this.f543943b + ')';
    }

    public c(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f543942a = r100;
        this.f543943b = null;
    }
}
