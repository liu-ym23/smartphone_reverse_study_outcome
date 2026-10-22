package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Xml;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes23.dex */
public class ChipDrawable extends Drawable implements TintAwareDrawable, Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = null;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha;
    private boolean checkable;
    private Drawable checkedIcon;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentCompatRippleColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference<Delegate> delegate;
    private final ResourcesCompat.FontCallback fontCallback;
    private final Paint.FontMetrics fontMetrics;
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private int maxWidth;
    private final PointF pointF;
    private CharSequence rawText;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private boolean shouldDrawText;
    private MotionSpec showMotionSpec;
    private TextAppearance textAppearance;
    private float textEndPadding;
    private final TextPaint textPaint;
    private float textStartPadding;
    private float textWidth;
    private boolean textWidthDirty;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
    private PorterDuff.Mode tintMode;
    private TextUtils.TruncateAt truncateAt;
    private CharSequence unicodeWrappedText;
    private boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    static {
        DEFAULT_STATE = new int[]{R.attr.state_enabled};
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private float calculateTextCenterFromBaseline() {
        this.textPaint.getFontMetrics(this.fontMetrics);
        Paint.FontMetrics r100 = this.fontMetrics;
        return (r100.descent + r100.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        if (this.checkedIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.checkedIcon == null) goto L9;
        if (this.checkable == false) goto L9;
        return true;
    }

    private float getTextWidth() {
        if (this.textWidthDirty == false) goto L5;
        float r100 = calculateTextWidth(this.unicodeWrappedText);
        this.textWidth = r100;
        this.textWidthDirty = false;
        return r100;
    L5:
        return this.textWidth;
    }

    private ColorFilter getTintColorFilter() {
        ColorFilter r100 = this.colorFilter;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.tintFilter;
    }

    private boolean showsCheckedIcon() {
        if (this.checkedIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.checkedIcon == null) goto L9;
        if (this.currentChecked == false) goto L9;
        return true;
    }

    private boolean showsChipIcon() {
        if (this.chipIconVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.chipIcon == null) goto L7;
        return true;
    }

    private boolean showsCloseIcon() {
        if (this.closeIconVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.closeIcon == null) goto L7;
        return true;
    }

    private void updateCompatRippleColor() {
        if (this.useCompatRipple == false) goto L5;
        ColorStateList r100 = RippleUtils.convertToRippleDrawableColor(this.rippleColor);
    L6:
        this.compatRippleColor = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public Drawable getChipIcon() {
        Drawable r100 = this.chipIcon;
        if (r100 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r100);
    }

    public Drawable getCloseIcon() {
        Drawable r100 = this.closeIcon;
        if (r100 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round((((((this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding) + getTextWidth()) + this.textEndPadding) + calculateCloseIconWidth()) + this.chipEndPadding), this.maxWidth);
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (isStateful(this.chipBackgroundColor) == false) goto L5;
    L22:
        return true;
    L5:
        if (isStateful(this.chipStrokeColor) == true) goto L22;
        if (this.useCompatRipple == false) goto L11;
        if (isStateful(this.compatRippleColor) == true) goto L22;
    L11:
        if (isStateful(this.textAppearance) == true) goto L22;
        if (canShowCheckedIcon() == true) goto L22;
        if (isStateful(this.chipIcon) == true) goto L22;
        if (isStateful(this.checkedIcon) == true) goto L22;
        if (isStateful(this.tint) == true) goto L22;
        return false;
    }

    public void onSizeChange() {
        Delegate r100 = this.delegate.get();
        if (r100 == null) goto L6;
        r100.onChipDrawableSizeChange();
        return;
    }

    private float calculateCloseIconWidth() {
        if (showsCloseIcon() == true) goto L5;
        return 0.0f;
    L5:
        return (this.closeIconStartPadding + this.closeIconSize) + this.closeIconEndPadding;
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() == true) goto L10;
        if (showsCheckedIcon() == true) goto L10;
        return 0.0f;
    L10:
        return (this.iconStartPadding + this.chipIconSize) + this.iconEndPadding;
    }

    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        return this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public CharSequence getText() {
        return this.rawText;
    }

    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    private ChipDrawable(Context r100) {
        this.fontCallback = new AnonymousClass1(this);
        TextPaint r101 = new TextPaint(1);
        this.textPaint = r101;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        this.textWidthDirty = true;
        this.context = r100;
        this.rawText = "";
        r101.density = INVOKEVIRTUAL_com_google_android_material_chip_ChipDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        this.debugPaint = null;
        int[] r102 = DEFAULT_STATE;
        setState(r102);
        setCloseIconState(r102);
        this.shouldDrawText = true;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_google_android_material_chip_ChipDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void applyChildDrawable(Drawable r100) {
        if (r100 == null) goto L13;
        r100.setCallback(this);
        DrawableCompat.setLayoutDirection(r100, DrawableCompat.getLayoutDirection(this));
        r100.setLevel(getLevel());
        r100.setVisible(isVisible(), false);
        if (r100 != this.closeIcon) goto L10;
        if (r100.isStateful() == false) goto L8;
        r100.setState(getCloseIconState());
    L8:
        DrawableCompat.setTintList(r100, this.closeIconTint);
        return;
    L10:
        if (r100.isStateful() == false) goto L15;
        r100.setState(getState());
        return;
    L15:
        return;
    }

    private float calculateTextWidth(CharSequence r100) {
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return this.textPaint.measureText(r100, 0, r100.length());
    }

    private static boolean isStateful(TextAppearance r100) {
        if (r100 == null) goto L8;
        ColorStateList r101 = r100.textColor;
        if (r101 == null) goto L8;
        if (r101.isStateful() == false) goto L8;
        return true;
    L8:
        return false;
    }

    private void unapplyChildDrawable(Drawable r100) {
        if (r100 == null) goto L5;
        r100.setCallback(null);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Rect r101 = getBounds();
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() == 0) goto L20;
        int r102 = this.alpha;
        if (r102 >= 255) goto L10;
        int r103 = CanvasCompat.saveLayerAlpha(r100, r101.left, r101.top, r101.right, r101.bottom, r102);
    L11:
        drawChipBackground(r100, r101);
        drawChipStroke(r100, r101);
        drawCompatRipple(r100, r101);
        drawChipIcon(r100, r101);
        drawCheckedIcon(r100, r101);
        if (this.shouldDrawText == false) goto L14;
        drawText(r100, r101);
    L14:
        drawCloseIcon(r100, r101);
        drawDebug(r100, r101);
        if (this.alpha >= 255) goto L19;
        r100.restoreToCount(r103);
        return;
    L19:
        return;
    L10:
        r103 = 0;
        goto L11
    }

    public void getChipTouchBounds(RectF r100) {
        calculateChipTouchBounds(getBounds(), r100);
    }

    public void getCloseIconTouchBounds(RectF r100) {
        calculateCloseIconTouchBounds(getBounds(), r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        Rect r101 = getBounds();
        if (r101.isEmpty() == true) goto L5;
        r100.setRoundRect(r101, this.chipCornerRadius);
    L6:
        r100.setAlpha(getAlpha() / 255.0f);
        return;
    L5:
        r100.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        Drawable.Callback r101 = getCallback();
        if (r101 == null) goto L6;
        r101.invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r100) {
        boolean r101 = super.onLayoutDirectionChanged(r100);
        if (showsChipIcon() == false) goto L6;
        r101 = r101 | this.chipIcon.setLayoutDirection(r100);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r101 = r101 | this.checkedIcon.setLayoutDirection(r100);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r101 = r101 | this.closeIcon.setLayoutDirection(r100);
    L11:
        if (r101 == false) goto L15;
        invalidateSelf();
        return true;
    L15:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        boolean r101 = super.onLevelChange(r100);
        if (showsChipIcon() == false) goto L6;
        r101 = r101 | this.chipIcon.setLevel(r100);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r101 = r101 | this.checkedIcon.setLevel(r100);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r101 = r101 | this.closeIcon.setLevel(r100);
    L11:
        if (r101 == false) goto L13;
        invalidateSelf();
    L13:
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        return onStateChange(r100, getCloseIconState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (this.alpha == r100) goto L6;
        this.alpha = r100;
        invalidateSelf();
        return;
    }

    public void setCheckable(boolean r100) {
        if (this.checkable == r100) goto L13;
        this.checkable = r100;
        float r101 = calculateChipIconWidth();
        if (r100 == false) goto L7;
    L9:
        float r102 = calculateChipIconWidth();
        invalidateSelf();
        if (r101 == r102) goto L14;
        onSizeChange();
        return;
    L14:
        return;
    L7:
        if (this.currentChecked == false) goto L9;
        this.currentChecked = false;
        goto L9
    }

    public void setCheckableResource(int r100) {
        setCheckable(this.context.getResources().getBoolean(r100));
    }

    public void setCheckedIcon(Drawable r100) {
        if (this.checkedIcon == r100) goto L8;
        float r101 = calculateChipIconWidth();
        this.checkedIcon = r100;
        float r102 = calculateChipIconWidth();
        unapplyChildDrawable(this.checkedIcon);
        applyChildDrawable(this.checkedIcon);
        invalidateSelf();
        if (r101 == r102) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCheckedIconEnabled(boolean r100) {
        setCheckedIconVisible(r100);
    }

    public void setCheckedIconEnabledResource(int r100) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r100));
    }

    public void setCheckedIconResource(int r100) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, r100));
    }

    public void setCheckedIconVisible(boolean r100) {
        if (this.checkedIconVisible == r100) goto L14;
        boolean r101 = showsCheckedIcon();
        this.checkedIconVisible = r100;
        boolean r102 = showsCheckedIcon();
        if (r101 == r102) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L15;
        if (r102 == false) goto L11;
        applyChildDrawable(this.checkedIcon);
    L12:
        invalidateSelf();
        onSizeChange();
        return;
    L11:
        unapplyChildDrawable(this.checkedIcon);
        goto L12
    L15:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public void setChipBackgroundColor(ColorStateList r100) {
        if (this.chipBackgroundColor == r100) goto L6;
        this.chipBackgroundColor = r100;
        onStateChange(getState());
        return;
    }

    public void setChipBackgroundColorResource(int r100) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, r100));
    }

    public void setChipCornerRadius(float r100) {
        if (this.chipCornerRadius == r100) goto L6;
        this.chipCornerRadius = r100;
        invalidateSelf();
        return;
    }

    public void setChipCornerRadiusResource(int r100) {
        setChipCornerRadius(this.context.getResources().getDimension(r100));
    }

    public void setChipEndPadding(float r100) {
        if (this.chipEndPadding == r100) goto L6;
        this.chipEndPadding = r100;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipEndPaddingResource(int r100) {
        setChipEndPadding(this.context.getResources().getDimension(r100));
    }

    public void setChipIcon(Drawable r100) {
        Drawable r101 = getChipIcon();
        if (r101 == r100) goto L15;
        float r102 = calculateChipIconWidth();
        if (r100 == null) goto L7;
        Drawable r103 = DrawableCompat.wrap(r100).mutate();
    L8:
        this.chipIcon = r103;
        float r104 = calculateChipIconWidth();
        unapplyChildDrawable(r101);
        if (showsChipIcon() == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L11:
        invalidateSelf();
        if (r102 == r104) goto L16;
        onSizeChange();
        return;
    L16:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public void setChipIconEnabled(boolean r100) {
        setChipIconVisible(r100);
    }

    public void setChipIconEnabledResource(int r100) {
        setChipIconVisible(r100);
    }

    public void setChipIconResource(int r100) {
        setChipIcon(AppCompatResources.getDrawable(this.context, r100));
    }

    public void setChipIconSize(float r100) {
        if (this.chipIconSize == r100) goto L8;
        float r101 = calculateChipIconWidth();
        this.chipIconSize = r100;
        float r102 = calculateChipIconWidth();
        invalidateSelf();
        if (r101 == r102) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setChipIconSizeResource(int r100) {
        setChipIconSize(this.context.getResources().getDimension(r100));
    }

    public void setChipIconTint(ColorStateList r100) {
        if (this.chipIconTint == r100) goto L9;
        this.chipIconTint = r100;
        if (showsChipIcon() == false) goto L7;
        DrawableCompat.setTintList(this.chipIcon, r100);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipIconTintResource(int r100) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, r100));
    }

    public void setChipIconVisible(boolean r100) {
        if (this.chipIconVisible == r100) goto L14;
        boolean r101 = showsChipIcon();
        this.chipIconVisible = r100;
        boolean r102 = showsChipIcon();
        if (r101 == r102) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L15;
        if (r102 == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L12:
        invalidateSelf();
        onSizeChange();
        return;
    L11:
        unapplyChildDrawable(this.chipIcon);
        goto L12
    L15:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public void setChipMinHeight(float r100) {
        if (this.chipMinHeight == r100) goto L6;
        this.chipMinHeight = r100;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipMinHeightResource(int r100) {
        setChipMinHeight(this.context.getResources().getDimension(r100));
    }

    public void setChipStartPadding(float r100) {
        if (this.chipStartPadding == r100) goto L6;
        this.chipStartPadding = r100;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipStartPaddingResource(int r100) {
        setChipStartPadding(this.context.getResources().getDimension(r100));
    }

    public void setChipStrokeColor(ColorStateList r100) {
        if (this.chipStrokeColor == r100) goto L6;
        this.chipStrokeColor = r100;
        onStateChange(getState());
        return;
    }

    public void setChipStrokeColorResource(int r100) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, r100));
    }

    public void setChipStrokeWidth(float r100) {
        if (this.chipStrokeWidth == r100) goto L6;
        this.chipStrokeWidth = r100;
        this.chipPaint.setStrokeWidth(r100);
        invalidateSelf();
        return;
    }

    public void setChipStrokeWidthResource(int r100) {
        setChipStrokeWidth(this.context.getResources().getDimension(r100));
    }

    public void setCloseIcon(Drawable r100) {
        Drawable r101 = getCloseIcon();
        if (r101 == r100) goto L15;
        float r102 = calculateCloseIconWidth();
        if (r100 == null) goto L7;
        Drawable r103 = DrawableCompat.wrap(r100).mutate();
    L8:
        this.closeIcon = r103;
        float r104 = calculateCloseIconWidth();
        unapplyChildDrawable(r101);
        if (showsCloseIcon() == false) goto L11;
        applyChildDrawable(this.closeIcon);
    L11:
        invalidateSelf();
        if (r102 == r104) goto L16;
        onSizeChange();
        return;
    L16:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public void setCloseIconContentDescription(CharSequence r100) {
        if (this.closeIconContentDescription == r100) goto L6;
        this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(r100);
        invalidateSelf();
        return;
    }

    public void setCloseIconEnabled(boolean r100) {
        setCloseIconVisible(r100);
    }

    public void setCloseIconEnabledResource(int r100) {
        setCloseIconVisible(r100);
    }

    public void setCloseIconEndPadding(float r100) {
        if (this.closeIconEndPadding == r100) goto L8;
        this.closeIconEndPadding = r100;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconEndPaddingResource(int r100) {
        setCloseIconEndPadding(this.context.getResources().getDimension(r100));
    }

    public void setCloseIconResource(int r100) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, r100));
    }

    public void setCloseIconSize(float r100) {
        if (this.closeIconSize == r100) goto L8;
        this.closeIconSize = r100;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconSizeResource(int r100) {
        setCloseIconSize(this.context.getResources().getDimension(r100));
    }

    public void setCloseIconStartPadding(float r100) {
        if (this.closeIconStartPadding == r100) goto L8;
        this.closeIconStartPadding = r100;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconStartPaddingResource(int r100) {
        setCloseIconStartPadding(this.context.getResources().getDimension(r100));
    }

    public boolean setCloseIconState(int[] r100) {
        if (Arrays.equals(this.closeIconStateSet, r100) == true) goto L8;
        this.closeIconStateSet = r100;
        if (showsCloseIcon() == true) goto L7;
        return false;
    L7:
        return onStateChange(getState(), r100);
    L8:
        return false;
    }

    public void setCloseIconTint(ColorStateList r100) {
        if (this.closeIconTint == r100) goto L9;
        this.closeIconTint = r100;
        if (showsCloseIcon() == false) goto L7;
        DrawableCompat.setTintList(this.closeIcon, r100);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCloseIconTintResource(int r100) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, r100));
    }

    public void setCloseIconVisible(boolean r100) {
        if (this.closeIconVisible == r100) goto L14;
        boolean r101 = showsCloseIcon();
        this.closeIconVisible = r100;
        boolean r102 = showsCloseIcon();
        if (r101 == r102) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L15;
        if (r102 == false) goto L11;
        applyChildDrawable(this.closeIcon);
    L12:
        invalidateSelf();
        onSizeChange();
        return;
    L11:
        unapplyChildDrawable(this.closeIcon);
        goto L12
    L15:
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        if (this.colorFilter == r100) goto L6;
        this.colorFilter = r100;
        invalidateSelf();
        return;
    }

    public void setDelegate(Delegate r100) {
        this.delegate = new WeakReference(r100);
    }

    public void setEllipsize(TextUtils.TruncateAt r100) {
        this.truncateAt = r100;
    }

    public void setHideMotionSpec(MotionSpec r100) {
        this.hideMotionSpec = r100;
    }

    public void setHideMotionSpecResource(int r100) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, r100));
    }

    public void setIconEndPadding(float r100) {
        if (this.iconEndPadding == r100) goto L8;
        float r101 = calculateChipIconWidth();
        this.iconEndPadding = r100;
        float r102 = calculateChipIconWidth();
        invalidateSelf();
        if (r101 == r102) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconEndPaddingResource(int r100) {
        setIconEndPadding(this.context.getResources().getDimension(r100));
    }

    public void setIconStartPadding(float r100) {
        if (this.iconStartPadding == r100) goto L8;
        float r101 = calculateChipIconWidth();
        this.iconStartPadding = r100;
        float r102 = calculateChipIconWidth();
        invalidateSelf();
        if (r101 == r102) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconStartPaddingResource(int r100) {
        setIconStartPadding(this.context.getResources().getDimension(r100));
    }

    public void setMaxWidth(int r100) {
        this.maxWidth = r100;
    }

    public void setRippleColor(ColorStateList r100) {
        if (this.rippleColor == r100) goto L6;
        this.rippleColor = r100;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    public void setRippleColorResource(int r100) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, r100));
    }

    public void setShouldDrawText(boolean r100) {
        this.shouldDrawText = r100;
    }

    public void setShowMotionSpec(MotionSpec r100) {
        this.showMotionSpec = r100;
    }

    public void setShowMotionSpecResource(int r100) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, r100));
    }

    public void setText(CharSequence r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (this.rawText == r100) goto L8;
        this.rawText = r100;
        this.unicodeWrappedText = BidiFormatter.getInstance().unicodeWrap(r100);
        this.textWidthDirty = true;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextAppearance(TextAppearance r100) {
        if (this.textAppearance == r100) goto L9;
        this.textAppearance = r100;
        if (r100 == null) goto L7;
        r100.updateMeasureState(this.context, this.textPaint, this.fontCallback);
        this.textWidthDirty = true;
    L7:
        onStateChange(getState());
        onSizeChange();
        return;
    }

    public void setTextAppearanceResource(int r100) {
        setTextAppearance(new TextAppearance(this.context, r100));
    }

    public void setTextEndPadding(float r100) {
        if (this.textEndPadding == r100) goto L6;
        this.textEndPadding = r100;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextEndPaddingResource(int r100) {
        setTextEndPadding(this.context.getResources().getDimension(r100));
    }

    public void setTextResource(int r100) {
        setText(this.context.getResources().getString(r100));
    }

    public void setTextStartPadding(float r100) {
        if (this.textStartPadding == r100) goto L6;
        this.textStartPadding = r100;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextStartPaddingResource(int r100) {
        setTextStartPadding(this.context.getResources().getDimension(r100));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        if (this.tint == r100) goto L6;
        this.tint = r100;
        onStateChange(getState());
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        if (this.tintMode == r100) goto L6;
        this.tintMode = r100;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, r100);
        invalidateSelf();
        return;
    }

    public void setUseCompatRipple(boolean r100) {
        if (this.useCompatRipple == r100) goto L6;
        this.useCompatRipple = r100;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    private static boolean isStateful(ColorStateList r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isStateful() == false) goto L6;
        return true;
    }

    public void setCheckedIconVisible(int r100) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r100));
    }

    public void setChipIconVisible(int r100) {
        setChipIconVisible(this.context.getResources().getBoolean(r100));
    }

    public void setCloseIconVisible(int r100) {
        setCloseIconVisible(this.context.getResources().getBoolean(r100));
    }

    private static boolean isStateful(Drawable r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isStateful() == false) goto L6;
        return true;
    }

    public static /* synthetic */ boolean access$002(ChipDrawable r100, boolean r101) {
        r100.textWidthDirty = r101;
        return r101;
    }

    private void calculateChipIconBounds(Rect r100, RectF r101) {
        r101.setEmpty();
        if (showsChipIcon() == false) goto L5;
    L6:
        float r102 = this.chipStartPadding + this.iconStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L9;
        float r103 = r100.left + r102;
        r101.left = r103;
        r101.right = r103 + this.chipIconSize;
    L10:
        float r104 = r100.exactCenterY();
        float r105 = this.chipIconSize;
        float r106 = r104 - (r105 / 2.0f);
        r101.top = r106;
        r101.bottom = r106 + r105;
        return;
    L9:
        float r107 = r100.right - r102;
        r101.right = r107;
        r101.left = r107 - this.chipIconSize;
        goto L10
    L5:
        if (showsCheckedIcon() == true) goto L6;
    }

    private void calculateChipTouchBounds(Rect r100, RectF r101) {
        r101.set(r100);
        if (showsCloseIcon() == false) goto L9;
        float r102 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r101.right = r100.right - r102;
        return;
    L7:
        r101.left = r100.left + r102;
        return;
    }

    private void calculateCloseIconBounds(Rect r100, RectF r101) {
        r101.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r102 = this.chipEndPadding + this.closeIconEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r103 = r100.right - r102;
        r101.right = r103;
        r101.left = r103 - this.closeIconSize;
    L8:
        float r104 = r100.exactCenterY();
        float r105 = this.closeIconSize;
        float r106 = r104 - (r105 / 2.0f);
        r101.top = r106;
        r101.bottom = r106 + r105;
        return;
    L7:
        float r107 = r100.left + r102;
        r101.left = r107;
        r101.right = r107 + this.closeIconSize;
        goto L8
    }

    private void calculateCloseIconTouchBounds(Rect r100, RectF r101) {
        r101.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r102 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r103 = r100.right;
        r101.right = r103;
        r101.left = r103 - r102;
    L8:
        r101.top = r100.top;
        r101.bottom = r100.bottom;
        return;
    L7:
        int r104 = r100.left;
        r101.left = r104;
        r101.right = r104 + r102;
        goto L8
    }

    private void calculateTextBounds(Rect r100, RectF r101) {
        r101.setEmpty();
        if (this.unicodeWrappedText == null) goto L10;
        float r102 = (this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding;
        float r103 = (this.chipEndPadding + calculateCloseIconWidth()) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r101.left = r100.left + r102;
        r101.right = r100.right - r103;
    L8:
        r101.top = r100.top;
        r101.bottom = r100.bottom;
        return;
    L7:
        r101.left = r100.left + r103;
        r101.right = r100.right - r102;
        goto L8
    }

    public static ChipDrawable createFromResource(Context r100, int r101) {
        XmlResourceParser r102 = r100.getResources().getXml(r101);     // Catch: Throwable -> L19 XmlPullParserException -> L21
    L3:
        int r103 = r102.next();     // Catch: Throwable -> L19 XmlPullParserException -> L21
        if (r103 == 2) goto L7;
        if (r103 != 1) goto L3;
    L7:
        if (r103 != 2) goto L18;
        if (TextUtils.equals(r102.getName(), "chip") == false) goto L16;
        AttributeSet r104 = Xml.asAttributeSet(r102);     // Catch: Throwable -> L19 XmlPullParserException -> L21
        int r105 = r104.getStyleAttribute();     // Catch: Throwable -> L19 XmlPullParserException -> L21
        if (r105 != 0) goto L14;
        r105 = com.larus.nova.R.style.Widget_MaterialComponents_Chip_Entry;
    L14:
        return createFromAttributes(r100, r104, com.larus.nova.R.attr.chipStandaloneStyle, r105);
    L16:
        throw new XmlPullParserException("Must have a <chip> start tag");     // Catch: Throwable -> L19 XmlPullParserException -> L21
    L18:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L19 XmlPullParserException -> L21
    L19:
        e = move-exception;
        Resources.NotFoundException r106 = new Resources.NotFoundException("Can't load chip resource ID #0x" + Integer.toHexString(r101));
        r106.initCause(e);
        throw r106;
    }

    private void drawCheckedIcon(Canvas r100, Rect r101) {
        if (showsCheckedIcon() == false) goto L6;
        calculateChipIconBounds(r101, this.rectF);
        RectF r102 = this.rectF;
        float r103 = r102.left;
        float r104 = r102.top;
        r100.translate(r103, r104);
        this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.checkedIcon.draw(r100);
        r100.translate(-r103, -r104);
        return;
    }

    private void drawChipBackground(Canvas r100, Rect r101) {
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(r101);
        RectF r102 = this.rectF;
        float r103 = this.chipCornerRadius;
        r100.drawRoundRect(r102, r103, r103, this.chipPaint);
    }

    private void drawChipIcon(Canvas r100, Rect r101) {
        if (showsChipIcon() == false) goto L6;
        calculateChipIconBounds(r101, this.rectF);
        RectF r102 = this.rectF;
        float r103 = r102.left;
        float r104 = r102.top;
        r100.translate(r103, r104);
        this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.chipIcon.draw(r100);
        r100.translate(-r103, -r104);
        return;
    }

    private void drawChipStroke(Canvas r100, Rect r101) {
        if (this.chipStrokeWidth <= 0.0f) goto L6;
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(Paint.Style.STROKE);
        this.chipPaint.setColorFilter(getTintColorFilter());
        RectF r102 = this.rectF;
        float r103 = r101.left;
        float r104 = this.chipStrokeWidth;
        r102.set(r103 + (r104 / 2.0f), r101.top + (r104 / 2.0f), r101.right - (r104 / 2.0f), r101.bottom - (r104 / 2.0f));
        float r105 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        r100.drawRoundRect(this.rectF, r105, r105, this.chipPaint);
        return;
    }

    private void drawCloseIcon(Canvas r100, Rect r101) {
        if (showsCloseIcon() == false) goto L6;
        calculateCloseIconBounds(r101, this.rectF);
        RectF r102 = this.rectF;
        float r103 = r102.left;
        float r104 = r102.top;
        r100.translate(r103, r104);
        this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.closeIcon.draw(r100);
        r100.translate(-r103, -r104);
        return;
    }

    private void drawCompatRipple(Canvas r100, Rect r101) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r101);
        RectF r102 = this.rectF;
        float r103 = this.chipCornerRadius;
        r100.drawRoundRect(r102, r103, r103, this.chipPaint);
    }

    private void drawDebug(Canvas r110, Rect r111) {
        Paint r100 = this.debugPaint;
        if (r100 == null) goto L17;
        r100.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
        r110.drawRect(r111, this.debugPaint);
        if (showsChipIcon() == false) goto L7;
    L8:
        calculateChipIconBounds(r111, this.rectF);
        r110.drawRect(this.rectF, this.debugPaint);
    L10:
        if (this.unicodeWrappedText == null) goto L13;
        r110.drawLine(r111.left, r111.exactCenterY(), r111.right, r111.exactCenterY(), this.debugPaint);
    L13:
        if (showsCloseIcon() == false) goto L15;
        calculateCloseIconBounds(r111, this.rectF);
        r110.drawRect(this.rectF, this.debugPaint);
    L15:
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
        calculateChipTouchBounds(r111, this.rectF);
        r110.drawRect(this.rectF, this.debugPaint);
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(FakePickerAvatarCreator.GREEN, 127));
        calculateCloseIconTouchBounds(r111, this.rectF);
        r110.drawRect(this.rectF, this.debugPaint);
        return;
    L7:
        if (showsCheckedIcon() == false) goto L10;
    }

    private void drawText(Canvas r110, Rect r111) {
        if (this.unicodeWrappedText == null) goto L22;
        Paint.Align r100 = calculateTextOriginAndAlignment(r111, this.pointF);
        calculateTextBounds(r111, this.rectF);
        if (this.textAppearance == null) goto L7;
        TextPaint r112 = this.textPaint;
        r112.drawableState = getState();
        this.textAppearance.updateDrawState(this.context, this.textPaint, this.fontCallback);
    L7:
        this.textPaint.setTextAlign(r100);
        int r101 = 0;
        if (Math.round(getTextWidth()) <= Math.round(this.rectF.width())) goto L10;
        boolean r113 = true;
    L11:
        if (r113 == false) goto L13;
        r101 = r110.save();
        r110.clipRect(this.rectF);
    L13:
        CharSequence r102 = this.unicodeWrappedText;
        if (r113 == true) goto L16;
    L18:
        CharSequence r103 = r102;
        int r104 = r103.length();
        PointF r105 = this.pointF;
        r110.drawText(r103, 0, r104, r105.x, r105.y, this.textPaint);
        if (r113 == false) goto L23;
        r110.restoreToCount(r101);
        return;
    L23:
        return;
    L16:
        if (this.truncateAt == null) goto L18;
        r102 = TextUtils.ellipsize(r102, this.textPaint, this.rectF.width(), this.truncateAt);
        goto L18
    L10:
        r113 = false;
        goto L11
    }

    private static boolean hasState(int[] r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private boolean onStateChange(int[] r100, int[] r101) {
        boolean r102 = super.onStateChange(r100);
        ColorStateList r103 = this.chipBackgroundColor;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.getColorForState(r100, this.currentChipBackgroundColor);
    L6:
        boolean r106 = true;
        if (this.currentChipBackgroundColor == r105) goto L9;
        this.currentChipBackgroundColor = r105;
        r102 = true;
    L9:
        ColorStateList r107 = this.chipStrokeColor;
        if (r107 == null) goto L12;
        int r108 = r107.getColorForState(r100, this.currentChipStrokeColor);
    L14:
        if (this.currentChipStrokeColor == r108) goto L16;
        this.currentChipStrokeColor = r108;
        r102 = true;
    L16:
        ColorStateList r109 = this.compatRippleColor;
        if (r109 == null) goto L19;
        int r110 = r109.getColorForState(r100, this.currentCompatRippleColor);
    L21:
        if (this.currentCompatRippleColor == r110) goto L25;
        this.currentCompatRippleColor = r110;
        if (this.useCompatRipple == false) goto L25;
        r102 = true;
    L25:
        TextAppearance r111 = this.textAppearance;
        if (r111 == null) goto L30;
        ColorStateList r112 = r111.textColor;
        if (r112 == null) goto L30;
        int r113 = r112.getColorForState(r100, this.currentTextColor);
    L32:
        if (this.currentTextColor == r113) goto L35;
        this.currentTextColor = r113;
        r102 = true;
    L35:
        if (hasState(getState(), R.attr.state_checked) == true) goto L37;
    L39:
        boolean r114 = false;
    L41:
        if (this.currentChecked != r114) goto L43;
    L48:
        boolean r115 = false;
    L49:
        ColorStateList r116 = this.tint;
        if (r116 == null) goto L53;
        r104 = r116.getColorForState(r100, this.currentTint);
    L53:
        if (this.currentTint == r104) goto L55;
        this.currentTint = r104;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
    L57:
        if (isStateful(this.chipIcon) == false) goto L60;
        r106 = r106 | this.chipIcon.setState(r100);
    L60:
        if (isStateful(this.checkedIcon) == false) goto L63;
        r106 = r106 | this.checkedIcon.setState(r100);
    L63:
        if (isStateful(this.closeIcon) == false) goto L65;
        r106 = r106 | this.closeIcon.setState(r101);
    L65:
        if (r106 == false) goto L67;
        invalidateSelf();
    L67:
        if (r115 == false) goto L69;
        onSizeChange();
    L69:
        return r106;
    L55:
        r106 = r102;
        goto L57
    L43:
        if (this.checkedIcon == null) goto L48;
        float r117 = calculateChipIconWidth();
        this.currentChecked = r114;
        if (r117 == calculateChipIconWidth()) goto L47;
        r102 = true;
        r115 = true;
        goto L49
    L47:
        r102 = true;
        goto L48
    L37:
        if (this.checkable == false) goto L39;
        r114 = true;
    L30:
        r113 = 0;
        goto L32
    L19:
        r110 = 0;
        goto L21
    L12:
        r108 = 0;
        goto L14
    L5:
        r105 = 0;
        goto L6
    }

    public Paint.Align calculateTextOriginAndAlignment(Rect r100, PointF r101) {
        r101.set(0.0f, 0.0f);
        Paint.Align r102 = Paint.Align.LEFT;
        if (this.unicodeWrappedText == null) goto L9;
        float r103 = (this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r101.x = r100.left + r103;
        r102 = Paint.Align.LEFT;
    L8:
        r101.y = r100.centerY() - calculateTextCenterFromBaseline();
        goto L9
    L7:
        r101.x = r100.right - r103;
        r102 = Paint.Align.RIGHT;
    L9:
        return r102;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        if (showsChipIcon() == false) goto L6;
        r102 = r102 | this.chipIcon.setVisible(r100, r101);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r102 = r102 | this.checkedIcon.setVisible(r100, r101);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r102 = r102 | this.closeIcon.setVisible(r100, r101);
    L11:
        if (r102 == false) goto L13;
        invalidateSelf();
    L13:
        return r102;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r100, Runnable r101) {
        Drawable.Callback r102 = getCallback();
        if (r102 == null) goto L6;
        r102.unscheduleDrawable(this, r101);
        return;
    }

    private void loadFromAttributes(AttributeSet r100, int r101, int r110) {
        TypedArray r102 = ThemeEnforcement.obtainStyledAttributes(this.context, r100, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.maxWidth, R.attr.text, R.attr.checkable, com.larus.nova.R.attr.checkedIcon, com.larus.nova.R.attr.checkedIconEnabled, com.larus.nova.R.attr.checkedIconVisible, com.larus.nova.R.attr.chipBackgroundColor, com.larus.nova.R.attr.chipCornerRadius, com.larus.nova.R.attr.chipEndPadding, com.larus.nova.R.attr.chipIcon, com.larus.nova.R.attr.chipIconEnabled, com.larus.nova.R.attr.chipIconSize, com.larus.nova.R.attr.chipIconTint, com.larus.nova.R.attr.chipIconVisible, com.larus.nova.R.attr.chipMinHeight, com.larus.nova.R.attr.chipStartPadding, com.larus.nova.R.attr.chipStrokeColor, com.larus.nova.R.attr.chipStrokeWidth, com.larus.nova.R.attr.closeIcon, com.larus.nova.R.attr.closeIconEnabled, com.larus.nova.R.attr.closeIconEndPadding, com.larus.nova.R.attr.closeIconSize, com.larus.nova.R.attr.closeIconStartPadding, com.larus.nova.R.attr.closeIconTint, com.larus.nova.R.attr.closeIconVisible, com.larus.nova.R.attr.hideMotionSpec, com.larus.nova.R.attr.iconEndPadding, com.larus.nova.R.attr.iconStartPadding, com.larus.nova.R.attr.rippleColor, com.larus.nova.R.attr.showMotionSpec, com.larus.nova.R.attr.textEndPadding, com.larus.nova.R.attr.textStartPadding}, r101, r110, new int[0]);
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, r102, 8));
        setChipMinHeight(r102.getDimension(16, 0.0f));
        setChipCornerRadius(r102.getDimension(9, 0.0f));
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, r102, 18));
        setChipStrokeWidth(r102.getDimension(19, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, r102, 30));
        setText(r102.getText(3));
        setTextAppearance(MaterialResources.getTextAppearance(this.context, r102, 0));
        int r103 = r102.getInt(1, 0);
        if (r103 == 1) goto L9;
        if (r103 == 2) goto L8;
        if (r103 != 3) goto L10;
        setEllipsize(TextUtils.TruncateAt.END);
    L10:
        setChipIconVisible(r102.getBoolean(15, false));
        if (r100 != null) goto L13;
    L17:
        setChipIcon(MaterialResources.getDrawable(this.context, r102, 11));
        setChipIconTint(MaterialResources.getColorStateList(this.context, r102, 14));
        setChipIconSize(r102.getDimension(13, 0.0f));
        setCloseIconVisible(r102.getBoolean(26, false));
        if (r100 != null) goto L20;
    L24:
        setCloseIcon(MaterialResources.getDrawable(this.context, r102, 20));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, r102, 25));
        setCloseIconSize(r102.getDimension(23, 0.0f));
        setCheckable(r102.getBoolean(4, false));
        setCheckedIconVisible(r102.getBoolean(7, false));
        if (r100 != null) goto L27;
    L31:
        setCheckedIcon(MaterialResources.getDrawable(this.context, r102, 5));
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, r102, 31));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, r102, 27));
        setChipStartPadding(r102.getDimension(17, 0.0f));
        setIconStartPadding(r102.getDimension(29, 0.0f));
        setIconEndPadding(r102.getDimension(28, 0.0f));
        setTextStartPadding(r102.getDimension(33, 0.0f));
        setTextEndPadding(r102.getDimension(32, 0.0f));
        setCloseIconStartPadding(r102.getDimension(24, 0.0f));
        setCloseIconEndPadding(r102.getDimension(22, 0.0f));
        setChipEndPadding(r102.getDimension(10, 0.0f));
        setMaxWidth(r102.getDimensionPixelSize(2, Integer.MAX_VALUE));
        r102.recycle();
        return;
    L27:
        if (r100.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null) goto L31;
        if (r100.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null) goto L31;
        setCheckedIconVisible(r102.getBoolean(6, false));
        goto L31
    L20:
        if (r100.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null) goto L24;
        if (r100.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null) goto L24;
        setCloseIconVisible(r102.getBoolean(21, false));
        goto L24
    L13:
        if (r100.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null) goto L17;
        if (r100.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null) goto L17;
        setChipIconVisible(r102.getBoolean(12, false));
        goto L17
    L8:
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        goto L10
    L9:
        setEllipsize(TextUtils.TruncateAt.START);
        goto L10
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Drawable.Callback r103 = getCallback();
        if (r103 == null) goto L6;
        r103.scheduleDrawable(this, r101, r102);
        return;
    }

    public static ChipDrawable createFromAttributes(Context r100, AttributeSet r101, int r102, int r103) {
        ChipDrawable r104 = new ChipDrawable(r100);
        r104.loadFromAttributes(r101, r102, r103);
        return r104;
    }
}
