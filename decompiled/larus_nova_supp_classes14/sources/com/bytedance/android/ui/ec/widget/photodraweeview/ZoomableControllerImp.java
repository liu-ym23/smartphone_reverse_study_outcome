package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ZoomableControllerImp extends ABSZoomableController {
    public static final long DEFAULT_ANIMATION_DURATION = 400;
    public static final int LIMIT_ALL = 7;
    public static final int LIMIT_NONE = 0;
    public static final int LIMIT_SCALE = 4;
    public static final int LIMIT_TRANSLATION_X = 1;
    public static final int LIMIT_TRANSLATION_Y = 2;
    private long animationDuration;
    private Runnable enableGestureWhenCompleted;
    private final Matrix mAnimeWorkingTransform;
    private Context mContext;
    private final float[] mCurrentValues;
    private boolean mDisableGesture;
    private final Matrix mFlingStartTempTransform;
    private boolean mHorizontalNestedScrollEnabled;
    private final Matrix mNewTransform;
    private Scroller mScroller;
    private final float[] mStartValues;
    private final float[] mStopValues;
    private final RectF mTempRect;
    private final ValueAnimator mValueAnimator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public static /* synthetic */ void a(ZoomableControllerImp r0, Runnable r1) {
        r0.lambda$zoomToPoint$1(r1);
    }

    public static /* synthetic */ void b(ZoomableControllerImp r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void c(ZoomableControllerImp r0, ValueAnimator.AnimatorUpdateListener r1, ValueAnimator r2) {
        r0.lambda$setTransformAnimated$2(r1, r2);
    }

    private /* synthetic */ void lambda$new$0() {
        setDisableGesture(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureEnd(TransformGestureDetector r1) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset() == false) goto L6;
        int r0 = this.mScroller.getCurrX();
        int r1 = this.mScroller.getCurrY();
        this.mNewTransform.set(this.mFlingStartTempTransform);
        calculateTranslateToPointTransform(this.mNewTransform, r0, r1);
        setTransformImmediate(this.mNewTransform);
        return;
    }

    public boolean isAnimating() {
        return this.mValueAnimator.isRunning();
    }

    public boolean isAnimatingOrScrolling() {
        if (this.mValueAnimator.isRunning() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mScroller.computeScrollOffset() == true) goto L8;
        return false;
    }

    public boolean isScrolling() {
        return this.mScroller.computeScrollOffset();
    }

    public void trySpringBack() {
        this.mNewTransform.set(getActiveTransform());
        RectF r0 = getViewBounds();
        if ((limitScale(this.mNewTransform, r0.centerX(), r0.centerY()) | limitTranslation(this.mNewTransform)) == false) goto L6;
        setDisableGesture(true);
        setTransformAnimated(this.mNewTransform, this.animationDuration, this.enableGestureWhenCompleted, null);
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean isIdentity() {
        if (isAnimatingOrScrolling() == false) goto L5;
    L7:
        return false;
    L5:
        if (super.isIdentity() == false) goto L7;
        return true;
    }

    public boolean isImageOutTopEdge() {
        if ((getViewBounds().top - getTransformedImageBounds().top) <= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isParentScrollEnabled() {
        if (isHorizontalNestedScrollEnabled() == false) goto L18;
        TransformGestureDetector r0 = getDetector();
        if (isImageInLeftEdge() == true) goto L9;
        if (isIdentity() == true) goto L9;
    L12:
        if (isImageInRightEdge() == true) goto L16;
        if (isIdentity() == true) goto L16;
        return false;
    L16:
        if (r0.getGestureIntent() != 1) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (r0.getGestureIntent() != 3) goto L12;
        return true;
    L18:
        return false;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void reset() {
        stopAnimatingAndScrolling();
        this.mAnimeWorkingTransform.reset();
        this.mNewTransform.reset();
        super.reset();
    }

    public void stopAnimating() {
        if (isAnimating() == false) goto L6;
        this.mValueAnimator.cancel();
        this.mValueAnimator.removeAllUpdateListeners();
        this.mValueAnimator.removeAllListeners();
        return;
    }

    public void stopAnimatingAndScrolling() {
        stopAnimating();
        stopScrolling();
    }

    public void stopScrolling() {
        if (isScrolling() == false) goto L6;
        this.mScroller.forceFinished(true);
        return;
    }

    public long getAnimationDuration() {
        return this.animationDuration;
    }

    public Matrix getAnimeWorkingTransform() {
        return this.mAnimeWorkingTransform;
    }

    public boolean isDisableGesture() {
        return this.mDisableGesture;
    }

    public boolean isHorizontalNestedScrollEnabled() {
        return this.mHorizontalNestedScrollEnabled;
    }

    public static /* synthetic */ ValueAnimator access$000(ZoomableControllerImp r0) {
        return r0.mValueAnimator;
    }

    private /* synthetic */ void lambda$zoomToPoint$1(Runnable r2) {
        setDisableGesture(false);
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    private void setTransformImmediate(Matrix r2) {
        if (isAnimating() == false) goto L5;
        stopAnimating();
    L5:
        this.mAnimeWorkingTransform.set(r2);
        super.setTransform(r2);
    }

    public boolean calculateGestureTransform(Matrix r6) {
        TransformGestureDetector r0 = getDetector();
        r6.set(getActiveTransform());
        if (isTranslationEnabled() == false) goto L6;
        r6.postTranslate(r0.getDeltaTranslationX(), r0.getDeltaTranslationY());
    L6:
        if (isScaleEnabled() == false) goto L11;
        if (r0.isMultiPointer() == false) goto L11;
        r6.postScale(r0.getDeltaScale(), r0.getDeltaScale(), r0.getPivotX(), r0.getPivotY());
    L11:
        if (r0.isSinglePointer() == false) goto L13;
    L14:
        limitTranslation(r6);
        return true;
    L13:
        if (isScaleEnabled() == false) goto L14;
        return true;
    }

    public boolean limitTranslation(Matrix r11) {
        RectF r0 = this.mTempRect;
        RectF r1 = getImageBounds();
        RectF r2 = getViewBounds();
        r0.set(r1);
        r11.mapRect(r0);
        float r3 = getOffset(r0.left, r0.right, r2.left, r2.right, r1.centerX());
        float r4 = getOffset(r0.top, r0.bottom, r2.top, r2.bottom, r1.centerY());
        if (r3 == 0.0f) goto L5;
    L9:
        r11.postTranslate(r3, r4);
        return true;
    L5:
        if (r4 != 0.0f) goto L9;
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureBegin(TransformGestureDetector r1) {
        if (this.mDisableGesture == false) goto L5;
        return;
    L5:
        stopAnimatingAndScrolling();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r1) {
        onGestureEnd(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureUpdate(TransformGestureDetector r2) {
        if (this.mDisableGesture == false) goto L6;
        return;
    L6:
        if (isAnimatingOrScrolling() == false) goto L9;
        return;
    L9:
        if (r2.isPointerCountChanged() == true) goto L11;
    L13:
        calculateGestureTransform(getActiveTransform());
        onTransformChanged();
        return;
    L11:
        if (r2.isSinglePointer() == false) goto L13;
        trySpringBack();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 3) goto L7;
        return super.onTouchEvent(r3);
    L7:
        if (isParentScrollEnabled() == false) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r3);
    }

    public void setAnimationDuration(long r1) {
        this.animationDuration = r1;
    }

    public void setDisableGesture(boolean r1) {
        this.mDisableGesture = r1;
    }

    public void setHorizontalNestedScrollEnabled(boolean r1) {
        this.mHorizontalNestedScrollEnabled = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r1) {
        onGestureBegin(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r1) {
        onGestureUpdate(r1);
    }

    public ZoomableControllerImp(TransformGestureDetector r3, Context r4) {
        super(r3);
        this.mStartValues = new float[9];
        this.mStopValues = new float[9];
        this.mCurrentValues = new float[9];
        this.mNewTransform = new Matrix();
        this.mAnimeWorkingTransform = new Matrix();
        this.mFlingStartTempTransform = new Matrix();
        this.mHorizontalNestedScrollEnabled = false;
        this.animationDuration = 400;
        this.enableGestureWhenCompleted = new c(this);
        this.mTempRect = new RectF();
        this.mDisableGesture = false;
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mValueAnimator = r5;
        r5.setInterpolator(new DecelerateInterpolator(1.2f));
        this.mContext = r4;
        this.mScroller = new Scroller(this.mContext);
    }

    private /* synthetic */ void lambda$setTransformAnimated$2(ValueAnimator.AnimatorUpdateListener r3, ValueAnimator r4) {
        calculateInterpolation(this.mAnimeWorkingTransform, ((Float) r4.getAnimatedValue()).floatValue());
        setTransform(this.mAnimeWorkingTransform);
        if (r3 == null) goto L6;
        r3.onAnimationUpdate(r4);
        return;
    }

    public void calculateInterpolation(Matrix r5, float r6) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        this.mCurrentValues[r0] = ((1.0f - r6) * this.mStartValues[r0]) + (this.mStopValues[r0] * r6);
        r0 = r0 + 1;
        goto L4
    L6:
        r5.setValues(this.mCurrentValues);
    }

    public void fling(int r11, int r12) {
        if (isAnimating() == false) goto L5;
        return;
    L5:
        if (isTranslationEnabled() == true) goto L8;
        return;
    L8:
        if (isScrolling() == false) goto L10;
        stopScrolling();
    L10:
        this.mScroller.fling(0, 0, r11, r12, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.mFlingStartTempTransform.set(getActiveTransform());
        setTransform(getActiveTransform());
    }

    public void calculateTranslateToPointTransform(Matrix r1, float r2, float r3) {
        r1.postTranslate(r2, r3);
        limitTranslation(r1);
    }

    public void calculateZoomToPointTransform(Matrix r3, float r4, PointF r5) {
        PointF r6 = mapViewToImage(r5);
        r3.setScale(r4, r4, r6.x, r6.y);
        limitScale(r3, r6.x, r6.y);
        limitTranslation(r3);
    }

    public boolean limitScale(Matrix r4, float r5, float r6) {
        float r0 = getMatrixScaleFactor(r4);
        float r1 = Math.min(Math.max(getMinScaleFactor(), r0), getMaxScaleFactor());
        if (r1 == r0) goto L6;
        float r2 = r1 / r0;
        r4.postScale(r2, r2, r5, r6);
        return true;
    L6:
        return false;
    }

    public void setTransformAnimated(Matrix r2, long r3, final Runnable r5, final ValueAnimator.AnimatorUpdateListener r6) {
        if (isAnimating() == false) goto L5;
        stopAnimating();
    L5:
        this.mValueAnimator.setDuration(r3);
        getActiveTransform().getValues(this.mStartValues);
        r2.getValues(this.mStopValues);
        this.mValueAnimator.addUpdateListener(new a(this, r6));
        this.mValueAnimator.addListener(new AnonymousClass1(this, r5));
        this.mValueAnimator.start();
    }

    public void zoomToPoint(float r8, PointF r9, final Runnable r10, ValueAnimator.AnimatorUpdateListener r11) {
        if (isScaleEnabled() == true) goto L6;
        return;
    L6:
        if (isAnimating() == false) goto L8;
        stopAnimating();
    L8:
        setDisableGesture(true);
        Runnable r5 = new b(this, r10);
        this.mNewTransform.reset();
        calculateZoomToPointTransform(this.mNewTransform, r8, r9);
        setTransformAnimated(this.mNewTransform, getAnimationDuration(), r5, r11);
    }

    public float getOffset(float r5, float r6, float r7, float r8, float r9) {
        float r0 = r6 - r5;
        float r1 = r8 - r7;
        if (r0 >= (Math.min(r9 - r7, r8 - r9) * 2.0f)) goto L7;
        return r9 - ((r6 + r5) / 2.0f);
    L7:
        if (r0 >= r1) goto L15;
        if (r9 >= ((r7 + r8) / 2.0f)) goto L13;
        return r7 - r5;
    L13:
        return r8 - r6;
    L15:
        if (r5 <= r7) goto L19;
        return r7 - r5;
    L19:
        if (r6 < r8) goto L21;
        return 0.0f;
    L21:
        return r8 - r6;
    }
}
