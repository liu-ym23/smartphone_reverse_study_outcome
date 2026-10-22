package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.ColorUtils;
import com.larus.nova.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OButtonLink extends OUILinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OBaseTextView f399118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f399119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f399120j;

    public static final class a {
    }

    static {
    }

    public OButtonLink(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OButtonLink(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OButtonLink(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.b
    public final void Q5(int r100) {
        float r101 = RangesKt.coerceIn(r100 / 255.0f, 0.0f, 1.0f);
        int r102 = ColorUtils.setAlphaComponent(this.f399120j, RangesKt.coerceIn(MathKt.roundToInt(Color.alpha(this.f399120j) * r101), 0, 255));
        OBaseTextView r103 = null;
        if (r101 <= 0.0f) goto L5;
        PorterDuffColorFilter r104 = new PorterDuffColorFilter(r102, PorterDuff.Mode.SRC_ATOP);
    L6:
        OBaseTextView r105 = this.f399118h;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r105 = null;
    L9:
        r105.getPaint().setColorFilter(r104);
        OBaseTextView r106 = this.f399118h;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L13:
        r103.invalidate();
        if (r104 == null) goto L19;
        AppCompatImageView r107 = this.f399119i;
        if (r107 == null) goto L25;
        r107.setColorFilter(r104);
        return;
    L25:
        return;
    L19:
        AppCompatImageView r108 = this.f399119i;
        if (r108 == null) goto L26;
        r108.clearColorFilter();
        return;
    L26:
        return;
    L12:
        r103 = r106;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.view.View, androidx.appcompat.widget.AppCompatImageView] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.widget.LinearLayout, com.obric.oui.button.OButtonLink, com.obric.oui.layout.OUILinearLayout] */
    public OButtonLink(Context r100, AttributeSet r110, int r111, int r112) {
        ?? r101 = 0;
        r101 = 0;
        if ((r112 & 2) == 0) goto L5;
        r110 = null;
    L5:
        int r102 = 0;
        if ((r112 & 4) == 0) goto L8;
        r111 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111, 8);
        this.f399120j = r100.getResources().getColor(R.color.oui_state_overlay_pressed_on_color);
        TypedArray r113 = r100.obtainStyledAttributes(r110, new int[]{R.attr.oui_buttonLinkArrowDrawable, R.attr.oui_buttonLinkShowArrow, R.attr.oui_widgetText, R.attr.oui_widgetTextColor, R.attr.oui_widgetTextStyle});
        String r114 = r113.getString(2);
        int r115 = r113.getResourceId(4, R.style.Button_1_Medium);
        int r103 = r113.getColor(3, getResources().getColor(R.color.oui_accent_7_fg, null));
        boolean r104 = r113.getBoolean(1, false);
        Drawable r105 = r113.getDrawable(0);
        setOrientation(0);
        OBaseTextView r106 = new OBaseTextView(r100, r101, 6, r102);
        r106.setSingleLine();
        r106.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r106.setTextAppearance(r115);
        r106.setTextColor(r103);
        r106.setText(r114);
        r106.setIncludeFontPadding(false);
        r106.setGravity(17);
        this.f399118h = r106;
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.weight = 1.0f;
        Unit r107 = Unit.INSTANCE;
        addView(r106, r116);
        if (r104 == false) goto L18;
        ?? r117 = new AppCompatImageView(r100);
        if (r105 == null) goto L17;
        Drawable r108 = r105.mutate();
        if (r108 == null) goto L17;
        r108.setTint(r103);
        r101 = r108;
    L17:
        r117.setImageDrawable(r101);
        this.f399119i = r117;
        addView(r117, new LinearLayout.LayoutParams(-2, -2));
    L18:
        r113.recycle();
        setOverridePressColor(0);
        m1("OButtonLink");
        setChangeAlphaWhenPress(true);
        setClickable(true);
    }
}
