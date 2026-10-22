package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f434944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingUILaunchMode f434945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmEndWindowMetaInfo f434946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmEndWindowAISummary f434947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<MmEndWindowAvatar> f434948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b f434949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmEndWindowHitPointContext f434950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f434951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmEndWindowSubtitle f434952j;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f434943a, r101.f434943a) == true) goto L12;
        return false;
    L12:
        if (this.f434944b == r101.f434944b) goto L15;
        return false;
    L15:
        if (this.f434945c == r101.f434945c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434946d, r101.f434946d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f434947e, r101.f434947e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f434948f, r101.f434948f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f434949g, r101.f434949g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f434950h, r101.f434950h) == true) goto L33;
        return false;
    L33:
        if (this.f434951i == r101.f434951i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f434952j, r101.f434952j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f434943a.hashCode() * 31;
        int r101 = 1231;
        if (this.f434944b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((((((r100 + r102) * 31) + this.f434945c.hashCode()) * 31) + this.f434946d.hashCode()) * 31) + this.f434947e.hashCode()) * 31) + this.f434948f.hashCode()) * 31) + this.f434949g.hashCode()) * 31) + this.f434950h.hashCode()) * 31;
        if (this.f434951i == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f434952j.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingEndWindowEntity(sessionId=" + this.f434943a + ", useRecordingApi=" + this.f434944b + ", uiLaunchMode=" + this.f434945c + ", metaInfo=" + this.f434946d + ", aiSummary=" + this.f434947e + ", avatarList=" + this.f434948f + ", speakerSnapshot=" + this.f434949g + ", mmHitPointContext=" + this.f434950h + ", isFromHardware=" + this.f434951i + ", subtitle=" + this.f434952j + ')';
    }

    public /* synthetic */ c(int r310) {
        this("", false, MmRecordingUILaunchMode.UNKNOWN, new MmEndWindowMetaInfo(null, 0, 0, false, 0, null, 0, null, null, null, null, null, null, null, null, 0, 65535, null), new MmEndWindowAISummary(false, null, null, 7, null), new ArrayList(), new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b(0), new MmEndWindowHitPointContext(null, 1, null), false, new MmEndWindowSubtitle(false, null, null, 7, null));
    }

    public static c a(c r110, String r111, MmEndWindowMetaInfo r112, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r111 = r110.f434943a;
    L5:
        String r100 = r111;
        if ((r114 & 2) == 0) goto L8;
        boolean r101 = r110.f434944b;
    L10:
        if ((r114 & 4) == 0) goto L12;
        MmRecordingUILaunchMode r115 = r110.f434945c;
    L14:
        if ((r114 & 8) == 0) goto L16;
        r112 = r110.f434946d;
    L16:
        MmEndWindowMetaInfo r102 = r112;
        if ((r114 & 16) == 0) goto L19;
        MmEndWindowAISummary r103 = r110.f434947e;
    L21:
        if ((r114 & 32) == 0) goto L23;
        ArrayList<MmEndWindowAvatar> r104 = r110.f434948f;
    L25:
        if ((r114 & 64) == 0) goto L27;
        r113 = r110.f434949g;
    L27:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r105 = r113;
        if ((r114 & 128) == 0) goto L30;
        MmEndWindowHitPointContext r106 = r110.f434950h;
    L32:
        if ((r114 & 256) == 0) goto L34;
        boolean r107 = r110.f434951i;
    L36:
        if ((r114 & 512) == 0) goto L38;
        MmEndWindowSubtitle r116 = r110.f434952j;
    L39:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r115, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r102, "metaInfo");
        Intrinsics.checkNotNullParameter(r103, "aiSummary");
        Intrinsics.checkNotNullParameter(r104, "avatarList");
        Intrinsics.checkNotNullParameter(r105, "speakerSnapshot");
        Intrinsics.checkNotNullParameter(r106, "mmHitPointContext");
        Intrinsics.checkNotNullParameter(r116, "subtitle");
        return new c(r100, r101, r115, r102, r103, r104, r105, r106, r107, r116);
    L38:
        r116 = null;
        goto L39
    L34:
        r107 = false;
        goto L36
    L30:
        r106 = null;
        goto L32
    L23:
        r104 = null;
        goto L25
    L19:
        r103 = null;
        goto L21
    L12:
        r115 = null;
        goto L14
    L8:
        r101 = false;
        goto L10
    }

    public c(String r100, boolean r101, MmRecordingUILaunchMode r102, MmEndWindowMetaInfo r103, MmEndWindowAISummary r104, ArrayList<MmEndWindowAvatar> r105, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r106, MmEndWindowHitPointContext r107, boolean r110, MmEndWindowSubtitle r111) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r103, "metaInfo");
        Intrinsics.checkNotNullParameter(r104, "aiSummary");
        Intrinsics.checkNotNullParameter(r105, "avatarList");
        Intrinsics.checkNotNullParameter(r106, "speakerSnapshot");
        Intrinsics.checkNotNullParameter(r107, "mmHitPointContext");
        Intrinsics.checkNotNullParameter(r111, "subtitle");
        this.f434943a = r100;
        this.f434944b = r101;
        this.f434945c = r102;
        this.f434946d = r103;
        this.f434947e = r104;
        this.f434948f = r105;
        this.f434949g = r106;
        this.f434950h = r107;
        this.f434951i = r110;
        this.f434952j = r111;
    }
}
