package com.bytedance.android.ui.base.widget.icon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0014\u001a\u00020\u000e2\b\b\u0003\u0010\u0015\u001a\u00020\u00072\b\b\u0003\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ui/base/widget/icon/IconImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "colorStateList", "Landroid/content/res/ColorStateList;", "iconSize", "", "applyState", "", "drawableStateChanged", "initMatrix", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setIconColor", "res", "color", "setIconSize", "size", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IconImageView extends AppCompatImageView {
    private ColorStateList colorStateList;
    private float iconSize;

    public IconImageView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public IconImageView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void applyState() {
        ColorStateList r0 = this.colorStateList;
        if (r0 == null) goto L6;
        setColorFilter(new PorterDuffColorFilter(r0.getColorForState(getDrawableState(), -16777216), PorterDuff.Mode.SRC_IN));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initMatrix() {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        if (this.iconSize != 0.0f) goto L7;
        return;
    L7:
        if (getMeasuredWidth() <= 0) goto L21;
        int r0 = getDrawable().getIntrinsicWidth();
        int r1 = getDrawable().getIntrinsicHeight();
        if (r0 <= 0) goto L20;
        if (r1 <= 0) goto L22;
        ImageView.ScaleType r2 = getScaleType();
        ImageView.ScaleType r3 = ImageView.ScaleType.MATRIX;
        if (r2 == r3) goto L16;
        setScaleType(r3);
    L16:
        float r4 = Math.min(this.iconSize, getMeasuredWidth());
        float r5 = Math.min(this.iconSize, getMeasuredHeight());
        float r6 = r4 / r0;
        float r7 = r5 / r1;
        float r8 = (float) Math.rint((getMeasuredWidth() - r4) * 0.5f);
        float r9 = (float) Math.rint((getMeasuredHeight() - r5) * 0.5f);
        Matrix r10 = new Matrix();
        r10.setScale(r6, r7);
        r10.postTranslate(r8, r9);
        setImageMatrix(r10);
        return;
    L22:
        return;
    L20:
        return;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        applyState();
    }

    public final void setIconColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "colorStateList");
        this.colorStateList = r2;
        applyState();
    }

    public final void setIconSize(float r2) {
        if (this.iconSize == r2) goto L6;
        this.iconSize = r2;
        initMatrix();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r1, int r2) {
        super/*android.widget.ImageView*/.onMeasure(r1, r2);
        initMatrix();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIconColor(int r1, int r2) {
        if (r1 == 0) goto L4;
        this.colorStateList = ContextCompat.getColorStateList(getContext(), r1);
    L6:
        applyState();
        return;
    L4:
        if (r2 == 0) goto L6;
        this.colorStateList = ColorStateList.valueOf(r2);
        goto L6
    }

    public IconImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (r3 == null) goto L6;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130970302, 2130970308});
        this.colorStateList = r5.getColorStateList(0);
        this.iconSize = r5.getDimension(1, 0.0f);
        r5.recycle();
        applyState();
        return;
    }

    public /* synthetic */ IconImageView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ void setIconColor$default(IconImageView r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        r1.setIconColor(r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconColor");
    }
}
