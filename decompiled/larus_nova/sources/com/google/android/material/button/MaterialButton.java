package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
public class MaterialButton extends AppCompatButton {
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    private static final String LOG_TAG = "MaterialButton";
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private final MaterialButtonHelper materialButtonHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper r100 = this.materialButtonHelper;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isBackgroundOverwritten() == true) goto L7;
        return true;
    }

    private void updateIcon() {
        Drawable r100 = this.icon;
        if (r100 == null) goto L16;
        Drawable r101 = r100.mutate();
        this.icon = r101;
        DrawableCompat.setTintList(r101, this.iconTint);
        PorterDuff.Mode r102 = this.iconTintMode;
        if (r102 == null) goto L7;
        DrawableCompat.setTintMode(this.icon, r102);
    L7:
        int r103 = this.iconSize;
        if (r103 != 0) goto L11;
        r103 = this.icon.getIntrinsicWidth();
    L11:
        int r104 = this.iconSize;
        if (r104 != 0) goto L15;
        r104 = this.icon.getIntrinsicHeight();
    L15:
        Drawable r105 = this.icon;
        int r106 = this.iconLeft;
        r105.setBounds(r106, 0, r103 + r106, r104);
    L16:
        TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getCornerRadius();
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getRippleColor();
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getStrokeColor();
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getStrokeWidth();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintList();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintMode();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public MaterialButton(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        setBackgroundDrawable(r100);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setBackgroundColor(r100);
        return;
    L5:
        super.setBackgroundColor(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        if (isUsingOriginalBackground() == true) goto L5;
        super.setBackgroundDrawable(r100);
        return;
    L5:
        if (r100 == getBackground()) goto L7;
        this.materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(r100);
        return;
    L7:
        getBackground().setState(r100.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
    L5:
        setBackgroundDrawable(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r100) {
        setSupportBackgroundTintList(r100);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r100) {
        setSupportBackgroundTintMode(r100);
    }

    public void setCornerRadius(int r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCornerRadius(r100);
        return;
    }

    public void setCornerRadiusResource(int r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r100));
        return;
    }

    public void setIcon(Drawable r100) {
        if (this.icon == r100) goto L6;
        this.icon = r100;
        updateIcon();
        return;
    }

    public void setIconGravity(int r100) {
        this.iconGravity = r100;
    }

    public void setIconPadding(int r100) {
        if (this.iconPadding == r100) goto L6;
        this.iconPadding = r100;
        setCompoundDrawablePadding(r100);
        return;
    }

    public void setIconResource(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
    L5:
        setIcon(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setIconSize(int r100) {
        if (r100 < 0) goto L8;
        if (this.iconSize == r100) goto L9;
        this.iconSize = r100;
        updateIcon();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList r100) {
        if (this.iconTint == r100) goto L6;
        this.iconTint = r100;
        updateIcon();
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r100) {
        if (this.iconTintMode == r100) goto L6;
        this.iconTintMode = r100;
        updateIcon();
        return;
    }

    public void setIconTintResource(int r100) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), r100));
    }

    public void setInternalBackground(Drawable r100) {
        super.setBackgroundDrawable(r100);
    }

    public void setRippleColor(ColorStateList r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setRippleColor(r100);
        return;
    }

    public void setRippleColorResource(int r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(AppCompatResources.getColorStateList(getContext(), r100));
        return;
    }

    public void setStrokeColor(ColorStateList r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeColor(r100);
        return;
    }

    public void setStrokeColorResource(int r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r100));
        return;
    }

    public void setStrokeWidth(int r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeWidth(r100);
        return;
    }

    public void setStrokeWidthResource(int r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r100));
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setSupportBackgroundTintList(r100);
        return;
    L6:
        if (this.materialButtonHelper == null) goto L10;
        super.setSupportBackgroundTintList(r100);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setSupportBackgroundTintMode(r100);
        return;
    L6:
        if (this.materialButtonHelper == null) goto L10;
        super.setSupportBackgroundTintMode(r100);
        return;
    }

    public MaterialButton(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.materialButtonStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.icon != null) goto L5;
        return;
    L5:
        if (this.iconGravity != 2) goto L19;
        int r102 = (int) getPaint().measureText(getText().toString());
        int r103 = this.iconSize;
        if (r103 != 0) goto L10;
        r103 = this.icon.getIntrinsicWidth();
    L10:
        int r104 = (((((getMeasuredWidth() - r102) - ViewCompat.getPaddingEnd(this)) - r103) - this.iconPadding) - ViewCompat.getPaddingStart(this)) / 2;
        if (isLayoutRTL() == false) goto L14;
        r104 = -r104;
    L14:
        if (this.iconLeft == r104) goto L18;
        this.iconLeft = r104;
        updateIcon();
        return;
    L18:
        return;
    }

    public MaterialButton(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        TypedArray r102 = ThemeEnforcement.obtainStyledAttributes(r100, r101, new int[]{android.R.attr.insetLeft, android.R.attr.insetRight, android.R.attr.insetTop, android.R.attr.insetBottom, R.attr.backgroundTint, R.attr.backgroundTintMode, R.attr.cornerRadius, R.attr.icon, R.attr.iconGravity, R.attr.iconPadding, R.attr.iconSize, R.attr.iconTint, R.attr.iconTintMode, R.attr.rippleColor, R.attr.strokeColor, R.attr.strokeWidth}, r110, R.style.Widget_MaterialComponents_Button, new int[0]);
        this.iconPadding = r102.getDimensionPixelSize(9, 0);
        this.iconTintMode = ViewUtils.parseTintMode(r102.getInt(12, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), r102, 11);
        this.icon = MaterialResources.getDrawable(getContext(), r102, 7);
        this.iconGravity = r102.getInteger(8, 1);
        this.iconSize = r102.getDimensionPixelSize(10, 0);
        MaterialButtonHelper r103 = new MaterialButtonHelper(this);
        this.materialButtonHelper = r103;
        r103.loadFromAttributes(r102);
        r102.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (Build.VERSION.SDK_INT != 21) goto L8;
        MaterialButtonHelper r105 = this.materialButtonHelper;
        if (r105 == null) goto L9;
        r105.updateMaskBounds(r104 - r102, r103 - r101);
        return;
    L9:
        return;
    }
}
