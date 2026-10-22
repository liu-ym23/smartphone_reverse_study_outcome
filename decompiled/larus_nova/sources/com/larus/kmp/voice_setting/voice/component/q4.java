package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceEditAreaActionKind f352473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f352476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f352478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f352479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f352481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f352482j;

    public q4() {
        this(null, 0, null, null, 0.0f, 0.0f, null, false, false, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q4) == true) goto L8;
        return false;
    L8:
        q4 r101 = (q4) r100;
        if (this.f352473a == r101.f352473a) goto L12;
        return false;
    L12:
        if (this.f352474b == r101.f352474b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352475c, r101.f352475c) == true) goto L18;
        return false;
    L18:
        if (this.f352476d == r101.f352476d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352477e, r101.f352477e) == true) goto L24;
        return false;
    L24:
        if (Float.compare(this.f352478f, r101.f352478f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f352479g, r101.f352479g) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352480h, r101.f352480h) == true) goto L33;
        return false;
    L33:
        if (this.f352481i == r101.f352481i) goto L36;
        return false;
    L36:
        if (this.f352482j == r101.f352482j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352473a.hashCode() * 31;
        long r101 = this.f352474b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f352475c;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        long r106 = this.f352476d;
        int r107 = (((((((((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f352477e.hashCode()) * 31) + Float.floatToIntBits(this.f352478f)) * 31) + Float.floatToIntBits(this.f352479g)) * 31;
        String r108 = this.f352480h;
        if (r108 == null) goto L10;
        r104 = r108.hashCode();
    L10:
        int r109 = (r107 + r104) * 31;
        int r110 = 1231;
        if (this.f352481i == false) goto L13;
        int r111 = 1231;
    L14:
        int r112 = (r109 + r111) * 31;
        if (this.f352482j == true) goto L19;
        r110 = 1237;
    L19:
        return r112 + r110;
    L13:
        r111 = 1237;
        goto L14
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceEditAreaActionMeta(kind=" + this.f352473a + ", token=" + this.f352474b + ", source=" + this.f352475c + ", vibrateDurationMs=" + this.f352476d + ", editResultScene=" + this.f352477e + ", editResultPitch=" + this.f352478f + ", editResultRate=" + this.f352479g + ", selectedVoiceId=" + this.f352480h + ", appBarCollapsed=" + this.f352481i + ", mixBarDefaultCollapsing=" + this.f352482j + ')';
    }

    public /* synthetic */ q4(VoiceEditAreaActionKind r110, long r111, String r112, String r210, float r211, float r212, String r213, boolean r214, boolean r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        VoiceEditAreaActionKind r100 = VoiceEditAreaActionKind.NONE;
    L6:
        long r101 = 0;
        if ((r216 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        r101 = 5;
    L17:
        long r104 = r101;
        if ((r216 & 16) == 0) goto L20;
        String r113 = "";
    L22:
        if ((r216 & 32) == 0) goto L24;
        float r114 = 0.0f;
    L26:
        if ((r216 & 64) == 0) goto L28;
        float r115 = 1.0f;
    L30:
        if ((r216 & 128) == 0) goto L32;
        String r116 = null;
    L34:
        if ((r216 & 256) == 0) goto L36;
        boolean r117 = false;
    L38:
        if ((r216 & 512) == 0) goto L40;
        boolean r105 = false;
    L41:
        this(r100, r102, r103, r104, r113, r114, r115, r116, r117, r105);
        return;
    L40:
        r105 = r215;
        goto L41
    L36:
        r117 = r214;
        goto L38
    L32:
        r116 = r213;
        goto L34
    L28:
        r115 = r212;
        goto L30
    L24:
        r114 = r211;
        goto L26
    L20:
        r113 = r210;
        goto L22
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }

    public q4(VoiceEditAreaActionKind r100, long r101, String r102, long r103, String r104, float r105, float r110, String r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r104, "editResultScene");
        this.f352473a = r100;
        this.f352474b = r101;
        this.f352475c = r102;
        this.f352476d = r103;
        this.f352477e = r104;
        this.f352478f = r105;
        this.f352479g = r110;
        this.f352480h = r111;
        this.f352481i = r112;
        this.f352482j = r113;
    }
}
