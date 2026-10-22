package com.larus.kmp.voice_setting.voice.dialog;

import com.larus.kmp.voice_setting.voice.component.VoiceDialogKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceDialogKind f352717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceDialogKind f352718c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f352716a == r101.f352716a) goto L12;
        return false;
    L12:
        if (this.f352717b == r101.f352717b) goto L15;
        return false;
    L15:
        if (this.f352718c == r101.f352718c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352716a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f352717b.hashCode()) * 31) + this.f352718c.hashCode();
    }

    public final String toString() {
        return "NameInputImeSessionKey(requestToken=" + this.f352716a + ", returnDialogKind=" + this.f352717b + ", backgroundDialogKind=" + this.f352718c + ')';
    }

    public c(long r100, VoiceDialogKind r101, VoiceDialogKind r102) {
        Intrinsics.checkNotNullParameter(r101, "returnDialogKind");
        Intrinsics.checkNotNullParameter(r102, "backgroundDialogKind");
        this.f352716a = r100;
        this.f352717b = r101;
        this.f352718c = r102;
    }
}
