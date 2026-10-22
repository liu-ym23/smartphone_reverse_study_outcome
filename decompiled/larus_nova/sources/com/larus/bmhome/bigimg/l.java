package com.larus.bmhome.bigimg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f296006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f296007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f296008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f296009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f296010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f296011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f296012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f296013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f296014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f296015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f296016k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f296006a, r101.f296006a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f296007b, r101.f296007b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f296008c, r101.f296008c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f296009d, r101.f296009d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f296010e, r101.f296010e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f296011f, r101.f296011f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f296012g, r101.f296012g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f296013h, r101.f296013h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f296014i, r101.f296014i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f296015j, r101.f296015j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f296016k, r101.f296016k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f296006a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.f296007b.hashCode()) * 31) + this.f296008c.hashCode()) * 31) + this.f296009d.hashCode()) * 31;
        String r104 = this.f296010e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f296011f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f296012g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f296013h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f296014i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f296015j;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f296016k;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "BigImageInfo(itemId=" + this.f296006a + ", imageUrl=" + this.f296007b + ", imageUri=" + this.f296008c + ", imageThumbUrl=" + this.f296009d + ", shortId=" + this.f296010e + ", sourceName=" + this.f296011f + ", sourceIcon=" + this.f296012g + ", sourceFrom=" + this.f296013h + ", jumpUrl=" + this.f296014i + ", imageCaption=" + this.f296015j + ", docId=" + this.f296016k + ')';
    }

    public /* synthetic */ l(String r110, String r111, String r112, String r113, String r210, String r211, String r212, Integer r213, String r214, String r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r216 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r216 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r216 & 64) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r216 & 128) == 0) goto L21;
        Integer r115 = null;
    L23:
        if ((r216 & 256) == 0) goto L25;
        String r116 = null;
    L27:
        if ((r216 & 512) == 0) goto L29;
        String r117 = null;
    L30:
        this(r100, r111, r112, r113, r101, r102, r114, r115, r116, r117, null);
        return;
    L29:
        r117 = r215;
        goto L30
    L25:
        r116 = r214;
        goto L27
    L21:
        r115 = r213;
        goto L23
    L17:
        r114 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public l(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        Intrinsics.checkNotNullParameter(r102, "imageUri");
        Intrinsics.checkNotNullParameter(r103, "imageThumbUrl");
        this.f296006a = r100;
        this.f296007b = r101;
        this.f296008c = r102;
        this.f296009d = r103;
        this.f296010e = r104;
        this.f296011f = r105;
        this.f296012g = r106;
        this.f296013h = r107;
        this.f296014i = r110;
        this.f296015j = r111;
        this.f296016k = r112;
    }
}
