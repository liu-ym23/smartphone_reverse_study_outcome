package com.facebook.drawee.controller;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash.BlurHashDecoder;
import com.facebook.imagepipeline.blurhash.BlurHashListener;
import com.facebook.imagepipeline.blurhash.BlurHashMapUtils;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener, BlurHashListener {
    private static final Class<?> TAG = null;
    private static ResetCallback mResetCallback;
    protected int encodedCacheHashcode;
    protected boolean isEnableAsyncAttach;
    protected boolean isEnableAsyncRequest;
    boolean isEnableHeaderBlurhash;
    protected boolean isReuseController;
    protected boolean isReuseLastBitmap;
    private Object mCallerContext;

    @Nullable
    private String mContentDescription;

    @Nullable
    private ControllerListener<INFO> mControllerListener;

    @Nullable
    private Drawable mControllerOverlay;

    @Nullable
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

    @Nullable
    private DataSource<T> mDataSource;
    private final DeferredReleaser mDeferredReleaser;

    @Nullable
    private Drawable mDrawable;
    private final DraweeEventTracker mEventTracker;

    @Nullable
    private T mFetchedImage;

    @Nullable
    private GestureDetector mGestureDetector;
    private boolean mHasFetchFailed;
    private String mId;
    private ImageRequest mImageRequest;
    protected boolean mIsAttached;
    protected boolean mIsRequestSubmitted;
    private boolean mIsVisibleInViewportHint;
    private boolean mJustConstructed;
    private boolean mRetainImageOnFailure;
    private boolean mRetainPreviousImageOnFailure;

    @Nullable
    private RetryManager mRetryManager;

    @Nullable
    private SettableDraweeHierarchy mSettableDraweeHierarchy;
    private SizeDeterminer mSizeDeterminer;
    private final Executor mUiThreadImmediateExecutor;

    public static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
        private InternalForwardingListener() {
        }

        public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> r100, ControllerListener<? super INFO> r101) {
            if (FrescoSystrace.isTracing() == false) goto L5;
            FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
        L5:
            InternalForwardingListener<INFO> r102 = new InternalForwardingListener();
            r102.addListener(r100);
            r102.addListener(r101);
            if (FrescoSystrace.isTracing() == false) goto L8;
            FrescoSystrace.endSection();
        L8:
            return r102;
        }
    }

    public interface ResetCallback {
        void flicker();

        void skipReset();
    }

    public abstract Drawable createDrawable(T r100);

    public T getCachedImage() {
        return null;
    }

    public abstract DataSource<T> getDataSource();

    @Nullable
    public abstract INFO getImageInfo(T r100);

    public boolean isLastImageInEncodedCached() {
        return false;
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.ClickListener
    public boolean onClick() {
        if (FLog.isLoggable(2) == false) goto L6;
        FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
    L6:
        if (shouldRetryOnTap() == false) goto L9;
        this.mRetryManager.notifyTapToRetry();
        this.mSettableDraweeHierarchy.reset();
        submitRequest();
        return true;
    L9:
        return false;
    }

    public void onImageLoadedFromCacheImmediately(String r100, T r101) {
    }

    public abstract void releaseDrawable(@Nullable Drawable r100);

    public abstract void releaseImage(@Nullable T r100);

    public void storeEncodedCacheHash() {
    }

    static {
        TAG = AbstractDraweeController.class;
    }

    private void releaseFetch() {
        boolean r100 = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        DataSource<T> r101 = this.mDataSource;
        if (r101 == null) goto L5;
        r101.close();
        this.mDataSource = null;
    L5:
        Drawable r102 = this.mDrawable;
        if (r102 == null) goto L9;
        releaseDrawable(r102);
    L9:
        if (this.mContentDescription == null) goto L11;
        this.mContentDescription = null;
    L11:
        this.mDrawable = null;
        T r103 = this.mFetchedImage;
        if (r103 != null) goto L14;
    L16:
        if (r100 == false) goto L22;
        ControllerListener<INFO> r104 = getControllerListener();
        if ((r104 instanceof BaseControllerListener) == false) goto L20;
        ((BaseControllerListener) r104).onRelease(this.mId, getImageRequest());
    L20:
        r104.onRelease(this.mId);
        return;
    L22:
        return;
    L14:
        if (this.mRetainPreviousImageOnFailure == true) goto L16;
        logMessageAndImage("release", r103);
        releaseImage(this.mFetchedImage);
        this.mFetchedImage = null;
        goto L16
    }

    private boolean shouldRetryOnTap() {
        if (this.mHasFetchFailed == false) goto L9;
        RetryManager r100 = this.mRetryManager;
        if (r100 == null) goto L9;
        if (r100.shouldRetryOnTap() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public void cancelDeferredRelease() {
        DeferredReleaser r100 = this.mDeferredReleaser;
        if (r100 == null) goto L6;
        r100.cancelDeferredRelease(this);
        return;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void clearHierarchy() {
        if (this.isReuseLastBitmap == false) goto L5;
        return;
    L5:
        setHierarchy(null);
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public Animatable getAnimatable() {
        Object r100 = this.mDrawable;
        if ((r100 instanceof Animatable) == true) goto L7;
        return null;
    L7:
        return (Animatable) r100;
    }

    public ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> r100 = this.mControllerListener;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return BaseControllerListener.getNoOpListener();
    }

    public RetryManager getRetryManager() {
        if (this.mRetryManager != null) goto L6;
        this.mRetryManager = new RetryManager();
    L6:
        return this.mRetryManager;
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        RetryManager r100 = this.mRetryManager;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        GestureDetector r101 = this.mGestureDetector;
        if (r101 == null) goto L8;
        r101.reset();
    L8:
        resetHierarchy(this.mSettableDraweeHierarchy);
        releaseFetch();
    }

    public void scheduleDeferredRelease() {
        this.mDeferredReleaser.scheduleDeferredRelease(this);
    }

    public void doAttach() {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
    L6:
        if (FLog.isLoggable(2) == false) goto L12;
        Class<?> r100 = TAG;
        Integer r101 = Integer.valueOf(System.identityHashCode(this));
        String r102 = this.mId;
        if (this.mIsRequestSubmitted == false) goto L10;
        String r103 = "request already submitted";
    L11:
        FLog.v(r100, "controller %x %s: onAttach: %s", r101, r102, r103);
        goto L12
    L10:
        r103 = "request needs submit";
    L12:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
        cancelDeferredRelease();
        this.mIsAttached = true;
        if (this.mIsRequestSubmitted == true) goto L16;
        submitRequest();
    L16:
        if (FrescoSystrace.isTracing() == false) goto L19;
        FrescoSystrace.endSection();
        return;
    }

    @Nullable
    public Uri getMainUri() {
        if (getImageRequest() != null) goto L7;
        return null;
    L7:
        return getImageRequest().getSourceUri();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onDetach() {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
    L6:
        if (FLog.isLoggable(2) == false) goto L8;
        FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
    L8:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        scheduleDeferredRelease();
        if (FrescoSystrace.isTracing() == false) goto L12;
        FrescoSystrace.endSection();
        return;
    }

    public boolean shouldHandleGesture() {
        return shouldRetryOnTap();
    }

    public void submitRequest() {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
    L5:
        T r100 = getCachedImage();
        boolean r101 = isThumbImageCache(r100);
        if (r100 == null) goto L19;
        if (r101 == true) goto L19;
        if (FrescoSystrace.isTracing() == false) goto L11;
        FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
    L11:
        this.mDataSource = null;
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
        getControllerListener().onSubmit(this.mId, this.mCallerContext);
        onImageLoadedFromCacheImmediately(this.mId, r100);
        onNewResultInternal(this.mId, this.mDataSource, r100, 1.0f, true, true, true);
        if (FrescoSystrace.isTracing() == false) goto L15;
        FrescoSystrace.endSection();
    L15:
        if (FrescoSystrace.isTracing() == false) goto L32;
        FrescoSystrace.endSection();
        return;
    L32:
        return;
    L19:
        if (mResetCallback != null) goto L21;
    L28:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        getControllerListener().onSubmit(this.mId, this.mCallerContext);
        setProgressInHierarchy(0.0f, true);
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        submitRequestInner();
        if (FrescoSystrace.isTracing() == false) goto L33;
        FrescoSystrace.endSection();
        return;
    L33:
        return;
    L21:
        if (this.isReuseController == false) goto L28;
        if (isLastImageInEncodedCached() == false) goto L28;
        if (this.isReuseLastBitmap == false) goto L27;
        mResetCallback.skipReset();
        goto L28
    L27:
        mResetCallback.flicker();
        goto L28
    }

    public void submitRequestInner() {
        DataSource<T> r100 = getDataSource();
        this.mDataSource = r100;
        if (FLog.isLoggable(2) == false) goto L5;
        FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(r100)));
    L5:
        DataSubscriber<T> r101 = createDataSubscriber(this.mId, r100.hasResult(), true);
        if (this.mImageRequest == null) goto L8;
    L17:
        r100.subscribe(r101, this.mUiThreadImmediateExecutor);
        if (BlurHashMapUtils.isEnableBlurHash() == true) goto L24;
        ImageRequest r102 = this.mImageRequest;
        if (r102 != null) goto L22;
        return;
    L22:
        if (r102.isUseSingleHeaderBlurhash() == true) goto L24;
        return;
    L24:
        if (getMainUri() == null) goto L29;
        BlurHashMapUtils.putListener(getMainUri(), new WeakReference(this));
        return;
    L29:
        return;
    L8:
        if ((r100 instanceof FirstAvailableDataSourceSupplier.FirstAvailableDataSource) == false) goto L17;
        Supplier<DataSource<T>> r103 = ((FirstAvailableDataSourceSupplier.FirstAvailableDataSource) r100).getCurrentSupplier();
        if ((r103 instanceof AbstractDraweeControllerBuilder.CustomSupplier) == false) goto L17;
        Object r104 = ((AbstractDraweeControllerBuilder.CustomSupplier) r103).getRequest();
        if (this.mIsRequestSubmitted == false) goto L17;
        if (this.mImageRequest != null) goto L17;
        if (r104 == null) goto L17;
        ImageRequest r105 = (ImageRequest) r104;
        this.mImageRequest = r105;
        r105.setSizeDeterminer(this.mSizeDeterminer);
        goto L17
    }

    public String toString() {
        return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public String getContentDescription() {
        return this.mContentDescription;
    }

    @Nullable
    public Drawable getControllerOverlay() {
        return this.mControllerOverlay;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Nullable
    public GestureDetector getGestureDetector() {
        return this.mGestureDetector;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public DraweeHierarchy getHierarchy() {
        return this.mSettableDraweeHierarchy;
    }

    public String getId() {
        return this.mId;
    }

    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public boolean isAttached() {
        return this.mIsAttached;
    }

    public boolean isEnableHeaderBlurhash() {
        return this.isEnableHeaderBlurhash;
    }

    public boolean isFetchFailed() {
        return this.mHasFetchFailed;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onAttach() {
        doAttach();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isThumbImageCache(T r100) {
        CloseableImage r101 = null;
        if ((r100 instanceof CloseableReference) == false) goto L5;
        CloseableReference r102 = (CloseableReference) r100;
    L6:
        if (r102 != null) goto L8;
    L10:
        if (r101 != null) goto L14;
        return false;
    L14:
        return r101.isThumbCache();
    L8:
        if ((r102.get() instanceof CloseableImage) == false) goto L10;
        r101 = (CloseableImage) r102.get();
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static void setResetCallback(ResetCallback r100) {
        mResetCallback = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(ControllerListener<? super INFO> r100) {
        Preconditions.checkNotNull(r100);
        ControllerListener<INFO> r101 = this.mControllerListener;
        if ((r101 instanceof InternalForwardingListener) == false) goto L6;
        ((InternalForwardingListener) r101).addListener(r100);
        return;
    L6:
        if (r101 == null) goto L9;
        this.mControllerListener = InternalForwardingListener.createInternal(r101, r100);
        return;
    L9:
        this.mControllerListener = r100;
    }

    public void clearControllerOverlayInHierarchy(@Nullable SettableDraweeHierarchy r100) {
        if (r100 == null) goto L5;
        r100.setControllerOverlay(null);
        return;
    }

    public String getImageClass(@Nullable T r100) {
        if (r100 != null) goto L6;
        return "<null>";
    L6:
        return r100.getClass().getSimpleName();
    }

    public int getImageHash(@Nullable T r100) {
        return System.identityHashCode(r100);
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent r100) {
        if (FLog.isLoggable(2) == false) goto L5;
        FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, r100);
    L5:
        GestureDetector r101 = this.mGestureDetector;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.isCapturingGesture() == false) goto L11;
    L14:
        this.mGestureDetector.onTouchEvent(r100);
        return true;
    L11:
        if (shouldHandleGesture() == true) goto L14;
        return false;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onViewportVisibilityHint(boolean r100) {
        ControllerViewportVisibilityListener r101 = this.mControllerViewportVisibilityListener;
        if (r101 == null) goto L12;
        if (r100 == true) goto L6;
    L8:
        if (r100 == true) goto L12;
        if (this.mIsVisibleInViewportHint == false) goto L12;
        r101.onDraweeViewportExit(this.mId);
        goto L12
    L6:
        if (this.mIsVisibleInViewportHint == true) goto L8;
        r101.onDraweeViewportEntry(this.mId);
    L12:
        this.mIsVisibleInViewportHint = r100;
    }

    public void refineImageInPlace(@Nullable DataSource<T> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsAttached == true) goto L8;
        r100.close();
        return;
    L8:
        DataSource<T> r101 = this.mDataSource;
        if (r101 == null) goto L12;
        if (r101 == r100) goto L12;
        r101.close();
    L12:
        this.mDataSource = r100;
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        boolean r102 = r100.hasResult();
        r100.subscribe(createDataSubscriber(this.mId, r102, false), this.mUiThreadImmediateExecutor);
    }

    public void removeControllerListener(ControllerListener<? super INFO> r100) {
        Preconditions.checkNotNull(r100);
        ControllerListener<INFO> r101 = this.mControllerListener;
        if ((r101 instanceof InternalForwardingListener) == false) goto L6;
        ((InternalForwardingListener) r101).removeListener(r100);
        return;
    L6:
        if (r101 != r100) goto L9;
        this.mControllerListener = null;
        return;
    }

    public void resetHierarchy(@Nullable SettableDraweeHierarchy r100) {
        if (r100 == null) goto L5;
        r100.reset();
        return;
    }

    public void resetHierarchyAndClearOverlay(@Nullable SettableDraweeHierarchy r100) {
        if (r100 == null) goto L5;
        r100.reset();
        r100.setControllerOverlay(null);
        return;
    }

    public void runInMain(Runnable r100) {
        r100.run();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setContentDescription(@Nullable String r100) {
        this.mContentDescription = r100;
    }

    public void setControllerOverlay(@Nullable Drawable r100) {
        this.mControllerOverlay = r100;
        SettableDraweeHierarchy r101 = this.mSettableDraweeHierarchy;
        if (r101 == null) goto L6;
        setControllerOverlayInHierarchy(r101, r100);
        return;
    }

    public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener r100) {
        this.mControllerViewportVisibilityListener = r100;
    }

    public void setEnableAsyncAttach(boolean r100) {
        this.isEnableAsyncAttach = r100;
    }

    public void setEnableAsyncRequest(boolean r100) {
        this.isEnableAsyncRequest = r100;
    }

    public void setEnableHeaderBlurhash(boolean r100) {
        this.isEnableHeaderBlurhash = r100;
    }

    public void setFailureInHierarchy(Throwable r100) {
        SettableDraweeHierarchy r101 = this.mSettableDraweeHierarchy;
        if (r101 == null) goto L6;
        r101.setFailure(r100);
        return;
    }

    public void setGestureDetector(@Nullable GestureDetector r100) {
        this.mGestureDetector = r100;
        if (r100 == null) goto L6;
        r100.setClickListener(this);
        return;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy r100) {
        if (FLog.isLoggable(2) == false) goto L5;
        FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, r100);
    L5:
        DraweeEventTracker r101 = this.mEventTracker;
        if (r100 == null) goto L8;
        DraweeEventTracker.Event r102 = DraweeEventTracker.Event.ON_SET_HIERARCHY;
    L9:
        r101.recordEvent(r102);
        if (this.mIsRequestSubmitted == false) goto L13;
        cancelDeferredRelease();
        release();
    L13:
        if (this.isReuseLastBitmap == false) goto L23;
        if (r100 == null) goto L20;
        SettableDraweeHierarchy r103 = this.mSettableDraweeHierarchy;
        if (r103 != r100) goto L20;
        if (r103.getControllerOverlay() != this.mControllerOverlay) goto L20;
        return;
    L20:
        SettableDraweeHierarchy r104 = this.mSettableDraweeHierarchy;
        if (r104 == null) goto L23;
        resetHierarchyAndClearOverlay(r104);
        this.mSettableDraweeHierarchy = null;
    L23:
        SettableDraweeHierarchy r105 = this.mSettableDraweeHierarchy;
        if (r105 == null) goto L26;
        clearControllerOverlayInHierarchy(r105);
        this.mSettableDraweeHierarchy = null;
    L26:
        if (r100 == null) goto L29;
        Preconditions.checkArgument(r100 instanceof SettableDraweeHierarchy);
        SettableDraweeHierarchy r106 = (SettableDraweeHierarchy) r100;
        this.mSettableDraweeHierarchy = r106;
        setControllerOverlayInHierarchy(r106, this.mControllerOverlay);
        return;
    L29:
        return;
    L8:
        r102 = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY;
        goto L9
    }

    public void setImageRequest(ImageRequest r100) {
        this.mImageRequest = r100;
        if (r100.isAsyncAttach() == true) goto L6;
        this.isEnableAsyncAttach = false;
    L6:
        if (r100.isAsyncRequest() == true) goto L9;
        this.isEnableAsyncRequest = false;
        return;
    }

    public void setRetainImageOnFailure(boolean r100) {
        this.mRetainImageOnFailure = r100;
    }

    public void setRetainPreviousImageOnFailure(boolean r100) {
        this.mRetainPreviousImageOnFailure = r100;
    }

    public void setRetryInHierarchy(Throwable r100) {
        SettableDraweeHierarchy r101 = this.mSettableDraweeHierarchy;
        if (r101 == null) goto L6;
        r101.setRetry(r100);
        return;
    }

    public void setReuseController(boolean r100) {
        this.isReuseController = r100;
        this.isReuseLastBitmap = false;
    }

    public void setSizeDeterminer(SizeDeterminer r100) {
        this.mSizeDeterminer = r100;
    }

    private synchronized void init(String r100, Object r101) {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("AbstractDraweeController#init");     // Catch: Throwable -> L40
    L6:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);     // Catch: Throwable -> L40
        if (this.mJustConstructed == true) goto L9;
        cancelDeferredRelease();     // Catch: Throwable -> L40
    L9:
        this.mIsAttached = false;     // Catch: Throwable -> L40
        this.mIsVisibleInViewportHint = false;     // Catch: Throwable -> L40
        releaseFetch();     // Catch: Throwable -> L40
        this.mRetainImageOnFailure = false;     // Catch: Throwable -> L40
        RetryManager r102 = this.mRetryManager;     // Catch: Throwable -> L40
        if (r102 == null) goto L12;
        r102.init();     // Catch: Throwable -> L40
    L12:
        GestureDetector r103 = this.mGestureDetector;     // Catch: Throwable -> L40
        if (r103 == null) goto L15;
        r103.init();     // Catch: Throwable -> L40
        this.mGestureDetector.setClickListener(this);     // Catch: Throwable -> L40
    L15:
        ControllerListener<INFO> r104 = this.mControllerListener;     // Catch: Throwable -> L40
        if ((r104 instanceof InternalForwardingListener) == false) goto L18;
        ((InternalForwardingListener) r104).clearListeners();     // Catch: Throwable -> L40
    L19:
        this.mControllerViewportVisibilityListener = null;     // Catch: Throwable -> L40
        SettableDraweeHierarchy r105 = this.mSettableDraweeHierarchy;     // Catch: Throwable -> L40
        if (r105 != null) goto L22;
    L32:
        this.mControllerOverlay = null;     // Catch: Throwable -> L40
        if (FLog.isLoggable(2) == false) goto L35;
        FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, r100);     // Catch: Throwable -> L40
    L35:
        this.mId = r100;     // Catch: Throwable -> L40
        this.mCallerContext = r101;     // Catch: Throwable -> L40
        if (FrescoSystrace.isTracing() == false) goto L38;
        FrescoSystrace.endSection();     // Catch: Throwable -> L40
    L38:
        monitor-exit(this);
        return;
    L22:
        if (this.mRetainPreviousImageOnFailure == false) goto L24;
        clearControllerOverlayInHierarchy(r105);     // Catch: Throwable -> L40
        this.mSettableDraweeHierarchy = null;     // Catch: Throwable -> L40
        goto L32
    L24:
        if (FrescoCacheMonitorUtil.isOptRest() == true) goto L26;
    L30:
        resetHierarchyAndClearOverlay(this.mSettableDraweeHierarchy);     // Catch: Throwable -> L40
        this.mSettableDraweeHierarchy = null;     // Catch: Throwable -> L40
        goto L32
    L26:
        if (this.isReuseController == false) goto L30;
        if (isLastImageInEncodedCached() == false) goto L30;
        this.isReuseLastBitmap = true;     // Catch: Throwable -> L40
        this.mSettableDraweeHierarchy.stopDrawUntilSetImage();     // Catch: Throwable -> L40
        goto L32
    L18:
        this.mControllerListener = null;     // Catch: Throwable -> L40
        goto L19
    }

    private boolean isExpectedDataSource(String r100, DataSource<T> r101) {
        if (r101 != null) goto L8;
        if (this.mDataSource != null) goto L8;
        return true;
    L8:
        if (r100.equals(this.mId) == true) goto L10;
    L14:
        return false;
    L10:
        if (r101 != this.mDataSource) goto L14;
        if (this.mIsRequestSubmitted == false) goto L14;
        return true;
    }

    private void logMessageAndFailure(String r100, Throwable r101) {
        if (FrescoCacheMonitorUtil.isEnableAddLogUriInfo() == false) goto L8;
        if (FLog.isLoggable(5) == false) goto L11;
        FLog.w(TAG, "controller %x %s: %s %s: failure: %s", new Object[]{Integer.valueOf(System.identityHashCode(this)), this.mId, r100, "imageUri: " + getMainUri(), r101});
        return;
    L11:
        return;
    L8:
        if (FLog.isLoggable(2) == false) goto L13;
        FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, r100, r101);
        return;
    }

    private void logMessageAndImage(String r110, T r111) {
        if (FrescoCacheMonitorUtil.isEnableAddLogUriInfo() == false) goto L8;
        if (FLog.isLoggable(2) == false) goto L11;
        FLog.v(TAG, "controller %x %s: %s %s: image: %s %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), this.mId, r110, "imageUri: " + getMainUri(), getImageClass(r111), Integer.valueOf(getImageHash(r111))});
        return;
    L11:
        return;
    L8:
        if (FLog.isLoggable(2) == false) goto L13;
        FLog.v(TAG, "controller %x %s: %s: image: %s %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), this.mId, r110, getImageClass(r111), Integer.valueOf(getImageHash(r111))});
        return;
    }

    private void onRefineFailed(String r100, DataSource<T> r101) {
        if (isExpectedDataSource(r100, r101) == true) goto L6;
        r101.close();
        return;
    L6:
        this.mDataSource = null;
    }

    public void initialize(String r100, Object r101) {
        init(r100, r101);
        this.mJustConstructed = false;
    }

    @Override // com.facebook.imagepipeline.blurhash.BlurHashListener
    public long onBlurHashReady(String r100, BlurHashConfig r110) {
        if (this.isEnableHeaderBlurhash == true) goto L6;
        return 0;
    L6:
        long r101 = SystemClock.uptimeMillis();
        BlurHashDecoder r102 = new BlurHashDecoder();
        if (r110 != null) goto L9;
        int r103 = 50;
    L10:
        if (r110 != null) goto L12;
        int r104 = 50;
    L13:
        if (r110 != null) goto L15;
        float r105 = 1.0f;
    L16:
        if (r110 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        Bitmap r107 = r102.decode(r100, r103, r104, r105, r106);
        FLog.d("blurhash", "AbstractDraweeController, onBlurHashReady2: currentThread is = " + ThreadMethodProxy.currentThread() + ", decode blurhash cost time is " + (SystemClock.uptimeMillis() - r101));
        if (r107 == null) goto L28;
        BitmapDrawable r111 = new BitmapDrawable(r107);
        if ((getHierarchy() instanceof GenericDraweeHierarchy) == false) goto L28;
        ((GenericDraweeHierarchy) getHierarchy()).setPlaceholderImage(r111, ScalingUtils.ScaleType.FIT_XY);
    L28:
        return SystemClock.uptimeMillis() - r101;
    L18:
        if (r110.isUseCache() == true) goto L21;
        r106 = false;
        goto L22
    L15:
        r105 = r110.getPunch();
        goto L16
    L12:
        r104 = r110.getHeight();
        goto L13
    L9:
        r103 = r110.getWidth();
        goto L10
    }

    public void setControllerOverlayInHierarchy(@Nullable SettableDraweeHierarchy r100, @Nullable Drawable r101) {
        if (r100 == null) goto L5;
        r100.setControllerOverlay(r101);
        return;
    }

    public void setProgressInHierarchy(float r100, boolean r101) {
        SettableDraweeHierarchy r102 = this.mSettableDraweeHierarchy;
        if (r102 == null) goto L6;
        r102.setProgress(r100, r101);
        return;
    }

    public static /* synthetic */ void access$200(AbstractDraweeController r100, String r101, DataSource r102) {
        r100.onRefineFailed(r101, r102);
    }

    private DataSubscriber<T> createDataSubscriber(final String r100, final boolean r101, final boolean r102) {
        return new AnonymousClass1(this, r100, r101, r102);
    }

    public void initialize(String r100, Object r101, ImageRequest r102) {
        this.mImageRequest = r102;
        init(r100, r101);
        this.mJustConstructed = false;
    }

    public void setImageInHierarchy(Drawable r100, float r101, boolean r102) {
        SettableDraweeHierarchy r103 = this.mSettableDraweeHierarchy;
        if (r103 == null) goto L6;
        r103.setImage(r100, r101, r102);
        return;
    }

    public AbstractDraweeController(DeferredReleaser r100, Executor r101, String r102, Object r103) {
        this.isEnableHeaderBlurhash = true;
        this.isEnableAsyncRequest = false;
        this.isEnableAsyncAttach = false;
        this.mEventTracker = DraweeEventTracker.newInstance();
        this.mJustConstructed = true;
        this.isReuseController = false;
        this.isReuseLastBitmap = false;
        this.encodedCacheHashcode = 0;
        this.mDeferredReleaser = r100;
        this.mUiThreadImmediateExecutor = r101;
        init(r102, r103);
    }

    private void onFailureInternal(String r100, DataSource<T> r101, Throwable r102, boolean r103) {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
    L6:
        if (isExpectedDataSource(r100, r101) == true) goto L11;
        logMessageAndFailure("ignore_old_datasource @ onFailure", r102);
        r101.close();
        if (FrescoSystrace.isTracing() == false) goto L35;
        FrescoSystrace.endSection();
        return;
    L35:
        return;
    L11:
        DraweeEventTracker r104 = this.mEventTracker;
        if (r103 == false) goto L14;
        DraweeEventTracker.Event r105 = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
    L15:
        r104.recordEvent(r105);
        if (r103 == false) goto L30;
        logMessageAndFailure("final_failed @ onFailure", r102);
        this.mDataSource = null;
        this.mHasFetchFailed = true;
        if (this.mRetainImageOnFailure == false) goto L23;
        Drawable r106 = this.mDrawable;
        if (r106 == null) goto L23;
        setImageInHierarchy(r106, 1.0f, true);
    L26:
        ControllerListener<INFO> r107 = getControllerListener();
        if ((r107 instanceof BaseControllerListener) == false) goto L29;
        ((BaseControllerListener) r107).onFailure(this.mId, getImageRequest(), r102);
    L29:
        r107.onFailure(this.mId, r102);
    L32:
        if (FrescoSystrace.isTracing() == false) goto L36;
        FrescoSystrace.endSection();
        return;
    L36:
        return;
    L23:
        if (shouldRetryOnTap() == false) goto L25;
        setRetryInHierarchy(r102);
        goto L26
    L25:
        setFailureInHierarchy(r102);
        goto L26
    L30:
        logMessageAndFailure("intermediate_failed @ onFailure", r102);
        getControllerListener().onIntermediateImageFailed(this.mId, r102);
        goto L32
    L14:
        r105 = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
        goto L15
    }

    private void onProgressUpdateInternal(String r100, DataSource<T> r101, float r102, boolean r103) {
        if (isExpectedDataSource(r100, r101) == true) goto L6;
        logMessageAndFailure("ignore_old_datasource @ onProgress", null);
        r101.close();
        return;
    L6:
        if (r103 == true) goto L9;
        setProgressInHierarchy(r102, false);
        return;
    }

    public static /* synthetic */ void access$100(AbstractDraweeController r100, String r101, DataSource r102, Throwable r103, boolean r104) {
        r100.onFailureInternal(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$300(AbstractDraweeController r100, String r101, DataSource r102, float r103, boolean r104) {
        r100.onProgressUpdateInternal(r101, r102, r103, r104);
    }

    private void onNewResultInternal(String r110, DataSource<T> r111, @Nullable T r112, float r113, boolean r114, boolean r210, boolean r211) {
    L76:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L80;
        FrescoSystrace.endSection();
    L80:
        throw th;
    L4:
        if (FrescoSystrace.isTracing() == false) goto L7;
        FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");     // Catch: Throwable -> L76
    L7:
        if (isExpectedDataSource(r110, r111) == true) goto L15;
        logMessageAndFailure("ignore_old_datasource @ onNewResult", null);     // Catch: Throwable -> L76
        releaseImage(r112);     // Catch: Throwable -> L76
        if (r111 == null) goto L12;
        r111.close();     // Catch: Throwable -> L76
    L12:
        if (FrescoSystrace.isTracing() == false) goto L85;
        FrescoSystrace.endSection();
        return;
    L85:
        return;
    L15:
        DraweeEventTracker r100 = this.mEventTracker;     // Catch: Throwable -> L76
        if (r114 == false) goto L18;
        DraweeEventTracker.Event r101 = DraweeEventTracker.Event.ON_DATASOURCE_RESULT;     // Catch: Throwable -> L76
    L19:
        r100.recordEvent(r101);     // Catch: Throwable -> L76
        Drawable r115 = createDrawable(r112);     // Catch: Exception -> L70 Throwable -> L76
        T r116 = this.mFetchedImage;     // Catch: Throwable -> L76
        Drawable r117 = this.mDrawable;     // Catch: Throwable -> L76
        this.mFetchedImage = r112;     // Catch: Throwable -> L76
        this.mDrawable = r115;     // Catch: Throwable -> L76
        HashMap r102 = new HashMap();     // Catch: Throwable -> L76
        r102.put("drawableWidth", Integer.valueOf(r115.getIntrinsicWidth()));     // Catch: Throwable -> L76
        r102.put("drawableHeight", Integer.valueOf(r115.getIntrinsicHeight()));     // Catch: Throwable -> L76
        r102.put(FrescoMonitorConst.SCENE_TAG, this.mCallerContext);     // Catch: Throwable -> L76
        if (r114 == false) goto L48;
        logMessageAndImage("set_final_result @ onNewResult", r112);     // Catch: Throwable -> L46
        this.mDataSource = null;     // Catch: Throwable -> L46
        setImageInHierarchy(r115, 1.0f, r210);     // Catch: Throwable -> L46
        storeEncodedCacheHash();     // Catch: Throwable -> L46
        ControllerListener<INFO> r103 = getControllerListener();     // Catch: Throwable -> L46
        if ((r103 instanceof BaseControllerListener) == false) goto L45;
        ImageRequest r104 = getImageRequest();     // Catch: Throwable -> L46
        if (FrescoCacheMonitorUtil.isOptMultiRequestSensible() == false) goto L43;
        if (r104 != null) goto L43;
        if (r111 == null) goto L43;
        if ((r111 instanceof IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource) == false) goto L43;
        ArrayList<DataSource<T>> r105 = ((IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource) r111).getDataSources();     // Catch: Throwable -> L46
        if (r105 == null) goto L43;
        if (r105.size() <= 0) goto L43;
        DataSource<T> r106 = r105.get(0);     // Catch: Throwable -> L46
        if ((r106 instanceof FirstAvailableDataSourceSupplier.FirstAvailableDataSource) == false) goto L43;
        Supplier<DataSource<T>> r107 = ((FirstAvailableDataSourceSupplier.FirstAvailableDataSource) r106).getCurrentSupplier();     // Catch: Throwable -> L46
        if (r107 == null) goto L43;
        Object r108 = ((AbstractDraweeControllerBuilder.CustomSupplier) r107).getRequest();     // Catch: Throwable -> L46
        if ((r108 instanceof ImageRequest) == false) goto L43;
        ImageRequest r109 = (ImageRequest) r108;     // Catch: Throwable -> L46
    L44:
        ((BaseControllerListener) r103).onFinalImageSet(r110, getImageInfo(r112), getAnimatable(), r109, r102);     // Catch: Throwable -> L46
    L43:
        r109 = r104;
    L45:
        r103.onFinalImageSet(r110, getImageInfo(r112), getAnimatable());     // Catch: Throwable -> L46
    L53:
        if (r117 == null) goto L56;
        if (r117 == r115) goto L56;
        releaseDrawable(r117);     // Catch: Throwable -> L76
    L56:
        if (r116 == null) goto L60;
        if (r116 == r112) goto L60;
        logMessageAndImage("release_previous_result @ onNewResult", r116);     // Catch: Throwable -> L76
        releaseImage(r116);     // Catch: Throwable -> L76
    L60:
        if (FrescoSystrace.isTracing() == false) goto L86;
        FrescoSystrace.endSection();
        return;
    L86:
        return;
    L48:
        if (r211 == false) goto L50;
        logMessageAndImage("set_temporary_result @ onNewResult", r112);     // Catch: Throwable -> L46
        setImageInHierarchy(r115, 1.0f, r210);     // Catch: Throwable -> L46
        getControllerListener().onFinalImageSet(r110, getImageInfo(r112), getAnimatable());     // Catch: Throwable -> L46
        goto L53
    L50:
        logMessageAndImage("set_intermediate_result @ onNewResult", r112);     // Catch: Throwable -> L46
        setImageInHierarchy(r115, r113, r210);     // Catch: Throwable -> L46
        getControllerListener().onIntermediateImageSet(r110, getImageInfo(r112));     // Catch: Throwable -> L46
        if ((getControllerListener() instanceof BaseControllerListener) == false) goto L53;
        ((BaseControllerListener) getControllerListener()).onIntermediateImageSet(r110, getImageInfo(r112), getAnimatable());     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        if (r117 == null) goto L66;
        if (r117 == r115) goto L66;
        releaseDrawable(r117);     // Catch: Throwable -> L76
    L66:
        if (r116 == null) goto L69;
        if (r116 == r112) goto L69;
        logMessageAndImage("release_previous_result @ onNewResult", r116);     // Catch: Throwable -> L76
        releaseImage(r116);     // Catch: Throwable -> L76
    L69:
        throw th;     // Catch: Throwable -> L76
    L70:
        e = move-exception;
        logMessageAndFailure("drawable_failed @ onNewResult", e);     // Catch: Throwable -> L76
        releaseImage(r112);     // Catch: Throwable -> L76
        onFailureInternal(r110, r111, e, r114);     // Catch: Throwable -> L76
        if (FrescoSystrace.isTracing() == false) goto L87;
        FrescoSystrace.endSection();
        return;
    L87:
        return;
    L18:
        r101 = DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT;     // Catch: Throwable -> L76
        goto L19
    }

    public static /* synthetic */ void access$000(AbstractDraweeController r100, String r101, DataSource r102, Object r103, float r104, boolean r105, boolean r106, boolean r107) {
        r100.onNewResultInternal(r101, r102, r103, r104, r105, r106, r107);
    }
}
