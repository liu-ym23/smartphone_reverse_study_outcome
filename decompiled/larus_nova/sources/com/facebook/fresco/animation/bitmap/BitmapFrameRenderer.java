package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Rect;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface BitmapFrameRenderer {
    int getIntrinsicHeight();

    int getIntrinsicWidth();

    boolean renderFrame(int r100, Bitmap r101);

    void setBounds(@Nullable Rect r100);
}
