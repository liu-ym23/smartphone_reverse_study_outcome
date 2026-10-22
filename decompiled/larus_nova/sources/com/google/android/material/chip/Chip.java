package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.larus.nova.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate {
    private static final int CLOSE_ICON_VIRTUAL_ID = 0;
    private static final Rect EMPTY_BOUNDS = null;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private int focusedVirtualView;
    private final ResourcesCompat.FontCallback fontCallback;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    private RippleDrawable ripple;
    private final ChipTouchHelper touchHelper;

    public class ChipTouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ Chip this$0;

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> r100) {
            if (Chip.access$100(this.this$0) == false) goto L6;
            r100.add(0);
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat r100) {
            if (Chip.access$000(this.this$0) != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            r100.setCheckable(r101);
            r100.setClassName(Chip.class.getName());
            CharSequence r102 = this.this$0.getText();
            if (Build.VERSION.SDK_INT < 23) goto L11;
            r100.setText(r102);
            return;
        L11:
            r100.setContentDescription(r102);
            return;
        L5:
            if (Chip.access$000(this.this$0).isCheckable() == false) goto L7;
            r101 = true;
            goto L8
        }

        public ChipTouchHelper(Chip r100, Chip r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float r100, float r101) {
            if (Chip.access$100(this.this$0) == true) goto L5;
        L7:
            return -1;
        L5:
            if (Chip.access$200(this.this$0).contains(r100, r101) == false) goto L7;
            return 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int r100, AccessibilityNodeInfoCompat r101) {
            CharSequence r102 = "";
            if (Chip.access$100(this.this$0) == false) goto L12;
            CharSequence r103 = this.this$0.getCloseIconContentDescription();
            if (r103 == null) goto L7;
            r101.setContentDescription(r103);
        L11:
            r101.setBoundsInParent(Chip.access$300(this.this$0));
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            r101.setEnabled(this.this$0.isEnabled());
            return;
        L7:
            CharSequence r104 = this.this$0.getText();
            Context r105 = this.this$0.getContext();
            Object[] r106 = new Object[1];
            if (TextUtils.isEmpty(r104) == true) goto L10;
            r102 = r104;
        L10:
            r106[0] = r102;
            r101.setContentDescription(r105.getString(R.string.mtrl_chip_close_icon_content_description, r106).trim());
            goto L11
        L12:
            r101.setContentDescription("");
            r101.setBoundsInParent(Chip.access$400());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int r100, int r101, Bundle r102) {
            if (r101 != 16) goto L7;
            if (r100 == 0) goto L6;
            return false;
        L6:
            return this.this$0.performCloseIconClick();
        L7:
            return false;
        }
    }

    public boolean performCloseIconClick() {
        playSoundEffect(0);
        View.OnClickListener r100 = this.onCloseIconClickListener;
        if (r100 == null) goto L5;
        r100.onClick(this);
        boolean r101 = true;
    L6:
        this.touchHelper.sendEventForVirtualView(0, 1);
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    static {
        EMPTY_BOUNDS = new Rect();
        SELECTED_STATE = new int[]{android.R.attr.state_selected};
    }

    private void ensureFocus() {
        if (this.focusedVirtualView != Integer.MIN_VALUE) goto L6;
        setFocusedVirtualView(-1);
        return;
    }

    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() == false) goto L6;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    L6:
        return this.rectF;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTextAppearance();
    }

    private boolean hasCloseIcon() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getCloseIcon() == null) goto L7;
        return true;
    }

    private void initOutlineProvider() {
        setOutlineProvider(new AnonymousClass2(this));
    }

    public Drawable getCheckedIcon() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCheckedIcon();
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChipBackgroundColor();
    }

    public float getChipCornerRadius() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getChipCornerRadius();
    }

    public float getChipEndPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getChipEndPadding();
    }

    public Drawable getChipIcon() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChipIcon();
    }

    public float getChipIconSize() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getChipIconSize();
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChipIconTint();
    }

    public float getChipMinHeight() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getChipMinHeight();
    }

    public float getChipStartPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getChipStartPadding();
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChipStrokeColor();
    }

    public float getChipStrokeWidth() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getChipStrokeWidth();
    }

    public Drawable getCloseIcon() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCloseIcon();
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCloseIconContentDescription();
    }

    public float getCloseIconEndPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getCloseIconEndPadding();
    }

    public float getCloseIconSize() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getCloseIconSize();
    }

    public float getCloseIconStartPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getCloseIconStartPadding();
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCloseIconTint();
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getEllipsize();
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHideMotionSpec();
    }

    public float getIconEndPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getIconEndPadding();
    }

    public float getIconStartPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getIconStartPadding();
    }

    public ColorStateList getRippleColor() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRippleColor();
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getShowMotionSpec();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getText();
    }

    public float getTextEndPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getTextEndPadding();
    }

    public float getTextStartPadding() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getTextStartPadding();
    }

    public boolean isCheckable() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCheckable() == false) goto L7;
        return true;
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCheckedIconVisible() == false) goto L7;
        return true;
    }

    public boolean isChipIconVisible() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isChipIconVisible() == false) goto L7;
        return true;
    }

    public boolean isCloseIconVisible() {
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCloseIconVisible() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] createCloseIconDrawableState() {
        ?? r100 = isEnabled();
        int r101 = r100;
        if (this.closeIconFocused == false) goto L5;
        r101 = r100 + 1;
    L5:
        int r102 = r101;
        if (this.closeIconHovered == false) goto L8;
        r102 = r101 + 1;
    L8:
        int r103 = r102;
        if (this.closeIconPressed == false) goto L11;
        r103 = r102 + 1;
    L11:
        int r104 = r103;
        if (isChecked() == false) goto L14;
        r104 = r103 + 1;
    L14:
        int[] r105 = new int[r104];
        int r106 = 0;
        if (isEnabled() == false) goto L18;
        r105[0] = 16842910;
        r106 = 1;
    L18:
        if (this.closeIconFocused == false) goto L21;
        r105[r106] = 16842908;
        r106 = r106 + 1;
    L21:
        if (this.closeIconHovered == false) goto L24;
        r105[r106] = 16843623;
        r106 = r106 + 1;
    L24:
        if (this.closeIconPressed == false) goto L27;
        r105[r106] = 16842919;
        r106 = r106 + 1;
    L27:
        if (isChecked() == false) goto L29;
        r105[r106] = 16842913;
    L29:
        return r105;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF r100 = getCloseIconTouchBounds();
        this.rect.set((int) r100.left, (int) r100.top, (int) r100.right, (int) r100.bottom);
        return this.rect;
    }

    private void updatePaddingInternal() {
        if (TextUtils.isEmpty(getText()) == true) goto L27;
        ChipDrawable r100 = this.chipDrawable;
        if (r100 == null) goto L29;
        float r101 = ((r100.getChipStartPadding() + this.chipDrawable.getChipEndPadding()) + this.chipDrawable.getTextStartPadding()) + this.chipDrawable.getTextEndPadding();
        if (this.chipDrawable.isChipIconVisible() == false) goto L12;
        if (this.chipDrawable.getChipIcon() == null) goto L12;
    L17:
        r101 = r101 + ((this.chipDrawable.getIconStartPadding() + this.chipDrawable.getIconEndPadding()) + this.chipDrawable.getChipIconSize());
    L19:
        if (this.chipDrawable.isCloseIconVisible() == false) goto L24;
        if (this.chipDrawable.getCloseIcon() == null) goto L24;
        r101 = r101 + ((this.chipDrawable.getCloseIconStartPadding() + this.chipDrawable.getCloseIconEndPadding()) + this.chipDrawable.getCloseIconSize());
    L24:
        if (ViewCompat.getPaddingEnd(this) == r101) goto L28;
        ViewCompat.setPaddingRelative(this, ViewCompat.getPaddingStart(this), getPaddingTop(), (int) r101, getPaddingBottom());
        return;
    L28:
        return;
    L12:
        if (this.chipDrawable.getCheckedIcon() == null) goto L19;
        if (this.chipDrawable.isCheckedIconVisible() == false) goto L19;
        if (isChecked() == false) goto L19;
    L29:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable r100 = this.chipDrawable;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r100.isCloseIconStateful() == false) goto L7;
        r101 = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        goto L8
    }

    public CharSequence getChipText() {
        return getText();
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

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        updatePaddingInternal();
        requestLayout();
        invalidateOutline();
    }

    public static /* synthetic */ Rect access$400() {
        return EMPTY_BOUNDS;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public Chip(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ ChipDrawable access$000(Chip r100) {
        return r100.chipDrawable;
    }

    public static /* synthetic */ boolean access$100(Chip r100) {
        return r100.hasCloseIcon();
    }

    public static /* synthetic */ RectF access$200(Chip r100) {
        return r100.getCloseIconTouchBounds();
    }

    public static /* synthetic */ Rect access$300(Chip r100) {
        return r100.getCloseIconTouchBoundsInt();
    }

    private void applyChipDrawable(ChipDrawable r100) {
        r100.setDelegate(this);
    }

    private float calculateTextOffsetFromStart(ChipDrawable r100) {
        float r101 = (getChipStartPadding() + r100.calculateChipIconWidth()) + getTextStartPadding();
        if (ViewCompat.getLayoutDirection(this) != 0) goto L6;
        return r101;
    L6:
        return -r101;
    }

    private boolean handleAccessibilityExit(MotionEvent r100) {
        if (r100.getAction() == 10) goto L10;
    L8:
        return false;
    L10:
        Field r101 = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");     // Catch: Throwable -> L9
        r101.setAccessible(true);     // Catch: Throwable -> L9
        if (((Integer) r101.get(this.touchHelper)).intValue() == Integer.MIN_VALUE) goto L8;
        Method r102 = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", new Class[]{Integer.TYPE});     // Catch: Throwable -> L9
        r102.setAccessible(true);     // Catch: Throwable -> L9
        r102.invoke(this.touchHelper, new Object[]{Integer.MIN_VALUE});     // Catch: Throwable -> L9
        return true;
    }

    private boolean moveFocus(boolean r100) {
        ensureFocus();
        if (r100 == false) goto L8;
        if (this.focusedVirtualView != (-1)) goto L10;
        setFocusedVirtualView(0);
        return true;
    L10:
        return false;
    L8:
        if (this.focusedVirtualView != 0) goto L10;
        setFocusedVirtualView(-1);
        return true;
    }

    private void setCloseIconFocused(boolean r100) {
        if (this.closeIconFocused == r100) goto L6;
        this.closeIconFocused = r100;
        refreshDrawableState();
        return;
    }

    private void setCloseIconHovered(boolean r100) {
        if (this.closeIconHovered == r100) goto L6;
        this.closeIconHovered = r100;
        refreshDrawableState();
        return;
    }

    private void setCloseIconPressed(boolean r100) {
        if (this.closeIconPressed == r100) goto L6;
        this.closeIconPressed = r100;
        refreshDrawableState();
        return;
    }

    private void setFocusedVirtualView(int r100) {
        int r101 = this.focusedVirtualView;
        if (r101 == r100) goto L10;
        if (r101 != 0) goto L6;
        setCloseIconFocused(false);
    L6:
        this.focusedVirtualView = r100;
        if (r100 != 0) goto L11;
        setCloseIconFocused(true);
        return;
    L11:
        return;
    }

    private void unapplyChipDrawable(ChipDrawable r100) {
        if (r100 == null) goto L5;
        r100.setDelegate(null);
        return;
    }

    private void updateTextPaintDrawState(TextAppearance r100) {
        TextPaint r101 = getPaint();
        r101.drawableState = this.chipDrawable.getState();
        r100.updateDrawState(getContext(), r101, this.fontCallback);
    }

    private void validateAttributes(AttributeSet r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getAttributeValue(NAMESPACE_ANDROID, "background") != null) goto L35;
        if (r100.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) goto L33;
        if (r100.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) goto L31;
        if (r100.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) goto L29;
        if (r100.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) goto L27;
        if (r100.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) == false) goto L25;
        if (r100.getAttributeIntValue(NAMESPACE_ANDROID, GXTemplateKey.STYLE_FONT_LINES, 1) != 1) goto L25;
        if (r100.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1) goto L25;
        if (r100.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) goto L25;
        r100.getAttributeIntValue(NAMESPACE_ANDROID, GXTemplateKey.GAIAX_LAYER_GRAVITY, 8388627);
        return;
    L25:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    L27:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L29:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L31:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    L33:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    L35:
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent r100) {
        if (handleAccessibilityExit(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.touchHelper.dispatchHoverEvent(r100) == true) goto L10;
        if (super.dispatchHoverEvent(r100) == true) goto L10;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r100) {
        if (this.touchHelper.dispatchKeyEvent(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchKeyEvent(r100) == true) goto L8;
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect r100) {
        if (this.focusedVirtualView != 0) goto L5;
        r100.set(getCloseIconTouchBoundsInt());
        return;
    L5:
        super.getFocusedRect(r100);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        CheckBox.mergeDrawableStates(r101, SELECTED_STATE);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        if (TextUtils.isEmpty(getText()) == true) goto L11;
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L11;
        if (r101.shouldDrawText() == true) goto L11;
        int r102 = r100.save();
        r100.translate(calculateTextOffsetFromStart(this.chipDrawable), 0.0f);
        super.onDraw(r100);
        r100.restoreToCount(r102);
        return;
    L11:
        super.onDraw(r100);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 7) goto L5;
        setCloseIconHovered(getCloseIconTouchBounds().contains(r100.getX(), r100.getY()));
    L10:
        return super.onHoverEvent(r100);
    L5:
        if (r101 != 10) goto L10;
        setCloseIconHovered(false);
        goto L10
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        boolean r102 = getCloseIconTouchBounds().contains(r100.getX(), r100.getY());
        if (r101 == 0) goto L19;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L11;
        if (r101 != 3) goto L22;
    L17:
        boolean r103 = false;
    L18:
        setCloseIconPressed(false);
    L23:
        if (r103 == false) goto L25;
        return true;
    L25:
        if (super.onTouchEvent(r100) == true) goto L30;
        return false;
    L30:
        return true;
    L22:
        r103 = false;
        goto L23
    L11:
        if (this.closeIconPressed == false) goto L22;
        if (r102 == true) goto L21;
        setCloseIconPressed(false);
    L21:
        r103 = true;
        goto L23
    L15:
        if (this.closeIconPressed == false) goto L17;
        performCloseIconClick();
        r103 = true;
        goto L18
    L19:
        if (r102 == false) goto L22;
        setCloseIconPressed(true);
        goto L21
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        if (r100 != this.chipDrawable) goto L5;
    L9:
        super.setBackground(r100);
        return;
    L5:
        if (r100 == this.ripple) goto L9;
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        if (r100 != this.chipDrawable) goto L5;
    L9:
        super.setBackgroundDrawable(r100);
        return;
    L5:
        if (r100 == this.ripple) goto L9;
        throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r100) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r100) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r100) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCheckable(r100);
        return;
    }

    public void setCheckableResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCheckableResource(r100);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 != null) goto L6;
        this.deferredCheckedValue = r100;
        return;
    L6:
        if (r101.isCheckable() == false) goto L14;
        boolean r102 = isChecked();
        super.setChecked(r100);
        if (r102 == r100) goto L15;
        CompoundButton.OnCheckedChangeListener r103 = this.onCheckedChangeListenerInternal;
        if (r103 == null) goto L16;
        r103.onCheckedChanged(this, r100);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setCheckedIcon(Drawable r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCheckedIcon(r100);
        return;
    }

    public void setCheckedIconEnabled(boolean r100) {
        setCheckedIconVisible(r100);
    }

    public void setCheckedIconEnabledResource(int r100) {
        setCheckedIconVisible(r100);
    }

    public void setCheckedIconResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCheckedIconResource(r100);
        return;
    }

    public void setCheckedIconVisible(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCheckedIconVisible(r100);
        return;
    }

    public void setChipBackgroundColor(ColorStateList r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipBackgroundColor(r100);
        return;
    }

    public void setChipBackgroundColorResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipBackgroundColorResource(r100);
        return;
    }

    public void setChipCornerRadius(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipCornerRadius(r100);
        return;
    }

    public void setChipCornerRadiusResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipCornerRadiusResource(r100);
        return;
    }

    public void setChipDrawable(ChipDrawable r100) {
        if (this.chipDrawable == r100) goto L9;
        unapplyChipDrawable(this.chipDrawable);
        this.chipDrawable = r100;
        applyChipDrawable(this.chipDrawable);
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.ripple = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(this.chipDrawable.getRippleColor()), this.chipDrawable, null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        return;
    L7:
        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.setBackground(this, this.chipDrawable);
        return;
    }

    public void setChipEndPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipEndPadding(r100);
        return;
    }

    public void setChipEndPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipEndPaddingResource(r100);
        return;
    }

    public void setChipIcon(Drawable r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIcon(r100);
        return;
    }

    public void setChipIconEnabled(boolean r100) {
        setChipIconVisible(r100);
    }

    public void setChipIconEnabledResource(int r100) {
        setChipIconVisible(r100);
    }

    public void setChipIconResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconResource(r100);
        return;
    }

    public void setChipIconSize(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconSize(r100);
        return;
    }

    public void setChipIconSizeResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconSizeResource(r100);
        return;
    }

    public void setChipIconTint(ColorStateList r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconTint(r100);
        return;
    }

    public void setChipIconTintResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconTintResource(r100);
        return;
    }

    public void setChipIconVisible(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconVisible(r100);
        return;
    }

    public void setChipMinHeight(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipMinHeight(r100);
        return;
    }

    public void setChipMinHeightResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipMinHeightResource(r100);
        return;
    }

    public void setChipStartPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipStartPadding(r100);
        return;
    }

    public void setChipStartPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipStartPaddingResource(r100);
        return;
    }

    public void setChipStrokeColor(ColorStateList r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipStrokeColor(r100);
        return;
    }

    public void setChipStrokeColorResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipStrokeColorResource(r100);
        return;
    }

    public void setChipStrokeWidth(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipStrokeWidth(r100);
        return;
    }

    public void setChipStrokeWidthResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipStrokeWidthResource(r100);
        return;
    }

    public void setChipText(CharSequence r100) {
        setText(r100);
    }

    public void setChipTextResource(int r100) {
        setText(getResources().getString(r100));
    }

    public void setCloseIcon(Drawable r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIcon(r100);
        return;
    }

    public void setCloseIconContentDescription(CharSequence r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconContentDescription(r100);
        return;
    }

    public void setCloseIconEnabled(boolean r100) {
        setCloseIconVisible(r100);
    }

    public void setCloseIconEnabledResource(int r100) {
        setCloseIconVisible(r100);
    }

    public void setCloseIconEndPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconEndPadding(r100);
        return;
    }

    public void setCloseIconEndPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconEndPaddingResource(r100);
        return;
    }

    public void setCloseIconResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconResource(r100);
        return;
    }

    public void setCloseIconSize(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconSize(r100);
        return;
    }

    public void setCloseIconSizeResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconSizeResource(r100);
        return;
    }

    public void setCloseIconStartPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconStartPadding(r100);
        return;
    }

    public void setCloseIconStartPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconStartPaddingResource(r100);
        return;
    }

    public void setCloseIconTint(ColorStateList r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconTint(r100);
        return;
    }

    public void setCloseIconTintResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconTintResource(r100);
        return;
    }

    public void setCloseIconVisible(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconVisible(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r100) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (r100 == TextUtils.TruncateAt.MARQUEE) goto L12;
        super.setEllipsize(r100);
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L13;
        r101.setEllipsize(r100);
        return;
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    @Override // android.widget.TextView
    public void setGravity(int r100) {
        if (r100 != 8388627) goto L7;
        super.setGravity(r100);
        return;
    }

    public void setHideMotionSpec(MotionSpec r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setHideMotionSpec(r100);
        return;
    }

    public void setHideMotionSpecResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setHideMotionSpecResource(r100);
        return;
    }

    public void setIconEndPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setIconEndPadding(r100);
        return;
    }

    public void setIconEndPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setIconEndPaddingResource(r100);
        return;
    }

    public void setIconStartPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setIconStartPadding(r100);
        return;
    }

    public void setIconStartPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setIconStartPaddingResource(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setLines(int r100) {
        if (r100 > 1) goto L7;
        super.setLines(r100);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r100) {
        if (r100 > 1) goto L7;
        super.setMaxLines(r100);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r100) {
        super.setMaxWidth(r100);
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setMaxWidth(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setMinLines(int r100) {
        if (r100 > 1) goto L7;
        super.setMinLines(r100);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener r100) {
        this.onCheckedChangeListenerInternal = r100;
    }

    public void setOnCloseIconClickListener(View.OnClickListener r100) {
        this.onCloseIconClickListener = r100;
    }

    public void setRippleColor(ColorStateList r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setRippleColor(r100);
        return;
    }

    public void setRippleColorResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setRippleColorResource(r100);
        return;
    }

    public void setShowMotionSpec(MotionSpec r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setShowMotionSpec(r100);
        return;
    }

    public void setShowMotionSpecResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setShowMotionSpecResource(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean r100) {
        if (r100 == false) goto L6;
        super.setSingleLine(r100);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r100) {
        super.setTextAppearance(r100);
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setTextAppearanceResource(r100);
    L6:
        if (getTextAppearance() == null) goto L9;
        getTextAppearance().updateMeasureState(getContext(), getPaint(), this.fontCallback);
        updateTextPaintDrawState(getTextAppearance());
        return;
    }

    public void setTextAppearanceResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L5;
        r101.setTextAppearanceResource(r100);
    L5:
        setTextAppearance(getContext(), r100);
    }

    public void setTextEndPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setTextEndPadding(r100);
        return;
    }

    public void setTextEndPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setTextEndPaddingResource(r100);
        return;
    }

    public void setTextStartPadding(float r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setTextStartPadding(r100);
        return;
    }

    public void setTextStartPaddingResource(int r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setTextStartPaddingResource(r100);
        return;
    }

    public void setCheckedIconVisible(boolean r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCheckedIconVisible(r100);
        return;
    }

    public void setChipIconVisible(boolean r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setChipIconVisible(r100);
        return;
    }

    public void setCloseIconVisible(boolean r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setCloseIconVisible(r100);
        return;
    }

    public void setTextAppearance(TextAppearance r100) {
        ChipDrawable r101 = this.chipDrawable;
        if (r101 == null) goto L6;
        r101.setTextAppearance(r100);
    L6:
        if (getTextAppearance() == null) goto L9;
        getTextAppearance().updateMeasureState(getContext(), getPaint(), this.fontCallback);
        updateTextPaintDrawState(r100);
        return;
    }

    public Chip(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.chipStyle);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        int r102 = r101.getKeyCode();
        boolean r103 = false;
        if (r102 == 61) goto L23;
        if (r102 == 66) goto L14;
        switch(r102) {
            case 21: goto L12;
            case 22: goto L9;
            case 23: goto L14;
            default: goto L39;
        };
    L39:
        if (r103 == false) goto L43;
        invalidate();
        return true;
    L43:
        return super.onKeyDown(r100, r101);
    L9:
        if (r101.hasNoModifiers() == false) goto L39;
        r103 = moveFocus(!ViewUtils.isLayoutRtl(this));
        goto L39
    L12:
        if (r101.hasNoModifiers() == false) goto L39;
        r103 = moveFocus(ViewUtils.isLayoutRtl(this));
    L14:
        int r104 = this.focusedVirtualView;
        if (r104 == (-1)) goto L20;
        if (r104 != 0) goto L39;
        performCloseIconClick();
        return true;
    L20:
        performClick();
        return true;
    L23:
        if (r101.hasNoModifiers() == false) goto L26;
        int r105 = 2;
    L29:
        if (r105 == 0) goto L39;
        ViewParent r106 = getParent();
        View r107 = this;
    L31:
        r107 = r107.focusSearch(r105);
        if (r107 == null) goto L36;
        if (r107 == this) goto L36;
        if (r107.getParent() == r106) goto L31;
    L36:
        if (r107 == null) goto L39;
        r107.requestFocus();
        return true;
    L26:
        if (r101.hasModifiers(1) == false) goto L28;
        r105 = 1;
        goto L29
    L28:
        r105 = 0;
        goto L29
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent r100, int r101) {
        if (getCloseIconTouchBounds().contains(r100.getX(), r100.getY()) == true) goto L5;
        return null;
    L5:
        if (isEnabled() == true) goto L7;
        return null;
    L7:
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r101) {
        if (this.chipDrawable != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        CharSequence r102 = BidiFormatter.getInstance().unicodeWrap(r100);
        if (this.chipDrawable.shouldDrawText() == false) goto L10;
        r102 = null;
    L10:
        super.setText(r102, r101);
        ChipDrawable r103 = this.chipDrawable;
        if (r103 == null) goto L14;
        r103.setText(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r100, int r101) {
        super.setTextAppearance(r100, r101);
        ChipDrawable r102 = this.chipDrawable;
        if (r102 == null) goto L6;
        r102.setTextAppearanceResource(r101);
    L6:
        if (getTextAppearance() == null) goto L9;
        getTextAppearance().updateMeasureState(r100, getPaint(), this.fontCallback);
        updateTextPaintDrawState(getTextAppearance());
        return;
    }

    public Chip(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.focusedVirtualView = Integer.MIN_VALUE;
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AnonymousClass1(this);
        validateAttributes(r101);
        ChipDrawable r103 = ChipDrawable.createFromAttributes(r100, r101, r102, R.style.Widget_MaterialComponents_Chip_Action);
        setChipDrawable(r103);
        ChipTouchHelper r104 = new ChipTouchHelper(this, this);
        this.touchHelper = r104;
        ViewCompat.setAccessibilityDelegate(this, r104);
        initOutlineProvider();
        setChecked(this.deferredCheckedValue);
        r103.setShouldDrawText(false);
        setText(r103.getText());
        setEllipsize(r103.getEllipsize());
        setIncludeFontPadding(false);
        if (getTextAppearance() == null) goto L5;
        updateTextPaintDrawState(getTextAppearance());
    L5:
        setSingleLine();
        setGravity(8388627);
        updatePaddingInternal();
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean r100, int r101, Rect r102) {
        if (r100 == false) goto L4;
        setFocusedVirtualView(-1);
    L5:
        invalidate();
        super.onFocusChanged(r100, r101, r102);
        this.touchHelper.onFocusChanged(r100, r101, r102);
        return;
    L4:
        setFocusedVirtualView(Integer.MIN_VALUE);
        goto L5
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        if (r100 != null) goto L9;
        if (r102 != null) goto L7;
        super.setCompoundDrawables(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        if (r100 != null) goto L9;
        if (r102 != null) goto L7;
        super.setCompoundDrawablesRelative(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r100, int r101, int r102, int r103) {
        if (r100 != 0) goto L9;
        if (r102 != 0) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r100, int r101, int r102, int r103) {
        if (r100 != 0) goto L9;
        if (r102 != 0) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        if (r100 != null) goto L9;
        if (r102 != null) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        if (r100 != null) goto L9;
        if (r102 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }
}
