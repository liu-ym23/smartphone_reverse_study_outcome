package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;

/* JADX INFO: loaded from: classes23.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas r100, RectF r101, int r102) {
        if (Build.VERSION.SDK_INT <= 21) goto L7;
        return r100.saveLayerAlpha(r101, r102);
    L7:
        return r100.saveLayerAlpha(r101, r102, 31);
    }

    public static int saveLayerAlpha(Canvas r100, float r101, float r102, float r110, float r111, int r112) {
        if (Build.VERSION.SDK_INT <= 21) goto L7;
        return r100.saveLayerAlpha(r101, r102, r110, r111, r112);
    L7:
        return r100.saveLayerAlpha(r101, r102, r110, r111, r112, 31);
    }
}
