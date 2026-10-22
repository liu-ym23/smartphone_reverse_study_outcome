package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f433548a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f433548a, ((d) r100).f433548a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f433548a.hashCode();
    }

    public final String toString() {
        return "MmAINoteGalleryPreviewItem(image=" + this.f433548a + ')';
    }

    public d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "image");
        this.f433548a = r100;
    }
}
