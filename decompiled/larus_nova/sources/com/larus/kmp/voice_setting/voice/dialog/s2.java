package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s2 implements t1a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f352926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f352927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f352928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f352929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f352930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final UgcVoiceInfoOptimizeBannerMode f352931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f352932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.q0 f352933p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final UgcVoiceInfoOptimizeErrorIconMode f352934q;

    public s2() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, 131071);
    }

    public static s2 a(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, boolean r311, boolean r312, UgcVoiceInfoOptimizeBannerMode r313, boolean r314, com.larus.kmp.voice_setting.platform.q0 r315, UgcVoiceInfoOptimizeErrorIconMode r316) {
        Intrinsics.checkNotNullParameter(r210, "title");
        Intrinsics.checkNotNullParameter(r211, "avatarUrl");
        Intrinsics.checkNotNullParameter(r212, "voiceName");
        Intrinsics.checkNotNullParameter(r213, "progressText");
        Intrinsics.checkNotNullParameter(r214, "playText");
        Intrinsics.checkNotNullParameter(r215, "errorText");
        Intrinsics.checkNotNullParameter(r216, "permissionHint");
        Intrinsics.checkNotNullParameter(r217, "privateLabel");
        Intrinsics.checkNotNullParameter(r218, "publicLabel");
        Intrinsics.checkNotNullParameter(r219, "publicWarning");
        Intrinsics.checkNotNullParameter(r310, "completeText");
        Intrinsics.checkNotNullParameter(r313, "bannerMode");
        Intrinsics.checkNotNullParameter(r316, "errorIconMode");
        return new s2(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public static /* synthetic */ s2 b(s2 r210, String r211, String r212, String r213, String r214, boolean r215, boolean r216, UgcVoiceInfoOptimizeBannerMode r217, boolean r218, UgcVoiceInfoOptimizeErrorIconMode r310, int r311) {
        com.larus.kmp.voice_setting.platform.q0 r100 = null;
        if ((r311 & 1) == 0) goto L5;
        String r101 = r210.f352918a;
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r102 = r210.f352919b;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r103 = r210.f352920c;
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r104 = r210.f352921d;
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r105 = r210.f352922e;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r106 = r210.f352923f;
    L27:
        if ((r311 & 64) == 0) goto L29;
        String r110 = r210.f352924g;
    L31:
        if ((r311 & 128) == 0) goto L33;
        String r111 = r210.f352925h;
    L35:
        if ((r311 & 256) == 0) goto L37;
        String r112 = r210.f352926i;
    L39:
        if ((r311 & 512) == 0) goto L41;
        String r113 = r210.f352927j;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r114 = r210.f352928k;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        boolean r115 = r210.f352929l;
    L51:
        if ((r311 & 4096) == 0) goto L53;
        boolean r116 = r210.f352930m;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        UgcVoiceInfoOptimizeBannerMode r117 = r210.f352931n;
    L59:
        if ((r311 & 16384) == 0) goto L61;
        boolean r118 = r210.f352932o;
    L63:
        if ((32768 & r311) == 0) goto L65;
        r100 = r210.f352933p;
    L65:
        com.larus.kmp.voice_setting.platform.q0 r119 = r100;
        if ((r311 & 65536) == 0) goto L68;
        UgcVoiceInfoOptimizeErrorIconMode r219 = r210.f352934q;
    L69:
        r210.getClass();
        return a(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r219);
    L68:
        r219 = r310;
        goto L69
    L61:
        r118 = r218;
        goto L63
    L57:
        r117 = r217;
        goto L59
    L53:
        r116 = r216;
        goto L55
    L49:
        r115 = r215;
        goto L51
    L45:
        r114 = r214;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = null;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s2) == true) goto L8;
        return false;
    L8:
        s2 r101 = (s2) r100;
        if (Intrinsics.areEqual(this.f352918a, r101.f352918a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352919b, r101.f352919b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352920c, r101.f352920c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352921d, r101.f352921d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352922e, r101.f352922e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352923f, r101.f352923f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352924g, r101.f352924g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352925h, r101.f352925h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352926i, r101.f352926i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352927j, r101.f352927j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352928k, r101.f352928k) == true) goto L42;
        return false;
    L42:
        if (this.f352929l == r101.f352929l) goto L45;
        return false;
    L45:
        if (this.f352930m == r101.f352930m) goto L48;
        return false;
    L48:
        if (this.f352931n == r101.f352931n) goto L51;
        return false;
    L51:
        if (this.f352932o == r101.f352932o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f352933p, r101.f352933p) == true) goto L57;
        return false;
    L57:
        if (this.f352934q == r101.f352934q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((this.f352918a.hashCode() * 31) + this.f352919b.hashCode()) * 31) + this.f352920c.hashCode()) * 31) + this.f352921d.hashCode()) * 31) + this.f352922e.hashCode()) * 31) + this.f352923f.hashCode()) * 31) + this.f352924g.hashCode()) * 31) + this.f352925h.hashCode()) * 31) + this.f352926i.hashCode()) * 31) + this.f352927j.hashCode()) * 31) + this.f352928k.hashCode()) * 31;
        int r101 = 1231;
        if (this.f352929l == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f352930m == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f352931n.hashCode()) * 31;
        if (this.f352932o == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        com.larus.kmp.voice_setting.platform.q0 r107 = this.f352933p;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return ((r106 + r108) * 31) + this.f352934q.hashCode();
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UgcVoiceInfoOptimizeDialogUiState(title=" + this.f352918a + ", avatarUrl=" + this.f352919b + ", voiceName=" + this.f352920c + ", progressText=" + this.f352921d + ", playText=" + this.f352922e + ", errorText=" + this.f352923f + ", permissionHint=" + this.f352924g + ", privateLabel=" + this.f352925h + ", publicLabel=" + this.f352926i + ", publicWarning=" + this.f352927j + ", completeText=" + this.f352928k + ", isPublic=" + this.f352929l + ", isCompleteEnabled=" + this.f352930m + ", bannerMode=" + this.f352931n + ", isVoicePlaying=" + this.f352932o + ", previewRequest=" + this.f352933p + ", errorIconMode=" + this.f352934q + ')';
    }

    public /* synthetic */ s2(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, String r312, boolean r313, UgcVoiceInfoOptimizeBannerMode r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r110 = "";
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r111 = "";
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r113 = "";
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r114 = "";
    L47:
        if ((r315 & 2048) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        boolean r116 = true;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        UgcVoiceInfoOptimizeBannerMode r117 = UgcVoiceInfoOptimizeBannerMode.PROGRESS;
    L59:
        if ((r315 & 65536) == 0) goto L61;
        UgcVoiceInfoOptimizeErrorIconMode r106 = UgcVoiceInfoOptimizeErrorIconMode.PROGRESS;
    L62:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, false, null, r106);
        return;
    L61:
        r106 = null;
        goto L62
    L57:
        r117 = r314;
        goto L59
    L53:
        r116 = false;
        goto L55
    L49:
        r115 = r313;
        goto L51
    L45:
        r114 = r312;
        goto L47
    L41:
        r113 = r311;
        goto L43
    L37:
        r112 = r310;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
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

    public s2(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r217, boolean r218, UgcVoiceInfoOptimizeBannerMode r219, boolean r310, com.larus.kmp.voice_setting.platform.q0 r311, UgcVoiceInfoOptimizeErrorIconMode r312) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "avatarUrl");
        Intrinsics.checkNotNullParameter(r112, "voiceName");
        Intrinsics.checkNotNullParameter(r113, "progressText");
        Intrinsics.checkNotNullParameter(r210, "playText");
        Intrinsics.checkNotNullParameter(r211, "errorText");
        Intrinsics.checkNotNullParameter(r212, "permissionHint");
        Intrinsics.checkNotNullParameter(r213, "privateLabel");
        Intrinsics.checkNotNullParameter(r214, "publicLabel");
        Intrinsics.checkNotNullParameter(r215, "publicWarning");
        Intrinsics.checkNotNullParameter(r216, "completeText");
        Intrinsics.checkNotNullParameter(r219, "bannerMode");
        Intrinsics.checkNotNullParameter(r312, "errorIconMode");
        this.f352918a = r110;
        this.f352919b = r111;
        this.f352920c = r112;
        this.f352921d = r113;
        this.f352922e = r210;
        this.f352923f = r211;
        this.f352924g = r212;
        this.f352925h = r213;
        this.f352926i = r214;
        this.f352927j = r215;
        this.f352928k = r216;
        this.f352929l = r217;
        this.f352930m = r218;
        this.f352931n = r219;
        this.f352932o = r310;
        this.f352933p = r311;
        this.f352934q = r312;
    }
}
