package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f354451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f354453c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l1) == true) goto L8;
        return false;
    L8:
        l1 r101 = (l1) r100;
        if (this.f354451a == r101.f354451a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354452b, r101.f354452b) == true) goto L15;
        return false;
    L15:
        if (this.f354453c == r101.f354453c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f354451a * 31) + this.f354452b.hashCode()) * 31;
        if (this.f354453c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoubleTabLandingDecision(index=" + this.f354451a + ", reason=" + this.f354452b + ", landingMy=" + this.f354453c + ')';
    }

    public l1(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f354451a = r100;
        this.f354452b = r101;
        this.f354453c = r102;
    }
}
