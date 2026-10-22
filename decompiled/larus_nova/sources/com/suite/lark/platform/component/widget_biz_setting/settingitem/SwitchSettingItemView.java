package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import xbc.b;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
public class SwitchSettingItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f461101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDSwitch f461102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f461103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f461104d;

    public UDSwitch getSwitchView() {
        return this.f461102b;
    }

    public SwitchSettingItemView(Context r100) {
        this(r100, null);
    }

    public void setTitle(String r100) {
        this.f461101a.setText(r100);
    }

    public SwitchSettingItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SwitchSettingItemView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f461104d = false;
        if (r111 == null) goto L5;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.setting_checked, R.attr.setting_title});
        this.f461103c = r113.getString(1);
        this.f461104d = r113.getBoolean(0, this.f461104d);
        r113.recycle();
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int r100 = d.b(r110, 16.0f);
        setPadding(0, r100, 0, r100);
        TextView r101 = new TextView(r110);
        this.f461101a = r101;
        r101.setTextSize(16.0f);
        this.f461101a.setTextColor(getContext().getResources().getColorStateList(R.color.text_title));
        this.f461101a.setMaxLines(3);
        this.f461101a.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r114 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r114.topToTop = 0;
        r114.bottomToBottom = 0;
        r114.startToStart = 0;
        r114.endToStart = R.id.setting_item_right_switch;
        addView(this.f461101a, r114);
        UDSwitch r115 = new UDSwitch(r110);
        this.f461102b = r115;
        r115.setId(R.id.setting_item_right_switch);
        this.f461102b.setGravity(17);
        ConstraintLayout.LayoutParams r116 = b.b(-2.0f, -1.0f, 0, 0, 16, 0);
        r116.topToTop = 0;
        r116.bottomToBottom = 0;
        r116.endToEnd = 0;
        addView(this.f461102b, r116);
        setTitle(this.f461103c);
        this.f461102b.setChecked(this.f461104d);
        this.f461102b.setOnCheckedChangeListener(null);
    }
}
