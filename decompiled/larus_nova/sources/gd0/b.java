package gd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f480890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f480891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f480893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f480894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f480895f;

    public b() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f480890a, r101.f480890a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f480891b, r101.f480891b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f480892c, r101.f480892c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480893d, r101.f480893d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f480894e, r101.f480894e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f480895f, r101.f480895f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f480890a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f480891b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f480892c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f480893d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f480894e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f480895f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AwemeVideoPreviewInfo(itemId=" + this.f480890a + ", itemType=" + this.f480891b + ", coverUrl=" + this.f480892c + ", likeCount=" + this.f480893d + ", title=" + this.f480894e + ", tabType=" + this.f480895f + ")";
    }

    public b(Long r100, Long r101, String r102, Long r103, String r104, Integer r105) {
        this.f480890a = r100;
        this.f480891b = r101;
        this.f480892c = r102;
        this.f480893d = r103;
        this.f480894e = r104;
        this.f480895f = r105;
    }
}
