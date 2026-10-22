package com.facebook.drawee.generic;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class GenericDraweeHierarchyBuilder {
    public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = null;
    public static final int DEFAULT_FADE_DURATION = 300;
    public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = null;
    private static int mGlobalFadeDuration;
    private ColorFilter mActualImageColorFilter;
    private PointF mActualImageFocusPoint;
    private Matrix mActualImageMatrix;
    private ScalingUtils.ScaleType mActualImageScaleType;
    private Drawable mBackground;
    private Context mContext;
    private float mDesiredAspectRatio;
    private int mFadeDuration;
    private Drawable mFailureImage;
    private ScalingUtils.ScaleType mFailureImageScaleType;
    private List<Drawable> mOverlays;
    private Drawable mPlaceholderImage;

    @Nullable
    private ScalingUtils.ScaleType mPlaceholderImageScaleType;
    private Drawable mPressedStateOverlay;
    private Drawable mProgressBarImage;
    private ScalingUtils.ScaleType mProgressBarImageScaleType;
    private Resources mResources;
    private Drawable mRetryImage;
    private ScalingUtils.ScaleType mRetryImageScaleType;
    private RoundingParams mRoundingParams;

    static {
        DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
        DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
        mGlobalFadeDuration = -1;
    }

    private void init() {
        int r100 = mGlobalFadeDuration;
        if (r100 >= 0) goto L5;
        r100 = 300;
    L5:
        this.mFadeDuration = r100;
        this.mDesiredAspectRatio = 0.0f;
        this.mPlaceholderImage = null;
        ScalingUtils.ScaleType r101 = DEFAULT_SCALE_TYPE;
        this.mPlaceholderImageScaleType = r101;
        this.mRetryImage = null;
        this.mRetryImageScaleType = r101;
        this.mFailureImage = null;
        this.mFailureImageScaleType = r101;
        this.mProgressBarImage = null;
        this.mProgressBarImageScaleType = r101;
        this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageMatrix = null;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackground = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
    }

    private void validate() {
        List<Drawable> r100 = this.mOverlays;
        if (r100 == null) goto L8;
        Iterator<Drawable> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Preconditions.checkNotNull(r101.next());
        goto L6
    L10:
        return;
    }

    public GenericDraweeHierarchy build() {
        validate();
        return new GenericDraweeHierarchy(this);
    }

    @Nullable
    public ColorFilter getActualImageColorFilter() {
        return this.mActualImageColorFilter;
    }

    @Nullable
    public PointF getActualImageFocusPoint() {
        return this.mActualImageFocusPoint;
    }

    @Nullable
    public ScalingUtils.ScaleType getActualImageScaleType() {
        return this.mActualImageScaleType;
    }

    @Nullable
    public Drawable getBackground() {
        return this.mBackground;
    }

    public Context getContext() {
        return this.mContext;
    }

    public float getDesiredAspectRatio() {
        return this.mDesiredAspectRatio;
    }

    public int getFadeDuration() {
        return this.mFadeDuration;
    }

    @Nullable
    public Drawable getFailureImage() {
        return this.mFailureImage;
    }

    @Nullable
    public ScalingUtils.ScaleType getFailureImageScaleType() {
        return this.mFailureImageScaleType;
    }

    @Nullable
    public List<Drawable> getOverlays() {
        return this.mOverlays;
    }

    @Nullable
    public Drawable getPlaceholderImage() {
        return this.mPlaceholderImage;
    }

    @Nullable
    public ScalingUtils.ScaleType getPlaceholderImageScaleType() {
        return this.mPlaceholderImageScaleType;
    }

    @Nullable
    public Drawable getPressedStateOverlay() {
        return this.mPressedStateOverlay;
    }

    @Nullable
    public Drawable getProgressBarImage() {
        return this.mProgressBarImage;
    }

    @Nullable
    public ScalingUtils.ScaleType getProgressBarImageScaleType() {
        return this.mProgressBarImageScaleType;
    }

    public Resources getResources() {
        return this.mResources;
    }

    @Nullable
    public Drawable getRetryImage() {
        return this.mRetryImage;
    }

    @Nullable
    public ScalingUtils.ScaleType getRetryImageScaleType() {
        return this.mRetryImageScaleType;
    }

    @Nullable
    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    public GenericDraweeHierarchyBuilder reset() {
        init();
        return this;
    }

    public GenericDraweeHierarchyBuilder(Resources r100) {
        this.mResources = r100;
        init();
    }

    public static GenericDraweeHierarchyBuilder newInstance(Resources r100) {
        return new GenericDraweeHierarchyBuilder(r100);
    }

    public static void setDefaultFadeDuration(int r100) {
        mGlobalFadeDuration = r100;
    }

    public GenericDraweeHierarchyBuilder setActualImageColorFilter(@Nullable ColorFilter r100) {
        this.mActualImageColorFilter = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageFocusPoint(@Nullable PointF r100) {
        this.mActualImageFocusPoint = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageScaleType(@Nullable ScalingUtils.ScaleType r100) {
        this.mActualImageScaleType = r100;
        this.mActualImageMatrix = null;
        return this;
    }

    public GenericDraweeHierarchyBuilder setBackground(@Nullable Drawable r100) {
        this.mBackground = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setDesiredAspectRatio(float r100) {
        this.mDesiredAspectRatio = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFadeDuration(int r100) {
        this.mFadeDuration = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int r100) {
        this.mFailureImage = this.mResources.getDrawable(r100);
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImageScaleType(@Nullable ScalingUtils.ScaleType r100) {
        this.mFailureImageScaleType = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setOverlay(@Nullable Drawable r100) {
        if (r100 != null) goto L4;
        this.mOverlays = null;
    L5:
        return this;
    L4:
        this.mOverlays = Arrays.asList(new Drawable[]{r100});
        goto L5
    }

    public GenericDraweeHierarchyBuilder setOverlays(@Nullable List<Drawable> r100) {
        this.mOverlays = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int r100) {
        this.mPlaceholderImage = this.mResources.getDrawable(r100);
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(@Nullable ScalingUtils.ScaleType r100) {
        this.mPlaceholderImageScaleType = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPressedStateOverlay(@Nullable Drawable r100) {
        if (r100 != null) goto L4;
        this.mPressedStateOverlay = null;
    L5:
        return this;
    L4:
        StateListDrawable r101 = new StateListDrawable();
        r101.addState(new int[]{R.attr.state_pressed}, r100);
        this.mPressedStateOverlay = r101;
        goto L5
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int r100) {
        this.mProgressBarImage = this.mResources.getDrawable(r100);
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImageScaleType(@Nullable ScalingUtils.ScaleType r100) {
        this.mProgressBarImageScaleType = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int r100) {
        this.mRetryImage = this.mResources.getDrawable(r100);
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImageScaleType(@Nullable ScalingUtils.ScaleType r100) {
        this.mRetryImageScaleType = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRoundingParams(@Nullable RoundingParams r100) {
        this.mRoundingParams = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(@Nullable Drawable r100) {
        this.mFailureImage = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(@Nullable Drawable r100) {
        this.mPlaceholderImage = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(@Nullable Drawable r100) {
        this.mProgressBarImage = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(@Nullable Drawable r100) {
        this.mRetryImage = r100;
        return this;
    }

    public GenericDraweeHierarchyBuilder(Context r100, Resources r101) {
        this.mContext = r100;
        this.mResources = r101;
        init();
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mFailureImage = this.mResources.getDrawable(r100);
        this.mFailureImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mPlaceholderImage = this.mResources.getDrawable(r100);
        this.mPlaceholderImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mProgressBarImage = this.mResources.getDrawable(r100);
        this.mProgressBarImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mRetryImage = this.mResources.getDrawable(r100);
        this.mRetryImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mFailureImage = r100;
        this.mFailureImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mPlaceholderImage = r100;
        this.mPlaceholderImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mProgressBarImage = r100;
        this.mProgressBarImageScaleType = r101;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable r100, @Nullable ScalingUtils.ScaleType r101) {
        this.mRetryImage = r100;
        this.mRetryImageScaleType = r101;
        return this;
    }
}
