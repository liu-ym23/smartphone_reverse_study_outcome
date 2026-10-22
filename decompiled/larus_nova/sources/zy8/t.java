package zy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f573979e;

    public t() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f573975a, r101.f573975a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573976b, r101.f573976b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573977c, r101.f573977c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573978d, r101.f573978d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573979e, r101.f573979e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f573975a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f573976b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f573977c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f573978d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f573979e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "GalleryTextSendEventExt(enterMethod=" + this.f573975a + ", scene=" + this.f573976b + ", contentSource=" + this.f573977c + ", contentSourceEntrance=" + this.f573978d + ", pictureSourceMessageId=" + this.f573979e + ')';
    }

    public t(String r100, String r101, String r102, String r103, String r104) {
        this.f573975a = r100;
        this.f573976b = r101;
        this.f573977c = r102;
        this.f573978d = r103;
        this.f573979e = r104;
    }
}
