package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceDialogActionKind f352176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f352178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f352182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f352183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f352184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f352185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f352186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f352187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f352188o;

    public c0() {
        this(0, 0, null, null, false, null, null, null, null, 0.0f, 0.0f, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.f352174a == r101.f352174a) goto L12;
        return false;
    L12:
        if (this.f352175b == r101.f352175b) goto L15;
        return false;
    L15:
        if (this.f352176c == r101.f352176c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352177d, r101.f352177d) == true) goto L21;
        return false;
    L21:
        if (this.f352178e == r101.f352178e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352179f, r101.f352179f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352180g, r101.f352180g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352181h, r101.f352181h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352182i, r101.f352182i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352183j, r101.f352183j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352184k, r101.f352184k) == true) goto L42;
        return false;
    L42:
        if (Float.compare(this.f352185l, r101.f352185l) == 0) goto L45;
        return false;
    L45:
        if (Float.compare(this.f352186m, r101.f352186m) == 0) goto L48;
        return false;
    L48:
        if (Float.compare(this.f352187n, r101.f352187n) == 0) goto L51;
        return false;
    L51:
        if (Float.compare(this.f352188o, r101.f352188o) == 0) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352174a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f352175b;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f352176c.hashCode()) * 31) + this.f352177d.hashCode()) * 31;
        if (this.f352178e == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f352179f;
        int r107 = 0;
        if (r106 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f352180g;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f352181h;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f352182i;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f352183j;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        int r121 = (r118 + r120) * 31;
        Object r122 = this.f352184k;
        if (r122 == null) goto L31;
        r107 = r122.hashCode();
    L31:
        return ((((((((r121 + r107) * 31) + Float.floatToIntBits(this.f352185l)) * 31) + Float.floatToIntBits(this.f352186m)) * 31) + Float.floatToIntBits(this.f352187n)) * 31) + Float.floatToIntBits(this.f352188o);
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = r116.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r106.hashCode();
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceDialogActionData(token=" + this.f352174a + ", requestToken=" + this.f352175b + ", kind=" + this.f352176c + ", text=" + this.f352177d + ", boolValue=" + this.f352178e + ", voiceId=" + this.f352179f + ", filePath=" + this.f352180g + ", freeTalkContent=" + this.f352181h + ", avatarUri=" + this.f352182i + ", avatarUrl=" + this.f352183j + ", platformValue=" + this.f352184k + ", globalActionX=" + this.f352185l + ", globalActionY=" + this.f352186m + ", deltaX=" + this.f352187n + ", deltaY=" + this.f352188o + ')';
    }

    public c0(long r110, long r111, VoiceDialogActionKind r210, String r211, boolean r212, String r213, String r214, String r215, String r216, float r217, float r218, int r310) {
        long r100 = 0;
        if ((r310 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r310 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r310 & 4) == 0) goto L13;
        VoiceDialogActionKind r102 = VoiceDialogActionKind.NONE;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r310 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r310 & 64) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r310 & 128) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r310 & 256) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r310 & 512) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 2048) == 0) goto L41;
        float r115 = 0.0f;
    L43:
        if ((r310 & 4096) == 0) goto L45;
        float r106 = 0.0f;
    L46:
        Intrinsics.checkNotNullParameter(r102, "kind");
        Intrinsics.checkNotNullParameter(r103, "text");
        this.f352174a = r101;
        this.f352175b = r100;
        this.f352176c = r102;
        this.f352177d = r103;
        this.f352178e = r104;
        this.f352179f = null;
        this.f352180g = r105;
        this.f352181h = r112;
        this.f352182i = r113;
        this.f352183j = r114;
        this.f352184k = null;
        this.f352185l = r115;
        this.f352186m = r106;
        this.f352187n = 0.0f;
        this.f352188o = 0.0f;
        return;
    L45:
        r106 = r218;
        goto L46
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
        r112 = r214;
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
    L5:
        r101 = r110;
        goto L7
    }
}
