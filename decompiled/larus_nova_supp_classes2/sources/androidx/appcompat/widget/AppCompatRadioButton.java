package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton, TintableBackgroundView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper r0 = this.mCompoundButtonHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportButtonTintList();
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper r0 = this.mCompoundButtonHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportButtonTintMode();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L9;
        r1.applyCompoundDrawablesTints();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r0 = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper r1 = this.mCompoundButtonHelper;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r1.getCompoundPaddingLeft(r0);
    }

    public AppCompatRadioButton(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        super.setBackgroundDrawable(r2);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r2);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r2) {
        super.setBackgroundResource(r2);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r2);
        return;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int r2) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setSupportBackgroundTintList(ColorStateList r2) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r2);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r2);
        return;
    }

    public void setSupportButtonTintList(ColorStateList r2) {
        AppCompatCompoundButtonHelper r0 = this.mCompoundButtonHelper;
        if (r0 == null) goto L6;
        r0.setSupportButtonTintList(r2);
        return;
    }

    public void setSupportButtonTintMode(PorterDuff.Mode r2) {
        AppCompatCompoundButtonHelper r0 = this.mCompoundButtonHelper;
        if (r0 == null) goto L6;
        r0.setSupportButtonTintMode(r2);
        return;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable r1) {
        super.setButtonDrawable(r1);
        AppCompatCompoundButtonHelper r2 = this.mCompoundButtonHelper;
        if (r2 == null) goto L6;
        r2.onSetButtonDrawable();
        return;
    }

    public AppCompatRadioButton(Context r2, AttributeSet r3) {
        this(r2, r3, 2130973710);
    }

    public AppCompatRadioButton(Context r1, AttributeSet r2, int r3) {
        super(TintContextWrapper.wrap(r1), r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatCompoundButtonHelper r4 = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper = r4;
        r4.loadFromAttributes(r2, r3);
        AppCompatBackgroundHelper r5 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r5;
        r5.loadFromAttributes(r2, r3);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.loadFromAttributes(r2, r3);
    }
}
