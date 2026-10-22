package com.larus.mirabridge.api.pluginservice;

import com.heytap.mcssdk.constant.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/larus/mirabridge/api/pluginservice/ImagePostProcessResult;", "", "success", "", "code", "", "outputSize", "", "outputImage", "", "realMask", b.C, "", "<init>", "(ZI[I[BILjava/lang/String;)V", "getSuccess", "()Z", "getCode", "()I", "getOutputSize", "()[I", "getOutputImage", "()[B", "getRealMask", "getSdkVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePostProcessResult {
    private final int code;
    private final byte[] outputImage;
    private final int[] outputSize;
    private final int realMask;
    private final String sdkVersion;
    private final boolean success;

    public static /* synthetic */ ImagePostProcessResult copy$default(ImagePostProcessResult r100, boolean r101, int r102, int[] r103, byte[] r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.success;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.code;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.outputSize;
    L11:
        int[] r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.outputImage;
    L14:
        byte[] r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.realMask;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.sdkVersion;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.success;
    }

    public final int component2() {
        return this.code;
    }

    public final int[] component3() {
        return this.outputSize;
    }

    public final byte[] component4() {
        return this.outputImage;
    }

    public final int component5() {
        return this.realMask;
    }

    public final String component6() {
        return this.sdkVersion;
    }

    public final ImagePostProcessResult copy(boolean r100, int r110, int[] r111, byte[] r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r111, "outputSize");
        Intrinsics.checkNotNullParameter(r114, b.C);
        return new ImagePostProcessResult(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImagePostProcessResult) == true) goto L8;
        return false;
    L8:
        ImagePostProcessResult r101 = (ImagePostProcessResult) r100;
        if (this.success == r101.success) goto L12;
        return false;
    L12:
        if (this.code == r101.code) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.outputSize, r101.outputSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.outputImage, r101.outputImage) == true) goto L21;
        return false;
    L21:
        if (this.realMask == r101.realMask) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sdkVersion, r101.sdkVersion) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.success == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.code) * 31) + Arrays.hashCode(this.outputSize)) * 31;
        byte[] r102 = this.outputImage;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((((r101 + r103) * 31) + this.realMask) * 31) + this.sdkVersion.hashCode();
    L9:
        r103 = Arrays.hashCode(r102);
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ImagePostProcessResult(success=" + this.success + ", code=" + this.code + ", outputSize=" + Arrays.toString(this.outputSize) + ", outputImage=" + Arrays.toString(this.outputImage) + ", realMask=" + this.realMask + ", sdkVersion=" + this.sdkVersion + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final byte[] getOutputImage() {
        return this.outputImage;
    }

    public final int[] getOutputSize() {
        return this.outputSize;
    }

    public final int getRealMask() {
        return this.realMask;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public ImagePostProcessResult(boolean r100, int r101, int[] r102, byte[] r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r102, "outputSize");
        Intrinsics.checkNotNullParameter(r105, b.C);
        this.success = r100;
        this.code = r101;
        this.outputSize = r102;
        this.outputImage = r103;
        this.realMask = r104;
        this.sdkVersion = r105;
    }

    public /* synthetic */ ImagePostProcessResult(boolean r100, int r101, int[] r110, byte[] r111, int r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = "";
    L9:
        this(r100, r101, r110, r111, r102, r113);
        return;
    L5:
        r102 = r112;
        goto L7
    }
}
