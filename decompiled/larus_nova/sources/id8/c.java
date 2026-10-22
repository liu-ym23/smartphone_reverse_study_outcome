package id8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f489365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f489366b;

    public c() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f489365a, r101.f489365a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489366b, r101.f489366b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        g r100 = this.f489365a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a r104 = this.f489366b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImmutableUplinkEntityContent(uplinkFileInfo=" + this.f489365a + ", uplinkImageInfo=" + this.f489366b + ')';
    }

    public c(g r100, a r101) {
        this.f489365a = r100;
        this.f489366b = r101;
    }
}
