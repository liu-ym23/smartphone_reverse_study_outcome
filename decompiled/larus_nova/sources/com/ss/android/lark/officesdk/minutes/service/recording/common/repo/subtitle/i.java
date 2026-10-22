package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmParticipantType f435241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSubtitleSpeakerType f435242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f435243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f435244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f435245g;

    public static final class a {
    }

    static {
    }

    public i() {
        this(null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f435239a, r101.f435239a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435240b, r101.f435240b) == true) goto L15;
        return false;
    L15:
        if (this.f435241c == r101.f435241c) goto L18;
        return false;
    L18:
        if (this.f435242d == r101.f435242d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435243e, r101.f435243e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435244f, r101.f435244f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f435245g, r101.f435245g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f435239a.hashCode() * 31) + this.f435240b.hashCode()) * 31) + this.f435241c.hashCode()) * 31) + this.f435242d.hashCode()) * 31) + this.f435243e.hashCode()) * 31) + this.f435244f.hashCode()) * 31) + this.f435245g.hashCode();
    }

    public final String toString() {
        return "MmSubtitleSpeaker(userId='" + this.f435239a + "', speakerType=" + this.f435242d + ')';
    }

    public /* synthetic */ i(String r110, String r111, MmParticipantType r112, MmSubtitleSpeakerType r113, String r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r115 & 4) == 0) goto L13;
        MmParticipantType r102 = MmParticipantType.UNKNOWN;
    L15:
        if ((r115 & 8) == 0) goto L17;
        MmSubtitleSpeakerType r103 = MmSubtitleSpeakerType.UNKNOWN;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r104 = "unknown";
    L23:
        if ((r115 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r115 & 64) == 0) goto L29;
        String r106 = "";
    L30:
        this(r100, r101, r102, r103, r104, r105, r106);
        return;
    L29:
        r106 = null;
        goto L30
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static i a(i r110, MmParticipantType r111, MmSubtitleSpeakerType r112, String r113, String r114, int r115) {
        String r100 = null;
        if ((r115 & 1) == 0) goto L5;
        String r101 = r110.f435239a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r102 = r110.f435240b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        r111 = r110.f435241c;
    L13:
        MmParticipantType r103 = r111;
        if ((r115 & 8) == 0) goto L16;
        r112 = r110.f435242d;
    L16:
        MmSubtitleSpeakerType r104 = r112;
        if ((r115 & 16) == 0) goto L19;
        r100 = r110.f435243e;
    L19:
        String r105 = r100;
        if ((r115 & 32) == 0) goto L22;
        r113 = r110.f435244f;
    L22:
        String r106 = r113;
        if ((r115 & 64) == 0) goto L25;
        r114 = r110.f435245g;
    L25:
        String r107 = r114;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "deviceId");
        Intrinsics.checkNotNullParameter(r103, "participantType");
        Intrinsics.checkNotNullParameter(r104, "speakerType");
        Intrinsics.checkNotNullParameter(r105, "identifyMethod");
        Intrinsics.checkNotNullParameter(r106, "name");
        Intrinsics.checkNotNullParameter(r107, "avatarKey");
        return new i(r101, r102, r103, r104, r105, r106, r107);
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public i(String r100, String r101, MmParticipantType r102, MmSubtitleSpeakerType r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "participantType");
        Intrinsics.checkNotNullParameter(r103, "speakerType");
        Intrinsics.checkNotNullParameter(r104, "identifyMethod");
        Intrinsics.checkNotNullParameter(r105, "name");
        Intrinsics.checkNotNullParameter(r106, "avatarKey");
        this.f435239a = r100;
        this.f435240b = r101;
        this.f435241c = r102;
        this.f435242d = r103;
        this.f435243e = r104;
        this.f435244f = r105;
        this.f435245g = r106;
    }
}
