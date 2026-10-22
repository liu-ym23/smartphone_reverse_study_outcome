package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RoundingParams {
    private int mBorderColor;
    private float mBorderWidth;
    private float[] mCornersRadii;
    private int mOverlayColor;
    private float mPadding;
    private boolean mRoundAsCircle;
    private RoundingMethod mRoundingMethod;
    private boolean mScaleDownInsideBorders;

    public static final enum RoundingMethod extends Enum<RoundingMethod> {
        private static final /* synthetic */ RoundingMethod[] $VALUES = null;
        public static final RoundingMethod BITMAP_ONLY = null;
        public static final RoundingMethod OVERLAY_COLOR = null;

        static {
            RoundingMethod r100 = new RoundingMethod("OVERLAY_COLOR", 0);
            OVERLAY_COLOR = r100;
            RoundingMethod r101 = new RoundingMethod("BITMAP_ONLY", 1);
            BITMAP_ONLY = r101;
            $VALUES = new RoundingMethod[]{r100, r101};
        }

        public static RoundingMethod[] values() {
            return (RoundingMethod[]) $VALUES.clone();
        }

        public static RoundingMethod valueOf(String r100) {
            return (RoundingMethod) Enum.valueOf(RoundingMethod.class, r100);
        }

        private RoundingMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static RoundingParams asCircle() {
        return new RoundingParams().setRoundAsCircle(true);
    }

    private float[] getOrCreateRoundedCornersRadii() {
        if (this.mCornersRadii != null) goto L6;
        this.mCornersRadii = new float[8];
    L6:
        return this.mCornersRadii;
    }

    public int hashCode() {
        RoundingMethod r100 = this.mRoundingMethod;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
        float[] r104 = this.mCornersRadii;
        if (r104 == null) goto L9;
        int r105 = Arrays.hashCode(r104);
    L10:
        int r106 = (((r103 + r105) * 31) + this.mOverlayColor) * 31;
        float r107 = this.mBorderWidth;
        if (r107 == 0.0f) goto L13;
        int r108 = Float.floatToIntBits(r107);
    L14:
        int r109 = (((r106 + r108) * 31) + this.mBorderColor) * 31;
        float r110 = this.mPadding;
        if (r110 == 0.0f) goto L18;
        r101 = Float.floatToIntBits(r110);
    L18:
        return ((r109 + r101) * 31) + (this.mScaleDownInsideBorders ? 1 : 0);
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public RoundingParams() {
        this.mRoundingMethod = RoundingMethod.BITMAP_ONLY;
        this.mRoundAsCircle = false;
        this.mCornersRadii = null;
        this.mOverlayColor = 0;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public float[] getCornersRadii() {
        return this.mCornersRadii;
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean getRoundAsCircle() {
        return this.mRoundAsCircle;
    }

    public RoundingMethod getRoundingMethod() {
        return this.mRoundingMethod;
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public static RoundingParams fromCornersRadii(float[] r100) {
        return new RoundingParams().setCornersRadii(r100);
    }

    public static RoundingParams fromCornersRadius(float r100) {
        return new RoundingParams().setCornersRadius(r100);
    }

    public boolean equals(@Nullable Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L33:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L33;
        RoundingParams r101 = (RoundingParams) r100;
        if (this.mRoundAsCircle == r101.mRoundAsCircle) goto L14;
        return false;
    L14:
        if (this.mOverlayColor == r101.mOverlayColor) goto L17;
        return false;
    L17:
        if (Float.compare(r101.mBorderWidth, this.mBorderWidth) == 0) goto L20;
        return false;
    L20:
        if (this.mBorderColor == r101.mBorderColor) goto L23;
        return false;
    L23:
        if (Float.compare(r101.mPadding, this.mPadding) == 0) goto L26;
        return false;
    L26:
        if (this.mRoundingMethod == r101.mRoundingMethod) goto L29;
        return false;
    L29:
        if (this.mScaleDownInsideBorders == r101.mScaleDownInsideBorders) goto L32;
        return false;
    L32:
        return Arrays.equals(this.mCornersRadii, r101.mCornersRadii);
    }

    public RoundingParams setBorderColor(int r100) {
        this.mBorderColor = r100;
        return this;
    }

    public RoundingParams setBorderWidth(float r100) {
        if (r100 < 0.0f) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "the border width cannot be < 0");
        this.mBorderWidth = r100;
        return this;
    L5:
        r101 = false;
        goto L6
    }

    public RoundingParams setCornersRadii(float[] r100) {
        Preconditions.checkNotNull(r100);
        if (r100.length != 8) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "radii should have exactly 8 values");
        System.arraycopy(r100, 0, getOrCreateRoundedCornersRadii(), 0, 8);
        return this;
    L5:
        r101 = false;
        goto L6
    }

    public RoundingParams setCornersRadius(float r100) {
        Arrays.fill(getOrCreateRoundedCornersRadii(), r100);
        return this;
    }

    public RoundingParams setOverlayColor(int r100) {
        this.mOverlayColor = r100;
        this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams setPadding(float r100) {
        if (r100 < 0.0f) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "the padding cannot be < 0");
        this.mPadding = r100;
        return this;
    L5:
        r101 = false;
        goto L6
    }

    public RoundingParams setRoundAsCircle(boolean r100) {
        this.mRoundAsCircle = r100;
        return this;
    }

    public RoundingParams setRoundingMethod(RoundingMethod r100) {
        this.mRoundingMethod = r100;
        return this;
    }

    public RoundingParams setScaleDownInsideBorders(boolean r100) {
        this.mScaleDownInsideBorders = r100;
        return this;
    }

    public RoundingParams setBorder(int r100, float r101) {
        if (r101 < 0.0f) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "the border width cannot be < 0");
        this.mBorderWidth = r101;
        this.mBorderColor = r100;
        return this;
    L5:
        r102 = false;
        goto L6
    }

    public static RoundingParams fromCornersRadii(float r100, float r101, float r102, float r103) {
        return new RoundingParams().setCornersRadii(r100, r101, r102, r103);
    }

    public RoundingParams setCornersRadii(float r100, float r101, float r102, float r103) {
        float[] r104 = getOrCreateRoundedCornersRadii();
        r104[1] = r100;
        r104[0] = r100;
        r104[3] = r101;
        r104[2] = r101;
        r104[5] = r102;
        r104[4] = r102;
        r104[7] = r103;
        r104[6] = r103;
        return this;
    }
}
