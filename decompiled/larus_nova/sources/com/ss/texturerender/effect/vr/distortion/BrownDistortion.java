package com.ss.texturerender.effect.vr.distortion;

import com.ss.texturerender.TextureRenderLog;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class BrownDistortion {
    private final String LOG_TAG;
    private float[] mCoefficients;
    private int mTexType;

    private float distortionFactor(float r100) {
        float[] r101 = this.mCoefficients;
        int r102 = r101.length;
        float r103 = 1.0f;
        float r104 = 1.0f;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        r104 = r104 * r100;
        r103 = r103 + (Float.valueOf(r101[r105]).floatValue() * r104);
        r105 = r105 + 1;
        goto L3
    L5:
        return r103;
    }

    public BrownDistortion(float[] r100, int r101) {
        this.mTexType = -1;
        String r102 = TextureRenderLog.getLogTag(this);
        this.LOG_TAG = r102;
        this.mTexType = r101;
        this.mCoefficients = Arrays.copyOf(r100, r100.length);
        TextureRenderLog.i(this.mTexType, r102, "new BrownDistortion:" + Arrays.toString(this.mCoefficients));
    }

    public float[] distort(float r100, float r101) {
        float r102 = distortionFactor((r100 * r100) + (r101 * r101));
        return new float[]{r100 * r102, r102 * r101};
    }

    public float[] distortInverse(float r110, float r111) {
        float r100 = (float) Math.sqrt((r110 * r110) + (r111 * r111));
        if ((r100 - 0.0f) < Math.ulp(0.0f)) goto L5;
        float r101 = r100 / 2.0f;
        float r102 = r100 / 3.0f;
        float r103 = r100 - (distortionFactor(r101 * r101) * r101);
    L7:
        float r104 = r102;
        float r105 = r101;
        r101 = r104;
        float r106 = r101 - r105;
        if (Math.abs(r106) <= 1.0E-4f) goto L10;
        float r107 = r100 - (distortionFactor(r101 * r101) * r101);
        r102 = r101 - ((r106 / (r107 - r103)) * r107);
        r103 = r107;
        goto L7
    L10:
        float r108 = r101 / r100;
        return new float[]{r110 * r108, r108 * r111};
    L5:
        return new float[]{r110, r111};
    }
}
