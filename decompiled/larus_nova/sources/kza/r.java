package kza;

import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GalleryType f506814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f506820g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f506814a == r101.f506814a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506815b, r101.f506815b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506816c, r101.f506816c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506817d, r101.f506817d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506818e, r101.f506818e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506819f, r101.f506819f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506820g, r101.f506820g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506814a.hashCode() * 31;
        String r101 = this.f506815b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f506816c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f506817d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f506818e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f506819f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f506820g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenFeishuMediaInfo(mediaType=" + this.f506814a + ", messageId=" + this.f506815b + ", chatId=" + this.f506816c + ", itemId=" + this.f506817d + ", imageUri=" + this.f506818e + ", authorShortId=" + this.f506819f + ", sourceFrom=" + this.f506820g + ')';
    }

    public r(GalleryType r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "mediaType");
        this.f506814a = r100;
        this.f506815b = r101;
        this.f506816c = r102;
        this.f506817d = r103;
        this.f506818e = null;
        this.f506819f = null;
        this.f506820g = null;
    }
}
