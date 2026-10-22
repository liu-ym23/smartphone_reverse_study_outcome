package com.ss.android.ttve.model;

import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes38.dex */
public class VEMVAudioAlgorithmResult {
    public float[] bitsTime;
    public int[] bitsValue;
    public int size;

    public VEMVAudioAlgorithmResult() {
    }

    public int resizeBeatTrackingNum(int r110, int r111) {
        if (r110 < r111) goto L5;
        return 0;
    L5:
        VELogUtil.i("VEMVAudioAlgorithmResult", "need to transForm beat num... musicTime = " + r110 + ", mvTime = " + r111);
        int r100 = r111 / r110;
        float r112 = (float) (r111 - (r110 * r100));
        float r113 = (float) r110;
        int r101 = this.size;
        int r114 = ((int) ((r112 / r113) * r101)) + 1;
        int r102 = (r101 * r100) + r114;
        int[] r103 = new int[r102];
        float[] r104 = new float[r102];
        float[] r105 = new float[this.bitsTime.length];
        int r106 = 0;
    L7:
        if (r106 >= r100) goto L13;
        int[] r107 = this.bitsValue;
        int r108 = this.size;
        System.arraycopy(r107, 0, r103, r108 * r106, r108);
        int r109 = 0;
    L9:
        float[] r115 = this.bitsTime;
        if (r109 >= r115.length) goto L12;
        r105[r109] = r115[r109] + ((r113 / 1000.0f) * r106);
        r109 = r109 + 1;
        goto L9
    L12:
        int r116 = this.size;
        System.arraycopy(r105, 0, r104, r116 * r106, r116);
        r106 = r106 + 1;
        goto L7
    L13:
        int r117 = 0;
    L14:
        float[] r118 = this.bitsTime;
        if (r117 >= r118.length) goto L17;
        r105[r117] = r118[r117] + ((r113 / 1000.0f) * r100);
        r117 = r117 + 1;
        goto L14
    L17:
        System.arraycopy(this.bitsValue, 0, r103, this.size * r100, r114);
        System.arraycopy(r105, 0, r104, this.size * r100, r114);
        this.bitsValue = r103;
        this.bitsTime = r104;
        this.size = r102;
        return 0;
    }
}
