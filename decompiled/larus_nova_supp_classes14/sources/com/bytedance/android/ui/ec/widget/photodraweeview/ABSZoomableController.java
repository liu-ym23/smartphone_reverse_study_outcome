package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ABSZoomableController implements ZoomableController, GestureListener<TransformGestureDetector> {
    private static final float DEFAULT_MIN_SCALE_FACTOR = 1.0f;
    protected static final float EPS = 0.001f;
    private static final float SCALE_FACTOR_UNDEFINE = 0.0f;
    private final Matrix mActiveTransform;
    private final Matrix mActiveTransformInverse;
    private TransformGestureDetector mGestureDetector;
    private final RectF mImageBounds;
    private ImageBoundsListener mImageBoundsListener;
    private boolean mIsEnabled;
    private boolean mIsScaleEnabled;
    private boolean mIsTranslationEnabled;
    private ZoomableController.Listener mListener;
    private float mMaxScaleFactor;
    private float mMinScaleFactor;
    private float mRecommendedMaxScaleFactor;
    private final float[] mTempValues;
    private final RectF mTransformedImageBounds;
    private final RectF mViewBounds;

    public interface ImageBoundsListener {
        void onImageBoundsSet(RectF r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void computeScroll() {
    }

    /* JADX INFO: renamed from: onGestureBegin, reason: avoid collision after fix types in other method */
    public void onGestureBegin2(TransformGestureDetector r1) {
    }

    /* JADX INFO: renamed from: onGestureEnd, reason: avoid collision after fix types in other method */
    public void onGestureEnd2(TransformGestureDetector r1) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeHorizontalScrollExtent() {
        return (int) this.mViewBounds.width();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeHorizontalScrollOffset() {
        return (int) (this.mViewBounds.left - this.mTransformedImageBounds.left);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeHorizontalScrollRange() {
        return (int) this.mTransformedImageBounds.width();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeVerticalScrollExtent() {
        return (int) this.mViewBounds.height();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeVerticalScrollOffset() {
        return (int) (this.mViewBounds.top - this.mTransformedImageBounds.top);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeVerticalScrollRange() {
        return (int) this.mTransformedImageBounds.height();
    }

    public float getMaxScaleFactor() {
        float r0 = this.mMaxScaleFactor;
        if (r0 == 0.0f) goto L5;
        return r0;
    L5:
        return this.mRecommendedMaxScaleFactor;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public float getScaleFactor() {
        return getMatrixScaleFactor(this.mActiveTransform);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean isIdentity() {
        return isMatrixIdentity(this.mActiveTransform, EPS);
    }

    public boolean isImageInBottomEdge() {
        if (Math.abs(this.mTransformedImageBounds.bottom - this.mViewBounds.bottom) >= EPS) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageInLeftEdge() {
        if (Math.abs(this.mTransformedImageBounds.left - this.mViewBounds.left) >= EPS) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageInRightEdge() {
        if (Math.abs(this.mTransformedImageBounds.right - this.mViewBounds.right) >= EPS) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageInTopEdge() {
        if (Math.abs(this.mTransformedImageBounds.top - this.mViewBounds.top) >= EPS) goto L5;
        return true;
    L5:
        return false;
    }

    public void onTransformChanged() {
        this.mActiveTransform.mapRect(this.mTransformedImageBounds, this.mImageBounds);
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L9;
        this.mListener.onTransformChanged(this.mActiveTransform);
        return;
    }

    public void reset() {
        this.mActiveTransform.reset();
        onTransformChanged();
    }

    private void updateRecommendedMaxScale() {
        RectF r0 = getViewBounds();
        RectF r1 = getImageBounds();
        if (r1.width() <= r0.width()) goto L5;
    L8:
        this.mRecommendedMaxScaleFactor = Math.max(r1.width() / r0.width(), r1.height() / r0.height());
        return;
    L5:
        if (r1.height() > r0.height()) goto L8;
        this.mRecommendedMaxScaleFactor = Math.max(r0.width() / r1.width(), r0.height() / r1.height());
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public Matrix getActiveTransform() {
        return this.mActiveTransform;
    }

    public TransformGestureDetector getDetector() {
        return this.mGestureDetector;
    }

    public RectF getImageBounds() {
        return this.mImageBounds;
    }

    public ImageBoundsListener getImageBoundsListener() {
        return this.mImageBoundsListener;
    }

    public ZoomableController.Listener getListener() {
        return this.mListener;
    }

    public float getMinScaleFactor() {
        return this.mMinScaleFactor;
    }

    public RectF getTransformedImageBounds() {
        return this.mTransformedImageBounds;
    }

    public RectF getViewBounds() {
        return this.mViewBounds;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public boolean isTranslationEnabled() {
        return this.mIsTranslationEnabled;
    }

    public ABSZoomableController(TransformGestureDetector r2) {
        this.mListener = null;
        this.mIsEnabled = false;
        this.mIsScaleEnabled = true;
        this.mIsTranslationEnabled = true;
        this.mMinScaleFactor = DEFAULT_MIN_SCALE_FACTOR;
        this.mMaxScaleFactor = 0.0f;
        this.mRecommendedMaxScaleFactor = 0.0f;
        this.mViewBounds = new RectF();
        this.mImageBounds = new RectF();
        this.mTransformedImageBounds = new RectF();
        this.mActiveTransform = new Matrix();
        this.mActiveTransformInverse = new Matrix();
        this.mTempValues = new float[9];
        this.mGestureDetector = r2;
        r2.addListener(this);
    }

    public float getMatrixScaleFactor(Matrix r2) {
        r2.getValues(this.mTempValues);
        return this.mTempValues[0];
    }

    public PointF mapViewToImage(PointF r10) {
        float[] r6 = this.mTempValues;
        r6[0] = r10.x;
        r6[1] = r10.y;
        this.mActiveTransform.invert(this.mActiveTransformInverse);
        this.mActiveTransformInverse.mapPoints(r6, 0, r6, 0, 1);
        return new PointF(r6[0], r6[1]);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r1) {
        onGestureBegin2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r1) {
        onGestureEnd2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r1) {
        onGestureUpdate2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.mIsEnabled == true) goto L5;
        return false;
    L5:
        return this.mGestureDetector.onTouchEvent(r2);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setEnabled(boolean r1) {
        this.mIsEnabled = r1;
        if (r1 == true) goto L6;
        reset();
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setImageBounds(RectF r2) {
        if (r2.equals(this.mImageBounds) == true) goto L8;
        this.mImageBounds.set(r2);
        updateRecommendedMaxScale();
        onTransformChanged();
        ImageBoundsListener r3 = this.mImageBoundsListener;
        if (r3 == null) goto L9;
        r3.onImageBoundsSet(this.mImageBounds);
        return;
    L9:
        return;
    }

    public void setImageBoundsListener(ImageBoundsListener r1) {
        this.mImageBoundsListener = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setListener(ZoomableController.Listener r1) {
        this.mListener = r1;
    }

    public void setMaxScaleFactor(float r2) {
        if (r2 >= DEFAULT_MIN_SCALE_FACTOR) goto L5;
        return;
    L5:
        if (r2 < this.mMinScaleFactor) goto L10;
        this.mMaxScaleFactor = r2;
        return;
    }

    public void setMinScaleFactor(float r2) {
        if (r2 >= DEFAULT_MIN_SCALE_FACTOR) goto L5;
        return;
    L5:
        if (r2 > this.mMaxScaleFactor) goto L10;
        this.mMinScaleFactor = r2;
        return;
    }

    public void setScaleEnabled(boolean r1) {
        this.mIsScaleEnabled = r1;
    }

    public void setTransform(Matrix r2) {
        this.mActiveTransform.set(r2);
        onTransformChanged();
    }

    public void setTranslationEnabled(boolean r1) {
        this.mIsTranslationEnabled = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setViewBounds(RectF r2) {
        this.mViewBounds.set(r2);
        updateRecommendedMaxScale();
    }

    /* JADX INFO: renamed from: onGestureUpdate, reason: avoid collision after fix types in other method */
    public void onGestureUpdate2(TransformGestureDetector r1) {
        onTransformChanged();
    }

    private boolean isMatrixIdentity(Matrix r5, float r6) {
        r5.getValues(this.mTempValues);
        float[] r7 = this.mTempValues;
        r7[0] = r7[0] - DEFAULT_MIN_SCALE_FACTOR;
        r7[4] = r7[4] - DEFAULT_MIN_SCALE_FACTOR;
        r7[8] = r7[8] - DEFAULT_MIN_SCALE_FACTOR;
        int r8 = 0;
    L4:
        if (r8 >= 9) goto L9;
        if (Math.abs(this.mTempValues[r8]) > r6) goto L7;
        r8 = r8 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }
}
