package com.ss.android.vesdk.faceinfo;

import com.ss.android.ttve.nativePort.e;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceAttributeInfo {
    private static final String TAG = "VEFaceAttributeInfo";
    private int faceCount;
    VEFaceAttribute[] info;
    private e parcelWrapper;

    public VEFaceAttributeInfo() {
    }

    public void readFromParcel() {
        e r100 = this.parcelWrapper;
        if (r100 != null) goto L5;
        return;
    L5:
        this.faceCount = r100.c();
        VELogUtil.d(TAG, "face count = " + this.faceCount);
        int r101 = this.faceCount;
        if (r101 != 0) goto L8;
        return;
    L8:
        this.info = new VEFaceAttribute[r101];
        int r102 = 0;
    L10:
        if (r102 >= this.faceCount) goto L12;
        VEFaceAttribute r103 = new VEFaceAttribute();
        r103.setParcelWrapper(this.parcelWrapper);
        r103.readFromParcel();
        this.info[r102] = r103;
        r102 = r102 + 1;
        goto L10
    }

    public VEFaceAttribute[] getInfo() {
        return this.info;
    }

    public static VEFaceAttributeInfo convert(FaceAttributeInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        VEFaceAttributeInfo r101 = new VEFaceAttributeInfo();
        FaceAttribute[] r102 = r100.getInfo();
        int r103 = 0;
        if (r102 != null) goto L8;
        r101.setInfo(new VEFaceAttribute[0]);
    L14:
        return r101;
    L8:
        VEFaceAttribute[] r104 = new VEFaceAttribute[r102.length];
        r101.setInfo(r104);
        int r105 = r102.length;
        int r106 = 0;
    L9:
        if (r103 >= r105) goto L14;
        FaceAttribute r107 = r102[r103];
        VEFaceAttribute r108 = new VEFaceAttribute();
        int r109 = r106 + 1;
        r104[r106] = r108;
        if (r107 == null) goto L13;
        r108.setAge(r107.getAge());
        r108.setAngryScore(r107.getAngryScore());
        r108.setArousal(r107.getArousal());
        r108.setAngryScore(r107.getAngryScore());
        r108.setAttractive(r107.getAttractive());
        r108.setBlurScore(r107.getBlurScore());
        r108.setBoyProb(r107.getBoyProb());
        r108.setExpProbs(r107.getExpProbs());
        r108.setExpType(r107.getExpType());
        r108.setHappyScore(r107.getHappyScore());
        r108.setIllumination(r107.getIllumination());
        r108.setLipstickProb(r107.getLipstickProb());
        r108.setMaskProb(r107.getMaskProb());
        r108.setMustacheProb(r107.getMustacheProb());
        r108.setQuality(r107.getQuality());
        r108.setRealFaceProb(r107.getRealFaceProb());
        r108.setSadScore(r107.getSadScore());
        r108.setSurpriseScore(r107.getSurpriseScore());
        r108.setValence(r107.getValence());
        r108.setWearGlassProb(r107.getWearGlassProb());
        r108.setWearHatProb(r107.getWearHatProb());
        r108.setWearSunglassProb(r107.getWearSunglassProb());
    L13:
        r103 = r103 + 1;
        r106 = r109;
        goto L9
    }

    public void setInfo(VEFaceAttribute[] r100) {
        this.info = r100;
    }

    public void setParcelWrapper(e r100) {
        this.parcelWrapper = r100;
    }
}
