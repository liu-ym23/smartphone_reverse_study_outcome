package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.dtf.face.config.IConstValues;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityStartMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HardwareRecordingDeviceType f435555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f435556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HardwareRecordingSessionState f435557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f435558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecordingPriorityStartMode f435559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HardwareRecordingInterruptionReason f435560h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f435553a, r101.f435553a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435554b, r101.f435554b) == true) goto L15;
        return false;
    L15:
        if (this.f435555c == r101.f435555c) goto L18;
        return false;
    L18:
        if (this.f435556d == r101.f435556d) goto L21;
        return false;
    L21:
        if (this.f435557e == r101.f435557e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435558f, r101.f435558f) == true) goto L27;
        return false;
    L27:
        if (this.f435559g == r101.f435559g) goto L30;
        return false;
    L30:
        if (this.f435560h == r101.f435560h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f435553a.hashCode() * 31) + this.f435554b.hashCode()) * 31) + this.f435555c.hashCode()) * 31;
        long r101 = this.f435556d;
        int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f435557e.hashCode()) * 31) + this.f435558f.hashCode()) * 31) + this.f435559g.hashCode()) * 31;
        HardwareRecordingInterruptionReason r103 = this.f435560h;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "HardwareRecordingSession(sceneInstanceId=" + this.f435553a + ", hardwareDeviceId=" + this.f435554b + ", deviceType=" + this.f435555c + ", startTimestampSeconds=" + this.f435556d + ", state=" + this.f435557e + ", recordingId=" + this.f435558f + ", startMode=" + this.f435559g + ", interruptionReason=" + this.f435560h + ')';
    }

    public static e a(e r110, HardwareRecordingSessionState r111, String r112, int r113) {
        HardwareRecordingInterruptionReason r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f435553a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f435554b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        HardwareRecordingDeviceType r103 = r110.f435555c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        long r104 = r110.f435556d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        r111 = r110.f435557e;
    L21:
        HardwareRecordingSessionState r105 = r111;
        if ((r113 & 32) == 0) goto L24;
        r112 = r110.f435558f;
    L24:
        String r106 = r112;
        if ((r113 & 64) == 0) goto L27;
        RecordingPriorityStartMode r114 = r110.f435559g;
    L29:
        if ((r113 & 128) == 0) goto L31;
        r100 = r110.f435560h;
    L31:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "sceneInstanceId");
        Intrinsics.checkNotNullParameter(r102, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r103, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r105, "state");
        Intrinsics.checkNotNullParameter(r106, "recordingId");
        Intrinsics.checkNotNullParameter(r114, "startMode");
        return new e(r101, r102, r103, r104, r105, r106, r114, r100);
    L27:
        r114 = null;
        goto L29
    L17:
        r104 = 0;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public e(String r100, String r101, HardwareRecordingDeviceType r102, long r103, HardwareRecordingSessionState r104, String r105, RecordingPriorityStartMode r106, HardwareRecordingInterruptionReason r110) {
        Intrinsics.checkNotNullParameter(r100, "sceneInstanceId");
        Intrinsics.checkNotNullParameter(r101, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r102, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r104, "state");
        Intrinsics.checkNotNullParameter(r105, "recordingId");
        Intrinsics.checkNotNullParameter(r106, "startMode");
        this.f435553a = r100;
        this.f435554b = r101;
        this.f435555c = r102;
        this.f435556d = r103;
        this.f435557e = r104;
        this.f435558f = r105;
        this.f435559g = r106;
        this.f435560h = r110;
    }
}
