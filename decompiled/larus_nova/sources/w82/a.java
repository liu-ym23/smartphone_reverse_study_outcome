package w82;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f558619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f558620b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f558619a, r101.f558619a) == true) goto L8;
        return false;
    L8:
        if (this.f558620b == r101.f558620b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f558619a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f558620b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "LogParams(requestId=" + this.f558619a + ", inviteeId=" + this.f558620b + ")";
    }

    public a(int r100) {
        this.f558619a = null;
        this.f558620b = 0;
    }
}
