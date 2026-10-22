package com.facebook.keyframes;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.facebook.keyframes.model.KFAnimationGroup;
import com.facebook.keyframes.model.KFFeature;
import com.facebook.keyframes.model.KFGradient;
import com.facebook.keyframes.model.KFImage;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedGradient;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedPath;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedStrokeWidth;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class KeyframesDrawable extends Drawable implements KeyframesDrawableAnimationCallback.FrameListener, KeyframesDirectionallyScalingDrawable {
    private static final float GRADIENT_PRECISION_PER_SECOND = 30.0f;
    private final SparseArray<Matrix> mAnimationGroupMatrices;
    private final Paint mDrawingPaint;
    private final Map<String, FeatureConfig> mFeatureConfigs;
    private final List<FeatureState> mFeatureStateList;
    private boolean mHasInitialized;
    private final Matrix mInverseScaleMatrix;
    private final KFImage mKFImage;
    private final KeyframesDrawableAnimationCallback mKeyframesDrawableAnimationCallback;
    private WeakReference<OnAnimationEnd> mOnAnimationEnd;
    private final Matrix mRecyclableTransformMatrix;
    private float mScale;
    private float mScaleFromCenter;
    private float mScaleFromEnd;
    private final Matrix mScaleMatrix;
    private int mSetHeight;
    private int mSetWidth;

    public static class FeatureConfig {
        final Drawable drawable;
        final Matrix matrix;

        public FeatureConfig(Drawable r100, Matrix r101) {
            this.matrix = r101;
            this.drawable = r100;
        }
    }

    public class FeatureState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Shader[] mCachedShaders;
        private Shader mCurrentShader;
        private final KFFeature mFeature;
        private final Matrix mFeatureMatrix;
        private boolean mIsVisible;
        private final float[] mMatrixValueRecyclableArray;
        private final KFPath mPath;
        private final KeyFramedStrokeWidth.StrokeWidth mStrokeWidth;
        final /* synthetic */ KeyframesDrawable this$0;

        public final FeatureConfig getConfig() {
            if (KeyframesDrawable.access$300(this.this$0) != null) goto L7;
            return null;
        L7:
            return (FeatureConfig) KeyframesDrawable.access$300(this.this$0).get(this.mFeature.getConfigClassName());
        }

        public int getFillColor() {
            return this.mFeature.getFillColor();
        }

        public int getStrokeColor() {
            return this.mFeature.getStrokeColor();
        }

        public Paint.Cap getStrokeLineCap() {
            return this.mFeature.getStrokeLineCap();
        }

        public float getStrokeWidth() {
            KeyFramedStrokeWidth.StrokeWidth r100 = this.mStrokeWidth;
            if (r100 != null) goto L7;
            return 0.0f;
        L7:
            return r100.getStrokeWidth();
        }

        public Matrix getUniqueFeatureMatrix() {
            if (this.mFeatureMatrix != KeyframesDrawable.access$000(this.this$0)) goto L7;
            return null;
        L7:
            return this.mFeatureMatrix;
        }

        private boolean hasCustomDrawable() {
            FeatureConfig r100 = getConfig();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.drawable == null) goto L7;
            return true;
        }

        static {
        }

        public KFPath getCurrentPathForDrawing() {
            return this.mPath;
        }

        public Shader getCurrentShader() {
            return this.mCurrentShader;
        }

        public boolean isVisible() {
            return this.mIsVisible;
        }

        private float extractScaleFromMatrix(Matrix r100) {
            r100.getValues(this.mMatrixValueRecyclableArray);
            return (Math.abs(this.mMatrixValueRecyclableArray[0]) + Math.abs(this.mMatrixValueRecyclableArray[4])) / 2.0f;
        }

        private void prepareShadersForFeature(KFFeature r110) {
            if (this.mCachedShaders == null) goto L5;
            return;
        L5:
            int r100 = KeyframesDrawable.access$200(this.this$0).getFrameRate();
            float r101 = KeyframesDrawable.access$200(this.this$0).getFrameCount();
            int r102 = Math.round((30.0f * r101) / r100);
            this.mCachedShaders = new LinearGradient[r102 + 1];
            KeyFramedGradient.GradientColorPair r103 = new KeyFramedGradient.GradientColorPair();
            KFGradient r111 = r110.getEffect().getGradient();
            int r104 = 0;
        L6:
            if (r104 >= r102) goto L8;
            float r105 = (r104 / r102) * r101;
            r111.getStartGradient().apply(r105, r103);
            r111.getEndGradient().apply(r105, r103);
            this.mCachedShaders[r104] = new LinearGradient(0.0f, 0.0f, 0.0f, KeyframesDrawable.access$200(this.this$0).getCanvasSize()[1], r103.getStartColor(), r103.getEndColor(), Shader.TileMode.CLAMP);
            r104 = r104 + 1;
            goto L6
        }

        public Shader getNearestShaderForFeature(float r100) {
            if (this.mCachedShaders != null) goto L6;
            return null;
        L6:
            float r101 = r100 / KeyframesDrawable.access$200(this.this$0).getFrameCount();
            Shader[] r102 = this.mCachedShaders;
            return r102[(int) (r101 * (r102.length - 1))];
        }

        public void setupFeatureStateForProgress(float r100) {
            if (r100 >= this.mFeature.getFromFrame()) goto L5;
        L21:
            this.mIsVisible = false;
            return;
        L5:
            if (r100 > this.mFeature.getToFrame()) goto L21;
            this.mIsVisible = true;
            this.mFeature.setAnimationMatrix(this.mFeatureMatrix, r100);
            Matrix r101 = (Matrix) KeyframesDrawable.access$100(this.this$0).get(this.mFeature.getAnimationGroup());
            if (r101 != null) goto L10;
        L12:
            KeyFramedPath r102 = this.mFeature.getPath();
            if (hasCustomDrawable() == true) goto L23;
            if (r102 == null) goto L24;
            this.mPath.reset();
            r102.apply(r100, this.mPath);
            this.mPath.transform(this.mFeatureMatrix);
            this.mFeature.setStrokeWidth(this.mStrokeWidth, r100);
            this.mStrokeWidth.adjustScale(extractScaleFromMatrix(this.mFeatureMatrix));
            if (this.mFeature.getEffect() == null) goto L19;
            prepareShadersForFeature(this.mFeature);
        L19:
            this.mCurrentShader = getNearestShaderForFeature(r100);
            return;
        L24:
            return;
        L23:
            return;
        L10:
            if (r101.isIdentity() == true) goto L12;
            this.mFeatureMatrix.postConcat(r101);
            goto L12
        }

        public FeatureState(KeyframesDrawable r100, KFFeature r101) {
            this.this$0 = r100;
            this.mMatrixValueRecyclableArray = new float[9];
            this.mFeature = r101;
            if (hasCustomDrawable() == false) goto L5;
            this.mPath = null;
            this.mStrokeWidth = null;
            this.mFeatureMatrix = new Matrix();
            return;
        L5:
            this.mPath = new KFPath();
            this.mStrokeWidth = new KeyFramedStrokeWidth.StrokeWidth();
            this.mFeatureMatrix = KeyframesDrawable.access$000(r100);
        }
    }

    public interface OnAnimationEnd {
        void onAnimationEnd();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
    }

    @Override // com.facebook.keyframes.KeyframesDrawableAnimationCallback.FrameListener
    public void onStop() {
        WeakReference<OnAnimationEnd> r100 = this.mOnAnimationEnd;
        if (r100 != null) goto L5;
        return;
    L5:
        OnAnimationEnd r101 = r100.get();
        if (r101 != null) goto L8;
        return;
    L8:
        r101.onAnimationEnd();
        this.mOnAnimationEnd.clear();
    }

    public void startAnimation() {
        this.mKeyframesDrawableAnimationCallback.start();
    }

    public void stopAnimation() {
        this.mKeyframesDrawableAnimationCallback.stop();
    }

    public void stopAnimationAtLoopEnd() {
        this.mKeyframesDrawableAnimationCallback.stopAtLoopEnd();
    }

    public KeyframesDrawable(KeyframesDrawableBuilder r100) {
        Paint r101 = new Paint(1);
        this.mDrawingPaint = r101;
        int r102 = 0;
        this.mHasInitialized = false;
        KFImage r103 = r100.getImage();
        this.mKFImage = r103;
        if (r100.getExperimentalFeatures().getParticleFeatureConfigs() != null) goto L5;
        Map<String, FeatureConfig> r104 = null;
    L6:
        this.mFeatureConfigs = r104;
        this.mRecyclableTransformMatrix = new Matrix();
        this.mScaleMatrix = new Matrix();
        this.mInverseScaleMatrix = new Matrix();
        this.mKeyframesDrawableAnimationCallback = KeyframesDrawableAnimationCallback.create(this, this.mKFImage);
        r101.setStrokeCap(Paint.Cap.ROUND);
        ArrayList r105 = new ArrayList();
        int r106 = r103.getFeatures().size();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r105.add(new FeatureState(this, this.mKFImage.getFeatures().get(r107)));
        r107 = r107 + 1;
        goto L7
    L9:
        this.mFeatureStateList = Collections.unmodifiableList(r105);
        this.mAnimationGroupMatrices = new SparseArray();
        List<KFAnimationGroup> r108 = this.mKFImage.getAnimationGroups();
        int r109 = r108.size();
    L10:
        if (r102 >= r109) goto L12;
        this.mAnimationGroupMatrices.put(r108.get(r102).getGroupId(), new Matrix());
        r102 = r102 + 1;
        goto L10
    L12:
        setMaxFrameRate(r100.getMaxFrameRate());
        return;
    L5:
        r104 = Collections.unmodifiableMap(r100.getExperimentalFeatures().getParticleFeatureConfigs());
        goto L6
    }

    public static /* synthetic */ Matrix access$000(KeyframesDrawable r100) {
        return r100.mRecyclableTransformMatrix;
    }

    public static /* synthetic */ SparseArray access$100(KeyframesDrawable r100) {
        return r100.mAnimationGroupMatrices;
    }

    public static /* synthetic */ KFImage access$200(KeyframesDrawable r100) {
        return r100.mKFImage;
    }

    public static /* synthetic */ Map access$300(KeyframesDrawable r100) {
        return r100.mFeatureConfigs;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Rect r101 = getBounds();
        r100.translate(r101.left, r101.top);
        int r102 = this.mFeatureStateList.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L41;
        FeatureState r104 = this.mFeatureStateList.get(r103);
        if (r104.isVisible() == false) goto L40;
        FeatureConfig r105 = r104.getConfig();
        Matrix r106 = r104.getUniqueFeatureMatrix();
        if (r105 != null) goto L10;
    L24:
        KFPath r107 = r104.getCurrentPathForDrawing();
        if (r107 == null) goto L40;
        if (r107.isEmpty() == true) goto L40;
        this.mDrawingPaint.setShader(null);
        this.mDrawingPaint.setStrokeCap(r104.getStrokeLineCap());
        if (r104.getFillColor() == 0) goto L36;
        this.mDrawingPaint.setStyle(Paint.Style.FILL);
        if (r104.getCurrentShader() != null) goto L34;
        this.mDrawingPaint.setColor(r104.getFillColor());
        r107.transform(this.mScaleMatrix);
        r100.drawPath(r107.getPath(), this.mDrawingPaint);
        r107.transform(this.mInverseScaleMatrix);
        goto L36
    L34:
        this.mDrawingPaint.setShader(r104.getCurrentShader());
        r100.concat(this.mScaleMatrix);
        r100.drawPath(r107.getPath(), this.mDrawingPaint);
        r100.concat(this.mInverseScaleMatrix);
    L36:
        if (r104.getStrokeColor() == 0) goto L40;
        if (r104.getStrokeWidth() <= 0.0f) goto L40;
        this.mDrawingPaint.setColor(r104.getStrokeColor());
        this.mDrawingPaint.setStyle(Paint.Style.STROKE);
        this.mDrawingPaint.setStrokeWidth(((r104.getStrokeWidth() * this.mScale) * this.mScaleFromCenter) * this.mScaleFromEnd);
        r107.transform(this.mScaleMatrix);
        r100.drawPath(r107.getPath(), this.mDrawingPaint);
        r107.transform(this.mInverseScaleMatrix);
        goto L40
    L10:
        if (r105.drawable == null) goto L24;
        if (r106 == null) goto L24;
        r100.save();
        r100.concat(this.mScaleMatrix);
        r100.concat(r106);
        Matrix r108 = r105.matrix;
        if (r108 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L20;
        r100.save();
        r100.concat(r105.matrix);
    L20:
        r105.drawable.draw(r100);
        if (r109 == false) goto L23;
        r100.restore();
    L23:
        r100.restore();
        goto L40
    L15:
        if (r108.isIdentity() == true) goto L17;
        r109 = true;
    L40:
        r103 = r103 + 1;
        goto L3
    L41:
        r100.translate(-r101.left, -r101.top);
    }

    @Override // com.facebook.keyframes.KeyframesDrawableAnimationCallback.FrameListener
    public void onProgressUpdate(float r100) {
        setFrameProgress(r100);
        invalidateSelf();
    }

    public void setAnimationListener(OnAnimationEnd r100) {
        this.mOnAnimationEnd = new WeakReference(r100);
    }

    public void setFrameProgress(float r100) {
        this.mHasInitialized = true;
        this.mKFImage.setAnimationMatrices(this.mAnimationGroupMatrices, r100);
        int r101 = this.mFeatureStateList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        this.mFeatureStateList.get(r102).setupFeatureStateForProgress(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void setMaxFrameRate(int r100) {
        this.mKeyframesDrawableAnimationCallback.setMaxFrameRate(r100);
    }

    private void calculateScaleMatrix(float r100, float r101, KeyframesDirectionallyScalingDrawable.ScaleDirection r102) {
        if (this.mScaleFromCenter == r100) goto L5;
    L7:
        Matrix r103 = this.mScaleMatrix;
        float r104 = this.mScale;
        r103.setScale(r104, r104);
        if (r100 != 1.0f) goto L14;
        if (r101 != 1.0f) goto L14;
        this.mScaleFromCenter = 1.0f;
        this.mScaleFromEnd = 1.0f;
        this.mScaleMatrix.invert(this.mInverseScaleMatrix);
        return;
    L14:
        if (r102 != KeyframesDirectionallyScalingDrawable.ScaleDirection.UP) goto L16;
        float r105 = this.mSetHeight;
    L17:
        this.mScaleMatrix.postScale(r100, r100, this.mSetWidth / 2, this.mSetHeight / 2);
        this.mScaleMatrix.postScale(r101, r101, this.mSetWidth / 2, r105);
        this.mScaleFromCenter = r100;
        this.mScaleFromEnd = r101;
        this.mScaleMatrix.invert(this.mInverseScaleMatrix);
        return;
    L16:
        r105 = 0.0f;
        goto L17
    L5:
        if (this.mScaleFromEnd != r101) goto L7;
    }

    @Override // com.facebook.keyframes.KeyframesDirectionallyScalingDrawable
    public void setDirectionalScale(float r100, float r101, KeyframesDirectionallyScalingDrawable.ScaleDirection r102) {
        calculateScaleMatrix(r100, r101, r102);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        int r104 = r102 - r100;
        this.mSetWidth = r104;
        this.mSetHeight = r103 - r101;
        this.mScale = Math.min(r104 / this.mKFImage.getCanvasSize()[0], this.mSetHeight / this.mKFImage.getCanvasSize()[1]);
        calculateScaleMatrix(1.0f, 1.0f, KeyframesDirectionallyScalingDrawable.ScaleDirection.UP);
        if (this.mHasInitialized == true) goto L6;
        setFrameProgress(0.0f);
        return;
    }
}
