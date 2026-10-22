package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public interface SettableDraweeHierarchy extends DraweeHierarchy {
    Drawable getControllerOverlay();

    void reset();

    void setControllerOverlay(Drawable r100);

    void setFailure(Throwable r100);

    void setImage(Drawable r100, float r101, boolean r102);

    void setProgress(float r100, boolean r101);

    void setRetry(Throwable r100);

    void stopDrawUntilSetImage();
}
