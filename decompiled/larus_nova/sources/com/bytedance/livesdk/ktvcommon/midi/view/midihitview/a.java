package com.bytedance.livesdk.ktvcommon.midi.view.midihitview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f256159o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f256160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f256161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f256162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f256163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f256164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f256165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f256166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f256167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f256168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f256169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f256170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f256171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f256172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f256173n;

    /* JADX INFO: renamed from: com.bytedance.livesdk.ktvcommon.midi.view.midihitview.a$a, reason: collision with other inner class name */
    public static final class C3639a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L34;
        a r101 = (a) r100;
        if (this.f256160a == r101.f256160a) goto L8;
        return false;
    L8:
        if (this.f256161b == r101.f256161b) goto L10;
        return false;
    L10:
        if (this.f256162c == r101.f256162c) goto L12;
        return false;
    L12:
        if (this.f256163d == r101.f256163d) goto L14;
        return false;
    L14:
        if (Float.compare(this.f256164e, r101.f256164e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f256165f, r101.f256165f) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f256166g, r101.f256166g) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.f256167h, r101.f256167h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f256168i, r101.f256168i) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f256169j, r101.f256169j) == 0) goto L26;
        return false;
    L26:
        if (this.f256170k == r101.f256170k) goto L28;
        return false;
    L28:
        if (this.f256171l == r101.f256171l) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f256172m, r101.f256172m) == true) goto L32;
        return false;
    L32:
        if (this.f256173n == r101.f256173n) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f256160a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f256161b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f256162c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f256163d;
        int r107 = (((((((((((((((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + Float.floatToIntBits(this.f256164e)) * 31) + Float.floatToIntBits(this.f256165f)) * 31) + Float.floatToIntBits(this.f256166g)) * 31) + Float.floatToIntBits(this.f256167h)) * 31) + Float.floatToIntBits(this.f256168i)) * 31) + Float.floatToIntBits(this.f256169j)) * 31) + this.f256170k) * 31) + this.f256171l) * 31;
        String r108 = this.f256172m;
        if (r108 == null) goto L5;
        int r109 = r108.hashCode();
    L7:
        return ((r107 + r109) * 31) + this.f256173n;
    L5:
        r109 = 0;
        goto L7
    }

    public final String toString() {
        return "KtvMidiHitConfig(enterAnimDuration=" + this.f256160a + ", scaleAnimDuration=" + this.f256161b + ", exitAnimDuration=" + this.f256162c + ", comboDelay=" + this.f256163d + ", goodScaleFrom=" + this.f256164e + ", goodScaleTo=" + this.f256165f + ", perfectScaleFrom=" + this.f256166g + ", perfectScaleTo=" + this.f256167h + ", advancedScaleFrom=" + this.f256168i + ", componentComboTextSize=" + this.f256169j + ", componentComboBottomMargin=" + this.f256170k + ", componentComboEndMargin=" + this.f256171l + ", defaultPerfectBgUrl=" + this.f256172m + ", fpsConfig=" + this.f256173n + ")";
    }

    public a(float r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "defaultPerfectBgUrl");
        this.f256160a = 200;
        this.f256161b = 300;
        this.f256162c = 200;
        this.f256163d = 1500;
        this.f256164e = 1.6f;
        this.f256165f = 1.0f;
        this.f256166g = 2.0f;
        this.f256167h = 1.0f;
        this.f256168i = 3.0f;
        this.f256169j = r100;
        this.f256170k = r101;
        this.f256171l = r102;
        this.f256172m = r103;
        this.f256173n = 3;
    }
}
