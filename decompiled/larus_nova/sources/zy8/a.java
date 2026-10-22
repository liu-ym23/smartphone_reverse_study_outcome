package zy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f573955e;

    public a() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f573951a, r101.f573951a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573952b, r101.f573952b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573953c, r101.f573953c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573954d, r101.f573954d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573955e, r101.f573955e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f573951a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f573952b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f573953c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f573954d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f573955e;
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
        return "GalleryImgSendEventExt(enterMethod=" + this.f573951a + ", scene=" + this.f573952b + ", contentSource=" + this.f573953c + ", contentSourceEntrance=" + this.f573954d + ", pictureSourceMessageId=" + this.f573955e + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        this.f573951a = r100;
        this.f573952b = r101;
        this.f573953c = r102;
        this.f573954d = r103;
        this.f573955e = r104;
    }
}
