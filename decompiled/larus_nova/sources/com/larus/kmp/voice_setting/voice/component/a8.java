package com.larus.kmp.voice_setting.voice.component;

import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceShellFeedbackKind f352152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceStringKey f352153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352154c;

    public a8() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a8) == true) goto L8;
        return false;
    L8:
        a8 r101 = (a8) r100;
        if (this.f352152a == r101.f352152a) goto L12;
        return false;
    L12:
        if (this.f352153b == r101.f352153b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352154c, r101.f352154c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352152a.hashCode() * 31;
        VoiceStringKey r101 = this.f352153b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f352154c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceShellFeedbackData(kind=" + this.f352152a + ", key=" + this.f352153b + ", message=" + this.f352154c + ')';
    }

    public a8(VoiceShellFeedbackKind r100, VoiceStringKey r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = VoiceShellFeedbackKind.SHOW;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f352152a = r100;
        this.f352153b = r101;
        this.f352154c = r102;
    }
}
