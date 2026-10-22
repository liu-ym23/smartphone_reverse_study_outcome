package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "", "drawableResId", "", "setIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "color", "setIconTintColor", "Landroid/content/res/ColorStateList;", "setIconBgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OIconButtonFloating extends OShadowFrame {
    public AppCompatImageView D;

    public OIconButtonFloating(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public OIconButtonFloating(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public OIconButtonFloating(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void d(int r100) {
        super.d(r100);
    }

    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        AppCompatImageView r101 = this.D;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        r101.setImageDrawable(r100);
    }

    public final void setIconBgColor(int r100) {
        setBgColor(r100);
    }

    public final void setIconTintColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        AppCompatImageView r101 = this.D;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        r101.setImageTintList(r100);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void t(boolean r100) {
        super.t(r100);
        AppCompatImageView r101 = null;
        if (r100 == false) goto L9;
        AppCompatImageView r102 = this.D;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L8:
        r101.setAlpha(1.0f);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        AppCompatImageView r103 = this.D;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L13:
        r101.setAlpha(0.3f);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    public final void setIcon(int r100) {
        AppCompatImageView r101 = this.D;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        r101.setImageResource(r100);
    }

    public final void setIconTintColor(int r100) {
        AppCompatImageView r101 = this.D;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        r101.setColorFilter(r100);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(Context r100, OUIFrameLayout r101, TypedArray r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        ColorStateList r103 = r102.getColorStateList(20);
        Drawable r104 = r102.getDrawable(3);
        AppCompatImageView r105 = new AppCompatImageView(r100);
        this.D = r105;
        r105.setDuplicateParentStateEnabled(true);
        View r106 = null;
        if (r104 == null) goto L13;
        AppCompatImageView r107 = this.D;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r107 = null;
    L7:
        r107.setImageDrawable(r104);
        if (r103 == null) goto L13;
        AppCompatImageView r108 = this.D;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r108 = null;
    L12:
        r108.setImageTintList(r103);
    L13:
        View r109 = this.D;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L17:
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-1, -1);
        r110.gravity = 17;
        Unit r111 = Unit.INSTANCE;
        r101.addView(r106, r110);
        if (getEnableMaterial() == false) goto L21;
        l(r100, r102);
        return;
    L21:
        return;
    L16:
        r106 = r109;
        goto L17
    }

    public OIconButtonFloating(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
    }

    public OIconButtonFloating(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
    }
}
