package k31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f501634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f501635b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f501634a, r101.f501634a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f501635b, r101.f501635b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        g r100 = this.f501634a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        n r104 = this.f501635b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentsOption(pkProgressBarOption=" + this.f501634a + ", topReserveOption=" + this.f501635b + ")";
    }

    public a(g r100, n r101) {
        this.f501634a = r100;
        this.f501635b = r101;
    }
}
