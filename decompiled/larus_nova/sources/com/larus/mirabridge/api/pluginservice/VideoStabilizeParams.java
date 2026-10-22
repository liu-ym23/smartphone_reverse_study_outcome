package com.larus.mirabridge.api.pluginservice;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003Jo\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/larus/mirabridge/api/pluginservice/VideoStabilizeParams;", "", "zipFilePath", "", "optDirPath", "outputMp4FilePath", "cropRatio", "", "delayNum", "", "fixLevel", "outputWidth", "outputHeight", "inputMp4FilePath", "enableVideoFeature", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIIIILjava/lang/String;Z)V", "getZipFilePath", "()Ljava/lang/String;", "getOptDirPath", "getOutputMp4FilePath", "getCropRatio", "()D", "getDelayNum", "()I", "getFixLevel", "getOutputWidth", "getOutputHeight", "getInputMp4FilePath", "getEnableVideoFeature", "()Z", "videoThreadCount", "getVideoThreadCount", "setVideoThreadCount", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoStabilizeParams {
    private final double cropRatio;
    private final int delayNum;
    private final boolean enableVideoFeature;
    private final int fixLevel;
    private final String inputMp4FilePath;
    private final String optDirPath;
    private final int outputHeight;
    private final String outputMp4FilePath;
    private final int outputWidth;
    private int videoThreadCount;
    private final String zipFilePath;

    public static /* synthetic */ VideoStabilizeParams copy$default(VideoStabilizeParams r110, String r111, String r112, String r113, double r114, int r115, int r116, int r210, int r211, String r212, boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.zipFilePath;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.optDirPath;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.outputMp4FilePath;
    L15:
        if ((r214 & 8) == 0) goto L17;
        double r103 = r110.cropRatio;
    L19:
        if ((r214 & 16) == 0) goto L21;
        int r104 = r110.delayNum;
    L23:
        if ((r214 & 32) == 0) goto L25;
        int r105 = r110.fixLevel;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r106 = r110.outputWidth;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r117 = r110.outputHeight;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.inputMp4FilePath;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r107 = r110.enableVideoFeature;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
    L41:
        r107 = r213;
        goto L43
    L37:
        r118 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.zipFilePath;
    }

    public final boolean component10() {
        return this.enableVideoFeature;
    }

    public final String component2() {
        return this.optDirPath;
    }

    public final String component3() {
        return this.outputMp4FilePath;
    }

    public final double component4() {
        return this.cropRatio;
    }

    public final int component5() {
        return this.delayNum;
    }

    public final int component6() {
        return this.fixLevel;
    }

    public final int component7() {
        return this.outputWidth;
    }

    public final int component8() {
        return this.outputHeight;
    }

    public final String component9() {
        return this.inputMp4FilePath;
    }

    public final VideoStabilizeParams copy(String r110, String r111, String r112, double r113, int r114, int r210, int r211, int r212, String r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r110, "zipFilePath");
        Intrinsics.checkNotNullParameter(r111, "optDirPath");
        Intrinsics.checkNotNullParameter(r112, "outputMp4FilePath");
        return new VideoStabilizeParams(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoStabilizeParams) == true) goto L8;
        return false;
    L8:
        VideoStabilizeParams r101 = (VideoStabilizeParams) r100;
        if (Intrinsics.areEqual(this.zipFilePath, r101.zipFilePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optDirPath, r101.optDirPath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.outputMp4FilePath, r101.outputMp4FilePath) == true) goto L18;
        return false;
    L18:
        if (Double.compare(this.cropRatio, r101.cropRatio) == 0) goto L21;
        return false;
    L21:
        if (this.delayNum == r101.delayNum) goto L24;
        return false;
    L24:
        if (this.fixLevel == r101.fixLevel) goto L27;
        return false;
    L27:
        if (this.outputWidth == r101.outputWidth) goto L30;
        return false;
    L30:
        if (this.outputHeight == r101.outputHeight) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.inputMp4FilePath, r101.inputMp4FilePath) == true) goto L36;
        return false;
    L36:
        if (this.enableVideoFeature == r101.enableVideoFeature) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.zipFilePath.hashCode() * 31) + this.optDirPath.hashCode()) * 31) + this.outputMp4FilePath.hashCode()) * 31;
        long r101 = Double.doubleToLongBits(this.cropRatio);
        int r102 = (((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.delayNum) * 31) + this.fixLevel) * 31) + this.outputWidth) * 31) + this.outputHeight) * 31;
        String r103 = this.inputMp4FilePath;
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.enableVideoFeature == false) goto L9;
        int r106 = 1231;
    L11:
        return r105 + r106;
    L9:
        r106 = 1237;
        goto L11
    L5:
        r104 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "VideoStabilizeParams(zipFilePath=" + this.zipFilePath + ", optDirPath=" + this.optDirPath + ", outputMp4FilePath=" + this.outputMp4FilePath + ", cropRatio=" + this.cropRatio + ", delayNum=" + this.delayNum + ", fixLevel=" + this.fixLevel + ", outputWidth=" + this.outputWidth + ", outputHeight=" + this.outputHeight + ", inputMp4FilePath=" + this.inputMp4FilePath + ", enableVideoFeature=" + this.enableVideoFeature + ')';
    }

    public final double getCropRatio() {
        return this.cropRatio;
    }

    public final int getDelayNum() {
        return this.delayNum;
    }

    public final boolean getEnableVideoFeature() {
        return this.enableVideoFeature;
    }

    public final int getFixLevel() {
        return this.fixLevel;
    }

    public final String getInputMp4FilePath() {
        return this.inputMp4FilePath;
    }

    public final String getOptDirPath() {
        return this.optDirPath;
    }

    public final int getOutputHeight() {
        return this.outputHeight;
    }

    public final String getOutputMp4FilePath() {
        return this.outputMp4FilePath;
    }

    public final int getOutputWidth() {
        return this.outputWidth;
    }

    public final int getVideoThreadCount() {
        return this.videoThreadCount;
    }

    public final String getZipFilePath() {
        return this.zipFilePath;
    }

    public final void setVideoThreadCount(int r100) {
        this.videoThreadCount = r100;
    }

    public VideoStabilizeParams(String r100, String r101, String r102, double r103, int r104, int r105, int r106, int r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "zipFilePath");
        Intrinsics.checkNotNullParameter(r101, "optDirPath");
        Intrinsics.checkNotNullParameter(r102, "outputMp4FilePath");
        this.zipFilePath = r100;
        this.optDirPath = r101;
        this.outputMp4FilePath = r102;
        this.cropRatio = r103;
        this.delayNum = r104;
        this.fixLevel = r105;
        this.outputWidth = r106;
        this.outputHeight = r110;
        this.inputMp4FilePath = r111;
        this.enableVideoFeature = r112;
        this.videoThreadCount = 8;
    }

    public /* synthetic */ VideoStabilizeParams(String r110, String r111, String r112, double r113, int r210, int r211, int r212, int r213, String r214, boolean r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 256) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r216 & 512) == 0) goto L9;
        boolean r115 = true;
    L10:
        this(r110, r111, r112, r113, r210, r211, r212, r213, r114, r115);
        return;
    L9:
        r115 = r215;
        goto L10
    L5:
        r114 = r214;
        goto L7
    }
}
