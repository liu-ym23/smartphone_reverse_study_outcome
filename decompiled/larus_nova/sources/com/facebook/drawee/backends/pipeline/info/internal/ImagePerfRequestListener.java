package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfRequestListener extends BaseRequestListener {
    private final MonotonicClock mClock;
    private final ImagePerfState mImagePerfState;

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String r100) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setRequestId(r100);
    }

    public ImagePerfRequestListener(MonotonicClock r100, ImagePerfState r101) {
        this.mClock = r100;
        this.mImagePerfState = r101;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(r100);
        this.mImagePerfState.setRequestId(r101);
        this.mImagePerfState.setPrefetch(r102);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(r100);
        this.mImagePerfState.setRequestId(r101);
        this.mImagePerfState.setPrefetch(r103);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        this.mImagePerfState.setImageRequestStartTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(r100);
        this.mImagePerfState.setCallerContext(r101);
        this.mImagePerfState.setRequestId(r102);
        this.mImagePerfState.setPrefetch(r103);
    }
}
