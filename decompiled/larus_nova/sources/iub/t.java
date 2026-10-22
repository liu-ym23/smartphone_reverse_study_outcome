package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f495885b;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f495884a, r101.f495884a) == true) goto L12;
        return false;
    L12:
        if (this.f495885b == r101.f495885b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495884a.hashCode() * 31;
        long r101 = this.f495885b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "MmRecordingTimeData(recordingId=" + this.f495884a + ", recordingDurationInSecs=" + this.f495885b + ')';
    }

    public /* synthetic */ t(int r100) {
        this("", 0);
    }

    public t(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        this.f495884a = r100;
        this.f495885b = r101;
    }
}
