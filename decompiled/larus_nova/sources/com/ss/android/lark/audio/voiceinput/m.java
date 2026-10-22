package com.ss.android.lark.audio.voiceinput;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f409269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f409270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f409272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f409273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VoiceInputSpeechScene f409274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f409275g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f409269a == r101.f409269a) goto L12;
        return false;
    L12:
        if (this.f409270b == r101.f409270b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409271c, r101.f409271c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409272d, r101.f409272d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409273e, r101.f409273e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f409274f, r101.f409274f) == true) goto L27;
        return false;
    L27:
        if (this.f409275g == r101.f409275g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f409269a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f409270b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f409271c;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f409272d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.f409273e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        VoiceInputSpeechScene r115 = this.f409274f;
        if (r115 == null) goto L26;
        r106 = r115.hashCode();
    L26:
        int r116 = (r114 + r106) * 31;
        if (this.f409275g == true) goto L31;
        r100 = 1237;
    L31:
        return r116 + r100;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceInputConfig(isAsrEnable=" + this.f409269a + ", isAsrNerEnable=" + this.f409270b + ", chatId=" + this.f409271c + ", psdaToken=" + this.f409272d + ", enableFormat=" + this.f409273e + ", speechScene=" + this.f409274f + ", enableMarkdown=" + this.f409275g + ')';
    }

    public m() {
        Boolean r100 = Boolean.TRUE;
        this.f409269a = true;
        this.f409270b = false;
        this.f409271c = null;
        this.f409272d = null;
        this.f409273e = r100;
        this.f409274f = null;
        this.f409275g = false;
    }
}
