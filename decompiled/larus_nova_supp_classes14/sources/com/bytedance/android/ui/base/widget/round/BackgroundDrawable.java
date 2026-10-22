package com.bytedance.android.ui.base.widget.round;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020\u0007H\u0002J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010(\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020\u0019J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\"\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020/H\u0002J\b\u00104\u001a\u00020/H\u0002J\b\u00105\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\u000eJ\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010<\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u0010\u0010>\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/bytedance/android/ui/base/widget/round/BackgroundDrawable;", "Landroid/graphics/drawable/StateListDrawable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "immediately", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "background", "Landroid/graphics/drawable/GradientDrawable;", "backgroundChecked", "backgroundPressed", "bgCheckedColor", "", "bgCheckedEndColor", "bgCheckedStartColor", "bgColor", "bgEndColor", "bgPressColor", "bgPressEndColor", "bgPressStartColor", "bgStartColor", "colorOrientation", "cornerRadius", "", "cornerRadiusBL", "cornerRadiusBR", "cornerRadiusTL", "cornerRadiusTR", "isBackgroundAdded", "isCheckedBackgroundAdded", "isPressedBackgroundAdded", "strokeCheckedColor", "strokeColor", "strokePressColor", "strokeWidth", "allRadiusIsEqual", "getCornerRadius", "getCornerRadiusBL", "getCornerRadiusBR", "getCornerRadiusTL", "getCornerRadiusTR", "getOrientationEnum", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "hasRadius", "initAttributes", "", "invalidate", "isBgColorValid", "makeBackgroundDrawable", "makeCheckedBackgroundDrawable", "makeDrawable", "makePressedBackgroundDrawable", "setBgColor", "color", "setCornerRadius", "radius", "setCornerRadiusBL", "setCornerRadiusBR", "setCornerRadiusTL", "setCornerRadiusTR", "setStrokeColor", "setStrokeWidth", "width", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundDrawable extends StateListDrawable {
    private final GradientDrawable background;
    private final GradientDrawable backgroundChecked;
    private final GradientDrawable backgroundPressed;
    private int bgCheckedColor;
    private int bgCheckedEndColor;
    private int bgCheckedStartColor;
    private int bgColor;
    private int bgEndColor;
    private int bgPressColor;
    private int bgPressEndColor;
    private int bgPressStartColor;
    private int bgStartColor;
    private int colorOrientation;
    private float cornerRadius;
    private float cornerRadiusBL;
    private float cornerRadiusBR;
    private float cornerRadiusTL;
    private float cornerRadiusTR;
    private boolean isBackgroundAdded;
    private boolean isCheckedBackgroundAdded;
    private boolean isPressedBackgroundAdded;
    private int strokeCheckedColor;
    private int strokeColor;
    private int strokePressColor;
    private int strokeWidth;

    private final boolean allRadiusIsEqual() {
        float r0 = this.cornerRadiusTL;
        if (r0 == this.cornerRadiusTR) goto L5;
    L9:
        return false;
    L5:
        if (r0 != this.cornerRadiusBR) goto L9;
        if (r0 != this.cornerRadiusBL) goto L9;
        return true;
    }

    private final GradientDrawable.Orientation getOrientationEnum() {
        int r0 = this.colorOrientation;
        if (r0 == 1) goto L18;
        if (r0 == 3) goto L23;
        if (r0 == 4) goto L22;
        if (r0 == 5) goto L21;
        if (r0 == 6) goto L20;
        return GradientDrawable.Orientation.TOP_BOTTOM;
    L20:
        return GradientDrawable.Orientation.BL_TR;
    L21:
        return GradientDrawable.Orientation.TR_BL;
    L22:
        return GradientDrawable.Orientation.BR_TL;
    L23:
        return GradientDrawable.Orientation.TL_BR;
    L18:
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }

    private final boolean hasRadius() {
        float r2 = 0;
        if (this.cornerRadiusTL <= r2) goto L5;
    L10:
        return true;
    L5:
        if (this.cornerRadiusTR > r2) goto L10;
        if (this.cornerRadiusBR > r2) goto L10;
        if (this.cornerRadiusBL > r2) goto L10;
        return false;
    }

    private final boolean isBgColorValid() {
        if (this.bgStartColor != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.bgEndColor == 0) goto L7;
        return true;
    }

    private final void makeBackgroundDrawable() {
        if (isBgColorValid() == false) goto L19;
        this.background.setColors(new int[]{this.bgStartColor, this.bgEndColor});
        this.background.setOrientation(getOrientationEnum());
        if (hasRadius() == true) goto L7;
    L10:
        int r0 = this.strokeWidth;
        if (r0 < 0) goto L16;
        int r2 = this.strokeColor;
        if (r2 == 0) goto L16;
        this.background.setStroke(r0, r2);
    L16:
        if (this.isBackgroundAdded == true) goto L20;
        this.isBackgroundAdded = true;
        addState(new int[]{-16842919, -16842912}, this.background);
        return;
    L20:
        return;
    L7:
        if (allRadiusIsEqual() == false) goto L9;
        this.background.setCornerRadius(this.cornerRadiusTL);
        goto L10
    L9:
        GradientDrawable r1 = this.background;
        float r3 = this.cornerRadiusTL;
        float r4 = this.cornerRadiusTR;
        float r5 = this.cornerRadiusBR;
        float r6 = this.cornerRadiusBL;
        r1.setCornerRadii(new float[]{r3, r3, r4, r4, r5, r5, r6, r6});
        goto L10
    }

    private final void makeCheckedBackgroundDrawable() {
        if (isBgColorValid() == true) goto L5;
        return;
    L5:
        int r0 = this.bgCheckedStartColor;
        if (r0 == 0) goto L10;
        if (this.bgCheckedEndColor == 0) goto L10;
    L11:
        GradientDrawable r1 = this.backgroundChecked;
        int[] r3 = new int[2];
        if (r0 != 0) goto L14;
        r0 = this.bgStartColor;
    L14:
        r3[0] = r0;
        int r2 = this.bgCheckedEndColor;
        if (r2 != 0) goto L17;
        r2 = this.bgEndColor;
    L17:
        r3[1] = r2;
        r1.setColors(r3);
        this.backgroundChecked.setOrientation(getOrientationEnum());
        if (hasRadius() == true) goto L20;
    L23:
        int r4 = this.strokeCheckedColor;
        if (r4 != 0) goto L26;
        r4 = this.strokeColor;
    L26:
        int r5 = this.strokeWidth;
        if (r5 < 0) goto L31;
        if (r4 == 0) goto L31;
        this.backgroundChecked.setStroke(r5, r4);
    L31:
        if (this.isCheckedBackgroundAdded == true) goto L35;
        this.isCheckedBackgroundAdded = true;
        addState(new int[]{R.attr.state_checked}, this.backgroundChecked);
        return;
    L35:
        return;
    L20:
        if (allRadiusIsEqual() == false) goto L22;
        this.backgroundChecked.setCornerRadius(this.cornerRadiusTL);
        goto L23
    L22:
        GradientDrawable r6 = this.backgroundChecked;
        float r7 = this.cornerRadiusTL;
        float r8 = this.cornerRadiusTR;
        float r9 = this.cornerRadiusBR;
        float r10 = this.cornerRadiusBL;
        r6.setCornerRadii(new float[]{r7, r7, r8, r8, r9, r9, r10, r10});
    L10:
        if (this.strokeCheckedColor != 0) goto L11;
    }

    private final void makeDrawable() {
        makeBackgroundDrawable();
        makePressedBackgroundDrawable();
        makeCheckedBackgroundDrawable();
    }

    private final void makePressedBackgroundDrawable() {
        if (isBgColorValid() == true) goto L5;
        return;
    L5:
        int r0 = this.bgPressStartColor;
        if (r0 == 0) goto L10;
        if (this.bgPressEndColor == 0) goto L10;
    L11:
        GradientDrawable r1 = this.backgroundPressed;
        int[] r3 = new int[2];
        if (r0 != 0) goto L14;
        r0 = this.bgStartColor;
    L14:
        r3[0] = r0;
        int r2 = this.bgPressEndColor;
        if (r2 != 0) goto L17;
        r2 = this.bgEndColor;
    L17:
        r3[1] = r2;
        r1.setColors(r3);
        this.backgroundPressed.setOrientation(getOrientationEnum());
        if (hasRadius() == true) goto L20;
    L23:
        int r4 = this.strokePressColor;
        if (r4 != 0) goto L26;
        r4 = this.strokeColor;
    L26:
        int r5 = this.strokeWidth;
        if (r5 < 0) goto L31;
        if (r4 == 0) goto L31;
        this.backgroundPressed.setStroke(r5, r4);
    L31:
        if (this.isPressedBackgroundAdded == true) goto L35;
        this.isPressedBackgroundAdded = true;
        addState(new int[]{R.attr.state_pressed}, this.backgroundPressed);
        return;
    L35:
        return;
    L20:
        if (allRadiusIsEqual() == false) goto L22;
        this.backgroundPressed.setCornerRadius(this.cornerRadiusTL);
        goto L23
    L22:
        GradientDrawable r6 = this.backgroundPressed;
        float r7 = this.cornerRadiusTL;
        float r8 = this.cornerRadiusTR;
        float r9 = this.cornerRadiusBR;
        float r10 = this.cornerRadiusBL;
        r6.setCornerRadii(new float[]{r7, r7, r8, r8, r9, r9, r10, r10});
    L10:
        if (this.strokePressColor != 0) goto L11;
    }

    public final void invalidate() {
        makeDrawable();
        invalidateSelf();
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCornerRadiusBL() {
        return this.cornerRadiusBL;
    }

    public final float getCornerRadiusBR() {
        return this.cornerRadiusBR;
    }

    public final float getCornerRadiusTL() {
        return this.cornerRadiusTL;
    }

    public final float getCornerRadiusTR() {
        return this.cornerRadiusTR;
    }

    public final BackgroundDrawable setBgColor(int r1) {
        this.bgColor = r1;
        this.bgStartColor = r1;
        this.bgEndColor = r1;
        return this;
    }

    public final BackgroundDrawable setCornerRadius(float r1) {
        this.cornerRadius = r1;
        this.cornerRadiusTL = r1;
        this.cornerRadiusTR = r1;
        this.cornerRadiusBL = r1;
        this.cornerRadiusBR = r1;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusBL(float r1) {
        this.cornerRadiusBL = r1;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusBR(float r1) {
        this.cornerRadiusBR = r1;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusTL(float r1) {
        this.cornerRadiusTL = r1;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusTR(float r1) {
        this.cornerRadiusTR = r1;
        return this;
    }

    public final BackgroundDrawable setStrokeColor(int r1) {
        this.strokeColor = r1;
        return this;
    }

    public final BackgroundDrawable setStrokeWidth(int r1) {
        this.strokeWidth = r1;
        return this;
    }

    public BackgroundDrawable(Context r2, AttributeSet r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.background = new GradientDrawable();
        this.backgroundPressed = new GradientDrawable();
        this.backgroundChecked = new GradientDrawable();
        this.colorOrientation = 2;
        float r0 = this.cornerRadius;
        this.cornerRadiusTL = r0;
        this.cornerRadiusTR = r0;
        this.cornerRadiusBL = r0;
        this.cornerRadiusBR = r0;
        this.strokeWidth = -1;
        initAttributes(r2, r3, r4);
    }

    private final void initAttributes(Context r2, AttributeSet r3, boolean r4) {
        if (r3 == null) goto L7;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130969003, 2130969004, 2130969005, 2130969006, 2130969007, 2130969008, 2130969009, 2130969010, 2130969011, 2130969012, 2130969013, 2130969015, 2130969016, 2130969017, 2130969018, 2130969019, 2130969020, 2130969021, 2130969022});
        int r6 = r5.getColor(3, this.bgColor);
        this.bgColor = r6;
        this.bgStartColor = r5.getColor(14, r6);
        this.bgEndColor = r5.getColor(10, this.bgColor);
        int r7 = r5.getColor(11, this.bgPressColor);
        this.bgPressColor = r7;
        this.bgPressStartColor = r5.getColor(13, r7);
        this.bgPressEndColor = r5.getColor(12, this.bgPressColor);
        int r8 = r5.getColor(0, this.bgCheckedColor);
        this.bgCheckedColor = r8;
        this.bgCheckedStartColor = r5.getColor(2, r8);
        this.bgCheckedEndColor = r5.getColor(1, this.bgCheckedColor);
        this.strokeColor = r5.getColor(16, this.strokeColor);
        this.strokePressColor = r5.getColor(17, this.strokePressColor);
        this.strokeCheckedColor = r5.getColor(15, this.strokeCheckedColor);
        this.colorOrientation = r5.getInt(4, this.colorOrientation);
        this.strokeWidth = r5.getDimensionPixelSize(18, this.strokeWidth);
        float r9 = r5.getDimension(5, this.cornerRadius);
        this.cornerRadius = r9;
        this.cornerRadiusTL = r5.getDimension(8, r9);
        this.cornerRadiusTR = r5.getDimension(9, this.cornerRadius);
        this.cornerRadiusBL = r5.getDimension(6, this.cornerRadius);
        this.cornerRadiusBR = r5.getDimension(7, this.cornerRadius);
        r5.recycle();
        if (r4 == false) goto L8;
        makeDrawable();
        return;
    L8:
        return;
    }

    public /* synthetic */ BackgroundDrawable(Context r1, AttributeSet r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        this(r1, r2, r3);
    }
}
