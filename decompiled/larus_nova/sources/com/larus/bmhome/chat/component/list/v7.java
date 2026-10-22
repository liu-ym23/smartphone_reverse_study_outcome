package com.larus.bmhome.chat.component.list;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f301281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f301282b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v7) == true) goto L8;
        return false;
    L8:
        v7 r101 = (v7) r100;
        if (Intrinsics.areEqual(this.f301281a, r101.f301281a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f301282b, r101.f301282b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f301281a.hashCode() * 31;
        String r101 = this.f301282b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SectionIdInfo(userId=" + this.f301281a + ", sectionId=" + this.f301282b + ')';
    }

    public v7(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f301281a = r100;
        this.f301282b = r101;
    }
}
