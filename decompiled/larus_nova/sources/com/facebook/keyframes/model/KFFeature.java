package com.facebook.keyframes.model;

import android.graphics.Matrix;
import android.graphics.Paint;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedAnchorPoint;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedPath;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedStrokeWidth;
import com.facebook.keyframes.util.AnimationHelper;
import com.facebook.keyframes.util.ArgCheckUtil;
import com.facebook.keyframes.util.ListHelper;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KFFeature {
    public static final String ANIMATION_GROUP_JSON_FIELD = "animation_group";
    public static final String CLASS_NAME_JSON_FIELD = "class";
    public static final String EFFECT_JSON_FIELD = "effects";
    public static final String FEATURE_ANIMATIONS_JSON_FIELD = "feature_animations";
    public static final String FILL_COLOR_JSON_FIELD = "fill_color";
    public static final String FROM_FRAME_JSON_FIELD = "from_frame";
    public static final String KEY_FRAMES_JSON_FIELD = "key_frames";
    public static final String NAME_JSON_FIELD = "name";
    public static final String STROKE_COLOR_JSON_FIELD = "stroke_color";
    public static final String STROKE_LINE_CAP_JSON_FIELD = "stroke_line_cap";
    public static final String STROKE_WIDTH_JSON_FIELD = "stroke_width";
    public static final String TIMING_CURVES_JSON_FIELD = "timing_curves";
    public static final String TO_FRAME_JSON_FIELD = "to_frame";
    final KFAnimation mAnchorPoint;
    private final int mAnimationGroup;
    private final String mClassName;
    private final KFFeatureEffect mEffect;
    final List<KFAnimation> mFeatureMatrixAnimations;
    private final int mFillColor;
    private final float mFromFrame;
    private final KeyFramedPath mKeyFramedPath;
    private final List<KFFeatureFrame> mKeyFrames;
    private final String mName;
    private final int mStrokeColor;
    private final Paint.Cap mStrokeLineCap;
    private final float mStrokeWidth;
    final KFAnimation mStrokeWidthAnimation;
    private final float[][][] mTimingCurves;
    private final float mToFrame;

    public static class Builder {
        public float[] anchorPoint;
        public int animationGroup;
        public String className;
        public KFFeatureEffect effect;
        public List<KFAnimation> featureAnimations;
        public int fillColor;
        public float fromFrame;
        public List<KFFeatureFrame> keyFrames;
        public String name;
        public int strokeColor;
        public Paint.Cap strokeLineCap;
        public float strokeWidth;
        public float[][][] timingCurves;
        public float toFrame;

        public KFFeature build() {
            return new KFFeature(this.name, this.fillColor, this.strokeColor, this.strokeWidth, this.fromFrame, this.toFrame, this.keyFrames, this.timingCurves, this.animationGroup, this.strokeLineCap, this.featureAnimations, this.anchorPoint, this.effect, this.className);
        }

        public Builder() {
            this.fromFrame = 0.0f;
            this.toFrame = Float.MAX_VALUE;
            this.strokeLineCap = Paint.Cap.ROUND;
        }
    }

    public int getAnimationGroup() {
        return this.mAnimationGroup;
    }

    public String getConfigClassName() {
        return this.mClassName;
    }

    public KFFeatureEffect getEffect() {
        return this.mEffect;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public float getFromFrame() {
        return this.mFromFrame;
    }

    public List<KFFeatureFrame> getKeyFrames() {
        return this.mKeyFrames;
    }

    public String getName() {
        return this.mName;
    }

    public KeyFramedPath getPath() {
        return this.mKeyFramedPath;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public Paint.Cap getStrokeLineCap() {
        return this.mStrokeLineCap;
    }

    public float[][][] getTimingCurves() {
        return this.mTimingCurves;
    }

    public float getToFrame() {
        return this.mToFrame;
    }

    public void setAnimationMatrix(Matrix r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.reset();
        if (this.mFeatureMatrixAnimations != null) goto L7;
        return;
    L7:
        KFAnimation r102 = this.mAnchorPoint;
        if (r102 == null) goto L10;
        ((KeyFramedAnchorPoint) r102.getAnimation()).apply(r100);
    L10:
        int r103 = this.mFeatureMatrixAnimations.size();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L13;
        this.mFeatureMatrixAnimations.get(r104).getAnimation().apply(r101, r100);
        r104 = r104 + 1;
        goto L11
    }

    public void setStrokeWidth(KeyFramedStrokeWidth.StrokeWidth r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setStrokeWidth(this.mStrokeWidth);
        KFAnimation r102 = this.mStrokeWidthAnimation;
        if (r102 != null) goto L7;
        return;
    L7:
        r102.getAnimation().apply(r101, r100);
    }

    public KFFeature(String r100, int r101, int r102, float r103, float r104, float r105, List<KFFeatureFrame> r106, float[][][] r107, int r108, Paint.Cap r110, List<KFAnimation> r111, float[] r112, KFFeatureEffect r113, String r114) {
        this.mName = r100;
        this.mFillColor = r101;
        this.mStrokeColor = r102;
        this.mStrokeWidth = r103;
        this.mFromFrame = r104;
        this.mToFrame = r105;
        List<KFFeatureFrame> r109 = ListHelper.immutableOrEmpty(r106);
        this.mKeyFrames = r109;
        this.mTimingCurves = (float[][][]) ArgCheckUtil.checkArg(r107, ArgCheckUtil.checkTimingCurveObjectValidity(r107, r109.size()), "timing_curves");
        this.mAnimationGroup = r108;
        this.mStrokeLineCap = r110;
        this.mStrokeWidthAnimation = AnimationHelper.extractSpecialAnimationAnimationSet(r111, KFAnimation.PropertyType.STROKE_WIDTH);
        this.mAnchorPoint = AnimationHelper.extractSpecialAnimationAnimationSet(r111, KFAnimation.PropertyType.ANCHOR_POINT);
        ListHelper.sort(r111, KFAnimation.ANIMATION_PROPERTY_COMPARATOR);
        this.mFeatureMatrixAnimations = ListHelper.immutableOrEmpty(r111);
        this.mEffect = r113;
        this.mClassName = r114;
        if (r109.isEmpty() == false) goto L5;
        KeyFramedPath r115 = null;
    L6:
        this.mKeyFramedPath = r115;
        return;
    L5:
        r115 = KeyFramedPath.fromFeature(this);
        goto L6
    }
}
