package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

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

    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportImageTintList();
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportImageTintMode();
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.hasOverlappingRendering() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.applySupportBackgroundTint();
    L5:
        AppCompatImageHelper r1 = this.mImageHelper;
        if (r1 == null) goto L9;
        r1.applySupportImageTint();
        return;
    }

    public AppCompatImageButton(Context r2) {
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

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        AppCompatImageHelper r2 = this.mImageHelper;
        if (r2 == null) goto L6;
        r2.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        AppCompatImageHelper r2 = this.mImageHelper;
        if (r2 == null) goto L6;
        r2.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r2) {
        this.mImageHelper.setImageResource(r2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        AppCompatImageHelper r2 = this.mImageHelper;
        if (r2 == null) goto L6;
        r2.applySupportImageTint();
        return;
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

    public void setSupportImageTintList(ColorStateList r2) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setSupportImageTintList(r2);
        return;
    }

    public void setSupportImageTintMode(PorterDuff.Mode r2) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setSupportImageTintMode(r2);
        return;
    }

    public AppCompatImageButton(Context r2, AttributeSet r3) {
        this(r2, r3, 2130970320);
    }

    public AppCompatImageButton(Context r1, AttributeSet r2, int r3) {
        super(TintContextWrapper.wrap(r1), r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r4 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r4;
        r4.loadFromAttributes(r2, r3);
        AppCompatImageHelper r5 = new AppCompatImageHelper(this);
        this.mImageHelper = r5;
        r5.loadFromAttributes(r2, r3);
    }
}
