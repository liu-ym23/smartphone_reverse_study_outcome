package com.larus.kmp.voice_setting.voice.dialog;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f352704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f352705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f352706c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f352704a == r101.f352704a) goto L12;
        return false;
    L12:
        if (this.f352705b == r101.f352705b) goto L15;
        return false;
    L15:
        if (this.f352706c == r101.f352706c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352704a * 31;
        int r101 = 1231;
        if (this.f352705b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f352706c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "NameInputImeInsetState(appliedBottomPx=" + this.f352704a + ", contentVisible=" + this.f352705b + ", gateReady=" + this.f352706c + ')';
    }

    public b(int r100, boolean r101, boolean r102) {
        this.f352704a = r100;
        this.f352705b = r101;
        this.f352706c = r102;
    }
}
