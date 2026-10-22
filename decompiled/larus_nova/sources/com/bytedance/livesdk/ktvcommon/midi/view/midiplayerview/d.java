package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import com.bytedance.android.live.core.utils.rxutils.IoToUiTransformer;
import io.reactivex.t;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d {
    public final Pair<Integer, Integer> A;
    public final Pair<Integer, Integer> B;
    public final t<?, ?> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Long, Long> f256213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair<Long, Long> f256214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f256215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f256216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f256217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f256218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f256219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f256220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f256221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f256222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f256223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f256224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f256225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f256226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f256227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f256228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f256229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f256230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f256231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f256232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f256233u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f256234v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f256235w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Pair<Integer, Integer> f256236x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Pair<Integer, Integer> f256237y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Pair<Integer, Integer> f256238z;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L64;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f256213a, r101.f256213a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f256214b, r101.f256214b) == true) goto L10;
        return false;
    L10:
        if (this.f256215c == r101.f256215c) goto L12;
        return false;
    L12:
        if (this.f256216d == r101.f256216d) goto L14;
        return false;
    L14:
        if (Float.compare(this.f256217e, r101.f256217e) == 0) goto L16;
        return false;
    L16:
        if (this.f256218f == r101.f256218f) goto L18;
        return false;
    L18:
        if (this.f256219g == r101.f256219g) goto L20;
        return false;
    L20:
        if (this.f256220h == r101.f256220h) goto L22;
        return false;
    L22:
        if (this.f256221i == r101.f256221i) goto L24;
        return false;
    L24:
        if (this.f256222j == r101.f256222j) goto L26;
        return false;
    L26:
        if (this.f256223k == r101.f256223k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f256224l, r101.f256224l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f256225m, r101.f256225m) == true) goto L32;
        return false;
    L32:
        if (this.f256226n == r101.f256226n) goto L34;
        return false;
    L34:
        if (Float.compare(this.f256227o, r101.f256227o) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.f256228p, r101.f256228p) == 0) goto L38;
        return false;
    L38:
        if (Float.compare(this.f256229q, r101.f256229q) == 0) goto L40;
        return false;
    L40:
        if (Float.compare(this.f256230r, r101.f256230r) == 0) goto L42;
        return false;
    L42:
        if (this.f256231s == r101.f256231s) goto L44;
        return false;
    L44:
        if (this.f256232t == r101.f256232t) goto L46;
        return false;
    L46:
        if (this.f256233u == r101.f256233u) goto L48;
        return false;
    L48:
        if (this.f256234v == r101.f256234v) goto L50;
        return false;
    L50:
        if (this.f256235w == r101.f256235w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f256236x, r101.f256236x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f256237y, r101.f256237y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f256238z, r101.f256238z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    public final int hashCode() {
        Pair<Long, Long> r100 = this.f256213a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Pair<Long, Long> r104 = this.f256214b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((((((((r103 + r105) * 31) + this.f256215c) * 31) + this.f256216d) * 31) + Float.floatToIntBits(this.f256217e)) * 31) + this.f256218f) * 31) + this.f256219g) * 31) + this.f256220h) * 31;
        long r107 = this.f256221i;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f256222j;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f256223k;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.f256224l;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f256225m;
        if (r116 == null) goto L17;
        int r117 = r116.hashCode();
    L18:
        int r118 = (((((((((((((((((((r115 + r117) * 31) + this.f256226n) * 31) + Float.floatToIntBits(this.f256227o)) * 31) + Float.floatToIntBits(this.f256228p)) * 31) + Float.floatToIntBits(this.f256229q)) * 31) + Float.floatToIntBits(this.f256230r)) * 31) + this.f256231s) * 31) + this.f256232t) * 31) + this.f256233u) * 31) + this.f256234v) * 31;
        long r119 = this.f256235w;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        Pair<Integer, Integer> r121 = this.f256236x;
        if (r121 == null) goto L21;
        int r122 = r121.hashCode();
    L22:
        int r123 = (r120 + r122) * 31;
        Pair<Integer, Integer> r124 = this.f256237y;
        if (r124 == null) goto L25;
        int r125 = r124.hashCode();
    L26:
        int r126 = (r123 + r125) * 31;
        Pair<Integer, Integer> r127 = this.f256238z;
        if (r127 == null) goto L29;
        int r128 = r127.hashCode();
    L30:
        int r129 = (r126 + r128) * 31;
        Pair<Integer, Integer> r130 = this.A;
        if (r130 == null) goto L33;
        int r131 = r130.hashCode();
    L34:
        int r132 = (r129 + r131) * 31;
        Pair<Integer, Integer> r133 = this.B;
        if (r133 == null) goto L37;
        int r134 = r133.hashCode();
    L38:
        int r135 = (r132 + r134) * 31;
        t<?, ?> r136 = this.C;
        if (r136 == null) goto L42;
        r101 = r136.hashCode();
    L42:
        return r135 + r101;
    L37:
        r134 = 0;
        goto L38
    L33:
        r131 = 0;
        goto L34
    L29:
        r128 = 0;
        goto L30
    L25:
        r125 = 0;
        goto L26
    L21:
        r122 = 0;
        goto L22
    L17:
        r117 = 0;
        goto L18
    L13:
        r114 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvMidiPlayerConfig(defaultTimeRange=" + this.f256213a + ", componentTimeRange=" + this.f256214b + ", minTone=" + this.f256215c + ", maxTone=" + this.f256216d + ", defaultToneX=" + this.f256217e + ", tailMarginStart=" + this.f256218f + ", topAdapter=" + this.f256219g + ", half=" + this.f256220h + ", msgDelay=" + this.f256221i + ", hitAnimationDuration=" + this.f256222j + ", missAnimationDuration=" + this.f256223k + ", defaultScoreText=" + this.f256224l + ", scoreFormat=" + this.f256225m + ", defaultScoreLocation=" + this.f256226n + ", hitScoreThreshold=" + this.f256227o + ", perfectThreshold=" + this.f256228p + ", goodThreshold=" + this.f256229q + ", normalThreshold=" + this.f256230r + ", pointRate=" + this.f256231s + ", wrongRate=" + this.f256232t + ", chorusModeHeight=" + this.f256233u + ", chorusModeWidth=" + this.f256234v + ", scoreTimeInterval=" + this.f256235w + ", highScoreTopStyle=" + this.f256236x + ", lowScoreTopStyle=" + this.f256237y + ", highScoreBottomStyle=" + this.f256238z + ", lowScoreBottomStyle=" + this.A + ", chorusScoreStyle=" + this.B + ", schedulerHelper=" + this.C + ")";
    }

    public d(Pair r110, Pair r111, float r112, int r113, int r114, int r115, String r116, int r210, int r211, Pair r212, Pair r213, Pair r214, Pair r215, Pair r216, IoToUiTransformer r217) {
        Intrinsics.checkNotNullParameter(r110, "defaultTimeRange");
        Intrinsics.checkNotNullParameter(r111, "componentTimeRange");
        Intrinsics.checkNotNullParameter(r116, "defaultScoreText");
        Intrinsics.checkNotNullParameter("#0.0", "scoreFormat");
        Intrinsics.checkNotNullParameter(r212, "highScoreTopStyle");
        Intrinsics.checkNotNullParameter(r213, "lowScoreTopStyle");
        Intrinsics.checkNotNullParameter(r214, "highScoreBottomStyle");
        Intrinsics.checkNotNullParameter(r215, "lowScoreBottomStyle");
        Intrinsics.checkNotNullParameter(r216, "chorusScoreStyle");
        Intrinsics.checkNotNullParameter(r217, "schedulerHelper");
        this.f256213a = r110;
        this.f256214b = r111;
        this.f256215c = 58;
        this.f256216d = 90;
        this.f256217e = r112;
        this.f256218f = r113;
        this.f256219g = r114;
        this.f256220h = r115;
        this.f256221i = 300;
        this.f256222j = 500;
        this.f256223k = 500;
        this.f256224l = r116;
        this.f256225m = "#0.0";
        this.f256226n = 1;
        this.f256227o = 80.0f;
        this.f256228p = 0.5f;
        this.f256229q = 1.5f;
        this.f256230r = 2.5f;
        this.f256231s = 3;
        this.f256232t = 3;
        this.f256233u = r210;
        this.f256234v = r211;
        this.f256235w = 1000;
        this.f256236x = r212;
        this.f256237y = r213;
        this.f256238z = r214;
        this.A = r215;
        this.B = r216;
        this.C = r217;
    }
}
