package ko0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f504367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f504368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f504369c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f504367a, r101.f504367a) == true) goto L8;
        return false;
    L8:
        if (this.f504368b == r101.f504368b) goto L10;
        return false;
    L10:
        if (this.f504369c == r101.f504369c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f504367a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f504368b;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f504369c;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformPopupInfo(text=" + this.f504367a + ", durationMillis=" + this.f504368b + ", priorityLevel=" + this.f504369c + ")";
    }

    public f(String r100, long r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 5000;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 1;
    L8:
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f504367a = r100;
        this.f504368b = r101;
        this.f504369c = r102;
    }
}
