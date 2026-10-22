package com.larus.kmp.voice_setting.voice.component;

import com.larus.kmp.voice_setting.voice.mix.VoiceMixPlayVisualState;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s4 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceEditMode f352529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f352530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f352531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceEditAreaLayoutMode f352532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f352533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f352534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f352535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f352536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f352537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e6 f352538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.editvoice.f f352539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r4 f352540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f352541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VoiceMixPlayVisualState f352542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.editvoice.b f352543o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.q0 f352544p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final q4 f352545q;

    public s4() {
        this(null, false, false, null, false, false, false, false, 0, null, null, null, 0, null, null, null, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s4) == true) goto L8;
        return false;
    L8:
        s4 r101 = (s4) r100;
        if (this.f352529a == r101.f352529a) goto L12;
        return false;
    L12:
        if (this.f352530b == r101.f352530b) goto L15;
        return false;
    L15:
        if (this.f352531c == r101.f352531c) goto L18;
        return false;
    L18:
        if (this.f352532d == r101.f352532d) goto L21;
        return false;
    L21:
        if (this.f352533e == r101.f352533e) goto L24;
        return false;
    L24:
        if (this.f352534f == r101.f352534f) goto L27;
        return false;
    L27:
        if (this.f352535g == r101.f352535g) goto L30;
        return false;
    L30:
        if (this.f352536h == r101.f352536h) goto L33;
        return false;
    L33:
        if (this.f352537i == r101.f352537i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352538j, r101.f352538j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352539k, r101.f352539k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f352540l, r101.f352540l) == true) goto L45;
        return false;
    L45:
        if (this.f352541m == r101.f352541m) goto L48;
        return false;
    L48:
        if (this.f352542n == r101.f352542n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f352543o, r101.f352543o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f352544p, r101.f352544p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f352545q, r101.f352545q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352529a.hashCode() * 31;
        int r101 = 1231;
        if (this.f352530b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f352531c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f352532d.hashCode()) * 31;
        if (this.f352533e == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f352534f == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f352535g == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f352536h == true) goto L26;
        r101 = 1237;
    L26:
        long r112 = this.f352537i;
        int r113 = (((((((((((((r111 + r101) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.f352538j.hashCode()) * 31) + this.f352539k.hashCode()) * 31) + this.f352540l.hashCode()) * 31) + this.f352541m) * 31) + this.f352542n.hashCode()) * 31;
        com.larus.kmp.voice_setting.voice.editvoice.b r114 = this.f352543o;
        int r115 = 0;
        if (r114 != null) goto L29;
        int r116 = 0;
    L30:
        int r117 = (r113 + r116) * 31;
        com.larus.kmp.voice_setting.platform.q0 r118 = this.f352544p;
        if (r118 == null) goto L35;
        r115 = r118.hashCode();
    L35:
        return ((r117 + r115) * 31) + this.f352545q.hashCode();
    L29:
        r116 = r114.hashCode();
        goto L30
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceEditAreaStateData(mode=" + this.f352529a + ", visible=" + this.f352530b + ", hasVoiceContent=" + this.f352531c + ", layoutMode=" + this.f352532d + ", controlsVisible=" + this.f352533e + ", collapseEnabled=" + this.f352534f + ", gestureExpandEnabled=" + this.f352535g + ", isEditAreaCollapsed=" + this.f352536h + ", expandRequestToken=" + this.f352537i + ", selection=" + this.f352538j + ", pitchAndRate=" + this.f352539k + ", labels=" + this.f352540l + ", mixVoiceCount=" + this.f352541m + ", playState=" + this.f352542n + ", mixPreviewRequest=" + this.f352543o + ", previewPlaybackRequest=" + this.f352544p + ", lastAction=" + this.f352545q + ')';
    }

    public final boolean d() {
        if (this.f352530b == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f352529a == VoiceEditMode.NONE) goto L7;
        return true;
    }

    public final boolean b() {
        if (d() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f352531c == false) goto L9;
        if (this.f352534f == false) goto L9;
        return true;
    }

    public final boolean c() {
        if (d() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f352531c == false) goto L9;
        if (this.f352533e == false) goto L9;
        return true;
    }

    public static s4 a(s4 r210, VoiceEditMode r211, boolean r212, boolean r213, VoiceEditAreaLayoutMode r214, boolean r215, e6 r216, com.larus.kmp.voice_setting.voice.editvoice.f r217, r4 r310, int r311, VoiceMixPlayVisualState r312, q4 r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        VoiceEditMode r100 = r210.f352529a;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r101 = r210.f352530b;
    L11:
        if ((r314 & 4) == 0) goto L13;
        boolean r102 = r210.f352531c;
    L15:
        if ((r314 & 8) == 0) goto L17;
        VoiceEditAreaLayoutMode r103 = r210.f352532d;
    L19:
        if ((r314 & 16) == 0) goto L21;
        boolean r104 = r210.f352533e;
    L23:
        if ((r314 & 32) == 0) goto L25;
        boolean r105 = r210.f352534f;
    L27:
        if ((r314 & 64) == 0) goto L29;
        boolean r110 = r210.f352535g;
    L31:
        if ((r314 & 128) == 0) goto L33;
        boolean r111 = r210.f352536h;
    L35:
        if ((r314 & 256) == 0) goto L37;
        long r106 = r210.f352537i;
    L38:
        long r112 = r106;
        if ((r314 & 512) == 0) goto L41;
        e6 r113 = r210.f352538j;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        com.larus.kmp.voice_setting.voice.editvoice.f r114 = r210.f352539k;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        r4 r107 = r210.f352540l;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r115 = r210.f352541m;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        VoiceMixPlayVisualState r108 = r210.f352542n;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        com.larus.kmp.voice_setting.voice.editvoice.b r116 = r210.f352543o;
    L63:
        if ((32768 & r314) == 0) goto L65;
        com.larus.kmp.voice_setting.platform.q0 r218 = r210.f352544p;
    L67:
        if ((r314 & 65536) == 0) goto L69;
        q4 r109 = r210.f352545q;
    L70:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r103, "layoutMode");
        Intrinsics.checkNotNullParameter(r113, "selection");
        Intrinsics.checkNotNullParameter(r114, "pitchAndRate");
        Intrinsics.checkNotNullParameter(r107, "labels");
        Intrinsics.checkNotNullParameter(r108, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r109, "lastAction");
        return new s4(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r107, r115, r108, r116, r218, r109);
    L69:
        r109 = r313;
        goto L70
    L65:
        r218 = null;
        goto L67
    L61:
        r116 = null;
        goto L63
    L57:
        r108 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r107 = r310;
        goto L51
    L45:
        r114 = r217;
        goto L47
    L41:
        r113 = r216;
        goto L43
    L37:
        r106 = 0;
        goto L38
    L33:
        r111 = r215;
        goto L35
    L29:
        r110 = false;
        goto L31
    L25:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public /* synthetic */ s4(VoiceEditMode r310, boolean r311, boolean r312, VoiceEditAreaLayoutMode r313, boolean r314, boolean r315, boolean r316, boolean r317, long r318, e6 r410, com.larus.kmp.voice_setting.voice.editvoice.f r411, r4 r412, int r413, VoiceMixPlayVisualState r414, com.larus.kmp.voice_setting.voice.editvoice.b r415, com.larus.kmp.voice_setting.platform.q0 r416, int r417) {
        if ((r417 & 1) == 0) goto L5;
        VoiceEditMode r100 = VoiceEditMode.NONE;
    L7:
        if ((r417 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r417 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r417 & 8) == 0) goto L17;
        VoiceEditAreaLayoutMode r103 = VoiceEditAreaLayoutMode.LEGACY_MIX;
    L19:
        if ((r417 & 16) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r417 & 32) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r417 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r417 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r417 & 256) == 0) goto L37;
        long r111 = 0;
    L39:
        if ((r417 & 512) == 0) goto L41;
        e6 r112 = new e6(null, 31);
    L43:
        if ((r417 & 1024) == 0) goto L45;
        com.larus.kmp.voice_setting.voice.editvoice.f r113 = new com.larus.kmp.voice_setting.voice.editvoice.f(0);
    L47:
        if ((r417 & 2048) == 0) goto L49;
        r4 r114 = new r4(0);
    L51:
        if ((r417 & 4096) == 0) goto L53;
        int r115 = 0;
    L55:
        if ((r417 & 8192) == 0) goto L57;
        VoiceMixPlayVisualState r116 = VoiceMixPlayVisualState.Idle;
    L59:
        if ((r417 & 16384) == 0) goto L61;
        com.larus.kmp.voice_setting.voice.editvoice.b r117 = null;
    L63:
        if ((32768 & r417) == 0) goto L65;
        com.larus.kmp.voice_setting.platform.q0 r210 = null;
    L67:
        if ((r417 & 65536) == 0) goto L69;
        q4 r107 = new q4(null, 0, null, null, 0.0f, 0.0f, null, false, false, 1023);
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210, r107);
        return;
    L69:
        r107 = null;
        goto L70
    L65:
        r210 = r416;
        goto L67
    L61:
        r117 = r415;
        goto L63
    L57:
        r116 = r414;
        goto L59
    L53:
        r115 = r413;
        goto L55
    L49:
        r114 = r412;
        goto L51
    L45:
        r113 = r411;
        goto L47
    L41:
        r112 = r410;
        goto L43
    L37:
        r111 = r318;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public s4(VoiceEditMode r110, boolean r111, boolean r112, VoiceEditAreaLayoutMode r113, boolean r114, boolean r115, boolean r116, boolean r117, long r118, e6 r210, com.larus.kmp.voice_setting.voice.editvoice.f r211, r4 r212, int r213, VoiceMixPlayVisualState r214, com.larus.kmp.voice_setting.voice.editvoice.b r215, com.larus.kmp.voice_setting.platform.q0 r216, q4 r217) {
        Intrinsics.checkNotNullParameter(r110, "mode");
        Intrinsics.checkNotNullParameter(r113, "layoutMode");
        Intrinsics.checkNotNullParameter(r210, "selection");
        Intrinsics.checkNotNullParameter(r211, "pitchAndRate");
        Intrinsics.checkNotNullParameter(r212, "labels");
        Intrinsics.checkNotNullParameter(r214, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r217, "lastAction");
        this.f352529a = r110;
        this.f352530b = r111;
        this.f352531c = r112;
        this.f352532d = r113;
        this.f352533e = r114;
        this.f352534f = r115;
        this.f352535g = r116;
        this.f352536h = r117;
        this.f352537i = r118;
        this.f352538j = r210;
        this.f352539k = r211;
        this.f352540l = r212;
        this.f352541m = r213;
        this.f352542n = r214;
        this.f352543o = r215;
        this.f352544p = r216;
        this.f352545q = r217;
    }
}
