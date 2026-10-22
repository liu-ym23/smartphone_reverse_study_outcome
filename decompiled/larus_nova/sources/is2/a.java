package is2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f495586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f495587b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f495586a, r101.f495586a) == true) goto L8;
        return false;
    L8:
        if (this.f495587b == r101.f495587b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f495586a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f495587b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "BackendExtraData(roomControllerKey=" + this.f495586a + ", roomId=" + this.f495587b + ")";
    }

    public a(Integer r100, long r101) {
        this.f495586a = r100;
        this.f495587b = r101;
    }
}
