package com.larus.kmp.voice_setting.voice.editvoice;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f353262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f353263d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f353260a, r101.f353260a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353261b, r101.f353261b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353262c, r101.f353262c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353263d, r101.f353263d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f353260a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f353261b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f353262c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f353263d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoicePitchAndRateFirstVoice(voiceId=" + this.f353260a + ", voiceName=" + this.f353261b + ", pitchF64=" + this.f353262c + ", speechRateF64=" + this.f353263d + ')';
    }

    public h(String r100, String r101, Float r102, Float r103) {
        this.f353260a = r100;
        this.f353261b = r101;
        this.f353262c = r102;
        this.f353263d = r103;
    }
}
