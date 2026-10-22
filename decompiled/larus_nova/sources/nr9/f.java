package nr9;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f520254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f520255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Bitmap f520256f;

    public f() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f520251a, r101.f520251a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520252b, r101.f520252b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520253c, r101.f520253c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520254d, r101.f520254d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520255e, r101.f520255e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f520256f, r101.f520256f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f520251a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f520252b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f520253c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f520254d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f520255e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Bitmap r116 = this.f520256f;
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
        return "VideoPlayCover(thumbUrl=" + this.f520251a + ", url=" + this.f520252b + ", localPath=" + this.f520253c + ", height=" + this.f520254d + ", width=" + this.f520255e + ", bitmap=" + this.f520256f + ')';
    }

    public f(String r100, String r101, String r102, Integer r103, Integer r104, Bitmap r105) {
        this.f520251a = r100;
        this.f520252b = r101;
        this.f520253c = r102;
        this.f520254d = r103;
        this.f520255e = r104;
        this.f520256f = r105;
    }

    public /* synthetic */ f(String r100, String r101, String r102, Integer r110, Integer r111, Bitmap r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        r110 = 0;
    L17:
        Integer r106 = r110;
        if ((r113 & 16) == 0) goto L20;
        r111 = 0;
    L20:
        Integer r107 = r111;
        if ((r113 & 32) == 0) goto L23;
        Bitmap r114 = null;
    L24:
        this(r103, r104, r105, r106, r107, r114);
        return;
    L23:
        r114 = r112;
        goto L24
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }

    public static f a(f r100, String r101, String r102, Integer r110, Integer r111, Bitmap r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f520251a;
    L5:
        String r103 = r101;
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f520252b;
    L8:
        String r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        String r105 = r100.f520253c;
    L12:
        String r106 = r105;
        if ((r113 & 8) == 0) goto L15;
        r110 = r100.f520254d;
    L15:
        Integer r107 = r110;
        if ((r113 & 16) == 0) goto L18;
        r111 = r100.f520255e;
    L18:
        Integer r108 = r111;
        if ((r113 & 32) == 0) goto L21;
        r112 = r100.f520256f;
    L21:
        r100.getClass();
        return new f(r103, r104, r106, r107, r108, r112);
    L11:
        r105 = null;
        goto L12
    }
}
