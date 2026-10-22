package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.MixVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MixVoice> f354196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354197b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a4) == true) goto L8;
        return false;
    L8:
        a4 r101 = (a4) r100;
        if (Intrinsics.areEqual(this.f354196a, r101.f354196a) == true) goto L12;
        return false;
    L12:
        if (this.f354197b == r101.f354197b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f354196a.hashCode() * 31;
        if (this.f354197b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "NormalizedInitialMixVoiceList(voiceList=" + this.f354196a + ", changed=" + this.f354197b + ')';
    }

    public a4(List<MixVoice> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceList");
        this.f354196a = r100;
        this.f354197b = r101;
    }
}
