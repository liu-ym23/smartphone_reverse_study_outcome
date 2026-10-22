package com.facebook.drawee.backends.pipeline.info;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.pia.core.metrics.ErrorType;
import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfData {
    public static final int UNSET = -1;

    @Nullable
    private final Object mCallerContext;
    private final long mControllerCancelTimeMs;
    private final long mControllerFailureTimeMs;
    private final long mControllerFinalImageSetTimeMs;

    @Nullable
    private final String mControllerId;
    private final long mControllerIntermediateImageSetTimeMs;
    private final long mControllerSubmitTimeMs;

    @Nullable
    private final ImageInfo mImageInfo;
    private final int mImageOrigin;

    @Nullable
    private final ImageRequest mImageRequest;
    private final long mImageRequestEndTimeMs;
    private final long mImageRequestStartTimeMs;
    private final long mInvisibilityEventTimeMs;
    private final boolean mIsPrefetch;
    private final int mOnScreenHeightPx;
    private final int mOnScreenWidthPx;

    @Nullable
    private final String mRequestId;
    private final long mVisibilityEventTimeMs;
    private final int mVisibilityState;

    public String createDebugString() {
        return Objects.toStringHelper(this).add("controller ID", this.mControllerId).add("request ID", this.mRequestId).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add(PlayerResolution.SDKKEY.ORIGIN, ImageOriginUtils.toString(this.mImageOrigin)).add(ErrorType.PREFETCH, this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", this.mImageRequest).add("image info", this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).toString();
    }

    public long getFinalImageLoadTimeMs() {
        if (getImageRequestEndTimeMs() != (-1)) goto L5;
    L9:
        return -1;
    L5:
        if (getImageRequestStartTimeMs() == (-1)) goto L9;
        return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
    }

    public long getIntermediateImageLoadTimeMs() {
        if (getControllerIntermediateImageSetTimeMs() != (-1)) goto L5;
    L9:
        return -1;
    L5:
        if (getControllerSubmitTimeMs() == (-1)) goto L9;
        return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public long getControllerFailureTimeMs() {
        return this.mControllerFailureTimeMs;
    }

    public long getControllerFinalImageSetTimeMs() {
        return this.mControllerFinalImageSetTimeMs;
    }

    @Nullable
    public String getControllerId() {
        return this.mControllerId;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        return this.mControllerIntermediateImageSetTimeMs;
    }

    public long getControllerSubmitTimeMs() {
        return this.mControllerSubmitTimeMs;
    }

    @Nullable
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getImageOrigin() {
        return this.mImageOrigin;
    }

    @Nullable
    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public long getImageRequestEndTimeMs() {
        return this.mImageRequestEndTimeMs;
    }

    public long getImageRequestStartTimeMs() {
        return this.mImageRequestStartTimeMs;
    }

    public long getInvisibilityEventTimeMs() {
        return this.mInvisibilityEventTimeMs;
    }

    public int getOnScreenHeightPx() {
        return this.mOnScreenHeightPx;
    }

    public int getOnScreenWidthPx() {
        return this.mOnScreenWidthPx;
    }

    @Nullable
    public String getRequestId() {
        return this.mRequestId;
    }

    public long getVisibilityEventTimeMs() {
        return this.mVisibilityEventTimeMs;
    }

    public int getVisibilityState() {
        return this.mVisibilityState;
    }

    public boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    public ImagePerfData(@Nullable String r100, @Nullable String r101, @Nullable ImageRequest r102, @Nullable Object r103, @Nullable ImageInfo r104, long r105, long r110, long r111, long r112, long r113, long r114, long r210, int r211, boolean r212, int r213, int r214, int r215, long r216, long r310) {
        this.mControllerId = r100;
        this.mRequestId = r101;
        this.mImageRequest = r102;
        this.mCallerContext = r103;
        this.mImageInfo = r104;
        this.mControllerSubmitTimeMs = r105;
        this.mControllerIntermediateImageSetTimeMs = r110;
        this.mControllerFinalImageSetTimeMs = r111;
        this.mControllerFailureTimeMs = r112;
        this.mControllerCancelTimeMs = r113;
        this.mImageRequestStartTimeMs = r114;
        this.mImageRequestEndTimeMs = r210;
        this.mImageOrigin = r211;
        this.mIsPrefetch = r212;
        this.mOnScreenWidthPx = r213;
        this.mOnScreenHeightPx = r214;
        this.mVisibilityState = r215;
        this.mVisibilityEventTimeMs = r216;
        this.mInvisibilityEventTimeMs = r310;
    }
}
