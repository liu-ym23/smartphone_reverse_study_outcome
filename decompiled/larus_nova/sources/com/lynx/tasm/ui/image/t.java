package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class t implements ScalingUtils.ScaleType {
    public t() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix getTransform(Matrix r100, Rect r101, int r102, int r103, float r104, float r105) {
        float r106 = r101.width() / r102;
        float r107 = r101.height() / r103;
        float r108 = Math.max(r106, r107);
        float r109 = r101.left;
        float r110 = r101.top;
        if (r106 <= r107) goto L5;
        r100.postTranslate(r109, 0.0f);
    L6:
        r100.setScale(r108, r108);
        return r100;
    L5:
        r100.postTranslate(0.0f, r110);
        goto L6
    }
}
