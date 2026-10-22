package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    private long mFinalImageSetTimeMs;

    @Nullable
    private ImageLoadingTimeListener mImageLoadingTimeListener;
    private long mRequestSubmitTimeMs;

    public ImageLoadingTimeControllerListener(@Nullable ImageLoadingTimeListener r100) {
        this.mRequestSubmitTimeMs = -1;
        this.mFinalImageSetTimeMs = -1;
        this.mImageLoadingTimeListener = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String r100, Object r101) {
        this.mRequestSubmitTimeMs = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String r100, @Nullable Object r101, @Nullable Animatable r102) {
        long r103 = System.currentTimeMillis();
        this.mFinalImageSetTimeMs = r103;
        ImageLoadingTimeListener r104 = this.mImageLoadingTimeListener;
        if (r104 == null) goto L6;
        r104.onFinalImageSet(r103 - this.mRequestSubmitTimeMs);
        return;
    }
}
