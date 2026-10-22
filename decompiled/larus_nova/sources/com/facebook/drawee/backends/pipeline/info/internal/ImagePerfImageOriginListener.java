package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfImageOriginListener implements ImageOriginListener {
    private final ImagePerfMonitor mImagePerfMonitor;
    private final ImagePerfState mImagePerfState;

    public ImagePerfImageOriginListener(ImagePerfState r100, ImagePerfMonitor r101) {
        this.mImagePerfState = r100;
        this.mImagePerfMonitor = r101;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String r100, int r101, boolean r102) {
        this.mImagePerfState.setImageOrigin(r101);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 1);
    }
}
