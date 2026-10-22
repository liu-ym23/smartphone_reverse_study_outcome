package z68;

import da9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f570540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f570541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f570542c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f570540a == r101.f570540a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570541b, r101.f570541b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570542c, r101.f570542c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f570540a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f570541b.hashCode()) * 31) + this.f570542c.hashCode();
    }

    public final String toString() {
        return "PendingScreenShareStart(startElapsedMs=" + this.f570540a + ", startSource=" + this.f570541b + ", policy=" + this.f570542c + ')';
    }

    public b(long r100, String r101, e r102) {
        Intrinsics.checkNotNullParameter(r101, "startSource");
        Intrinsics.checkNotNullParameter(r102, "policy");
        this.f570540a = r100;
        this.f570541b = r101;
        this.f570542c = r102;
    }
}
