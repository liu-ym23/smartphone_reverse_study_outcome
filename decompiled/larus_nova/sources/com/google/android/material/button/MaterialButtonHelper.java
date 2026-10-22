package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

/* JADX INFO: loaded from: classes23.dex */
class MaterialButtonHelper {
    private static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5f;
    private static final int DEFAULT_BACKGROUND_COLOR = -1;
    private static final boolean IS_LOLLIPOP = false;
    private GradientDrawable backgroundDrawableLollipop;
    private boolean backgroundOverwritten;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private final Rect bounds;
    private final Paint buttonStrokePaint;
    private GradientDrawable colorableBackgroundDrawableCompat;
    private int cornerRadius;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private GradientDrawable maskDrawableLollipop;
    private final MaterialButton materialButton;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private GradientDrawable rippleDrawableCompat;
    private ColorStateList strokeColor;
    private GradientDrawable strokeDrawableLollipop;
    private int strokeWidth;
    private Drawable tintableBackgroundDrawableCompat;
    private Drawable tintableRippleDrawableCompat;

    static {
        IS_LOLLIPOP = true;
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    private Drawable createBackgroundCompat() {
        GradientDrawable r100 = new GradientDrawable();
        this.colorableBackgroundDrawableCompat = r100;
        r100.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.colorableBackgroundDrawableCompat.setColor(-1);
        Drawable r101 = DrawableCompat.wrap(this.colorableBackgroundDrawableCompat);
        this.tintableBackgroundDrawableCompat = r101;
        DrawableCompat.setTintList(r101, this.backgroundTint);
        PorterDuff.Mode r102 = this.backgroundTintMode;
        if (r102 == null) goto L5;
        DrawableCompat.setTintMode(this.tintableBackgroundDrawableCompat, r102);
    L5:
        GradientDrawable r103 = new GradientDrawable();
        this.rippleDrawableCompat = r103;
        r103.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.rippleDrawableCompat.setColor(-1);
        Drawable r104 = DrawableCompat.wrap(this.rippleDrawableCompat);
        this.tintableRippleDrawableCompat = r104;
        DrawableCompat.setTintList(r104, this.rippleColor);
        return wrapDrawableWithInset(new LayerDrawable(new Drawable[]{this.tintableBackgroundDrawableCompat, this.tintableRippleDrawableCompat}));
    }

    private Drawable createBackgroundLollipop() {
        GradientDrawable r100 = new GradientDrawable();
        this.backgroundDrawableLollipop = r100;
        r100.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.backgroundDrawableLollipop.setColor(-1);
        updateTintAndTintModeLollipop();
        GradientDrawable r101 = new GradientDrawable();
        this.strokeDrawableLollipop = r101;
        r101.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.strokeDrawableLollipop.setColor(0);
        this.strokeDrawableLollipop.setStroke(this.strokeWidth, this.strokeColor);
        InsetDrawable r102 = wrapDrawableWithInset(new LayerDrawable(new Drawable[]{this.backgroundDrawableLollipop, this.strokeDrawableLollipop}));
        GradientDrawable r103 = new GradientDrawable();
        this.maskDrawableLollipop = r103;
        r103.setCornerRadius(this.cornerRadius + CORNER_RADIUS_ADJUSTMENT);
        this.maskDrawableLollipop.setColor(-1);
        return new MaterialButtonBackgroundDrawable(RippleUtils.convertToRippleDrawableColor(this.rippleColor), r102, this.maskDrawableLollipop);
    }

    private GradientDrawable unwrapBackgroundDrawable() {
        if (IS_LOLLIPOP == true) goto L5;
        return null;
    L5:
        if (this.materialButton.getBackground() != null) goto L7;
        return null;
    L7:
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable unwrapStrokeDrawable() {
        if (IS_LOLLIPOP == true) goto L5;
        return null;
    L5:
        if (this.materialButton.getBackground() != null) goto L7;
        return null;
    L7:
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void updateStroke() {
        boolean r100 = IS_LOLLIPOP;
        if (r100 == true) goto L5;
    L7:
        if (r100 == true) goto L11;
        this.materialButton.invalidate();
        return;
    L11:
        return;
    L5:
        if (this.strokeDrawableLollipop == null) goto L7;
        this.materialButton.setInternalBackground(createBackgroundLollipop());
    }

    private void updateTintAndTintModeLollipop() {
        GradientDrawable r100 = this.backgroundDrawableLollipop;
        if (r100 == null) goto L8;
        DrawableCompat.setTintList(r100, this.backgroundTint);
        PorterDuff.Mode r101 = this.backgroundTintMode;
        if (r101 == null) goto L9;
        DrawableCompat.setTintMode(this.backgroundDrawableLollipop, r101);
        return;
    L9:
        return;
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public MaterialButtonHelper(MaterialButton r100) {
        this.buttonStrokePaint = new Paint(1);
        this.bounds = new Rect();
        this.rectF = new RectF();
        this.backgroundOverwritten = false;
        this.materialButton = r100;
    }

    private InsetDrawable wrapDrawableWithInset(Drawable r100) {
        return new InsetDrawable(r100, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    public void drawStroke(Canvas r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.strokeColor != null) goto L6;
        return;
    L6:
        if (this.strokeWidth <= 0) goto L11;
        this.bounds.set(this.materialButton.getBackground().getBounds());
        RectF r101 = this.rectF;
        Rect r102 = this.bounds;
        float r103 = r102.left;
        int r104 = this.strokeWidth;
        r101.set((r103 + (r104 / 2.0f)) + this.insetLeft, (r102.top + (r104 / 2.0f)) + this.insetTop, (r102.right - (r104 / 2.0f)) - this.insetRight, (r102.bottom - (r104 / 2.0f)) - this.insetBottom);
        float r105 = this.cornerRadius - (this.strokeWidth / 2.0f);
        r100.drawRoundRect(this.rectF, r105, r105, this.buttonStrokePaint);
        return;
    }

    public void loadFromAttributes(TypedArray r100) {
        int r101 = 0;
        this.insetLeft = r100.getDimensionPixelOffset(0, 0);
        this.insetRight = r100.getDimensionPixelOffset(1, 0);
        this.insetTop = r100.getDimensionPixelOffset(2, 0);
        this.insetBottom = r100.getDimensionPixelOffset(3, 0);
        this.cornerRadius = r100.getDimensionPixelSize(6, 0);
        this.strokeWidth = r100.getDimensionPixelSize(15, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(r100.getInt(5, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), r100, 4);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r100, 14);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r100, 13);
        this.buttonStrokePaint.setStyle(Paint.Style.STROKE);
        this.buttonStrokePaint.setStrokeWidth(this.strokeWidth);
        Paint r102 = this.buttonStrokePaint;
        ColorStateList r103 = this.strokeColor;
        if (r103 == null) goto L5;
        r101 = r103.getColorForState(this.materialButton.getDrawableState(), 0);
    L5:
        r102.setColor(r101);
        int r104 = ViewCompat.getPaddingStart(this.materialButton);
        int r105 = this.materialButton.getPaddingTop();
        int r106 = ViewCompat.getPaddingEnd(this.materialButton);
        int r107 = this.materialButton.getPaddingBottom();
        MaterialButton r108 = this.materialButton;
        if (IS_LOLLIPOP == false) goto L8;
        Drawable r109 = createBackgroundLollipop();
    L9:
        r108.setInternalBackground(r109);
        ViewCompat.setPaddingRelative(this.materialButton, r104 + this.insetLeft, r105 + this.insetTop, r106 + this.insetRight, r107 + this.insetBottom);
        return;
    L8:
        r109 = createBackgroundCompat();
        goto L9
    }

    public void setBackgroundColor(int r100) {
        boolean r101 = IS_LOLLIPOP;
        if (r101 == false) goto L7;
        GradientDrawable r102 = this.backgroundDrawableLollipop;
        if (r102 == null) goto L7;
        r102.setColor(r100);
        return;
    L7:
        if (r101 == true) goto L13;
        GradientDrawable r103 = this.colorableBackgroundDrawableCompat;
        if (r103 == null) goto L14;
        r103.setColor(r100);
        return;
    L14:
        return;
    }

    public void setCornerRadius(int r100) {
        if (this.cornerRadius == r100) goto L23;
        this.cornerRadius = r100;
        boolean r101 = IS_LOLLIPOP;
        if (r101 == true) goto L7;
    L16:
        if (r101 == true) goto L25;
        GradientDrawable r102 = this.colorableBackgroundDrawableCompat;
        if (r102 != null) goto L20;
        return;
    L20:
        if (this.rippleDrawableCompat == null) goto L27;
        float r103 = r100 + CORNER_RADIUS_ADJUSTMENT;
        r102.setCornerRadius(r103);
        this.rippleDrawableCompat.setCornerRadius(r103);
        this.materialButton.invalidate();
        return;
    L27:
        return;
    L25:
        return;
    L7:
        if (this.backgroundDrawableLollipop == null) goto L16;
        if (this.strokeDrawableLollipop == null) goto L16;
        if (this.maskDrawableLollipop == null) goto L16;
        if (Build.VERSION.SDK_INT != 21) goto L15;
        GradientDrawable r104 = unwrapBackgroundDrawable();
        float r105 = r100 + CORNER_RADIUS_ADJUSTMENT;
        r104.setCornerRadius(r105);
        unwrapStrokeDrawable().setCornerRadius(r105);
    L15:
        GradientDrawable r106 = this.backgroundDrawableLollipop;
        float r107 = r100 + CORNER_RADIUS_ADJUSTMENT;
        r106.setCornerRadius(r107);
        this.strokeDrawableLollipop.setCornerRadius(r107);
        this.maskDrawableLollipop.setCornerRadius(r107);
        return;
    }

    public void setRippleColor(ColorStateList r100) {
        if (this.rippleColor == r100) goto L14;
        this.rippleColor = r100;
        boolean r101 = IS_LOLLIPOP;
        if (r101 == true) goto L7;
    L9:
        if (r101 == true) goto L16;
        Drawable r102 = this.tintableRippleDrawableCompat;
        if (r102 == null) goto L17;
        DrawableCompat.setTintList(r102, r100);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if ((this.materialButton.getBackground() instanceof RippleDrawable) == false) goto L9;
        ((RippleDrawable) this.materialButton.getBackground()).setColor(r100);
        return;
    }

    public void setStrokeColor(ColorStateList r100) {
        if (this.strokeColor == r100) goto L9;
        this.strokeColor = r100;
        Paint r101 = this.buttonStrokePaint;
        int r102 = 0;
        if (r100 == null) goto L7;
        r102 = r100.getColorForState(this.materialButton.getDrawableState(), 0);
    L7:
        r101.setColor(r102);
        updateStroke();
        return;
    }

    public void setStrokeWidth(int r100) {
        if (this.strokeWidth == r100) goto L6;
        this.strokeWidth = r100;
        this.buttonStrokePaint.setStrokeWidth(r100);
        updateStroke();
        return;
    }

    public void setSupportBackgroundTintList(ColorStateList r100) {
        if (this.backgroundTint == r100) goto L11;
        this.backgroundTint = r100;
        if (IS_LOLLIPOP == false) goto L7;
        updateTintAndTintModeLollipop();
        return;
    L7:
        Drawable r101 = this.tintableBackgroundDrawableCompat;
        if (r101 == null) goto L13;
        DrawableCompat.setTintList(r101, r100);
        return;
    L13:
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        if (this.backgroundTintMode == r100) goto L12;
        this.backgroundTintMode = r100;
        if (IS_LOLLIPOP == false) goto L7;
        updateTintAndTintModeLollipop();
        return;
    L7:
        Drawable r101 = this.tintableBackgroundDrawableCompat;
        if (r101 == null) goto L14;
        if (r100 == null) goto L15;
        DrawableCompat.setTintMode(r101, r100);
        return;
    L15:
        return;
    L14:
        return;
    }

    public void updateMaskBounds(int r100, int r101) {
        GradientDrawable r102 = this.maskDrawableLollipop;
        if (r102 == null) goto L6;
        r102.setBounds(this.insetLeft, this.insetTop, r101 - this.insetRight, r100 - this.insetBottom);
        return;
    }
}
