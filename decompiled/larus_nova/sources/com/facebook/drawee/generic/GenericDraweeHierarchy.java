package com.facebook.drawee.generic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    private static final int ACTUAL_IMAGE_INDEX = 2;
    private static final int BACKGROUND_IMAGE_INDEX = 0;
    private static final int FAILURE_IMAGE_INDEX = 5;
    private static final int OVERLAY_IMAGES_INDEX = 6;
    private static final int PLACEHOLDER_IMAGE_INDEX = 1;
    private static final int PROGRESS_BAR_IMAGE_INDEX = 3;
    private static final int RETRY_IMAGE_INDEX = 4;
    private final ForwardingDrawable mActualImageWrapper;
    private Context mContext;
    private final Drawable mEmptyActualImageDrawable;
    private final FadeDrawable mFadeDrawable;
    private final Resources mResources;

    @Nullable
    private RoundingParams mRoundingParams;
    private final RootDrawable mTopLevelDrawable;

    private void fadeOutBranches() {
        fadeOutLayer(1);
        fadeOutLayer(2);
        fadeOutLayer(3);
        fadeOutLayer(4);
        fadeOutLayer(5);
    }

    @Nullable
    public ScalingUtils.ScaleType getActualImageScaleType() {
        if (hasScaleTypeDrawableAtIndex(2) == true) goto L7;
        return null;
    L7:
        return getScaleTypeDrawableAtIndex(2).getScaleType();
    }

    private void resetActualImages() {
        this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
    }

    private void resetFade() {
        FadeDrawable r100 = this.mFadeDrawable;
        if (r100 == null) goto L6;
        r100.beginBatchMode();
        this.mFadeDrawable.fadeInAllLayers();
        fadeOutBranches();
        fadeInLayer(1);
        this.mFadeDrawable.finishTransitionImmediately();
        this.mFadeDrawable.endBatchMode();
        return;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public Drawable getControllerOverlay() {
        return this.mTopLevelDrawable.getControllerOverlay();
    }

    public int getFadeDuration() {
        return this.mFadeDrawable.getTransitionDuration();
    }

    public boolean hasImage() {
        if (this.mActualImageWrapper.getDrawable() == this.mEmptyActualImageDrawable) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasPlaceholderImage() {
        if (this.mFadeDrawable.getDrawable(1) != null) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void stopDrawUntilSetImage() {
        this.mActualImageWrapper.stopDrawUntilSetDrawable();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        resetActualImages();
        resetFade();
    }

    @Nullable
    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder r110) {
        int r100 = 0;
        ColorDrawable r101 = new ColorDrawable(0);
        this.mEmptyActualImageDrawable = r101;
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("GenericDraweeHierarchy()");
    L5:
        this.mResources = r110.getResources();
        this.mContext = r110.getContext();
        this.mRoundingParams = r110.getRoundingParams();
        ForwardingDrawable r102 = new ForwardingDrawable(r101);
        this.mActualImageWrapper = r102;
        int r103 = 1;
        if (r110.getOverlays() == null) goto L8;
        int r104 = r110.getOverlays().size();
    L10:
        if (r110.getPressedStateOverlay() == null) goto L12;
        int r105 = 1;
    L13:
        int r106 = r104 + r105;
        Drawable[] r107 = new Drawable[r106 + 6];
        r107[0] = buildBranch(r110.getBackground(), null);
        r107[1] = buildBranch(r110.getPlaceholderImage(), r110.getPlaceholderImageScaleType());
        r107[2] = buildActualImageBranch(r102, r110.getActualImageScaleType(), r110.getActualImageFocusPoint(), r110.getActualImageColorFilter());
        r107[3] = buildBranch(r110.getProgressBarImage(), r110.getProgressBarImageScaleType());
        r107[4] = buildBranch(r110.getRetryImage(), r110.getRetryImageScaleType());
        r107[5] = buildBranch(r110.getFailureImage(), r110.getFailureImageScaleType());
        if (r106 > 0) goto L16;
    L25:
        FadeDrawable r108 = new FadeDrawable(r107);
        this.mFadeDrawable = r108;
        r108.setTransitionDuration(r110.getFadeDuration());
        RootDrawable r109 = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(r108, this.mRoundingParams));
        this.mTopLevelDrawable = r109;
        r109.mutate();
        resetFade();
        if (FrescoSystrace.isTracing() == false) goto L30;
        FrescoSystrace.endSection();
        return;
    L30:
        return;
    L16:
        if (r110.getOverlays() == null) goto L23;
        Iterator<Drawable> r111 = r110.getOverlays().iterator();
    L19:
        if (r111.hasNext() == false) goto L21;
        int r112 = r100 + 1;
        r107[r100 + 6] = buildBranch(r111.next(), null);
        r100 = r112;
        goto L19
    L21:
        r103 = r100;
    L23:
        if (r110.getPressedStateOverlay() == null) goto L25;
        r107[r103 + 6] = buildBranch(r110.getPressedStateOverlay(), null);
        goto L25
    L12:
        r105 = 0;
        goto L13
    L8:
        r104 = 1;
        goto L10
    }

    private void fadeInLayer(int r100) {
        if (r100 < 0) goto L5;
        this.mFadeDrawable.fadeInLayer(r100);
        return;
    }

    private void fadeOutLayer(int r100) {
        if (r100 < 0) goto L5;
        this.mFadeDrawable.fadeOutLayer(r100);
        return;
    }

    private DrawableParent getParentDrawableAtIndex(int r100) {
        DrawableParent r101 = this.mFadeDrawable.getDrawableParentForIndex(r100);
        if ((r101.getDrawable() instanceof MatrixDrawable) == false) goto L6;
        r101 = (MatrixDrawable) r101.getDrawable();
    L6:
        if ((r101.getDrawable() instanceof ScaleTypeDrawable) == true) goto L8;
        return r101;
    L8:
        return (ScaleTypeDrawable) r101.getDrawable();
    }

    private ScaleTypeDrawable getScaleTypeDrawableAtIndex(int r100) {
        DrawableParent r101 = getParentDrawableAtIndex(r100);
        if ((r101 instanceof ScaleTypeDrawable) == false) goto L7;
        return (ScaleTypeDrawable) r101;
    L7:
        return WrappingUtils.wrapChildWithScaleType(r101, ScalingUtils.ScaleType.FIT_XY);
    }

    private boolean hasScaleTypeDrawableAtIndex(int r100) {
        return getParentDrawableAtIndex(r100) instanceof ScaleTypeDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setProgress(float r100) {
        Drawable r101 = this.mFadeDrawable.getDrawable(3);
        if (r101 != 0) goto L6;
        return;
    L6:
        if (r100 < 0.999f) goto L12;
        if ((r101 instanceof Animatable) == false) goto L10;
        ((Animatable) r101).stop();
    L10:
        fadeOutLayer(3);
    L15:
        r101.setLevel(Math.round(r100 * 10000.0f));
        return;
    L12:
        if ((r101 instanceof Animatable) == false) goto L14;
        ((Animatable) r101).start();
    L14:
        fadeInLayer(3);
        goto L15
    }

    public void getActualImageBounds(RectF r100) {
        this.mActualImageWrapper.getTransformedBounds(r100);
    }

    public void setActualImageColorFilter(ColorFilter r100) {
        this.mActualImageWrapper.setColorFilter(r100);
    }

    public void setActualImageFocusPoint(PointF r100) {
        Preconditions.checkNotNull(r100);
        getScaleTypeDrawableAtIndex(2).setFocusPoint(r100);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType r100) {
        Preconditions.checkNotNull(r100);
        getScaleTypeDrawableAtIndex(2).setScaleType(r100);
    }

    public void setBackgroundImage(@Nullable Drawable r100) {
        setChildDrawableAtIndex(0, r100);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setControllerOverlay(@Nullable Drawable r100) {
        this.mTopLevelDrawable.setControllerOverlay(r100);
    }

    public void setFadeDuration(int r100) {
        this.mFadeDrawable.setTransitionDuration(r100);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setFailure(Throwable r100) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(5) == null) goto L5;
        fadeInLayer(5);
    L6:
        this.mFadeDrawable.endBatchMode();
        return;
    L5:
        fadeInLayer(1);
        goto L6
    }

    public void setFailureImage(int r100) {
        setFailureImage(this.mResources.getDrawable(r100));
    }

    public void setOverlayImage(@Nullable Drawable r100) {
        setOverlayImage(0, r100);
    }

    public void setPlaceholderImage(int r100) {
        setPlaceholderImage(this.mResources.getDrawable(r100));
    }

    public void setPlaceholderImageFocusPoint(PointF r100) {
        Preconditions.checkNotNull(r100);
        getScaleTypeDrawableAtIndex(1).setFocusPoint(r100);
    }

    public void setProgressBarImage(int r100) {
        setProgressBarImage(this.mResources.getDrawable(r100));
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setRetry(Throwable r100) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(4) == null) goto L5;
        fadeInLayer(4);
    L6:
        this.mFadeDrawable.endBatchMode();
        return;
    L5:
        fadeInLayer(1);
        goto L6
    }

    public void setRetryImage(int r100) {
        setRetryImage(this.mResources.getDrawable(r100));
    }

    public void setRoundingParams(@Nullable RoundingParams r100) {
        this.mRoundingParams = r100;
        WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, r100);
        int r101 = 0;
    L4:
        if (r101 >= this.mFadeDrawable.getNumberOfLayers()) goto L6;
        WrappingUtils.updateLeafRounding(getParentDrawableAtIndex(r101), this.mRoundingParams, this.mResources);
        r101 = r101 + 1;
        goto L4
    }

    public void setFailureImage(@Nullable Drawable r100) {
        setChildDrawableAtIndex(5, r100);
    }

    public void setPlaceholderImage(@Nullable Drawable r100) {
        setChildDrawableAtIndex(1, r100);
    }

    public void setProgressBarImage(@Nullable Drawable r100) {
        setChildDrawableAtIndex(3, r100);
    }

    public void setRetryImage(@Nullable Drawable r100) {
        setChildDrawableAtIndex(4, r100);
    }

    public static /* synthetic */ ScaleTypeDrawable access$100(GenericDraweeHierarchy r100, int r101) {
        return r100.getScaleTypeDrawableAtIndex(r101);
    }

    @Nullable
    private Drawable buildBranch(@Nullable Drawable r100, @Nullable ScalingUtils.ScaleType r101) {
        return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(r100, this.mRoundingParams, this.mResources), r101);
    }

    private void setChildDrawableAtIndex(int r100, @Nullable Drawable r101) {
        if (r101 != null) goto L5;
        this.mFadeDrawable.setDrawable(r100, null);
        return;
    L5:
        Drawable r102 = WrappingUtils.maybeApplyLeafRounding(r101, this.mRoundingParams, this.mResources);
        getParentDrawableAtIndex(r100).setDrawable(r102);
    }

    public void setFailureImage(Drawable r100, ScalingUtils.ScaleType r101) {
        setChildDrawableAtIndex(5, r100);
        getScaleTypeDrawableAtIndex(5).setScaleType(r101);
    }

    public void setOverlayImage(int r100, @Nullable Drawable r101) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r102 = false;
    L7:
        Preconditions.checkArgument(r102, "The given index does not correspond to an overlay image.");
        setChildDrawableAtIndex(r100 + 6, r101);
        return;
    L4:
        if ((r100 + 6) >= this.mFadeDrawable.getNumberOfLayers()) goto L6;
        r102 = true;
        goto L7
    }

    public void setPlaceholderImage(final Drawable r100, final ScalingUtils.ScaleType r101) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L7;
        Context r102 = this.mContext;
        if ((r102 instanceof Activity) == false) goto L9;
        ((Activity) r102).runOnUiThread(new AnonymousClass1(this, r100, r101));
        return;
    L9:
        return;
    L7:
        setChildDrawableAtIndex(1, r100);
        getScaleTypeDrawableAtIndex(1).setScaleType(r101);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setProgress(float r100, boolean r101) {
        if (this.mFadeDrawable.getDrawable(3) != null) goto L5;
        return;
    L5:
        this.mFadeDrawable.beginBatchMode();
        setProgress(r100);
        if (r101 == false) goto L8;
        this.mFadeDrawable.finishTransitionImmediately();
    L8:
        this.mFadeDrawable.endBatchMode();
    }

    public void setProgressBarImage(Drawable r100, ScalingUtils.ScaleType r101) {
        setChildDrawableAtIndex(3, r100);
        getScaleTypeDrawableAtIndex(3).setScaleType(r101);
    }

    public void setRetryImage(Drawable r100, ScalingUtils.ScaleType r101) {
        setChildDrawableAtIndex(4, r100);
        getScaleTypeDrawableAtIndex(4).setScaleType(r101);
    }

    public void setFailureImage(int r100, ScalingUtils.ScaleType r101) {
        setFailureImage(this.mResources.getDrawable(r100), r101);
    }

    public void setPlaceholderImage(int r100, ScalingUtils.ScaleType r101) {
        setPlaceholderImage(this.mResources.getDrawable(r100), r101);
    }

    public void setProgressBarImage(int r100, ScalingUtils.ScaleType r101) {
        setProgressBarImage(this.mResources.getDrawable(r100), r101);
    }

    public void setRetryImage(int r100, ScalingUtils.ScaleType r101) {
        setRetryImage(this.mResources.getDrawable(r100), r101);
    }

    public static /* synthetic */ void access$000(GenericDraweeHierarchy r100, int r101, Drawable r102) {
        r100.setChildDrawableAtIndex(r101, r102);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setImage(Drawable r100, float r101, boolean r102) {
        Drawable r103 = WrappingUtils.maybeApplyLeafRounding(r100, this.mRoundingParams, this.mResources);
        r103.mutate();
        this.mActualImageWrapper.setDrawable(r103);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(2);
        setProgress(r101);
        if (r102 == false) goto L5;
        this.mFadeDrawable.finishTransitionImmediately();
    L5:
        this.mFadeDrawable.endBatchMode();
    }

    @Nullable
    private Drawable buildActualImageBranch(Drawable r100, @Nullable ScalingUtils.ScaleType r101, @Nullable PointF r102, @Nullable ColorFilter r103) {
        r100.setColorFilter(r103);
        return WrappingUtils.maybeWrapWithScaleType(r100, r101, r102);
    }
}
