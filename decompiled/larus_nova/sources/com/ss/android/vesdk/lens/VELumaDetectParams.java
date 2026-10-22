package com.ss.android.vesdk.lens;

import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VELumaDetectParams extends VEBaseRecorderLensParams {
    public int detectFrames;
    public float ecStep;
    public int exposureTime;
    public int faceNum;
    public Rect[] faceRects;
    public int iso;
    public int maxExposureTime;
    public int maxIso;
    public int minExposureTime;
    public int minIso;

    public VELumaDetectParams() {
        this.iso = 0;
        this.minIso = 0;
        this.maxIso = ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT;
        this.exposureTime = 1;
        this.minExposureTime = 1;
        this.maxExposureTime = 1;
        this.ecStep = 0.0f;
        this.detectFrames = 3;
        this.faceNum = 0;
        this.algorithmFlag = 27;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("Iso", this.iso);
        r100.setInt("MinIso", this.minIso);
        r100.setInt("MaxIso", this.maxIso);
        r100.setInt(ExifInterface.TAG_EXPOSURE_TIME, this.exposureTime);
        r100.setInt("MinExposureTime", this.minExposureTime);
        r100.setInt("MaxExposureTime", this.maxExposureTime);
        r100.setFloat("EcStep", this.ecStep);
        r100.setInt("DetectFrames", this.detectFrames);
        r100.setInt("FaceNum", this.faceNum);
        if (this.faceNum != 0) goto L5;
        return r100;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= this.faceNum) goto L9;
        Rect r102 = this.faceRects[r101];
        r100.setIntArray("FaceRect_" + r101, new int[]{r102.bottom, r102.left, r102.right, r102.top});
        r101 = r101 + 1;
        goto L7
    L9:
        return r100;
    }
}
