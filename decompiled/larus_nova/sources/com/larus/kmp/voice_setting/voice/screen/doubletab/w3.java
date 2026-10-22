package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class w3 implements t1a.f, m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f354755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f354756d;

    public w3() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w3) == true) goto L8;
        return false;
    L8:
        w3 r101 = (w3) r100;
        if (this.f354753a == r101.f354753a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354754b, r101.f354754b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354755c, r101.f354755c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f354756d, r101.f354756d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f354753a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + this.f354754b.hashCode()) * 31) + this.f354755c.hashCode()) * 31) + this.f354756d.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoubleTabTitleBarUiState(visible=" + this.f354753a + ", title=" + this.f354754b + ", leadingText=" + this.f354755c + ", trailingText=" + this.f354756d + ')';
    }

    public w3(String r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = "";
    L15:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "leadingText");
        Intrinsics.checkNotNullParameter(r102, "trailingText");
        this.f354753a = r104;
        this.f354754b = r100;
        this.f354755c = r101;
        this.f354756d = r102;
        return;
    L5:
        r104 = false;
        goto L7
    }
}
