package com.larus.office.card.urlpreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f361829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeUrlPreviewResolution f361830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f361831c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a2) == true) goto L8;
        return false;
    L8:
        a2 r101 = (a2) r100;
        if (Intrinsics.areEqual(this.f361829a, r101.f361829a) == true) goto L12;
        return false;
    L12:
        if (this.f361830b == r101.f361830b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361831c, r101.f361831c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f361829a.hashCode() * 31) + this.f361830b.hashCode()) * 31;
        z0 r101 = this.f361831c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "OfficeUrlPreviewRenderSnapshot(block=" + this.f361829a + ", resolution=" + this.f361830b + ", previewInfo=" + this.f361831c + ')';
    }

    public a2(s r100, OfficeUrlPreviewResolution r101, z0 r102) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Intrinsics.checkNotNullParameter(r101, "resolution");
        this.f361829a = r100;
        this.f361830b = r101;
        this.f361831c = r102;
    }
}
