package com.ss.android.lark.audio.voiceinput;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceInputMode f409282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceInputScene f409283b;

    public final boolean a() {
        if (this.f409282a.getInputMode() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean b() {
        if (this.f409282a.getInputMode() != 2) goto L5;
    L8:
        return true;
    L5:
        if (this.f409282a.getInputMode() == 3) goto L8;
        return false;
    }

    public final boolean c() {
        if (this.f409282a.getInputMode() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public p(VoiceInputMode r100, VoiceInputScene r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputMode");
        Intrinsics.checkNotNullParameter(r101, "voiceInputScene");
        this.f409282a = r100;
        this.f409283b = r101;
    }
}
