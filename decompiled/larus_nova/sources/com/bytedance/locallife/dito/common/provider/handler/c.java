package com.bytedance.locallife.dito.common.provider.handler;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f257634l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f257635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f257636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f257637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f257638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f257639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f257640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f257641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f257642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Drawable f257643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f257644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f257645k;

    public static final class a {
    }

    static {
    }

    public c() {
        this(true, 0, false, 0.0f, 1.0f, false, 0, 3000, null, 300, 120);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f257635a == r101.f257635a) goto L12;
        return false;
    L12:
        if (this.f257636b == r101.f257636b) goto L15;
        return false;
    L15:
        if (this.f257637c == r101.f257637c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f257638d, r101.f257638d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f257639e, r101.f257639e) == 0) goto L24;
        return false;
    L24:
        if (this.f257640f == r101.f257640f) goto L27;
        return false;
    L27:
        if (this.f257641g == r101.f257641g) goto L30;
        return false;
    L30:
        if (this.f257642h == r101.f257642h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f257643i, r101.f257643i) == true) goto L36;
        return false;
    L36:
        if (this.f257644j == r101.f257644j) goto L39;
        return false;
    L39:
        if (this.f257645k == r101.f257645k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f257635a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f257636b) * 31;
        if (this.f257637c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((r102 + r103) * 31) + Float.floatToIntBits(this.f257638d)) * 31) + Float.floatToIntBits(this.f257639e)) * 31;
        if (this.f257640f == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        long r106 = this.f257641g;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f257642h;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        Drawable r110 = this.f257643i;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f257644j;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f257645k;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L17:
        r111 = r110.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocateActionParam(needLocate=" + this.f257635a + ", locateIndex=" + this.f257636b + ", smoothScroll=" + this.f257637c + ", scrollOffset=" + this.f257638d + ", speedMultiple=" + this.f257639e + ", needHighlight=" + this.f257640f + ", highlightDelay=" + this.f257641g + ", highlightDuration=" + this.f257642h + ", highlightBackground=" + this.f257643i + ", delayCheckInterval=" + this.f257644j + ", halfPageExpandDelay=" + this.f257645k + ')';
    }

    public c(boolean r100, int r101, boolean r102, float r103, float r104, boolean r105, long r106, long r107, Drawable r110, long r111, long r112) {
        this.f257635a = r100;
        this.f257636b = r101;
        this.f257637c = r102;
        this.f257638d = r103;
        this.f257639e = r104;
        this.f257640f = r105;
        this.f257641g = r106;
        this.f257642h = r107;
        this.f257643i = r110;
        this.f257644j = r111;
        this.f257645k = r112;
    }
}
