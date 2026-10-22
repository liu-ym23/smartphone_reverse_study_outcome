package com.larus.community.impl.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f329837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f329838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f329839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f329840d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f329837a, r101.f329837a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f329838b, r101.f329838b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f329839c, r101.f329839c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f329840d, r101.f329840d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f329837a.hashCode() * 31) + this.f329838b.hashCode()) * 31;
        Long r101 = this.f329839c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f329840d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareImagePuzzleItem(rawImageUrl=" + this.f329837a + ", refImageUrl=" + this.f329838b + ", defaultWidth=" + this.f329839c + ", defaultHeight=" + this.f329840d + ')';
    }

    public q(String r100, String r101, Long r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "rawImageUrl");
        Intrinsics.checkNotNullParameter(r101, "refImageUrl");
        this.f329837a = r100;
        this.f329838b = r101;
        this.f329839c = r102;
        this.f329840d = r103;
    }
}
