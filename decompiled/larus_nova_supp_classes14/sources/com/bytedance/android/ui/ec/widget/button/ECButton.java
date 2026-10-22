package com.bytedance.android.ui.ec.widget.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.bytedance.android.ui.base.widget.drawable.RotatingDrawable;
import com.bytedance.android.ui.base.widget.icon.IconExtKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0014J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020\u0014J\b\u0010'\u001a\u00020!H\u0016J\u0018\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020!H\u0002J\u0012\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u00105\u001a\u00020!H\u0007J\u0010\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0012H\u0014J\u0010\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u0012H\u0002R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/button/ECButton;", "Lcom/bytedance/android/ui/base/widget/button/CornersButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disabledAlpha", "", "Ljava/lang/Float;", "enabledAlpha", "foregroundColor", "Landroid/content/res/ColorStateList;", "foregroundColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "foregroundDrawable", "Landroid/graphics/drawable/Drawable;", "hasAdjust", "", "getHasAdjust", "()Z", "setHasAdjust", "(Z)V", "iconLoadingColorStateList", "iconLoadingSize", "tempDrawableEnd", "tempDrawablePadding", "tempDrawableStart", "tempText", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawableStateChanged", "endLoading", "isLoadingAnimating", "jumpDrawablesToCurrentState", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setEnabled", "enabled", "setForegroundColor", "setForegroundDrawable", "drawable", "startLoading", "verifyDrawable", "who", "wrapDrawableWithInset", "Landroid/graphics/drawable/InsetDrawable;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECButton extends CornersButton {
    private Float disabledAlpha;
    private Float enabledAlpha;
    private ColorStateList foregroundColor;
    private GradientDrawable foregroundColorDrawable;
    private Drawable foregroundDrawable;
    private boolean hasAdjust;
    private ColorStateList iconLoadingColorStateList;
    private int iconLoadingSize;
    private Drawable tempDrawableEnd;
    private int tempDrawablePadding;
    private Drawable tempDrawableStart;
    private CharSequence tempText;

    public ECButton(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECButton(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void endLoading() {
        setClickable(true);
        Drawable r0 = getCompoundDrawables()[0];
        if (isLoadingAnimating() == false) goto L9;
        setCompoundDrawables(this.tempDrawableStart, null, this.tempDrawableEnd, null);
        if ((r0 instanceof RotatingDrawable) == false) goto L7;
        ((RotatingDrawable) r0).stop();
    L7:
        setText(this.tempText);
        this.tempText = "";
        setCompoundDrawablePadding(this.tempDrawablePadding);
        this.tempDrawableEnd = null;
        this.tempDrawableStart = null;
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setForegroundColor() {
        if (this.foregroundColor == null) goto L12;
        GradientDrawable r0 = new GradientDrawable();
        Drawable r1 = getBackground();
        if ((r1 instanceof BackgroundDrawable) == true) goto L7;
        r1 = null;
    L7:
        BackgroundDrawable r2 = (BackgroundDrawable) r1;
        if (r2 == null) goto L10;
        r0.setCornerRadius(r2.getCornerRadius());
    L10:
        DrawableCompat.setTintList(r0, this.foregroundColor);
        setForegroundDrawable(wrapDrawableWithInset(r0));
        Unit r3 = Unit.INSTANCE;
        this.foregroundColorDrawable = r0;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ui.base.widget.icon.IconTextView
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.foregroundDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() != true) goto L11;
        Drawable r1 = this.foregroundDrawable;
        if (r1 == null) goto L12;
        r1.setState(getDrawableState());
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLoadingAnimating() {
        Drawable r0 = getCompoundDrawables()[0];
        if ((r0 instanceof RotatingDrawable) == true) goto L5;
        return false;
    L5:
        return ((RotatingDrawable) r0).isRunning();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jumpDrawablesToCurrentState() {
        super/*android.widget.TextView*/.jumpDrawablesToCurrentState();
        Drawable r0 = this.foregroundDrawable;
        if (r0 == null) goto L6;
        r0.jumpToCurrentState();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startLoading() {
        if (isLoadingAnimating() == false) goto L5;
        return;
    L5:
        setClickable(false);
        Drawable[] r1 = getCompoundDrawables();
        Drawable r2 = r1[0];
        Drawable r3 = r1[2];
        this.tempDrawableStart = r2;
        this.tempDrawableEnd = r3;
        RotatingDrawable r4 = new RotatingDrawable(ContextCompat.getDrawable(getContext(), 2131234502));
        ColorStateList r5 = this.iconLoadingColorStateList;
        if (r5 == null) goto L8;
        r4.setColorFilter(new PorterDuffColorFilter(r5.getColorForState(getDrawableState(), -16777216), PorterDuff.Mode.SRC_IN));
    L8:
        IconExtKt.setDrawableSize(r4, this.iconLoadingSize);
        r4.start();
        this.tempText = getText();
        this.tempDrawablePadding = getCompoundDrawablePadding();
        setCompoundDrawablePadding(0);
        setText("");
        setCompoundDrawables(r4, null, null, null);
    }

    public final boolean getHasAdjust() {
        return this.hasAdjust;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setForegroundDrawable(Drawable r3) {
        if (Intrinsics.areEqual(this.foregroundDrawable, r3) == false) goto L5;
        return;
    L5:
        Drawable r0 = this.foregroundDrawable;
        if (r0 == null) goto L8;
        r0.setCallback(null);
        unscheduleDrawable(r0);
    L8:
        this.foregroundDrawable = r3;
        if (r3 == null) goto L13;
        r3.setCallback(this);
        if (r3.isStateful() == false) goto L13;
        r3.setState(getDrawableState());
    L13:
        requestLayout();
        invalidate();
    }

    private final InsetDrawable wrapDrawableWithInset(Drawable r8) {
        return new InsetDrawable(r8, 0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Drawable[] r0 = getCompoundDrawables();
        Drawable r1 = r0[0];
        Drawable r2 = r0[2];
        if (r1 == null) goto L10;
        if (r2 != null) goto L10;
        float r3 = (getWidth() - ((getPaint().measureText(getText().toString()) + getCompoundDrawablePadding()) + r1.getBounds().width())) / 2;
        this.hasAdjust = true;
        int r4 = (int) r3;
        if (getPaddingLeft() == r4) goto L8;
    L9:
        setPadding(r4, getPaddingTop(), r4, getPaddingBottom());
    L24:
        super/*android.widget.TextView*/.draw(r7);
        Drawable r5 = this.foregroundDrawable;
        if (r5 == null) goto L28;
        r5.draw(r7);
        return;
    L28:
        return;
    L8:
        if (getPaddingRight() == r4) goto L24;
    L10:
        if (r1 != null) goto L17;
        if (r2 == null) goto L17;
        float r6 = (getWidth() - ((getPaint().measureText(getText().toString()) + getCompoundDrawablePadding()) + r2.getBounds().width())) / 2;
        this.hasAdjust = true;
        int r8 = (int) r6;
        if (getPaddingLeft() == r8) goto L15;
    L16:
        setPadding(r8, getPaddingTop(), r8, getPaddingBottom());
        goto L24
    L15:
        if (getPaddingRight() == r8) goto L24;
    L17:
        if (r1 == null) goto L24;
        if (r2 == null) goto L24;
        float r9 = getPaint().measureText(getText().toString());
        int r10 = getCompoundDrawablePadding();
        float r11 = (getMeasuredWidth() - (((r9 + (r10 * 2)) + r1.getBounds().width()) + r2.getBounds().width())) / 2;
        this.hasAdjust = true;
        int r12 = (int) r11;
        if (getPaddingLeft() == r12) goto L22;
    L23:
        setPadding(r12, getPaddingTop(), r12, getPaddingBottom());
        goto L24
    L22:
        if (getPaddingRight() == r12) goto L24;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r1) {
        super/*android.widget.TextView*/.setEnabled(r1);
        if (r1 == false) goto L7;
        Float r2 = this.enabledAlpha;
        if (r2 == null) goto L11;
        setAlpha(r2.floatValue());
        return;
    L11:
        return;
    L7:
        Float r3 = this.disabledAlpha;
        if (r3 == null) goto L13;
        setAlpha(r3.floatValue());
        return;
    }

    public final void setHasAdjust(boolean r1) {
        this.hasAdjust = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super/*android.widget.TextView*/.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, this.foregroundDrawable) == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        Drawable r5 = this.foregroundDrawable;
        if (r5 == null) goto L6;
        r5.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        invalidate();
        return;
    }

    public ECButton(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.tempText = "";
        if (r4 == null) goto L14;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{R.attr.enabled, R.attr.foreground, 2130970141, 2130970305, 2130970306, 2130974256, 2130974260});
        this.foregroundColor = r6.getColorStateList(2);
        Drawable r7 = r6.getDrawable(1);
        if (r6.hasValue(6) == false) goto L8;
        this.enabledAlpha = Float.valueOf(r6.getFloat(6, 1.0f));
    L8:
        if (r6.hasValue(5) == false) goto L10;
        this.disabledAlpha = Float.valueOf(r6.getFloat(5, 0.34f));
    L10:
        this.iconLoadingSize = r6.getDimensionPixelSize(4, 0);
        this.iconLoadingColorStateList = r6.getColorStateList(3);
        setEnabled(r6.getBoolean(0, true));
        r6.recycle();
        if (r7 != null) goto L15;
        setForegroundColor();
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        Drawable r5 = this.foregroundDrawable;
        if (r5 == null) goto L6;
        r5.setBounds(0, 0, r1, r2);
        invalidate();
        return;
    }

    public /* synthetic */ ECButton(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
