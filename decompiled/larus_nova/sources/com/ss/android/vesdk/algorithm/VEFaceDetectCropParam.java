package com.ss.android.vesdk.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceDetectCropParam extends VEBachAlgorithmParam {
    public String bingoCropImgPath;
    public boolean isFastPath;
    public String slowPathImgPath;
    public String smashCropImgPath;

    public VEFaceDetectCropParam() {
        this(14, "bach_face_crop", false);
    }

    public VEFaceDetectCropParam(int r100, String r101, boolean r102) {
        super(r100, r101, r102);
    }
}
