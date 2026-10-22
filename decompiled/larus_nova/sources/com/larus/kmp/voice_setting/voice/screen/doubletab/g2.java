package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f354319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f354321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f354322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f354323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f354324f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g2) == true) goto L8;
        return false;
    L8:
        g2 r101 = (g2) r100;
        if (Intrinsics.areEqual(this.f354319a, r101.f354319a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354320b, r101.f354320b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354321c, r101.f354321c) == true) goto L18;
        return false;
    L18:
        if (this.f354322d == r101.f354322d) goto L21;
        return false;
    L21:
        if (this.f354323e == r101.f354323e) goto L24;
        return false;
    L24:
        if (this.f354324f == r101.f354324f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f354319a.hashCode() * 31) + this.f354320b.hashCode()) * 31) + this.f354321c.hashCode()) * 31) + this.f354322d) * 31;
        int r101 = 1231;
        if (this.f354323e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f354324f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoubleTabRootShellTabUiState(tabKey=" + this.f354319a + ", title=" + this.f354320b + ", badgeText=" + this.f354321c + ", pageIndex=" + this.f354322d + ", isSelected=" + this.f354323e + ", isEnabled=" + this.f354324f + ')';
    }

    public g2(String r100, String r101, String r102, int r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "badgeText");
        this.f354319a = r100;
        this.f354320b = r101;
        this.f354321c = r102;
        this.f354322d = r103;
        this.f354323e = r104;
        this.f354324f = r105;
    }
}
