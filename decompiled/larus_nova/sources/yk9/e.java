package yk9;

import com.larus.minutes.api.MinutesOfflineRecordingUploadStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f568284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MinutesOfflineRecordingUploadStatus f568285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f568286d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f568283a, r101.f568283a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f568284b, r101.f568284b) == 0) goto L15;
        return false;
    L15:
        if (this.f568285c == r101.f568285c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f568286d, r101.f568286d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f568283a.hashCode() * 31) + Float.floatToIntBits(this.f568284b)) * 31) + this.f568285c.hashCode()) * 31;
        String r101 = this.f568286d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MinutesOfflineRecordingUploadState(recordingId=" + this.f568283a + ", progress=" + this.f568284b + ", status=" + this.f568285c + ", errorMessage=" + this.f568286d + ')';
    }

    public e(String r100, float r101, MinutesOfflineRecordingUploadStatus r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r102, "status");
        this.f568283a = r100;
        this.f568284b = r101;
        this.f568285c = r102;
        this.f568286d = r103;
    }
}
