package com.larus.im.internal.audio.session.omni;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f347354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.media.a f347355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.media.p0 f347356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f347357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f347358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f347359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f347360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f347361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f347362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f347363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m0 f347364k;

    public q() {
        int r100 = com.larus.media.a.f358977k;
        this(null, com.larus.media.a.C4419a.c(), new com.larus.media.p0(0), 20, true, false, 20, false, false, false, new m0(0));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f347354a, r101.f347354a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347355b, r101.f347355b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f347356c, r101.f347356c) == true) goto L18;
        return false;
    L18:
        if (this.f347357d == r101.f347357d) goto L21;
        return false;
    L21:
        if (this.f347358e == r101.f347358e) goto L24;
        return false;
    L24:
        if (this.f347359f == r101.f347359f) goto L27;
        return false;
    L27:
        if (this.f347360g == r101.f347360g) goto L30;
        return false;
    L30:
        if (this.f347361h == r101.f347361h) goto L33;
        return false;
    L33:
        if (this.f347362i == r101.f347362i) goto L36;
        return false;
    L36:
        if (this.f347363j == r101.f347363j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f347364k, r101.f347364k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f347354a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.f347355b.hashCode()) * 31) + this.f347356c.hashCode()) * 31) + this.f347357d) * 31;
        int r103 = 1231;
        if (this.f347358e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f347359f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.f347360g) * 31;
        if (this.f347361h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f347362i == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f347363j == true) goto L27;
        r103 = 1237;
    L27:
        return ((r111 + r103) * 31) + this.f347364k.hashCode();
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OmniAudioEngineOptions(fixedRecordFrameMs=" + this.f347354a + ", initialAudioDeviceRuntimeConfig=" + this.f347355b + ", stereoPlayoutGainConfig=" + this.f347356c + ", audioPlayerWriteFrameDurationMs=" + this.f347357d + ", enableAudioPlayerResample=" + this.f347358e + ", enableAudioRecorderFixedReadFrameDuration=" + this.f347359f + ", audioRecorderReadFrameDurationMs=" + this.f347360g + ", enableAudioPlayerLowLatency=" + this.f347361h + ", enablePlayerFillSilentWhenIdle=" + this.f347362i + ", enableLowWatermarkSilencePlayout=" + this.f347363j + ", refSignalConfig=" + this.f347364k + ')';
    }

    public q(Integer r100, com.larus.media.a r101, com.larus.media.p0 r102, int r103, boolean r104, boolean r105, int r106, boolean r107, boolean r110, boolean r111, m0 r112) {
        Intrinsics.checkNotNullParameter(r101, "initialAudioDeviceRuntimeConfig");
        Intrinsics.checkNotNullParameter(r102, "stereoPlayoutGainConfig");
        Intrinsics.checkNotNullParameter(r112, "refSignalConfig");
        this.f347354a = r100;
        this.f347355b = r101;
        this.f347356c = r102;
        this.f347357d = r103;
        this.f347358e = r104;
        this.f347359f = r105;
        this.f347360g = r106;
        this.f347361h = r107;
        this.f347362i = r110;
        this.f347363j = r111;
        this.f347364k = r112;
    }
}
