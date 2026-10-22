package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceStringKey f354421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354422b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k4) == true) goto L8;
        return false;
    L8:
        k4 r101 = (k4) r100;
        if (this.f354421a == r101.f354421a) goto L12;
        return false;
    L12:
        if (this.f354422b == r101.f354422b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f354421a.hashCode() * 31;
        if (this.f354422b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceDoubleTabExitToast(key=" + this.f354421a + ", success=" + this.f354422b + ')';
    }

    public k4(VoiceStringKey r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f354421a = r100;
        this.f354422b = r101;
    }
}
