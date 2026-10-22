package dj0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f468873b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f468872a, r101.f468872a) == true) goto L8;
        return false;
    L8:
        if (this.f468873b == r101.f468873b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468872a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f468873b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PaidLinkMicAddPriceState(addPriceUserId=" + this.f468872a + ", addPriceCount=" + this.f468873b + ")";
    }

    public a() {
        this("", 0);
    }

    public a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "addPriceUserId");
        this.f468872a = r100;
        this.f468873b = r101;
    }
}
