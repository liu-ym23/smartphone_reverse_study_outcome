package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495889d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f495886a, r101.f495886a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495887b, r101.f495887b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495888c, r101.f495888c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495889d, r101.f495889d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f495886a.hashCode() * 31) + this.f495887b.hashCode()) * 31) + this.f495888c.hashCode()) * 31) + this.f495889d.hashCode();
    }

    public final String toString() {
        return "MmRecordingTitleData(recordingId=" + this.f495886a + ", meetingId=" + this.f495887b + ", minutesToken=" + this.f495888c + ", title=" + this.f495889d + ')';
    }

    public u() {
        this("", "", "", "");
    }

    public u(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "minutesToken");
        Intrinsics.checkNotNullParameter(r103, "title");
        this.f495886a = r100;
        this.f495887b = r101;
        this.f495888c = r102;
        this.f495889d = r103;
    }
}
