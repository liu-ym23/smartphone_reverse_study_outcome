package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f468187b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f468186a, r101.f468186a) == true) goto L8;
        return false;
    L8:
        if (this.f468187b == r101.f468187b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468186a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f468187b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "SKURequired(promotionId=" + this.f468186a + ", actionType=" + this.f468187b + ")";
    }

    public v(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        this.f468186a = r100;
        this.f468187b = r101;
    }
}
