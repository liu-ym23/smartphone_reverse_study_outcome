package com.larus.kmp.voice_setting.voice.dialog.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f353082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceChatSpeakerStatus f353083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceChatSpeakerVisualStyle f353084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f353086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f353087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f353088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f353089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f353090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f353091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f353092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h0 f353093l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Float f353094m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Float f353095n;

    public f0() {
        this(false, null, null, null, null, null, false, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f353082a == r101.f353082a) goto L12;
        return false;
    L12:
        if (this.f353083b == r101.f353083b) goto L15;
        return false;
    L15:
        if (this.f353084c == r101.f353084c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353085d, r101.f353085d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353086e, r101.f353086e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f353087f, r101.f353087f) == true) goto L27;
        return false;
    L27:
        if (this.f353088g == r101.f353088g) goto L30;
        return false;
    L30:
        if (this.f353089h == r101.f353089h) goto L33;
        return false;
    L33:
        if (this.f353090i == r101.f353090i) goto L36;
        return false;
    L36:
        if (this.f353091j == r101.f353091j) goto L39;
        return false;
    L39:
        if (this.f353092k == r101.f353092k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f353093l, r101.f353093l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f353094m, r101.f353094m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f353095n, r101.f353095n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f353082a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((((r101 * 31) + this.f353083b.hashCode()) * 31) + this.f353084c.hashCode()) * 31) + this.f353085d.hashCode()) * 31) + this.f353086e.hashCode()) * 31) + this.f353087f.hashCode()) * 31;
        if (this.f353088g == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f353089h;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        if (this.f353090i == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f353091j == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f353092k == true) goto L22;
        r100 = 1237;
    L22:
        int r111 = (((r110 + r100) * 31) + this.f353093l.hashCode()) * 31;
        Float r112 = this.f353094m;
        int r113 = 0;
        if (r112 != null) goto L25;
        int r114 = 0;
    L26:
        int r115 = (r111 + r114) * 31;
        Float r116 = this.f353095n;
        if (r116 == null) goto L31;
        r113 = r116.hashCode();
    L31:
        return r115 + r113;
    L25:
        r114 = r112.hashCode();
        goto L26
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceChatSpeakerUiState(showRecordButton=" + this.f353082a + ", status=" + this.f353083b + ", visualStyle=" + this.f353084c + ", holdToRecordText=" + this.f353085d + ", normalTipText=" + this.f353086e + ", cancelTipText=" + this.f353087f + ", cancelIsRed=" + this.f353088g + ", recordingSessionKey=" + this.f353089h + ", isDarkOrImmerseMode=" + this.f353090i + ", springUIMode=" + this.f353091j + ", forceHideShadow=" + this.f353092k + ", waveFrame=" + this.f353093l + ", highlightXRatio=" + this.f353094m + ", highlightYRatio=" + this.f353095n + ')';
    }

    public final boolean b() {
        VoiceChatSpeakerStatus r100 = this.f353083b;
        if (r100 != VoiceChatSpeakerStatus.RECORDING) goto L5;
    L8:
        return true;
    L5:
        if (r100 == VoiceChatSpeakerStatus.CANCEL) goto L8;
        return false;
    }

    public /* synthetic */ f0(boolean r210, VoiceChatSpeakerStatus r211, VoiceChatSpeakerVisualStyle r212, String r213, String r214, String r215, boolean r216, h0 r217, int r218) {
        if ((r218 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r218 & 2) == 0) goto L9;
        VoiceChatSpeakerStatus r101 = VoiceChatSpeakerStatus.NORMAL;
    L11:
        if ((r218 & 4) == 0) goto L13;
        VoiceChatSpeakerVisualStyle r102 = VoiceChatSpeakerVisualStyle.BLUR;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r218 & 64) == 0) goto L29;
        boolean r110 = true;
    L31:
        if ((r218 & 2048) == 0) goto L33;
        h0 r111 = new h0(0.0f, null, 0, 15);
    L34:
        this(r100, r101, r102, r103, r104, r105, r110, 0, false, false, false, r111, null, null);
        return;
    L33:
        r111 = r217;
        goto L34
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

    public static f0 a(f0 r110, boolean r210, VoiceChatSpeakerStatus r211, VoiceChatSpeakerVisualStyle r212, String r213, String r214, String r215, long r216, boolean r217, h0 r218, Float r310, Float r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        boolean r100 = r110.f353082a;
    L7:
        if ((r312 & 2) == 0) goto L9;
        VoiceChatSpeakerStatus r101 = r110.f353083b;
    L11:
        if ((r312 & 4) == 0) goto L13;
        VoiceChatSpeakerVisualStyle r102 = r110.f353084c;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.f353085d;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.f353086e;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.f353087f;
    L27:
        if ((r312 & 64) == 0) goto L29;
        boolean r111 = r110.f353088g;
    L31:
        if ((r312 & 128) == 0) goto L33;
        long r112 = r110.f353089h;
    L35:
        if ((r312 & 256) == 0) goto L37;
        boolean r113 = r110.f353090i;
    L39:
        if ((r312 & 512) == 0) goto L41;
        boolean r114 = r110.f353091j;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        boolean r115 = r110.f353092k;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        h0 r106 = r110.f353093l;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        Float r116 = r110.f353094m;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        Float r117 = r110.f353095n;
    L58:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, "visualStyle");
        Intrinsics.checkNotNullParameter(r103, "holdToRecordText");
        Intrinsics.checkNotNullParameter(r104, "normalTipText");
        Intrinsics.checkNotNullParameter(r105, "cancelTipText");
        Intrinsics.checkNotNullParameter(r106, "waveFrame");
        return new f0(r100, r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r106, r116, r117);
    L57:
        r117 = r311;
        goto L58
    L53:
        r116 = r310;
        goto L55
    L49:
        r106 = r218;
        goto L51
    L45:
        r115 = false;
        goto L47
    L41:
        r114 = false;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r111 = false;
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

    public f0(boolean r100, VoiceChatSpeakerStatus r110, VoiceChatSpeakerVisualStyle r111, String r112, String r113, String r114, boolean r115, long r116, boolean r117, boolean r118, boolean r210, h0 r211, Float r212, Float r213) {
        Intrinsics.checkNotNullParameter(r110, "status");
        Intrinsics.checkNotNullParameter(r111, "visualStyle");
        Intrinsics.checkNotNullParameter(r112, "holdToRecordText");
        Intrinsics.checkNotNullParameter(r113, "normalTipText");
        Intrinsics.checkNotNullParameter(r114, "cancelTipText");
        Intrinsics.checkNotNullParameter(r211, "waveFrame");
        this.f353082a = r100;
        this.f353083b = r110;
        this.f353084c = r111;
        this.f353085d = r112;
        this.f353086e = r113;
        this.f353087f = r114;
        this.f353088g = r115;
        this.f353089h = r116;
        this.f353090i = r117;
        this.f353091j = r118;
        this.f353092k = r210;
        this.f353093l = r211;
        this.f353094m = r212;
        this.f353095n = r213;
    }
}
