package oz8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f527236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527237b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f527236a, r101.f527236a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527237b, r101.f527237b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f527236a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f527237b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AtomCreditInfo(totalCreditNum=" + this.f527236a + ", iconUrl=" + this.f527237b + ')';
    }

    public a(Long r100, String r101) {
        this.f527236a = r100;
        this.f527237b = r101;
    }
}
