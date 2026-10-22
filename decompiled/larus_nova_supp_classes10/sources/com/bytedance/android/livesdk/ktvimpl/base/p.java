package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public long m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;

    public static final class a {
    }

    static {
    }

    public p() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L48;
        p r7 = (p) r6;
        if (Float.compare(this.a, r7.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r7.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r7.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r7.d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r7.e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r7.f) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.g, r7.g) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.h, r7.h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.i, r7.i) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.j, r7.j) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(this.k, r7.k) == 0) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L32;
        return false;
    L32:
        if (Float.compare(this.n, r7.n) == 0) goto L34;
        return false;
    L34:
        if (Float.compare(this.o, r7.o) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.p, r7.p) == 0) goto L38;
        return false;
    L38:
        if (Float.compare(this.q, r7.q) == 0) goto L40;
        return false;
    L40:
        if (Float.compare(this.r, r7.r) == 0) goto L42;
        return false;
    L42:
        if (Float.compare(this.s, r7.s) == 0) goto L44;
        return false;
    L44:
        if (Float.compare(this.t, r7.t) == 0) goto L46;
        return false;
    L46:
        if (Float.compare(this.u, r7.u) == 0) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k)) * 31) + this.l) * 31;
        long r1 = this.m;
        return ((((((((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + Float.floatToIntBits(this.n)) * 31) + Float.floatToIntBits(this.o)) * 31) + Float.floatToIntBits(this.p)) * 31) + Float.floatToIntBits(this.q)) * 31) + Float.floatToIntBits(this.r)) * 31) + Float.floatToIntBits(this.s)) * 31) + Float.floatToIntBits(this.t)) * 31) + Float.floatToIntBits(this.u);
    }

    public final String toString() {
        return "RealTimeInfoModel(pitchSentenceScore=" + this.a + ", pitchSongScore=" + this.b + ", userPitch1=" + this.c + ", userPitch2=" + this.d + ", reserved4=" + this.e + ", reserved5=" + this.f + ", reserved6=" + this.g + ", refPitch1=" + this.h + ", refPitch2=" + this.i + ", reserved9=" + this.j + ", reserved10=" + this.k + ", sentenceId=" + this.l + ", currentPositionMs=" + this.m + ", emotionSentenceScore=" + this.n + ", emotionSongScore=" + this.o + ", rhythmSentenceScore=" + this.p + ", rhythmSongScore=" + this.q + ", breathSentenceScore=" + this.r + ", breathSongScore=" + this.s + ", vibratoSentenceScore=" + this.t + ", vibratoSongScore=" + this.u + ')';
    }

    public p(int r3) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
    }

    public final void a(double[] r3) {
        Intrinsics.checkNotNullParameter(r3, "scoreInfo");
        this.a = (float) r3[0];
        this.b = (float) r3[1];
        this.c = (float) r3[2];
        this.d = (float) r3[3];
        this.e = (float) r3[4];
        this.f = (float) r3[5];
        this.g = (float) r3[6];
        this.h = (float) r3[7];
        this.i = (float) r3[8];
        this.j = (float) r3[9];
        this.k = (float) r3[10];
        this.l = (int) r3[11];
        this.m = (long) r3[12];
        this.n = (float) r3[13];
        this.o = (float) r3[14];
        this.p = (float) r3[15];
        this.q = (float) r3[16];
        this.r = (float) r3[17];
        this.s = (float) r3[18];
        this.t = (float) r3[19];
        this.u = (float) r3[20];
    }
}
