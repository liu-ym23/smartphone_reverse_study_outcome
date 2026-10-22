package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import xbc.b;

/* JADX INFO: loaded from: classes36.dex */
public class IndicatorItemView extends BaseItemView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f461050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f461051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f461052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f461053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f461054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f461055q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f461056r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f461057s;

    public IndicatorItemView(Context r100) {
        this(r100, null);
    }

    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public void setupContainer(FrameLayout r210) {
        ConstraintLayout r100 = new ConstraintLayout(getContext());
        TextView r101 = new TextView(getContext());
        this.f461050l = r101;
        r101.setId(R.id.setting_item_left_text);
        this.f461050l.setTextSize(16);
        this.f461050l.setTextColor(getContext().getResources().getColorStateList(R.color.text_title));
        this.f461050l.setMaxLines(2);
        TextView r102 = this.f461050l;
        String r103 = this.f461054p;
        r102.setText(r103);
        int r104 = 8;
        if (TextUtils.isEmpty(r103) == false) goto L5;
        int r105 = 8;
    L6:
        r102.setVisibility(r105);
        ConstraintLayout.LayoutParams r106 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r106.topToTop = 0;
        r106.bottomToBottom = 0;
        r106.startToStart = 0;
        r106.endToStart = R.id.setting_item_right_drawable;
        r106.horizontalWeight = 1.0f;
        r106.horizontalChainStyle = 2;
        r100.addView(this.f461050l, r106);
        ImageView r107 = new ImageView(getContext());
        this.f461053o = r107;
        r107.setId(R.id.setting_item_right_drawable);
        ConstraintLayout.LayoutParams r108 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r108.topToTop = 0;
        r108.bottomToBottom = 0;
        r108.startToEnd = R.id.setting_item_left_text;
        r108.endToStart = R.id.setting_item_right_text;
        ImageView r109 = this.f461053o;
        Drawable r110 = this.f461057s;
        if (r110 != null) goto L9;
        int r111 = 8;
    L10:
        r109.setVisibility(r111);
        if (r110 == null) goto L13;
        r109.setImageDrawable(r110);
    L13:
        r100.addView(this.f461053o, r108);
        ImageView r112 = this.f461053o;
        Drawable r113 = this.f461057s;
        if (r113 != null) goto L16;
        int r114 = 8;
    L17:
        r112.setVisibility(r114);
        if (r113 == null) goto L20;
        r112.setImageDrawable(r113);
    L20:
        TextView r115 = new TextView(getContext());
        this.f461052n = r115;
        r115.setId(R.id.setting_item_right_text);
        this.f461052n.setTextSize(14);
        this.f461052n.setTextColor(getContext().getResources().getColorStateList(R.color.text_title));
        ConstraintLayout.LayoutParams r116 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r116.topToTop = 0;
        r116.bottomToBottom = 0;
        r116.startToEnd = R.id.setting_item_right_drawable;
        r116.endToStart = R.id.setting_item_right_icon;
        r100.addView(this.f461052n, r116);
        TextView r117 = this.f461052n;
        String r118 = this.f461056r;
        r117.setText(r118);
        if (TextUtils.isEmpty(r118) == false) goto L23;
        int r119 = 8;
    L24:
        r117.setVisibility(r119);
        ImageView r120 = new ImageView(getContext());
        this.f461051m = r120;
        r120.setId(R.id.setting_item_right_icon);
        this.f461051m.setImageTintList(getContext().getResources().getColorStateList(R.color.icon_n3));
        ConstraintLayout.LayoutParams r121 = b.b(16.0f, 16.0f, 0, 0, 16, 0);
        r121.topToTop = 0;
        r121.bottomToBottom = 0;
        r121.startToEnd = R.id.setting_item_right_text;
        r121.endToEnd = 0;
        r100.addView(this.f461051m, r121);
        ImageView r122 = this.f461051m;
        Drawable r123 = this.f461055q;
        if (r123 == null) goto L28;
        r104 = 0;
    L28:
        r122.setVisibility(r104);
        if (r123 == null) goto L31;
        r122.setImageDrawable(r123);
    L31:
        setupBackground(r100);
        r100.setClickable(true);
        r100.setOnClickListener(null);
        r210.addView(r100, new ConstraintLayout.LayoutParams(-1, UIHelper.dp2px(54)));
        return;
    L23:
        r119 = 0;
        goto L24
    L16:
        r114 = 0;
        goto L17
    L9:
        r111 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public IndicatorItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public final void R5(Context r100, AttributeSet r101) {
        super.R5(r100, r101);
        if (r101 == null) goto L6;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bottom_desc, R.attr.button_color, R.attr.button_text, R.attr.containerType, R.attr.divider_bottom_visible, R.attr.divider_top_visible, R.attr.end_indicator, R.attr.end_indicator_drawable, R.attr.end_indicator_text, R.attr.indicator_text, R.attr.margin_top, R.attr.upper_desc});
        this.f461054p = r102.getString(9);
        this.f461055q = r102.getDrawable(6);
        this.f461057s = r102.getDrawable(7);
        this.f461056r = r102.getString(8);
        r102.recycle();
        return;
    }

    public IndicatorItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        R5(r100, r101);
        S5(r100);
    }
}
