package com.larus.kmp.voice_setting.voice.bridge;

/* JADX INFO: loaded from: classes30.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f351903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f351904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f351905c;

    public s() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f351903a == r101.f351903a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f351904b, r101.f351904b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f351905c, r101.f351905c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f351903a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + Float.floatToIntBits(this.f351904b)) * 31) + Float.floatToIntBits(this.f351905c);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceLazyListCacheWindowConfig(enabled=" + this.f351903a + ", aheadFraction=" + this.f351904b + ", behindFraction=" + this.f351905c + ')';
    }

    public /* synthetic */ s(int r100) {
        this(true, 1.0f, 0.5f);
    }

    public s(boolean r100, float r101, float r102) {
        this.f351903a = r100;
        this.f351904b = r101;
        this.f351905c = r102;
    }
}
