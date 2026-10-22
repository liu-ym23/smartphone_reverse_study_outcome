package com.larus.kmp.voice_setting.voice.mix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f353774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353775b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (this.f353774a == r101.f353774a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353775b, r101.f353775b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f353774a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f353775b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoicePlayButtonRenderState(showPlayIcon=" + this.f353774a + ", lottieAssetPath=" + this.f353775b + ')';
    }

    public b1(boolean r100, String r101) {
        this.f353774a = r100;
        this.f353775b = r101;
    }
}
