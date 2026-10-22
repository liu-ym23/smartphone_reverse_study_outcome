package com.dtf.toyger.base.face;

import android.graphics.RectF;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.algorithm.TGFaceAttr;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerFaceAttr extends TGFaceAttr implements ToygerAttr {
    public ToygerFaceAttr() {
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public float brightness() {
        return this.brightness;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public short distance() {
        return this.distance;
    }

    public boolean eyeBlink() {
        return this.eyeBlink;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public float gaussian() {
        return this.gaussian;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public boolean hasTarget() {
        return this.hasFace;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public float integrity() {
        return this.integrity;
    }

    public float leftEyeBlinkRatio() {
        return this.leftEyeBlinkRatio;
    }

    public float leftEyeBlinkRatioMax() {
        return this.leftEyeBlinkRatioMax;
    }

    public float leftEyeBlinkRatioMin() {
        return this.leftEyeBlinkRatioMin;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public boolean lipMovement() {
        return this.lipMovement;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public float motion() {
        return this.motion;
    }

    public float pitch() {
        return this.pitch;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public float quality() {
        return this.quality;
    }

    @Override // com.dtf.toyger.base.ToygerAttr
    public RectF region() {
        return this.faceRegion;
    }

    public float rightEyeBlinkRatio() {
        return this.rightEyeBlinkRatio;
    }

    public float rightEyeBlinkRatioMax() {
        return this.rightEyeBlinkRatioMax;
    }

    public float rightEyeBlinkRatioMin() {
        return this.rightEyeBlinkRatioMin;
    }

    public float yaw() {
        return this.yaw;
    }

    public ToygerFaceAttr(TGFaceAttr r100) {
        super(r100);
    }

    public ToygerFaceAttr(ToygerFaceAttr r100, boolean r101) {
        super(r100);
        if (r101 == true) goto L6;
        RectF r102 = r100.faceRegion;
        this.faceRegion = new RectF(1.0f - r102.right, r102.top, 1.0f - r102.left, r102.bottom);
    L6:
        if (r100 == null) goto L13;
        float[] r103 = r100.keypts10;
        if (r103 == null) goto L13;
        float[] r104 = new float[10];
        if (r101 == false) goto L12;
        r104[0] = 1.0f - r103[1];
        r104[1] = 1.0f - r103[0];
        r104[2] = 1.0f - r103[2];
        r104[3] = 1.0f - r103[4];
        r104[4] = 1.0f - r103[3];
        r104[5] = r103[5];
        r104[6] = r103[6];
        r104[7] = r103[7];
        r104[8] = r103[8];
        r104[9] = r103[9];
    L12:
        this.keypts10 = r104;
        return;
    L13:
        if (r100 == null) goto L15;
        float[] r105 = r100.keypts10;
    L16:
        this.keypts10 = r105;
        return;
    L15:
        r105 = new float[10];
        goto L16
    }

    public ToygerFaceAttr(boolean r100, int r101, boolean r102, boolean r103, RectF r104, float r105, float r106, float r107, float r108, float r110, float r111, float r112, float r113, float r114, float r115, float r116, float r117, float r118, short r119, float[] r210, float r211, float r212, float r213, float r214, float r215) {
        super(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215);
    }
}
