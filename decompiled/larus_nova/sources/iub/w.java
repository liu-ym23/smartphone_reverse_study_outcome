package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f495894b;

    public w() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f495893a, r101.f495893a) == true) goto L12;
        return false;
    L12:
        if (this.f495894b == r101.f495894b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f495893a.hashCode() * 31) + this.f495894b;
    }

    public final String toString() {
        return "MmRecordingVolumeData(recordingId=" + this.f495893a + ", recordingVolume=" + this.f495894b + ')';
    }

    public /* synthetic */ w(int r100) {
        this("", 0);
    }

    public w(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        this.f495893a = r100;
        this.f495894b = r101;
    }
}
