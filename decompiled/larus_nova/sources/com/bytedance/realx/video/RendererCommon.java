package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* JADX INFO: renamed from: com.bytedance.realx.video.RendererCommon$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType = null;

        static {
            int[] r100 = new int[ScalingType.values().length];
            $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType = r100;
            r100[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface GlDrawer {
        void drawOes(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107);

        void drawOes(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111);

        void drawOes(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111, int r112, int r113);

        void drawRgb(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107);

        void drawRgb(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111);

        void drawRgb(int r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111, int r112, int r113);

        void drawYuv(int[] r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107);

        void drawYuv(int[] r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111);

        void drawYuv(int[] r100, float[] r101, int r102, int r103, int r104, int r105, int r106, int r107, FilterType r108, int r110, int r111, int r112, int r113);

        void release();
    }

    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int r100, int r101, int r102);
    }

    public static final enum ScalingType extends Enum<ScalingType> {
        private static final /* synthetic */ ScalingType[] $VALUES = null;
        public static final ScalingType SCALE_ASPECT_BALANCED = null;
        public static final ScalingType SCALE_ASPECT_FILL = null;
        public static final ScalingType SCALE_ASPECT_FIT = null;

        static {
            ScalingType r100 = new ScalingType("SCALE_ASPECT_FIT", 0);
            SCALE_ASPECT_FIT = r100;
            ScalingType r101 = new ScalingType("SCALE_ASPECT_FILL", 1);
            SCALE_ASPECT_FILL = r101;
            ScalingType r102 = new ScalingType("SCALE_ASPECT_BALANCED", 2);
            SCALE_ASPECT_BALANCED = r102;
            $VALUES = new ScalingType[]{r100, r101, r102};
        }

        public static ScalingType[] values() {
            return (ScalingType[]) $VALUES.clone();
        }

        public static ScalingType valueOf(String r100) {
            return (ScalingType) r27.a.a(ScalingType.class, r100);
        }

        private ScalingType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class VideoLayoutMeasure {
        private ScalingType scalingTypeMatchOrientation;
        private ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType r100 = ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = r100;
            this.scalingTypeMismatchOrientation = r100;
        }

        public void setScalingType(ScalingType r100) {
            this.scalingTypeMatchOrientation = r100;
            this.scalingTypeMismatchOrientation = r100;
        }

        public void setScalingType(ScalingType r100, ScalingType r101) {
            this.scalingTypeMatchOrientation = r100;
            this.scalingTypeMismatchOrientation = r101;
        }

        public Point measure(int r100, int r101, int r102, int r110) {
            int r103 = View.getDefaultSize(Integer.MAX_VALUE, r100);
            int r104 = View.getDefaultSize(Integer.MAX_VALUE, r101);
            if (r102 == 0) goto L27;
            if (r110 == 0) goto L27;
            if (r103 == 0) goto L27;
            if (r104 == 0) goto L27;
            float r105 = r102 / r110;
            float r111 = r103 / r104;
            boolean r106 = true;
            if (r105 <= 1.0f) goto L11;
            boolean r107 = true;
        L13:
            if (r111 > 1.0f) goto L16;
            r106 = false;
        L16:
            if (r107 != r106) goto L18;
            ScalingType r112 = this.scalingTypeMatchOrientation;
        L19:
            Point r108 = RendererCommon.getDisplaySize(r112, r105, r103, r104);
            if (View.MeasureSpec.getMode(r100) != 1073741824) goto L23;
            r108.x = r103;
        L23:
            if (View.MeasureSpec.getMode(r101) != 1073741824) goto L25;
            r108.y = r104;
        L25:
            return r108;
        L18:
            r112 = this.scalingTypeMismatchOrientation;
            goto L19
        L11:
            r107 = false;
        L27:
            return new Point(r103, r104);
        }
    }

    public RendererCommon() {
    }

    private static void adjustOrigin(float[] r100) {
        float r101 = r100[12] - ((r100[0] + r100[4]) * 0.5f);
        r100[12] = r101;
        float r102 = r100[13] - ((r100[1] + r100[5]) * 0.5f);
        r100[13] = r102;
        r100[12] = r101 + 0.5f;
        r100[13] = r102 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix r100) {
        float[] r101 = new float[9];
        r100.getValues(r101);
        return new float[]{r101[0], r101[3], 0.0f, r101[6], r101[1], r101[4], 0.0f, r101[7], 0.0f, 0.0f, 1.0f, 0.0f, r101[2], r101[5], 0.0f, r101[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] r100) {
        float[] r101 = {r100[0], r100[4], r100[12], r100[1], r100[5], r100[13], r100[3], r100[7], r100[15]};
        Matrix r102 = new Matrix();
        r102.setValues(r101);
        return r102;
    }

    private static float convertScalingTypeToVisibleFraction(ScalingType r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$bytedance$realx$video$RendererCommon$ScalingType[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 1.0f;
    L5:
        if (r101 != 2) goto L7;
        return 0.0f;
    L7:
        if (r101 != 3) goto L11;
        return BALANCED_VISIBLE_FRACTION;
    L11:
        throw new IllegalArgumentException();
    }

    public static float[] getLayoutMatrix(boolean r100, float r101, float r102) {
        if (r102 <= r101) goto L5;
        float r103 = r101 / r102;
        float r104 = 1.0f;
    L6:
        if (r100 == false) goto L8;
        r104 = r104 * (-1.0f);
    L8:
        float[] r105 = new float[16];
        android.opengl.Matrix.setIdentityM(r105, 0);
        android.opengl.Matrix.scaleM(r105, 0, r104, r103, 1.0f);
        adjustOrigin(r105);
        return r105;
    L5:
        r104 = r102 / r101;
        r103 = 1.0f;
        goto L6
    }

    private static Point getDisplaySize(float r100, float r101, int r102, int r103) {
        if (r100 == 0.0f) goto L10;
        if (r101 == 0.0f) goto L10;
        return new Point(Math.min(r102, Math.round((r103 / r100) * r101)), Math.min(r103, Math.round((r102 / r100) / r101)));
    L10:
        return new Point(r102, r103);
    }

    public static Point getDisplaySize(ScalingType r100, float r101, int r102, int r103) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(r100), r101, r102, r103);
    }
}
