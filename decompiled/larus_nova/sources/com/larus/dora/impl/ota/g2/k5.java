package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k5 {
    private final String descriptionDetail;
    private final String descriptionText;
    private final String descriptionType;
    private final long sizeBytes;
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k5) == true) goto L8;
        return false;
    L8:
        k5 r101 = (k5) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L12;
        return false;
    L12:
        if (this.sizeBytes == r101.sizeBytes) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.descriptionText, r101.descriptionText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.descriptionType, r101.descriptionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.descriptionDetail, r101.descriptionDetail) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.version.hashCode() * 31;
        long r101 = this.sizeBytes;
        return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.descriptionText.hashCode()) * 31) + this.descriptionType.hashCode()) * 31) + this.descriptionDetail.hashCode();
    }

    public final String toString() {
        return "SilentOtaCompletionNotice(version=" + this.version + ", sizeBytes=" + this.sizeBytes + ", descriptionText=" + this.descriptionText + ", descriptionType=" + this.descriptionType + ", descriptionDetail=" + this.descriptionDetail + ')';
    }

    public final String a() {
        return this.descriptionDetail;
    }

    public final String b() {
        return this.descriptionText;
    }

    public final String c() {
        return this.version;
    }

    public k5(String r100, long r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "version");
        Intrinsics.checkNotNullParameter(r102, "descriptionText");
        Intrinsics.checkNotNullParameter(r103, "descriptionType");
        Intrinsics.checkNotNullParameter(r104, "descriptionDetail");
        this.version = r100;
        this.sizeBytes = r101;
        this.descriptionText = r102;
        this.descriptionType = r103;
        this.descriptionDetail = r104;
    }
}
