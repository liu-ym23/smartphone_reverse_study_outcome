package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class ButtonItemView extends BaseItemView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f461043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f461044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f461045n;

    public ButtonItemView(Context r100) {
        this(r100, null);
    }

    public void setEnable(boolean r100) {
        this.f461043l.setEnabled(r100);
    }

    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public void setupContainer(FrameLayout r100) {
        TextView r101 = new TextView(getContext());
        this.f461043l = r101;
        r101.setId(R.id.setting_item_button);
        this.f461043l.setTextSize(16);
        this.f461043l.setTextColor(this.f461045n);
        this.f461043l.setMaxLines(1);
        this.f461043l.setText(this.f461044m);
        this.f461043l.setGravity(17);
        setupBackground(this.f461043l);
        this.f461043l.setOnClickListener(null);
        r100.addView(this.f461043l, new FrameLayout.LayoutParams(-1, UIHelper.dp2px(54)));
    }

    public ButtonItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public final void R5(Context r100, AttributeSet r101) {
        super.R5(r100, r101);
        if (r101 == null) goto L6;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bottom_desc, R.attr.button_color, R.attr.button_text, R.attr.containerType, R.attr.divider_bottom_visible, R.attr.divider_top_visible, R.attr.end_indicator, R.attr.end_indicator_drawable, R.attr.end_indicator_text, R.attr.indicator_text, R.attr.margin_top, R.attr.upper_desc});
        this.f461044m = r102.getString(2);
        this.f461045n = r102.getColor(1, getResources().getColor(R.color.text_title));
        r102.recycle();
        return;
    }

    public ButtonItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        R5(r100, r101);
        S5(r100);
    }
}
