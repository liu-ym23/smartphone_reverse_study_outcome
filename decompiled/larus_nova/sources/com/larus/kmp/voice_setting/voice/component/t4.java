package com.larus.kmp.voice_setting.voice.component;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeakerVoice f352554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f352556c;

    public t4() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t4) == true) goto L8;
        return false;
    L8:
        t4 r101 = (t4) r100;
        if (Intrinsics.areEqual(this.f352554a, r101.f352554a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352555b, r101.f352555b) == true) goto L15;
        return false;
    L15:
        if (this.f352556c == r101.f352556c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r100 = this.f352554a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f352555b.hashCode()) * 31;
        if (this.f352556c == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceEditDialogArgsData(voice=" + this.f352554a + ", enterFrom=" + this.f352555b + ", isUploadSuccess=" + this.f352556c + ')';
    }

    public t4(SpeakerVoice r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r102 & 4) == 0) goto L11;
        boolean r103 = true;
    L12:
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f352554a = r100;
        this.f352555b = r101;
        this.f352556c = r103;
        return;
    L11:
        r103 = false;
        goto L12
    }
}
