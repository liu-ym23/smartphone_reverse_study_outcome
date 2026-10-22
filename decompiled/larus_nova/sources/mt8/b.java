package mt8;

import com.larus.im.bean.message.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Image f515650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f515651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f515652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f515653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f515654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f515655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f515656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f515657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f515658i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f515650a, r101.f515650a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f515651b, r101.f515651b) == 0) goto L15;
        return false;
    L15:
        if (this.f515652c == r101.f515652c) goto L18;
        return false;
    L18:
        if (this.f515653d == r101.f515653d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f515654e, r101.f515654e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f515655f, r101.f515655f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f515656g, r101.f515656g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f515657h, r101.f515657h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f515658i, r101.f515658i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Image r100 = this.f515650a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + Float.floatToIntBits(this.f515651b)) * 31) + this.f515652c) * 31) + this.f515653d) * 31;
        String r104 = this.f515654e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f515655f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f515656g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f515657h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f515658i;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "VideoMeta(coverImage=" + this.f515650a + ", duration=" + this.f515651b + ", width=" + this.f515652c + ", height=" + this.f515653d + ", localFilePath=" + this.f515654e + ", vid=" + this.f515655f + ", resourceId=" + this.f515656g + ", videoModel=" + this.f515657h + ", downloadUrl=" + this.f515658i + ')';
    }

    public b(Image r100, float r101, int r102, int r103, String r104, String r105, String r106, String r107, String r108) {
        this.f515650a = r100;
        this.f515651b = r101;
        this.f515652c = r102;
        this.f515653d = r103;
        this.f515654e = r104;
        this.f515655f = r105;
        this.f515656g = r106;
        this.f515657h = r107;
        this.f515658i = r108;
    }

    public /* synthetic */ b(Image r110, float r111, int r112, int r113, String r114, String r115, String r210, String r211, String r212, int r213) {
        if ((r213 & 4) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r213 & 8) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r213 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r213 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r213 & 64) == 0) goto L21;
        String r116 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        String r118 = null;
    L30:
        this(r110, r111, r100, r101, r102, r103, r116, r117, r118);
        return;
    L29:
        r118 = r212;
        goto L30
    L25:
        r117 = r211;
        goto L27
    L21:
        r116 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static b a(b r110, Image r111, float r112, int r113, int r114, String r115, String r116, String r117, String r118, String r119, int r210) {
        if ((r210 & 1) == 0) goto L5;
        Image r100 = r110.f515650a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        float r101 = r110.f515651b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.f515652c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.f515653d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.f515654e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.f515655f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.f515656g;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.f515657h;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.f515658i;
    L39:
        return new b(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
