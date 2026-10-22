package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z4 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y4 f352657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.f0 f352658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.j0 f352659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.c0 f352660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f352663g;

    public z4() {
        this(null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z4) == true) goto L8;
        return false;
    L8:
        z4 r101 = (z4) r100;
        if (Intrinsics.areEqual(this.f352657a, r101.f352657a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352658b, r101.f352658b) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352659c, r101.f352659c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352660d, r101.f352660d) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352661e, r101.f352661e) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352662f, r101.f352662f) == true) goto L30;
        return false;
    L30:
        if (this.f352663g == r101.f352663g) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        y4 r100 = this.f352657a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + 0) * 31;
        com.larus.kmp.voice_setting.platform.f0 r104 = this.f352658b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        com.larus.kmp.voice_setting.platform.j0 r107 = this.f352659c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        com.larus.kmp.voice_setting.platform.c0 r110 = this.f352660d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f352661e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f352662f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.f352663g == false) goto L29;
        int r118 = 1231;
    L31:
        return r117 + r118;
    L29:
        r118 = 1237;
        goto L31
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceImageUploadStateData(pickerRequest=" + this.f352657a + ", cropRequest=null, cropRef=" + this.f352658b + ", uploadRequest=" + this.f352659c + ", sourceFile=" + this.f352660d + ", uploadedUrl=" + this.f352661e + ", uploadedUri=" + this.f352662f + ", isUploading=" + this.f352663g + ')';
    }

    public /* synthetic */ z4(y4 r100, int r110) {
        if ((r110 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null, null, null, null, false);
    }

    public static z4 a(z4 r100, y4 r101, com.larus.kmp.voice_setting.platform.f0 r110, com.larus.kmp.voice_setting.platform.j0 r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f352657a;
    L5:
        y4 r102 = r101;
        if ((r113 & 4) == 0) goto L8;
        r110 = r100.f352658b;
    L8:
        com.larus.kmp.voice_setting.platform.f0 r103 = r110;
        if ((r113 & 8) == 0) goto L11;
        r111 = r100.f352659c;
    L11:
        com.larus.kmp.voice_setting.platform.j0 r104 = r111;
        if ((r113 & 16) == 0) goto L14;
        com.larus.kmp.voice_setting.platform.c0 r105 = r100.f352660d;
    L16:
        if ((r113 & 32) == 0) goto L18;
        String r106 = r100.f352661e;
    L20:
        if ((r113 & 64) == 0) goto L22;
        String r107 = r100.f352662f;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r112 = r100.f352663g;
    L27:
        return new z4(r102, r103, r104, r105, r106, r107, r112);
    L22:
        r107 = null;
        goto L24
    L18:
        r106 = null;
        goto L20
    L14:
        r105 = null;
        goto L16
    }

    public z4(y4 r100, com.larus.kmp.voice_setting.platform.f0 r101, com.larus.kmp.voice_setting.platform.j0 r102, com.larus.kmp.voice_setting.platform.c0 r103, String r104, String r105, boolean r106) {
        this.f352657a = r100;
        this.f352658b = r101;
        this.f352659c = r102;
        this.f352660d = r103;
        this.f352661e = r104;
        this.f352662f = r105;
        this.f352663g = r106;
    }
}
