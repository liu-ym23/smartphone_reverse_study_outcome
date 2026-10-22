package com.larus.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecordSourceType f359082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f359083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f359084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f359085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f359086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f359087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f359088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f359089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f359090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f359091j;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f359082a == r101.f359082a) goto L12;
        return false;
    L12:
        if (this.f359083b == r101.f359083b) goto L15;
        return false;
    L15:
        if (this.f359084c == r101.f359084c) goto L18;
        return false;
    L18:
        if (this.f359085d == r101.f359085d) goto L21;
        return false;
    L21:
        if (this.f359086e == r101.f359086e) goto L24;
        return false;
    L24:
        if (this.f359087f == r101.f359087f) goto L27;
        return false;
    L27:
        if (this.f359088g == r101.f359088g) goto L30;
        return false;
    L30:
        if (this.f359089h == r101.f359089h) goto L33;
        return false;
    L33:
        if (this.f359090i == r101.f359090i) goto L36;
        return false;
    L36:
        if (this.f359091j == r101.f359091j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f359082a.hashCode() * 31) + this.f359083b) * 31) + this.f359084c) * 31) + this.f359085d) * 31;
        int r101 = 1231;
        if (this.f359086e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f359087f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f359088g == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f359089h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (((r107 + r108) * 31) + this.f359090i) * 31;
        if (this.f359091j == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
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
        return "AudioRecorderConfig(source=" + this.f359082a + ", sampleRate=" + this.f359083b + ", channel=" + this.f359084c + ", format=" + this.f359085d + ", enableHardwareAec=" + this.f359086e + ", enableHardwareNs=" + this.f359087f + ", enableHardwareAgc=" + this.f359088g + ", enableFixedReadFrameDuration=" + this.f359089h + ", readFrameDurationMs=" + this.f359090i + ", enableTrace=" + this.f359091j + ')';
    }

    public /* synthetic */ j(int r110) {
        this(RecordSourceType.MIC, 48000, 16, 2, false, false, false, false, 20, false);
    }

    public j(RecordSourceType r100, int r101, int r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f359082a = r100;
        this.f359083b = r101;
        this.f359084c = r102;
        this.f359085d = r103;
        this.f359086e = r104;
        this.f359087f = r105;
        this.f359088g = r106;
        this.f359089h = r107;
        this.f359090i = r110;
        this.f359091j = r111;
    }
}
