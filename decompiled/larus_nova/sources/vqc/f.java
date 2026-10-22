package vqc;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static float[] a(RectF r100) {
        float r101 = r100.left;
        float r102 = r100.top;
        float r103 = r100.right;
        float r104 = r100.bottom;
        return new float[]{r101, r102, r103, r102, r103, r104, r101, r104};
    }

    public static RectF b(float[] r100) {
        RectF r101 = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        int r102 = 1;
    L4:
        if (r102 >= r100.length) goto L20;
        float r103 = Math.round(r100[r102 - 1] * 10.0f) / 10.0f;
        float r104 = Math.round(r100[r102] * 10.0f) / 10.0f;
        float r105 = r101.left;
        if (r103 >= r105) goto L8;
        r105 = r103;
    L8:
        r101.left = r105;
        float r106 = r101.top;
        if (r104 >= r106) goto L11;
        r106 = r104;
    L11:
        r101.top = r106;
        float r107 = r101.right;
        if (r103 > r107) goto L15;
        r103 = r107;
    L15:
        r101.right = r103;
        float r108 = r101.bottom;
        if (r104 > r108) goto L19;
        r104 = r108;
    L19:
        r101.bottom = r104;
        r102 = r102 + 2;
        goto L4
    L20:
        r101.sort();
        return r101;
    }
}
