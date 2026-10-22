package com.larus.community.impl.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f329841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f329842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f329843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f329844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f329845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f329846f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f329841a, r101.f329841a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f329842b, r101.f329842b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f329843c, r101.f329843c) == true) goto L18;
        return false;
    L18:
        if (this.f329844d == r101.f329844d) goto L21;
        return false;
    L21:
        if (this.f329845e == r101.f329845e) goto L24;
        return false;
    L24:
        if (this.f329846f == r101.f329846f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f329841a.hashCode() * 31;
        Long r101 = this.f329842b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f329843c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.f329844d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f329845e == true) goto L19;
        r107 = 1237;
    L19:
        return ((r109 + r107) * 31) + this.f329846f;
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareImageSingleItem(previewImageUrl=" + this.f329841a + ", defaultWidth=" + this.f329842b + ", defaultHeight=" + this.f329843c + ", hasPuzzleImage=" + this.f329844d + ", isVideo=" + this.f329845e + ", videoDuration=" + this.f329846f + ')';
    }

    public r(String r100, Long r101, Long r102, boolean r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "previewImageUrl");
        this.f329841a = r100;
        this.f329842b = r101;
        this.f329843c = r102;
        this.f329844d = r103;
        this.f329845e = r104;
        this.f329846f = r105;
    }
}
