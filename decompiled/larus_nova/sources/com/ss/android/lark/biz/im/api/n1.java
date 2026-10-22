package com.ss.android.lark.biz.im.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f410420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f410422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f410423d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r101 = (n1) r100;
        if (Intrinsics.areEqual(this.f410420a, r101.f410420a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410421b, r101.f410421b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410422c, r101.f410422c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410423d, r101.f410423d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f410420a.hashCode() * 31) + this.f410421b.hashCode()) * 31) + this.f410422c.hashCode()) * 31;
        Long r101 = this.f410423d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UserStatusUrlPreviewSnapshot(content=" + this.f410420a + ", userId=" + this.f410421b + ", sourceTextMD5=" + this.f410422c + ", privateDescriptionId=" + this.f410423d + ')';
    }

    public n1(String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "sourceTextMD5");
        this.f410420a = r100;
        this.f410421b = r101;
        this.f410422c = r102;
        this.f410423d = r103;
    }
}
