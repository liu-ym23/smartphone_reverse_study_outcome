package com.bytedance.locallife.photo.album.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f261993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f261994b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f261993a, r101.f261993a) == true) goto L12;
        return false;
    L12:
        if (this.f261994b == r101.f261994b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f261993a.hashCode() * 31) + this.f261994b;
    }

    public final String toString() {
        return "AlbumReportErrorEvent(id=" + this.f261993a + ", mode=" + this.f261994b + ')';
    }

    public j(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f261993a = r100;
        this.f261994b = r101;
    }
}
