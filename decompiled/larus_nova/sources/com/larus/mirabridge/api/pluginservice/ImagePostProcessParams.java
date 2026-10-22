package com.larus.mirabridge.api.pluginservice;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006!"}, d2 = {"Lcom/larus/mirabridge/api/pluginservice/ImagePostProcessParams;", "", "zipFilePath", "", "optDirPath", BuyNowCloseMethod.MASK, "", "readZipImage", "enableCalib", "", "algorithmType", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIZLjava/lang/String;)V", "getZipFilePath", "()Ljava/lang/String;", "getOptDirPath", "getMask", "()I", "getReadZipImage", "getEnableCalib", "()Z", "getAlgorithmType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePostProcessParams {
    private final String algorithmType;
    private final boolean enableCalib;
    private final int mask;
    private final String optDirPath;
    private final int readZipImage;
    private final String zipFilePath;

    public static /* synthetic */ ImagePostProcessParams copy$default(ImagePostProcessParams r100, String r101, String r102, int r103, int r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.zipFilePath;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.optDirPath;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.mask;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.readZipImage;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.enableCalib;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.algorithmType;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.zipFilePath;
    }

    public final String component2() {
        return this.optDirPath;
    }

    public final int component3() {
        return this.mask;
    }

    public final int component4() {
        return this.readZipImage;
    }

    public final boolean component5() {
        return this.enableCalib;
    }

    public final String component6() {
        return this.algorithmType;
    }

    public final ImagePostProcessParams copy(String r100, String r110, int r111, int r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "zipFilePath");
        Intrinsics.checkNotNullParameter(r110, "optDirPath");
        return new ImagePostProcessParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImagePostProcessParams) == true) goto L8;
        return false;
    L8:
        ImagePostProcessParams r101 = (ImagePostProcessParams) r100;
        if (Intrinsics.areEqual(this.zipFilePath, r101.zipFilePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optDirPath, r101.optDirPath) == true) goto L15;
        return false;
    L15:
        if (this.mask == r101.mask) goto L18;
        return false;
    L18:
        if (this.readZipImage == r101.readZipImage) goto L21;
        return false;
    L21:
        if (this.enableCalib == r101.enableCalib) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.algorithmType, r101.algorithmType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.zipFilePath.hashCode() * 31) + this.optDirPath.hashCode()) * 31) + this.mask) * 31) + this.readZipImage) * 31;
        if (this.enableCalib == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.algorithmType;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ImagePostProcessParams(zipFilePath=" + this.zipFilePath + ", optDirPath=" + this.optDirPath + ", mask=" + this.mask + ", readZipImage=" + this.readZipImage + ", enableCalib=" + this.enableCalib + ", algorithmType=" + this.algorithmType + ')';
    }

    public final String getAlgorithmType() {
        return this.algorithmType;
    }

    public final boolean getEnableCalib() {
        return this.enableCalib;
    }

    public final int getMask() {
        return this.mask;
    }

    public final String getOptDirPath() {
        return this.optDirPath;
    }

    public final int getReadZipImage() {
        return this.readZipImage;
    }

    public final String getZipFilePath() {
        return this.zipFilePath;
    }

    public ImagePostProcessParams(String r100, String r101, int r102, int r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "zipFilePath");
        Intrinsics.checkNotNullParameter(r101, "optDirPath");
        this.zipFilePath = r100;
        this.optDirPath = r101;
        this.mask = r102;
        this.readZipImage = r103;
        this.enableCalib = r104;
        this.algorithmType = r105;
    }

    public /* synthetic */ ImagePostProcessParams(String r100, String r101, int r110, int r111, boolean r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        int r102 = 1;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = null;
    L9:
        this(r100, r101, r110, r102, r112, r113);
        return;
    L5:
        r102 = r111;
        goto L7
    }
}
