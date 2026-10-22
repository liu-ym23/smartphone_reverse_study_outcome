package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.alipay.sdk.m.u.i;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private GradientDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private float boxCornerRadiusBottomEnd;
    private float boxCornerRadiusBottomStart;
    private float boxCornerRadiusTopEnd;
    private float boxCornerRadiusTopStart;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private final int counterOverflowTextAppearance;
    private boolean counterOverflowed;
    private final int counterTextAppearance;
    private TextView counterView;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    EditText editText;
    private Drawable editTextOriginalDrawable;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private boolean hasReconstructedEditTextBackground;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private PorterDuff.Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    private boolean restoringSavedState;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout r100) {
            this.layout = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r110, AccessibilityNodeInfoCompat r111) {
            super.onInitializeAccessibilityNodeInfo(r110, r111);
            EditText r112 = this.layout.getEditText();
            if (r112 == null) goto L5;
            Editable r113 = r112.getText();
        L6:
            CharSequence r100 = this.layout.getHint();
            CharSequence r101 = this.layout.getError();
            CharSequence r102 = this.layout.getCounterOverflowDescription();
            boolean r103 = !TextUtils.isEmpty(r113);
            boolean r104 = !TextUtils.isEmpty(r100);
            boolean r105 = !TextUtils.isEmpty(r101);
            boolean r106 = false;
            if (r105 == false) goto L9;
        L12:
            boolean r107 = true;
        L13:
            if (r103 == false) goto L15;
            r111.setText(r113);
        L17:
            if (r104 == false) goto L23;
            r111.setHintText(r100);
            if (r103 == true) goto L22;
            if (r104 == false) goto L22;
            r106 = true;
        L22:
            r111.setShowingHintText(r106);
        L23:
            if (r107 == false) goto L29;
            if (r105 == true) goto L27;
            r101 = r102;
        L27:
            r111.setError(r101);
            r111.setContentInvalid(true);
            return;
        L29:
            return;
        L15:
            if (r104 == false) goto L17;
            r111.setText(r100);
            goto L17
        L9:
            if (TextUtils.isEmpty(r102) == false) goto L12;
            r107 = false;
            goto L13
        L5:
            r113 = null;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onPopulateAccessibilityEvent(r100, r101);
            EditText r102 = this.layout.getEditText();
            if (r102 == null) goto L5;
            CharSequence r103 = r102.getText();
        L7:
            if (TextUtils.isEmpty(r103) == false) goto L10;
            r103 = this.layout.getHint();
        L10:
            if (TextUtils.isEmpty(r103) == true) goto L13;
            r101.getText().add(r103);
            return;
        L13:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        CharSequence error;
        boolean isPasswordToggledVisible;

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
            boolean r102 = true;
            if (r100.readInt() == 1) goto L6;
            r102 = false;
        L6:
            this.isPasswordToggledVisible = r102;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            TextUtils.writeToParcel(this.error, r100, r101);
            r100.writeInt(this.isPasswordToggledVisible ? 1 : 0);
        }
    }

    private void applyBoxAttributes() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        setBoxAttributes();
        EditText r100 = this.editText;
        if (r100 != null) goto L8;
    L13:
        EditText r101 = this.editText;
        if (r101 != null) goto L16;
    L20:
        int r102 = this.boxStrokeWidthPx;
        if (r102 <= (-1)) goto L25;
        int r103 = this.boxStrokeColor;
        if (r103 == 0) goto L25;
        this.boxBackground.setStroke(r102, r103);
    L25:
        this.boxBackground.setCornerRadii(getCornerRadiiAsArray());
        this.boxBackground.setColor(this.boxBackgroundColor);
        invalidate();
        return;
    L16:
        if (this.boxBackgroundMode != 1) goto L20;
        Drawable r104 = this.editTextOriginalDrawable;
        if (r104 == null) goto L20;
        ViewCompat.setBackground(r101, r104);
        goto L20
    L8:
        if (this.boxBackgroundMode != 2) goto L13;
        if (r100.getBackground() == null) goto L12;
        this.editTextOriginalDrawable = this.editText.getBackground();
    L12:
        ViewCompat.setBackground(this.editText, null);
        goto L13
    }

    private void applyPasswordToggleTint() {
        Drawable r100 = this.passwordToggleDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.hasPasswordToggleTintList == false) goto L7;
    L8:
        Drawable r101 = DrawableCompat.wrap(r100).mutate();
        this.passwordToggleDrawable = r101;
        if (this.hasPasswordToggleTintList == false) goto L12;
        DrawableCompat.setTintList(r101, this.passwordToggleTintList);
    L12:
        if (this.hasPasswordToggleTintMode == false) goto L14;
        DrawableCompat.setTintMode(this.passwordToggleDrawable, this.passwordToggleTintMode);
    L14:
        CheckableImageButton r102 = this.passwordToggleView;
        if (r102 == null) goto L22;
        Drawable r103 = r102.getDrawable();
        Drawable r104 = this.passwordToggleDrawable;
        if (r103 == r104) goto L23;
        this.passwordToggleView.setImageDrawable(r104);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (this.hasPasswordToggleTintMode == true) goto L8;
    }

    private void assignBoxBackgroundByMode() {
        int r100 = this.boxBackgroundMode;
        if (r100 != 0) goto L6;
        this.boxBackground = null;
        return;
    L6:
        if (r100 != 2) goto L13;
        if (this.hintEnabled == false) goto L13;
        if ((this.boxBackground instanceof CutoutDrawable) == true) goto L13;
        this.boxBackground = new CutoutDrawable();
        return;
    L13:
        if ((this.boxBackground instanceof GradientDrawable) == true) goto L18;
        this.boxBackground = new GradientDrawable();
        return;
    }

    private int calculateBoxBackgroundTop() {
        EditText r100 = this.editText;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = this.boxBackgroundMode;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L11;
        return 0;
    L11:
        return r100.getTop() + calculateLabelMarginTop();
    L13:
        return r100.getTop();
    }

    private int calculateCollapsedTextTopBounds() {
        int r100 = this.boxBackgroundMode;
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return getPaddingTop();
    L9:
        return getBoxBackground().getBounds().top - calculateLabelMarginTop();
    L11:
        return getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
    }

    private int calculateLabelMarginTop() {
        if (this.hintEnabled == true) goto L5;
        return 0;
    L5:
        int r100 = this.boxBackgroundMode;
        if (r100 != 0) goto L8;
    L15:
        float r101 = this.collapsingTextHelper.getCollapsedTextHeight();
    L14:
        return (int) r101;
    L8:
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L12;
        return 0;
    L12:
        r101 = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        goto L14
    }

    private boolean cutoutEnabled() {
        if (this.hintEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.hint) == true) goto L9;
        if ((this.boxBackground instanceof CutoutDrawable) == false) goto L9;
        return true;
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 21) goto L5;
    L7:
        Drawable r101 = this.editText.getBackground();
        if (r101 != null) goto L11;
        return;
    L11:
        if (this.hasReconstructedEditTextBackground == true) goto L19;
        Drawable r102 = r101.getConstantState().newDrawable();
        if ((r101 instanceof DrawableContainer) == false) goto L16;
        this.hasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer) r101, r102.getConstantState());
    L16:
        if (this.hasReconstructedEditTextBackground == true) goto L20;
        ViewCompat.setBackground(this.editText, r102);
        this.hasReconstructedEditTextBackground = true;
        onApplyBoxBackgroundMode();
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r100 == 22) goto L7;
    }

    private Drawable getBoxBackground() {
        int r100 = this.boxBackgroundMode;
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.boxBackground;
    }

    private boolean hasPasswordTransformation() {
        EditText r100 = this.editText;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r100.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        return true;
    }

    private void setBoxAttributes() {
        int r100 = this.boxBackgroundMode;
        if (r100 != 1) goto L5;
        this.boxStrokeWidthPx = 0;
        return;
    L5:
        if (r100 == 2) goto L8;
        return;
    L8:
        if (this.focusedStrokeColor != 0) goto L12;
        this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
        return;
    }

    private boolean shouldShowPasswordIcon() {
        if (this.passwordToggleEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (hasPasswordTransformation() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.passwordToggledVisible == false) goto L9;
        goto L8
    }

    private void updateEditTextBackgroundBounds() {
        EditText r100 = this.editText;
        if (r100 != null) goto L5;
        return;
    L5:
        Drawable r101 = r100.getBackground();
        if (r101 != null) goto L9;
        return;
    L9:
        if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r101) == false) goto L11;
        r101 = r101.mutate();
    L11:
        Rect r102 = new Rect();
        DescendantOffsetUtils.getDescendantRect(this, this.editText, r102);
        Rect r103 = r101.getBounds();
        if (r103.left == r103.right) goto L15;
        Rect r104 = new Rect();
        r101.getPadding(r104);
        int r105 = r103.left - r104.left;
        int r106 = r103.right + (r104.right * 2);
        r101.setBounds(r105, r103.top, r106, this.editText.getBottom());
        return;
    }

    private void updateInputLayoutMargins() {
        LinearLayout.LayoutParams r100 = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int r101 = calculateLabelMarginTop();
        if (r101 == r100.topMargin) goto L6;
        r100.topMargin = r101;
        this.inputFrame.requestLayout();
        return;
    }

    private void updatePasswordToggleView() {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (shouldShowPasswordIcon() == true) goto L8;
        CheckableImageButton r100 = this.passwordToggleView;
        if (r100 == null) goto L28;
        if (r100.getVisibility() != 0) goto L28;
        this.passwordToggleView.setVisibility(8);
    L28:
        if (this.passwordToggleDummyDrawable == null) goto L34;
        Drawable[] r101 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        if (r101[2] != this.passwordToggleDummyDrawable) goto L35;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r101[0], r101[1], this.originalEditTextEndDrawable, r101[3]);
        this.passwordToggleDummyDrawable = null;
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (this.passwordToggleView != null) goto L10;
        CheckableImageButton r102 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, this.inputFrame, false);
        this.passwordToggleView = r102;
        r102.setImageDrawable(this.passwordToggleDrawable);
        this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
        this.inputFrame.addView(this.passwordToggleView);
        this.passwordToggleView.setOnClickListener(new AnonymousClass2(this));
    L10:
        EditText r103 = this.editText;
        if (r103 != null) goto L13;
    L15:
        this.passwordToggleView.setVisibility(0);
        this.passwordToggleView.setChecked(this.passwordToggledVisible);
        if (this.passwordToggleDummyDrawable != null) goto L18;
        this.passwordToggleDummyDrawable = new ColorDrawable();
    L18:
        this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
        Drawable[] r104 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r105 = r104[2];
        Drawable r106 = this.passwordToggleDummyDrawable;
        if (r105 == r106) goto L21;
        this.originalEditTextEndDrawable = r105;
    L21:
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r104[0], r104[1], r106, r104[3]);
        this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
        return;
    L13:
        if (ViewCompat.getMinimumHeight(r103) > 0) goto L15;
        this.editText.setMinimumHeight(ViewCompat.getMinimumHeight(this.passwordToggleView));
        goto L15
    }

    private void updateTextInputBoxBounds() {
        if (this.boxBackgroundMode != 0) goto L5;
        return;
    L5:
        if (this.boxBackground != null) goto L7;
        return;
    L7:
        if (this.editText != null) goto L9;
        return;
    L9:
        if (getRight() == 0) goto L19;
        int r100 = this.editText.getLeft();
        int r101 = calculateBoxBackgroundTop();
        int r102 = this.editText.getRight();
        int r103 = this.editText.getBottom() + this.boxBottomOffsetPx;
        if (this.boxBackgroundMode != 2) goto L14;
        int r104 = this.boxStrokeWidthFocusedPx;
        r100 = r100 + (r104 / 2);
        r101 = r101 - (r104 / 2);
        r102 = r102 - (r104 / 2);
        r103 = r103 + (r104 / 2);
    L14:
        this.boxBackground.setBounds(r100, r101, r102, r103);
        applyBoxAttributes();
        updateEditTextBackgroundBounds();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.inDrawableStateChanged == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] r101 = getDrawableState();
        if (ViewCompat.isLaidOut(this) == true) goto L8;
    L10:
        r100 = false;
    L11:
        updateLabelState(r100);
        updateEditTextBackground();
        updateTextInputBoxBounds();
        updateTextInputBoxState();
        CollapsingTextHelper r102 = this.collapsingTextHelper;
        if (r102 == null) goto L14;
        boolean r103 = r102.setState(r101) | false;
    L15:
        if (r103 == false) goto L17;
        invalidate();
    L17:
        this.inDrawableStateChanged = false;
        return;
    L14:
        r103 = false;
        goto L15
    L8:
        if (isEnabled() == false) goto L10;
        goto L10
    }

    public CharSequence getCounterOverflowDescription() {
        if (this.counterEnabled == true) goto L5;
        return null;
    L5:
        if (this.counterOverflowed == false) goto L12;
        TextView r100 = this.counterView;
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getContentDescription();
    L12:
        return null;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getErrorText();
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getHelperText();
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public CharSequence getHint() {
        if (this.hintEnabled == true) goto L7;
        return null;
    L7:
        return this.hint;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public void updateEditTextBackground() {
        EditText r100 = this.editText;
        if (r100 != null) goto L5;
        return;
    L5:
        Drawable r101 = r100.getBackground();
        if (r101 != null) goto L8;
        return;
    L8:
        ensureBackgroundDrawableStateWorkaround();
        if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r101) == false) goto L12;
        r101 = r101.mutate();
    L12:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L15;
        r101.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L15:
        if (this.counterOverflowed == false) goto L19;
        TextView r102 = this.counterView;
        if (r102 == null) goto L19;
        r101.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r102.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L19:
        DrawableCompat.clearColorFilter(r101);
        this.editText.refreshDrawableState();
    }

    public void updateTextInputBoxState() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 0) goto L47;
        EditText r100 = this.editText;
        boolean r101 = true;
        if (r100 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        EditText r103 = this.editText;
        if (r103 != null) goto L16;
    L18:
        r101 = false;
    L20:
        if (this.boxBackgroundMode == 2) goto L22;
        return;
    L22:
        if (isEnabled() == true) goto L25;
        this.boxStrokeColor = this.disabledColor;
    L37:
        if (r101 == true) goto L40;
        if (r102 == true) goto L40;
    L42:
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    L43:
        applyBoxAttributes();
        return;
    L40:
        if (isEnabled() == false) goto L42;
        this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        goto L43
    L25:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L28;
        this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
        goto L37
    L28:
        if (this.counterOverflowed == false) goto L32;
        TextView r104 = this.counterView;
        if (r104 == null) goto L32;
        this.boxStrokeColor = r104.getCurrentTextColor();
    L32:
        if (r102 == false) goto L34;
        this.boxStrokeColor = this.focusedStrokeColor;
        goto L37
    L34:
        if (r101 == false) goto L36;
        this.boxStrokeColor = this.hoveredStrokeColor;
        goto L37
    L36:
        this.boxStrokeColor = this.defaultStrokeColor;
        goto L37
    L16:
        if (r103.isHovered() == false) goto L18;
    L10:
        if (r100.hasFocus() == false) goto L12;
        r102 = true;
        goto L13
    }

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private float[] getCornerRadiiAsArray() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L6;
        float r100 = this.boxCornerRadiusTopStart;
        float r101 = this.boxCornerRadiusTopEnd;
        float r102 = this.boxCornerRadiusBottomEnd;
        float r103 = this.boxCornerRadiusBottomStart;
        return new float[]{r100, r100, r101, r101, r102, r102, r103, r103};
    L6:
        float r104 = this.boxCornerRadiusTopEnd;
        float r105 = this.boxCornerRadiusTopStart;
        float r106 = this.boxCornerRadiusBottomStart;
        float r107 = this.boxCornerRadiusBottomEnd;
        return new float[]{r104, r104, r105, r105, r106, r106, r107, r107};
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        if (this.boxBackgroundMode == 0) goto L5;
        updateInputLayoutMargins();
    L5:
        updateTextInputBoxBounds();
    }

    private void openCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        RectF r100 = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(r100);
        applyCutoutPadding(r100);
        ((CutoutDrawable) this.boxBackground).setCutout(r100);
    }

    public boolean cutoutIsOpen() {
        if (cutoutEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L5;
        r100.error = getError();
    L5:
        r100.isPasswordToggledVisible = this.passwordToggledVisible;
        return r100;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxCornerRadiusBottomEnd;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxCornerRadiusBottomStart;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxCornerRadiusTopEnd;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxCornerRadiusTopStart;
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public TextInputLayout(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ boolean access$000(TextInputLayout r100) {
        return r100.restoringSavedState;
    }

    private void applyCutoutPadding(RectF r100) {
        float r101 = r100.left;
        int r102 = this.boxLabelCutoutPaddingPx;
        r100.left = r101 - r102;
        r100.top -= r102;
        r100.right += r102;
        r100.bottom += r102;
    }

    private void collapseHint(boolean r100) {
        ValueAnimator r101 = this.animator;
        if (r101 == null) goto L8;
        if (r101.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r100 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(1.0f);
    L13:
        this.hintExpanded = false;
        if (cutoutEnabled() == false) goto L17;
        openCutout();
        return;
    L17:
        return;
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(1.0f);
        goto L13
    }

    private void expandHint(boolean r100) {
        ValueAnimator r101 = this.animator;
        if (r101 == null) goto L8;
        if (r101.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r100 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(0.0f);
    L14:
        if (cutoutEnabled() == true) goto L16;
    L18:
        this.hintExpanded = true;
        return;
    L16:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L18;
        closeCutout();
        goto L18
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(0.0f);
        goto L14
    }

    private void setEditText(EditText r100) {
        if (this.editText != null) goto L22;
        boolean r101 = r100 instanceof TextInputEditText;
        this.editText = r100;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        if (hasPasswordTransformation() == true) goto L7;
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
    L7:
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r102 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r102 & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r102);
        this.editText.addTextChangedListener(new AnonymousClass1(this));
        if (this.defaultHintTextColor != null) goto L11;
        this.defaultHintTextColor = this.editText.getHintTextColors();
    L11:
        if (this.hintEnabled == false) goto L17;
        if (TextUtils.isEmpty(this.hint) == false) goto L15;
        CharSequence r103 = this.editText.getHint();
        this.originalHint = r103;
        setHint(r103);
        this.editText.setHint(null);
    L15:
        this.isProvidingHint = true;
    L17:
        if (this.counterView == null) goto L19;
        updateCounter(this.editText.getText().length());
    L19:
        this.indicatorViewController.adjustIndicatorPadding();
        updatePasswordToggleView();
        updateLabelState(false, true);
        return;
    L22:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence r100) {
        if (TextUtils.equals(r100, this.hint) == true) goto L8;
        this.hint = r100;
        this.collapsingTextHelper.setText(r100);
        if (this.hintExpanded == true) goto L9;
        openCutout();
        return;
    L9:
        return;
    }

    public void animateToExpansionFraction(float r100) {
        if (this.collapsingTextHelper.getExpansionFraction() != r100) goto L6;
        return;
    L6:
        if (this.animator != null) goto L8;
        ValueAnimator r101 = new ValueAnimator();
        this.animator = r101;
        r101.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.animator.setDuration(167);
        this.animator.addUpdateListener(new AnonymousClass3(this));
    L8:
        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), r100});
        this.animator.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r100) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(r100);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        GradientDrawable r101 = this.boxBackground;
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        super.draw(r100);
        if (this.hintEnabled == false) goto L9;
        this.collapsingTextHelper.draw(r100);
        return;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setError(r101.error);
        if (r101.isPasswordToggledVisible == false) goto L9;
        passwordVisibilityToggleRequested(true);
    L9:
        requestLayout();
    }

    public void passwordVisibilityToggleRequested(boolean r100) {
        if (this.passwordToggleEnabled == false) goto L13;
        int r101 = this.editText.getSelectionEnd();
        if (hasPasswordTransformation() == false) goto L7;
        this.editText.setTransformationMethod(null);
        this.passwordToggledVisible = true;
    L8:
        this.passwordToggleView.setChecked(this.passwordToggledVisible);
        if (r100 == false) goto L11;
        this.passwordToggleView.jumpDrawablesToCurrentState();
    L11:
        this.editText.setSelection(r101);
        return;
    L7:
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordToggledVisible = false;
        goto L8
    }

    public void setBoxBackgroundColor(int r100) {
        if (this.boxBackgroundColor == r100) goto L6;
        this.boxBackgroundColor = r100;
        applyBoxAttributes();
        return;
    }

    public void setBoxBackgroundColorResource(int r100) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setBoxBackgroundMode(int r100) {
        if (r100 != this.boxBackgroundMode) goto L5;
        return;
    L5:
        this.boxBackgroundMode = r100;
        onApplyBoxBackgroundMode();
    }

    public void setBoxStrokeColor(int r100) {
        if (this.focusedStrokeColor == r100) goto L6;
        this.focusedStrokeColor = r100;
        updateTextInputBoxState();
        return;
    }

    public void setCounterEnabled(boolean r100) {
        if (this.counterEnabled != r100) goto L5;
        return;
    L5:
        if (r100 == false) goto L13;
        AppCompatTextView r101 = new AppCompatTextView(getContext());
        this.counterView = r101;
        r101.setId(R.id.textinput_counter);
        Typeface r102 = this.typeface;
        if (r102 == null) goto L9;
        this.counterView.setTypeface(r102);
    L9:
        this.counterView.setMaxLines(1);
        setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
        this.indicatorViewController.addIndicator(this.counterView, 2);
        EditText r103 = this.editText;
        if (r103 != null) goto L12;
        updateCounter(0);
    L14:
        this.counterEnabled = r100;
        return;
    L12:
        updateCounter(r103.getText().length());
        goto L14
    L13:
        this.indicatorViewController.removeIndicator(this.counterView, 2);
        this.counterView = null;
        goto L14
    }

    public void setCounterMaxLength(int r100) {
        if (this.counterMaxLength == r100) goto L15;
        if (r100 <= 0) goto L6;
        this.counterMaxLength = r100;
    L8:
        if (this.counterEnabled == false) goto L16;
        EditText r101 = this.editText;
        if (r101 != null) goto L12;
        int r102 = 0;
    L13:
        updateCounter(r102);
        return;
    L12:
        r102 = r101.getText().length();
        goto L13
    L16:
        return;
    L6:
        this.counterMaxLength = -1;
        goto L8
    }

    public void setDefaultHintTextColor(ColorStateList r100) {
        this.defaultHintTextColor = r100;
        this.focusedTextColor = r100;
        if (this.editText == null) goto L6;
        updateLabelState(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        recursiveSetEnabled(this, r100);
        super.setEnabled(r100);
    }

    public void setError(CharSequence r100) {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L9;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        this.indicatorViewController.showError(r100);
        return;
    L11:
        this.indicatorViewController.hideError();
    }

    public void setErrorEnabled(boolean r100) {
        this.indicatorViewController.setErrorEnabled(r100);
    }

    public void setErrorTextAppearance(int r100) {
        this.indicatorViewController.setErrorTextAppearance(r100);
    }

    public void setErrorTextColor(ColorStateList r100) {
        this.indicatorViewController.setErrorViewTextColor(r100);
    }

    public void setHelperText(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        if (isHelperTextEnabled() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (isHelperTextEnabled() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.indicatorViewController.showHelper(r100);
    }

    public void setHelperTextColor(ColorStateList r100) {
        this.indicatorViewController.setHelperTextViewTextColor(r100);
    }

    public void setHelperTextEnabled(boolean r100) {
        this.indicatorViewController.setHelperTextEnabled(r100);
    }

    public void setHelperTextTextAppearance(int r100) {
        this.indicatorViewController.setHelperTextAppearance(r100);
    }

    public void setHint(CharSequence r100) {
        if (this.hintEnabled == false) goto L6;
        setHintInternal(r100);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHintAnimationEnabled(boolean r100) {
        this.hintAnimationEnabled = r100;
    }

    public void setHintEnabled(boolean r100) {
        if (r100 == this.hintEnabled) goto L23;
        this.hintEnabled = r100;
        if (r100 == true) goto L12;
        this.isProvidingHint = false;
        if (TextUtils.isEmpty(this.hint) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.editText == null) goto L24;
        updateInputLayoutMargins();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.editText.getHint()) == false) goto L11;
        this.editText.setHint(this.hint);
        goto L11
    L12:
        CharSequence r101 = this.editText.getHint();
        if (TextUtils.isEmpty(r101) == false) goto L15;
    L18:
        this.isProvidingHint = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        setHint(r101);
    L17:
        this.editText.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(int r100) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r100);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) goto L6;
        updateLabelState(false);
        updateInputLayoutMargins();
        return;
    }

    public void setPasswordVisibilityToggleContentDescription(int r100) {
        if (r100 == 0) goto L4;
        CharSequence r101 = getResources().getText(r100);
    L5:
        setPasswordVisibilityToggleContentDescription(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setPasswordVisibilityToggleDrawable(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
    L5:
        setPasswordVisibilityToggleDrawable(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setPasswordVisibilityToggleEnabled(boolean r100) {
        if (this.passwordToggleEnabled == r100) goto L13;
        this.passwordToggleEnabled = r100;
        if (r100 == false) goto L7;
    L11:
        this.passwordToggledVisible = false;
        updatePasswordToggleView();
        return;
    L7:
        if (this.passwordToggledVisible == false) goto L11;
        EditText r101 = this.editText;
        if (r101 == null) goto L11;
        r101.setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L11
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList r100) {
        this.passwordToggleTintList = r100;
        this.hasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r100) {
        this.passwordToggleTintMode = r100;
        this.hasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate r100) {
        EditText r101 = this.editText;
        if (r101 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r101, r100);
        return;
    }

    public void setTypeface(Typeface r100) {
        if (r100 == this.typeface) goto L8;
        this.typeface = r100;
        this.collapsingTextHelper.setTypefaces(r100);
        this.indicatorViewController.setTypefaces(r100);
        TextView r101 = this.counterView;
        if (r101 == null) goto L9;
        r101.setTypeface(r100);
        return;
    L9:
        return;
    }

    public void updateCounter(int r100) {
        boolean r101 = this.counterOverflowed;
        if (this.counterMaxLength != (-1)) goto L6;
        this.counterView.setText(String.valueOf(r100));
        this.counterView.setContentDescription(null);
        this.counterOverflowed = false;
    L23:
        if (this.editText != null) goto L25;
        return;
    L25:
        if (r101 == this.counterOverflowed) goto L29;
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
        return;
    L29:
        return;
    L6:
        if (ViewCompat.getAccessibilityLiveRegion(this.counterView) != 1) goto L9;
        ViewCompat.setAccessibilityLiveRegion(this.counterView, 0);
    L9:
        if (r100 <= this.counterMaxLength) goto L11;
        boolean r102 = true;
    L12:
        this.counterOverflowed = r102;
        if (r101 == r102) goto L21;
        TextView r103 = this.counterView;
        if (r102 == false) goto L17;
        int r104 = this.counterOverflowTextAppearance;
    L18:
        setTextAppearanceCompatWithErrorFallback(r103, r104);
        if (this.counterOverflowed == false) goto L21;
        ViewCompat.setAccessibilityLiveRegion(this.counterView, 1);
        goto L21
    L17:
        r104 = this.counterTextAppearance;
    L21:
        this.counterView.setText(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(r100), Integer.valueOf(this.counterMaxLength)}));
        this.counterView.setContentDescription(getContext().getString(R.string.character_counter_content_description, new Object[]{Integer.valueOf(r100), Integer.valueOf(this.counterMaxLength)}));
        goto L23
    L11:
        r102 = false;
        goto L12
    }

    public void updateLabelState(boolean r100) {
        updateLabelState(r100, false);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence r100) {
        this.passwordToggleContentDesc = r100;
        CheckableImageButton r101 = this.passwordToggleView;
        if (r101 == null) goto L6;
        r101.setContentDescription(r100);
        return;
    }

    public void setPasswordVisibilityToggleDrawable(Drawable r100) {
        this.passwordToggleDrawable = r100;
        CheckableImageButton r101 = this.passwordToggleView;
        if (r101 == null) goto L6;
        r101.setImageDrawable(r100);
        return;
    }

    public TextInputLayout(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textInputStyle);
    }

    private static void recursiveSetEnabled(ViewGroup r100, boolean r101) {
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r100.getChildAt(r103);
        r104.setEnabled(r101);
        if ((r104 instanceof ViewGroup) == false) goto L7;
        recursiveSetEnabled((ViewGroup) r104, r101);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    private void updateLabelState(boolean r100, boolean r101) {
        boolean r102 = isEnabled();
        EditText r103 = this.editText;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        EditText r106 = this.editText;
        if (r106 != null) goto L11;
    L13:
        r104 = false;
    L14:
        boolean r107 = this.indicatorViewController.errorShouldBeShown();
        ColorStateList r108 = this.defaultHintTextColor;
        if (r108 == null) goto L17;
        this.collapsingTextHelper.setCollapsedTextColor(r108);
        this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
    L17:
        if (r102 == true) goto L19;
        this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
        this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.disabledColor));
    L30:
        if (r105 == false) goto L32;
    L40:
        if (r101 == false) goto L42;
    L43:
        collapseHint(r100);
        return;
    L42:
        if (this.hintExpanded == true) goto L43;
        return;
    L32:
        if (isEnabled() == false) goto L36;
        if (r104 == true) goto L40;
        if (r107 == true) goto L40;
    L36:
        if (r101 == false) goto L38;
    L39:
        expandHint(r100);
        return;
    L38:
        if (this.hintExpanded == false) goto L39;
        return;
    L19:
        if (r107 == false) goto L22;
        this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        goto L30
    L22:
        if (this.counterOverflowed == false) goto L26;
        TextView r109 = this.counterView;
        if (r109 == null) goto L26;
        this.collapsingTextHelper.setCollapsedTextColor(r109.getTextColors());
    L26:
        if (r104 == false) goto L30;
        ColorStateList r110 = this.focusedTextColor;
        if (r110 == null) goto L30;
        this.collapsingTextHelper.setCollapsedTextColor(r110);
        goto L30
    L11:
        if (r106.hasFocus() == false) goto L13;
    L5:
        if (TextUtils.isEmpty(r103.getText()) == true) goto L7;
        r105 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure r100, int r101) {
        if (this.originalHint == null) goto L14;
        EditText r102 = this.editText;
        if (r102 == null) goto L14;
        boolean r103 = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence r104 = r102.getHint();
        this.editText.setHint(this.originalHint);
        super.dispatchProvideAutofillStructure(r100, r101);     // Catch: Throwable -> L11
        this.editText.setHint(r104);
        this.isProvidingHint = r103;
        return;
    L11:
        th = move-exception;
        this.editText.setHint(r104);
        this.isProvidingHint = r103;
        throw th;
    L14:
        super.dispatchProvideAutofillStructure(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        updatePasswordToggleView();
        super.onMeasure(r100, r101);
    }

    public void setTextAppearanceCompatWithErrorFallback(TextView r100, int r101) {
        boolean r102 = true;
        TextViewCompat.setTextAppearance(r100, r101);     // Catch: Exception -> L10
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r100.getTextColors().getDefaultColor() == (-65281)) goto L11;
    L9:
        r102 = false;
    L11:
        if (r102 == false) goto L16;
        TextViewCompat.setTextAppearance(r100, R.style.TextAppearance_AppCompat_Caption);
        r100.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
        return;
    }

    public TextInputLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpRectF = new RectF();
        CollapsingTextHelper r100 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r100;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r101 = new FrameLayout(r110);
        this.inputFrame = r101;
        r101.setAddStatesFromChildren(true);
        addView(r101);
        TimeInterpolator r102 = AnimationUtils.LINEAR_INTERPOLATOR;
        r100.setTextSizeInterpolator(r102);
        r100.setPositionInterpolator(r102);
        r100.setCollapsedTextGravity(8388659);
        TintTypedArray r113 = ThemeEnforcement.obtainTintedStyledAttributes(r110, r111, new int[]{android.R.attr.textColorHint, android.R.attr.hint, R.attr.boxBackgroundColor, R.attr.boxBackgroundMode, R.attr.boxCollapsedPaddingTop, R.attr.boxCornerRadiusBottomEnd, R.attr.boxCornerRadiusBottomStart, R.attr.boxCornerRadiusTopEnd, R.attr.boxCornerRadiusTopStart, R.attr.boxStrokeColor, R.attr.boxStrokeWidth, R.attr.counterEnabled, R.attr.counterMaxLength, R.attr.counterOverflowTextAppearance, R.attr.counterTextAppearance, R.attr.errorEnabled, R.attr.errorTextAppearance, R.attr.helperText, R.attr.helperTextEnabled, R.attr.helperTextTextAppearance, R.attr.hintAnimationEnabled, R.attr.hintEnabled, R.attr.hintTextAppearance, R.attr.passwordToggleContentDescription, R.attr.passwordToggleDrawable, R.attr.passwordToggleEnabled, R.attr.passwordToggleTint, R.attr.passwordToggleTintMode}, r112, R.style.Widget_Design_TextInputLayout, new int[0]);
        this.hintEnabled = r113.getBoolean(21, true);
        setHint(r113.getText(1));
        this.hintAnimationEnabled = r113.getBoolean(20, true);
        this.boxBottomOffsetPx = r110.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_bottom_offset);
        this.boxLabelCutoutPaddingPx = r110.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r113.getDimensionPixelOffset(4, 0);
        this.boxCornerRadiusTopStart = r113.getDimension(8, 0.0f);
        this.boxCornerRadiusTopEnd = r113.getDimension(7, 0.0f);
        this.boxCornerRadiusBottomEnd = r113.getDimension(5, 0.0f);
        this.boxCornerRadiusBottomStart = r113.getDimension(6, 0.0f);
        this.boxBackgroundColor = r113.getColor(2, 0);
        this.focusedStrokeColor = r113.getColor(9, 0);
        int r103 = r110.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default);
        this.boxStrokeWidthDefaultPx = r103;
        this.boxStrokeWidthFocusedPx = r110.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused);
        this.boxStrokeWidthPx = r103;
        setBoxBackgroundMode(r113.getInt(3, 0));
        if (r113.hasValue(0) == false) goto L5;
        ColorStateList r104 = r113.getColorStateList(0);
        this.focusedTextColor = r104;
        this.defaultHintTextColor = r104;
    L5:
        this.defaultStrokeColor = ContextCompat.getColor(r110, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(r110, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(r110, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r113.getResourceId(22, -1) == (-1)) goto L8;
        setHintTextAppearance(r113.getResourceId(22, 0));
    L8:
        int r114 = r113.getResourceId(16, 0);
        boolean r105 = r113.getBoolean(15, false);
        int r106 = r113.getResourceId(19, 0);
        boolean r107 = r113.getBoolean(18, false);
        CharSequence r108 = r113.getText(17);
        boolean r109 = r113.getBoolean(11, false);
        setCounterMaxLength(r113.getInt(12, -1));
        this.counterTextAppearance = r113.getResourceId(14, 0);
        this.counterOverflowTextAppearance = r113.getResourceId(13, 0);
        this.passwordToggleEnabled = r113.getBoolean(25, false);
        this.passwordToggleDrawable = r113.getDrawable(24);
        this.passwordToggleContentDesc = r113.getText(23);
        if (r113.hasValue(26) == false) goto L12;
        this.hasPasswordToggleTintList = true;
        this.passwordToggleTintList = r113.getColorStateList(26);
    L12:
        if (r113.hasValue(27) == false) goto L14;
        this.hasPasswordToggleTintMode = true;
        this.passwordToggleTintMode = ViewUtils.parseTintMode(r113.getInt(27, -1), null);
    L14:
        r113.recycle();
        setHelperTextEnabled(r107);
        setHelperText(r108);
        setHelperTextTextAppearance(r106);
        setErrorEnabled(r105);
        setErrorTextAppearance(r114);
        setCounterEnabled(r109);
        applyPasswordToggleTint();
        ViewCompat.setImportantForAccessibility(this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if ((r100 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(r102);
        r103.gravity = (r103.gravity & (-113)) | 16;
        this.inputFrame.addView(r100, r103);
        this.inputFrame.setLayoutParams(r102);
        updateInputLayoutMargins();
        setEditText((EditText) r100);
        return;
    L5:
        super.addView(r100, r101, r102);
    }

    public void setBoxCornerRadii(float r100, float r101, float r102, float r103) {
        if (this.boxCornerRadiusTopStart == r100) goto L5;
    L10:
        this.boxCornerRadiusTopStart = r100;
        this.boxCornerRadiusTopEnd = r101;
        this.boxCornerRadiusBottomEnd = r103;
        this.boxCornerRadiusBottomStart = r102;
        applyBoxAttributes();
        return;
    L5:
        if (this.boxCornerRadiusTopEnd != r101) goto L10;
        if (this.boxCornerRadiusBottomEnd != r103) goto L10;
        if (this.boxCornerRadiusBottomStart != r102) goto L10;
    }

    public void setBoxCornerRadiiResources(int r100, int r101, int r102, int r103) {
        setBoxCornerRadii(getContext().getResources().getDimension(r100), getContext().getResources().getDimension(r101), getContext().getResources().getDimension(r102), getContext().getResources().getDimension(r103));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.boxBackground == null) goto L6;
        updateTextInputBoxBounds();
    L6:
        if (this.hintEnabled == false) goto L15;
        EditText r105 = this.editText;
        if (r105 == null) goto L16;
        Rect r106 = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, r105, r106);
        int r107 = r106.left + this.editText.getCompoundPaddingLeft();
        int r108 = r106.right - this.editText.getCompoundPaddingRight();
        int r109 = calculateCollapsedTextTopBounds();
        this.collapsingTextHelper.setExpandedBounds(r107, r106.top + this.editText.getCompoundPaddingTop(), r108, r106.bottom - this.editText.getCompoundPaddingBottom());
        this.collapsingTextHelper.setCollapsedBounds(r107, r109, r108, (r104 - r102) - getPaddingBottom());
        this.collapsingTextHelper.recalculate();
        if (cutoutEnabled() == true) goto L12;
        return;
    L12:
        if (this.hintExpanded == true) goto L18;
        openCutout();
        return;
    L18:
        return;
    L16:
        return;
    }
}
