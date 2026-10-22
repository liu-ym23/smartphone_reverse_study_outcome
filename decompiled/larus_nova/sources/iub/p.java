package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495867c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f495865a, r101.f495865a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495866b, r101.f495866b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495867c, r101.f495867c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f495865a.hashCode() * 31) + this.f495866b.hashCode()) * 31) + this.f495867c.hashCode();
    }

    public final String toString() {
        return "MmRecordingMinutesTokenData(recordingId=" + this.f495865a + ", meetingId=" + this.f495866b + ", minutesToken=" + this.f495867c + ')';
    }

    public p() {
        this("", "", "");
    }

    public p(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "minutesToken");
        this.f495865a = r100;
        this.f495866b = r101;
        this.f495867c = r102;
    }
}
