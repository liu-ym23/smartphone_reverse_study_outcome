package com.larus.kmp.voice_setting.voice.screen.single;

/* JADX INFO: loaded from: classes30.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f354951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f354952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f354953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f354954d;

    public t0() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (this.f354951a == r101.f354951a) goto L12;
        return false;
    L12:
        if (this.f354952b == r101.f354952b) goto L15;
        return false;
    L15:
        if (this.f354953c == r101.f354953c) goto L18;
        return false;
    L18:
        if (this.f354954d == r101.f354954d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f354951a * 31) + this.f354952b) * 31) + this.f354953c) * 31) + this.f354954d;
    }

    public final String toString() {
        return "VoiceMenuAnchorBounds(left=" + this.f354951a + ", top=" + this.f354952b + ", width=" + this.f354953c + ", height=" + this.f354954d + ')';
    }

    public t0(int r100, int r101, int r102, int r103) {
        this.f354951a = r100;
        this.f354952b = r101;
        this.f354953c = r102;
        this.f354954d = r103;
    }
}
