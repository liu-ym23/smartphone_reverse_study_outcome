package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.dtf.face.config.IConstValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nvb.a f435563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HardwareRecordingDeviceType f435564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f435566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HardwarePlaybackState f435567e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f435563a, r101.f435563a) == true) goto L12;
        return false;
    L12:
        if (this.f435564b == r101.f435564b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435565c, r101.f435565c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435566d, r101.f435566d) == true) goto L21;
        return false;
    L21:
        if (this.f435567e == r101.f435567e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        nvb.a r100 = this.f435563a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f435564b.hashCode()) * 31;
        String r104 = this.f435565c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f435566d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f435567e.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HardwareRecordingStartRequest(hardwareDeviceId=" + this.f435563a + ", deviceType=" + this.f435564b + ", sceneInstanceId=" + this.f435565c + ", timestampSeconds=" + this.f435566d + ", initialPlaybackState=" + this.f435567e + ')';
    }

    public g() {
        HardwareRecordingDeviceType r100 = HardwareRecordingDeviceType.UNKNOWN;
        HardwarePlaybackState r101 = HardwarePlaybackState.OTHER;
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r101, "initialPlaybackState");
        this.f435563a = null;
        this.f435564b = r100;
        this.f435565c = null;
        this.f435566d = null;
        this.f435567e = r101;
    }
}
