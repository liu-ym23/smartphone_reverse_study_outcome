package com.larus.kmp.voice_setting.voice.mix;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceMixPlayVisualState f353916b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f353915a, r101.f353915a) == true) goto L12;
        return false;
    L12:
        if (this.f353916b == r101.f353916b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f353915a.hashCode() * 31) + this.f353916b.hashCode();
    }

    public final String toString() {
        return "VoiceEditAreaMixedPlayCtaState(text=" + this.f353915a + ", playState=" + this.f353916b + ')';
    }

    public s(String r100, VoiceMixPlayVisualState r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_STATE);
        this.f353915a = r100;
        this.f353916b = r101;
    }
}
