package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f255993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f255994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f255995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f255996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f255997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f255998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f255999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f256000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f256001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f256002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f256003m;

    public m() {
        this(null, null, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L32;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f255991a, r101.f255991a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255992b, r101.f255992b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f255993c, r101.f255993c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f255994d, r101.f255994d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f255995e, r101.f255995e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f255996f, r101.f255996f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f255997g, r101.f255997g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f255998h, r101.f255998h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f255999i, r101.f255999i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f256000j, r101.f256000j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f256001k, r101.f256001k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f256002l, r101.f256002l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f256003m, r101.f256003m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f255991a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f255992b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f255993c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f255994d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f255995e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f255996f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f255997g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f255998h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f255999i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f256000j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f256001k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f256002l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f256003m;
        if (r137 == null) goto L54;
        r101 = r137.hashCode();
    L54:
        return r136 + r101;
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MusicInfo(id=" + this.f255991a + ", midiUrl=" + this.f255992b + ", mvUrl=" + this.f255993c + ", lyricUrl=" + this.f255994d + ", fullTrackFileHash=" + this.f255995e + ", fullTrackAudioId=" + this.f255996f + ", fullTrackUrl=" + this.f255997g + ", accompanimentFileHash=" + this.f255998h + ", accompanimentAudioId=" + this.f255999i + ", accompanimentUrl=" + this.f256000j + ", effectName=" + this.f256001k + ", effectVersion=" + this.f256002l + ", effectUrl=" + this.f256003m + ")";
    }

    public m(String r100, String r101, String r102, String r103, String r110, String r111, String r112, String r113, String r114, int r115) {
        String r104 = "";
        if ((r115 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r115 & 4) == 0) goto L11;
        String r105 = "";
    L13:
        if ((r115 & 8) == 0) goto L16;
        r102 = "";
    L16:
        if ((r115 & 16) == 0) goto L19;
        r103 = "";
    L19:
        if ((r115 & 32) == 0) goto L22;
        r110 = "";
    L22:
        if ((r115 & 64) == 0) goto L25;
        r111 = "";
    L25:
        if ((r115 & 128) == 0) goto L28;
        r112 = "";
    L28:
        if ((r115 & 256) == 0) goto L31;
        r113 = "";
    L31:
        if ((r115 & 512) == 0) goto L34;
        r114 = "";
    L34:
        if ((r115 & 1024) == 0) goto L36;
        String r106 = "";
    L38:
        if ((r115 & 2048) == 0) goto L40;
        String r107 = "";
    L42:
        if ((r115 & 4096) != 0) goto L45;
        r104 = null;
    L45:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "midiUrl");
        Intrinsics.checkNotNullParameter(r105, "mvUrl");
        Intrinsics.checkNotNullParameter(r102, "lyricUrl");
        Intrinsics.checkNotNullParameter(r103, "fullTrackFileHash");
        Intrinsics.checkNotNullParameter(r110, "fullTrackAudioId");
        Intrinsics.checkNotNullParameter(r111, "fullTrackUrl");
        Intrinsics.checkNotNullParameter(r112, "accompanimentFileHash");
        Intrinsics.checkNotNullParameter(r113, "accompanimentAudioId");
        Intrinsics.checkNotNullParameter(r114, "accompanimentUrl");
        Intrinsics.checkNotNullParameter(r106, "effectName");
        Intrinsics.checkNotNullParameter(r107, "effectVersion");
        Intrinsics.checkNotNullParameter(r104, "effectUrl");
        this.f255991a = r100;
        this.f255992b = r101;
        this.f255993c = r105;
        this.f255994d = r102;
        this.f255995e = r103;
        this.f255996f = r110;
        this.f255997g = r111;
        this.f255998h = r112;
        this.f255999i = r113;
        this.f256000j = r114;
        this.f256001k = r106;
        this.f256002l = r107;
        this.f256003m = r104;
        return;
    L40:
        r107 = null;
        goto L42
    L36:
        r106 = null;
        goto L38
    L11:
        r105 = null;
        goto L13
    }
}
