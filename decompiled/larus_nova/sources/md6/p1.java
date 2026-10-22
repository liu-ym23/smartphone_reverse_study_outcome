package md6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f513417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f513418c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f513416a, r101.f513416a) == true) goto L12;
        return false;
    L12:
        if (this.f513417b == r101.f513417b) goto L15;
        return false;
    L15:
        if (this.f513418c == r101.f513418c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f513416a.hashCode() * 31;
        long r101 = this.f513417b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f513418c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "TraceEventData(traceName=" + this.f513416a + ", startTime=" + this.f513417b + ", durationNs=" + this.f513418c + ')';
    }

    public p1(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "traceName");
        this.f513416a = r100;
        this.f513417b = r101;
        this.f513418c = r102;
    }
}
