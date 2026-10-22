package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    private int mBorderColor;
    private final Path mBorderPath;
    final float[] mBorderRadii;
    private float mBorderWidth;
    private final RectF mBounds;

    @Nullable
    private RectF mInsideBorderBounds;

    @Nullable
    private Matrix mInsideBorderTransform;
    private boolean mIsCircle;
    private int mOverlayColor;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    private final float[] mRadii;
    private boolean mScaleDownInsideBorders;
    private final RectF mTempRectangle;
    Type mType;

    /* JADX INFO: renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = null;

        static {
            int[] r100 = new int[Type.values().length];
            $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = r100;
            r100[Type.CLIPPING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[Type.OVERLAY_COLOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CLIPPING = null;
        public static final Type OVERLAY_COLOR = null;

        static {
            Type r100 = new Type("OVERLAY_COLOR", 0);
            OVERLAY_COLOR = r100;
            Type r101 = new Type("CLIPPING", 1);
            CLIPPING = r101;
            $VALUES = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) Enum.valueOf(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    private void updatePath() {
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRectangle.set(getBounds());
        RectF r100 = this.mTempRectangle;
        float r101 = this.mPadding;
        r100.inset(r101, r101);
        this.mPath.addRect(this.mTempRectangle, Path.Direction.CW);
        if (this.mIsCircle == false) goto L5;
        this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Path.Direction.CW);
    L6:
        RectF r102 = this.mTempRectangle;
        float r103 = this.mPadding;
        r102.inset(-r103, -r103);
        RectF r104 = this.mTempRectangle;
        float r105 = this.mBorderWidth;
        r104.inset(r105 / 2.0f, r105 / 2.0f);
        if (this.mIsCircle == false) goto L9;
        float r106 = Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f;
        this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), r106, Path.Direction.CW);
    L14:
        RectF r107 = this.mTempRectangle;
        float r108 = this.mBorderWidth;
        r107.inset((-r108) / 2.0f, (-r108) / 2.0f);
        return;
    L9:
        int r109 = 0;
    L10:
        float[] r110 = this.mBorderRadii;
        if (r109 >= r110.length) goto L13;
        r110[r109] = (this.mRadii[r109] + this.mPadding) - (this.mBorderWidth / 2.0f);
        r109 = r109 + 1;
        goto L10
    L13:
        this.mBorderPath.addRoundRect(this.mTempRectangle, r110, Path.Direction.CW);
        goto L14
    L5:
        this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
        goto L6
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.mRadii;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    public RoundedCornersDrawable(Drawable r100) {
        super((Drawable) Preconditions.checkNotNull(r100));
        this.mType = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mOverlayColor = 0;
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mTempRectangle = new RectF();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        this.mBounds.set(getBounds());
        int r100 = AnonymousClass1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()];
        if (r100 != 1) goto L5;
        int r101 = r110.save();
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        r110.clipPath(this.mPath);
        super.draw(r110);
        r110.restoreToCount(r101);
    L25:
        if (this.mBorderColor == 0) goto L28;
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mBorderColor);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        r110.drawPath(this.mBorderPath, this.mPaint);
        return;
    L28:
        return;
    L5:
        if (r100 != 2) goto L25;
        if (this.mScaleDownInsideBorders == false) goto L14;
        RectF r102 = this.mInsideBorderBounds;
        if (r102 != null) goto L12;
        this.mInsideBorderBounds = new RectF(this.mBounds);
        this.mInsideBorderTransform = new Matrix();
    L13:
        RectF r103 = this.mInsideBorderBounds;
        float r104 = this.mBorderWidth;
        r103.inset(r104, r104);
        this.mInsideBorderTransform.setRectToRect(this.mBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
        int r105 = r110.save();
        r110.clipRect(this.mBounds);
        r110.concat(this.mInsideBorderTransform);
        super.draw(r110);
        r110.restoreToCount(r105);
    L15:
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mOverlayColor);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        r110.drawPath(this.mPath, this.mPaint);
        if (this.mIsCircle == false) goto L25;
        float r106 = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
        float r107 = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
        if (r106 <= 0.0f) goto L21;
        RectF r108 = this.mBounds;
        float r109 = r108.left;
        r110.drawRect(r109, r108.top, r109 + r106, r108.bottom, this.mPaint);
        RectF r111 = this.mBounds;
        float r112 = r111.right;
        r110.drawRect(r112 - r106, r111.top, r112, r111.bottom, this.mPaint);
    L21:
        if (r107 <= 0.0f) goto L25;
        RectF r113 = this.mBounds;
        float r114 = r113.left;
        float r115 = r113.top;
        r110.drawRect(r114, r115, r113.right, r115 + r107, this.mPaint);
        RectF r116 = this.mBounds;
        float r117 = r116.left;
        float r118 = r116.bottom;
        r110.drawRect(r117, r118 - r107, r116.right, r118, this.mPaint);
        goto L25
    L12:
        r102.set(this.mBounds);
        goto L13
    L14:
        super.draw(r110);
        goto L15
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        updatePath();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean r100) {
        this.mIsCircle = r100;
        updatePath();
        invalidateSelf();
    }

    public void setOverlayColor(int r100) {
        this.mOverlayColor = r100;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float r100) {
        this.mPadding = r100;
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] r100) {
        if (r100 != null) goto L5;
        Arrays.fill(this.mRadii, 0.0f);
    L9:
        updatePath();
        invalidateSelf();
        return;
    L5:
        if (r100.length != 8) goto L7;
        boolean r101 = true;
    L8:
        Preconditions.checkArgument(r101, "radii should have exactly 8 values");
        System.arraycopy(r100, 0, this.mRadii, 0, 8);
        goto L9
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float r100) {
        Arrays.fill(this.mRadii, r100);
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean r100) {
        this.mScaleDownInsideBorders = r100;
        updatePath();
        invalidateSelf();
    }

    public void setType(Type r100) {
        this.mType = r100;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int r100, float r101) {
        this.mBorderColor = r100;
        this.mBorderWidth = r101;
        updatePath();
        invalidateSelf();
    }
}
