package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495844b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f495843a, r101.f495843a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495844b, r101.f495844b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f495843a.hashCode() * 31) + this.f495844b.hashCode();
    }

    public final String toString() {
        return "MmRecordingAudioPathData(recordingId=" + this.f495843a + ", audioFilePath=" + this.f495844b + ')';
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "audioFilePath");
        this.f495843a = r100;
        this.f495844b = r101;
    }
}
