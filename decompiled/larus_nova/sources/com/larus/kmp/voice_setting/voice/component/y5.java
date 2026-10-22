package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f352644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f352645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f352646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f352648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f352649h;

    public y5() {
        this(0, 0, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y5) == true) goto L8;
        return false;
    L8:
        y5 r101 = (y5) r100;
        if (this.f352642a == r101.f352642a) goto L12;
        return false;
    L12:
        if (this.f352643b == r101.f352643b) goto L15;
        return false;
    L15:
        if (this.f352644c == r101.f352644c) goto L18;
        return false;
    L18:
        if (this.f352645d == r101.f352645d) goto L21;
        return false;
    L21:
        if (this.f352646e == r101.f352646e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352647f, r101.f352647f) == true) goto L27;
        return false;
    L27:
        if (this.f352648g == r101.f352648g) goto L30;
        return false;
    L30:
        if (this.f352649h == r101.f352649h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352642a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f352643b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f352644c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        int r106 = 1231;
        if (this.f352645d == false) goto L5;
        int r107 = 1231;
    L6:
        long r108 = this.f352646e;
        int r109 = (((((r105 + r107) * 31) + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.f352647f.hashCode()) * 31;
        long r110 = this.f352648g;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        if (this.f352649h == true) goto L11;
        r106 = 1237;
    L11:
        return r111 + r106;
    L5:
        r107 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceRecordSessionData(sessionToken=" + this.f352642a + ", pressStartMs=" + this.f352643b + ", recordStartMs=" + this.f352644c + ", mediaGranted=" + this.f352645d + ", timeoutToken=" + this.f352646e + ", logTraceId=" + this.f352647f + ", qualityValidateStartMs=" + this.f352648g + ", noiseValidateReported=" + this.f352649h + ')';
    }

    public /* synthetic */ y5(long r110, long r210, String r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r212 & 32) == 0) goto L13;
        String r111 = "";
    L14:
        this(r100, r101, 0, false, 0, r111, 0, false);
        return;
    L13:
        r111 = r211;
        goto L14
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static y5 a(y5 r210, long r211, boolean r212, long r213, long r214, boolean r215, int r310) {
        long r100 = 0;
        if ((r310 & 1) == 0) goto L5;
        long r101 = r210.f352642a;
    L7:
        if ((r310 & 2) == 0) goto L9;
        r100 = r210.f352643b;
    L9:
        long r110 = r100;
        if ((r310 & 4) == 0) goto L12;
        long r111 = r210.f352644c;
    L14:
        if ((r310 & 8) == 0) goto L16;
        boolean r112 = r210.f352645d;
    L18:
        if ((r310 & 16) == 0) goto L20;
        long r113 = r210.f352646e;
    L22:
        if ((r310 & 32) == 0) goto L24;
        String r102 = r210.f352647f;
    L26:
        if ((r310 & 64) == 0) goto L28;
        long r114 = r210.f352648g;
    L30:
        if ((r310 & 128) == 0) goto L32;
        boolean r216 = r210.f352649h;
    L33:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r102, "logTraceId");
        return new y5(r101, r110, r111, r112, r113, r102, r114, r216);
    L32:
        r216 = r215;
        goto L33
    L28:
        r114 = r214;
        goto L30
    L24:
        r102 = null;
        goto L26
    L20:
        r113 = r213;
        goto L22
    L16:
        r112 = r212;
        goto L18
    L12:
        r111 = r211;
        goto L14
    L5:
        r101 = 0;
        goto L7
    }

    public y5(long r100, long r101, long r102, boolean r103, long r104, String r110, long r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "logTraceId");
        this.f352642a = r100;
        this.f352643b = r101;
        this.f352644c = r102;
        this.f352645d = r103;
        this.f352646e = r104;
        this.f352647f = r110;
        this.f352648g = r111;
        this.f352649h = r112;
    }
}
