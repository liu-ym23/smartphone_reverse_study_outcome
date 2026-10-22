package com.facebook.drawee.backends.pipeline.info.internal;

import android.graphics.drawable.Animatable;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfControllerListener extends BaseControllerListener<ImageInfo> {
    private final MonotonicClock mClock;
    private final ImagePerfMonitor mImagePerfMonitor;
    private final ImagePerfState mImagePerfState;

    private void reportViewInvisible(long r100) {
        this.mImagePerfState.setVisible(false);
        this.mImagePerfState.setInvisibilityEventTimeMs(r100);
        this.mImagePerfMonitor.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, 2);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onRelease(String r100) {
        super.onRelease(r100);
        long r101 = this.mClock.now();
        int r102 = this.mImagePerfState.getImageLoadStatus();
        if (r102 != 3) goto L5;
    L7:
        reportViewInvisible(r101);
        return;
    L5:
        if (r102 == 5) goto L7;
        this.mImagePerfState.setControllerCancelTimeMs(r101);
        this.mImagePerfState.setControllerId(r100);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 4);
        goto L7
    }

    public void reportViewVisible(long r100) {
        this.mImagePerfState.setVisible(true);
        this.mImagePerfState.setVisibilityEventTimeMs(r100);
        this.mImagePerfMonitor.notifyListenersOfVisibilityStateUpdate(this.mImagePerfState, 1);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFailure(String r100, Throwable r101) {
        long r102 = this.mClock.now();
        this.mImagePerfState.setControllerFailureTimeMs(r102);
        this.mImagePerfState.setControllerId(r100);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 5);
        reportViewInvisible(r102);
    }

    public void onIntermediateImageSet(String r100, @Nullable ImageInfo r101) {
        long r102 = this.mClock.now();
        this.mImagePerfState.setControllerIntermediateImageSetTimeMs(r102);
        this.mImagePerfState.setControllerId(r100);
        this.mImagePerfState.setImageInfo(r101);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 2);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String r100, Object r101) {
        long r102 = this.mClock.now();
        this.mImagePerfState.setControllerSubmitTimeMs(r102);
        this.mImagePerfState.setControllerId(r100);
        this.mImagePerfState.setCallerContext(r101);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 0);
        reportViewVisible(r102);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, @Nullable Object r101) {
        onIntermediateImageSet(r100, (ImageInfo) r101);
    }

    public ImagePerfControllerListener(MonotonicClock r100, ImagePerfState r101, ImagePerfMonitor r102) {
        this.mClock = r100;
        this.mImagePerfState = r101;
        this.mImagePerfMonitor = r102;
    }

    public void onFinalImageSet(String r100, @Nullable ImageInfo r101, @Nullable Animatable r102) {
        long r103 = this.mClock.now();
        this.mImagePerfState.setControllerFinalImageSetTimeMs(r103);
        this.mImagePerfState.setImageRequestEndTimeMs(r103);
        this.mImagePerfState.setControllerId(r100);
        this.mImagePerfState.setImageInfo(r101);
        this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 3);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String r100, @Nullable Object r101, @Nullable Animatable r102) {
        onFinalImageSet(r100, (ImageInfo) r101, r102);
    }
}
