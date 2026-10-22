package com.ss.android.vesdk.lens;

import android.graphics.Rect;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEOneKeyProcessParams extends VEBaseRecorderLensParams {
    public int faceNum;
    public Rect[] faceRects;
    public boolean isFirstFrame;
    public int iso;
    public String lutTablePath;
    public int maxIso;
    public int minIso;

    public VEOneKeyProcessParams() {
        this.iso = 0;
        this.maxIso = 0;
        this.minIso = 0;
        this.isFirstFrame = false;
        this.faceNum = 0;
        this.lutTablePath = "";
        this.algorithmFlag = 28;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("Iso", this.iso);
        r100.setInt("MinIso", this.minIso);
        r100.setInt("MaxIso", this.maxIso);
        r100.setBool("IsFirstFrame", this.isFirstFrame);
        r100.setInt("FaceNum", this.faceNum);
        r100.setString("LutTablePath", this.lutTablePath);
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
