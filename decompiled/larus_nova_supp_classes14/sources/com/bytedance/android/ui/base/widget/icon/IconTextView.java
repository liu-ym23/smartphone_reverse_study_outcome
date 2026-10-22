package com.bytedance.android.ui.base.widget.icon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ui/base/widget/icon/IconTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomColorStateList", "Landroid/content/res/ColorStateList;", "bottomIconSize", "endColorStateList", "endIconSize", "startColorStateList", "startIconSize", "topColorStateList", "topIconSize", "applyState", "", "drawableStateChanged", "setCompoundDrawablesBounds", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IconTextView extends AppCompatTextView {
    private ColorStateList bottomColorStateList;
    private int bottomIconSize;
    private ColorStateList endColorStateList;
    private int endIconSize;
    private ColorStateList startColorStateList;
    private int startIconSize;
    private ColorStateList topColorStateList;
    private int topIconSize;

    public IconTextView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public IconTextView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void applyState() {
        ColorStateList r0 = this.startColorStateList;
        if (r0 == null) goto L7;
        int r1 = r0.getColorForState(getDrawableState(), -16777216);
        Drawable r2 = getCompoundDrawables()[0];
        if (r2 == null) goto L7;
        r2.setColorFilter(new PorterDuffColorFilter(r1, PorterDuff.Mode.SRC_IN));
    L7:
        ColorStateList r3 = this.topColorStateList;
        if (r3 == null) goto L12;
        int r4 = r3.getColorForState(getDrawableState(), -16777216);
        Drawable r5 = getCompoundDrawables()[1];
        if (r5 == null) goto L12;
        r5.setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN));
    L12:
        ColorStateList r6 = this.endColorStateList;
        if (r6 == null) goto L17;
        int r7 = r6.getColorForState(getDrawableState(), -16777216);
        Drawable r8 = getCompoundDrawables()[2];
        if (r8 == null) goto L17;
        r8.setColorFilter(new PorterDuffColorFilter(r7, PorterDuff.Mode.SRC_IN));
    L17:
        ColorStateList r9 = this.bottomColorStateList;
        if (r9 == null) goto L23;
        int r10 = r9.getColorForState(getDrawableState(), -16777216);
        Drawable r11 = getCompoundDrawables()[3];
        if (r11 == null) goto L24;
        r11.setColorFilter(new PorterDuffColorFilter(r10, PorterDuff.Mode.SRC_IN));
        return;
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCompoundDrawablesBounds() {
        Drawable[] r0 = getCompoundDrawables();
        boolean r1 = false;
        Drawable r2 = r0[0];
        Drawable r3 = null;
        if (r2 == null) goto L13;
        int r5 = this.startIconSize;
        if (r5 <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        Drawable r7 = r2;
    L11:
        if (r7 == null) goto L13;
        IconExtKt.setDrawableSize(r7, r5);
        goto L13
    L10:
        r7 = null;
        goto L11
    L7:
        r6 = false;
    L13:
        Drawable r8 = r0[1];
        if (r8 == null) goto L24;
        int r9 = this.topIconSize;
        if (r9 <= 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        Drawable r11 = r8;
    L22:
        if (r11 == null) goto L24;
        IconExtKt.setDrawableSize(r11, r9);
        goto L24
    L21:
        r11 = null;
        goto L22
    L18:
        r10 = false;
    L24:
        Drawable r12 = r0[2];
        if (r12 == null) goto L35;
        int r13 = this.endIconSize;
        if (r13 <= 0) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == false) goto L32;
        Drawable r15 = r12;
    L33:
        if (r15 == null) goto L35;
        IconExtKt.setDrawableSize(r15, r13);
        goto L35
    L32:
        r15 = null;
        goto L33
    L29:
        r14 = false;
    L35:
        Drawable r4 = r0[3];
        if (r4 == null) goto L44;
        int r16 = this.bottomIconSize;
        if (r16 <= 0) goto L40;
        r1 = true;
    L40:
        if (r1 == false) goto L42;
        r3 = r4;
    L42:
        if (r3 == null) goto L44;
        IconExtKt.setDrawableSize(r3, r16);
    L44:
        super.setCompoundDrawables(r2, r8, r12, r4);
        applyState();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        setCompoundDrawablesBounds();
    }

    public IconTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (r3 == null) goto L6;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130970300, 2130970301, 2130970303, 2130970304, 2130970309, 2130970310, 2130970311, 2130970312});
        this.startColorStateList = r5.getColorStateList(4);
        this.topColorStateList = r5.getColorStateList(6);
        this.endColorStateList = r5.getColorStateList(2);
        this.bottomColorStateList = r5.getColorStateList(0);
        this.startIconSize = r5.getDimensionPixelSize(5, 0);
        this.topIconSize = r5.getDimensionPixelSize(7, 0);
        this.endIconSize = r5.getDimensionPixelSize(3, 0);
        this.bottomIconSize = r5.getDimensionPixelSize(1, 0);
        r5.recycle();
        setCompoundDrawablesBounds();
        return;
    }

    public /* synthetic */ IconTextView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
