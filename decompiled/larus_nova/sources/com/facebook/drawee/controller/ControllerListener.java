package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ControllerListener<INFO> {
    void onFailure(String r100, Throwable r101);

    void onFinalImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102);

    void onIntermediateImageFailed(String r100, Throwable r101);

    void onIntermediateImageSet(String r100, @Nullable INFO r101);

    void onRelease(String r100);

    void onSubmit(String r100, Object r101);
}
