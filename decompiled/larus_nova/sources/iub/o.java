package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495864b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f495863a, r101.f495863a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495864b, r101.f495864b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f495863a.hashCode() * 31) + this.f495864b.hashCode();
    }

    public final String toString() {
        return "MmRecordingMeetingData(recordingId=" + this.f495863a + ", meetingId=" + this.f495864b + ')';
    }

    public o(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        this.f495863a = r100;
        this.f495864b = r101;
    }
}
