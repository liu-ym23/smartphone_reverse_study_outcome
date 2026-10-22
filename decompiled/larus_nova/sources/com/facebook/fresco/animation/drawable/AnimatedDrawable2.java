package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.frame.FixedSlidingHeifFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.fresco.animation.frame.SmoothSlidingFrameScheduler;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    private static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    private static final AnimationListener NO_OP_LISTENER = null;
    private static final Class<?> TAG = null;
    private static FrameSchedulerFactory sFrameSchedulerFactory;

    @Nullable
    private AnimationBackend mAnimationBackend;
    private volatile AnimationListener mAnimationListener;

    @Nullable
    private Object mDecodeContext;
    private int mDecodeStatus;

    @Nullable
    private volatile DrawListener mDrawListener;

    @Nullable
    private DrawableProperties mDrawableProperties;
    private int mDroppedFrames;
    private long mExpectedRenderTimeMs;

    @Nullable
    private BitmapFrameCache mFrameCache;

    @Nullable
    private FrameScheduler mFrameScheduler;
    private long mFrameSchedulingDelayMs;
    private long mFrameSchedulingOffsetMs;
    private boolean mHasChangeLoopCount;
    private ImageFormat mImageFormat;
    private final Runnable mInvalidateRunnable;
    private volatile boolean mIsRunning;
    private int mLastDrawnFrameNumber;
    private long mLastFrameAnimationTimeMs;
    private int mLoopCount;
    private volatile boolean mPaused;
    private int mPausedLastDrawnFrameNumber;
    private long mPausedLastFrameAnimationTimeMsDifference;
    private long mPausedStartTimeMsDifference;
    private long mStartTimeMs;

    public interface DrawListener {
        void onDraw(AnimatedDrawable2 r100, FrameScheduler r101, int r102, boolean r103, boolean r104, long r105, long r106, long r110, long r111, long r112, long r113, long r114);
    }

    public AnimatedDrawable2() {
        this(null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        TAG = AnimatedDrawable2.class;
        NO_OP_LISTENER = new BaseAnimationListener();
    }

    private void onFrameDropped() {
        this.mDroppedFrames++;
        if (FLog.isLoggable(2) == false) goto L6;
        FLog.v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this.mDroppedFrames));
        return;
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        AnimationBackend r100 = this.mAnimationBackend;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public long getDroppedFrames() {
        return this.mDroppedFrames;
    }

    public int getFrameCount() {
        AnimationBackend r100 = this.mAnimationBackend;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getFrameCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend r100 = this.mAnimationBackend;
        if (r100 != null) goto L7;
        return super.getIntrinsicHeight();
    L7:
        return r100.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend r100 = this.mAnimationBackend;
        if (r100 != null) goto L7;
        return super.getIntrinsicWidth();
    L7:
        return r100.getIntrinsicWidth();
    }

    public int getLoopCount() {
        if (this.mHasChangeLoopCount == true) goto L5;
        AnimationBackend r100 = this.mAnimationBackend;
        if (r100 != null) goto L10;
        return 0;
    L10:
        return r100.getLoopCount();
    L5:
        return this.mLoopCount;
    }

    public long getLoopDurationMs() {
        if (this.mAnimationBackend != null) goto L6;
        return 0;
    L6:
        FrameScheduler r100 = this.mFrameScheduler;
        if (r100 != null) goto L9;
        int r101 = 0;
        int r102 = 0;
    L12:
        if (r101 >= this.mAnimationBackend.getFrameCount()) goto L15;
        r102 = r102 + this.mAnimationBackend.getFrameDurationMs(r101);
        r101 = r101 + 1;
        goto L12
    L15:
        return r102;
    L9:
        return r100.getLoopDurationMs();
    }

    public boolean isInfiniteAnimation() {
        FrameScheduler r100 = this.mFrameScheduler;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInfiniteAnimation() == false) goto L7;
        return true;
    }

    public void pause() {
        if (this.mPaused == false) goto L5;
        return;
    L5:
        if (this.mIsRunning == false) goto L10;
        this.mIsRunning = false;
        long r100 = now();
        this.mPausedStartTimeMsDifference = r100 - this.mStartTimeMs;
        this.mPausedLastFrameAnimationTimeMsDifference = r100 - this.mLastFrameAnimationTimeMs;
        this.mPausedLastDrawnFrameNumber = this.mLastDrawnFrameNumber;
        this.mPaused = true;
        unscheduleSelf(this.mInvalidateRunnable);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mIsRunning == true) goto L5;
    L6:
        AnimationBackend r100 = this.mAnimationBackend;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.getFrameCount() <= 1) goto L18;
        this.mIsRunning = true;
        long r101 = now();
        this.mStartTimeMs = r101;
        this.mExpectedRenderTimeMs = r101;
        this.mLastFrameAnimationTimeMs = -1;
        this.mLastDrawnFrameNumber = -1;
        if (this.mPaused == false) goto L14;
        long r102 = now();
        long r103 = r102 - this.mPausedStartTimeMsDifference;
        this.mStartTimeMs = r103;
        this.mExpectedRenderTimeMs = r103;
        this.mLastFrameAnimationTimeMs = r102 - this.mPausedLastFrameAnimationTimeMsDifference;
        this.mLastDrawnFrameNumber = this.mPausedLastDrawnFrameNumber;
        this.mPaused = false;
    L14:
        invalidateSelf();
        this.mAnimationListener.onAnimationStart(this);
        return;
    L18:
        return;
    L5:
        if (this.mPaused == true) goto L6;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        this.mStartTimeMs = 0;
        this.mExpectedRenderTimeMs = 0;
        this.mLastFrameAnimationTimeMs = -1;
        this.mLastDrawnFrameNumber = -1;
        this.mPaused = false;
        FrameScheduler r100 = this.mFrameScheduler;
        if ((r100 instanceof FixedSlidingHeifFrameScheduler) == false) goto L8;
        ((FixedSlidingHeifFrameScheduler) r100).setAnimatedStop(true);
    L8:
        unscheduleSelf(this.mInvalidateRunnable);
        this.mAnimationListener.onAnimationStop(this);
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    @Nullable
    public AnimationBackend getAnimationBackend() {
        return this.mAnimationBackend;
    }

    @Nullable
    public BitmapFrameCache getBitmapFrameCache() {
        return this.mFrameCache;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    public static /* synthetic */ Runnable access$000(AnimatedDrawable2 r100) {
        return r100.mInvalidateRunnable;
    }

    private void scheduleNextFrame(long r100) {
        long r101 = this.mStartTimeMs + r100;
        this.mExpectedRenderTimeMs = r101;
        scheduleSelf(this.mInvalidateRunnable, r101);
    }

    public static void setFrameSchedulerFactory(FrameSchedulerFactory r100) {
        sFrameSchedulerFactory = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r210) {
        if (this.mAnimationBackend == null) goto L40;
        if (this.mFrameScheduler == null) goto L40;
        long r110 = now();
        if (this.mIsRunning == false) goto L10;
        long r100 = (r110 - this.mStartTimeMs) + this.mFrameSchedulingOffsetMs;
    L11:
        long r101 = r100;
        int r102 = this.mFrameScheduler.getFrameNumberToRender(r101, this.mLastFrameAnimationTimeMs);
        if (r102 != (-1)) goto L14;
        r102 = this.mAnimationBackend.getFrameCount() - 1;
        this.mAnimationListener.onAnimationStop(this);
        this.mIsRunning = false;
    L20:
        int r103 = r102;
        boolean r104 = this.mAnimationBackend.drawFrame(this, r210, r103);
        if (r104 == false) goto L23;
        this.mAnimationListener.onAnimationFrame(this, r103);
        this.mLastDrawnFrameNumber = r103;
    L23:
        if (r104 == true) goto L25;
        onFrameDropped();
    L25:
        long r111 = now();
        if (this.mIsRunning == false) goto L32;
        this.mFrameScheduler.setStartTime(this.mStartTimeMs);
        long r112 = this.mFrameScheduler.getTargetRenderTimeForNextFrameMs(r111 - this.mStartTimeMs);
        if (r112 == (-1)) goto L30;
        long r105 = this.mFrameSchedulingDelayMs + r112;
        scheduleNextFrame(r105);
        long r113 = r105;
    L31:
        long r114 = r112;
    L33:
        DrawListener r106 = this.mDrawListener;
        if (r106 == null) goto L36;
        r106.onDraw(this, this.mFrameScheduler, r103, r104, this.mIsRunning, this.mStartTimeMs, r101, this.mLastFrameAnimationTimeMs, r110, r111, r114, r113);
        long r107 = r101;
    L37:
        this.mLastFrameAnimationTimeMs = r107;
        return;
    L36:
        r107 = r101;
        goto L37
    L30:
        this.mAnimationListener.onAnimationStop(this);
        this.mIsRunning = false;
        r113 = -1;
        goto L31
    L32:
        r114 = -1;
        r113 = -1;
        goto L33
    L14:
        if (r102 != 0) goto L20;
        if (this.mLastDrawnFrameNumber == (-1)) goto L20;
        if (r110 < this.mExpectedRenderTimeMs) goto L20;
        this.mAnimationListener.onAnimationRepeat(this);
        goto L20
    L10:
        r100 = Math.max(this.mLastFrameAnimationTimeMs, 0);
    }

    public void jumpToFrame(int r100) {
        if (this.mAnimationBackend == null) goto L9;
        FrameScheduler r101 = this.mFrameScheduler;
        if (r101 == null) goto L10;
        this.mLastFrameAnimationTimeMs = r101.getTargetRenderTimeMs(r100);
        long r102 = now() - this.mLastFrameAnimationTimeMs;
        this.mStartTimeMs = r102;
        this.mExpectedRenderTimeMs = r102;
        invalidateSelf();
        return;
    L10:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        AnimationBackend r101 = this.mAnimationBackend;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        if (this.mIsRunning == false) goto L5;
        return false;
    L5:
        long r101 = r100;
        if (this.mLastFrameAnimationTimeMs == r101) goto L9;
        this.mLastFrameAnimationTimeMs = r101;
        invalidateSelf();
        return true;
    L9:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (this.mDrawableProperties != null) goto L5;
        this.mDrawableProperties = new DrawableProperties();
    L5:
        this.mDrawableProperties.setAlpha(r100);
        AnimationBackend r101 = this.mAnimationBackend;
        if (r101 == null) goto L9;
        r101.setAlpha(r100);
        return;
    }

    public void setAnimationBackend(@Nullable AnimationBackend r100) {
        this.mAnimationBackend = r100;
        if (r100 == null) goto L7;
        this.mFrameScheduler = new SmoothSlidingFrameScheduler(r100);
        this.mAnimationBackend.setBounds(getBounds());
        DrawableProperties r101 = this.mDrawableProperties;
        if (r101 == null) goto L7;
        r101.applyTo(this);
    L7:
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend, null, 0, this.mImageFormat);
        stop();
    }

    public void setAnimationListener(@Nullable AnimationListener r100) {
        if (r100 != null) goto L5;
        r100 = NO_OP_LISTENER;
    L5:
        this.mAnimationListener = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        if (this.mDrawableProperties != null) goto L5;
        this.mDrawableProperties = new DrawableProperties();
    L5:
        this.mDrawableProperties.setColorFilter(r100);
        AnimationBackend r101 = this.mAnimationBackend;
        if (r101 == null) goto L9;
        r101.setColorFilter(r100);
        return;
    }

    public void setDrawListener(@Nullable DrawListener r100) {
        this.mDrawListener = r100;
    }

    public void setFrameSchedulingDelayMs(long r100) {
        this.mFrameSchedulingDelayMs = r100;
    }

    public void setFrameSchedulingOffsetMs(long r100) {
        this.mFrameSchedulingOffsetMs = r100;
    }

    public void setLoopCount(int r100) {
        this.mLoopCount = r100;
        this.mHasChangeLoopCount = true;
    }

    public void setPrivateFrameScheduler(FrameScheduler r100) {
        if (DefaultImageFormats.isHeifFormatAnimated(this.mImageFormat) == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        this.mFrameScheduler = r100;
        return;
    }

    public void setPrivateFrameSchedulerFactory(FrameSchedulerFactory r100) {
        if (DefaultImageFormats.isHeifFormatAnimated(this.mImageFormat) == false) goto L5;
        return;
    L5:
        FrameScheduler r101 = newPrivateFrameScheduler(this.mAnimationBackend, this.mDecodeContext, this.mDecodeStatus, this.mImageFormat, r100);
        if (r101 == null) goto L9;
        this.mFrameScheduler = r101;
        return;
    }

    public AnimatedDrawable2(@Nullable AnimationBackend r100, @Nullable Object r101) {
        this.mLoopCount = -1000;
        this.mHasChangeLoopCount = false;
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mFrameSchedulingDelayMs = 8;
        this.mFrameSchedulingOffsetMs = 0;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new AnonymousClass1(this);
        this.mAnimationBackend = r100;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(r100, r101, 0, this.mImageFormat);
        this.mDecodeContext = r101;
    }

    public void updateDrawable(AnimationBackend r100, Object r101, int r102) {
        this.mAnimationBackend = r100;
        if (this.mFrameScheduler == null) goto L9;
        FrameScheduler r103 = createSchedulerForBackendAndDelayMethod(r100, r101, r102, this.mImageFormat);
        FrameScheduler r104 = this.mFrameScheduler.forNewFrameScheduler(r103);
        if (r104 == null) goto L7;
        r103 = r104;
    L7:
        this.mFrameScheduler = r103;
        return;
    }

    @Nullable
    private static FrameScheduler createSchedulerForBackendAndDelayMethod(@Nullable AnimationBackend r100, @Nullable Object r101, int r102, ImageFormat r103) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == false) goto L12;
        if (FrescoOptUtil.getHeifAnimDecodeOptType() != 1) goto L12;
        return new FixedSlidingHeifFrameScheduler(r100, r102);
    L12:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == false) goto L18;
        if (FrescoOptUtil.getHeifAnimDecodeOptType() != 2) goto L18;
        return new SmoothSlidingFrameScheduler(r100, r102);
    L18:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == true) goto L20;
    L25:
        FrameSchedulerFactory r104 = sFrameSchedulerFactory;
        if (r104 == null) goto L31;
        FrameScheduler r105 = r104.build(r100, r101, r103, r102);
        if (r105 == null) goto L31;
        return r105;
    L31:
        if (DefaultImageFormats.isHeifFormatAnimated(r103) == false) goto L39;
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() == true) goto L37;
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled() == false) goto L39;
    L37:
        return new FixedSlidingHeifFrameScheduler(r100, r102);
    L39:
        return new SmoothSlidingFrameScheduler(r100, r102);
    L20:
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() == true) goto L25;
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled() == true) goto L25;
        return new FixedSlidingHeifFrameScheduler(r100, r102);
    }

    public AnimatedDrawable2(@Nullable AnimationBackend r100, @Nullable Object r101, @Nullable BitmapFrameCache r102, int r103, ImageFormat r104) {
        this.mLoopCount = -1000;
        this.mHasChangeLoopCount = false;
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mFrameSchedulingDelayMs = 8;
        this.mFrameSchedulingOffsetMs = 0;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new AnonymousClass1(this);
        this.mAnimationBackend = r100;
        this.mImageFormat = r104;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(r100, r101, r103, r104);
        this.mFrameCache = r102;
        this.mDecodeStatus = r103;
        this.mDecodeContext = r101;
    }

    private FrameScheduler newPrivateFrameScheduler(@Nullable AnimationBackend r100, @Nullable Object r101, int r102, ImageFormat r103, FrameSchedulerFactory r104) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.build(r100, r101, r103, r102);
    }
}
