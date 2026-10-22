package pc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f528460b;

    public final int hashCode() {
        return (this.f528459a.hashCode() * 31) + this.f528460b.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof g) == false) goto L9;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(r101.f528459a, this.f528459a) == false) goto L9;
        if (Intrinsics.areEqual(r101.f528460b, this.f528460b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public g(String r100, b r101) {
        this.f528459a = r100;
        this.f528460b = r101;
    }
}
