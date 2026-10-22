package com.larus.gallery.api;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f343866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f343867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f343868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap.Config f343869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f343870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f343871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f343872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f343873i;

    public m() {
        this(null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f343865a, r101.f343865a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343866b, r101.f343866b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343867c, r101.f343867c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f343868d, r101.f343868d) == true) goto L21;
        return false;
    L21:
        if (this.f343869e == r101.f343869e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f343870f, r101.f343870f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f343871g, r101.f343871g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f343872h, r101.f343872h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f343873i, r101.f343873i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f343865a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f343866b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f343867c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f343868d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Bitmap.Config r113 = this.f343869e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f343870f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f343871g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f343872h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f343873i;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "GalleryImage(uri=" + this.f343865a + ", thumbUri=" + this.f343866b + ", width=" + this.f343867c + ", height=" + this.f343868d + ", previewBitmapConfig=" + this.f343869e + ", enableDownScale=" + this.f343870f + ", enableFullSizeResize=" + this.f343871g + ", bizTag=" + this.f343872h + ", fullSizeResizeSize=" + this.f343873i + ')';
    }

    public /* synthetic */ m(String r110, String r111, Integer r112, Integer r113, Boolean r114, Boolean r115, Integer r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r211 & 32) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r211 & 64) == 0) goto L25;
        Boolean r116 = null;
    L27:
        if ((r211 & 256) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r100, r101, r102, r103, null, r104, r116, null, r117);
        return;
    L29:
        r117 = r210;
        goto L30
    L25:
        r116 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public m(String r100, String r101, Integer r102, Integer r103, Bitmap.Config r104, Boolean r105, Boolean r106, String r107, Integer r108) {
        this.f343865a = r100;
        this.f343866b = r101;
        this.f343867c = r102;
        this.f343868d = r103;
        this.f343869e = r104;
        this.f343870f = r105;
        this.f343871g = r106;
        this.f343872h = r107;
        this.f343873i = r108;
    }
}
