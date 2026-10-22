package com.bytedance.dux.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.dux.utils.EmojiTextViewHelper;
import com.google.android.material.button.MaterialButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b\u001e\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001f\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/dux/button/DuxButton;", "Lcom/google/android/material/button/MaterialButton;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setForegroundDrawable", "", "enabled", "setEnabled", "Landroid/graphics/Rect;", "getInset", "Lcom/bytedance/dux/text/DuxTextView$TextSpec;", "textSpec", "setTextSpec", "", "Landroid/text/InputFilter;", "filters", "setFilters", "([Landroid/text/InputFilter;)V", "enableParseEmoji", "setEnableParseEmoji", "enable", "setAdaptLargeFont", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/dux/utils/EmojiTextViewHelper;", "getEmojiViewHelper", "()Lcom/bytedance/dux/utils/EmojiTextViewHelper;", "emojiViewHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxButton extends MaterialButton {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DuxComponent f204880o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f204881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f204882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f204883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f204884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f204885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f204886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f204887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f204888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f204889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f204890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f204891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f204892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f204893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EmojiTextViewHelper f204894n;

    public static final class a {
    }

    static {
        f204880o = DuxComponent.BUTTON;
    }

    private final EmojiTextViewHelper getEmojiViewHelper() {
        EmojiTextViewHelper r100 = this.f204894n;
        if (r100 != null) goto L6;
        EmojiTextViewHelper r101 = new EmojiTextViewHelper(this);
        this.f204894n = r101;
        return r101;
    L6:
        return r100;
    }

    public final Rect getInset() {
        return new Rect(this.f204885e, this.f204887g, this.f204886f, this.f204888h);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f204881a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L13;
        Drawable r102 = this.f204881a;
        if (r102 == null) goto L14;
        r102.setState(getDrawableState());
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r100.isStateful() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.f204881a;
        if (r100 == null) goto L6;
        r100.jumpToCurrentState();
        return;
    }

    public DuxButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(new ContextThemeWrapper(r100, R.style.DuxAppcompat));
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f204889i = DuxLargeFontHelper.a(f204880o, null);
        a(r100, null, 0);
    }

    private final void setAdaptLargeFont(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f204889i = DuxLargeFontHelper.a(f204880o, r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
        Drawable r101 = this.f204881a;
        if (r101 == null) goto L6;
        r101.draw(r100);
        return;
    }

    public final void setEnableParseEmoji(boolean r100) {
        getEmojiViewHelper().c(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L7;
        Float r101 = this.f204883c;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r101);
        setAlpha(r101.floatValue());
        return;
    L7:
        if (r100 == true) goto L13;
        Float r102 = this.f204884d;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNull(r102);
        setAlpha(r102.floatValue());
        return;
    L14:
        return;
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r100) {
        InputFilter[] r101 = getEmojiViewHelper().b(r100);
        boolean r102 = true;
        if (r101 != null) goto L5;
    L11:
        if (r102 == false) goto L13;
        super.setFilters(r100);
        return;
    L13:
        super.setFilters(r101);
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = false;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public void setForegroundDrawable(Drawable r100) {
        if (Intrinsics.areEqual(this.f204881a, r100) == false) goto L5;
        return;
    L5:
        Drawable r101 = this.f204881a;
        if (r101 == null) goto L8;
        r101.setCallback(null);
        unscheduleDrawable(r101);
    L8:
        this.f204881a = r100;
        if (r100 == null) goto L13;
        r100.setCallback(this);
        if (r100.isStateful() == false) goto L13;
        r100.setState(getDrawableState());
    L13:
        requestLayout();
        invalidate();
    }

    public final void setTextSpec(DuxTextView.TextSpec r100) {
        Intrinsics.checkNotNullParameter(r100, "textSpec");
        TextViewCompat.setTextAppearance(this, r100.getTextStyle());
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, this.f204881a) == true) goto L8;
        return false;
    }

    public DuxButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(new ContextThemeWrapper(r100, R.style.DuxAppcompat), r101);
        Lazy r102 = DuxLargeFontHelper.f205243a;
        this.f204889i = DuxLargeFontHelper.a(f204880o, null);
        a(r100, r101, 0);
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Drawable r102 = this.f204881a;
        if (r102 == null) goto L6;
        r102.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        invalidate();
        return;
    }

    public DuxButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Lazy r103 = DuxLargeFontHelper.f205243a;
        this.f204889i = DuxLargeFontHelper.a(f204880o, null);
        a(new ContextThemeWrapper(r100, R.style.DuxAppcompat), r101, r102);
    }

    public final void a(Context r110, AttributeSet r111, int r112) {
        TypedArray r100 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.textAppearance, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.background, android.R.attr.paddingLeft, android.R.attr.paddingTop, android.R.attr.paddingRight, android.R.attr.paddingBottom, android.R.attr.foreground, android.R.attr.minWidth, android.R.attr.minHeight, android.R.attr.drawablePadding, android.R.attr.insetLeft, android.R.attr.insetRight, android.R.attr.insetTop, android.R.attr.insetBottom, android.R.attr.stateListAnimator, R.attr.adaptLargeFontMode, R.attr.backgroundTint, R.attr.backgroundTintMode, R.attr.cornerRadius, R.attr.elevation, R.attr.enforceTextAppearance, R.attr.foregroundTint, R.attr.iconGravity, R.attr.iconPadding, R.attr.iconTint, R.attr.isIcon, R.attr.limitLargeFontScale, R.attr.rippleColor, R.attr.stateDisabledAlpha, R.attr.stateEnabledAlpha, R.attr.strokeColor, R.attr.strokeWidth, R.attr.styleContentHeight, R.attr.stylePaddingVertical}, r112, R.style.DuxButton_Base);
        this.f204882b = r100.getColorStateList(23);
        if (r100.hasValue(17) == false) goto L5;
        setAdaptLargeFont(Boolean.valueOf(r100.getBoolean(17, false)));
    L5:
        Drawable r101 = r100.getDrawable(8);
        this.f204890j = r100.getBoolean(28, false);
        this.f204891k = r100.getDimension(34, 0.0f);
        this.f204892l = r100.getDimension(35, 0.0f);
        this.f204893m = r100.getBoolean(27, false);
        if (this.f204889i == true) goto L8;
    L30:
        r100.recycle();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.insetLeft, android.R.attr.insetRight, android.R.attr.insetTop, android.R.attr.insetBottom, R.attr.backgroundTint, R.attr.backgroundTintMode, R.attr.cornerRadius, R.attr.icon, R.attr.iconGravity, R.attr.iconPadding, R.attr.iconSize, R.attr.iconTint, R.attr.iconTintMode, R.attr.rippleColor, R.attr.strokeColor, R.attr.strokeWidth}, r112, R.style.DuxButton_Base);
        this.f204885e = r113.getDimensionPixelSize(0, 0);
        this.f204887g = r113.getDimensionPixelSize(2, 0);
        this.f204888h = r113.getDimensionPixelSize(3, 0);
        this.f204886f = r113.getDimensionPixelSize(1, 0);
    L38:
        e = move-exception;
        int r114 = d.f473061a;
        d.b("DuxButton", "init attributes error:" + e.getMessage());
    L40:
        r113.recycle();
        if (r101 == null) goto L43;
        setForegroundDrawable(r101);
    L48:
        return;
    L43:
        if (this.f204882b == null) goto L48;
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(getCornerRadius());
        DrawableCompat.setTintList(r102, this.f204882b);
        Intrinsics.checkNotNull(r102);
        setForegroundDrawable(new InsetDrawable(r102, this.f204885e, this.f204887g, this.f204886f, this.f204888h));
        goto L48
    L32:
        if (r113.hasValue(31) == false) goto L35;
        this.f204883c = Float.valueOf(r113.getFloat(31, 1.0f));     // Catch: Exception -> L38
    L35:
        if (r113.hasValue(30) == false) goto L40;
        this.f204884d = Float.valueOf(r113.getFloat(30, 1.0f));     // Catch: Exception -> L38
        goto L40
    L8:
        if (this.f204891k <= 0.0f) goto L30;
        if (this.f204892l <= 0.0f) goto L30;
        int r103 = getMinHeight();
        if (this.f204890j == false) goto L23;
        float r104 = getTextSize();
        float r105 = Resources.getSystem().getConfiguration().fontScale;
        if (r105 <= 1.15f) goto L16;
        r104 = (r104 / r105) * 1.15f;
    L16:
        setTextSize(0, r104);
        int r106 = getIconSize();
        float r107 = Resources.getSystem().getConfiguration().fontScale;
        float r108 = r106;
        if (r107 <= 1.15f) goto L19;
        r108 = (r108 / r107) * 1.15f;
    L19:
        setIconSize(MathKt.roundToInt(r108));
        float r109 = this.f204891k;
        float r115 = Resources.getSystem().getConfiguration().fontScale;
        if (r115 <= 1.15f) goto L22;
        r109 = (r109 / r115) * 1.15f;
    L22:
        this.f204891k = r109;
    L23:
        if (r103 <= 0) goto L28;
        float r116 = this.f204891k + this.f204892l;
        if (r116 <= r103) goto L28;
        setMinHeight((int) r116);
    L28:
        if (this.f204893m == false) goto L30;
        setMinWidth(getMinHeight());
        goto L30
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Drawable r104 = this.f204881a;
        if (r104 == null) goto L6;
        r104.setBounds(0, 0, r100, r101);
        invalidate();
        return;
    }
}
