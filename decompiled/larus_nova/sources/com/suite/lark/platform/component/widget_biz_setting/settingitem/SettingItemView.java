package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes36.dex */
public class SettingItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f461064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f461065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f461066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f461067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f461068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f461069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f461070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f461071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f461072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f461073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f461074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f461075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f461076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f461077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f461078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f461079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f461080q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f461081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f461082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f461083t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f461084u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f461085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f f461086w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f f461087x;

    public static final enum ContainerType extends Enum<ContainerType> {
        public static final ContainerType CUSTOM = null;
        public static final ContainerType ICON_BTN = null;
        public static final ContainerType RADIO_BTN = null;
        public static final ContainerType SWITCH_BTN = null;
        public static final ContainerType TEXT_ICON_BTN = null;
        public static final ContainerType THROTTLE_CHECKBOX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContainerType[] f461088a = null;
        final int type;

        static {
            ContainerType r100 = new ContainerType("ICON_BTN", 0, 0);
            ICON_BTN = r100;
            ContainerType r101 = new ContainerType("SWITCH_BTN", 1, 1);
            SWITCH_BTN = r101;
            ContainerType r102 = new ContainerType("RADIO_BTN", 2, 2);
            RADIO_BTN = r102;
            ContainerType r103 = new ContainerType("CUSTOM", 3, 3);
            CUSTOM = r103;
            ContainerType r104 = new ContainerType("TEXT_ICON_BTN", 4, 4);
            TEXT_ICON_BTN = r104;
            ContainerType r105 = new ContainerType("THROTTLE_CHECKBOX", 5, 5);
            THROTTLE_CHECKBOX = r105;
            f461088a = new ContainerType[]{r100, r101, r102, r103, r104, r105};
        }

        public static ContainerType[] values() {
            return (ContainerType[]) f461088a.clone();
        }

        public static ContainerType valueOf(String r100) {
            return (ContainerType) r27.a.a(ContainerType.class, r100);
        }

        public ContainerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final enum Event extends Enum<Event> {
        public static final Event GetCheckBox = null;
        public static final Event GetRadioBtn = null;
        public static final Event GetSwitchBtn = null;
        public static final Event SetEnable = null;
        public static final Event SetText = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f461089a = null;

        static {
            Event r100 = new Event("SetText", 0);
            SetText = r100;
            Event r101 = new Event("SetEnable", 1);
            SetEnable = r101;
            Event r102 = new Event("GetSwitchBtn", 2);
            GetSwitchBtn = r102;
            Event r103 = new Event("GetCheckBox", 3);
            GetCheckBox = r103;
            Event r104 = new Event("GetRadioBtn", 4);
            GetRadioBtn = r104;
            f461089a = new Event[]{r100, r101, r102, r103, r104};
        }

        public static Event[] values() {
            return (Event[]) f461089a.clone();
        }

        public static Event valueOf(String r100) {
            return (Event) r27.a.a(Event.class, r100);
        }

        public Event(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDSwitch f461090a;

        public a(UDSwitch r100) {
            this.f461090a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            UDSwitch r101 = this.f461090a;
            r101.setChecked(!r101.isChecked());
        }
    }

    public class b extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDCheckBox f461091a;

        public b(UDCheckBox r100) {
            this.f461091a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            UDCheckBox r101 = this.f461091a;
            r101.setChecked(!r101.isChecked());
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUICheckBox f461092a;

        public c(ThrottleCheckBox r100) {
            this.f461092a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LKUICheckBox r101 = this.f461092a;
            r101.setChecked(!r101.isChecked());
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f461093a = null;

        static {
            int[] r100 = new int[Event.values().length];
            f461093a = r100;
            r100[Event.GetRadioBtn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f461093a[Event.SetEnable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f461093a[Event.SetText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class e extends Application {
        public e(Context r100) {
            attachBaseContext(r100);
        }
    }

    public interface f {
        Object a(Event r100, Object r101);
    }

    public static class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f461094a;

        public g(ImageView r100) {
            this.f461094a = r100;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r100, Object r101) {
            if (r100 == Event.SetEnable) goto L5;
            return null;
        L5:
            if ((r101 instanceof Boolean) == false) goto L10;
            this.f461094a.setEnabled(((Boolean) r101).booleanValue());
            return null;
        L10:
            return null;
        }
    }

    public static class h implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDCheckBox f461095a;

        public h(UDCheckBox r100) {
            this.f461095a = r100;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r100, Object r101) {
            int r102 = d.f461093a[r100.ordinal()];
            if (r102 == 1) goto L13;
            if (r102 == 2) goto L8;
            return null;
        L8:
            if ((r101 instanceof Boolean) == false) goto L14;
            this.f461095a.setEnabled(((Boolean) r101).booleanValue());
            return null;
        L14:
            return null;
        L13:
            return this.f461095a;
        }
    }

    public static class i implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDSwitch f461096a;

        public i(UDSwitch r100) {
            this.f461096a = r100;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r100, Object r101) {
            if (r100 != Event.SetEnable) goto L8;
            if ((r101 instanceof Boolean) == false) goto L8;
            this.f461096a.setEnabled(((Boolean) r101).booleanValue());
            return null;
        L8:
            if (r100 == Event.GetSwitchBtn) goto L10;
            return null;
        L10:
            return this.f461096a;
        }
    }

    public static class j implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f461097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f461098b;

        public j(TextView r100, ImageView r101) {
            this.f461097a = r100;
            this.f461098b = r101;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r100, Object r101) {
            int r102 = d.f461093a[r100.ordinal()];
            if (r102 == 2) goto L11;
            if (r102 == 3) goto L8;
            return null;
        L8:
            if ((r101 instanceof String) == false) goto L15;
            this.f461097a.setText((String) r101);
            return null;
        L15:
            return null;
        L11:
            if ((r101 instanceof Boolean) == false) goto L17;
            Boolean r103 = (Boolean) r101;
            this.f461097a.setEnabled(r103.booleanValue());
            this.f461098b.setEnabled(r103.booleanValue());
            return null;
        L17:
            return null;
        }
    }

    public static class k implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LKUICheckBox f461099a;

        public k(ThrottleCheckBox r100) {
            this.f461099a = r100;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r100, Object r101) {
            if (r100 != Event.GetCheckBox) goto L7;
            return this.f461099a;
        L7:
            if (r100 == Event.SetEnable) goto L9;
            return null;
        L9:
            if ((r101 instanceof Boolean) == false) goto L14;
            this.f461099a.setEnabled(((Boolean) r101).booleanValue());
            return null;
        L14:
            return null;
        }
    }

    public LKUICheckBox getLeftCheckBox() {
        f r100 = this.f461086w;
        if (r100 == null) goto L8;
        Object r101 = r100.a(Event.GetCheckBox, null);
        if ((r101 instanceof LKUICheckBox) == false) goto L8;
        return (LKUICheckBox) r101;
    L8:
        return null;
    }

    public UDCheckBox getLeftRadioButton() {
        f r100 = this.f461086w;
        if (r100 == null) goto L8;
        Object r101 = r100.a(Event.GetRadioBtn, null);
        if ((r101 instanceof UDCheckBox) == false) goto L8;
        return (UDCheckBox) r101;
    L8:
        return null;
    }

    public UDSwitch getRightSwitch() {
        f r100 = this.f461087x;
        if (r100 == null) goto L8;
        Object r101 = r100.a(Event.GetSwitchBtn, null);
        if ((r101 instanceof UDSwitch) == false) goto L8;
        return (UDSwitch) r101;
    L8:
        return null;
    }

    public SettingItemView(Context r100) {
        this(r100, null);
    }

    public void setDescription(String r100) {
        this.f461065b.setText(r100);
        TextView r101 = this.f461065b;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        TextView r101 = this.f461064a;
        if (r101 == null) goto L5;
        r101.setEnabled(r100);
    L5:
        TextView r102 = this.f461065b;
        if (r102 == null) goto L8;
        r102.setEnabled(r100);
    L8:
        f r103 = this.f461087x;
        if (r103 == null) goto L11;
        r103.a(Event.SetEnable, Boolean.valueOf(r100));
    L11:
        f r104 = this.f461086w;
        if (r104 == null) goto L15;
        r104.a(Event.SetEnable, Boolean.valueOf(r100));
        return;
    }

    public void setRightText(String r100) {
        f r101 = this.f461087x;
        if (r101 == null) goto L6;
        r101.a(Event.SetText, r100);
        return;
    }

    public void setTitle(String r100) {
        this.f461064a.setText(r100);
        TextView r101 = this.f461064a;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public SettingItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SettingItemView(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        this.f461080q = true;
        this.f461081r = false;
        int r100 = -1;
        int r101 = 8;
        if (r211 == null) goto L9;
        TypedArray r102 = r210.obtainStyledAttributes(r211, new int[]{R.attr.bottom_divider_start_margin, R.attr.bottom_divider_visible, R.attr.description, R.attr.leftType, R.attr.left_icon, R.attr.left_layout, R.attr.left_text, R.attr.limit_title_lines, R.attr.margin_left_layout_top, R.attr.rightType, R.attr.right_icon, R.attr.right_icon_tint, R.attr.right_layout, R.attr.right_text, R.attr.setting_background, R.attr.title, R.attr.top_divider_start_margin, R.attr.top_divider_visible});
        this.f461070g = r102.getString(15);
        this.f461071h = r102.getString(2);
        this.f461072i = r102.getString(13);
        this.f461073j = r102.getInteger(9, 0);
        this.f461074k = r102.getDrawable(10);
        this.f461075l = r102.getColorStateList(11);
        this.f461083t = r102.getString(6);
        this.f461084u = r102.getInteger(3, -1);
        this.f461085v = r102.getDrawable(4);
        this.f461076m = r102.getBoolean(17, false);
        this.f461078o = r102.getDimensionPixelSize(16, 0);
        this.f461077n = r102.getBoolean(1, false);
        this.f461079p = r102.getDimensionPixelSize(0, 0);
        this.f461080q = r102.getBoolean(7, this.f461080q);
        this.f461081r = r102.getBoolean(8, this.f461081r);
        Drawable r110 = r102.getDrawable(14);
        this.f461082s = r110;
        if (r110 != null) goto L7;
        this.f461082s = y9c.d.e(r210, R.drawable.item_bg_selector_c11);
    L7:
        r102.recycle();
    L9:
        if (isInEditMode() == false) goto L11;
        LarkContext.setApplication(new e(getContext().getApplicationContext()));
    L11:
        RelativeLayout r103 = new RelativeLayout(r210);
        this.f461067d = r103;
        r103.setId(R.id.left_custom_fl);
        ConstraintLayout.LayoutParams r104 = xbc.b.b(-2.0f, -2.0f, 16, 0, 0, 0);
        boolean r111 = this.f461081r;
        if (r111 == false) goto L14;
        r104.topToTop = R.id.setting_name_tv;
    L15:
        if (r111 == true) goto L18;
        r100 = 0;
    L18:
        r104.bottomToBottom = r100;
        r104.startToStart = 0;
        r104.leftToLeft = 0;
        r104.goneLeftMargin = 0;
        addView(this.f461067d, r104);
        TextView r105 = new TextView(r210);
        this.f461064a = r105;
        r105.setId(R.id.setting_name_tv);
        this.f461064a.setTextSize(16);
        this.f461064a.setTextColor(r210.getResources().getColorStateList(R.color.setting_item_title_text_color));
        TextView r106 = this.f461064a;
        if (this.f461080q == false) goto L21;
        int r107 = 2;
    L22:
        r106.setMaxLines(r107);
        setTitle(this.f461070g);
        ConstraintLayout.LayoutParams r108 = xbc.b.b(0.0f, -2.0f, 16, 16, 5, 0);
        r108.goneBottomMargin = UIUtils.dp2px(r210, 16.0f);
        r108.goneEndMargin = UIUtils.dp2px(r210, 16.0f);
        r108.topToTop = 0;
        r108.bottomToTop = R.id.setting_desc_tv;
        r108.startToEnd = R.id.left_custom_fl;
        r108.endToStart = R.id.right_custom_fl;
        r108.verticalChainStyle = 2;
        addView(this.f461064a, r108);
        TextView r109 = new TextView(r210);
        this.f461065b = r109;
        r109.setId(R.id.setting_desc_tv);
        this.f461065b.setTextSize(14);
        this.f461065b.setTextColor(y9c.d.c(r210, R.color.text_placeholder));
        this.f461065b.setMaxLines(2);
        this.f461065b.setEllipsize(TextUtils.TruncateAt.END);
        setDescription(this.f461071h);
        ConstraintLayout.LayoutParams r112 = xbc.b.b(0.0f, -2.0f, 0, 4, 0, 16);
        r112.topToBottom = R.id.setting_name_tv;
        r112.bottomToBottom = 0;
        r112.startToStart = R.id.setting_name_tv;
        r112.endToEnd = R.id.setting_name_tv;
        addView(this.f461065b, r112);
        RelativeLayout r113 = new RelativeLayout(r210);
        this.f461066c = r113;
        r113.setId(R.id.right_custom_fl);
        ConstraintLayout.LayoutParams r114 = xbc.b.b(-2.0f, -2.0f, 0, 0, 16, 0);
        r114.topToTop = 0;
        r114.bottomToBottom = 0;
        r114.endToEnd = 0;
        addView(this.f461066c, r114);
        View r115 = new View(r210);
        this.f461068e = r115;
        r115.setId(R.id.top_divider);
        this.f461068e.setBackgroundColor(UIUtils.getColor(r210, R.color.line_divider_default));
        View r116 = this.f461068e;
        if (this.f461076m == false) goto L25;
        int r117 = 0;
    L26:
        r116.setVisibility(r117);
        ConstraintLayout.LayoutParams r118 = xbc.b.b(0.0f, 0.5f, this.f461078o, 0, 0, 0);
        r118.topToTop = 0;
        r118.startToStart = 0;
        r118.endToEnd = 0;
        addView(this.f461068e, r118);
        View r119 = new View(r210);
        this.f461069f = r119;
        r119.setId(R.id.bottom_divider);
        this.f461069f.setBackgroundColor(UIUtils.getColor(r210, R.color.line_divider_default));
        View r120 = this.f461069f;
        if (this.f461077n == false) goto L29;
        r101 = 0;
    L29:
        r120.setVisibility(r101);
        ConstraintLayout.LayoutParams r121 = xbc.b.b(0.0f, 0.5f, this.f461079p, 0, 0, 0);
        r121.bottomToBottom = 0;
        r121.startToStart = 0;
        r121.endToEnd = 0;
        addView(this.f461069f, r121);
        setBackground(this.f461082s);
        setClickable(true);
        this.f461086w = R5(r210, this.f461067d, this.f461084u, this.f461085v, this.f461083t);
        ColorStateList r122 = this.f461075l;
        if (r122 == null) goto L32;
        this.f461074k.setTintList(r122);
        this.f461074k.setTintMode(PorterDuff.Mode.SRC_ATOP);
    L32:
        this.f461087x = R5(r210, this.f461066c, this.f461073j, this.f461074k, this.f461072i);
        return;
    L25:
        r117 = 8;
        goto L26
    L21:
        r107 = Integer.MAX_VALUE;
        goto L22
    L14:
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        goto L15
    }

    public final f R5(Context r100, RelativeLayout r101, int r102, Drawable r103, String r104) {
        if (r102 != ContainerType.ICON_BTN.type) goto L6;
        ImageView r105 = new ImageView(r100);
        r105.setImageDrawable(r103);
        r105.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams r106 = xbc.b.d(16.0f, 16.0f);
        f r107 = new g(r105);
        View r108 = r105;
    L20:
        if (r108 == null) goto L25;
        if (r106 == null) goto L23;
        r101.addView(r108, r106);
    L24:
        r101.setVisibility(0);
    L26:
        return r107;
    L23:
        r101.addView(r108);
        goto L24
    L25:
        r101.setVisibility(8);
        goto L26
    L6:
        if (r102 != ContainerType.SWITCH_BTN.type) goto L9;
        View r109 = LayoutInflater.from(r100).inflate(R.layout.setting_item_item_switch_btn, null);
        UDSwitch r110 = (UDSwitch) r109.findViewById(R.id.setting_item_switch_btn);
        setOnClickListener(new a(r110));
        r107 = new i(r110);
        View r111 = r109;
    L18:
        r106 = null;
        r108 = r111;
        goto L20
    L9:
        if (r102 != ContainerType.RADIO_BTN.type) goto L13;
        UDCheckBox r112 = new UDCheckBox(r100);
        r112.setType(UDCheckBox.CheckBoxType.RADIO);
        r112.setPadding(0, 0, 0, 0);
        setOnClickListener(new b(r112));
        f r113 = new h(r112);
        View r114 = r112;
    L11:
        r107 = r113;
        r111 = r114;
        goto L18
    L13:
        if (r102 != ContainerType.TEXT_ICON_BTN.type) goto L16;
        LinearLayout r115 = new LinearLayout(r100);
        r115.setOrientation(0);
        TextView r116 = new TextView(r100);
        r116.setText(r104);
        r116.setTextSize(14.0f);
        r116.setTextColor(y9c.d.c(r100, R.color.text_placeholder));
        r115.addView(r116, xbc.b.c(-2, 16, 0, 12));
        ImageView r117 = new ImageView(r100);
        r117.setImageDrawable(r103);
        r117.setScaleType(ImageView.ScaleType.FIT_XY);
        float r118 = 16;
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(xbc.b.e(r118), xbc.b.e(r118));
        r119.gravity = 16;
        r115.addView(r117, r119);
        r106 = xbc.b.d(-2.0f, -2.0f);
        r107 = new j(r116, r117);
        r108 = r115;
        goto L20
    L16:
        if (r102 != ContainerType.THROTTLE_CHECKBOX.type) goto L19;
        ThrottleCheckBox r120 = new ThrottleCheckBox(r100);
        View.OnClickListener r121 = new c(r120);
        r120.setClickable(false);
        setOnClickListener(r121);
        r101.setOnClickListener(r121);
        r113 = new k(r120);
        r114 = r120;
        goto L11
    L19:
        r106 = null;
        r108 = null;
        r107 = null;
        goto L20
    }
}
