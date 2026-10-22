package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l5 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoicePlatformEffectKind f352355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y4 f352357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.j0 f352358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f352359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0 f352360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a8 f352361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f352362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.q0 f352363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.editvoice.b f352364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f352365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f352366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f352367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f352368n;

    public l5() {
        this(null, 0, null, null, null, null, null, null, null, 0, null, 0.0f, 0.0f, 262143);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l5) == true) goto L8;
        return false;
    L8:
        l5 r101 = (l5) r100;
        if (this.f352355a == r101.f352355a) goto L12;
        return false;
    L12:
        if (this.f352356b == r101.f352356b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352357c, r101.f352357c) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352358d, r101.f352358d) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352359e, r101.f352359e) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352360f, r101.f352360f) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352361g, r101.f352361g) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f352362h, r101.f352362h) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f352363i, r101.f352363i) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f352364j, r101.f352364j) == true) goto L51;
        return false;
    L51:
        if (this.f352365k == r101.f352365k) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f352366l, r101.f352366l) == true) goto L57;
        return false;
    L57:
        if (Float.compare(this.f352367m, r101.f352367m) == 0) goto L60;
        return false;
    L60:
        if (Float.compare(this.f352368n, r101.f352368n) == 0) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352355a.hashCode() * 31;
        long r101 = this.f352356b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 0;
        int r104 = (((r102 + 0) * 31) + 0) * 31;
        y4 r105 = this.f352357c;
        if (r105 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (((r104 + r106) * 31) + 0) * 31;
        com.larus.kmp.voice_setting.platform.j0 r108 = this.f352358d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        s r111 = this.f352359e;
        if (r111 != null) goto L13;
        int r112 = 0;
    L14:
        int r113 = (r110 + r112) * 31;
        n0 r114 = this.f352360f;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (((r113 + r115) * 31) + 0) * 31;
        a8 r117 = this.f352361g;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (r116 + r118) * 31;
        c0 r120 = this.f352362h;
        if (r120 != null) goto L25;
        int r121 = 0;
    L26:
        int r122 = (r119 + r121) * 31;
        com.larus.kmp.voice_setting.platform.q0 r123 = this.f352363i;
        if (r123 != null) goto L29;
        int r124 = 0;
    L30:
        int r125 = (r122 + r124) * 31;
        com.larus.kmp.voice_setting.voice.editvoice.b r126 = this.f352364j;
        if (r126 == null) goto L34;
        r103 = r126.hashCode();
    L34:
        int r127 = (r125 + r103) * 31;
        long r128 = this.f352365k;
        return ((((((r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31) + this.f352366l.hashCode()) * 31) + Float.floatToIntBits(this.f352367m)) * 31) + Float.floatToIntBits(this.f352368n);
    L29:
        r124 = r123.hashCode();
        goto L30
    L25:
        r121 = r120.hashCode();
        goto L26
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r112 = r111.hashCode();
        goto L14
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r105.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoicePlatformEffectData(kind=" + this.f352355a + ", effectToken=" + this.f352356b + ", routeRequest=null, routeResult=null, pickerRequest=" + this.f352357c + ", cropRequest=null, uploadRequest=" + this.f352358d + ", createPreflightMeta=" + this.f352359e + ", recordRequest=" + this.f352360f + ", recordResult=null, shellFeedback=" + this.f352361g + ", dialogAction=" + this.f352362h + ", previewPlaybackRequest=" + this.f352363i + ", mixPreviewRequest=" + this.f352364j + ", vibrateDurationMs=" + this.f352365k + ", editResultScene=" + this.f352366l + ", editResultPitch=" + this.f352367m + ", editResultRate=" + this.f352368n + ')';
    }

    public l5(VoicePlatformEffectKind r110, long r210, y4 r211, com.larus.kmp.voice_setting.platform.j0 r212, s r213, n0 r214, a8 r215, com.larus.kmp.voice_setting.platform.q0 r216, com.larus.kmp.voice_setting.voice.editvoice.b r217, long r218, String r310, float r311, float r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        VoicePlatformEffectKind r100 = VoicePlatformEffectKind.NONE;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r313 & 16) == 0) goto L13;
        y4 r102 = null;
    L15:
        if ((r313 & 64) == 0) goto L17;
        com.larus.kmp.voice_setting.platform.j0 r103 = null;
    L19:
        if ((r313 & 128) == 0) goto L21;
        s r104 = null;
    L23:
        if ((r313 & 256) == 0) goto L25;
        n0 r105 = null;
    L27:
        if ((r313 & 1024) == 0) goto L29;
        a8 r111 = null;
    L31:
        if ((r313 & 4096) == 0) goto L33;
        com.larus.kmp.voice_setting.platform.q0 r112 = null;
    L35:
        if ((r313 & 8192) == 0) goto L37;
        com.larus.kmp.voice_setting.voice.editvoice.b r113 = null;
    L39:
        if ((r313 & 16384) == 0) goto L41;
        long r114 = 5;
    L43:
        if ((32768 & r313) == 0) goto L45;
        String r115 = "";
    L47:
        if ((r313 & 65536) == 0) goto L49;
        float r116 = 0.0f;
    L51:
        if ((r313 & 131072) == 0) goto L53;
        float r106 = 1.0f;
    L54:
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r115, "editResultScene");
        this.f352355a = r100;
        this.f352356b = r101;
        this.f352357c = r102;
        this.f352358d = r103;
        this.f352359e = r104;
        this.f352360f = r105;
        this.f352361g = r111;
        this.f352362h = null;
        this.f352363i = r112;
        this.f352364j = r113;
        this.f352365k = r114;
        this.f352366l = r115;
        this.f352367m = r116;
        this.f352368n = r106;
        return;
    L53:
        r106 = r312;
        goto L54
    L49:
        r116 = r311;
        goto L51
    L45:
        r115 = r310;
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
        r111 = r215;
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
        r100 = r110;
        goto L7
    }
}
