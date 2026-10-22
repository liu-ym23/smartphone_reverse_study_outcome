package com.larus.canvas.feature.component.resultdisplay.image;

import com.larus.canvas.feature.component.base.ImageRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f323672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRes f323673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageRes f323674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f323675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f323676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f323677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f323678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f323679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f323680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f323681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageRes f323682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f323683l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f323672a, r101.f323672a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323673b, r101.f323673b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323674c, r101.f323674c) == true) goto L18;
        return false;
    L18:
        if (this.f323675d == r101.f323675d) goto L21;
        return false;
    L21:
        if (this.f323676e == r101.f323676e) goto L24;
        return false;
    L24:
        if (this.f323677f == r101.f323677f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f323678g, r101.f323678g) == true) goto L30;
        return false;
    L30:
        if (this.f323679h == r101.f323679h) goto L33;
        return false;
    L33:
        if (this.f323680i == r101.f323680i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f323681j, r101.f323681j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f323682k, r101.f323682k) == true) goto L42;
        return false;
    L42:
        if (this.f323683l == r101.f323683l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f323672a.hashCode() * 31;
        ImageRes r101 = this.f323673b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ImageRes r105 = this.f323674c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((((r104 + r106) * 31) + this.f323675d) * 31) + this.f323676e) * 31) + this.f323677f) * 31) + this.f323678g.hashCode()) * 31;
        int r108 = 1231;
        if (this.f323679h == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f323680i == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((r110 + r111) * 31) + this.f323681j.hashCode()) * 31;
        ImageRes r113 = this.f323682k;
        if (r113 == null) goto L22;
        r102 = r113.hashCode();
    L22:
        int r114 = (r112 + r102) * 31;
        if (this.f323683l == true) goto L27;
        r108 = 1237;
    L27:
        return r114 + r108;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PageItemData(id=" + this.f323672a + ", lowImageRes=" + this.f323673b + ", imageRes=" + this.f323674c + ", width=" + this.f323675d + ", height=" + this.f323676e + ", status=" + this.f323677f + ", description=" + this.f323678g + ", showCompareBtn=" + this.f323679h + ", showRegenerateBtn=" + this.f323680i + ", saveActionState=" + this.f323681j + ", compareRes=" + this.f323682k + ", willBeRemove=" + this.f323683l + ')';
    }

    public y(String r100, ImageRes r101, ImageRes r102, int r103, int r104, @PageItemStatus int r105, String r106, boolean r107, boolean r110, w r111, ImageRes r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r106, "description");
        Intrinsics.checkNotNullParameter(r111, "saveActionState");
        this.f323672a = r100;
        this.f323673b = r101;
        this.f323674c = r102;
        this.f323675d = r103;
        this.f323676e = r104;
        this.f323677f = r105;
        this.f323678g = r106;
        this.f323679h = r107;
        this.f323680i = r110;
        this.f323681j = r111;
        this.f323682k = r112;
        this.f323683l = r113;
    }
}
