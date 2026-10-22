package com.larus.gallery.api;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GalleryType f343859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f343860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f343861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f343862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f343863e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f343859a == r101.f343859a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343860b, r101.f343860b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343861c, r101.f343861c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f343862d, r101.f343862d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f343863e, r101.f343863e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f343859a.hashCode() * 31;
        m r101 = this.f343860b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        q r105 = this.f343861c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        h r108 = this.f343862d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Message r111 = this.f343863e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "GalleryData(type=" + this.f343859a + ", image=" + this.f343860b + ", video=" + this.f343861c + ", custom=" + this.f343862d + ", referMessage=" + this.f343863e + ')';
    }

    public final GalleryType getType() {
        return this.f343859a;
    }

    public k(GalleryType r100, m r101, q r102, h r103, Message r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f343859a = r100;
        this.f343860b = r101;
        this.f343861c = r102;
        this.f343862d = r103;
        this.f343863e = r104;
    }
}
