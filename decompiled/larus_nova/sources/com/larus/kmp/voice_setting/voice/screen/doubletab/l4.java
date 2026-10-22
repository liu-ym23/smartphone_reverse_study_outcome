package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.editvoice.f f354457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f354459c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l4) == true) goto L8;
        return false;
    L8:
        l4 r101 = (l4) r100;
        if (Intrinsics.areEqual(this.f354457a, r101.f354457a) == true) goto L12;
        return false;
    L12:
        if (this.f354458b == r101.f354458b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354459c, r101.f354459c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f354457a.hashCode() * 31;
        if (this.f354458b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f354459c.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceDoubleTabImmediatePitchAndRate(pitchAndRate=" + this.f354457a + ", cacheHit=" + this.f354458b + ", source=" + this.f354459c + ')';
    }

    public l4(com.larus.kmp.voice_setting.voice.editvoice.f r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pitchAndRate");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f354457a = r100;
        this.f354458b = r101;
        this.f354459c = r102;
    }
}
