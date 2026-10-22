package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfState {

    @Nullable
    private Object mCallerContext;
    private long mControllerCancelTimeMs;
    private long mControllerFailureTimeMs;
    private long mControllerFinalImageSetTimeMs;

    @Nullable
    private String mControllerId;
    private long mControllerIntermediateImageSetTimeMs;
    private long mControllerSubmitTimeMs;

    @Nullable
    private ImageInfo mImageInfo;
    private int mImageLoadStatus;
    private int mImageOrigin;

    @Nullable
    private ImageRequest mImageRequest;
    private long mImageRequestEndTimeMs;
    private long mImageRequestStartTimeMs;
    private long mInvisibilityEventTimeMs;
    private boolean mIsPrefetch;
    private int mOnScreenHeightPx;
    private int mOnScreenWidthPx;

    @Nullable
    private String mRequestId;
    private long mVisibilityEventTimeMs;
    private int mVisibilityState;

    public void reset() {
        this.mRequestId = null;
        this.mImageRequest = null;
        this.mCallerContext = null;
        this.mImageInfo = null;
        this.mControllerSubmitTimeMs = -1;
        this.mControllerFinalImageSetTimeMs = -1;
        this.mControllerFailureTimeMs = -1;
        this.mControllerCancelTimeMs = -1;
        this.mImageRequestStartTimeMs = -1;
        this.mImageRequestEndTimeMs = -1;
        this.mImageOrigin = 1;
        this.mIsPrefetch = false;
        this.mOnScreenWidthPx = -1;
        this.mOnScreenHeightPx = -1;
        this.mImageLoadStatus = -1;
        this.mVisibilityState = -1;
        this.mVisibilityEventTimeMs = -1;
        this.mInvisibilityEventTimeMs = -1;
    }

    public ImagePerfData snapshot() {
        return new ImagePerfData(this.mControllerId, this.mRequestId, this.mImageRequest, this.mCallerContext, this.mImageInfo, this.mControllerSubmitTimeMs, this.mControllerIntermediateImageSetTimeMs, this.mControllerFinalImageSetTimeMs, this.mControllerFailureTimeMs, this.mControllerCancelTimeMs, this.mImageRequestStartTimeMs, this.mImageRequestEndTimeMs, this.mImageOrigin, this.mIsPrefetch, this.mOnScreenWidthPx, this.mOnScreenHeightPx, this.mVisibilityState, this.mVisibilityEventTimeMs, this.mInvisibilityEventTimeMs);
    }

    public ImagePerfState() {
        this.mControllerSubmitTimeMs = -1;
        this.mControllerIntermediateImageSetTimeMs = -1;
        this.mControllerFinalImageSetTimeMs = -1;
        this.mControllerFailureTimeMs = -1;
        this.mControllerCancelTimeMs = -1;
        this.mImageRequestStartTimeMs = -1;
        this.mImageRequestEndTimeMs = -1;
        this.mImageOrigin = -1;
        this.mOnScreenWidthPx = -1;
        this.mOnScreenHeightPx = -1;
        this.mImageLoadStatus = -1;
        this.mVisibilityState = -1;
        this.mVisibilityEventTimeMs = -1;
        this.mInvisibilityEventTimeMs = -1;
    }

    public int getImageLoadStatus() {
        return this.mImageLoadStatus;
    }

    public void setCallerContext(@Nullable Object r100) {
        this.mCallerContext = r100;
    }

    public void setControllerCancelTimeMs(long r100) {
        this.mControllerCancelTimeMs = r100;
    }

    public void setControllerFailureTimeMs(long r100) {
        this.mControllerFailureTimeMs = r100;
    }

    public void setControllerFinalImageSetTimeMs(long r100) {
        this.mControllerFinalImageSetTimeMs = r100;
    }

    public void setControllerId(@Nullable String r100) {
        this.mControllerId = r100;
    }

    public void setControllerIntermediateImageSetTimeMs(long r100) {
        this.mControllerIntermediateImageSetTimeMs = r100;
    }

    public void setControllerSubmitTimeMs(long r100) {
        this.mControllerSubmitTimeMs = r100;
    }

    public void setImageInfo(@Nullable ImageInfo r100) {
        this.mImageInfo = r100;
    }

    public void setImageLoadStatus(int r100) {
        this.mImageLoadStatus = r100;
    }

    public void setImageOrigin(int r100) {
        this.mImageOrigin = r100;
    }

    public void setImageRequest(@Nullable ImageRequest r100) {
        this.mImageRequest = r100;
    }

    public void setImageRequestEndTimeMs(long r100) {
        this.mImageRequestEndTimeMs = r100;
    }

    public void setImageRequestStartTimeMs(long r100) {
        this.mImageRequestStartTimeMs = r100;
    }

    public void setInvisibilityEventTimeMs(long r100) {
        this.mInvisibilityEventTimeMs = r100;
    }

    public void setOnScreenHeight(int r100) {
        this.mOnScreenHeightPx = r100;
    }

    public void setOnScreenWidth(int r100) {
        this.mOnScreenWidthPx = r100;
    }

    public void setPrefetch(boolean r100) {
        this.mIsPrefetch = r100;
    }

    public void setRequestId(@Nullable String r100) {
        this.mRequestId = r100;
    }

    public void setVisibilityEventTimeMs(long r100) {
        this.mVisibilityEventTimeMs = r100;
    }

    public void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 1;
    L5:
        this.mVisibilityState = r101;
        return;
    L4:
        r101 = 2;
        goto L5
    }
}
