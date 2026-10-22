package com.ss.android.lark.voiceinput.impl.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f445128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f445129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f445130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f445131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f445132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f445133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f445134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f445135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f445136i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f445128a == r101.f445128a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f445129b, r101.f445129b) == 0) goto L15;
        return false;
    L15:
        if (this.f445130c == r101.f445130c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f445131d, r101.f445131d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f445132e, r101.f445132e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f445133f, r101.f445133f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f445134g, r101.f445134g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f445135h, r101.f445135h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f445136i, r101.f445136i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f445128a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + Float.floatToIntBits(this.f445129b)) * 31;
        if (this.f445130c == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        Integer r104 = this.f445131d;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f445132e;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f445133f;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f445134g;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f445135h;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.f445136i;
        if (r120 == null) goto L35;
        r105 = r120.hashCode();
    L35:
        return r119 + r105;
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceButtonStyle(enableTextMode=" + this.f445128a + ", textSizeSp=" + this.f445129b + ", isTextBold=" + this.f445130c + ", buttonHeightPx=" + this.f445131d + ", buttonHorizontalPaddingPx=" + this.f445132e + ", buttonVerticalPaddingPx=" + this.f445133f + ", buttonTopMarginPx=" + this.f445134g + ", buttonCornerRadiusPx=" + this.f445135h + ", backgroundColorArgb=" + this.f445136i + ')';
    }

    public a(boolean r100, float r101, boolean r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107, Integer r108) {
        this.f445128a = r100;
        this.f445129b = r101;
        this.f445130c = r102;
        this.f445131d = r103;
        this.f445132e = r104;
        this.f445133f = r105;
        this.f445134g = r106;
        this.f445135h = r107;
        this.f445136i = r108;
    }
}
