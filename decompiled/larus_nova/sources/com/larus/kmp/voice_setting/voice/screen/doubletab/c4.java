package com.larus.kmp.voice_setting.voice.screen.doubletab;

/* JADX INFO: loaded from: classes30.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f354228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f354229b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c4) == true) goto L8;
        return false;
    L8:
        c4 r101 = (c4) r100;
        if (Float.compare(this.f354228a, r101.f354228a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f354229b, r101.f354229b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f354228a) * 31) + Float.floatToIntBits(this.f354229b);
    }

    public final String toString() {
        return "TabIndicatorSpec(left=" + this.f354228a + ", width=" + this.f354229b + ')';
    }

    public c4(float r100, float r101) {
        this.f354228a = r100;
        this.f354229b = r101;
    }
}
