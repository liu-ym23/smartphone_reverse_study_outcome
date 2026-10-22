package com.ss.android.vesdk;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class VEMVParams {
    public float backVolume;
    public String bgmPath;
    public int bgmTrimIn;
    public int bgmTrimOut;
    public VESize customRenderRes;
    public String[] extraParams;
    public VESize imageResizeRatio;
    public List<VESize> imgSizes;
    public boolean isSingleVideo;
    public int[] karaokeAudioDurations;
    public String[] karaokeAudioPaths;
    public float[] karaokeAudioSpeeds;
    public int[] mvDuration;
    public String mvPath;
    public float originalVolume;
    public int resFillMode;
    public MVResolution resMV;
    public String[] resourcesFilePaths;
    public String[] resourcesTypes;

    public static final enum MVResolution extends Enum<MVResolution> {
        private static final /* synthetic */ MVResolution[] $VALUES = null;
        public static final MVResolution RES_1080P = null;
        public static final MVResolution RES_2K = null;
        public static final MVResolution RES_720P = null;
        public static final MVResolution RES_720P_REVERSE = null;
        public static final MVResolution RES_CUSTOM = null;
        public static final MVResolution RES_FROM_TEMPLATE = null;
        public static final MVResolution RES_RANDOM = null;

        private static /* synthetic */ MVResolution[] $values() {
            return new MVResolution[]{RES_RANDOM, RES_720P, RES_1080P, RES_2K, RES_720P_REVERSE, RES_FROM_TEMPLATE, RES_CUSTOM};
        }

        static {
            RES_RANDOM = new MVResolution("RES_RANDOM", 0);
            RES_720P = new MVResolution("RES_720P", 1);
            RES_1080P = new MVResolution("RES_1080P", 2);
            RES_2K = new MVResolution("RES_2K", 3);
            RES_720P_REVERSE = new MVResolution("RES_720P_REVERSE", 4);
            RES_FROM_TEMPLATE = new MVResolution("RES_FROM_TEMPLATE", 5);
            RES_CUSTOM = new MVResolution("RES_CUSTOM", 6);
            $VALUES = $values();
        }

        public static MVResolution[] values() {
            return (MVResolution[]) $VALUES.clone();
        }

        public static MVResolution valueOf(String r100) {
            return (MVResolution) r27.a.a(MVResolution.class, r100);
        }

        private MVResolution(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "VEMVParams{mvPath='" + this.mvPath + "', resourcesFilePaths=" + Arrays.toString(this.resourcesFilePaths) + ", resourcesTypes=" + Arrays.toString(this.resourcesTypes) + ", isSingleVideo=" + this.isSingleVideo + ", mvDuration=" + Arrays.toString(this.mvDuration) + ", bgmPath='" + this.bgmPath + "', bgmTrimIn=" + this.bgmTrimIn + ", bgmTrimOut=" + this.bgmTrimOut + ", imgSizes=" + this.imgSizes + ", backVolume=" + this.backVolume + ", originalVolume=" + this.originalVolume + ", resMV=" + this.resMV + ", karaokeAudioPaths=" + Arrays.toString(this.karaokeAudioPaths) + ", karaokeAudioDurations=" + Arrays.toString(this.karaokeAudioDurations) + ", karaokeAudioSpeeds=" + Arrays.toString(this.karaokeAudioSpeeds) + ", customRenderRes=" + this.customRenderRes + ", imageResizeRatio=" + this.imageResizeRatio + ", imageResFillMode=" + this.resFillMode + '}';
    }

    public VEMVParams() {
        this.imgSizes = null;
        this.backVolume = 1.0f;
        this.originalVolume = 1.0f;
        this.customRenderRes = null;
        this.imageResizeRatio = null;
        this.resFillMode = 0;
        this.mvPath = null;
        this.resourcesFilePaths = null;
        this.resourcesTypes = null;
        this.bgmPath = null;
        this.bgmTrimIn = -1;
        this.bgmTrimOut = -1;
        this.resMV = null;
        this.isSingleVideo = false;
        this.mvDuration = null;
        this.karaokeAudioPaths = null;
        this.karaokeAudioDurations = null;
        this.karaokeAudioSpeeds = null;
    }

    public VEMVParams(String r100, String[] r101, String[] r102) {
        this.imgSizes = null;
        this.backVolume = 1.0f;
        this.originalVolume = 1.0f;
        this.customRenderRes = null;
        this.imageResizeRatio = null;
        this.resFillMode = 0;
        this.mvPath = r100;
        this.resourcesFilePaths = r101;
        this.resourcesTypes = r102;
        this.resMV = MVResolution.RES_RANDOM;
        this.isSingleVideo = false;
        this.mvDuration = null;
    }

    public VEMVParams(String r100, String[] r101, String[] r102, MVResolution r103) {
        this.imgSizes = null;
        this.backVolume = 1.0f;
        this.originalVolume = 1.0f;
        this.customRenderRes = null;
        this.imageResizeRatio = null;
        this.resFillMode = 0;
        this.mvPath = r100;
        this.resourcesFilePaths = r101;
        this.resourcesTypes = r102;
        this.resMV = r103;
        this.isSingleVideo = false;
        this.mvDuration = null;
    }

    public VEMVParams(String r100, String[] r101, String[] r102, String r103, int r104, int r105) {
        this.imgSizes = null;
        this.backVolume = 1.0f;
        this.originalVolume = 1.0f;
        this.customRenderRes = null;
        this.imageResizeRatio = null;
        this.resFillMode = 0;
        this.mvPath = r100;
        this.resourcesFilePaths = r101;
        this.resourcesTypes = r102;
        this.bgmPath = r103;
        this.bgmTrimIn = r104;
        this.bgmTrimOut = r105;
        this.resMV = MVResolution.RES_RANDOM;
        this.isSingleVideo = false;
        this.mvDuration = null;
    }

    public VEMVParams(String r100, String[] r101, String[] r102, int[] r103, String[] r104, int[] r105, float[] r110) {
        this.imgSizes = null;
        this.backVolume = 1.0f;
        this.originalVolume = 1.0f;
        this.customRenderRes = null;
        this.imageResizeRatio = null;
        this.resFillMode = 0;
        if (r102[0].equals("video") == false) goto L8;
        if (r103 != null) goto L8;
        throw new VEException(-100, "Invalid params in karaoke mv mode!");
    L8:
        this.mvPath = r100;
        this.resourcesFilePaths = r101;
        this.resourcesTypes = r102;
        this.mvDuration = r103;
        this.karaokeAudioPaths = r104;
        this.karaokeAudioDurations = r105;
        this.karaokeAudioSpeeds = r110;
        this.resMV = MVResolution.RES_RANDOM;
        this.isSingleVideo = false;
    }

    public VEMVParams(String r100, String[] r101, String[] r102, String r103, int r104, int r105, boolean r106, int[] r110) {
        this.imgSizes = null;
        this.backVolume = 1.0f;
        this.originalVolume = 1.0f;
        this.customRenderRes = null;
        this.imageResizeRatio = null;
        this.resFillMode = 0;
        this.mvPath = r100;
        this.resourcesFilePaths = r101;
        this.resourcesTypes = r102;
        this.bgmPath = r103;
        this.bgmTrimIn = r104;
        this.bgmTrimOut = r105;
        this.resMV = MVResolution.RES_RANDOM;
        this.isSingleVideo = r106;
        this.mvDuration = r110;
    }
}
