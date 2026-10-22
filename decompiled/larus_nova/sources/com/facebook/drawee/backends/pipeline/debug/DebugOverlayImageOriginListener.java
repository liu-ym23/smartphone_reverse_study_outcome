package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

/* JADX INFO: loaded from: classes23.dex */
public class DebugOverlayImageOriginListener implements ImageOriginListener {
    private int mImageOrigin;

    public String getImageOrigin() {
        return ImageOriginUtils.toString(this.mImageOrigin);
    }

    public DebugOverlayImageOriginListener() {
        this.mImageOrigin = 1;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String r100, int r101, boolean r102) {
        this.mImageOrigin = r101;
    }
}
