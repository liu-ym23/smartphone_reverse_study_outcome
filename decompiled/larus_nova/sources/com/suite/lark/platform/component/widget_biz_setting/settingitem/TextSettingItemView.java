package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import xbc.b;

/* JADX INFO: loaded from: classes36.dex */
public class TextSettingItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f461105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f461106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f461107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f461108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f461109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f461110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f461111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f461112h;

    public TextSettingItemView(Context r100) {
        this(r100, null);
    }

    public void setRightText(String r100) {
        R5(this.f461107c, r100);
    }

    public void setTitle(String r100) {
        R5(this.f461105a, r100);
    }

    public TextSettingItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void R5(TextView r100, String r101) {
        r100.setText(r101);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        int r102 = 8;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public TextSettingItemView(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        int r100 = 8;
        if (r211 == null) goto L5;
        TypedArray r101 = r210.obtainStyledAttributes(r211, new int[]{R.attr.bottom_desc, R.attr.button_color, R.attr.button_text, R.attr.containerType, R.attr.divider_bottom_visible, R.attr.divider_top_visible, R.attr.end_indicator, R.attr.end_indicator_drawable, R.attr.end_indicator_text, R.attr.indicator_text, R.attr.margin_top, R.attr.upper_desc});
        this.f461109e = r101.getString(9);
        this.f461110f = r101.getDrawable(6);
        this.f461112h = r101.getDrawable(7);
        this.f461111g = r101.getString(8);
        r101.recycle();
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(UIHelper.dp2px(54.0f));
        TextView r102 = new TextView(getContext());
        this.f461105a = r102;
        r102.setId(R.id.setting_item_left_text);
        this.f461105a.setTextSize(16);
        this.f461105a.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        this.f461105a.setMaxLines(2);
        this.f461105a.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r103 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r103.topToTop = 0;
        r103.bottomToBottom = 0;
        r103.startToStart = 0;
        r103.endToStart = R.id.setting_item_right_drawable;
        r103.horizontalWeight = 1.0f;
        r103.horizontalChainStyle = 2;
        addView(this.f461105a, r103);
        ImageView r104 = new ImageView(getContext());
        this.f461108d = r104;
        r104.setId(R.id.setting_item_right_drawable);
        ConstraintLayout.LayoutParams r110 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r110.topToTop = 0;
        r110.bottomToBottom = 0;
        r110.startToEnd = R.id.setting_item_left_text;
        r110.endToStart = R.id.setting_item_right_text;
        addView(this.f461108d, r110);
        TextView r111 = new TextView(getContext());
        this.f461107c = r111;
        r111.setMaxWidth(UIHelper.dp2px(120.0f));
        this.f461107c.setId(R.id.setting_item_right_text);
        this.f461107c.setTextSize(14);
        this.f461107c.setTextColor(getContext().getResources().getColorStateList(R.color.text_placeholder));
        this.f461107c.setLines(1);
        this.f461107c.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r105 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        r105.startToEnd = R.id.setting_item_right_drawable;
        r105.endToStart = R.id.setting_item_right_icon;
        addView(this.f461107c, r105);
        ImageView r106 = new ImageView(getContext());
        this.f461106b = r106;
        r106.setId(R.id.setting_item_right_icon);
        this.f461106b.setImageTintList(getContext().getResources().getColorStateList(R.color.icon_n3));
        ConstraintLayout.LayoutParams r107 = b.b(16.0f, 16.0f, 0, 0, 16, 0);
        r107.topToTop = 0;
        r107.bottomToBottom = 0;
        r107.startToEnd = R.id.setting_item_right_text;
        r107.endToEnd = 0;
        addView(this.f461106b, r107);
        R5(this.f461105a, this.f461109e);
        ImageView r108 = this.f461108d;
        Drawable r109 = this.f461112h;
        if (r109 != null) goto L8;
        int r112 = 8;
    L9:
        r108.setVisibility(r112);
        if (r109 == null) goto L12;
        r108.setImageDrawable(r109);
    L12:
        ImageView r113 = this.f461108d;
        Drawable r114 = this.f461112h;
        if (r114 != null) goto L15;
        int r115 = 8;
    L16:
        r113.setVisibility(r115);
        if (r114 == null) goto L19;
        r113.setImageDrawable(r114);
    L19:
        R5(this.f461107c, this.f461111g);
        ImageView r116 = this.f461106b;
        Drawable r117 = this.f461110f;
        if (r117 == null) goto L23;
        r100 = 0;
    L23:
        r116.setVisibility(r100);
        if (r117 == null) goto L26;
        r116.setImageDrawable(r117);
    L26:
        setOnClickListener(null);
        return;
    L15:
        r115 = 0;
        goto L16
    L8:
        r112 = 0;
        goto L9
    }
}
