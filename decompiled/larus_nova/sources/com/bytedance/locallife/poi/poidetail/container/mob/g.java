package com.bytedance.locallife.poi.poidetail.container.mob;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f263870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f263871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f263872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f263873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f263874e;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f263870a, r101.f263870a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f263871b, r101.f263871b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f263872c, r101.f263872c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f263873d, r101.f263873d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f263874e, r101.f263874e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f263870a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f263871b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f263872c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f263873d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f263874e;
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
        return "PoiAutoAnchorVisibleInfo(nodeTag=" + this.f263870a + ", subViewId=" + this.f263871b + ", anchorLineOnScreen=" + this.f263872c + ", nodeTopOnScreen=" + this.f263873d + ", subViewTopOnScreen=" + this.f263874e + ')';
    }

    public /* synthetic */ g(int r100) {
        this(null, null, null, null, null);
    }

    public g(String r100, String r101, Integer r102, Integer r103, Integer r104) {
        this.f263870a = r100;
        this.f263871b = r101;
        this.f263872c = r102;
        this.f263873d = r103;
        this.f263874e = r104;
    }
}
