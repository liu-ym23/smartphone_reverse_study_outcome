package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468150b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L10;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f468149a, r101.f468149a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468150b, r101.f468150b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468149a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f468150b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPRequired(promotionId=" + this.f468149a + ", enterFrom=" + this.f468150b + ")";
    }

    public r(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f468149a = r100;
        this.f468150b = r101;
    }
}
