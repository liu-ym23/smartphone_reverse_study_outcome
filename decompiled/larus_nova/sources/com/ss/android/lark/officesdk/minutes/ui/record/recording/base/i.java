package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements l {
    public final String A;
    public final Boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f436238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f436239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f436240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MMRecordingState f436241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f436242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f436243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f436244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f436245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f436246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f436247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h f436248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h f436249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> f436250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> f436251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f436252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f436253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MmRecordingUITab f436254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MmAudioSaveType f436255r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f436256s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f436257t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f436258u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f436259v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g> f436260w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g f436261x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g f436262y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f436263z;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f436238a, r101.f436238a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f436239b, r101.f436239b) == true) goto L15;
        return false;
    L15:
        if (this.f436240c == r101.f436240c) goto L18;
        return false;
    L18:
        if (this.f436241d == r101.f436241d) goto L21;
        return false;
    L21:
        if (this.f436242e == r101.f436242e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f436243f, r101.f436243f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f436244g, r101.f436244g) == true) goto L30;
        return false;
    L30:
        if (this.f436245h == r101.f436245h) goto L33;
        return false;
    L33:
        if (this.f436246i == r101.f436246i) goto L36;
        return false;
    L36:
        if (this.f436247j == r101.f436247j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f436248k, r101.f436248k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f436249l, r101.f436249l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f436250m, r101.f436250m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f436251n, r101.f436251n) == true) goto L51;
        return false;
    L51:
        if (this.f436252o == r101.f436252o) goto L54;
        return false;
    L54:
        if (this.f436253p == r101.f436253p) goto L57;
        return false;
    L57:
        if (this.f436254q == r101.f436254q) goto L60;
        return false;
    L60:
        if (this.f436255r == r101.f436255r) goto L63;
        return false;
    L63:
        if (this.f436256s == r101.f436256s) goto L66;
        return false;
    L66:
        if (this.f436257t == r101.f436257t) goto L69;
        return false;
    L69:
        if (this.f436258u == r101.f436258u) goto L72;
        return false;
    L72:
        if (this.f436259v == r101.f436259v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f436260w, r101.f436260w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f436261x, r101.f436261x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f436262y, r101.f436262y) == true) goto L84;
        return false;
    L84:
        if (this.f436263z == r101.f436263z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f436238a.hashCode() * 31) + this.f436239b.hashCode()) * 31;
        long r101 = this.f436240c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f436241d.hashCode()) * 31;
        int r103 = 1231;
        if (this.f436242e == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (((((r102 + r104) * 31) + this.f436243f.hashCode()) * 31) + this.f436244g.hashCode()) * 31;
        long r106 = this.f436245h;
        int r107 = (((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f436246i) * 31;
        if (this.f436247j == false) goto L9;
        int r108 = 1231;
    L10:
        int r109 = (((((((((r107 + r108) * 31) + this.f436248k.hashCode()) * 31) + this.f436249l.hashCode()) * 31) + this.f436250m.hashCode()) * 31) + this.f436251n.hashCode()) * 31;
        if (this.f436252o == false) goto L13;
        int r110 = 1231;
    L14:
        int r111 = (r109 + r110) * 31;
        if (this.f436253p == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (((((r111 + r112) * 31) + this.f436254q.hashCode()) * 31) + this.f436255r.hashCode()) * 31;
        if (this.f436256s == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        if (this.f436257t == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f436258u == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f436259v == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (((r119 + r120) * 31) + this.f436260w.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r122 = this.f436261x;
        int r123 = 0;
        if (r122 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r121 + r124) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r126 = this.f436262y;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        if (this.f436263z == true) goto L46;
        r103 = 1237;
    L46:
        int r129 = (r128 + r103) * 31;
        String r130 = this.A;
        if (r130 != null) goto L49;
        int r131 = 0;
    L50:
        int r132 = (r129 + r131) * 31;
        Boolean r133 = this.B;
        if (r133 == null) goto L55;
        r123 = r133.hashCode();
    L55:
        return r132 + r123;
    L49:
        r131 = r130.hashCode();
        goto L50
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r122.hashCode();
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = 1237;
        goto L18
    L13:
        r110 = 1237;
        goto L14
    L9:
        r108 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingVMState(minutesToken=" + this.f436238a + ", meetingId=" + this.f436239b + ", meetingStartTime=" + this.f436240c + ", recordingState=" + this.f436241d + ", pauseResumeVisible=" + this.f436242e + ", title=" + this.f436243f + ", mmPOIAddress=" + this.f436244g + ", duration=" + this.f436245h + ", audioVolume=" + this.f436246i + ", showAudioSaveEntry=" + this.f436247j + ", currSpokenLanguage=" + this.f436248k + ", currTranslateLanguage=" + this.f436249l + ", spokenLanguageList=" + this.f436250m + ", translateLanguageList=" + this.f436251n + ", isBilingual=" + this.f436252o + ", isSubtitleSettingsDegraded=" + this.f436253p + ", currentTab=" + this.f436254q + ", audioSaveType=" + this.f436255r + ", needShowAudioSaveBoarding=" + this.f436256s + ", needShowAINoteTooltip=" + this.f436257t + ", showAIInterpretationEntry=" + this.f436258u + ", aiInterpretationOn=" + this.f436259v + ", aiInterpretationLanguages=" + this.f436260w + ", selectedAIInterpretationLanguage=" + this.f436261x + ", activeAIInterpretationLanguage=" + this.f436262y + ", aiInterpretationLoading=" + this.f436263z + ", aiInterpretationErrorMessage=" + this.A + ", hasUnviewedSummary=" + this.B + ')';
    }

    public /* synthetic */ i(int r310) {
        this("", "", 0, MMRecordingState.INIT, true, "", "", 0, 0, false, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(0), new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(0), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, false, MmRecordingUITab.SUBTITLE, MmAudioSaveType.SAVE, false, false, false, false, CollectionsKt.emptyList(), null, null, false, null, null);
    }

    public i(String r110, String r111, long r112, MMRecordingState r113, boolean r210, String r211, String r212, long r213, int r214, boolean r215, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r216, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r217, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r218, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r310, boolean r311, boolean r312, MmRecordingUITab r313, MmAudioSaveType r314, boolean r315, boolean r316, boolean r317, boolean r318, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g> r319, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r410, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r411, boolean r412, String r413, Boolean r414) {
        Intrinsics.checkNotNullParameter(r110, "minutesToken");
        Intrinsics.checkNotNullParameter(r111, "meetingId");
        Intrinsics.checkNotNullParameter(r113, "recordingState");
        Intrinsics.checkNotNullParameter(r211, "title");
        Intrinsics.checkNotNullParameter(r212, "mmPOIAddress");
        Intrinsics.checkNotNullParameter(r216, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r217, "currTranslateLanguage");
        Intrinsics.checkNotNullParameter(r218, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r310, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r313, "currentTab");
        Intrinsics.checkNotNullParameter(r314, "audioSaveType");
        Intrinsics.checkNotNullParameter(r319, "aiInterpretationLanguages");
        this.f436238a = r110;
        this.f436239b = r111;
        this.f436240c = r112;
        this.f436241d = r113;
        this.f436242e = r210;
        this.f436243f = r211;
        this.f436244g = r212;
        this.f436245h = r213;
        this.f436246i = r214;
        this.f436247j = r215;
        this.f436248k = r216;
        this.f436249l = r217;
        this.f436250m = r218;
        this.f436251n = r310;
        this.f436252o = r311;
        this.f436253p = r312;
        this.f436254q = r313;
        this.f436255r = r314;
        this.f436256s = r315;
        this.f436257t = r316;
        this.f436258u = r317;
        this.f436259v = r318;
        this.f436260w = r319;
        this.f436261x = r410;
        this.f436262y = r411;
        this.f436263z = r412;
        this.A = r413;
        this.B = r414;
    }

    public static i a(i r110, String r111, String r112, long r210, MMRecordingState r211, boolean r212, String r213, String r214, long r215, int r216, boolean r217, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r310, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r311, List r312, List r313, boolean r314, boolean r315, MmRecordingUITab r316, MmAudioSaveType r317, boolean r318, boolean r319, boolean r410, boolean r411, List r412, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r413, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r414, boolean r415, String r416, Boolean r417, int r418) {
        if ((r418 & 1) == 0) goto L5;
        String r100 = r110.f436238a;
    L7:
        if ((r418 & 2) == 0) goto L9;
        String r101 = r110.f436239b;
    L11:
        if ((r418 & 4) == 0) goto L13;
        long r102 = r110.f436240c;
    L15:
        if ((r418 & 8) == 0) goto L17;
        MMRecordingState r103 = r110.f436241d;
    L19:
        if ((r418 & 16) == 0) goto L21;
        boolean r104 = r110.f436242e;
    L23:
        if ((r418 & 32) == 0) goto L25;
        String r105 = r110.f436243f;
    L27:
        if ((r418 & 64) == 0) goto L29;
        String r106 = r110.f436244g;
    L31:
        if ((r418 & 128) == 0) goto L33;
        long r113 = r110.f436245h;
    L35:
        if ((r418 & 256) == 0) goto L37;
        int r114 = r110.f436246i;
    L39:
        if ((r418 & 512) == 0) goto L41;
        boolean r115 = r110.f436247j;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r116 = r110.f436248k;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r117 = r110.f436249l;
    L50:
        boolean r218 = r115;
        if ((r418 & 4096) == 0) goto L53;
        List r118 = r110.f436250m;
    L54:
        int r219 = r114;
        if ((r418 & 8192) == 0) goto L57;
        List r119 = r110.f436251n;
    L58:
        long r220 = r113;
        if ((r418 & 16384) == 0) goto L61;
        boolean r120 = r110.f436252o;
    L63:
        if ((32768 & r418) == 0) goto L65;
        boolean r121 = r110.f436253p;
    L66:
        boolean r320 = r121;
        if ((r418 & 65536) == 0) goto L69;
        MmRecordingUITab r122 = r110.f436254q;
    L70:
        boolean r321 = r120;
        if ((r418 & 131072) == 0) goto L73;
        MmAudioSaveType r123 = r110.f436255r;
    L74:
        boolean r221 = r104;
        if ((r418 & 262144) == 0) goto L77;
        boolean r107 = r110.f436256s;
    L78:
        boolean r322 = r107;
        if ((r418 & 524288) == 0) goto L81;
        boolean r108 = r110.f436257t;
    L82:
        boolean r323 = r108;
        if ((r418 & 1048576) == 0) goto L85;
        boolean r109 = r110.f436258u;
    L86:
        boolean r419 = r109;
        if ((r418 & 2097152) == 0) goto L89;
        boolean r124 = r110.f436259v;
    L90:
        boolean r420 = r124;
        if ((r418 & 4194304) == 0) goto L93;
        List r125 = r110.f436260w;
    L94:
        long r222 = r102;
        if ((r418 & 8388608) == 0) goto L97;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r126 = r110.f436261x;
    L99:
        if ((16777216 & r418) == 0) goto L101;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r127 = r110.f436262y;
    L102:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r421 = r127;
        if ((r418 & 33554432) == 0) goto L105;
        boolean r128 = r110.f436263z;
    L106:
        boolean r422 = r128;
        if ((r418 & 67108864) == 0) goto L109;
        String r129 = r110.A;
    L111:
        if ((r418 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Boolean r130 = r110.B;
    L114:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "minutesToken");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r103, "recordingState");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r106, "mmPOIAddress");
        Intrinsics.checkNotNullParameter(r116, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r117, "currTranslateLanguage");
        Intrinsics.checkNotNullParameter(r118, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r119, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r122, "currentTab");
        Intrinsics.checkNotNullParameter(r123, "audioSaveType");
        Intrinsics.checkNotNullParameter(r125, "aiInterpretationLanguages");
        return new i(r100, r101, r222, r103, r221, r105, r106, r220, r219, r218, r116, r117, r118, r119, r321, r320, r122, r123, r322, r323, r419, r420, r125, r126, r421, r422, r129, r130);
    L113:
        r130 = r417;
        goto L114
    L109:
        r129 = r416;
        goto L111
    L105:
        r128 = r415;
        goto L106
    L101:
        r127 = r414;
        goto L102
    L97:
        r126 = r413;
        goto L99
    L93:
        r125 = r412;
        goto L94
    L89:
        r124 = r411;
        goto L90
    L85:
        r109 = r410;
        goto L86
    L81:
        r108 = r319;
        goto L82
    L77:
        r107 = r318;
        goto L78
    L73:
        r123 = r317;
        goto L74
    L69:
        r122 = r316;
        goto L70
    L65:
        r121 = r315;
        goto L66
    L61:
        r120 = r314;
        goto L63
    L57:
        r119 = r313;
        goto L58
    L53:
        r118 = r312;
        goto L54
    L49:
        r117 = r311;
        goto L50
    L45:
        r116 = r310;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
