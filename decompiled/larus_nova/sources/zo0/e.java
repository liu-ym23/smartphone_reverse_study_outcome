package zo0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f573089b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f573088a, r101.f573088a) == true) goto L8;
        return false;
    L8:
        if (this.f573089b == r101.f573089b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f573088a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f573089b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "TimePoint(event=" + this.f573088a + ", timestamp=" + this.f573089b + ")";
    }

    public e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f573088a = r100;
        this.f573089b = r101;
    }
}
