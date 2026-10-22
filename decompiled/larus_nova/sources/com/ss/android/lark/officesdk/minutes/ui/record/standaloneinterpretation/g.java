package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f436768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f436769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MMRecordingState f436770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> f436771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> f436772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c f436773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c f436774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, MmStandaloneAIInterpretationLanguageDisabledReason> f436775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, MmStandaloneAIInterpretationLanguageDisabledReason> f436776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f436777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmStandaloneAIInterpretationLanguageSide f436778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f436779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f436780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f436781n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f436782o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f436783p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f436784q;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f436768a == r101.f436768a) goto L12;
        return false;
    L12:
        if (this.f436769b == r101.f436769b) goto L15;
        return false;
    L15:
        if (this.f436770c == r101.f436770c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f436771d, r101.f436771d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f436772e, r101.f436772e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f436773f, r101.f436773f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f436774g, r101.f436774g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f436775h, r101.f436775h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f436776i, r101.f436776i) == true) goto L36;
        return false;
    L36:
        if (this.f436777j == r101.f436777j) goto L39;
        return false;
    L39:
        if (this.f436778k == r101.f436778k) goto L42;
        return false;
    L42:
        if (this.f436779l == r101.f436779l) goto L45;
        return false;
    L45:
        if (this.f436780m == r101.f436780m) goto L48;
        return false;
    L48:
        if (this.f436781n == r101.f436781n) goto L51;
        return false;
    L51:
        if (this.f436782o == r101.f436782o) goto L54;
        return false;
    L54:
        if (this.f436783p == r101.f436783p) goto L57;
        return false;
    L57:
        if (this.f436784q == r101.f436784q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f436768a;
        int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f436769b) * 31) + this.f436770c.hashCode()) * 31) + this.f436771d.hashCode()) * 31) + this.f436772e.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r102 = this.f436773f;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r106 = this.f436774g;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        int r107 = (((((r105 + r103) * 31) + this.f436775h.hashCode()) * 31) + this.f436776i.hashCode()) * 31;
        int r108 = 1231;
        if (this.f436777j == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f436778k.hashCode()) * 31;
        if (this.f436779l == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f436780m == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f436781n == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f436782o == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.f436783p == false) goto L33;
        int r119 = 1231;
    L34:
        int r120 = (r118 + r119) * 31;
        if (this.f436784q == true) goto L39;
        r108 = 1237;
    L39:
        return r120 + r108;
    L33:
        r119 = 1237;
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationVMState(duration=" + this.f436768a + ", audioVolume=" + this.f436769b + ", recordingState=" + this.f436770c + ", supportSpokenLanguages=" + this.f436771d + ", supportTargetLanguages=" + this.f436772e + ", selectedSpokenLanguage=" + this.f436773f + ", selectedLanguage=" + this.f436774g + ", disabledSpokenLanguageReasons=" + this.f436775h + ", disabledTargetLanguageReasons=" + this.f436776i + ", isHeaderLanguageLoading=" + this.f436777j + ", languagePanelSide=" + this.f436778k + ", isBilingual=" + this.f436779l + ", languageSettingSyncing=" + this.f436780m + ", isPlaybackMuted=" + this.f436781n + ", saveArtifactType=" + this.f436782o + ", saveArtifactReady=" + this.f436783p + ", saveArtifactSyncing=" + this.f436784q + ')';
    }

    public /* synthetic */ g(int r210) {
        this(0, 0, MMRecordingState.INIT, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, null, MapsKt.emptyMap(), MapsKt.emptyMap(), true, MmStandaloneAIInterpretationLanguageSide.TARGET, false, false, true, false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(long r110, int r111, MMRecordingState r112, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r113, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r114, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r115, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r116, Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r117, Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r118, boolean r210, MmStandaloneAIInterpretationLanguageSide r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217) {
        Intrinsics.checkNotNullParameter(r112, "recordingState");
        Intrinsics.checkNotNullParameter(r113, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r114, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r117, "disabledSpokenLanguageReasons");
        Intrinsics.checkNotNullParameter(r118, "disabledTargetLanguageReasons");
        Intrinsics.checkNotNullParameter(r211, "languagePanelSide");
        this.f436768a = r110;
        this.f436769b = r111;
        this.f436770c = r112;
        this.f436771d = r113;
        this.f436772e = r114;
        this.f436773f = r115;
        this.f436774g = r116;
        this.f436775h = r117;
        this.f436776i = r118;
        this.f436777j = r210;
        this.f436778k = r211;
        this.f436779l = r212;
        this.f436780m = r213;
        this.f436781n = r214;
        this.f436782o = r215;
        this.f436783p = r216;
        this.f436784q = r217;
    }

    public static g a(g r110, long r111, int r210, MMRecordingState r211, List r212, List r213, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r214, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r215, Map r216, Map r217, boolean r218, MmStandaloneAIInterpretationLanguageSide r219, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        long r100 = r110.f436768a;
    L7:
        if ((r316 & 2) == 0) goto L9;
        int r101 = r110.f436769b;
    L11:
        if ((r316 & 4) == 0) goto L13;
        MMRecordingState r102 = r110.f436770c;
    L15:
        if ((r316 & 8) == 0) goto L17;
        List r103 = r110.f436771d;
    L19:
        if ((r316 & 16) == 0) goto L21;
        List r104 = r110.f436772e;
    L23:
        if ((r316 & 32) == 0) goto L25;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r105 = r110.f436773f;
    L27:
        if ((r316 & 64) == 0) goto L29;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r106 = r110.f436774g;
    L31:
        if ((r316 & 128) == 0) goto L33;
        Map r112 = r110.f436775h;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Map r113 = r110.f436776i;
    L39:
        if ((r316 & 512) == 0) goto L41;
        boolean r114 = r110.f436777j;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        MmStandaloneAIInterpretationLanguageSide r115 = r110.f436778k;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        boolean r116 = r110.f436779l;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        boolean r117 = r110.f436780m;
    L54:
        boolean r317 = r117;
        if ((r316 & 8192) == 0) goto L57;
        boolean r118 = r110.f436781n;
    L58:
        boolean r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        boolean r119 = r110.f436782o;
    L62:
        boolean r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        boolean r120 = r110.f436783p;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        boolean r107 = r110.f436784q;
    L70:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r102, "recordingState");
        Intrinsics.checkNotNullParameter(r103, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r104, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r112, "disabledSpokenLanguageReasons");
        Intrinsics.checkNotNullParameter(r113, "disabledTargetLanguageReasons");
        Intrinsics.checkNotNullParameter(r115, "languagePanelSide");
        return new g(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r317, r318, r319, r120, r107);
    L69:
        r107 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L67
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r219;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
