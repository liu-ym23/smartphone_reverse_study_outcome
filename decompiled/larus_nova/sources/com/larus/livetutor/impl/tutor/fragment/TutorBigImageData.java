package com.larus.livetutor.impl.tutor.fragment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/larus/livetutor/impl/tutor/fragment/TutorBigImageData;", "", "imageUrl", "", "jumpUrl", "imageRawX", "", "imageRawY", "imageWidth", "imageHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIII)V", "getImageUrl", "()Ljava/lang/String;", "getJumpUrl", "getImageRawX", "()I", "getImageRawY", "getImageWidth", "getImageHeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TutorBigImageData {
    private final int imageHeight;
    private final int imageRawX;
    private final int imageRawY;
    private final String imageUrl;
    private final int imageWidth;
    private final String jumpUrl;

    public static /* synthetic */ TutorBigImageData copy$default(TutorBigImageData r100, String r101, String r102, int r103, int r104, int r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.imageUrl;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.jumpUrl;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.imageRawX;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.imageRawY;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.imageWidth;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.imageHeight;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final int component3() {
        return this.imageRawX;
    }

    public final int component4() {
        return this.imageRawY;
    }

    public final int component5() {
        return this.imageWidth;
    }

    public final int component6() {
        return this.imageHeight;
    }

    public final TutorBigImageData copy(String r100, String r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Intrinsics.checkNotNullParameter(r110, "jumpUrl");
        return new TutorBigImageData(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TutorBigImageData) == true) goto L8;
        return false;
    L8:
        TutorBigImageData r101 = (TutorBigImageData) r100;
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (this.imageRawX == r101.imageRawX) goto L18;
        return false;
    L18:
        if (this.imageRawY == r101.imageRawY) goto L21;
        return false;
    L21:
        if (this.imageWidth == r101.imageWidth) goto L24;
        return false;
    L24:
        if (this.imageHeight == r101.imageHeight) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.imageUrl.hashCode() * 31) + this.jumpUrl.hashCode()) * 31) + this.imageRawX) * 31) + this.imageRawY) * 31) + this.imageWidth) * 31) + this.imageHeight;
    }

    public String toString() {
        return "TutorBigImageData(imageUrl=" + this.imageUrl + ", jumpUrl=" + this.jumpUrl + ", imageRawX=" + this.imageRawX + ", imageRawY=" + this.imageRawY + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ')';
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageRawX() {
        return this.imageRawX;
    }

    public final int getImageRawY() {
        return this.imageRawY;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public TutorBigImageData(String r100, String r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Intrinsics.checkNotNullParameter(r101, "jumpUrl");
        this.imageUrl = r100;
        this.jumpUrl = r101;
        this.imageRawX = r102;
        this.imageRawY = r103;
        this.imageWidth = r104;
        this.imageHeight = r105;
    }
}
