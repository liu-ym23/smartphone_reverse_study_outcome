package nv6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f520903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520905c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (this.f520903a == r101.f520903a) goto L12;
        return false;
    L12:
        if (this.f520904b == r101.f520904b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520905c, r101.f520905c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f520903a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f520904b) * 31) + this.f520905c.hashCode();
    }

    public final String toString() {
        return "SearchFinishEvent(requestDuration=" + this.f520903a + ", isSuccess=" + this.f520904b + ", logId=" + this.f520905c + ')';
    }

    public l0(long r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "logId");
        this.f520903a = r100;
        this.f520904b = r101;
        this.f520905c = r102;
    }
}
