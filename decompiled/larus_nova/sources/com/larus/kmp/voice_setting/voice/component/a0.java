package com.larus.kmp.voice_setting.voice.component;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeakerVoice f352141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f352143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f352144d;

    public a0() {
        this(null, null, false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f352141a, r101.f352141a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352142b, r101.f352142b) == true) goto L15;
        return false;
    L15:
        if (this.f352143c == r101.f352143c) goto L18;
        return false;
    L18:
        if (this.f352144d == r101.f352144d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r100 = this.f352141a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f352142b.hashCode()) * 31;
        int r103 = 1231;
        if (this.f352143c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f352144d == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDeleteDialogArgsData(voice=" + this.f352141a + ", enterFrom=" + this.f352142b + ", isUploadSuccess=" + this.f352143c + ", isFromTts=" + this.f352144d + ')';
    }

    public a0(SpeakerVoice r100, String r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        boolean r104 = true;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = false;
    L15:
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f352141a = r100;
        this.f352142b = r101;
        this.f352143c = r104;
        this.f352144d = r102;
        return;
    L11:
        r104 = false;
        goto L13
    }
}
