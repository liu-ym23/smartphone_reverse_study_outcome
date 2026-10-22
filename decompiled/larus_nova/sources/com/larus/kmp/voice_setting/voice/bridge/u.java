package com.larus.kmp.voice_setting.voice.bridge;

/* JADX INFO: loaded from: classes30.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f351907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f351908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f351909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f351910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f351911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f351912f;

    public u() {
        this(false, false, false, false, 0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f351907a == r101.f351907a) goto L12;
        return false;
    L12:
        if (this.f351908b == r101.f351908b) goto L15;
        return false;
    L15:
        if (this.f351909c == r101.f351909c) goto L18;
        return false;
    L18:
        if (this.f351910d == r101.f351910d) goto L21;
        return false;
    L21:
        if (this.f351911e == r101.f351911e) goto L24;
        return false;
    L24:
        if (this.f351912f == r101.f351912f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f351907a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f351908b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f351909c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f351910d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.f351911e) * 31;
        if (this.f351912f == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceSelectModeSettingsData(newStyleEnable=" + this.f351907a + ", singleVoiceMode=" + this.f351908b + ", voiceCanEdit=" + this.f351909c + ", multiVoiceMixMode=" + this.f351910d + ", selectVoiceMode=" + this.f351911e + ", showSelectedVoicesOnTop=" + this.f351912f + ')';
    }

    public u(boolean r100, boolean r101, boolean r102, boolean r103, int r104, boolean r105) {
        this.f351907a = r100;
        this.f351908b = r101;
        this.f351909c = r102;
        this.f351910d = r103;
        this.f351911e = r104;
        this.f351912f = r105;
    }
}
