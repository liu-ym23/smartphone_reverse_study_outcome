package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f435202g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmParticipantType f435205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSubtitleSpeakerType f435206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f435207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f435208f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f435203a, r101.f435203a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435204b, r101.f435204b) == true) goto L15;
        return false;
    L15:
        if (this.f435205c == r101.f435205c) goto L18;
        return false;
    L18:
        if (this.f435206d == r101.f435206d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435207e, r101.f435207e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435208f, r101.f435208f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f435203a.hashCode() * 31) + this.f435204b.hashCode()) * 31) + this.f435205c.hashCode()) * 31) + this.f435206d.hashCode()) * 31) + this.f435207e.hashCode()) * 31) + this.f435208f.hashCode();
    }

    public c() {
        this("", "", MmParticipantType.UNKNOWN, MmSubtitleSpeakerType.UNKNOWN, "", b.c.f435199a);
    }

    public final String toString() {
        return "MmDisplaySpeaker(userId='" + this.f435203a + "', speakerType=" + this.f435206d + ", name='" + this.f435207e + "', avatar=" + this.f435208f + ')';
    }

    public final String a(Function1<? super String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "numberFormatter");
        String r101 = this.f435207e;
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L16;
        Long r103 = StringsKt.toLongOrNull(this.f435203a);
        if (r103 == null) goto L13;
        long r104 = r103.longValue();
        if (r104 <= 0) goto L13;
        String r105 = String.valueOf(r104);
    L15:
        return r100.invoke(r105);
    L13:
        r105 = "1";
        goto L15
    L16:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public final c b(i r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        b r100 = this.f435208f;
        boolean r101 = false;
        if ((r100 instanceof b.d) == false) goto L5;
    L20:
        b r111 = r100;
        String r102 = this.f435207e;
        if (r102.length() != 0) goto L23;
        r101 = true;
    L23:
        if (r101 == false) goto L25;
        String r103 = r110.f435244f;
    L26:
        String r104 = this.f435203a;
        String r105 = this.f435204b;
        MmParticipantType r106 = this.f435205c;
        MmSubtitleSpeakerType r107 = this.f435206d;
        Intrinsics.checkNotNullParameter(r104, "userId");
        Intrinsics.checkNotNullParameter(r105, "deviceId");
        Intrinsics.checkNotNullParameter(r106, "participantType");
        Intrinsics.checkNotNullParameter(r107, "speakerType");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r111, "avatar");
        return new c(r104, r105, r106, r107, r103, r111);
    L25:
        r103 = r102;
        goto L26
    L5:
        if ((r100 instanceof b.C5190b) == true) goto L20;
        if (r110.f435245g.length() <= 0) goto L10;
        boolean r108 = true;
    L11:
        if (r108 == false) goto L14;
        r100 = new b.C5190b(r110.f435245g, r110.f435239a);
        goto L20
    L14:
        if (this.f435203a.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L19;
        r100 = new b.e(this.f435203a);
        goto L20
    L19:
        r100 = b.c.f435199a;
        goto L20
    L16:
        r109 = false;
        goto L17
    L10:
        r108 = false;
        goto L11
    }

    public c(String r100, String r101, MmParticipantType r102, MmSubtitleSpeakerType r103, String r104, b r105) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "participantType");
        Intrinsics.checkNotNullParameter(r103, "speakerType");
        Intrinsics.checkNotNullParameter(r104, "name");
        Intrinsics.checkNotNullParameter(r105, "avatar");
        this.f435203a = r100;
        this.f435204b = r101;
        this.f435205c = r102;
        this.f435206d = r103;
        this.f435207e = r104;
        this.f435208f = r105;
    }
}
