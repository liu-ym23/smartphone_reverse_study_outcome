package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled;
    private float mAspectRatio;
    private DraweeHolder<DH> mDraweeHolder;
    private boolean mInitialised;
    protected boolean mIsSupportAsync;
    private LazySizeAttach mLazySizeAttach;
    private boolean mLegacyVisibilityHandlingEnabled;
    private final AspectRatioMeasure.Spec mMeasureSpec;
    private SizeDeterminer mSizeDeterminer;

    private void maybeOverrideVisibilityHandling() {
        if (this.mLegacyVisibilityHandlingEnabled == false) goto L12;
        Drawable r100 = getDrawable();
        if (r100 != null) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r101 = true;
    L10:
        r100.setVisible(r101, false);
        return;
    L9:
        r101 = false;
        goto L10
    }

    public void cancelLazySizeAttach() {
        LazySizeAttach r100 = this.mLazySizeAttach;
        if (r100 == null) goto L6;
        this.mSizeDeterminer.removeCallback(r100);
        this.mLazySizeAttach = null;
        return;
    }

    public void doAttach() {
        this.mDraweeHolder.onAttach();
    }

    public void doDetach() {
        this.mDraweeHolder.onDetach();
    }

    @Nullable
    public DraweeController getController() {
        return this.mDraweeHolder.getController();
    }

    public DH getHierarchy() {
        return (DH) this.mDraweeHolder.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public boolean hasController() {
        if (this.mDraweeHolder.getController() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.hasHierarchy();
    }

    public boolean hasLazySizeAttached() {
        if (this.mLazySizeAttach == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        this.mSizeDeterminer.clearCallbacksAndListener();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public String toString() {
        Objects.ToStringHelper r100 = Objects.toStringHelper(this);
        DraweeHolder<DH> r101 = this.mDraweeHolder;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L7:
        return r100.add("holder", r102).toString();
    L5:
        r102 = "<no holder set>";
        goto L7
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public boolean isSupportAsync() {
        return this.mIsSupportAsync;
    }

    public void onAttach() {
        doAttach();
    }

    public void onDetach() {
        doDetach();
    }

    public DraweeView(Context r100) {
        super(r100);
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mIsSupportAsync = false;
        init(r100);
    }

    public static /* synthetic */ void access$100(DraweeView r100) {
        r100.maybeOverrideVisibilityHandling();
    }

    private void init(Context r100) {
    L29:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L33;
        FrescoSystrace.endSection();
    L33:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("DraweeView#init");     // Catch: Throwable -> L29
    L6:
        if (this.mInitialised == true) goto L8;
        boolean r101 = true;
        this.mInitialised = true;     // Catch: Throwable -> L29
        this.mDraweeHolder = DraweeHolder.create(null, r100);     // Catch: Throwable -> L29
        this.mSizeDeterminer = new SizeDeterminer(this);     // Catch: Throwable -> L29
        ColorStateList r102 = getImageTintList();     // Catch: Throwable -> L29
        if (r102 == null) goto L15;
        setColorFilter(r102.getDefaultColor());     // Catch: Throwable -> L29
        if (sGlobalLegacyVisibilityHandlingEnabled == true) goto L21;
    L23:
        r101 = false;
    L24:
        this.mLegacyVisibilityHandlingEnabled = r101;     // Catch: Throwable -> L29
        if (FrescoSystrace.isTracing() == false) goto L38;
        FrescoSystrace.endSection();
        return;
    L38:
        return;
    L21:
        if (r100.getApplicationInfo().targetSdkVersion < 24) goto L23;
    L15:
        if (FrescoSystrace.isTracing() == false) goto L37;
        FrescoSystrace.endSection();
        return;
    L37:
        return;
    L8:
        if (FrescoSystrace.isTracing() == false) goto L36;
        FrescoSystrace.endSection();
        return;
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean r100) {
        sGlobalLegacyVisibilityHandlingEnabled = r100;
    }

    public void controllerAttachSizeDeterminer(DraweeController r100) {
        if ((r100 instanceof AbstractDraweeController) == false) goto L9;
        AbstractDraweeController r101 = (AbstractDraweeController) r100;
        ImageRequest r102 = r101.getImageRequest();
        if (r102 == null) goto L7;
        r102.setSizeDeterminer(this.mSizeDeterminer);
        return;
    L7:
        r101.setSizeDeterminer(this.mSizeDeterminer);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mDraweeHolder.onTouchEvent(r100) == false) goto L7;
        return true;
    L7:
        return super.onTouchEvent(r100);
    }

    public void setAspectRatio(float r100) {
        if (r100 != this.mAspectRatio) goto L5;
        return;
    L5:
        this.mAspectRatio = r100;
        requestLayout();
    }

    public void setController(@Nullable DraweeController r100) {
        cancelLazySizeAttach();
        controllerAttachSizeDeterminer(r100);
        this.mDraweeHolder.setController(r100);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public void setHierarchy(DH r100) {
        this.mDraweeHolder.setHierarchy(r100);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        init(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.setController(null);
        super.setImageBitmap(r100);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        init(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.setController(null);
        super.setImageDrawable(r100);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        init(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.setController(null);
        super.setImageResource(r100);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r100) {
        init(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.setController(null);
        super.setImageURI(r100);
    }

    public void setLazySizeAttach(LazySizeAttach r100) {
        if (this.mLazySizeAttach == null) goto L5;
        cancelLazySizeAttach();
    L5:
        this.mLazySizeAttach = r100;
        this.mSizeDeterminer.getSize(r100);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean r100) {
        this.mLegacyVisibilityHandlingEnabled = r100;
    }

    public void setSupportAsync(boolean r100) {
        this.mIsSupportAsync = r100;
    }

    public DraweeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mIsSupportAsync = false;
        init(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        AspectRatioMeasure.Spec r102 = this.mMeasureSpec;
        r102.width = r100;
        r102.height = r101;
        AspectRatioMeasure.updateMeasureSpec(r102, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        AspectRatioMeasure.Spec r103 = this.mMeasureSpec;
        super.onMeasure(r103.width, r103.height);
    }

    @Override // android.view.View
    public void onVisibilityChanged(final View r100, final int r101) {
        UiThreadImmediateExecutorService.getInstance().execute(new AnonymousClass1(this, r100, r101));
    }

    public DraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mIsSupportAsync = false;
        init(r100);
    }

    public static /* synthetic */ void access$001(DraweeView r100, View r101, int r102) {
        super.onVisibilityChanged(r101, r102);
    }

    public DraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mIsSupportAsync = false;
        init(r100);
    }
}
