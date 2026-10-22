package com.bytedance.locallife.photo.album.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f261995a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f261995a, ((k) r100).f261995a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f261995a.hashCode();
    }

    public final String toString() {
        return "AlbumTagClickEvent(id=" + this.f261995a + ')';
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f261995a = r100;
    }
}
