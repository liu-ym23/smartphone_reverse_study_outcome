package ns8;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f520343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f520344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f520345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap.CompressFormat f520346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f520347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f520348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bitmap.CompressFormat f520349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f520350h;

    public a() {
        this(null, null, null, null, false, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f520343a, r101.f520343a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520344b, r101.f520344b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520345c, r101.f520345c) == true) goto L18;
        return false;
    L18:
        if (this.f520346d == r101.f520346d) goto L21;
        return false;
    L21:
        if (this.f520347e == r101.f520347e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f520348f, r101.f520348f) == true) goto L27;
        return false;
    L27:
        if (this.f520349g == r101.f520349g) goto L30;
        return false;
    L30:
        if (this.f520350h == r101.f520350h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f520343a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f520344b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f520345c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Bitmap.CompressFormat r110 = this.f520346d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f520347e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        Integer r115 = this.f520348f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Bitmap.CompressFormat r118 = this.f520349g;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return ((r117 + r101) * 31) + this.f520350h;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
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
        return "CompressConfig(optShortSize=" + this.f520343a + ", optLongSize=" + this.f520344b + ", optQuality=" + this.f520345c + ", compressFormat=" + this.f520346d + ", keepExif=" + this.f520347e + ", compressQualityWithAlpha=" + this.f520348f + ", compressFormatWithAlpha=" + this.f520349g + ", minSizeToCompress=" + this.f520350h + ')';
    }

    public static a a(a r110, Bitmap.CompressFormat r111, Bitmap.CompressFormat r112, int r113, int r114) {
        Integer r100 = null;
        if ((r114 & 1) == 0) goto L5;
        Integer r101 = r110.f520343a;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Integer r102 = r110.f520344b;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r103 = r110.f520345c;
    L15:
        if ((r114 & 8) == 0) goto L17;
        r111 = r110.f520346d;
    L17:
        Bitmap.CompressFormat r104 = r111;
        if ((r114 & 16) == 0) goto L20;
        boolean r105 = r110.f520347e;
    L22:
        if ((r114 & 32) == 0) goto L24;
        r100 = r110.f520348f;
    L24:
        Integer r106 = r100;
        if ((r114 & 64) == 0) goto L27;
        r112 = r110.f520349g;
    L27:
        Bitmap.CompressFormat r107 = r112;
        if ((r114 & 128) == 0) goto L31;
        r113 = r110.f520350h;
    L31:
        return new a(r101, r102, r103, r104, r105, r106, r107, r113);
    L20:
        r105 = false;
        goto L22
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ a(Integer r110, Integer r111, Integer r112, Bitmap.CompressFormat r113, boolean r114, int r115) {
        Bitmap.CompressFormat r100 = null;
        if ((r115 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        Bitmap.CompressFormat r104 = Bitmap.CompressFormat.JPEG;
    L19:
        if ((r115 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r115 & 64) == 0) goto L25;
        r100 = Bitmap.CompressFormat.JPEG;
    L25:
        this(r101, r102, r103, r104, r105, null, r100, 0);
        return;
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

    public a(Integer r100, Integer r101, Integer r102, Bitmap.CompressFormat r103, boolean r104, Integer r105, Bitmap.CompressFormat r106, int r107) {
        this.f520343a = r100;
        this.f520344b = r101;
        this.f520345c = r102;
        this.f520346d = r103;
        this.f520347e = r104;
        this.f520348f = r105;
        this.f520349g = r106;
        this.f520350h = r107;
    }
}
