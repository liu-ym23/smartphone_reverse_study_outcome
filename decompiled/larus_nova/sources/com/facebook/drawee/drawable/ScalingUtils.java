package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ecom.arch.slice.render.SlcScaleType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ScalingUtils {

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class AbstractScaleType implements ScaleType {
        public AbstractScaleType() {
        }

        public abstract void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107);

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix r110, Rect r111, int r112, int r113, float r114, float r115) {
            getTransformImpl(r110, r111, r112, r113, r114, r115, r111.width() / r112, r111.height() / r113);
            return r110;
        }
    }

    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {

        @Nullable
        private final Rect mBoundsFrom;

        @Nullable
        private final Rect mBoundsTo;

        @Nullable
        private final PointF mFocusPointFrom;

        @Nullable
        private final PointF mFocusPointTo;
        private float mInterpolatingValue;
        private final float[] mMatrixValuesFrom;
        private final float[] mMatrixValuesInterpolated;
        private final float[] mMatrixValuesTo;
        private final ScaleType mScaleTypeFrom;
        private final ScaleType mScaleTypeTo;

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", new Object[]{String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo)});
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public Object getState() {
            return Float.valueOf(this.mInterpolatingValue);
        }

        @Nullable
        public Rect getBoundsFrom() {
            return this.mBoundsFrom;
        }

        @Nullable
        public Rect getBoundsTo() {
            return this.mBoundsTo;
        }

        @Nullable
        public PointF getFocusPointFrom() {
            return this.mFocusPointFrom;
        }

        @Nullable
        public PointF getFocusPointTo() {
            return this.mFocusPointTo;
        }

        public ScaleType getScaleTypeFrom() {
            return this.mScaleTypeFrom;
        }

        public ScaleType getScaleTypeTo() {
            return this.mScaleTypeTo;
        }

        public float getValue() {
            return this.mInterpolatingValue;
        }

        public void setValue(float r100) {
            this.mInterpolatingValue = r100;
        }

        public InterpolatingScaleType(ScaleType r100, ScaleType r101) {
            this(r100, r101, null, null);
        }

        public InterpolatingScaleType(ScaleType r100, ScaleType r101, @Nullable Rect r110, @Nullable Rect r111) {
            this(r100, r101, r110, r111, null, null);
        }

        public InterpolatingScaleType(ScaleType r100, ScaleType r101, @Nullable Rect r102, @Nullable Rect r103, @Nullable PointF r104, @Nullable PointF r105) {
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = r100;
            this.mScaleTypeTo = r101;
            this.mBoundsFrom = r102;
            this.mBoundsTo = r103;
            this.mFocusPointFrom = r104;
            this.mFocusPointTo = r105;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix r110, Rect r111, int r112, int r113, float r114, float r115) {
            Rect r100 = this.mBoundsFrom;
            if (r100 == null) goto L5;
            Rect r101 = r100;
        L6:
            Rect r102 = this.mBoundsTo;
            if (r102 == null) goto L9;
            Rect r103 = r102;
        L10:
            ScaleType r104 = this.mScaleTypeFrom;
            PointF r105 = this.mFocusPointFrom;
            if (r105 != null) goto L13;
            float r106 = r114;
        L14:
            if (r105 != null) goto L16;
            float r107 = r115;
        L17:
            r104.getTransform(r110, r101, r112, r113, r106, r107);
            r110.getValues(this.mMatrixValuesFrom);
            ScaleType r108 = this.mScaleTypeTo;
            PointF r109 = this.mFocusPointTo;
            if (r109 != null) goto L20;
            float r116 = r114;
        L21:
            if (r109 != null) goto L23;
            float r117 = r115;
        L24:
            r108.getTransform(r110, r103, r112, r113, r116, r117);
            r110.getValues(this.mMatrixValuesTo);
            int r118 = 0;
        L26:
            if (r118 >= 9) goto L28;
            float[] r119 = this.mMatrixValuesInterpolated;
            float r120 = this.mMatrixValuesFrom[r118];
            float r121 = this.mInterpolatingValue;
            r119[r118] = (r120 * (1.0f - r121)) + (this.mMatrixValuesTo[r118] * r121);
            r118 = r118 + 1;
            goto L26
        L28:
            r110.setValues(this.mMatrixValuesInterpolated);
            return r110;
        L23:
            r117 = r109.y;
            goto L24
        L20:
            r116 = r109.x;
            goto L21
        L16:
            r107 = r105.y;
            goto L17
        L13:
            r106 = r105.x;
            goto L14
        L9:
            r103 = r111;
            goto L10
        L5:
            r101 = r111;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ScaleType {
        public static final ScaleType CENTER = null;
        public static final ScaleType CENTER_CROP = null;
        public static final ScaleType CENTER_INSIDE = null;
        public static final ScaleType FIT_BOTTOM_START = null;
        public static final ScaleType FIT_CENTER = null;
        public static final ScaleType FIT_END = null;
        public static final ScaleType FIT_START = null;
        public static final ScaleType FIT_XY = null;
        public static final ScaleType FOCUS_CROP = null;

        Matrix getTransform(Matrix r100, Rect r101, int r102, int r103, float r104, float r105);

        static {
            FIT_XY = ScaleTypeFitXY.INSTANCE;
            FIT_START = ScaleTypeFitStart.INSTANCE;
            FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
            FIT_END = ScaleTypeFitEnd.INSTANCE;
            CENTER = ScaleTypeCenter.INSTANCE;
            CENTER_INSIDE = ScaleTypeCenterInside.INSTANCE;
            CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
            FOCUS_CROP = ScaleTypeFocusCrop.INSTANCE;
            FIT_BOTTOM_START = ScaleTypeFitBottomStart.INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "center";
        }

        static {
            INSTANCE = new ScaleTypeCenter();
        }

        private ScaleTypeCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            r100.setTranslate((int) ((r101.left + ((r101.width() - r102) * 0.5f)) + 0.5f), (int) ((r101.top + ((r101.height() - r103) * 0.5f)) + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return SlcScaleType.CENTER_CROP;
        }

        static {
            INSTANCE = new ScaleTypeCenterCrop();
        }

        private ScaleTypeCenterCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            if (r107 <= r106) goto L5;
            float r108 = r101.left + ((r101.width() - (r102 * r107)) * 0.5f);
            float r109 = r101.top;
            r106 = r107;
        L6:
            r100.setScale(r106, r106);
            r100.postTranslate((int) (r108 + 0.5f), (int) (r109 + 0.5f));
            return;
        L5:
            float r110 = r101.left;
            r109 = ((r101.height() - (r103 * r106)) * 0.5f) + r101.top;
            r108 = r110;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeCenterInside extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "center_inside";
        }

        static {
            INSTANCE = new ScaleTypeCenterInside();
        }

        private ScaleTypeCenterInside() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            float r108 = Math.min(Math.min(r106, r107), 1.0f);
            float r109 = r101.left + ((r101.width() - (r102 * r108)) * 0.5f);
            float r110 = r101.top + ((r101.height() - (r103 * r108)) * 0.5f);
            r100.setScale(r108, r108);
            r100.postTranslate((int) (r109 + 0.5f), (int) (r110 + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeFitBottomStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "fit_bottom_start";
        }

        static {
            INSTANCE = new ScaleTypeFitBottomStart();
        }

        private ScaleTypeFitBottomStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            float r108 = Math.min(r106, r107);
            float r109 = r101.left;
            float r110 = r101.top + (r101.height() - (r103 * r108));
            r100.setScale(r108, r108);
            r100.postTranslate((int) (r109 + 0.5f), (int) (r110 + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeFitCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "fit_center";
        }

        static {
            INSTANCE = new ScaleTypeFitCenter();
        }

        private ScaleTypeFitCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            float r108 = Math.min(r106, r107);
            float r109 = r101.left + ((r101.width() - (r102 * r108)) * 0.5f);
            float r110 = r101.top + ((r101.height() - (r103 * r108)) * 0.5f);
            r100.setScale(r108, r108);
            r100.postTranslate((int) (r109 + 0.5f), (int) (r110 + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeFitEnd extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "fit_end";
        }

        static {
            INSTANCE = new ScaleTypeFitEnd();
        }

        private ScaleTypeFitEnd() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            float r108 = Math.min(r106, r107);
            float r109 = r101.left + (r101.width() - (r102 * r108));
            float r110 = r101.top + (r101.height() - (r103 * r108));
            r100.setScale(r108, r108);
            r100.postTranslate((int) (r109 + 0.5f), (int) (r110 + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeFitStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "fit_start";
        }

        static {
            INSTANCE = new ScaleTypeFitStart();
        }

        private ScaleTypeFitStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            float r108 = Math.min(r106, r107);
            float r109 = r101.left;
            float r110 = r101.top;
            r100.setScale(r108, r108);
            r100.postTranslate((int) (r109 + 0.5f), (int) (r110 + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeFitXY extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return SlcScaleType.FIT_XY;
        }

        static {
            INSTANCE = new ScaleTypeFitXY();
        }

        private ScaleTypeFitXY() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            float r108 = r101.left;
            float r109 = r101.top;
            r100.setScale(r106, r107);
            r100.postTranslate((int) (r108 + 0.5f), (int) (r109 + 0.5f));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class ScaleTypeFocusCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = null;

        public String toString() {
            return "focus_crop";
        }

        static {
            INSTANCE = new ScaleTypeFocusCrop();
        }

        private ScaleTypeFocusCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r110, float r111) {
            if (r111 <= r110) goto L5;
            float r106 = r102 * r111;
            float r107 = r101.left + Math.max(Math.min((r101.width() * 0.5f) - (r104 * r106), 0.0f), r101.width() - r106);
            float r108 = r101.top;
            r110 = r111;
        L6:
            r100.setScale(r110, r110);
            r100.postTranslate((int) (r107 + 0.5f), (int) (r108 + 0.5f));
            return;
        L5:
            r107 = r101.left;
            float r109 = r103 * r110;
            float r112 = (r101.height() * 0.5f) - (r105 * r109);
            r108 = Math.max(Math.min(r112, 0.0f), r101.height() - r109) + r101.top;
            goto L6
        }
    }

    public interface StatefulScaleType {
        Object getState();
    }

    public ScalingUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable r100) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r100 instanceof ScaleTypeDrawable) == false) goto L10;
        return (ScaleTypeDrawable) r100;
    L10:
        if ((r100 instanceof DrawableParent) == false) goto L14;
        return getActiveScaleTypeDrawable(((DrawableParent) r100).getDrawable());
    L14:
        if ((r100 instanceof ArrayDrawable) == false) goto L21;
        ArrayDrawable r101 = (ArrayDrawable) r100;
        int r102 = r101.getNumberOfLayers();
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L21;
        ScaleTypeDrawable r104 = getActiveScaleTypeDrawable(r101.getDrawable(r103));
        if (r104 != null) goto L19;
        r103 = r103 + 1;
        goto L16
    L19:
        return r104;
    L21:
        return null;
    }
}
