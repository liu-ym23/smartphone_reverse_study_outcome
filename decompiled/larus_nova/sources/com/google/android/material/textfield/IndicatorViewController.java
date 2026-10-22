package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.legacy.widget.Space;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
final class IndicatorViewController {
    private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    static final int COUNTER_INDEX = 2;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private int captionToShow;
    private final float captionTranslationYPx;
    private int captionViewsAdded;
    private final Context context;
    private boolean errorEnabled;
    private CharSequence errorText;
    private int errorTextAppearance;
    private TextView errorView;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;
    private TextView helperTextView;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;
    private final TextInputLayout textInputView;
    private Typeface typeface;

    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) goto L5;
    L10:
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
        return;
    L5:
        if (this.helperTextEnabled == true) goto L7;
    L9:
        this.captionToShow = 0;
        goto L10
    L7:
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        this.captionToShow = 2;
        goto L10
    }

    public boolean isCaptionView(int r100) {
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private boolean canAdjustIndicatorPadding() {
        if (this.indicatorArea != null) goto L5;
    L7:
        return false;
    L5:
        if (this.textInputView.getEditText() == null) goto L7;
        return true;
    }

    public void cancelCaptionAnimator() {
        Animator r100 = this.captionAnimator;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    public boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    public int getErrorViewCurrentTextColor() {
        TextView r100 = this.errorView;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getCurrentTextColor();
    }

    public ColorStateList getErrorViewTextColors() {
        TextView r100 = this.errorView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTextColors();
    }

    public ColorStateList getHelperTextViewColors() {
        TextView r100 = this.helperTextView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTextColors();
    }

    public int getHelperTextViewCurrentTextColor() {
        TextView r100 = this.helperTextView;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getCurrentTextColor();
    }

    public boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    public boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    public void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding() == false) goto L6;
        ViewCompat.setPaddingRelative(this.indicatorArea, ViewCompat.getPaddingStart(this.textInputView.getEditText()), 0, ViewCompat.getPaddingEnd(this.textInputView.getEditText()), 0);
        return;
    }

    public void hideHelperText() {
        cancelCaptionAnimator();
        int r100 = this.captionDisplayed;
        if (r100 != 2) goto L5;
        this.captionToShow = 0;
    L5:
        updateCaptionViewsVisibility(r100, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
    }

    public CharSequence getErrorText() {
        return this.errorText;
    }

    public CharSequence getHelperText() {
        return this.helperText;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    public IndicatorViewController(TextInputLayout r100) {
        Context r101 = r100.getContext();
        this.context = r101;
        this.textInputView = r100;
        this.captionTranslationYPx = r101.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public static /* synthetic */ TextView access$200(IndicatorViewController r100) {
        return r100.errorView;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
        r101.setDuration(217);
        r101.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return r101;
    }

    private TextView getCaptionViewFromDisplayState(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return this.helperTextView;
    L11:
        return this.errorView;
    }

    private boolean isCaptionStateError(int r100) {
        if (r100 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.errorView == null) goto L9;
        if (TextUtils.isEmpty(this.errorText) == true) goto L9;
        return true;
    }

    private boolean isCaptionStateHelperText(int r100) {
        if (r100 == 2) goto L5;
    L9:
        return false;
    L5:
        if (this.helperTextView == null) goto L9;
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        return true;
    }

    public void setErrorEnabled(boolean r100) {
        if (this.errorEnabled != r100) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r100 == false) goto L11;
        AppCompatTextView r101 = new AppCompatTextView(this.context);
        this.errorView = r101;
        r101.setId(R.id.textinput_error);
        Typeface r102 = this.typeface;
        if (r102 == null) goto L10;
        this.errorView.setTypeface(r102);
    L10:
        setErrorTextAppearance(this.errorTextAppearance);
        this.errorView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.errorView, 1);
        addIndicator(this.errorView, 0);
    L12:
        this.errorEnabled = r100;
        return;
    L11:
        hideError();
        removeIndicator(this.errorView, 0);
        this.errorView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setErrorTextAppearance(int r100) {
        this.errorTextAppearance = r100;
        TextView r101 = this.errorView;
        if (r101 == null) goto L6;
        this.textInputView.setTextAppearanceCompatWithErrorFallback(r101, r100);
        return;
    }

    public void setErrorViewTextColor(ColorStateList r100) {
        TextView r101 = this.errorView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setHelperTextAppearance(int r100) {
        this.helperTextTextAppearance = r100;
        TextView r101 = this.helperTextView;
        if (r101 == null) goto L6;
        TextViewCompat.setTextAppearance(r101, r100);
        return;
    }

    public void setHelperTextEnabled(boolean r100) {
        if (this.helperTextEnabled != r100) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r100 == false) goto L11;
        AppCompatTextView r101 = new AppCompatTextView(this.context);
        this.helperTextView = r101;
        r101.setId(R.id.textinput_helper_text);
        Typeface r102 = this.typeface;
        if (r102 == null) goto L10;
        this.helperTextView.setTypeface(r102);
    L10:
        this.helperTextView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
        setHelperTextAppearance(this.helperTextTextAppearance);
        addIndicator(this.helperTextView, 1);
    L12:
        this.helperTextEnabled = r100;
        return;
    L11:
        hideHelperText();
        removeIndicator(this.helperTextView, 1);
        this.helperTextView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setHelperTextViewTextColor(ColorStateList r100) {
        TextView r101 = this.helperTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setTypefaces(Typeface r100) {
        if (r100 == this.typeface) goto L6;
        this.typeface = r100;
        setTextViewTypeface(this.errorView, r100);
        setTextViewTypeface(this.helperTextView, r100);
        return;
    }

    public void showError(CharSequence r100) {
        cancelCaptionAnimator();
        this.errorText = r100;
        this.errorView.setText(r100);
        int r101 = this.captionDisplayed;
        if (r101 == 1) goto L5;
        this.captionToShow = 1;
    L5:
        updateCaptionViewsVisibility(r101, this.captionToShow, shouldAnimateCaptionView(this.errorView, r100));
    }

    public void showHelper(CharSequence r100) {
        cancelCaptionAnimator();
        this.helperText = r100;
        this.helperTextView.setText(r100);
        int r101 = this.captionDisplayed;
        if (r101 == 2) goto L5;
        this.captionToShow = 2;
    L5:
        updateCaptionViewsVisibility(r101, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, r100));
    }

    public static /* synthetic */ int access$002(IndicatorViewController r100, int r101) {
        r100.captionDisplayed = r101;
        return r101;
    }

    public static /* synthetic */ Animator access$102(IndicatorViewController r100, Animator r101) {
        r100.captionAnimator = r101;
        return r101;
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView r100, boolean r101) {
        if (r101 == false) goto L4;
        float r102 = 1.0f;
    L5:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, View.ALPHA, new float[]{r102});
        r103.setDuration(167);
        r103.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r103;
    L4:
        r102 = 0.0f;
        goto L5
    }

    private void setCaptionViewVisibilities(int r100, int r101) {
        if (r100 != r101) goto L4;
        return;
    L4:
        if (r101 == 0) goto L8;
        TextView r102 = getCaptionViewFromDisplayState(r101);
        if (r102 == null) goto L8;
        r102.setVisibility(0);
        r102.setAlpha(1.0f);
    L8:
        if (r100 == 0) goto L14;
        TextView r103 = getCaptionViewFromDisplayState(r100);
        if (r103 == null) goto L14;
        r103.setVisibility(4);
        if (r100 != 1) goto L14;
        r103.setText(null);
    L14:
        this.captionDisplayed = r101;
    }

    private void setTextViewTypeface(TextView r100, Typeface r101) {
        if (r100 == null) goto L5;
        r100.setTypeface(r101);
        return;
    }

    private void setViewGroupGoneIfEmpty(ViewGroup r100, int r101) {
        if (r101 != 0) goto L5;
        r100.setVisibility(8);
        return;
    }

    private boolean shouldAnimateCaptionView(TextView r100, CharSequence r101) {
        if (ViewCompat.isLaidOut(this.textInputView) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.textInputView.isEnabled() == false) goto L12;
        if (this.captionToShow != this.captionDisplayed) goto L11;
        if (r100 == null) goto L11;
        if (TextUtils.equals(r100.getText(), r101) == true) goto L12;
    L11:
        return true;
    }

    public void addIndicator(TextView r100, int r101) {
        if (this.indicatorArea != null) goto L10;
        if (this.captionArea != null) goto L10;
        LinearLayout r102 = new LinearLayout(this.context);
        this.indicatorArea = r102;
        r102.setOrientation(0);
        this.textInputView.addView(this.indicatorArea, -1, -2);
        FrameLayout r103 = new FrameLayout(this.context);
        this.captionArea = r103;
        this.indicatorArea.addView(r103, -1, new FrameLayout.LayoutParams(-2, -2));
        this.indicatorArea.addView(new Space(this.context), new LinearLayout.LayoutParams(0, 0, 1.0f));
        if (this.textInputView.getEditText() == null) goto L10;
        adjustIndicatorPadding();
    L10:
        if (isCaptionView(r101) == false) goto L12;
        this.captionArea.setVisibility(0);
        this.captionArea.addView(r100);
        this.captionViewsAdded++;
    L13:
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
        return;
    L12:
        this.indicatorArea.addView(r100, r101);
        goto L13
    }

    public void removeIndicator(TextView r100, int r101) {
        if (this.indicatorArea != null) goto L6;
        return;
    L6:
        if (isCaptionView(r101) == false) goto L10;
        FrameLayout r102 = this.captionArea;
        if (r102 == null) goto L10;
        int r103 = this.captionViewsAdded - 1;
        this.captionViewsAdded = r103;
        setViewGroupGoneIfEmpty(r102, r103);
        this.captionArea.removeView(r100);
    L11:
        int r104 = this.indicatorsAdded - 1;
        this.indicatorsAdded = r104;
        setViewGroupGoneIfEmpty(this.indicatorArea, r104);
        return;
    L10:
        this.indicatorArea.removeView(r100);
        goto L11
    }

    private void updateCaptionViewsVisibility(final int r110, final int r111, boolean r112) {
        if (r112 == false) goto L4;
        AnimatorSet r100 = new AnimatorSet();
        this.captionAnimator = r100;
        ArrayList r101 = new ArrayList();
        createCaptionAnimators(r101, this.helperTextEnabled, this.helperTextView, 2, r110, r111);
        createCaptionAnimators(r101, this.errorEnabled, this.errorView, 1, r110, r111);
        AnimatorSetCompat.playTogether(r100, r101);
        final TextView r102 = getCaptionViewFromDisplayState(r110);
        final TextView r103 = getCaptionViewFromDisplayState(r111);
        r100.addListener(new AnonymousClass1(this, r111, r102, r110, r103));
        r100.start();
    L5:
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(r112);
        this.textInputView.updateTextInputBoxState();
        return;
    L4:
        setCaptionViewVisibilities(r110, r111);
        goto L5
    }

    private void createCaptionAnimators(List<Animator> r100, boolean r101, TextView r102, int r103, int r104, int r105) {
        if (r102 == null) goto L14;
        if (r101 == false) goto L17;
        if (r103 == r105) goto L7;
        if (r103 == r104) goto L7;
        return;
    L7:
        if (r105 != r103) goto L9;
        boolean r106 = true;
    L10:
        r100.add(createCaptionOpacityAnimator(r102, r106));
        if (r105 != r103) goto L16;
        r100.add(createCaptionTranslationYAnimator(r102));
        return;
    L16:
        return;
    L9:
        r106 = false;
        goto L10
    L17:
        return;
    }
}
