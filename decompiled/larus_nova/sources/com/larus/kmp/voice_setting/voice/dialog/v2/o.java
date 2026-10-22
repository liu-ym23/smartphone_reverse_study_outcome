package com.larus.kmp.voice_setting.voice.dialog.v2;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f353154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f353155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f353156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f353157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f353158e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Color.m4828equalsimpl0(this.f353154a, r101.f353154a) == true) goto L12;
        return false;
    L12:
        if (Color.m4828equalsimpl0(this.f353155b, r101.f353155b) == true) goto L15;
        return false;
    L15:
        if (Color.m4828equalsimpl0(this.f353156c, r101.f353156c) == true) goto L18;
        return false;
    L18:
        if (Color.m4828equalsimpl0(this.f353157d, r101.f353157d) == true) goto L21;
        return false;
    L21:
        if (Color.m4828equalsimpl0(this.f353158e, r101.f353158e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Color.m4834hashCodeimpl(this.f353154a) * 31) + Color.m4834hashCodeimpl(this.f353155b)) * 31) + Color.m4834hashCodeimpl(this.f353156c)) * 31) + Color.m4834hashCodeimpl(this.f353157d)) * 31) + Color.m4834hashCodeimpl(this.f353158e);
    }

    public final String toString() {
        return "VoiceChatSpeakerRenderColors(circleColor=" + Color.m4835toStringimpl(this.f353154a) + ", highlightColor=" + Color.m4835toStringimpl(this.f353155b) + ", fullShadowColor=" + Color.m4835toStringimpl(this.f353156c) + ", tipColor=" + Color.m4835toStringimpl(this.f353157d) + ", waveColor=" + Color.m4835toStringimpl(this.f353158e) + ')';
    }

    public o(long r100, long r101, long r102, long r103, long r104) {
        this.f353154a = r100;
        this.f353155b = r101;
        this.f353156c = r102;
        this.f353157d = r103;
        this.f353158e = r104;
    }
}
