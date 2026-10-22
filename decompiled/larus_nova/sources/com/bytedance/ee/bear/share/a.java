package com.bytedance.ee.bear.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f236999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f237000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f237001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f237002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f237003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f237004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f237005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f237006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f237007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f237008k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f236998a, r101.f236998a) == true) goto L12;
        return false;
    L12:
        if (this.f236999b == r101.f236999b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f237000c, r101.f237000c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f237001d, r101.f237001d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f237002e, r101.f237002e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f237003f, r101.f237003f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f237004g, r101.f237004g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f237005h, r101.f237005h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f237006i, r101.f237006i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f237007j, r101.f237007j) == true) goto L39;
        return false;
    L39:
        if (this.f237008k == r101.f237008k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f236998a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f236999b) * 31;
        String r104 = this.f237000c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f237001d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f237002e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f237003f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((((r112 + r114) * 31) + this.f237004g.hashCode()) * 31) + this.f237005h.hashCode()) * 31;
        String r116 = this.f237006i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f237007j;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (r118 + r101) * 31;
        if (this.f237008k == false) goto L33;
        int r121 = 1231;
    L35:
        return r120 + r121;
    L33:
        r121 = 1237;
        goto L35
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
        return "CommonParams(fileId=" + this.f236998a + ", fileType=" + this.f236999b + ", appForm=" + this.f237000c + ", subFileType=" + this.f237001d + ", module=" + this.f237002e + ", subModule=" + this.f237003f + ", userPermission=" + this.f237004g + ", filePermission=" + this.f237005h + ", containerId=" + this.f237006i + ", containerType=" + this.f237007j + ", isWiki=" + this.f237008k + ')';
    }

    public a(String r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r106, "userPermission");
        Intrinsics.checkNotNullParameter(r107, "filePermission");
        this.f236998a = r100;
        this.f236999b = r101;
        this.f237000c = r102;
        this.f237001d = r103;
        this.f237002e = r104;
        this.f237003f = r105;
        this.f237004g = r106;
        this.f237005h = r107;
        this.f237006i = "none";
        this.f237007j = "none";
        this.f237008k = r110;
    }
}
