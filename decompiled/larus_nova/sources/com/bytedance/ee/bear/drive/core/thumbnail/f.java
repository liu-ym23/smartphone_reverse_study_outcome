package com.bytedance.ee.bear.drive.core.thumbnail;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseOpenEntity f224371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f224372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MimeTypeCategory f224373c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f224371a, r101.f224371a) == true) goto L12;
        return false;
    L12:
        if (this.f224372b == r101.f224372b) goto L15;
        return false;
    L15:
        if (this.f224373c == r101.f224373c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f224371a.hashCode() * 31) + this.f224372b) * 31;
        MimeTypeCategory r101 = this.f224373c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DrivePreviewThumbnailItem(entity=" + this.f224371a + ", position=" + this.f224372b + ", mediaCategory=" + this.f224373c + ')';
    }

    public f(BaseOpenEntity r100, int r101, MimeTypeCategory r102) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        this.f224371a = r100;
        this.f224372b = r101;
        this.f224373c = r102;
    }
}
