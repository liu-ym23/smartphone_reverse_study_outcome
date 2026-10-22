package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f495892c;

    public v() {
        this("", "", 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f495890a, r101.f495890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495891b, r101.f495891b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f495892c, r101.f495892c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f495890a.hashCode() * 31) + this.f495891b.hashCode()) * 31) + Float.floatToIntBits(this.f495892c);
    }

    public final String toString() {
        return "MmRecordingUploadStateData(recordingId=" + this.f495890a + ", minutesToken=" + this.f495891b + ", progress=" + this.f495892c + ')';
    }

    public v(String r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "minutesToken");
        this.f495890a = r100;
        this.f495891b = r101;
        this.f495892c = r102;
    }
}
