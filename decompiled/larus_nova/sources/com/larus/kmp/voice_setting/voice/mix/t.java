package com.larus.kmp.voice_setting.voice.mix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f353920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f353921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f353922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f353923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f353924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f353925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f353926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f353927i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f353919a, r101.f353919a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f353920b, r101.f353920b) == 0) goto L15;
        return false;
    L15:
        if (this.f353921c == r101.f353921c) goto L18;
        return false;
    L18:
        if (this.f353922d == r101.f353922d) goto L21;
        return false;
    L21:
        if (this.f353923e == r101.f353923e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f353924f, r101.f353924f) == 0) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f353925g, r101.f353925g) == true) goto L30;
        return false;
    L30:
        if (this.f353926h == r101.f353926h) goto L33;
        return false;
    L33:
        if (this.f353927i == r101.f353927i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f353919a.hashCode() * 31) + Float.floatToIntBits(this.f353920b)) * 31) + this.f353921c) * 31) + this.f353922d) * 31) + this.f353923e) * 31) + Float.floatToIntBits(this.f353924f)) * 31) + this.f353925g.hashCode()) * 31;
        int r101 = 1231;
        if (this.f353926h == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f353927i == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceEditAreaSliderState(label=" + this.f353919a + ", value=" + this.f353920b + ", progress=" + this.f353921c + ", max=" + this.f353922d + ", decimals=" + this.f353923e + ", defaultValue=" + this.f353924f + ", defaultPrefix=" + this.f353925g + ", showDefaultPrefix=" + this.f353926h + ", isInteracting=" + this.f353927i + ')';
    }

    public static t a(t r110, float r111, int r112, boolean r113, boolean r114, int r115) {
        String r100 = null;
        if ((r115 & 1) == 0) goto L5;
        String r101 = r110.f353919a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        float r102 = r110.f353920b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        int r103 = r110.f353921c;
    L15:
        if ((r115 & 8) == 0) goto L17;
        int r104 = r110.f353922d;
    L19:
        if ((r115 & 16) == 0) goto L21;
        int r105 = r110.f353923e;
    L23:
        if ((r115 & 32) == 0) goto L25;
        float r116 = r110.f353924f;
    L27:
        if ((r115 & 64) == 0) goto L29;
        r100 = r110.f353925g;
    L29:
        String r117 = r100;
        if ((r115 & 128) == 0) goto L32;
        boolean r118 = r110.f353926h;
    L34:
        if ((r115 & 256) == 0) goto L36;
        boolean r119 = r110.f353927i;
    L37:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r117, "defaultPrefix");
        return new t(r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L36:
        r119 = r114;
        goto L37
    L32:
        r118 = r113;
        goto L34
    L25:
        r116 = 0.0f;
        goto L27
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = 0;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ t(String r110, float r111, int r112, int r113, int r114, float r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, true, false);
    }

    public t(String r100, float r101, int r102, int r103, int r104, float r105, String r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r106, "defaultPrefix");
        this.f353919a = r100;
        this.f353920b = r101;
        this.f353921c = r102;
        this.f353922d = r103;
        this.f353923e = r104;
        this.f353924f = r105;
        this.f353925g = r106;
        this.f353926h = r107;
        this.f353927i = r110;
    }
}
