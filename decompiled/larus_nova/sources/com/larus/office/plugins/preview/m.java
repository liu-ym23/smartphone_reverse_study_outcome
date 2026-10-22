package com.larus.office.plugins.preview;

import hq9.w4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f363217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w4 f363218b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f363217a, r101.f363217a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363218b, r101.f363218b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f363217a.hashCode() * 31) + this.f363218b.hashCode();
    }

    public final String toString() {
        return "OfficeDrivePreviewFile(token=" + this.f363217a + ", uploadInfo=" + this.f363218b + ')';
    }

    public m(String r100, w4 r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "uploadInfo");
        this.f363217a = r100;
        this.f363218b = r101;
    }
}
