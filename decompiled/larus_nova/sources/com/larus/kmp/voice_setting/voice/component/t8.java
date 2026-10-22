package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f352560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceListKind f352561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f352562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f352564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f352565h;

    public t8() {
        this(null, null, 0, null, 0, false, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t8) == true) goto L8;
        return false;
    L8:
        t8 r101 = (t8) r100;
        if (Intrinsics.areEqual(this.f352558a, r101.f352558a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352559b, r101.f352559b) == true) goto L15;
        return false;
    L15:
        if (this.f352560c == r101.f352560c) goto L18;
        return false;
    L18:
        if (this.f352561d == r101.f352561d) goto L21;
        return false;
    L21:
        if (this.f352562e == r101.f352562e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352563f, r101.f352563f) == true) goto L27;
        return false;
    L27:
        if (this.f352564g == r101.f352564g) goto L30;
        return false;
    L30:
        if (this.f352565h == r101.f352565h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f352558a.hashCode() * 31) + this.f352559b.hashCode()) * 31) + this.f352560c) * 31) + this.f352561d.hashCode()) * 31) + this.f352562e) * 31) + this.f352563f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f352564g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f352565h == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceTabPageStateData(tabKey=" + this.f352558a + ", title=" + this.f352559b + ", pageIndex=" + this.f352560c + ", listKind=" + this.f352561d + ", recommendType=" + this.f352562e + ", badgeText=" + this.f352563f + ", isSelected=" + this.f352564g + ", isVisible=" + this.f352565h + ')';
    }

    public t8(String r100, String r101, int r102, VoiceListKind r103, int r104, boolean r105, int r110) {
        String r106 = "";
        if ((r110 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r110 & 8) == 0) goto L14;
        r103 = VoiceListKind.UNSPECIFIED;
    L14:
        boolean r107 = false;
        if ((r110 & 16) == 0) goto L18;
        r104 = 0;
    L18:
        if ((r110 & 32) != 0) goto L22;
        r106 = null;
    L22:
        if ((r110 & 64) == 0) goto L25;
        r105 = false;
    L25:
        if ((r110 & 128) == 0) goto L27;
        r107 = true;
    L27:
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "listKind");
        Intrinsics.checkNotNullParameter(r106, "badgeText");
        this.f352558a = r100;
        this.f352559b = r101;
        this.f352560c = r102;
        this.f352561d = r103;
        this.f352562e = r104;
        this.f352563f = r106;
        this.f352564g = r105;
        this.f352565h = r107;
    }
}
