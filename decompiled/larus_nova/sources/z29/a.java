package z29;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569802b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f569801a, r101.f569801a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569802b, r101.f569802b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f569801a.hashCode() * 31) + this.f569802b.hashCode();
    }

    public final String toString() {
        return "MembershipQuotaAbsoluteUsage(usedAmount=" + this.f569801a + ", totalAmount=" + this.f569802b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "usedAmount");
        Intrinsics.checkNotNullParameter(r101, "totalAmount");
        this.f569801a = r100;
        this.f569802b = r101;
    }
}
