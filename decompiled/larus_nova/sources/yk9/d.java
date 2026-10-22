package yk9;

import com.larus.minutes.api.MinutesOfflineRecordingDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f568279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f568280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f568281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MinutesOfflineRecordingDeviceType f568282e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f568278a, r101.f568278a) == true) goto L12;
        return false;
    L12:
        if (this.f568279b == r101.f568279b) goto L15;
        return false;
    L15:
        if (this.f568280c == r101.f568280c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f568281d, r101.f568281d) == true) goto L21;
        return false;
    L21:
        if (this.f568282e == r101.f568282e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f568278a.hashCode() * 31;
        long r101 = this.f568279b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f568280c == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        Float r105 = this.f568281d;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        MinutesOfflineRecordingDeviceType r109 = this.f568282e;
        if (r109 == null) goto L15;
        r106 = r109.hashCode();
    L15:
        return r108 + r106;
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "MinutesOfflineRecordingItem(recordingId=" + this.f568278a + ", startTimeMs=" + this.f568279b + ", isRecording=" + this.f568280c + ", uploadProgress=" + this.f568281d + ", deviceType=" + this.f568282e + ')';
    }

    public d(String r100, long r101, boolean r102, Float r103, MinutesOfflineRecordingDeviceType r104) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        this.f568278a = r100;
        this.f568279b = r101;
        this.f568280c = r102;
        this.f568281d = r103;
        this.f568282e = r104;
    }
}
