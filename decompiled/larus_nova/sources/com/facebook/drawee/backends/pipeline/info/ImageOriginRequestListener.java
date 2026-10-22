package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImageOriginRequestListener extends BaseRequestListener {
    private String mControllerId;

    @Nullable
    private final ImageOriginListener mImageOriginLister;

    public void init(String r100) {
        this.mControllerId = r100;
    }

    public ImageOriginRequestListener(String r100, @Nullable ImageOriginListener r101) {
        this.mImageOriginLister = r101;
        init(r100);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String r100, String r101, boolean r102) {
        ImageOriginListener r103 = this.mImageOriginLister;
        if (r103 == null) goto L6;
        r103.onImageLoaded(this.mControllerId, ImageOriginUtils.mapProducerNameToImageOrigin(r101), r102);
        return;
    }
}
