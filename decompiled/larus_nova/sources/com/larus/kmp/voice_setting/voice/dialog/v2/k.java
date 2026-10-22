package com.larus.kmp.voice_setting.voice.dialog.v2;

/* JADX INFO: loaded from: classes30.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f353125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f353126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f353127c;

    public k() {
        this(false, 0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f353125a == r101.f353125a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f353126b, r101.f353126b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f353127c, r101.f353127c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f353125a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + Float.floatToIntBits(this.f353126b)) * 31) + Float.floatToIntBits(this.f353127c);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceChatSpeakerGestureData(cancelRequested=" + this.f353125a + ", xRatio=" + this.f353126b + ", yRatio=" + this.f353127c + ')';
    }

    public k(boolean r100, float r101, float r102) {
        this.f353125a = r100;
        this.f353126b = r101;
        this.f353127c = r102;
    }
}
