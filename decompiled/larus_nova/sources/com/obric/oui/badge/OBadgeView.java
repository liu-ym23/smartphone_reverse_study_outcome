package com.obric.oui.badge;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "", "contentDescription", "", "setContentDescription", "", "color", "setTextColor", "", "enabled", "setEnableFontScale", "setBackgroundColor", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "maxNumber", "setMaxNumberInCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBadgeView extends OTextView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OBadgeDrawable f398818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f398819j;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBadgeView f398820a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(OBadgeView r100) {
            this.f398820a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            OBadgeDrawable r104 = this.f398820a.f398818i;
            String r105 = null;
            if (r104 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
            r104 = null;
        L5:
            if (r100 == null) goto L8;
            r105 = r100.toString();
        L8:
            r104.d(r105);
            this.f398820a.requestLayout();
            this.f398820a.invalidate();
        }
    }

    public static final class b {
    }

    static {
    }

    public OBadgeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OBadgeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.text.OTextView, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.text.OTextView
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    public final void b() {
        OBadgeDrawable r100 = this.f398818i;
        OBadgeDrawable r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r100 = null;
    L5:
        CharSequence r102 = getText();
        if (r102 != null) goto L8;
        String r103 = null;
    L9:
        r100.d(r103);
        OBadgeDrawable r104 = this.f398818i;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r104 = null;
    L12:
        int r105 = getCurrentTextColor();
        if (r104.D == r105) goto L16;
        r104.D = r105;
        r104.f398801l.setColor(r105);
        r104.invalidateSelf();
    L16:
        OBadgeDrawable r106 = this.f398818i;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r106 = null;
    L19:
        r106.e(this.f398819j);
        c(getTextSize());
        Drawable r107 = getBackground();
        if ((r107 instanceof ColorDrawable) == false) goto L27;
        OBadgeDrawable r108 = this.f398818i;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
    L25:
        r101.c(((ColorDrawable) r107).getColor());
        return;
    L24:
        r101 = r108;
        goto L25
    L27:
        return;
    L8:
        r103 = r102.toString();
        goto L9
    }

    public final void c(float r100) {
        Resources r101 = getResources();
        float r102 = r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).scaledDensity;
        OBadgeDrawable r103 = this.f398818i;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r103 = null;
    L6:
        if (r103.F != r102) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L17;
        r103.F = r102;
        Resources r105 = r103.f398790a.getResources();
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
        TextPaint r107 = r103.f398801l;
        if (r103.E == false) goto L14;
        float r108 = TypedValue.applyDimension(2, r103.F, r106);
    L15:
        r107.setTextSize(r108);
        r103.a();
        return;
    L14:
        r108 = TypedValue.applyDimension(1, r103.F, r106);
        goto L15
    L17:
        return;
    L8:
        r104 = false;
        goto L9
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L6:
        if (Intrinsics.areEqual(r100, r101) == false) goto L8;
        invalidate();
        return;
    L8:
        super.invalidateDrawable(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L5:
        r101.draw(r100);
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ColorDrawable) == false) goto L7;
        ColorDrawable r102 = (ColorDrawable) r100;
    L8:
        if (r102 == null) goto L15;
        if (r101 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L12:
        r101.c(r102.getColor());
        invalidate();
        return;
    L15:
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        OBadgeDrawable r101 = this.f398818i;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L6:
        r101.c(r100);
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r100) {
        super.setContentDescription(r100);
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L5:
        r101.getClass();
    }

    public final void setEnableFontScale(boolean r100) {
        if (this.f398819j != r100) goto L5;
        return;
    L5:
        this.f398819j = r100;
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L8:
        r101.e(r100);
        b();
        requestLayout();
        invalidate();
    }

    public final void setMaxNumberInCount(int r100) {
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L5:
        r101.getClass();
        if (r100 >= 1) goto L9;
        r100 = 1;
    L9:
        if (r101.f398815z == r100) goto L12;
        r101.f398815z = r100;
        r101.f398813x = r101.b(r101.f398813x);
        r101.a();
    L12:
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        if (this.f398818i == null) goto L13;
        super.setTextColor(r100);
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L7:
        int r102 = getCurrentTextColor();
        if (r101.D == r102) goto L11;
        r101.D = r102;
        r101.f398801l.setColor(r102);
        r101.invalidateSelf();
    L11:
        invalidate();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == true) goto L11;
        OBadgeDrawable r101 = this.f398818i;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r101 = null;
    L8:
        if (Intrinsics.areEqual(r100, r101) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        OBadgeDrawable r102 = this.f398818i;
        OBadgeDrawable r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r102 = null;
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r102.f(this, null);
        OBadgeDrawable r104 = this.f398818i;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
    L9:
        Rect r105 = r103.getBounds();
        int r106 = r105.width();
        int r107 = r105.height();
        setMeasuredDimension(TextView.resolveSize(r106 + (getPaddingLeft() + getPaddingRight()), r100), TextView.resolveSize(r107 + (getPaddingTop() + getPaddingBottom()), r101));
        return;
    L8:
        r103 = r104;
        goto L9
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        super.setTextSize(r100, r101);
        if (this.f398818i == null) goto L5;
        c(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    public OBadgeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        this.f398819j = true;
        int r103 = OBadgeDrawable.G;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OBadgeDrawable r104 = new OBadgeDrawable(r100);
        this.f398818i = r104;
        r104.setCallback(this);
        OBadgeDrawable.BadgeGravity r105 = OBadgeDrawable.BadgeGravity.CENTER;
        Intrinsics.checkNotNullParameter(r105, "value");
        if (r104.A == r105) goto L6;
        r104.A = r105;
        r104.a();
    L6:
        if (r101 != null) goto L8;
        getContentDescription();
    L40:
        b();
        addTextChangedListener(new a(this));
        return;
    L8:
        TypedArray r106 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.textSize, R.attr.textColor, R.attr.background, R.attr.text, com.larus.nova.R.attr.o_maxNumber, com.larus.nova.R.attr.oui_badgeview_ellipsis_color, com.larus.nova.R.attr.oui_widgetEnableFontScale}, r102, 0);
        boolean r107 = r106.getBoolean(6, true);     // Catch: Throwable -> L42
        this.f398819j = r107;     // Catch: Throwable -> L42
        r104.e(r107);     // Catch: Throwable -> L42
        int r108 = r106.getInt(4, r104.f398815z);     // Catch: Throwable -> L42
        if (r108 >= 1) goto L13;
        r108 = 1;
    L13:
        if (r104.f398815z == r108) goto L16;
        r104.f398815z = r108;     // Catch: Throwable -> L42
        r104.f398813x = r104.b(r104.f398813x);     // Catch: Throwable -> L42
        r104.a();     // Catch: Throwable -> L42
    L16:
        Integer r109 = Integer.valueOf(r106.getColor(5, 0));     // Catch: Throwable -> L42
        String r110 = null;
        if (Intrinsics.areEqual(r104.f398814y, r109) == true) goto L21;
        r104.f398814y = r109;     // Catch: Throwable -> L42
        r104.f398813x = null;     // Catch: Throwable -> L42
        r104.a();     // Catch: Throwable -> L42
    L21:
        if (r106.hasValue(3) == false) goto L28;
        CharSequence r111 = r106.getText(3);     // Catch: Throwable -> L42
        if (r111 == null) goto L26;
        r110 = r111.toString();     // Catch: Throwable -> L42
    L26:
        r104.d(r110);     // Catch: Throwable -> L42
    L28:
        if (r106.hasValue(1) == false) goto L34;
        int r112 = r106.getColor(1, getCurrentTextColor());     // Catch: Throwable -> L42
        if (r104.D == r112) goto L34;
        r104.D = r112;     // Catch: Throwable -> L42
        r104.f398801l.setColor(r112);     // Catch: Throwable -> L42
        r104.invalidateSelf();     // Catch: Throwable -> L42
    L34:
        if (r106.hasValue(0) == false) goto L37;
        c(r106.getDimension(0, getTextSize()));     // Catch: Throwable -> L42
    L37:
        if (r106.hasValue(2) == false) goto L39;
        r104.c(r106.getColor(2, ContextCompat.getColor(getContext(), com.larus.nova.R.color.oui_red_6)));     // Catch: Throwable -> L42
    L39:
        r106.recycle();
        getContentDescription();
    L42:
        th = move-exception;
        r106.recycle();
        throw th;
    }

    public /* synthetic */ OBadgeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        OBadgeDrawable r104 = this.f398818i;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r104 = null;
    L9:
        r104.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r104.f(this, null);
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == true) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L15;
        OBadgeDrawable r105 = this.f398818i;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(IAllianceService.CONTENT_TYPE_BADGE);
        r105 = null;
    L11:
        r105.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r105.f(this, null);
        return;
    }
}
