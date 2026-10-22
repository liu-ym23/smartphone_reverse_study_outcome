package com.huawei.hms.support.hwid.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdAuthButton extends RelativeLayout {
    public static final int COLOR_POLICY_BLACK = 3;
    public static final int COLOR_POLICY_GRAY = 4;
    public static final int COLOR_POLICY_RED = 0;
    public static final int COLOR_POLICY_WHITE = 1;
    public static final int COLOR_POLICY_WHITE_WITH_BORDER = 2;
    public static final int CORNER_RADIUS_LARGE = -1;
    public static final int CORNER_RADIUS_MEDIUM = -2;
    public static final int CORNER_RADIUS_SMALL = -3;
    public static final int THEME_FULL_TITLE = 1;
    public static final int THEME_NO_TITLE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PorterDuffColorFilter f277806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuffColorFilter f277807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PorterDuffColorFilter f277808c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f277809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f277810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f277811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GradientDrawable f277812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Button f277813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f277814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinearLayout f277815j;

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    static {
        f277806a = new PorterDuffColorFilter(218103808, PorterDuff.Mode.SRC_ATOP);
        f277807b = new PorterDuffColorFilter(436207616, PorterDuff.Mode.SRC_ATOP);
        f277808c = new PorterDuffColorFilter(872415231, PorterDuff.Mode.SRC_ATOP);
    }

    private void a() {
        if (this.f277814i != null) goto L5;
        this.f277814i = new ImageView(getContext());
    L5:
        this.f277814i.setImageDrawable(getResources().getDrawable(R.drawable.hwid_auth_button_round_normal));
        setBackgroundDrawableColor(R.color.hwid_auth_button_color_white);
        this.f277815j.addView(this.f277814i);
    }

    private void b() {
        if (this.f277813h != null) goto L5;
        this.f277813h = new Button(getContext());
    L5:
        this.f277813h.setStateListAnimator(null);
        this.f277813h.setBackground(null);
        int r100 = a(R.drawable.hwid_auth_button_white).getIntrinsicWidth();
        int r101 = a(8.0f);
        this.f277813h.setCompoundDrawablePadding(r101);
        a(r100, r101);
        this.f277813h.setLayoutParams(new ViewGroup.LayoutParams(-2, a(36.0f)));
        this.f277815j.addView(this.f277813h);
    }

    public int getColorPolicy() {
        return this.f277810e;
    }

    public int getCornerRadius() {
        return this.f277811f;
    }

    public int getTheme() {
        return this.f277809d;
    }

    public HuaweiIdAuthButton(Context r100) {
        super(r100);
        a(null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_huawei_hms_support_hwid_ui_HuaweiIdAuthButton_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void a(AttributeSet r100) {
        GradientDrawable r101 = (GradientDrawable) getResources().getDrawable(R.drawable.hwid_auth_button_background);
        this.f277812g = r101;
        setBackground(r101);
        LinearLayout r102 = new LinearLayout(getContext());
        this.f277815j = r102;
        int r103 = 0;
        r102.setOrientation(0);
        this.f277815j.setGravity(17);
        b();
        a();
        addView(this.f277815j);
        int r104 = a(8.0f);
        int r105 = 1;
        if (r100 == null) goto L5;
        TypedArray r106 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.hwid_button_theme, R.attr.hwid_color_policy, R.attr.hwid_corner_radius});
        int r107 = r106.getInt(0, 1);
        r103 = r106.getInt(1, 0);
        int r108 = r106.getLayoutDimension(2, a(8.0f));
        r106.recycle();
        r105 = r107;
        r104 = r108;
    L5:
        setLayoutParams(generateDefaultLayoutParams());
        setUIMode(r105, r103, r104);
    }

    private void setBackgroundCornerRadius(int r100) {
        this.f277812g.mutate();
        this.f277812g.setCornerRadius(r100);
    }

    private void setBackgroundDrawableColor(int r100) {
        this.f277812g.mutate();
        this.f277812g.setColor(getResources().getColor(r100));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L22;
        if (this.f277812g == null) goto L27;
        if (isEnabled() == false) goto L27;
        int r101 = this.f277810e;
        if (r101 == 0) goto L20;
        if (r101 != 1) goto L12;
    L19:
        this.f277812g.setColorFilter(f277806a);
        goto L27
    L12:
        if (r101 == 2) goto L19;
        if (r101 != 3) goto L16;
        this.f277812g.setColorFilter(f277808c);
        goto L27
    L16:
        if (r101 == 4) goto L19;
    L20:
        this.f277812g.setColorFilter(f277807b);
    L27:
        if (hasOnClickListeners() == true) goto L29;
        return true;
    L29:
        return super.onTouchEvent(r100);
    L22:
        if (1 != r100.getAction()) goto L27;
        GradientDrawable r102 = this.f277812g;
        if (r102 == null) goto L27;
        r102.clearColorFilter();
        goto L27
    }

    public void setColorPolicy(int r100) {
        if (r100 != 0) goto L5;
        a(r100, R.color.hwid_auth_button_color_red, R.color.hwid_auth_button_color_text_white, R.drawable.hwid_auth_button_white);
        this.f277814i.setImageDrawable(getResources().getDrawable(R.drawable.hwid_auth_button_round_white));
        return;
    L5:
        if (r100 != 1) goto L7;
        a(r100, R.color.hwid_auth_button_color_white, R.color.hwid_auth_button_color_text_black, R.drawable.hwid_auth_button_normal);
        this.f277814i.setImageDrawable(getResources().getDrawable(R.drawable.hwid_auth_button_round_normal));
        return;
    L7:
        if (r100 != 2) goto L9;
        a(r100, R.color.hwid_auth_button_color_white, R.color.hwid_auth_button_color_text_black, R.drawable.hwid_auth_button_normal);
        if (this.f277809d != 1) goto L23;
        b(a(1.0f), getResources().getColor(R.color.hwid_auth_button_color_border));
        return;
    L23:
        return;
    L9:
        if (r100 != 3) goto L11;
        a(r100, R.color.hwid_auth_button_color_black, R.color.hwid_auth_button_color_text_white, R.drawable.hwid_auth_button_white);
        this.f277814i.setImageDrawable(getResources().getDrawable(R.drawable.hwid_auth_button_round_white));
        return;
    L11:
        if (r100 != 4) goto L26;
        a(r100, R.color.hwid_auth_button_color_gray, R.color.hwid_auth_button_color_text_black, R.drawable.hwid_auth_button_normal);
        return;
    }

    public void setCornerRadius(int r100) {
        if (r100 != (-3)) goto L5;
        r100 = a(3.0f);
    L12:
        if (r100 >= 0) goto L14;
        return;
    L14:
        this.f277811f = r100;
        setBackgroundCornerRadius(r100);
        return;
    L5:
        if (r100 != (-2)) goto L7;
        r100 = a(8.0f);
        goto L12
    L7:
        if (r100 != (-1)) goto L12;
        r100 = a(24.0f);
        goto L12
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L5;
        setAlpha(0.38f);
        return;
    L5:
        setAlpha(1.0f);
    }

    public void setTheme(int r100) {
        if (r100 != 0) goto L5;
        this.f277809d = r100;
        this.f277814i.setVisibility(0);
        this.f277813h.setVisibility(8);
        setMinimumWidth(a(48.0f));
        setMinimumHeight(a(48.0f));
        this.f277815j.setMinimumWidth(a(48.0f));
        this.f277815j.setMinimumHeight(a(48.0f));
        return;
    L5:
        if (r100 != 1) goto L11;
        this.f277809d = r100;
        this.f277814i.setVisibility(8);
        this.f277813h.setVisibility(0);
        setMinimumWidth(a(200.0f));
        setMinimumHeight(a(36.0f));
        this.f277815j.setMinimumWidth(a(200.0f));
        this.f277815j.setMinimumHeight(a(36.0f));
        return;
    }

    private Drawable a(int r100) {
        Drawable r101 = getResources().getDrawable(r100);
        r101.setBounds(0, 0, r101.getMinimumWidth(), r101.getMinimumHeight());
        this.f277813h.setCompoundDrawablesRelativeWithIntrinsicBounds(r101, null, null, null);
        return r101;
    }

    private int a(float r100) {
        return (int) ((r100 * INVOKEVIRTUAL_com_huawei_hms_support_hwid_ui_HuaweiIdAuthButton_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density) + 0.5f);
    }

    public HuaweiIdAuthButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r101);
    }

    private void a(int r100, int r101) {
        this.f277813h.setTextSize(16.0f);
        this.f277813h.setText(getResources().getText(R.string.hwid_huawei_login_button_text));
        this.f277813h.setSingleLine();
        int r102 = INVOKEVIRTUAL_com_huawei_hms_support_hwid_ui_HuaweiIdAuthButton_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).widthPixels;
        int r103 = a(16.0f);
        int r104 = r103 + r103;
        int r105 = r102 - r104;
        this.f277813h.setMaxWidth(r105);
        float r106 = this.f277813h.getPaint().measureText(this.f277813h.getText().toString());
    L4:
        if ((((((int) r106) + r100) + r101) + r104) <= r105) goto L8;
        if (this.f277813h.getTextSize() <= a(9.0f)) goto L8;
        Button r107 = this.f277813h;
        r107.setTextSize(0, r107.getTextSize() - 1.0f);
        r106 = this.f277813h.getPaint().measureText(this.f277813h.getText().toString());
    L8:
        this.f277813h.setEllipsize(TextUtils.TruncateAt.END);
        this.f277813h.setPadding(r103, 0, r103, 0);
    }

    private void b(int r100, int r101) {
        this.f277812g.mutate();
        this.f277812g.setStroke(r100, r101);
    }

    public HuaweiIdAuthButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r101);
    }

    public void setUIMode(int r100, int r101, int r102) {
        setTheme(r100);
        setColorPolicy(r101);
        setCornerRadius(r102);
    }

    private void a(int r100, int r101, int r102, int r103) {
        this.f277810e = r100;
        if (this.f277809d == 1) goto L10;
        if (r100 == 0) goto L10;
        if (r100 == 3) goto L10;
        if (r100 == 1) goto L10;
        setBackgroundDrawableColor(R.color.hwid_auth_button_color_white);
        this.f277814i.setImageDrawable(getResources().getDrawable(R.drawable.hwid_auth_button_round_normal));
    L11:
        b(0, 0);
        this.f277813h.setTextColor(getResources().getColor(r102));
        a(r103);
        return;
    L10:
        setBackgroundDrawableColor(r101);
        goto L11
    }
}
