package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f468108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468110c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (this.f468108a == r101.f468108a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468109b, r101.f468109b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468110c, r101.f468110c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f468108a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f468109b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f468110c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "IMOptional(promotionSource=" + this.f468108a + ", sourcePage=" + this.f468109b + ", enterMethod=" + this.f468110c + ")";
    }

    public l() {
        this(0, null, null);
    }

    public l(long r100, String r101, String r102) {
        this.f468108a = r100;
        this.f468109b = r101;
        this.f468110c = r102;
    }
}
