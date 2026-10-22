package com.vivo.push.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static Bitmap a(Bitmap r100, int r101, int r102) {
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        float r105 = r101 / r103;
        float r106 = r102 / r104;
        Matrix r107 = new Matrix();     // Catch: Exception -> L5
        r107.postScale(r105, r106);     // Catch: Exception -> L5
        return Bitmap.createBitmap(r100, 0, 0, r103, r104, r107, true);
    L8:
        return r100;
    }
}
