package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import xbc.b;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BaseItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f461032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f461033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f461034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SettingDividerView f461035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SettingDividerView f461036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f461037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f461038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f461039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f461040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f461041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f461042k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemType {
        public static final int BUTTON = 4;
        public static final int CUSTOM = 0;
        public static final int DIVIDER = 3;
        public static final int INDICATOR = 1;
        public static final int SWITCHER = 2;
    }

    public abstract void setupContainer(FrameLayout r100);

    public BaseItemView(Context r100) {
        this(r100, null);
    }

    private void setBottomDesc(String r100) {
        this.f461038g = r100;
        this.f461033b.setText(r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f461033b.setVisibility(8);
        return;
    L5:
        this.f461033b.setVisibility(0);
    }

    private void setUpperDesc(String r100) {
        this.f461037f = r100;
        this.f461032a.setText(r100);
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) this.f461035d.getLayoutParams();
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) this.f461034c.getLayoutParams();
        if (TextUtils.isEmpty(r100) == false) goto L12;
        this.f461032a.setVisibility(8);
        SettingDividerView r103 = this.f461035d;
        if (this.f461041j <= 0) goto L7;
        float r104 = 0.0f;
    L8:
        r103.setLeftBlankWidth(r104);
        if (this.f461035d.getVisibility() == 8) goto L11;
        r101.setMargins(0, UIHelper.dp2px(this.f461041j), 0, 0);
        return;
    L11:
        r102.setMargins(0, UIHelper.dp2px(this.f461041j), 0, 0);
        return;
    L7:
        r104 = UIHelper.dp2px(16.0f);
        goto L8
    L12:
        this.f461032a.setVisibility(0);
        if (this.f461035d.getVisibility() == 8) goto L15;
        r101.setMargins(0, UIHelper.dp2px(this.f461041j), 0, 0);
        return;
    L15:
        r102.setMargins(0, UIHelper.dp2px(this.f461041j), 0, 0);
    }

    public final void S5(Context r210) {
        int r100 = d.b(r210, 16.0f);
        setPadding(r100, 0, r100, 0);
        TextView r101 = new TextView(r210);
        this.f461032a = r101;
        r101.setId(R.id.setting_item_top_desc);
        this.f461032a.setMaxLines(1);
        float r102 = 14;
        this.f461032a.setTextSize(r102);
        this.f461032a.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        ConstraintLayout.LayoutParams r103 = b.b(-1.0f, -2.0f, 16, this.f461041j, 16, 2);
        r103.topToTop = 0;
        r103.startToStart = 0;
        r103.endToEnd = 0;
        r103.bottomToTop = R.id.setting_item_top_divider;
        r103.verticalChainStyle = 2;
        addView(this.f461032a, r103);
        SettingDividerView r104 = new SettingDividerView(r210);
        this.f461035d = r104;
        r104.setId(R.id.setting_item_top_divider);
        SettingDividerView r105 = this.f461035d;
        int r110 = 8;
        if (this.f461039h == false) goto L5;
        int r106 = 0;
    L6:
        r105.setVisibility(r106);
        ConstraintLayout.LayoutParams r111 = b.b(0.0f, 0.5f, 0, 0, 0, 0);
        r111.topToBottom = R.id.setting_item_top_desc;
        r111.bottomToTop = R.id.setting_item_container;
        r111.startToStart = 0;
        r111.endToEnd = 0;
        addView(this.f461035d, r111);
        FrameLayout r112 = new FrameLayout(r210);
        this.f461034c = r112;
        r112.setId(R.id.setting_item_container);
        ConstraintLayout.LayoutParams r107 = b.b(-1.0f, -2.0f, 0, 0, 0, 0);
        r107.topToBottom = R.id.setting_item_top_divider;
        r107.startToStart = 0;
        r107.endToEnd = 0;
        r107.bottomToTop = R.id.setting_item_bottom_divider;
        addView(this.f461034c, r107);
        setupContainer(this.f461034c);
        TextView r108 = new TextView(r210);
        this.f461033b = r108;
        r108.setId(R.id.setting_item_bottom_desc);
        this.f461033b.setTextSize(r102);
        this.f461033b.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        ConstraintLayout.LayoutParams r109 = b.b(-1.0f, -2.0f, 16, 2, 16, 0);
        r109.bottomToBottom = 0;
        r109.startToStart = 0;
        r109.topToBottom = R.id.setting_item_bottom_divider;
        r109.endToEnd = 0;
        addView(this.f461033b, r109);
        SettingDividerView r113 = new SettingDividerView(r210);
        this.f461036e = r113;
        r113.setId(R.id.setting_item_bottom_divider);
        SettingDividerView r114 = this.f461036e;
        if (this.f461040i == false) goto L9;
        r110 = 0;
    L9:
        r114.setVisibility(r110);
        ConstraintLayout.LayoutParams r115 = b.b(0.0f, 0.5f, 0, 0, 0, 0);
        r115.topToBottom = R.id.setting_item_container;
        r115.bottomToTop = R.id.setting_item_bottom_desc;
        r115.startToStart = 0;
        r115.endToEnd = 0;
        addView(this.f461036e, r115);
        setUpperDesc(this.f461037f);
        setBottomDesc(this.f461038g);
        setClickable(true);
        return;
    L5:
        r106 = 8;
        goto L6
    }

    public void setupBackground(View r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setColor(UIUtils.getColorStateList(getContext(), R.color.bg_color_setting_item));
        r100.setBackground(r101);
        this.f461042k = r100;
    }

    public BaseItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void R5(Context r100, AttributeSet r101) {
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bottom_desc, R.attr.button_color, R.attr.button_text, R.attr.containerType, R.attr.divider_bottom_visible, R.attr.divider_top_visible, R.attr.end_indicator, R.attr.end_indicator_drawable, R.attr.end_indicator_text, R.attr.indicator_text, R.attr.margin_top, R.attr.upper_desc});
        this.f461037f = r102.getString(11);
        this.f461038g = r102.getString(0);
        r102.getInteger(3, 0);
        this.f461039h = r102.getBoolean(5, false);
        this.f461041j = r102.getDimensionPixelSize(10, 0);
        this.f461040i = r102.getBoolean(4, false);
        r102.recycle();
        return;
    }

    public BaseItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
