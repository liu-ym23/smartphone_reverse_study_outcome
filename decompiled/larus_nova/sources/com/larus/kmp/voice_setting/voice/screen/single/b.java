package com.larus.kmp.voice_setting.voice.screen.single;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f354871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpeakerVoice> f354872b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f354871a, r101.f354871a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354872b, r101.f354872b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f354871a.hashCode() * 31) + this.f354872b.hashCode();
    }

    public final String toString() {
        return "ChatSpeakerVoiceGroup(language=" + this.f354871a + ", speakerVoices=" + this.f354872b + ')';
    }

    public b(String r100, List<SpeakerVoice> r101) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, "speakerVoices");
        this.f354871a = r100;
        this.f354872b = r101;
    }
}
