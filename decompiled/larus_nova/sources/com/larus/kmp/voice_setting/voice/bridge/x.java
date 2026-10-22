package com.larus.kmp.voice_setting.voice.bridge;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f351913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f351914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f351915c;

    public x() {
        this(false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f351913a == r101.f351913a) goto L12;
        return false;
    L12:
        if (this.f351914b == r101.f351914b) goto L15;
        return false;
    L15:
        if (this.f351915c == r101.f351915c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f351913a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f351914b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f351915c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceSettingConvenienceConfigData(expandByDefault=" + this.f351913a + ", sampleAutoPlay=" + this.f351914b + ", rememberSingleSample=" + this.f351915c + ')';
    }

    public x(boolean r100, boolean r101, boolean r102) {
        this.f351913a = r100;
        this.f351914b = r101;
        this.f351915c = r102;
    }
}
