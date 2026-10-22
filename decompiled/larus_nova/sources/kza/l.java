package kza;

import android.graphics.Bitmap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Continuation<? super Bitmap>, Object> f506769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Continuation<? super Bitmap>, Object> f506770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f506773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f506774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f506775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f506776h;

    public l() {
        this(null, null, null, null, false, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f506769a, r101.f506769a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506770b, r101.f506770b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506771c, r101.f506771c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506772d, r101.f506772d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506773e, r101.f506773e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506774f, r101.f506774f) == true) goto L27;
        return false;
    L27:
        if (this.f506775g == r101.f506775g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506776h, r101.f506776h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Function1<Continuation<? super Bitmap>, Object> r100 = this.f506769a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<Continuation<? super Bitmap>, Object> r104 = this.f506770b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f506771c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f506772d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Object r113 = this.f506773e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        e r116 = this.f506774f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f506775g == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        Object r121 = this.f506776h;
        if (r121 == null) goto L35;
        r101 = r121.hashCode();
    L35:
        return r120 + r101;
    L29:
        r119 = 1237;
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
        return "OpenFeishuGalleryImageItem(imageProvider=" + this.f506769a + ", thumbProvider=" + this.f506770b + ", uri=" + this.f506771c + ", thumbUri=" + this.f506772d + ", photoItem=" + this.f506773e + ", imageDelegate=" + this.f506774f + ", isOriginalImageChecked=" + this.f506775g + ", doubaoMessage=" + this.f506776h + ')';
    }

    public l(String r100, String r101, Object r102, e r103, boolean r104, Object r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 16) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 32) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 64) == 0) goto L18;
        r104 = false;
    L18:
        if ((r106 & 128) == 0) goto L20;
        r105 = null;
    L20:
        this.f506769a = null;
        this.f506770b = null;
        this.f506771c = r100;
        this.f506772d = r101;
        this.f506773e = r102;
        this.f506774f = r103;
        this.f506775g = r104;
        this.f506776h = r105;
    }
}
