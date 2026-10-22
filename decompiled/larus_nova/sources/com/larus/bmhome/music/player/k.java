package com.larus.bmhome.music.player;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ad9.b f312984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f312985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f312986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f312987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f312988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f312989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f312990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f312991h;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f312984a, r101.f312984a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312985b, r101.f312985b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f312986c, r101.f312986c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f312987d, r101.f312987d) == 0) goto L21;
        return false;
    L21:
        if (this.f312988e == r101.f312988e) goto L24;
        return false;
    L24:
        if (this.f312989f == r101.f312989f) goto L27;
        return false;
    L27:
        if (this.f312990g == r101.f312990g) goto L30;
        return false;
    L30:
        if (this.f312991h == r101.f312991h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        ad9.b r100 = this.f312984a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.f312985b.hashCode()) * 31) + Float.floatToIntBits(this.f312986c)) * 31) + Float.floatToIntBits(this.f312987d)) * 31;
        int r103 = 1231;
        if (this.f312988e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f312989f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.f312990g) * 31;
        if (this.f312991h == true) goto L19;
        r103 = 1237;
    L19:
        return r107 + r103;
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
        return "StreamPlayState(playingPlayList=" + this.f312984a + ", chunkUrl=" + this.f312985b + ", currentPlayTime=" + this.f312986c + ", currentProgress=" + this.f312987d + ", playingChunk=" + this.f312988e + ", waitingToVideoEnginePlay=" + this.f312989f + ", waitingResumeTime=" + this.f312990g + ", playingVid=" + this.f312991h + ')';
    }

    public /* synthetic */ k(ad9.b r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r110 = null;
    L5:
        ad9.b r100 = r110;
        if ((r112 & 2) == 0) goto L8;
        r111 = "";
    L8:
        String r101 = r111;
        if ((r112 & 4) == 0) goto L11;
        float r102 = 60000.0f;
    L12:
        this(r100, r101, r102, 0.0f, false, false, 0, false);
        return;
    L11:
        r102 = 0.0f;
        goto L12
    }

    public k(ad9.b r100, String r101, float r102, float r103, boolean r104, boolean r105, int r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r101, "chunkUrl");
        this.f312984a = r100;
        this.f312985b = r101;
        this.f312986c = r102;
        this.f312987d = r103;
        this.f312988e = r104;
        this.f312989f = r105;
        this.f312990g = r106;
        this.f312991h = r107;
    }

    public static k a(k r100, ad9.b r110, String r111, float r112, float r113, boolean r114, boolean r115, int r116, int r117) {
        if ((r117 & 1) == 0) goto L5;
        ad9.b r101 = r100.f312984a;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.f312985b;
    L11:
        if ((r117 & 4) == 0) goto L13;
        float r103 = r100.f312986c;
    L15:
        if ((r117 & 8) == 0) goto L17;
        float r104 = r100.f312987d;
    L19:
        if ((r117 & 16) == 0) goto L21;
        boolean r105 = r100.f312988e;
    L23:
        if ((r117 & 32) == 0) goto L25;
        boolean r106 = r100.f312989f;
    L27:
        if ((r117 & 64) == 0) goto L29;
        int r107 = r100.f312990g;
    L31:
        if ((r117 & 128) == 0) goto L33;
        boolean r108 = r100.f312991h;
    L34:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "chunkUrl");
        return new k(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = false;
        goto L34
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
