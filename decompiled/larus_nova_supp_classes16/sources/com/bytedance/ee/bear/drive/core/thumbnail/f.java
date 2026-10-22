package com.bytedance.ee.bear.drive.core.thumbnail;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final BaseOpenEntity a;
    public final int b;
    public final MimeTypeCategory c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        MimeTypeCategory r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DrivePreviewThumbnailItem(entity=" + this.a + ", position=" + this.b + ", mediaCategory=" + this.c + ')';
    }

    public f(BaseOpenEntity r2, int r3, MimeTypeCategory r4) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
