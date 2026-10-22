package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f433549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f433550b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f433549a, r101.f433549a) == true) goto L12;
        return false;
    L12:
        if (this.f433550b == r101.f433550b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f433549a.hashCode() * 31) + this.f433550b;
    }

    public final String toString() {
        return "MmAINoteGalleryPreviewRequest(items=" + this.f433549a + ", startIndex=" + this.f433550b + ')';
    }

    public e(List<d> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f433549a = r100;
        this.f433550b = r101;
    }
}
