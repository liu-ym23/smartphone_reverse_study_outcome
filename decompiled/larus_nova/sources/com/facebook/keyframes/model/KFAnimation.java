package com.facebook.keyframes.model;

import com.facebook.keyframes.model.keyframedmodels.KeyFramedAnchorPoint;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedMatrixAnimation;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedObject;
import com.facebook.keyframes.model.keyframedmodels.KeyFramedStrokeWidth;
import com.facebook.keyframes.util.ArgCheckUtil;
import com.facebook.keyframes.util.ListHelper;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KFAnimation {
    public static final String ANCHOR_JSON_FIELD = "anchor";
    public static final String ANIMATION_FRAMES_JSON_FIELD = "key_values";
    public static final Comparator<KFAnimation> ANIMATION_PROPERTY_COMPARATOR = null;
    public static final String PROPERTY_TYPE_JSON_FIELD = "property";
    public static final String TIMING_CURVES_JSON_FIELD = "timing_curves";
    private final float[] mAnchor;
    private final List<KFAnimationFrame> mAnimationFrames;
    private final KeyFramedObject mKeyFramedAnimation;
    private final PropertyType mPropertyType;
    private final float[][][] mTimingCurves;

    public static class Builder {
        public float[] anchor;
        public List<KFAnimationFrame> animationFrames;
        public PropertyType propertyType;
        public float[][][] timingCurves;

        public Builder() {
        }

        public KFAnimation build() {
            return new KFAnimation(this.propertyType, this.animationFrames, this.timingCurves, this.anchor);
        }
    }

    public static final enum PropertyType extends Enum<PropertyType> {
        private static final /* synthetic */ PropertyType[] $VALUES = null;
        public static final PropertyType ANCHOR_POINT = null;
        public static final PropertyType POSITION = null;
        public static final PropertyType ROTATION = null;
        public static final PropertyType SCALE = null;
        public static final PropertyType STROKE_WIDTH = null;
        public static final PropertyType X_POSITION = null;
        public static final PropertyType Y_POSITION = null;
        final boolean mIsMatrixBased;

        static {
            PropertyType r100 = new PropertyType("SCALE", 0, true);
            SCALE = r100;
            PropertyType r101 = new PropertyType("ROTATION", 1, true);
            ROTATION = r101;
            PropertyType r102 = new PropertyType("POSITION", 2, true);
            POSITION = r102;
            PropertyType r103 = new PropertyType("X_POSITION", 3, true);
            X_POSITION = r103;
            PropertyType r104 = new PropertyType("Y_POSITION", 4, true);
            Y_POSITION = r104;
            PropertyType r105 = new PropertyType("ANCHOR_POINT", 5, false);
            ANCHOR_POINT = r105;
            PropertyType r110 = new PropertyType("STROKE_WIDTH", 6, false);
            STROKE_WIDTH = r110;
            $VALUES = new PropertyType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static PropertyType[] values() {
            return (PropertyType[]) $VALUES.clone();
        }

        public boolean isMatrixBased() {
            return this.mIsMatrixBased;
        }

        public static PropertyType valueOf(String r100) {
            return (PropertyType) Enum.valueOf(PropertyType.class, r100);
        }

        private PropertyType(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.mIsMatrixBased = r102;
        }
    }

    static {
        ANIMATION_PROPERTY_COMPARATOR = new AnonymousClass1();
    }

    public float[] getAnchor() {
        return this.mAnchor;
    }

    public KeyFramedObject getAnimation() {
        return this.mKeyFramedAnimation;
    }

    public List<KFAnimationFrame> getAnimationFrames() {
        return this.mAnimationFrames;
    }

    public PropertyType getPropertyType() {
        return this.mPropertyType;
    }

    public float[][][] getTimingCurves() {
        return this.mTimingCurves;
    }

    public KFAnimation(PropertyType r100, List<KFAnimationFrame> r101, float[][][] r102, float[] r103) {
        boolean r104 = true;
        if (r100 == null) goto L5;
        boolean r105 = true;
    L6:
        PropertyType r106 = (PropertyType) ArgCheckUtil.checkArg(r100, r105, PROPERTY_TYPE_JSON_FIELD);
        this.mPropertyType = r106;
        List r107 = ListHelper.immutableOrEmpty(r101);
        if (r101 != null) goto L9;
    L11:
        boolean r108 = false;
    L12:
        List<KFAnimationFrame> r109 = (List) ArgCheckUtil.checkArg(r107, r108, "key_values");
        this.mAnimationFrames = r109;
        this.mTimingCurves = (float[][][]) ArgCheckUtil.checkArg(r102, ArgCheckUtil.checkTimingCurveObjectValidity(r102, r109.size()), "timing_curves");
        if (r103 != null) goto L15;
    L18:
        this.mAnchor = (float[]) ArgCheckUtil.checkArg(r103, r104, "anchor");
        if (r106.isMatrixBased() == false) goto L22;
        this.mKeyFramedAnimation = KeyFramedMatrixAnimation.fromAnimation(this);
        return;
    L22:
        if (r106 != PropertyType.STROKE_WIDTH) goto L25;
        this.mKeyFramedAnimation = KeyFramedStrokeWidth.fromAnimation(this);
        return;
    L25:
        if (r106 != PropertyType.ANCHOR_POINT) goto L29;
        this.mKeyFramedAnimation = KeyFramedAnchorPoint.fromAnchorPoint(this);
        return;
    L29:
        throw new IllegalArgumentException("Unknown property type for animation post processing: " + r106);
    L15:
        if (r103.length == 2) goto L18;
        r104 = false;
        goto L18
    L9:
        if (r101.size() <= 0) goto L11;
        r108 = true;
        goto L12
    L5:
        r105 = false;
        goto L6
    }
}
