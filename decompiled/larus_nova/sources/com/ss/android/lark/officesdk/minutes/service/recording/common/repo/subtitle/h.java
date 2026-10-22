package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f435222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f435224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f435225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f435226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f435227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f435228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c f435229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f435230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f435231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f435232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f435233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f435234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f435235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f435236o;

    public h() {
        this(0, false, 0, 0, null, null, null, null, null, false, false, false, false, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f435222a == r101.f435222a) goto L12;
        return false;
    L12:
        if (this.f435223b == r101.f435223b) goto L15;
        return false;
    L15:
        if (this.f435224c == r101.f435224c) goto L18;
        return false;
    L18:
        if (this.f435225d == r101.f435225d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435226e, r101.f435226e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435227f, r101.f435227f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f435228g, r101.f435228g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f435229h, r101.f435229h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f435230i, r101.f435230i) == true) goto L36;
        return false;
    L36:
        if (this.f435231j == r101.f435231j) goto L39;
        return false;
    L39:
        if (this.f435232k == r101.f435232k) goto L42;
        return false;
    L42:
        if (this.f435233l == r101.f435233l) goto L45;
        return false;
    L45:
        if (this.f435234m == r101.f435234m) goto L48;
        return false;
    L48:
        if (this.f435235n == r101.f435235n) goto L51;
        return false;
    L51:
        if (this.f435236o == r101.f435236o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f435222a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f435223b == false) goto L5;
        int r103 = 1231;
    L6:
        long r104 = this.f435224c;
        int r105 = (((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f435225d;
        int r107 = (((((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f435226e.hashCode()) * 31) + this.f435227f.hashCode()) * 31) + this.f435228g.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r108 = this.f435229h;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (((r107 + r109) * 31) + this.f435230i.hashCode()) * 31;
        if (this.f435231j == false) goto L13;
        int r111 = 1231;
    L14:
        int r112 = (r110 + r111) * 31;
        if (this.f435232k == false) goto L17;
        int r113 = 1231;
    L18:
        int r114 = (r112 + r113) * 31;
        if (this.f435233l == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r114 + r115) * 31;
        if (this.f435234m == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f435235n == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f435236o == true) goto L35;
        r102 = 1237;
    L35:
        return r120 + r102;
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = 1237;
        goto L22
    L17:
        r113 = 1237;
        goto L18
    L13:
        r111 = 1237;
        goto L14
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmSubtitleItem(segId=" + this.f435222a + ", isFinal=" + this.f435223b + ", relativeTimeMs=" + this.f435224c + ", absoluteTimeMs=" + this.f435225d + ", sourceContent=" + this.f435226e + ", targetContent=" + this.f435227f + ", speaker=" + this.f435228g + ", markedSpeaker=" + this.f435229h + ", clusterId=" + this.f435230i + ", canEditSpeaker=" + this.f435231j + ", isSpeakerMarkingEnabled=" + this.f435232k + ", needMerge=" + this.f435233l + ", showBilingual=" + this.f435234m + ", isDuplicate=" + this.f435235n + ", hasCheckDuplicate=" + this.f435236o + ')';
    }

    public final c b() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r100 = this.f435229h;
        boolean r101 = false;
        if (r100 == null) goto L65;
        i r102 = this.f435228g;
        Intrinsics.checkNotNullParameter(r102, "original");
        String r103 = r100.f435069a;
        if (r103.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r103 = r102.f435239a;
    L10:
        String r105 = r103;
        boolean r106 = r100.f435074f.isLarkUser();
        String r107 = r102.f435240b;
        if (r106 == false) goto L13;
        MmParticipantType r108 = MmParticipantType.LARK_USER;
    L14:
        MmParticipantType r109 = r108;
        if (r106 == false) goto L17;
        MmSubtitleSpeakerType r110 = MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER;
    L18:
        MmSubtitleSpeakerType r111 = r110;
        String r112 = r100.f435070b;
        if (r112.length() != 0) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L24;
        String r114 = r102.f435244f;
    L25:
        b r115 = null;
        if (r106 == false) goto L40;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.d r116 = r100.f435073e;
        if (r116 == null) goto L49;
        String r117 = r116.f435076a;
        if (r117 == null) goto L49;
        if (r117.length() <= 0) goto L34;
        boolean r118 = true;
    L35:
        if (r118 == true) goto L38;
        r117 = null;
    L38:
        if (r117 == null) goto L49;
        b r119 = new b.C5190b(r117, r105);
    L50:
        if (r119 == null) goto L52;
        b r120 = r119;
    L80:
        return new c(r105, r107, r109, r111, r114, r120);
    L52:
        if (r105.length() <= 0) goto L54;
        r101 = true;
    L54:
        if (r101 == false) goto L56;
        String r121 = r105;
    L57:
        if (r121 == null) goto L59;
        r115 = new b.e(r121);
    L59:
        if (r115 != null) goto L62;
        r115 = b.c.f435199a;
    L62:
        r120 = r115;
        goto L80
    L56:
        r121 = null;
        goto L57
    L34:
        r118 = false;
    L49:
        r119 = null;
        goto L50
    L40:
        String r122 = r100.f435072d;
        if (r122.length() <= 0) goto L43;
        boolean r123 = true;
    L44:
        if (r123 == true) goto L47;
        r122 = null;
    L47:
        if (r122 == null) goto L49;
        r119 = new b.d(r122);
        goto L50
    L43:
        r123 = false;
        goto L44
    L24:
        r114 = r112;
        goto L25
    L21:
        r113 = false;
        goto L22
    L17:
        r110 = r102.f435242d;
        goto L18
    L13:
        r108 = MmParticipantType.UNKNOWN;
        goto L14
    L7:
        r104 = false;
        goto L8
    L65:
        int r124 = c.f435202g;
        i r125 = this.f435228g;
        Intrinsics.checkNotNullParameter(r125, MmEndWindowAvatar.TYPE_SPEAKER);
        String r126 = r125.f435239a;
        String r127 = r125.f435240b;
        MmParticipantType r128 = r125.f435241c;
        MmSubtitleSpeakerType r129 = r125.f435242d;
        String r130 = r125.f435244f;
        if (r125.f435245g.length() <= 0) goto L68;
        boolean r131 = true;
    L69:
        if (r131 == false) goto L72;
        b r132 = new b.C5190b(r125.f435245g, r125.f435239a);
    L76:
        b r133 = r132;
    L79:
        return new c(r126, r127, r128, r129, r130, r133);
    L72:
        if (r125.f435239a.length() <= 0) goto L74;
        r101 = true;
    L74:
        if (r101 == false) goto L77;
        r132 = new b.e(r125.f435239a);
        goto L76
    L77:
        r133 = b.c.f435199a;
        goto L79
    L68:
        r131 = false;
        goto L69
    }

    public final MmDisplaySpeakerEditBackgroundStyle c() {
        if (this.f435232k == true) goto L6;
        return MmDisplaySpeakerEditBackgroundStyle.NONE;
    L6:
        if (this.f435231j == true) goto L13;
        if (this.f435229h != null) goto L24;
        if (this.f435228g.f435242d.isLarkUser() == false) goto L13;
    L24:
        return MmDisplaySpeakerEditBackgroundStyle.DISABLE_MARKED;
    L13:
        if (this.f435231j == true) goto L16;
        return MmDisplaySpeakerEditBackgroundStyle.DISABLE_UNMARKED;
    L16:
        if (this.f435229h == null) goto L19;
        return MmDisplaySpeakerEditBackgroundStyle.EDITABLE_MARKED;
    L19:
        if (this.f435228g.f435242d.isLarkUser() == false) goto L22;
        return MmDisplaySpeakerEditBackgroundStyle.EDITABLE_MARKED;
    L22:
        return MmDisplaySpeakerEditBackgroundStyle.EDITABLE_UNMARKED;
    }

    public static h a(h r210, String r211, String r212, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r213, boolean r310, boolean r311, int r312) {
        long r100 = 0;
        if ((r312 & 1) == 0) goto L5;
        long r101 = r210.f435222a;
    L7:
        if ((r312 & 2) == 0) goto L9;
        boolean r110 = r210.f435223b;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r111 = r210.f435224c;
    L15:
        if ((r312 & 8) == 0) goto L17;
        r100 = r210.f435225d;
    L17:
        long r112 = r100;
        if ((r312 & 16) == 0) goto L20;
        String r113 = r210.f435226e;
    L22:
        if ((r312 & 32) == 0) goto L24;
        String r102 = r210.f435227f;
    L25:
        String r103 = null;
        if ((r312 & 64) == 0) goto L28;
        i r104 = r210.f435228g;
    L30:
        if ((r312 & 128) == 0) goto L32;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r114 = r210.f435229h;
    L34:
        if ((r312 & 256) == 0) goto L37;
        r103 = r210.f435230i;
    L37:
        if ((r312 & 512) == 0) goto L39;
        boolean r214 = r210.f435231j;
    L41:
        if ((r312 & 1024) == 0) goto L43;
        boolean r215 = r210.f435232k;
    L45:
        if ((r312 & 2048) == 0) goto L47;
        boolean r216 = r210.f435233l;
    L49:
        if ((r312 & 4096) == 0) goto L51;
        boolean r217 = r210.f435234m;
    L53:
        if ((r312 & 8192) == 0) goto L55;
        boolean r218 = r210.f435235n;
    L57:
        if ((r312 & 16384) == 0) goto L59;
        boolean r219 = r210.f435236o;
    L60:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r113, "sourceContent");
        Intrinsics.checkNotNullParameter(r102, "targetContent");
        Intrinsics.checkNotNullParameter(r104, MmEndWindowAvatar.TYPE_SPEAKER);
        Intrinsics.checkNotNullParameter(r103, "clusterId");
        return new h(r101, r110, r111, r112, r113, r102, r104, r114, r103, r214, r215, r216, r217, r218, r219);
    L59:
        r219 = false;
        goto L60
    L55:
        r218 = false;
        goto L57
    L51:
        r217 = r311;
        goto L53
    L47:
        r216 = false;
        goto L49
    L43:
        r215 = false;
        goto L45
    L39:
        r214 = r310;
        goto L41
    L32:
        r114 = r213;
        goto L34
    L28:
        r104 = null;
        goto L30
    L24:
        r102 = r212;
        goto L25
    L20:
        r113 = r211;
        goto L22
    L13:
        r111 = 0;
        goto L15
    L9:
        r110 = false;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public /* synthetic */ h(long r210, boolean r211, long r212, long r213, String r310, String r311, i r312, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r313, String r314, boolean r315, boolean r316, boolean r317, boolean r318, int r410) {
        if ((r410 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r410 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r410 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r410 & 8) == 0) goto L17;
        long r110 = 0;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r111 = "";
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r112 = "";
    L27:
        if ((r410 & 64) == 0) goto L29;
        i r113 = new i(null, null, null, null, null, 127);
    L31:
        if ((r410 & 128) == 0) goto L33;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r114 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r410 & 512) == 0) goto L41;
        boolean r116 = false;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        boolean r118 = false;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        boolean r214 = false;
    L54:
        this(r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r214, false, false);
        return;
    L53:
        r214 = r318;
        goto L54
    L49:
        r118 = r317;
        goto L51
    L45:
        r117 = r316;
        goto L47
    L41:
        r116 = r315;
        goto L43
    L37:
        r115 = r314;
        goto L39
    L33:
        r114 = r313;
        goto L35
    L29:
        r113 = r312;
        goto L31
    L25:
        r112 = r311;
        goto L27
    L21:
        r111 = r310;
        goto L23
    L17:
        r110 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public h(long r100, boolean r110, long r111, long r112, String r113, String r114, i r115, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r116, String r117, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r113, "sourceContent");
        Intrinsics.checkNotNullParameter(r114, "targetContent");
        Intrinsics.checkNotNullParameter(r115, MmEndWindowAvatar.TYPE_SPEAKER);
        Intrinsics.checkNotNullParameter(r117, "clusterId");
        this.f435222a = r100;
        this.f435223b = r110;
        this.f435224c = r111;
        this.f435225d = r112;
        this.f435226e = r113;
        this.f435227f = r114;
        this.f435228g = r115;
        this.f435229h = r116;
        this.f435230i = r117;
        this.f435231j = r210;
        this.f435232k = r211;
        this.f435233l = r212;
        this.f435234m = r213;
        this.f435235n = r214;
        this.f435236o = r215;
    }
}
