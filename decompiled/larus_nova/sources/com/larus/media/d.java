package com.larus.media;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayScenario f359011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f359012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f359013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f359014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f359015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p0 f359016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f359017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f359018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f359019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f359020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f359021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f359022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f359023m;

    public d() {
        this(null, 0, 0, 0, null, 0, false, false, false, false, false, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f359011a == r101.f359011a) goto L12;
        return false;
    L12:
        if (this.f359012b == r101.f359012b) goto L15;
        return false;
    L15:
        if (this.f359013c == r101.f359013c) goto L18;
        return false;
    L18:
        if (this.f359014d == r101.f359014d) goto L21;
        return false;
    L21:
        if (this.f359015e == r101.f359015e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f359016f, r101.f359016f) == true) goto L27;
        return false;
    L27:
        if (this.f359017g == r101.f359017g) goto L30;
        return false;
    L30:
        if (this.f359018h == r101.f359018h) goto L33;
        return false;
    L33:
        if (this.f359019i == r101.f359019i) goto L36;
        return false;
    L36:
        if (this.f359020j == r101.f359020j) goto L39;
        return false;
    L39:
        if (this.f359021k == r101.f359021k) goto L42;
        return false;
    L42:
        if (this.f359022l == r101.f359022l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f359023m, r101.f359023m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f359011a.hashCode() * 31) + this.f359012b) * 31) + this.f359013c) * 31) + this.f359014d) * 31) + this.f359015e) * 31) + this.f359016f.hashCode()) * 31) + this.f359017g) * 31;
        int r101 = 1231;
        if (this.f359018h == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f359019i == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f359020j == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f359021k == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f359022l == true) goto L22;
        r101 = 1237;
    L22:
        int r110 = (r109 + r101) * 31;
        Context r111 = this.f359023m;
        if (r111 != null) goto L25;
        int r112 = 0;
    L27:
        return r110 + r112;
    L25:
        r112 = r111.hashCode();
        goto L27
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
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioPlayerConfig(playScenario=" + this.f359011a + ", sampleRate=" + this.f359012b + ", sourceSampleRate=" + this.f359013c + ", channelConfig=" + this.f359014d + ", audioFormat=" + this.f359015e + ", stereoPlayoutGainConfig=" + this.f359016f + ", writeFrameDurationMs=" + this.f359017g + ", enableResampleToOutputRate=" + this.f359018h + ", enableLowLatency=" + this.f359019i + ", fillSilentWhenIdle=" + this.f359020j + ", enableLowWatermarkSilencePlayout=" + this.f359021k + ", enableTrace=" + this.f359022l + ", context=" + this.f359023m + ')';
    }

    public final Context getContext() {
        return this.f359023m;
    }

    public /* synthetic */ d(PlayScenario r110, int r111, int r112, int r210, p0 r211, int r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, Context r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        PlayScenario r100 = PlayScenario.MEDIA;
    L7:
        if ((r219 & 2) == 0) goto L9;
        int r101 = 48000;
    L11:
        if ((r219 & 4) == 0) goto L13;
        int r102 = r101;
    L15:
        if ((r219 & 8) == 0) goto L17;
        int r103 = 4;
    L19:
        if ((r219 & 16) == 0) goto L21;
        int r104 = 2;
    L23:
        if ((r219 & 32) == 0) goto L25;
        p0 r105 = new p0(0);
    L27:
        if ((r219 & 64) == 0) goto L29;
        int r106 = 20;
    L31:
        if ((r219 & 128) == 0) goto L33;
        boolean r113 = true;
    L35:
        if ((r219 & 256) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((r219 & 512) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        boolean r116 = false;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        boolean r117 = false;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        Context r118 = null;
    L54:
        this(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r118);
        return;
    L53:
        r118 = r218;
        goto L54
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r113 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r112;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public d(PlayScenario r100, int r101, int r102, int r103, int r104, p0 r105, int r106, boolean r107, boolean r110, boolean r111, boolean r112, boolean r113, Context r114) {
        Intrinsics.checkNotNullParameter(r100, "playScenario");
        Intrinsics.checkNotNullParameter(r105, "stereoPlayoutGainConfig");
        this.f359011a = r100;
        this.f359012b = r101;
        this.f359013c = r102;
        this.f359014d = r103;
        this.f359015e = r104;
        this.f359016f = r105;
        this.f359017g = r106;
        this.f359018h = r107;
        this.f359019i = r110;
        this.f359020j = r111;
        this.f359021k = r112;
        this.f359022l = r113;
        this.f359023m = r114;
    }
}
