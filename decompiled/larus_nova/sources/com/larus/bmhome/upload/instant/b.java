package com.larus.bmhome.upload.instant;

import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import kotlin.jvm.internal.Intrinsics;
import mr9.l;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f314770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourceInstantUploadInfo f314771b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f314770a, r101.f314770a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314771b, r101.f314771b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f314770a.hashCode() * 31) + this.f314771b.hashCode();
    }

    public final String toString() {
        return "ImageInstantUploadHit(uploadResult=" + this.f314770a + ", registerInfo=" + this.f314771b + ')';
    }

    public b(l r100, ResourceInstantUploadInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "uploadResult");
        Intrinsics.checkNotNullParameter(r101, "registerInfo");
        this.f314770a = r100;
        this.f314771b = r101;
    }
}
